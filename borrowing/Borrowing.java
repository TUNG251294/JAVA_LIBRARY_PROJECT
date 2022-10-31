package LibraryManagementDemo.borrowing;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Borrowing {
    private int borrowId;   /*tu tang*/
    private String studentID;   /*nhap vao(ton tai)*/
    private String bookID;  /*nhap vao(ktra ton tai)*/
    private Date dateBorrowed;  /*now(ngay hien tai)*/
    private Date dateReturned;  /*null, moi muon hom nay*/
    private boolean status; /*true: da tra, false: chua tra*/
    private static int count = 0;

    public Borrowing() {
    }

    public Borrowing(String studentID, String bookID, Date dateBorrowed) {
        this.studentID = studentID;
        this.bookID = bookID;
        this.dateBorrowed = dateBorrowed;
        this.borrowId = ++count;
        this.dateReturned = null;
        this.status = false;
    }

    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getBookID() {
        return bookID;
    }

    public Date getDateBorrowed() {
        return dateBorrowed;
    }

    public void setDateBorrowed(Date dateBorrowed) {
        this.dateBorrowed = dateBorrowed;
    }

    public Date getDateReturned() {
        return dateReturned;
    }

    public void setDateReturned(Date dateReturned) {
        this.dateReturned = dateReturned;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

//    public static int getCount() {                    /*nao xong thi coi khuc nay*/
//        return count;
//    }
//
//    public static void setCount(int count) {
//        Borrowing.count = count;
//    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String dateBorrowedFormat = simpleDateFormat.format(this.dateBorrowed);
        String dateReturnedFormat;
        if(this.dateReturned != null){
            dateReturnedFormat = simpleDateFormat.format(this.dateReturned);
        } else {
            dateReturnedFormat = null;
        }
        return borrowId +
                "," + studentID +
                "," + bookID +
                "," + dateBorrowedFormat +
                "," + dateReturnedFormat +
                "," + status;
    }
}
//khong co setBookID
