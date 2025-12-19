package src;

public class Student {
    private String name;
    private String nationalCode;

    public Student(String name, String nationalCode) {
        this.name = name;
        this.nationalCode = nationalCode;
    }

    public String getName() {
        return name;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setName(String name) {
        this.name = name;
    }
}
