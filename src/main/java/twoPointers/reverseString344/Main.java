package twoPointers.reverseString344;

public class Main {
    public static void main(String[] args) {
        char[] str = { 'h', 'e', 'l' ,'l' ,'o' };
        Solution.getInstance().reverseString(str);
        System.out.println(str);
    }


}
class Solution {

    private Solution() {
    }

    private static final Solution obj = new Solution();

    public static Solution getInstance() {
        return obj;
    }
// Faster than 83.63%; Memory Usage: 58 MB, less than 15.44%
    public void reverseString(char[] s) {
        for (int i = 0; i <= ( s.length - 1) / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
    }
}