package wangfei;

import java.io.*;

/**
 * The type File util.
 */
public class FileUtil {
    /**
     * ����ļ���
     *
     * @param path the path
     * @return the string
     */
    public static String getFileName(String path) {
        return new File(path).getName();
    }

    /**
     * �ļ��Ƿ����
     *
     * @param path �ļ�·��
     * @return the boolean
     */
    public static boolean exists(String path) {
        return new File(path).exists();
    }

    /**
     * �����հ��ļ�
     *
     * @param path �ļ�·��
     * @return �����Ƿ�ִ���˴��� boolean
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
     * ɾ���ļ�
     *
     * @param path the path
     * @return the boolean
     */
    public static boolean remove(String path) {
        return new File(path).delete();
    }

    /**
     * ���´����ļ�
     *
     * @param path the path
     */
    public static void recreate(String path) {
        remove(path);
        touch(path);
    }

    /**
     * ��ȡ�ļ�����
     *
     * @param path �ļ�·��
     * @return �ļ����� string
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
     * д���ļ�
     *
     * @param path  �ļ�·��
     * @param lines ÿ��������ɵ�����
     * @return the boolean
     */
    public static synchronized boolean writeFile(String path, String[] lines) {
        touch(path);
        try (PrintStream ps = new PrintStream(path)) {
            for (String line : lines) {
                ps.println(line);
            }
        } catch (FileNotFoundException ignored) {
            // �����ܵ����
        }
        return true;
    }
}