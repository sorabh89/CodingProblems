package learn.string;

public class IsPalindrome {

    public static void main(String[] args) {
        String str = "abccba";
        System.out.println(isPalindrome(str));
    }

    public static boolean isPalindrome(String str) {
        int i=0;
        while(i<str.length()/2) {
            if(str.charAt(i)!=str.charAt(str.length()-1-i)) {
                return false;
            }
            i++;
        }
        return true;
    }
}
