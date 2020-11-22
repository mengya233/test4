package wangfei;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {

        //// �����ռ��׶�

        // ����ʽ����ѧ������
        Student stu = Student.interactiveCreate();
        System.out.println("�ѵ�¼ѧ����" + stu);

        String inFilePath;
        do {
            inFilePath = InputUtil.inputString("�ύ��ҵ(�ļ�·��)��");

            if (!FileUtil.exists(inFilePath)) {
                System.out.println("�ļ�·������ȷ������ѡ��");
                continue;
            }
            break;
        } while (true);
        System.out.println("�����ļ�·����" + inFilePath);

        // ���������ʿ�
        ArrayList<String> searches = new ArrayList<>();
        searches.addAll(Arrays.asList(args));//�������
        do {
            String input = InputUtil.inputString("����Ҫ�����Ĵ�����(.)�������(" + searches.size() + "): ");
            if (input.equals(".")) break;
            searches.add(input.trim());
        } while (true);
        System.out.println("�����������(" + searches.size() + ")��" + Util.arrayJoin(searches, ", "));

        //// ���Ľ׶�

        System.out.println("����������ҵ...");

        // ȷ���������У����´���Ŀ���ļ���
        String outFileName = "resources" + File.separator + FileUtil.getFileName(inFilePath) + ".processed.txt";
        FileUtil.recreate(outFileName);

        // �����ַ�������д������
        StringBuffer content = new StringBuffer();

        // ����ѧ����Ϣ
        content.append(stu);
        content.append("\n\n========================\n\n");

        // ��ȡ�ı�
        String source = "";
        try {
            source = FileUtil.readFile(inFilePath);
        } catch (IOException e) {
            System.out.println("�����޷���ȡ�ļ�");
            exit(-1);
        }

        // ������ҵ
        assert source != null;
        String result = StringUtil.rulesInsert(
                StringUtil.rulesInsert(
                        source,
                        "��",
                        1, 14, 7),
                "��\n",
                1, 15, 0);
        content.append(result);
        content.append("\n\n========================\n\n");

        // ���м���
        content.append("����ͳ��\n");
        for (String keyword : searches) {
            content.append(keyword + "\t" + StringUtil.countString(result, keyword) + "\n");
        }

        //// �洢չʾ�׶�

        // д���ļ�
        FileUtil.writeFile(outFileName, content.toString().split("\n"));

        // չʾ���
        System.out.println(content.toString());
    }
}