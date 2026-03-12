public class StringToInt {

    public static void main(String[] args) {
        String str = "-91283472332";
        System.out.println(myAtoi(str));
    }

    private static int myAtoi(String s) {

        s = s.trim();
        if (s.length() == 0) return 0;

        int sign = 1;
        int index = 0;

        if (s.charAt(0) == '-') {
            sign = -1;
            index++;
        } else if (s.charAt(0) == '+') {
            index++;
        }

        long res = helpConvertAtoi(s, index, 0);

        res = res * sign;

        if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) res;
    }

    private static long helpConvertAtoi(String s, int ind, long res) {

        if (ind >= s.length())
            return res;

        char ch = s.charAt(ind);

        if (ch < '0' || ch > '9')
            return res;

        res = res * 10 + (ch - '0');

        if (res > Integer.MAX_VALUE)
            return res;

        return helpConvertAtoi(s, ind + 1, res);
    }
}