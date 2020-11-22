package wangfei;

import java.io.*;

/**
 * The type File util.
 */
public class FileUtil {
    /**
     * 获得文件名
     *
     * @param path the path
     * @return the string
     */
    public static String getFileName(String path) {
        return new File(path).getName();
    }

    /**
     * 文件是否存在
     *
     * @param path 文件路径
     * @return the boolean
     */
    public static boolean exists(String path) {
        return new File(path).exists();
    }

    /**
     * 创建空白文件
     *
     * @param path 文件路径
     * @return 返回是否执行了创建 boolean
     */
    public static synchronized boolean touch(String path) {
        File f = new File(path);
        if (f.exists()) {
            return false;
        }
        try {
            f.createNewFile();
            return true;
        } catch (IOException ignored) {
            return false;
        }
    }

    /**
     * 删除文件
     *
     * @param path the path
     * @return the boolean
     */
    public static boolean remove(String path) {
        return new File(path).delete();
    }

    /**
     * 重新创建文件
     *
     * @param path the path
     */
    public static void recreate(String path) {
        remove(path);
        touch(path);
    }

    /**
     * 读取文件内容
     *
     * @param path 文件路径
     * @return 文件内容 string
     * @throws IOException the io exception
     */
    public static synchronized String readFile(String path) throws IOException {
        File f = new File(path);
        if (!f.exists() || !f.isFile()) {
            //Utils.error("File not found.");
            return null;
        }
        StringBuilder contents = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(f))) {
            String line;
            boolean firstLine = true;
            while ((line = bufferedReader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                } else {
                    contents.append("\n");
                }
                contents.append(line);
            }
        } /*catch (IOException e) {
            //Utils.error("Errored while opening file.");
            e.printStackTrace();
        }*/
        return contents.toString();
    }

    /**
     * 写入文件
     *
     * @param path  文件路径
     * @param lines 每行内容组成的数组
     * @return the boolean
     */
    public static synchronized boolean writeFile(String path, String[] lines) {
        touch(path);
        try (PrintStream ps = new PrintStream(path)) {
            for (String line : lines) {
                ps.println(line);
            }
        } catch (FileNotFoundException ignored) {
            // 不可能到这里。
        }
        return true;
    }
}