package controller;

import models.RamItems;

import java.util.*;

// DDR4 -> t
public class RAMManagementSystem {
    public List<RamItems> listRam = new ArrayList<>();
    int count = 0;
    public RAMManagementSystem(String path) {
        listRam = FileController.loadToFile(path);
    }


    public void addRam(String type, String bus, String brand, int quantity, int production_month_year){
        listRam.add(new RamItems("RAM" +type.charAt(0)+"_"+count++, type, bus, brand, quantity, production_month_year));
    }

    public RamItems getRamByCode(String code){
        for (RamItems ram : listRam){
            if (ram.getType().equalsIgnoreCase(code)){
                return ram;
            }
        }
        return null;
    }
    public RamItems getRamByType(String type){
        for (RamItems ram : listRam){
            if (ram.getType().equalsIgnoreCase(type)){
                return ram;
            }
        }
        return null;
    }

    public RamItems getRamByBus(String bus){
        for (RamItems ram : listRam){
            if (ram.getType().equalsIgnoreCase(bus)){
                return ram;
            }
        }
        return null;
    }
    public RamItems getRamByBrand(String brand){
        for (RamItems ram : listRam){
            if (ram.getType().equalsIgnoreCase(brand)){
                return ram;
            }
        }
        return null;
    }

    public void searchRam(int choice, String key){
        switch (choice){
            case 1:
                RamItems ram = getRamByType(key);
                if (ram != null){
                    System.out.println(ram);
                }else {
                    System.out.println("Not found");
                }
                break;
            case 2:
                RamItems ram1 = getRamByBus(key);
                if (ram1 != null){
                    System.out.println(ram1);
                }else {
                    System.out.println("Not found");
                }
                break;
            case 3:
                RamItems ram2 = getRamByBrand(key);
                if (ram2 != null){
                    System.out.println(ram2);
                }else {
                    System.out.println("Not found");
                }
                break;
        }
    }
    public void updateRam(RamItems ram){
        RamItems ram1 = getRamByCode(ram.getCode());
            ram1.setType(ram.getType());
            ram1.setBus(ram.getBus());
            ram1.setBrand(ram.getBrand());
            ram1.setQuantity(ram.getQuantity());
            ram1.setProduction_month_year(ram.getProduction_month_year());

    }

    public void deleteRam(String code){
        RamItems ram = getRamByCode(code);
        ram.setActive(false);
    }
    public List<RamItems> displayAll(){
        List<RamItems> res =  listRam.stream().filter(RamItems::isActive).toList();
        /// CACH 1: Ban dung lambda -> ban viet ra ba ham comparotor theo type, bus, brand
        //          Viet ham displatAll() theo kieu nhu nay:
        //         Collections.sort(res, (a, b) -> { a.getType().compareTo(b.getType());
        //         Collections.sort(res, (a, b) -> { a.getBus().compareTo(b.getBus());
        //         Collections.sort(res, (a, b) -> { a.getBrand().compareTo(b.getBrand());
        // return res;

        /// CACH 2: Ban dung lambda -> ban dung ham Comparator.comparing
        Collections.sort(res, Comparator.comparing(RamItems::getType)
                                        .thenComparing(RamItems::getBus)
                                        .thenComparing(RamItems::getBrand));
        return res;
    }







}
