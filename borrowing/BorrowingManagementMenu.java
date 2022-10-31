package LibraryManagementDemo.borrowing;

import LibraryManagementDemo.book.BookManagement;
import LibraryManagementDemo.student.StudentManagement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BorrowingManagementMenu{
    BorrowingManagement borrowingManagement = new BorrowingManagement();
    BookManagement bookManagement = BookManagement.getBookManagement(); /**/
    StudentManagement studentManagement = StudentManagement.getStudentManagement(); /**/
    public void menu() {
        System.out.println("============Menu============");
        System.out.println("*     Borrow Management*    ");
        System.out.println("* 1. Add borrow            *");
        System.out.println("* 2. Return book           *");
        System.out.println("* 3. Search by borrow id   *");
        System.out.println("* 4. Search by book id     *");
        System.out.println("* 5. Search by student id  *");
        System.out.println("* 6. Get On Borrowings     *");
        System.out.println("* 7. Save file             *");
        System.out.println("* 8. Read file             *");
        System.out.println("* 9. Display all           *");
        System.out.println("* 0. Done                  *");
        System.out.println("============================");
    }

    public void handleMenu() throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        int choose = -1;
        while (choose != 0) {
            menu();
            System.out.println("Enter number");
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    add();
                    break;
                case 2:
                    returnBook();
                    break;
                case 3:
                    searchByBorrowingId();
                    break;
                case 4:
                    searchByBookID();
                    break;
                case 5:
                    searchByStudentID();
                    break;
                case 6:
                    getOnBorrowings();
                    break;
                case 7:
                    saveToFile();
                    break;
                case 8:
                    readFromFile();
                    break;
                case 9:
                    displayAll();
                    break;
                default:
                    break;
            }
        }
    }
    public void add() throws IOException, ParseException {
        readFromFile();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Student ID: ");
        String studentID = scanner.nextLine();
        System.out.println("Enter book ID");
        String bookID = scanner.nextLine();
        System.out.println("Enter date borrow");
        Date dateBorrow = new Date(scanner.nextLine());     /*KT xem book va student co ton tai khong*/

        if (bookManagement.searchByIsbn(bookID) == null){
            System.out.println("Book's ID not found");
            add();                                          /*de quy thay cho vong while*/
            return;
        }

        if(studentManagement.searchByID(studentID) == null){
            System.out.println("Student's ID not found");
            add();
            return;
        }

        Borrowing br = new Borrowing(studentID,bookID,dateBorrow);
        borrowingManagement.add(br);
        System.out.println(br.getBorrowId());
    }
    public void returnBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter borrowing ID:");
        int borrowingID = scanner.nextInt();scanner.nextLine();
        borrowingManagement.returnBook(borrowingID);
    }
    public void searchByBorrowingId(){  /*search ra kết quả là đơn mượn dua tren du lieu nhap vao*/
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input borrowing ID:");
        int borrowingID = scanner.nextInt();scanner.nextLine();
        Borrowing br = borrowingManagement.searchByBorrowingID(borrowingID);
        System.out.println(br);
    }

    public void searchByBookID(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input bookID");
        String bookID = scanner.nextLine();
        Borrowing br = borrowingManagement.searchByBookID(bookID);
        System.out.println(br);
    }

    public void searchByStudentID(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input StudentId");
        String studentID = scanner.nextLine();
        Borrowing br = borrowingManagement.searchByStudentID(studentID);
        System.out.println(br);
    }

    public void getOnBorrowings(){
        List<Borrowing> onBorrowings = borrowingManagement.getOnBorrowings();   /*lay list cac borrowing(don muon) chua tra*/
        for(Borrowing br : onBorrowings){
            System.out.println(br);
        }
    }
    public void saveToFile() throws IOException {      /*phuong thuc ben menu la de thuc thi nhung phuong thuc tu class khac, khong co tham so*/
        borrowingManagement.saveToFile();
    }

    public void readFromFile() throws IOException, ParseException {
        borrowingManagement.readFromFile();
    }

    public void displayAll(){
        borrowingManagement.displaybr();
    }
}
