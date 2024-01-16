public class Book implements Comparable<Book> {
    private String bookName;
    private int pageCount;
    private String authorName;
    private String publicationDate;

    public Book(String bookName, int pageCount, String authorName, String publicationDate) {
        this.bookName = bookName;
        this.pageCount = pageCount;
        this.authorName = authorName;
        this.publicationDate = publicationDate;
    }

    public int getPageCount() {
        return pageCount;
    }

    // Alfabetık sıralama
    @Override
    public int compareTo(Book otherBook) {
        return this.bookName.compareTo(otherBook.bookName);
    }

    @Override
    public String toString() {

        return
                " |Kitap Adı: |" + this.bookName +
                ",| Sayfa Sayısı:| " + this.pageCount +
                ",|Yazar: |" + this.authorName +
                ",|Basım Yılı: |" + this.publicationDate+
                "\n----------------------------------------------------------------------------------------------------------";
    }
}