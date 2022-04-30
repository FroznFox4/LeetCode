package twoPointers.reverseWordsInAString557;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String str = "Let's take LeetCode contest";
        System.out.println(Solution.getInstance().reverseWords(str));
    }


}
class Solution {

    private Solution() {
    }

    private static final Solution obj = new Solution();

    public static Solution getInstance() {
        return obj;
    }

//    Faster than 38,5; Memory less than 50,4.
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String sub : str){
            int n = sub.length()-1;
            for(int j=n;j>=0;j--)
                sb.append(sub.charAt(j));
            sb.append(" ");
        }
        return sb.toString().trim();
    }

//    My solution
//    Faster than 23.8; Memory less than 77,78.
    public String reverseWordsMy(String s) {
        ArrayList<String> arr = new ArrayList<>(Arrays.asList(s.split(" ")));
        StringBuilder stringBuilder = new StringBuilder();
        for (String ar:
             arr) {
            ArrayList<String> arrMin = new ArrayList<>(Arrays.asList(ar.split("")));
            Collections.reverse(arrMin);
            for (String value : arrMin) {
                stringBuilder.append(value);
            }
            stringBuilder.append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length());
        return stringBuilder.toString();
    }
}
