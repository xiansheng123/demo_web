package com.example.demo_web.Util;

import javafx.util.Pair;
import lombok.experimental.var;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class Junit5Test {
    private String environment = "Dev";

    @Test
    void failed_Test() {
        fail ("this is failed Test");
    }

    @Test
    void assumeTest() {
        assumeTrue (Objects.equals (this.environment, "Dev"));
    }

    @Test
    void sortFiles() {
        List<Integer> aa = Arrays.asList (11, 2, 13, 7, 67);
        for (Integer i : aa) {
            System.out.println (i);
        }
//        Comparator<Integer> comparator = Comparator.naturalOrder ();
//        aa.sort (comparator.reversed ());

        Collections.sort (aa, Comparator.naturalOrder ());
        for (Integer i : aa) {
            System.out.println (i);
        }
    }

    @Test
    void PairAndHashTableTest() {
        //Hash Set
        Integer int1 = 123;
        Integer int2 = 456;
        HashSet<Integer> aa = new HashSet<Integer> () {
            {
                add (null);
                add (int1);
                add (int2);
            }
        };
        System.out.println (int1.hashCode () + " " + int2.hashCode ());
        System.out.println ("begin aa");
        System.out.println ("total size:" + aa.size ());
        aa.forEach (System.out::println);
        System.out.println ("end aa");

        Hashtable<Integer, String> bb = new Hashtable<Integer, String> () {
            {
                put (1, "xd");
                put (2, "gg");
            }
        };
        System.out.println (bb.size ());

        List<Pair<Integer, String>> cc = new LinkedList<Pair<Integer, String>> () {
            {
                add (new Pair (1, "11"));
                add (new Pair (null, null));
                add (new Pair (null, null));
            }
        };

        HashMap<Integer, String> dd = new HashMap<Integer, String> () {
            {
                put (1, "xd");
                put (2, "second");
                put (null, "s");
                put (null, null);
            }
        };
        dd.computeIfAbsent (10, x -> "xd1");
        BiFunction<Integer, String, String> biFunction = (k, v) -> {
            System.out.println ("k: " + k + " v:" + v);
            return v + "haha";
        };
        //dd.computeIfPresent (2, biFunction);
        dd.computeIfPresent (2,(x,y)->y="gg");
        System.out.println ("begin hash map");
        System.out.println ("total size: " + dd.size ());
        dd.forEach ((x, y) -> System.out.println ("key:" + x + " value: " + y));
        System.out.println ("End hash map");

    }
}

