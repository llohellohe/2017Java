package yangqi.yangqi.leetcode;

public class PalindromeSolution {
    public static void main(String[] args) {
        PalindromeSolution solution = new PalindromeSolution();
        System.out.println(solution.isPalindrome2(123321));
        System.out.println(solution.isPalindrome2(-121));
        System.out.println(solution.isPalindrome2(121));
        System.out.println(solution.isPalindrome2(2147483647));

    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        StringBuilder reverseSb = new StringBuilder(Integer.toString(x)).reverse();

        return x == Long.parseLong(reverseSb.toString());
    }
    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }

        int reverse=0,xx=x;

        while(xx>0){
            int temp=reverse*10+xx%10;
            xx=xx/10;
            reverse=temp;
        }

        return reverse==x;
    }
}
