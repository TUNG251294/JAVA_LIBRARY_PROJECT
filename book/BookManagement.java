package LibraryManagementDemo.book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookManagement{
    private List<Book> books;    /*books la dac trung the hien ra ben ngoai cua Object quan ly sach*/
    private final String path = "LibraryManagementDemo/library.csv";        /**/
    private static BookManagement bookManagement = new BookManagement();    /*Design Patten(Singleton) tao mot doi tuong duy nhat phải dung private static*/
    public static BookManagement getBookManagement(){                       /*public o day thi bên menu moi goi duoc*/
        return bookManagement;
    }

    private BookManagement() {
        books = new ArrayList<>();          /*ReadToFile o day*/
        readToFile();
    }

    public void add(Book b){
        books.add(b);
        saveToFile();                       /*saveToFile o day*/
    }

    public boolean remove(String isbn){ /*kieu void cung duoc, kieu boolean de thay tra ve thong bao*/
        Book bookSearch = searchByIsbn(isbn);
        if(bookSearch != null){
            books.remove(bookSearch);
            saveToFile();                   /*saveToFile o day*/
            return true;
        }
        return false;
    }

    public Book searchByIsbn(String s){
        for (Book b: books){
            if(b.getIsbn().equals(s)){
                return b;
            }
        }
        return null;
    }

    public Book searchByTitle(String t){
        for (Book b: books){
            if(b.getTitle().equals(t)){
                return b;
            }
        }
        return null;
    }

    public Book update(String isbn, String title, String author, int year){
        for(Book b: books){
            if(b.getIsbn().equals(isbn)){
                b.setTitle(title);
                b.setAuthor(author);
                b.setYear(year);
                saveToFile();                   /*saveToFile o day*/
            }
            return b;
        }
        return null;
    }

    public void saveToFile(){
        try {
            FileWriter fWriter = new FileWriter(path);
            BufferedWriter cache = new BufferedWriter(fWriter);
            for (Book b : books) {
                cache.write(b.toString());
                cache.newLine();
            }
            cache.close();
            fWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readToFile(){
            books.clear();
            try {
                /*lenh doc file clear tranh doc chong*/

                FileReader fReader = new FileReader(path);
                BufferedReader cache02 = new BufferedReader(fReader);
                String line;
                Book b;
                while ((line = cache02.readLine()) != null) {                     /*WHAT THE HELL*/
                    b = handleLine(line);
                    books.add(b);

                    cache02.close();
                    fReader.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }

    }

    public Book handleLine(String line){    /*chuyen Book tu chuoi sang mang*/
        String[] str = line.split(",");
        Book newBook = new Book(str[0],str[1],str[2],Integer.parseInt(str[3]));
        return newBook;
    }

    String display(){
        String bookList = "";
        for (Book b: books){
            bookList += b.toString() +"\n";
        }
        return bookList;
    }

    @Override
    public String toString() {  /*WHAT THE HELL*/
        String listBook = "";
        for (Book b: books) {
            listBook += b.toString() +"\n";
        }
        return listBook;
    }
}