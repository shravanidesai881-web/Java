package oop;

import java.util.Scanner;

// Parent Class
class Publication {
    String title;
    double price;
    int copies;

    Publication(String title, double price, int copies) {
        this.title = title;
        this.price = price;
        this.copies = copies;
    }

    double saleCopy() {
        return price * copies;
    }

    void display() {
        System.out.println("Title: " + title);
        System.out.println("Price: Rs. " + price);
        System.out.println("Copies: " + copies);
    }
}

// Child Class - Book
class Book extends Publication {
    String author;

    Book(String title, double price, int copies, String author) {
        super(title, price, copies);
        this.author = author;
    }

    void orderCopies(int quantity) {
        copies = copies + quantity;
        System.out.println(quantity + " copies ordered successfully.");
    }

    void displayBook() {
        display();
        System.out.println("Author: " + author);
    }
}

// Child Class - Magazine
class Magazine extends Publication {
    int orderQty;
    String currentIssue;

    Magazine(String title, double price, int copies, int orderQty, String currentIssue) {
        super(title, price, copies);
        this.orderQty = orderQty;
        this.currentIssue = currentIssue;
    }

    void displayMagazine() {
        display();
        System.out.println("Order Quantity: " + orderQty);
        System.out.println("Current Issue: " + currentIssue);
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- BOOK INPUT ---
        System.out.println("--- ENTER BOOK DETAILS ---");
        System.out.print("Enter Book Title: ");
        String bTitle = sc.nextLine();
        
        System.out.print("Enter Book Price: ");
        double bPrice = sc.nextDouble();
        
        System.out.print("Enter Initial Copies Sold: ");
        int bCopies = sc.nextInt();
        sc.nextLine(); // लाईन क्लिअर करण्यासाठी (Buffer Clear)
        
        System.out.print("Enter Author Name: ");
        String bAuthor = sc.nextLine();

        // Creating Book Object with User Input
        Book book = new Book(bTitle, bPrice, bCopies, bAuthor);

        // --- MAGAZINE INPUT ---
        System.out.println("\n--- ENTER MAGAZINE DETAILS ---");
        System.out.print("Enter Magazine Title: ");
        String mTitle = sc.nextLine();
        
        System.out.print("Enter Magazine Price: ");
        double mPrice = sc.nextDouble();
        
        System.out.print("Enter Magazine Copies Sold: ");
        int mCopies = sc.nextInt();
        
        System.out.print("Enter Order Quantity: ");
        int mOrderQty = sc.nextInt();
        sc.nextLine(); // Buffer Clear
        
        System.out.print("Enter Current Issue (e.g., September 2026): ");
        String mIssue = sc.nextLine();

        // Creating Magazine Object with User Input
        Magazine magazine = new Magazine(mTitle, mPrice, mCopies, mOrderQty, mIssue);

        // --- DISPLAY AND OPERATIONS ---
        System.out.println("\n=========================");
        System.out.println("DISPLAYING DETAILS");
        System.out.println("=========================");
        
        System.out.println("\nBOOK DETAILS:");
        book.displayBook();

        // Order more books
        System.out.print("\nEnter number of book copies to order: ");
        int quantity = sc.nextInt();
        book.orderCopies(quantity);

        System.out.println("\nUPDATED BOOK DETAILS:");
        book.displayBook();

        System.out.println("\nMAGAZINE DETAILS:");
        magazine.displayMagazine();

        // Calculate sales
        double totalSales = book.saleCopy() + magazine.saleCopy();
        System.out.println("\n=========================");
        System.out.println("Book Sales: Rs. " + book.saleCopy());
        System.out.println("Magazine Sales: Rs. " + magazine.saleCopy());
        System.out.println("Total Publication Sales: Rs. " + totalSales);
        System.out.println("=========================");

        sc.close();
    }
}