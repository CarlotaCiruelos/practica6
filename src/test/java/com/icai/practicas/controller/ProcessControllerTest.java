package com.icai.practicas.controller;

import com.icai.practicas.service.ProcessService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.MultiValueMapAdapter;

import java.util.*;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class ProcessControllerTest {


    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private ProcessService processService;


    @Test
    void processDataLegacy() {

    }

    @Test
    void processData() {
    }

    @Test
    public void return_ok_when_status_is_true(){
        //Given
        String address = "http://localhost:" + port + "/api/v1/process-step1";
        ProcessController.DataRequest dataRequest = new ProcessController.DataRequest("Carlota Ciruelos", "53813913P", "616381627");
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<ProcessController.DataRequest> request = new HttpEntity<>(dataRequest, headers);

        //When
        ResponseEntity<ProcessController.DataResponse> result = this.restTemplate.postForEntity(address, request, ProcessController.DataResponse.class);

        //Then
        String expectedResult = "OK";
        ProcessController.DataResponse expectedResponse = new ProcessController.DataResponse(expectedResult);

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody().result()).isEqualTo(expectedResult);
        then(result.getBody()).isEqualTo(expectedResponse);
    }




    @Test
    public void return_ko_when_status_false_bad_dni()
    {
        //Given
        String address = "http://localhost:" + port + "/api/v1/process-step1";
        ProcessController.DataRequest dataRequest = new ProcessController.DataRequest("Carlota Ciruelos", "53813913L", "616381627");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ProcessController.DataRequest> request = new HttpEntity<>(dataRequest, headers);

        //When
        ResponseEntity<ProcessController.DataResponse> result = this.restTemplate.postForEntity(address, request, ProcessController.DataResponse.class);

        //Then
        String expectedResult = "KO";
        ProcessController.DataResponse expectedResponse = new ProcessController.DataResponse(expectedResult);

        //then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody().result()).isEqualTo(expectedResult);
        then(result.getBody()).isEqualTo(expectedResponse);
    }


    @Test
    public void return_ko_when_status_false_bad_phone()
    {
        //Given
        String address = "http://localhost:" + port + "/api/v1/process-step1";
        ProcessController.DataRequest dataRequest = new ProcessController.DataRequest("Carlota Ciruelos", "53813913P", "61631627");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ProcessController.DataRequest> request = new HttpEntity<>(dataRequest, headers);

        //When
        ResponseEntity<ProcessController.DataResponse> result = this.restTemplate.postForEntity(address, request, ProcessController.DataResponse.class);

        //Then
        String expectedResult = "KO";
        ProcessController.DataResponse expectedResponse = new ProcessController.DataResponse(expectedResult);

        //then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody().result()).isEqualTo(expectedResult);
        then(result.getBody()).isEqualTo(expectedResponse);
    }





}