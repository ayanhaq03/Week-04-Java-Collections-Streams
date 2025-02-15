package regex.basic_regex_problem.validate_hex_color_code;

import java.util.Scanner;
import java.util.regex.Pattern;

public class validateHexColor {

    public static  void validate(String pattern , String input){
        boolean ans = Pattern.matches(pattern,input);
        if(ans){
            System.out.println("Valid");
        }else{
            System.out.println("Invalid");
        }
    }
    public static void main(String[] args) {

        String pattern = "^#[a-f A-F 0-9]{6}";
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a hex color code");
        String input = sc.nextLine();
        validate(pattern,input);

    }
}
