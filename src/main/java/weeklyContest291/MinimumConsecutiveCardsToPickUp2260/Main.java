package weeklyContest291.MinimumConsecutiveCardsToPickUp2260;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] cards = { 1,4,2,3,9,4,7,8,3 };
        int mew = Solution.getInstance().minimumCardPickup(cards);
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

// Syntactically beautiful solution
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < cards.length; i++) {
            if (map.containsKey(cards[i]))
                min = Math.min(i - map.get(cards[i]) + 1, min);
            map.put(cards[i], i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

//    My solution
    public int minimumCardPickupMy(int[] cards) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < cards.length; i++) {
            int el = cards[i];
            if (map.containsKey(el)) {
                if (i - map.get(el) < min) {
                    min = i - map.get(el);
                } else {
                    map.replace(el, i);
                }
            } else {
                map.put(el, i);
            }
        }
        return (min == Integer.MAX_VALUE) ? -1 : min + 1;
    }

    public int minimumCardPickupSecond(int[] cards) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(cards).forEach(el -> {
            if (map.containsKey(el)) {
                map.replace(el, map.get(el) + 1);
            } else {
                map.put(el, 1);
            }
        });
        int min = Integer.MAX_VALUE;
        int count;
        for (int i = 0; i < cards.length - 1; i++) {
            if (min == 0)
                break;
            int curr = cards[i];
            if (map.get(curr) > 1) {
                map.replace(curr, map.get(curr) - 1);
            } else {
                continue;
            }
            int j = i + 1;
            count = 1;
            for (; j < cards.length; j++) {
                if (cards[j] == curr) {
                    count += 1;
                    if (count < min) {
                        min = count;
                        break;
                    }
                } else {
                    count += 1;
                }
            }
        }
        return (min == Integer.MAX_VALUE) ? -1 : min;
    }

    public int minimumCardPickupFirst(int[] cards) {
        int min = Integer.MAX_VALUE;
        int count;
        for (int i = 0; i < cards.length - 1; i++) {
            int curr = cards[i];
            int j = i + 1;
            count = 1;
            for (; j < cards.length; j++) {
                if (cards[j] == curr) {
                    count += 1;
                    if (count < min) {
                        min = count;
                        break;
                    }
                } else {
                    count += 1;
                }
            }
        }
        return (min == Integer.MAX_VALUE) ? -1 : min;
    }
}