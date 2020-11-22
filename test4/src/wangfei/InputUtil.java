package wangfei;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtil {

    /**
     * Select string.
     *
     * @param tip        the tip
     * @param selections the selections
     * @return the string
     */
    public static String select(String tip, String... selections) {
        for (int i = 0; i < selections.length; i++) {
            System.out.println(i + ")\t" + selections[i]);
        }
        return selections[inputInt(tip, 0, selections.length - 1)];
    }

    /**
     * Input string string.
     *
     * @param tip the tip
     * @return the string
     */
    public static String inputString(String tip) {
        do {
            System.out.print("[?] " + tip + " ");
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine().trim();
            if (str.length() == 0) {
                System.out.println("[!] �������ա�");
            } else {
                return str;
            }
        } while (true);
    }

    /**
     * Input int int.
     *
     * @param tip the tip
     * @param min the min
     * @param max the max
     * @return the int
     */
    public static int inputInt(String tip, int min, int max) {
        do {
            System.out.print("[?] " + tip + " [" + (min >= 0 ? min : "?") + "-" + (max >= 0 ? max : "?") + "]: ");
            Scanner sc = new Scanner(System.in);
            Integer intinput = null;
            try {
                intinput = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("[!] ֻ�������֣�");
            } catch (Exception ignored) {
            }
            if (intinput == null) continue;
            if (min >= 0 && intinput < min) {
                System.out.println("[!] ����ֵ���ڱ�׼: " + min);
            } else if (max >= 0 && intinput > max) {
                System.out.println("[!] ����ֵ���ڱ�׼��" + max);
            } else return intinput;
        } while (true);
    }

}
