package yangqi.yangqi.leetcode;


public class ReverseSolution {
    public static void main(String[] args) {
        ReverseSolution solution = new ReverseSolution();
        System.out.println(solution.reverse3(-421));
        System.out.println(solution.reverse3(421));
        System.out.println(solution.reverse3(964632431));
        System.out.println(solution.reverse3(-4210));

    }

    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        char[] chars = String.valueOf(x).toCharArray();
        int length = chars.length;
        int startindex = 0;
        StringBuilder builder = new StringBuilder();

        if (x < 0) {
            builder.append('-');
            startindex = 1;
        }
        for (int i = length - 1; i >= startindex; i--) {
            builder.append(chars[i]);
        }
        return Integer.valueOf(builder.toString());
    }

    public int reverse2(int x) {
        StringBuilder stringBuilder = new StringBuilder(Integer.toString(Math.abs(x)));
        try {
            String reversed = stringBuilder.reverse().toString();
            return Integer.parseInt(reversed.replaceFirst("^0+(?!$)", "")) * (x / Math.abs(x));
        } catch (Exception e) {
            return 0;
        }
    }

    public int reverse3(int x) {
        StringBuilder stringBuilder = new StringBuilder(Integer.toString(Math.abs(x)));
        try {
            String reversed = stringBuilder.reverse().toString();
            if(x<0){
               reversed="-"+reversed;
            }
            return Integer.parseInt(reversed);
        } catch (Exception e) {
            return 0;
        }
    }
}
