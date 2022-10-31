package LibraryManagementDemo.student;

import java.util.Scanner;

public class StudentManagementMenu {
    StudentManagement studentManagement = StudentManagement.getStudentManagement(); /*KHONG THE DUNG new, designPatten Singleton tao 1 doi tuong duy nhat*/
    Scanner scanner = new Scanner(System.in);
    public void menu(){
        System.out.println("Student Management");
        System.out.println("1.Add a Student");
        System.out.println("2.Update a Student");
        System.out.println("3.Remove a Student");
        System.out.println("4.Search by ID");
        System.out.println("5.Search by name");
        System.out.println("6.Read from file");
        System.out.println("7.Save to file");
        System.out.println("8.Display all");
    }

    public void handleMenu(){
        int choice = -1;
        do {
            System.out.println("Input your choice");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    remove();
                    break;
                case 4:
                    searchID();
                    break;
                case 5:
                    searchName();
                    break;
                case 6:
                    read();
                    break;
                case 7:
                    save();
                    break;
                case 8:
                    display();
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (choice != 0);
    }

    private void add(){
        System.out.println("Input ID");
        String id = scanner.nextLine();
        System.out.println("Input name");
        String name = scanner.nextLine();
        System.out.println("Input sClass");
        String sClass = scanner.nextLine();
        System.out.println("Input year");
        int year = Integer.parseInt(scanner.nextLine());
        Student newStudent = new Student(id,name,sClass,year);
        studentManagement.add(newStudent);
    }

    private void update(){
        System.out.println("Input id");
        String id = scanner.nextLine();
        System.out.println("Input new name");
        String name = scanner.nextLine();
        System.out.println("Input new sClass");
        String sClass = scanner.nextLine();
        System.out.println("Input year");
        int year = Integer.parseInt(scanner.nextLine());
        studentManagement.update(id,name,sClass,year);
    }

    private void remove(){
        System.out.println("Input id");
        String id = scanner.nextLine();
        studentManagement.remove(id);
    }

    private void searchID(){
        System.out.println("Input id");
        String id = scanner.nextLine();
        studentManagement.searchByID(id);
    }

    private void searchName(){
        System.out.println("Input name");
        String name = scanner.nextLine();
        studentManagement.searchByName(name);
    }

    private void read(){
            studentManagement.readFromFile();
    }

    private void save(){
            studentManagement.saveToFile();
    }

    private void display(){
        System.out.println(studentManagement.toString());
    }
}
