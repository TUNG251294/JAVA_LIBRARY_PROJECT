package LibraryManagementDemo.student;

public class Student {
    private String id;
    private String name;
    private String sClass;
    private int year;

    public Student() {
    }

    public Student(String id, String name, String sClass, int year) {
        this.id = id;
        this.name = name;
        this.sClass = sClass;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getsClass() {
        return sClass;
    }

    public void setsClass(String sClass) {
        this.sClass = sClass;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return id + "," + name +","+ sClass +"," + year;
    }
}
