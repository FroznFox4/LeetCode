package naumen.test28042022;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try {
            new Solution().solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Solution {
    public void solve() throws IOException {
        String fileName = System.getProperty("user.dir");
        List<String> content = Files
                .lines(Paths.get(fileName.concat("\\input.txt")))
                .collect(Collectors.toList());
        Long k = Long.parseLong(content.get(0).split(" ")[0]);
        Integer solution =  findSolution(
                        k,
                        content
                                .subList(1, content.size())
                                .stream()
                                .map(Long::parseLong)
                                .collect(Collectors.toList())
                );
        FileWriter fileWriter = new FileWriter("output.txt");
        fileWriter.write(Integer.toString(solution));
        fileWriter.close();
    }
    public Integer findSolution(Long k, List<Long> n) {
        Map<Long, Integer> nums = new HashMap<>(Map.of());
        Map<Long, Integer> cash = new HashMap<>(Map.of());
        final int[] result = {0};
        n.forEach(num -> {
            if (!nums.containsKey(num))
                nums.put(num, 1);
            else
                nums.replace(num, nums.get(num) + 1);
        });
        n.forEach(num -> {
            int countNum = nums.get(num);
            int cashNum = cash.getOrDefault(num, -1);
            if (countNum - 1 != 0) {
                if (cashNum == -1) {
                    if (cash.size() < k) {
                        cash.put(num, 1);
                    }
                    result[0] += 1;
                }
                nums.replace(num, countNum - 1);
            } else {
                if (cashNum == -1) {
                    result[0] += 1;
                } else {
                    cash.remove(num);
                }
                nums.remove(num);
            }
        });
        return result[0];
    }
}


