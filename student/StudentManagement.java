package LibraryManagementDemo.student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManagement {
    private List<Student> students;
    private static StudentManagement studentManagement = new StudentManagement();   /*Design Patten(Singleton) tao mot doi tuong duy nhat phải dung private static*/
    public static StudentManagement getStudentManagement(){
        return studentManagement;
    }
    private final String path = "LibraryManagementDemo/studentList";
    
    private StudentManagement(){
        students = new ArrayList<>();
        readFromFile();         /*readFromFile o day*/
    }
    public void add(Student s){
        students.add(s);
        saveToFile();           /*saveToFile o day*/
    }
    public boolean remove(String id){
        Student studentSearch = searchByID(id);
        if(studentSearch != null){
            students.remove(studentSearch);
            saveToFile();       /*saveToFile o day*/
            return true;
        }
        return false;
    }

    public Student searchByID(String id){
        for (Student s: students){
            if(s.getId().equals(id)){
                return s;
            }
        }
        return null;
    }

    public Student searchByName(String name){
        for (Student s: students){
            if(s.getName().equals(name)){
                return s;
            }
        }
        return null;
    }

    public Student update(String id, String name, String sClass, int year){
        for(Student s: students){
            if(s.getId().equals(id)){
                s.setName(name);
                s.setsClass(sClass);
                s.setYear(year);
                saveToFile();           /*saveToFile o day*/
            }
            return s;
        }
        return null;
    }

    public void saveToFile(){       /*dung tryCatch thi bo throws*/
        try {
            FileWriter fWriter = new FileWriter(path);
            BufferedWriter cache = new BufferedWriter(fWriter);
            for (Student s : students) {
                cache.write(s.toString());
                cache.newLine();
            }
            cache.close();
            fWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readFromFile(){
        try {
            students.clear();                                                  /*lenh doc file clear tranh doc chong*/
            FileReader fReader = new FileReader(path);
            BufferedReader cache02 = new BufferedReader(fReader);
            String line;
            Student s;
            while ((line = cache02.readLine()) != null) {                     /*WHAT THE HELL*/
                s = handleLine(line);
                students.add(s);
            }
            cache02.close();
            fReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public Student handleLine(String line){
        String[] str = line.split(",");
        Student newStudent = new Student(str[0],str[1],str[2],Integer.parseInt(str[3]));
        return newStudent;
    }

    @Override
    public String toString() {  /*WHAT THE HELL*/
        String listStudent = "";
        for (Student s: students) {
            listStudent += s.toString() +"\n";
        }
        return listStudent;
    }
}
