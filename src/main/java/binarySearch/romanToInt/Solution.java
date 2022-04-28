package binarySearch.romanToInt;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    Map<Character, Integer> symbToVal = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    public int romanToInt(String s) {
        Integer result = 0;
        Integer nextInt = 0;
        List<Character> listOfNumber = Arrays.stream(s.chars().mapToObj(c -> (char)c).toArray(Character[]::new))
                .collect(Collectors.toList());
        for (int i = 0; i < listOfNumber.size(); i++) {
            Integer curInt = symbToVal.getOrDefault(listOfNumber.get(i), 0);
            if (i + 1 < listOfNumber.size()) {
                nextInt = symbToVal.getOrDefault(listOfNumber.get(i + 1), 0);
                if (curInt >= nextInt) {
                    result += curInt;
                } else {
                    result -= curInt;
                }
            } else {
                result += curInt;
            }
        }
        return result;
    }
}