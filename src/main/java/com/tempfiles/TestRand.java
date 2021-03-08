package com.tempfiles;

import org.junit.Test;

import java.util.Random;

public class TestRand {
    @Test
    public void testRand(){
        Random random = new Random();
        for(int i = 0; i < 10; i++){
            int randNum = random.nextInt(1);
            System.out.println(randNum);
        }
    }
}
