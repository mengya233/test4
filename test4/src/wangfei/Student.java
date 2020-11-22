package wangfei;


/**
 * 学生数据类
 */
public class Student {
    private String name;
    private int age;
    private char gender;

    /**
     * Instantiates a new Student.
     *
     * @param name   the name
     * @param age    the age
     * @param gender the gender
     */
    public Student(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public static Student interactiveCreate() {
        return new Student(
                InputUtil.inputString("请输入姓名："),
                InputUtil.inputInt("请输入年龄：", 0, -1),
                InputUtil.select("请选择性别：", "男", "女").charAt(0)
        );
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets age.
     *
     * @param age the age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets gender.
     *
     * @return the gender
     */
    public char getGender() {
        return gender;
    }

    /**
     * Sets gender.
     *
     * @param gender the gender
     */
    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "学生信息{\n" +
                "\t姓名='" + name + '\'' + "\n" +
                "\t年龄=" + age + "\n" +
                "\t性别=" + gender + "\n" +
                '}';
    }
}