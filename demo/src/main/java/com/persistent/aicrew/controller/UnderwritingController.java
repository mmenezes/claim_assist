package com.persistent.aicrew.controller;

import com.ibm.watson.discovery.v2.Discovery;
import com.persistent.aicrew.dao.entity.Underwriting;
import com.persistent.aicrew.service.UnderwritingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ibm.cloud.sdk.core.security.IamAuthenticator;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/sample")
public class UnderwritingController {
    // Create the authenticator.
//    IamAuthenticator authenticator = new MyConfig().iamAuthenticator();

    @Autowired
    private UnderwritingService underwritingService;

//    @Autowired
//    private UnderwritingService underwritingService = new UnderwritingService(authenticator);

    @RequestMapping(value="/getAllUnderwriting",method = RequestMethod.GET)
    public ResponseEntity<List<Underwriting>> getUnderwritings() throws Exception {
        List <Underwriting> underwritingList = underwritingService.fetchAllunderwritings();
        return new ResponseEntity<List <Underwriting>>(underwritingList, HttpStatus.OK);
    }

//    @RequestMapping(value="/addUnderwriting",method = RequestMethod.POST)
//    public ResponseEntity<List<Underwriting>> postUnderwriting(@RequestBody Underwriting underwriting) throws Exception {
//          underwritingService.addUnderwriting(underwriting);
////        return new ResponseEntity<List <Underwriting>>(underwritingList, HttpStatus.OK);
//        return null;
//    }
}
