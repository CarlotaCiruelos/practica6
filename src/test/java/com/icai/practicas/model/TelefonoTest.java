package com.icai.practicas.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelefonoTest {


    private Telefono telefono;

    @Test
    void returnTrueWhenTelefonoPatternIsValid() {
        //given
        telefono = new Telefono("913526429");
        Boolean expectedResult = true;
        //when
        Boolean result = telefono.validar();

        //then
        Assertions.assertEquals(expectedResult, result);

    }
    @Test
    void returnFalseWhenTelefonoPatternIsNotValid() {
        //given
        telefono = new Telefono("913a26429");
        Boolean expectedResult = false;
        //when
        Boolean result = telefono.validar();

        //then
        Assertions.assertEquals(expectedResult, result);

    }
}