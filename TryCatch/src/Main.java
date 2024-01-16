import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] cars = {"Karpuz", "Elma", "Ford", "Mazda","BMW","Toyota","Yüzük","Kolye","Mandalina"};
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Hangi elemana erişmek istersiniz");
            int selectedIndex=scanner.nextInt();
            System.out.println("Eleman: "+cars[selectedIndex]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Geçersiz eleman");
        }
    }
}