public class Book {
    private int id;
    private String title;
    private boolean isIssued;
    private int borrowedByUserId; // New field

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.isIssued = false;
        this.borrowedByUserId = -1; // No one has borrowed it
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public int getBorrowedByUserId() {
        return borrowedByUserId;
    }

    public void issueBook(int userId) {
        isIssued = true;
        borrowedByUserId = userId;
    }

    public void returnBook() {
        isIssued = false;
        borrowedByUserId = -1;
    }

    @Override
    public String toString() {
        return id + " - " + title + " (" + (isIssued ? "Issued to User ID " + borrowedByUserId : "Available") + ")";
    }
}
