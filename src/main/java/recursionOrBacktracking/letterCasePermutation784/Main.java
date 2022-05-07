package recursionOrBacktracking.letterCasePermutation784;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String str = "mew";
        List<String> mew = Solution.getInstance().letterCasePermutation(str);
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

//    Memory optimize solution
    List<String> ans;
    public List<String> letterCasePermutation(String s) {
        ans = new ArrayList<>();
        letterCasePermutation(s, 0, s.toCharArray());
        return ans;
    }


    public void letterCasePermutation(String s, int pos, char[] curr) {
        if(pos == s.length()) {
            ans.add(new String(curr));
            return;
        }

        if(Character.isDigit(s.charAt(pos))){
            curr[pos] = s.charAt(pos);
            letterCasePermutation(s, pos+1, curr);
            return;
        }

        curr[pos] = Character.toUpperCase(s.charAt(pos));
        letterCasePermutation(s, pos+1, curr);

        curr[pos] = Character.toLowerCase(s.charAt(pos));
        letterCasePermutation(s, pos+1, curr);
    }

//    Faster solution
    public static List<String> letterCasePermutationSecond(String s) {
        List<String> res = new ArrayList<>();
        char[] a = s.toCharArray();
        letterDfs(a, 0, res);
        return res;
    }

    static void letterDfs(char[] letters, int pos, List<String> result){
        if(pos == letters.length){
            result.add(new String(letters));
            return;
        }

        if(!Character.isDigit(letters[pos])){
            letters[pos] = Character.toUpperCase(letters[pos]);
            letterDfs(letters, pos+1, result);
            letters[pos] = Character.toLowerCase(letters[pos]);
            letterDfs(letters, pos + 1,result);
        }else{
            letterDfs(letters, pos+1, result);
        }
    }

//    Understandable example
    public List<String> letterCasePermutationFirst(String S) {
        List<String> result = new ArrayList<>();
        recurse(S.toCharArray(), 0, result);
        return result;
    }
    void recurse(char[] str, int pos, List<String> result) {
        //If we have reached a leaf in the recursion tree, save the result.
        if (pos == str.length) {
            result.add(new String(str));
            return;
        }

        //If char is not a letter, no processing required.
        if (Character.isLetter(str[pos])) {
            //If uppercase char, we make it lower case, and recurse.
            if (Character.isUpperCase(str[pos])) {
                str[pos] = Character.toLowerCase(str[pos]);

                //Start a new branch in the recursion tree, exploring options that are possible only if we had changed the case.
                recurse(str, pos + 1, result);

                //Backtracking. We undo the change so that we can start a new branch in the recursion tree.
                str[pos] = Character.toUpperCase(str[pos]);
            }
            //If lowercase, then we make it upper case, and recurse.
            else {
                str[pos] = Character.toUpperCase(str[pos]);
                recurse(str, pos + 1, result);
                //Backtracking as explained above.
                str[pos] = Character.toLowerCase(str[pos]);
            }
        }
        //This branch explores options that are possible only if the previously performed change (if any) hadn't happened.
         recurse(str, pos + 1,  result);
    }
}