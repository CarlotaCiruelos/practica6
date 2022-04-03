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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

   /* private MultiValueMap <String, String> data1;
    private List<String> lista1 = new ArrayList<>();
    private List<String> lista2 = new ArrayList<>();
    private List<String> lista3 = new ArrayList<>();*/

   /* @Test
    public void given_app_when_login_using_right_credentials_then_ok() {

        //Given
        //ArgumentCaptor <ProcessService> argumentCaptor= ArgumentCaptor.forClass(ProcessService.class);

        String address = "http://localhost:" + port + "/api/v1/process-step1-legacy";

        lista1.add("Carlota");
        lista1.add("Ciruelos");
        lista2.add("53813913P");
        lista3.add("616381627");

        data1.put("fullName",lista1 );
        data1.put("dni",lista2);
        data1.put("telfono",lista3);



        HttpHeaders headers = new HttpHeaders();
        //HttpEntity<ProcessController.DataRequest> request = new HttpEntity<>(data1, headers);

        //When


    }*/


    @Test
    void processDataLegacy() {

    }

    @Test
    void processData() {
    }

    @Test
    public void process_data_then_ok(){
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


}