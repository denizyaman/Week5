import java.util.Scanner;

public class Main {
    static String[] myArray = {"Karpuz", "Elma", "Ford", "Mazda","BMW","Toyota","Yüzük","Kolye","Mandalina"};

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("1-9 Arasında Bir Değer Giriniz. Hangi Elemana Erişmek İstersiniz: ");
            int selectedIndex=scanner.nextInt();
            getValueByIndex(selectedIndex-1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Geçersiz Değer Girdiniz!");
        }
    }
    public static void getValueByIndex(int index){
        System.out.println("Eleman: "+myArray[index]);
    }
}