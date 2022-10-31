package LibraryManagementDemo.book;

import java.io.IOException;
import java.util.Scanner;

public class BookManagementMenu {
//    BookManagement bookManagement = new BookManagement();
    BookManagement bookManagement = BookManagement.getBookManagement();  /**/
    Scanner scanner = new Scanner(System.in);
    public void menu(){
        System.out.println("Book Management");
        System.out.println("1.Add a book");
        System.out.println("2.Update a book");
        System.out.println("3.Remove a book");
        System.out.println("4.Search by ISBN");
        System.out.println("5.Search by title");
        System.out.println("6.Save from file");
        System.out.println("7.Read to file");
        System.out.println("8.Display all");
    }

    public void handleMenu() throws IOException {
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
                    searchISBN();
                    break;
                case 5:
                    searchTitle();
                    break;
                case 6:
                    save();
                    break;
                case 7:
                    read();
                    break;
                case 8:
                    displayAll();
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (choice != 0);
    }

    private void add(){
        System.out.println("Input ISBN");
        String isbn = scanner.nextLine();
        System.out.println("Input title");
        String title = scanner.nextLine();
        System.out.println("Input author");
        String author = scanner.nextLine();
        System.out.println("Input year");



        int year = Integer.parseInt(scanner.nextLine());
        Book newBook = new Book(isbn,title,author,year);
        bookManagement.add(newBook);
    }

    private void update(){
        System.out.println("Input ISBN");
        String isbn = scanner.nextLine();
        System.out.println("Input new title");
        String title = scanner.nextLine();
        System.out.println("Input new author");
        String author = scanner.nextLine();
        System.out.println("Input year");
        int year = Integer.parseInt(scanner.nextLine());
        bookManagement.update(isbn,title,author,year);
    }

    private void remove(){
        System.out.println("Input ISBN");
        String isbn = scanner.nextLine();
        bookManagement.remove(isbn);
    }

    private void searchISBN(){
        System.out.println("Input ISBN");
        String isbn = scanner.nextLine();
        bookManagement.searchByIsbn(isbn);
    }

    private void searchTitle(){
        System.out.println("Input Title");
        String title = scanner.nextLine();
        bookManagement.searchByTitle(title);
    }

    private void read(){
        bookManagement.readToFile();
//        try {
//            bookManagement.readToFile();
//        } catch (IOException e){
//            e.printStackTrace();
//        }
    }

    private void save(){
            bookManagement.saveToFile();
    }

//    private void display() throws FileNotFoundException,IOException {
//        FileReader fileReader = new FileReader(String.valueOf(bookManagement));
//        BufferedReader cache = new BufferedReader(fileReader);
//        String line;
//        while ((line = cache.readLine())!=null){
//            System.out.println(line);
//        }
//        cache.close();
//        fileReader.close();
//    }

    @Override
    public String toString() {
        return "BookManagementMenu{" +
                "bookManagement=" + bookManagement +
                ", scanner=" + scanner +
                '}';
    }
    public void displayAll(){
        System.out.println(bookManagement.display());
    }
}
