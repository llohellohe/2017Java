package yangqi.yangqi.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字
 */
public class RomaSolution {
    public static void main(String[] args) {
        RomaSolution solution = new RomaSolution();
        System.out.println(solution.romanToInt("MCMXCIV"));
        System.out.println(solution.romanToInt("LVIII"));
    }

    public int romanToInt(String s) {
        Map<Character, Integer> numberMap = new HashMap<>();
        numberMap.put('I', 1);
        numberMap.put('V', 5);
        numberMap.put('X', 10);
        numberMap.put('L', 50);
        numberMap.put('C', 100);
        numberMap.put('D', 500);
        numberMap.put('M', 1000);

        Map<String, Integer> spNumberMap = new HashMap<>();
        spNumberMap.put("IV", 4);
        spNumberMap.put("IX", 9);
        spNumberMap.put("XL", 40);
        spNumberMap.put("XC", 90);
        spNumberMap.put("CD", 400);
        spNumberMap.put("CM", 900);

        int total = 0;
        String romaString = s;
        for (String k : spNumberMap.keySet()) {
            int length = romaString.length();
            romaString = romaString.replaceAll(k, "");
            int newLength = romaString.length();
            if (newLength < length) {
                total = total + spNumberMap.get(k) * (length - newLength) / 2;
            }
        }



        int finalLength = romaString.length();
        for (int i = 0; i < finalLength; i++) {
            total = total + numberMap.get(romaString.charAt(i));
        }


        return total;
    }

    public int romanToInt2(String s) {
        int nums[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'M':
                    nums[i] = 1000;
                    break;
                case 'D':
                    nums[i] = 500;
                    break;
                case 'C':
                    nums[i] = 100;
                    break;
                case 'L':
                    nums[i] = 50;
                    break;
                case 'X':
                    nums[i] = 10;
                    break;
                case 'V':
                    nums[i] = 5;
                    break;
                case 'I':
                    nums[i] = 1;
                    break;
            }
        }
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1])
                sum -= nums[i];
            else
                sum += nums[i];
        }
        return sum + nums[nums.length - 1];
    }
}
