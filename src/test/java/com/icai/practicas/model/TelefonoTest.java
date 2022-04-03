package com.icai.practicas.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelefonoTest {


    private Telefono telefono;

    @Test
    void return_true_when_telefono_pattern_is_valid() {
        //given
        telefono = new Telefono("913526429");
        Boolean expectedResult = true;
        //when
        Boolean result = telefono.validar();

        //then
        Assertions.assertEquals(expectedResult, result);

    }
    @Test
    void return_false_when_telefono_pattern_is_not_valid() {
        //given
        telefono = new Telefono("913a26429");
        Boolean expectedResult = false;
        //when
        Boolean result = telefono.validar();

        //then
        Assertions.assertEquals(expectedResult, result);

    }
}