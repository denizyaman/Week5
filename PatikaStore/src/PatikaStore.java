import java.util.Scanner;

public class PatikaStore {
    Scanner inp=new Scanner(System.in);
    boolean isRunning=true;

    public void run(){
        while (isRunning){
            System.out.println("Patika Store Yönetim Paneli");
            System.out.println("1-Notebook İşlemleri\n"
                    + "2-Cep Telefonu İşlemlei\n"
                    + "3-Markaları Listeleme\n"
                    + "0- Çıkış Yap");
            System.out.println("Lütfen yapmak istediğiniz işlemi seçiniz: ");
            int select= inp.nextInt();
            switch (select){
                case 1:
                    Notebook notebook=new Notebook();
                    notebook.runMenu();
                    return;
                case 2:
                    Phone phone=new Phone();
                    phone.runMenu();
                case 3:
                    Brand brand=new Brand();
                    brand.printBrand();
                    break;
                case 0:
                    System.out.println("Çıkış Yapıldı.");
                    isRunning=false;
                    break;
                default:
                    System.out.println("Hatalı değer girdiniz.");
            }
        }

    }
}
