package wangfei;


/**
 * ѧ��������
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
                InputUtil.inputString("������������"),
                InputUtil.inputInt("���������䣺", 0, -1),
                InputUtil.select("��ѡ���Ա�", "��", "Ů").charAt(0)
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
        return "ѧ����Ϣ{\n" +
                "\t����='" + name + '\'' + "\n" +
                "\t����=" + age + "\n" +
                "\t�Ա�=" + gender + "\n" +
                '}';
    }
}