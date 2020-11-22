package wangfei;

public class StringUtil {

    /**
     * 根据规则插入字符
     *
     * @param source    源字符
     * @param insertion 要插入的字符
     * @param startAt   开始处理位置
     * @param step      步阶
     * @param jump      跳值
     * @return the string
     */
    public static String rulesInsert(String source, String insertion, int startAt, int step, int jump) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= source.length(); i++) {
            if (i >= startAt) {
                if ((i + jump) % step == 0) {
                    result.append(insertion);
                }
            }
            if (i < source.length()) result.append(source.charAt(i));
        }
        return result.toString();
    }

    /**
     * 字符串查找计数算法
     *
     * @param source 源字符串
     * @param search 查找字符串
     * @return the int
     */
    public static int countString(String source, String search) {
        int count = 0;
        char[] c = source.toCharArray();
        char[] s = search.toCharArray();
        sourceloop:
        for (int i = 0; i < c.length; i++) {
            int j = 0;
            for (; j < search.length(); j++) {
                if (s[j] != c[i + j]) {
                    i += j;
                    continue sourceloop;
                }
            }
            count += 1;
            i += j;
        }
        return count;
    }
}