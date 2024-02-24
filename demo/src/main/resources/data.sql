INSERT INTO Claim (id, hospital, patient_name, claim_summary, claim_description) VALUES (1, 'Apollo Hospital', 'Govind Sharma', 'Diagnostic Services', 'X-ray, chest, single view MRI, CT Scan, abdomen and pelvis');
INSERT INTO Claim (id, hospital, patient_name, claim_summary, claim_description) VALUES (2, 'Tata Memorial Hospital', 'Shweta Singh', 'Diagnostic Services', 'X-ray, chest, single view MRI, CT Scan, abdomen and pelvis');
INSERT INTO Claim (id, hospital, patient_name, claim_summary, claim_description) VALUES (3, 'Apollo Hospital', 'Sameer Kumar', 'Diagnostic Services', 'X-ray, chest, single view MRI, CT Scan, abdomen and pelvis');
INSERT INTO Claim (id, hospital, patient_name, claim_summary, claim_description) VALUES (4, 'Nanavati Hospital', 'Raj Khosla', 'Diagnostic Services', 'X-ray, chest, single view MRI, CT Scan, abdomen and pelvis');
INSERT INTO Claim (id, hospital, patient_name, claim_summary, claim_description) VALUES (5, 'Breach Candy Hospital Trust', 'Manu Sharma', 'Diagnostic Services', 'X-ray, chest, single view MRI, CT Scan, abdomen and pelvis');

INSERT INTO Underwriting (id, age, gender, bmi, occupation, medical_history, risk_meter, rate_meter, approved) VALUES (1, 30, 'Male', 25.5, 'Engineer', 'No issues', 80, 0.03, true);
INSERT INTO Underwriting (id, age, gender, bmi, occupation, medical_history, risk_meter, rate_meter, approved) VALUES (2, 25, 'Female', 22.0, 'Doctor', 'Allergic to pollen', 75, 0.02, true);
INSERT INTO Underwriting (id, age, gender, bmi, occupation, medical_history, risk_meter, rate_meter, approved) VALUES (3, 35, 'Male', 28.3, 'Teacher', 'Hypertension', 90, 0.04, false);
INSERT INTO Underwriting (id, age, gender, bmi, occupation, medical_history, risk_meter, rate_meter, approved) VALUES (4, 28, 'Female', 26.8, 'Software Developer', 'No issues', 85, 0.035, true);
INSERT INTO Underwriting (id, age, gender, bmi, occupation, medical_history, risk_meter, rate_meter, approved) VALUES (5, 40, 'Male', 30.1, 'Nurse', 'Diabetes', 95, 0.05, false);

Insert INTO Bill (claim_id, bill_id, bill_date, bill_description, bill_amount) values (1, 1, '2023-01-02', 'Consultation charges', 200 );
Insert INTO Bill (claim_id, bill_id, bill_date, bill_description, bill_amount) values (1, 2, '2023-01-02', 'ECG charges', 200 );