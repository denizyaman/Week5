import java.util.ArrayList;
import java.util.Scanner;

public class Phone extends Product implements Operation{
    Scanner inp=new Scanner(System.in);
    private int camera;
    private int bateryCapacity;
    private String color;
    private static int phoneId;
    private static int idCounter = 1;
    boolean isMenuRunning = true;
    private static ArrayList<Phone> phoneList = new ArrayList<>();


    public Phone(int id, String name, double price, double discountRate, int stock, String brandName, String screenSize, int ram, String memory, int camera, int bateryCapacity, String color) {
        super(id, name, price, discountRate, stock, brandName, screenSize, ram, memory);
        this.camera = camera;
        this.bateryCapacity = bateryCapacity;
        this.color = color;
    }

    public Phone() {
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    public int getBateryCapacity() {
        return bateryCapacity;
    }

    public void setBateryCapacity(int bateryCapacity) {
        this.bateryCapacity = bateryCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static int getPhoneId() {
        return phoneId;
    }

    public static void setPhoneId(int phoneId) {
        Phone.phoneId = phoneId;
    }

    @Override
    public void runMenu() {
        while (isMenuRunning) {
            System.out.println("Cep Telefonu Yönetim Paneli");
            System.out.println("1-Telefon Ekleme\n"
                    + "2-Telefon Silme\n"
                    + "3-id'ye göre Filtreleme\n"
                    + "4-Markaya göre Filtreleme\n"
                    + "5-Telefon Listeleme\n"
                    + "0- Çıkış Yap");
            System.out.println("Lütfen yapmak istediğiniz işlemi seçiniz: ");

            int select = inp.nextInt();

            switch (select) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    deleteProduct();
                    break;
                case 3:
                    filterByProductId();
                    break;
                case 4:
                    filterByProductBrand();
                    break;
                case 5:
                    showProductList();
                    break;
                case 0:
                    System.out.println("Çıkış Yapıldı");
                    isMenuRunning=false;
                default:
                    System.out.println("Hatalı bir değer girdiniz.");
            }
        }
    }

    @Override
    public void showProductList() {
        printHeader();
        for (Phone phone : phoneList) {
            printProduct(phone);
        }
        printFooter();
    }


    @Override
    public void addProduct() {
        System.out.print("Ürün adını giriniz: ");
        String name = inp.next();
        System.out.print("Ürünün fiyatını giriniz: ");
        double price = inp.nextDouble();
        System.out.print("Ürünün indirim oranını giriniz: ");
        double discountRate = inp.nextDouble();
        System.out.print("Ürünün stok miktarını giriniz: ");
        int stock = inp.nextInt();
        System.out.print("Ürünün markasını giriniz: ");
        String brandName = inp.next();
        System.out.print("Ürünün ekran boyutunu giriniz: ");
        String screenSize = inp.next();
        System.out.print("Ürünün ram bilgisini giriniz: ");
        int ram = inp.nextInt();
        System.out.print("Ürünün hafıza bilgisini giriniz: ");
        String memory = inp.next();
        System.out.println("Ürünün kamera bilgiisini giriniz: ");
        int camera=inp.nextInt();
        System.out.println("Pil değerini giriniz");
        int battery=inp.nextInt();
        System.out.println("Renk giriniz");
        String color=inp.next();
        setPhoneId(idCounter++);
        phoneList.add(new Phone(getPhoneId(), name, price, discountRate, stock, brandName, screenSize, ram, memory,camera,battery,color));

    }
    public void printHeader(){
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(" | "+padRight("ID",5) +"| "+padRight("Ürün Adı",30)+"| "+padRight("FİYAT",12)+"| "+padRight("MARKA",12)+"| "+padRight("DEPOLAMA",12)+"| "+padRight("EKRAN",12)+"| "+padRight("Kamera",12)+"| "+padRight("Batarya",12)+"| "+padRight("RAM ",12)+"| "+padRight("Renk ",12));
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
    }
    public void printProduct(Phone phone){
        System.out.println(" | " + padRight(String.valueOf(phone.getId()), 5)
                + "| " + padRight(phone.getName(), 30)
                + "| " + padRight(String.valueOf(phone.getPrice()), 12)
                + "| " + padRight(phone.getBrandName(), 12)
                + "| " + padRight(phone.getMemory(), 12)
                + "| " + padRight(phone.getScreenSize(), 12)
                + "| " + padRight(String.valueOf(phone.getCamera()), 12)
                + "| " + padRight(String.valueOf(phone.getBateryCapacity()), 12)
                + "| " + padRight(String.valueOf(phone.getRam()), 12)
                + "| " + padRight(phone.getColor(), 12));

    }

    @Override
    public void deleteProduct() {
        System.out.print("Silmek istediğiniz ürünün ID değerini giriniz: ");
        int selectedId= inp.nextInt();
        for(int i=0;i<phoneList.size();i++){
            if (selectedId==phoneList.get(i).getId()){
                phoneList.remove(phoneList.get(i));
            }
        }
        System.out.println("Ürün silindi. Yeni liste:");
        showProductList();
    }

    @Override
    public void filterByProductId() {
        boolean isFind=false;
        System.out.print("Görmek istediğiniz ürünün id değerini giriniz: ");
        int selectedId = inp.nextInt();
        printHeader();
        for (Phone phone : phoneList) {
            if (selectedId == phone.getId()) {
                printProduct(phone);
                isFind=true;
            }
        }
        if (!isFind){
            System.out.println("Hatalı bir değer girdiniz.Girdiğiniz değer bulunamadı.");
        }


    }

    @Override
    public void filterByProductBrand() {
        boolean isFind=false;
        System.out.print("Görmek istediğiniz ürünün markasını giriniz: ");
        String selectedBrand = inp.next();
        printHeader();
        for (Phone phone : phoneList) {
            if (selectedBrand.equals(phone.getBrandName())) {
                printProduct(phone);
                isFind=true;
            }
        }
        if (!isFind){
            System.out.println("Hatalı bir değer girdiniz.Girdiğiniz değer bulunamadı.");
        }
        printFooter();
    }
}
