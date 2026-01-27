package com.example.mywebapp.models;

import java.io.Serializable;

public class BanknoteItem implements Serializable {
    private int MoneyValue;
    private int Count;

    public BanknoteItem(int val, int count){
        MoneyValue = val;
        Count = count;
    }

    public BanknoteItem(){

    }

    public int getMoneyValue(){
        return MoneyValue;
    }

    public void setMoneyValue(int moneyValue){
        MoneyValue = moneyValue;
    }

    public int getCount() {
        return Count;
    }

    public void updateCount(int result) {
        Count -=result;
    }
}
