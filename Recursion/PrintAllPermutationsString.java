public class PrintAllPermutationsString {
    public static void main(String[] args) {
        String str = "ABC";
        ArrayList<String> res = new ArrayList<>();
        permutate(str, 0, str.length() - 1, res);
        res.forEach(System.out::println);
    }

    private static void permutate(String str, int l, int r, ArrayList<String> res) {
        if (l == r) {
            res.add(str);
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permutate(str, l + 1, r, res);
                str = swap(str, l, i);
            }
        }
    }

    private static String swap(String str, int l, int r) {
        char[] charArray = str.toCharArray();
        char temp = charArray[l];
        charArray[l] = charArray[r];
        charArray[r] = temp;
        return String.valueOf(charArray);
    }
}
