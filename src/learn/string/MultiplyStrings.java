package learn.string;

public class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(multiply("123456789","987654321"));
    }

    public static String multiply(String num1, String num2) {
        if(num1 == null || num2 == null) {
            return null;
        }
        int mult = 0;
        for(int i = 0; i< num1.length(); i++) {
            int n1 = Integer.parseInt(String.valueOf(num1.charAt(num1.length()-1-i)));
            int sub = 0;
            for(int j = 0; j<num2.length();j++) {
                int n2 = Integer.parseInt(String.valueOf(num2.charAt(num2.length()-1-j)));
                sub = sub + (int)((n1*n2)*(Math.pow(10,j)));
            }
            mult = mult + (int)(sub*Math.pow(10,i));
        }

        return String.valueOf(mult);
    }
}
