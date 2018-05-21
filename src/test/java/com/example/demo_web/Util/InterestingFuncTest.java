package com.example.demo_web.Util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class InterestingFunc {
    //    东东从京京那里了解到有一个无限长的数字序列: 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, …(数字k在该序列中正好出现k次)。
// 东东想知道这个数字序列的第n项是多少，你能帮帮他么。
    //an=a1+(n-1)d
    @Test
    public void getNumberByInput() {
        assertEquals (3, getNumber (6));
        assertEquals (4, getNumber (7));
        assertEquals (4, getNumber (10));
        assertEquals (5, getNumber (11));
        assertEquals (18, getNumber (169));
    }

    private int getNumber(int input) {

        List<Integer> aa = new ArrayList<Integer> ();
        for (int i = 0; i < input; i++) {
            for (int j = 0; j < i; j++) {
                aa.add (i);
            }
        }
        return aa.get (input - 1);
    }
}