package controller;

import models.RamItems;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileController {
    public static List<RamItems>  loadToFile(String path){
        List<RamItems> list = new ArrayList<>();
        File f = new File(path);
        if(f.exists()){
            System.out.println("File exists");
        }
        try{
            Scanner sc = new Scanner(f);
            while (sc.hasNext()){
                String data = sc.nextLine();
                String[] arr = data.split(",");
                RamItems r = new RamItems(arr[0], arr[1], arr[2], arr[3], Integer.parseInt(arr[4]), Integer.parseInt(arr[5]));
                list.add(r);
            }
            System.out.println("Successfully loaded from file");
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void saveToFile(String path, List<RamItems> list){
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(path));
            for (RamItems r : list){
                pw.println(r.getCode() + "," + r.getType() + "," + r.getBus() + "," + r.getBrand() + "," + r.getQuantity() + "," + r.getProduction_month_year());
                System.out.println("Successfully saved to file");
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
