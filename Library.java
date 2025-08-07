import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();

        books.add(new Book(101, "Java Basics"));
        books.add(new Book(102, "OOP in Java"));
        books.add(new Book(103, "Data Structures"));

        users.add(new User(1, "Naveen"));
        users.add(new User(2, "Praveen"));
        users.add(new User(3, "Vijay"));
    }

    public void showBooks() {
        System.out.println("\nAvailable Books:");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void showUsers() {
        System.out.println("\nRegistered Users:");
        for (User u : users) {
            System.out.println(u);
        }
    }

    public boolean isValidUser(int userId) {
        for (User u : users) {
            if (u.getUserId() == userId) {
                return true;
            }
        }
        return false;
    }

    public void issueBook(int bookId, int userId) {
        if (!isValidUser(userId)) {
            System.out.println("Invalid User ID.");
            return;
        }

        for (Book b : books) {
            if (b.getId() == bookId) {
                if (!b.isIssued()) {
                    b.issueBook(userId);
                    System.out.println("Book '" + b.getTitle() + "' issued to User ID: " + userId);
                } else {
                    System.out.println("Book is already issued to User ID: " + b.getBorrowedByUserId());
                }
                return;
            }
        }
        System.out.println("Book ID not found.");
    }

    public void returnBook(int bookId, int userId) {
        for (Book b : books) {
            if (b.getId() == bookId) {
                if (b.isIssued() && b.getBorrowedByUserId() == userId) {
                    b.returnBook();
                    System.out.println("Book '" + b.getTitle() + "' returned successfully by User ID: " + userId);
                } else if (!b.isIssued()) {
                    System.out.println("Book is not currently issued.");
                } else {
                    System.out.println("Book was not issued to this user.");
                }
                return;
            }
        }
        System.out.println("Book ID not found.");
    }
}
