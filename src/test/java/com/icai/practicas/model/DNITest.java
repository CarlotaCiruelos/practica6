package com.icai.practicas.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DNITest {

    private DNI dni;

    @Test
    void return_true_when_dni_is_valid() {
        //given
        dni = new DNI( "53813913P");
        Boolean expectedResult = true;

        //when
        Boolean result = dni.validar();

        //then
       Assertions.assertEquals(expectedResult, result);

    }

    @Test
    void return_false_when_dni_is_not_valid_binary_search() {
        //given
        dni = new DNI( "00000000T");
        Boolean expectedResult = false;

        //when
        Boolean result = dni.validar();

        //then
        Assertions.assertEquals(expectedResult, result);

    }

    @Test
    void return_false_when_dni_is_not_valid_matcher() {
        //given
        dni = new DNI( "A3813913P");
        Boolean expectedResult = false;

        //when
        Boolean result = dni.validar();

        //then
        Assertions.assertEquals(expectedResult, result);

    }

    @Test
    void return_false_when_dni_is_not_valid_digito_control() {
        //given
        dni = new DNI( "5381391L");
        Boolean expectedResult = false;

        //when
        Boolean result = dni.validar();

        //then
        Assertions.assertEquals(expectedResult, result);

    }


}