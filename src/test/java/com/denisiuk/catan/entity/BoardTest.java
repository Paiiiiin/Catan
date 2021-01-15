package com.denisiuk.catan.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void countResources() {

        //given
        int column = 2;
        int row = 10;
        Board board = new Board();

        //when
        //int result = board.countResources(column, row);

        //then
       // Assertions.assertEquals(4, result);
    }

    @Test
    void checkBoardDataArray(){
        int column = 4;
        int row = 10;
        Board board = new Board();

        boolean result = board.checkBoardDataArray(column, row);

        Assertions.assertEquals(true, result);

    }
}