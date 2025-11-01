package ACT2.Utils;

import java.util.Set;


public class Valid {

    public static boolean opValid(char req) {
        Set<Character> validOps = Set.of('+', '-', '*', '/');
        if (!validOps.contains(req)) {
            System.out.println("Op is not valid!");
            return false;
        } else {
            return true;
        }
    }
}

