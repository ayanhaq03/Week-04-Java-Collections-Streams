package regex.basic_regex_problem.validate_license_plate_number;

import java.util.Scanner;
import java.util.regex.Pattern;

public class validateLicensePlateNo {
    public static  void validate(String pattern , String input){
        boolean ans = Pattern.matches(pattern,input);
        if(ans){
            System.out.println("Valid");
        }else{
            System.out.println("Invalid");
        }
    }
    public static void main(String[] args) {

        String pattern = "^[A-Z]{2}[0-9]{4}";
        Scanner sc = new Scanner(System.in);
        System.out.println("enter your License plate number");
        String input = sc.nextLine();
        validate(pattern,input);

    }
}
