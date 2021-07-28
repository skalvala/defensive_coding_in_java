package com.defcoding.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdasExplainer {

    public static void main(String[] args){



        // integers example
        List<Integer> ints = Arrays.asList(2,3,4);

        List<Integer> intResult = ints.stream()
                .filter(x -> x < 4) // 2 and 3 passes the criteria, but not 4
                .collect(Collectors.toList());

        System.out.println(intResult); // [2, 3]




        // Strings example
        List<String> strings = Arrays.asList("Boston", "Washington");

        List<String> stringResult = strings.stream()
                                        .filter(s -> s.equals("Boston")) // Boston will match, Washington won't
                                        .collect(Collectors.toList());

        System.out.println(stringResult); // [Boston]
    }
}
