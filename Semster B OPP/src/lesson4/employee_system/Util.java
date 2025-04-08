package lesson4.employee_system;

public class Util {
    public static String rjust(String st, int minWidth, char fillChar){
        if (st.length() >= minWidth){
            return st;
        }
        return (fillChar + "").repeat(minWidth - st.length()) + st;
    }
}
