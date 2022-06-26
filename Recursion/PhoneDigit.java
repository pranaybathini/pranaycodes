package practice;

import java.util.HashMap;

public class PhoneDigit {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        printAll(map, "234", 0, new StringBuilder());
    }

    private static void printAll(HashMap<Integer, String> map, String str, int index, StringBuilder sb) {
        if (index == str.length()) {
            System.out.println(sb.toString());
        } else {
            String s = map.get(Integer.parseInt(String.valueOf(str.charAt(index))));
            for (int i = 0; i < s.length(); i++) {
                sb.append(s.charAt(i));
                printAll(map, str, index + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
