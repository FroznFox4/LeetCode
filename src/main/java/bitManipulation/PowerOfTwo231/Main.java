package bitManipulation.PowerOfTwo231;

public class Main {
    public static void main(String[] args) {
        int n = 2;
        boolean mew = Solution.getInstance().isPowerOfTwo(n);
        System.out.println(mew);
    }
}

class Solution {

    private Solution() {
    }

    private static final Solution obj = new Solution();

    public static Solution getInstance() {
        return obj;
    }

    public boolean isPowerOfTwo(int n) {
        if(n < 1) return false;
        if(n == 1) return true;
        while((n & 1) != 1){
            n >>= 1;
        }
        return n <= 1;
    }

    //    My solution
    public boolean isPowerOfTwoMy(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }
}