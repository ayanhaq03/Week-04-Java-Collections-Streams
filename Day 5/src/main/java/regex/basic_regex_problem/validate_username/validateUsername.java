package regex.basic_regex_problem.validate_username;

import java.util.Scanner;
import java.util.regex.Pattern;

public class validateUsername {
    public static  void validate(String pattern , String input){
        boolean ans = Pattern.matches(pattern,input);
        if(ans){
            System.out.println("Valid");
        }else{
            System.out.println("Invalid");
        }
    }
    public static void main(String[] args) {

        String pattern = "^[a-z A-Z]\\w{5,15}";
        Scanner sc = new Scanner(System.in);
        System.out.println("enter your username");
        String input = sc.nextLine();
        validate(pattern,input);

    }
}
