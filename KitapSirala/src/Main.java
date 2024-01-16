import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("SUÇ VE CEZA", 1152, "Dostoyevski", "1886");
        Book book2 = new Book("SEFİLLER", 1515, "Victor Hugo", "1862");
        Book book3 = new Book("ANNA KARENINA", 1035, "Lev Tolstoy", "1877");
        Book book4 = new Book("VADİDEKİ ZAMBAK", 328, "Balzac", "1835");
        Book book5 = new Book("MADAME BOVARY", 408, "Gustave Flaubert", "1857");

        // İsme göre sıralama
        Set<Book> nameList = new TreeSet<>();
        nameList.add(book1);
        nameList.add(book2);
        nameList.add(book3);
        nameList.add(book4);
        nameList.add(book5);

        System.out.println("Kitap Adına Göre Sıralandı: ");
        for (Book book : nameList) {
            System.out.println(book);
        }

        Comparator<Book> pageCountComparator = Comparator.comparingInt(Book::getPageCount);


        Set<Book> pageCountList = new TreeSet<>(pageCountComparator);
        pageCountList.addAll(nameList);

        System.out.println("Sayfa Sayısına Göre Sıralandı: ");
        for (Book book : pageCountList) {
            System.out.println(book);
        }
    }
}