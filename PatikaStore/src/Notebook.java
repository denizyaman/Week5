import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.Scanner;

public class Notebook extends Product implements Operation {
    Scanner inp = new Scanner(System.in);
    private static int noteId;
    private static int idCounter = 1;
    boolean isMenuRunning = true;

    private static ArrayList<Notebook> notebookList = new ArrayList<>();

    public Notebook(int id, String name, double price, double discountRate, int stock, String brandName, String screenSize, int ram, String memory) {
        super(id, name, price, discountRate, stock, brandName, screenSize, ram, memory);
    }

    public Notebook() {

    }

    @Override
    public void runMenu() {
        while (isMenuRunning) {
            System.out.println("Notebook Yönetim Paneli");
            System.out.println("1-Notebook Ekleme\n"
                    + "2-Notebook Silme\n"
                    + "3-id'ye göre Filtreleme\n"
                    + "4-Markaya göre Filtreleme\n"
                    + "5-Notebook Listeleme\n"
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
    for (Notebook notebook : notebookList) {
            printProduct(notebook);
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
        setNoteId(idCounter++);
        notebookList.add(new Notebook(getNoteId(), name, price, discountRate, stock, brandName, screenSize, ram, memory));
    }

    @Override
    public void deleteProduct() {
        System.out.print("Silmek istediğiniz ürünün id değerini giriniz: ");
        int selectedId= inp.nextInt();
        for(int i=0;i<notebookList.size();i++){
            if (selectedId==notebookList.get(i).getId()){
                notebookList.remove(notebookList.get(i));
            }
        }
        System.out.println("Ürün silindi. Yeni liste:");
        showProductList();
    }
    public void printProduct(Notebook notebook){
        System.out.println(" | " + padRight(String.valueOf(notebook.getId()), 5)
                + "| " + padRight(notebook.getName(), 30)
                + "| " + padRight(String.valueOf(notebook.getPrice()), 12)
                + "| " + padRight(notebook.getBrandName(), 12)
                + "| " + padRight(notebook.getMemory(), 12)
                + "| " + padRight(notebook.getScreenSize(), 12)
                + "| " + padRight(String.valueOf(notebook.getRam()), 12));
    }

    public void printHeader(){
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(" | "+padRight("ID",5) +"| "+padRight("Ürün Adı",30)+"| "+padRight("FİYAT",12)+"| "+padRight("MARKA",12)+"| "+padRight("DEPOLAMA",12)+"| "+padRight("EKRAN",12)+"| "+padRight("RAM ",12));
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
    }

    @Override
    public void filterByProductId() {
        boolean isFind=false;
        System.out.print("Görmek istediğiniz ürünün id değerini giriniz: ");
        int selectedId = inp.nextInt();
        printHeader();
        for (Notebook notebook : notebookList) {
            if (selectedId == notebook.getId()) {
               printProduct(notebook);
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
        for (Notebook notebook : notebookList) {
            if (selectedBrand.equals(notebook.getBrandName())) {
                printProduct(notebook);
                isFind=true;
            }
        }
        if (!isFind){
            System.out.println("Hatalı bir değer girdiniz.Girdiğiniz değer bulunamadı.");
        }
        printFooter();
    }


    public static int getNoteId() {
        return noteId;
    }

    public static void setNoteId(int noteId) {
        Notebook.noteId = noteId;
    }
}
