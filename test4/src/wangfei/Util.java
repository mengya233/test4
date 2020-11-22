package wangfei;

import java.util.Collection;

public class Util {
    public static String arrayJoin(Collection<?> arr, String delimiter) {
        StringBuilder str = new StringBuilder();
        boolean first = true;
        for (Object o : arr) {
            if (first) first = false;
            else str.append(delimiter);
            str.append(o);
        }
        return str.toString();
    }
}
