package weeklyContest291.removeDigitFromNumberToMaximizeResult2259;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String str = "73197";
        char ch = '7';
        Solution.getInstance().removeDigit(str, ch);
    }
}

class Solution {

    private Solution() {
    }

    private static final Solution obj = new Solution();

    public static Solution getInstance() {
        return obj;
    }

//    Solution
    public String removeDigit(String number, char digit) {
//  First
        List<String> digits = new ArrayList<>();
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                String stringWithoutDigit = number.substring(0, i) + number.substring(i + 1);
                digits.add(stringWithoutDigit);
            }
        }
        Collections.sort(digits);
//        return digits.get(digits.size() - 1);
//  Second
        int index = 0;
        int n = number.length();
        for(int i = 0; i < n; i++){
            if(number.charAt(i)==digit){
                index = i;
                if( i < n - 1 && digit < number.charAt( i + 1 ))
                    break;
            }
        }
//        return number.substring(0, index) + number.substring(index + 1);
        return "";
    }

    public String removeDigitFour(String number, char digit) {
        ArrayList<Integer> indexes = new ArrayList<>();
        int index = -1;
        number = number + "0";
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                    indexes.add(i);
            }
        }
        if (indexes.size() == 1)
            index = indexes.get(0);
        else if (indexes.size() > 1) {
            for (Integer i : indexes) {
                if (((number.charAt(i + 1) - '0') > (digit - '0'))) {
                    index = i;
                    break;
                }
            }
            if (indexes.size() > 2 && index == -1) {
                if (indexes.get(indexes.size() - 1) == number.length() - 2) {
                    index = indexes.get(indexes.size() - 1);
                }
                ArrayList<Integer> integerArray = new ArrayList<>();
                boolean flag = false;
                for (Integer i : indexes) {
                    int i1 = (digit - '0') - (number.charAt(i + 1) - '0');
                    if (i1 == 0)
                        flag = true;
                    integerArray.add(i1);
                }
                if (integerArray.size() > 2 && index == -1) {
                    if (flag) {
                        for (int k = 0; k < integerArray.size(); k++) {
                            if (integerArray.get(k) == 0) {
                                index = k;
                            }
                        }
                        index = index + 2;
                    } else {
                        Integer min = Collections.min(integerArray);
                        for (Integer i : indexes) {
                            if ((digit - '0') - (number.charAt(i + 1) - '0') == min) {
                                index = i;
                                break;
                            }
                        }
                    }
                } else {
                    Integer min = Collections.min(integerArray);
                    for (Integer i : indexes) {
                        if ((digit - '0') - (number.charAt(i + 1) - '0') == min) {
                            index = i;
                            break;
                        }
                    }
                }
            }
        }
        if (index == 0)
            return number.substring(1);
        else if (index == number.length() - 1)
            return number.substring(0, number.length() - 2);
        else
            return number.substring(0, index) + number.substring(index + 1, number.length() - 1);
    }
    public String removeDigitThree(String number, char digit) {
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                if (i < number.length() - 1) {
                    if (i == 0 && ((number.charAt(i + 1) - '0') >= (digit - '0')) ) {
                        return number.substring(1);
                    } else {
                        indexes.add(i);
                    }
                }
            }
        }
        if (indexes.size() == 1) {
            if ((indexes.get(0) == 0) && (number.charAt(number.length() - 1) - '0' != digit - '0'))
                return number.substring(1);
            else if ((indexes.get(0) == 0) && (number.charAt(number.length() - 1) - '0' == digit - '0'))
                return number.substring(0, number.length() - 1);
            else if (indexes.get(0) > 0 && indexes.get(0) < number.length())
                return number.substring(0, indexes.get(0)) + number.substring(indexes.get(0) + 1);
            else
                return number.substring(0, number.length() - 1);
        }
        for (Integer index : indexes) {
            if (((number.charAt(index + 1) - '0') > (digit - '0'))) {
                return number.substring(0, index) + number.substring(index + 1);
            }
        }
        if (indexes.size() == 0) {
            if (number.charAt(0) - '0' == digit - '0') {
                if (number.charAt(number.length() - 1) - '0' == digit - '0') {
                    if (number.charAt(0) - '0' > digit - '0') {
                        return number.substring(1);
                    } else {
                        return number.substring(0, number.length() - 1);
                    }
                }
            } else
                return number.substring(0, number.length() - 1);
        }
        if (number.charAt(number.length() - 1)-'0' == digit - '0') {
            return number.substring(0, number.length() - 1);
        }
        return "$";
    }

    public String removeDigitFirst(String number, char digit) {
            long min = 0;
            List<String> myList = new ArrayList<>(Arrays.asList(number.split("")));
            for (int i = 0; i < myList.size(); i++) {
                if (Objects.equals(myList.get(i), String.valueOf(digit))) {
                    List<String> tempList = new ArrayList<>(myList);
                    tempList.remove(i);
                    long curr =  Long.parseLong(String.join("", tempList));
                    if (curr > min) {
                        min = curr;
                    }
                }
            }
            String result = String.valueOf(min);
            return result;
//                    .substring(0, result.length() - 2);
    }
}