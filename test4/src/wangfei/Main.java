package wangfei;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {

        //// 数据收集阶段

        // 交互式创建学生对象
        Student stu = Student.interactiveCreate();
        System.out.println("已登录学生：" + stu);

        String inFilePath;
        do {
            inFilePath = InputUtil.inputString("提交作业(文件路径)：");

            if (!FileUtil.exists(inFilePath)) {
                System.out.println("文件路径不正确，重新选择");
                continue;
            }
            break;
        } while (true);
        System.out.println("锁定文件路径：" + inFilePath);

        // 创建搜索词库
        ArrayList<String> searches = new ArrayList<>();
        searches.addAll(Arrays.asList(args));//导入参数
        do {
            String input = InputUtil.inputString("输入要计数的词语，点号(.)代表完成(" + searches.size() + "): ");
            if (input.equals(".")) break;
            searches.add(input.trim());
        } while (true);
        System.out.println("导入计数词语(" + searches.size() + ")：" + Util.arrayJoin(searches, ", "));

        //// 批改阶段

        System.out.println("正在批改作业...");

        // 确保正常运行，重新创建目标文件。
        String outFileName = "resources" + File.separator + FileUtil.getFileName(inFilePath) + ".processed.txt";
        FileUtil.recreate(outFileName);

        // 创建字符串缓存写入内容
        StringBuffer content = new StringBuffer();

        // 缓存学生信息
        content.append(stu);
        content.append("\n\n========================\n\n");

        // 读取文本
        String source = "";
        try {
            source = FileUtil.readFile(inFilePath);
        } catch (IOException e) {
            System.out.println("错误：无法读取文件");
            exit(-1);
        }

        // 处理作业
        assert source != null;
        String result = StringUtil.rulesInsert(
                StringUtil.rulesInsert(
                        source,
                        "，",
                        1, 14, 7),
                "。\n",
                1, 15, 0);
        content.append(result);
        content.append("\n\n========================\n\n");

        // 进行计数
        content.append("词语统计\n");
        for (String keyword : searches) {
            content.append(keyword + "\t" + StringUtil.countString(result, keyword) + "\n");
        }

        //// 存储展示阶段

        // 写入文件
        FileUtil.writeFile(outFileName, content.toString().split("\n"));

        // 展示结果
        System.out.println(content.toString());
    }
}