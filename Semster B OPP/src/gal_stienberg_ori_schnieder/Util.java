package gal_stienberg_ori_schnieder;

public class Util {
    public static boolean isExist(String name, int numOfArr, Object [] arr) {
        for (int i = 0;i < numOfArr;i++) {
            if (arr[i] instanceof Lecturer l && name.equals(l.getName())){
                return true;
            }
            if (arr[i] instanceof Department d && name.equals(d.getName())){
                return true;
            }
            if (arr[i] instanceof Committee c && name.equals(c.getName())){
                return true;
            }
        }
        return false;
    }
    public static <T> T[] copy(T[] arr, int size, int numOfArr) {
        T[] temp = (T[]) java.lang.reflect.Array.newInstance(arr.getClass().getComponentType(), size);
        if (numOfArr >= 0) System.arraycopy(arr, 0, temp, 0, numOfArr);
        return temp;
    }
    public static boolean isValidId(String id){
        return id != null && id.matches("[0-9]+") && id.length() == 9;
    }
}
