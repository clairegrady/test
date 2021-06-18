package application;

public class Validation {

    public static boolean validEmail(String email){
        String regex = "^(.+)@(.+)$";

        return email.matches(regex);
    }

    public static boolean validName(String name){
        char[] chars = name.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c)){
                return false;
            }
        }
        return true;
    }
}