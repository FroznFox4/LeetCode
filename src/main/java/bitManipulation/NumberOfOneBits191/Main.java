package bitManipulation.NumberOfOneBits191;

public class Main {
    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        int mew = Solution.getInstance().hammingWeight(n);
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

//    Good solution
    public int hammingWeight(int n) {
        int c = 0;
        while (n != 0) {
            c += (n & 1);
            n >>>= 1;
        }
        return c;
    }

//    My solution
    public int hammingWeightMy(int n) {
        return Integer.bitCount(n);
    }
}