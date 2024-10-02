package view;

import controller.FileController;
import controller.RAMManagementSystem;
import models.RamItems;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void menu(){
        System.out.println("1. Add new RAM");
        System.out.println("2. Search RAM");
        System.out.println("3. Update RAM");
        System.out.println("4. Delete RAM");
        System.out.println("5. Display all RAM");
        System.out.println("6. Save to file");
        System.out.println("7. Exit");
    }
    public static void menuSearch(){
        System.out.println("1. Search by type");
        System.out.println("2. Search by bus");
        System.out.println("3. Search by brand");
    }
    public static void main(String[] args) {
        RAMManagementSystem rMS = new RAMManagementSystem("input.dat");
        Scanner sc = new Scanner(System.in );
        int choice ;
        do{
            System.out.println("RAM Management System");
            menu();
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    System.out.println("Enter type: ");
                    String type = sc.nextLine();
                    System.out.println("Enter bus: ");
                    String bus = sc.nextLine();
                    System.out.println("Enter brand: ");
                    String brand = sc.nextLine();
                    System.out.println("Enter quantity: ");
                    int quantity = Integer.parseInt(sc.nextLine());
                    System.out.println("Enter production month year: ");
                    int production_month_year = Integer.parseInt(sc.nextLine());
                    rMS.addRam(type, bus, brand, quantity, production_month_year);
                    break;
                case 2:
                    menuSearch();
                    System.out.println("Enter your choice: ");
                    int choiceSearch = Integer.parseInt(sc.nextLine());
                    System.out.println("Enter key: ");
                    String key = sc.nextLine();
                    rMS.searchRam(choiceSearch, key);
                    break;
                case 3:
                    System.out.println("Enter code: ");
                    String code = sc.nextLine();
                    System.out.println("Enter type: ");
                    String typeUpdate = sc.nextLine();
                    System.out.println("Enter bus: ");
                    String busUpdate = sc.nextLine();
                    System.out.println("Enter brand: ");
                    String brandUpdate = sc.nextLine();
                    System.out.println("Enter quantity: ");
                    int quantityUpdate = Integer.parseInt(sc.nextLine());
                    System.out.println("Enter production month year: ");
                    int production_month_yearUpdate = Integer.parseInt(sc.nextLine());
                    RamItems ram = new RamItems(code,typeUpdate, busUpdate, brandUpdate, quantityUpdate, production_month_yearUpdate);
                    rMS.updateRam(ram);
                    break;
                case 4:
                    System.out.println("Enter type: ");
                    String typeDelete = sc.nextLine();
                    rMS.deleteRam(typeDelete);
                    break;
                case 5:
                    List<RamItems> listRes = rMS.displayAll();
                    for(RamItems r : listRes){
                        System.out.println(r);
                    }
                    break;
                case 6:
                    FileController.saveToFile("input.dat",rMS.listRam);
                    break;
                case 7:
                    System.out.println("Goodbye");
                    break;
            }
        }while(choice != 7);
    }
}