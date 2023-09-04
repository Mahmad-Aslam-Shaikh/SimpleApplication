package com.example.SimpleApplication.joda.money.demo;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.math.RoundingMode;
import java.util.ArrayList;

public class MoneyDemo {

    public static void main(String[] args) {

        CurrencyUnit ind = CurrencyUnit.ofCountry("IN");
        CurrencyUnit usd = CurrencyUnit.ofCountry("US");
        Money inr = Money.of(ind, 24.51);
//        Money zeroInr = Money.zero(ind);

        System.out.println("Amount: " + inr.getAmount());
        System.out.println("Amount Major: " + inr.getAmountMajor());
        System.out.println("Amount Minor: " + inr.getAmountMinor());
        System.out.println("Minor part: " + inr.getMinorPart());
        System.out.println("Scale " + inr.getScale());
        System.out.println(inr);

        Money checkMoney = Money.ofMinor(ind, inr.getAmountMinorLong());
        System.out.println(checkMoney);

        ArrayList<Money> monies = new ArrayList<>();
        monies.add(inr);
        monies.add(checkMoney);

        Money totalMoney = Money.total(monies);

        boolean result = inr.equals(totalMoney);

        Money substractedAmount = inr.minus(4.5134, RoundingMode.valueOf(2));

        System.out.println(substractedAmount);


    }

}
