public class W8Assignment5 {
    public static void main(String[] args) {
        Book b = new Book("Java Basics", 300);
        b.info();
    }
}

class Book {
    String title;
    int pages;

    Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    void info() {
        System.out.println("Title: " + title);
        System.out.println("Pages: " + pages);
    }
}
