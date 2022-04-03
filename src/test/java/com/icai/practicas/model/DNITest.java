package com.icai.practicas.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DNITest {

    private DNI dni;

    @Test
    void returnTrueWhenDniIsValid() {
        //given
        dni = new DNI( "53813913P");
        Boolean expectedResult = true;

        //when
        Boolean result = dni.validar();

        //then
       Assertions.assertEquals(expectedResult, result);

    }

    @Test
    void returnFalseWhenDniIsNotValidBinarySearch() {
        //given
        dni = new DNI( "00000000T");
        Boolean expectedResult = false;

        //when
        Boolean result = dni.validar();

        //then
        Assertions.assertEquals(expectedResult, result);

    }

    @Test
    void returnFalseWhenDniIsNotValidMatcher() {
        //given
        dni = new DNI( "A3813913P");
        Boolean expectedResult = false;

        //when
        Boolean result = dni.validar();

        //then
        Assertions.assertEquals(expectedResult, result);

    }

    @Test
    void returnFalseWhenDniIsNotValidDigitoControl() {
        //given
        dni = new DNI( "5381391L");
        Boolean expectedResult = false;

        //when
        Boolean result = dni.validar();

        //then
        Assertions.assertEquals(expectedResult, result);

    }


}