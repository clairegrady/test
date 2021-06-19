package application;

import data.DataStore;

import java.util.Optional;

public class Validation {

    public static boolean emailExists(String email){
        Optional<User> user = DataStore.getDatastore().getUserById(email);
        return user.isPresent();
    }

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