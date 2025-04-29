package gal_stienberg_ori_schnieder;

import java.util.Arrays;

import static gal_stienberg_ori_schnieder.CollegeActionStatus.*;
import static gal_stienberg_ori_schnieder.CollegeActionStatus.SUCCESS;

public class Util {
    public static boolean isExist(Object[] arr, int numOfItems, Object item) {
        for (int i = 0; i < numOfItems; i++) {
            if (arr[i].equals(item)){
                return true;
            }
        }
        return false;
    }


    public static Object[] resizeArr(Object[] arr){
        return Arrays.copyOf(arr,arr.length == 0 ?2 : arr.length*2);
    }
}
