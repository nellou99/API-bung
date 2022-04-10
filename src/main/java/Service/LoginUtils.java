package Service;

import java.util.regex.Pattern;

public class LoginUtils {

    //nom doit etre superieur a quatre caractere`s et ne pas contenir de caractere speciaux !"§$%&/()=?
    public static boolean testName(String name) {

        return  name.length() < 4 ? false : testSonderZeichen(name) ? false : true;
    }

    public static boolean testAge(int age) {
        return age > 16 ? true : false;
    }

    public static   boolean testEmail (String email){
        String regex = ("[A-Za-z0-9_.]+@[a-z0-9-]+\\.[a-z]{1,3}+");
        if (email.matches(regex)) {
            return true;
        }
        return false;
    }

    /*
    contient au moins deux classes de caractere
    chiffre
    minuscule
    majuscule
    caracterespeciaux
     */
    public static boolean testPasword(String mdp) {
        int compteurDeClasse = 0;
        if (sindKleinBuchstabenVorhanden(mdp)) {
            compteurDeClasse++;
        }
        if (sindGrossBuchstabenVorhanden(mdp)) {
            compteurDeClasse++;
        }
        if (iszahlenVorhanden(mdp)) {
            compteurDeClasse++;
        }
        if (testSonderZeichen(mdp)) {
            compteurDeClasse++;
        }

        return compteurDeClasse >= 2 ? true : false;
    }

    private static boolean iszahlenVorhanden(String mot) {
        String regex = ".*[0-9].*";
        return  mot.matches(regex);
    }

    private static boolean sindKleinBuchstabenVorhanden(String mot) {
        String regex = ".*[a-z].*";
        return mot.matches(regex);
    }

    private static boolean sindGrossBuchstabenVorhanden(String mot) {
        String  regex = ".*[A-Z].*";
        return mot.matches(regex);
    }


    private static boolean testSonderZeichen(String mot) {
        String regex =  ".*["+ Pattern.quote("!\"§$%&/()=?") +"].*";

        return  mot.matches(regex);
    }
}
