package com.persistent.aicrew.service;

import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.security.IamToken;
import com.ibm.watson.discovery.v2.Discovery;
import com.persistent.aicrew.dao.entity.Claim;
import com.persistent.aicrew.dao.entity.Underwriting;
import com.persistent.aicrew.repository.UnderwritingsRepository;
import okhttp3.Headers;
import okhttp3.Request;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
public class UnderwritingService {
    @Autowired
    private UnderwritingsRepository underwritingsRepository;

//    private IamAuthenticator authenticator;
//
//    public UnderwritingService(IamAuthenticator authenticator) {
//        this.authenticator = authenticator;
//    }

    public List<Underwriting> fetchAllunderwritings() throws Exception {
        List<Underwriting> result = new ArrayList<Underwriting>();
        underwritingsRepository.findAll().forEach(result::add);;

        for(Underwriting underwriting: result){
            underwriting.setRiskMeter(processRiskMeter(underwriting));
        }
        return result;
    }

    public String processRiskMeter(Underwriting underwriting) throws Exception {

        // Load api key property from application.properties
        Properties properties = new Properties();
        try (InputStream input = UnderwritingService.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find application.properties");
                return null;
            }
            properties.load(input);
        }
        String apiKey = properties.getProperty("api.key");

        // request to get the access token
        String tokenEndpoint = "https://iam.cloud.ibm.com/identity/token";

        String requestTokenBody = "grant_type=urn:ibm:params:oauth:grant-type:apikey&apikey=" + apiKey;

        // Build the HTTP request
        HttpClient clientToken = HttpClient.newHttpClient();
        HttpRequest requestToken = HttpRequest.newBuilder()
                .uri(URI.create(tokenEndpoint))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(requestTokenBody))
                .build();

        // Send the request and handle the response
        HttpResponse<String> expectedResponse = clientToken.send(requestToken, HttpResponse.BodyHandlers.ofString());

        JSONObject jsonTokenResponse = new JSONObject(expectedResponse.body());
        String accessToken = jsonTokenResponse.getString("access_token");

        Integer age = underwriting.getAge(); ;
        String gender=underwriting.getGender();
        Long bmi=underwriting.getBmi();
        String medical_history=underwriting.getMedicalHistory();

        String input= String.format("%d years, %s, %s, BMI %d", age, gender, medical_history, bmi);

        // set the request
        String url = "https://us-south.ml.cloud.ibm.com/ml/v1-beta/generation/text?version=2023-05-29";

        String requestBody = "{\n" +
                "    \"input\": \"Classify if the person is a High, Medium and Low Risk\\n\\nInput: \\n\\n45 years, Male, In good health, BMI 24\\nOutput: Low Risk\\n\\nInput: 25 years, Male, Smoker, In good health, BMI 24\\n\\n\\nOutput: Medium Risk\\n\\nInput: 25 years, Male, Smoker, In good health, BMI 26\\n\\nOutput: Medium Risk\\n\\nInput: 47 years, Male, Smoker, BMI 27\\nOutput: High Risk\\n\\nInput: "+input+"\\nOutput:\",\n" +
                "    \"parameters\": {\n" +
                "        \"decoding_method\": \"greedy\",\n" +
                "        \"max_new_tokens\": 20,\n" +
                "        \"min_new_tokens\": 0,\n" +
                "        \"stop_sequences\": [],\n" +
                "        \"repetition_penalty\": 1\n" +
                "    },\n" +
                "    \"model_id\": \"google/flan-ul2\",\n" +
                "    \"project_id\": \"09d4b701-5c6c-41c8-b796-a530f758b25e\"\n" +
                "}";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + accessToken)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new Exception("Non-200 response: " + response.body());
        }

        // Process responseData as needed
        JSONObject jsonResponse = new JSONObject(response.body());
        JSONArray resultsArray = jsonResponse.getJSONArray("results");
        JSONObject resultObject = resultsArray.getJSONObject(0);
        String generatedText = resultObject.getString("generated_text");

        // underwriting.setRiskMeter(generatedText.replace("Risk","").trim());
        return generatedText.replace("Risk","").trim();
    }

//    public List<Underwriting> addUnderwriting(Underwriting underwriting) throws Exception {
////        IamToken token = authenticator.requestToken();
////        System.out.println(token.getAccessToken());
//
//
////        underwriting.setRiskMeter(riskMeter);
////
////        underwritingsRepository.save(underwriting);
//        return null;
//    }
}
