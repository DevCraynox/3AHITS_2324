package at.htlhl.regex;

import java.util.regex.Pattern;

public class RegEx {

    public RegEx() {
        String regularExpression = "^[A-Za-z0-9%!=#]+$";
        String stringToValidate = "3xHITS!";
        if(stringToValidate.matches(regularExpression)){
            System.out.println(stringToValidate + " is valid!");
        }
        //oder so
        Pattern pattern = Pattern.compile("^[A-Za-z0-9%!=#]+$");
        if(pattern.matcher(stringToValidate).matches()){
            System.out.println(stringToValidate + " is valid!");
        }
    }

    public static void main(String[] args) {
        new RegEx();
    }
}