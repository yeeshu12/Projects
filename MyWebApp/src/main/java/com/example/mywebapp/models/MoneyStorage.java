package com.example.mywebapp.models;

import com.example.atm2app.models.BanknoteItem;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class MoneyStorage {
    final static String filePath = "db.txt";
    public static void Init(){
        var f = new File(filePath);
        if (!f.exists()) {
            // todo read
        } else {
            var list = new HashMap<Integer, BanknoteItem>();
            list.put(5,new BanknoteItem(5, 10));
            list.put(10, new BanknoteItem(10, 10));
            list.put(20, new BanknoteItem(20, 10));
            list.put(50, new BanknoteItem(50, 10));
            var l = new ArrayList<>(list.values());
            SaveToFile(l);
        }
    }

    private static void SaveToFile(ArrayList<BanknoteItem> l) {
        try {
            var fos = new FileOutputStream(filePath);
            var oos = new ObjectOutputStream(fos);
            oos.writeObject(l);
            oos. close();
            fos. close();
        }catch (Exception e){
            // ignore
        }
    }

    private static ArrayList<BanknoteItem> ReadFromFile(){
        try {
            var fis = new FileInputStream(filePath);
            var ois = new ObjectInputStream(fis);
            var result = (ArrayList<BanknoteItem>) ois.readObject();
            ois.close();
            fis.close();
            return result;
        }catch (Exception e){
            //ignore
            return new ArrayList<>();
        }
    }

    public static HashMap<Integer, BanknoteItem> GetMoney(){
        var list = ReadFromFile();
        var rr = new HashMap<Integer, BanknoteItem>();
        for(var item:list) {
            rr.put(item.getMoneyValue(), item);
        }
        return rr;
    }
}
