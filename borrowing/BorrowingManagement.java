package LibraryManagementDemo.borrowing;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class BorrowingManagement {
    List<Borrowing> borrowings;
    private final String path = "LibraryManagementDemo/borrowingList.csv";  /*cho duong dan co dinh*/
    private static BorrowingManagement borrowingManagement = new BorrowingManagement();
    public static BorrowingManagement getBorrowingManagement(){                 /*public o day thi bên menu moi goi duoc*/
        return borrowingManagement;
    }

    public BorrowingManagement(){
        borrowings = new ArrayList<>();
        readFromFile();
    }

    public int add(Borrowing b){
        borrowings.add(b);
        saveToFile();
        return b.getBorrowId();
    }

    public void returnBook(int borrowID){
        Borrowing borrowing = searchByBorrowingID(borrowID);
        if(borrowing != null){
            borrowing.setDateReturned(new Date());
            borrowing.setStatus(true);
        }
        saveToFile();
    }

    public Borrowing searchByBorrowingID(int borrowId){
        for (Borrowing b: borrowings){
            if (b.getBorrowId() == borrowId){
                return b;
            }
        }
        return null;
    }

    public Borrowing searchByBookID(String bookID){
        for(Borrowing b: borrowings){
            if(b.getBookID().equals(bookID)){
                return b;
            }
        }
        return null;
    }

    public Borrowing searchByStudentID(String studentID){
        for (Borrowing b: borrowings){
            if(b.getStudentID().equals(studentID)){
                return b;
            }
        }
        return null;
    }

    public List<Borrowing> getOnBorrowings(){
        List<Borrowing> onBorrowings = new ArrayList<>();
        for (Borrowing br: borrowings){
            if(!br.isStatus()){
                onBorrowings.add(br);
            }
        }
        saveToFile();
        return onBorrowings;
    }

    public void saveToFile(){
        try {                                           /*them try catch*/
            FileWriter fWriter = new FileWriter(path);
            BufferedWriter cache = new BufferedWriter(fWriter);
            for (Borrowing br : borrowings) {
                cache.write(br.toString()); /*chi kieu String moi viet duoc vao file*/
                cache.newLine();
            }

            cache.close();
            fWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readFromFile(){
        borrowings.clear();                                             /*clear ham read*/
        try {
            FileReader fReader = new FileReader(path);
            BufferedReader cache02 = new BufferedReader(fReader);
            String line;
            Borrowing br;
            while ((line = cache02.readLine()) != null) {
                br = handleLine(line);  /*chuyen doi tuong borrowing(don muon) thành mang de doc*/
                borrowings.add(br);
            }
            cache02.close();
            fReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Borrowing handleLine(String line) throws ParseException {        /*SAI SAI SAI SAI SAI*/
        String[] str = line.split(",");
        Date date = new SimpleDateFormat("MM/dd/yyyy").parse(str[3]);
        Borrowing borrowing = new Borrowing(str[1], str[2], date);    /*xem vi tri cua 3 tham so trong ham khoi tao*/
        return borrowing;
    }
//        Date date2;
//        if(!str[4].equals("null")) {
//            date2 = new SimpleDateFormat("MM/dd/yyyy").parse(str[4]);
//        } else {
//            date2 = null;
//        }
//        Borrowing newBorrowing = new Borrowing(Integer.parseInt(str[0]),str[1],str[2],date,date2,Boolean.parseBoolean(str[5])); /*CHUYEN KIEU STRING SANG DATE TAI DAY*/
//        return newBorrowing;

    public void displaybr(){
        for (Borrowing br: borrowings){
            System.out.println(br);
        }
    }
}
