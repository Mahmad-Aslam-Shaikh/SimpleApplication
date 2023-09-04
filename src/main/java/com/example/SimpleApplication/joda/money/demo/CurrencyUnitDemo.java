package com.example.SimpleApplication.joda.money.demo;

import org.joda.money.CurrencyUnit;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class CurrencyUnitDemo {

    public static void main(String[] args) {

        CurrencyUnit ind = CurrencyUnit.ofCountry("IN");
        CurrencyUnit chn = CurrencyUnit.ofCountry("CN");

        System.out.println("Country code: " + ind.getCountryCodes());
        System.out.println("Currency code: " + ind.getCode());
        System.out.println("Numeric code: " + ind.getNumericCode());
        System.out.println("Symbol: " + ind.getSymbol() + ind.getSymbol(Locale.ENGLISH));
        System.out.println("Numeric Symbol: " + ind.getNumeric3Code());
        System.out.println("Decimal Places: " + ind.getDecimalPlaces());
        boolean pseudoCurrency =
                ind.isPseudoCurrency();
        String indSymbol = ind.getSymbol();

        // CurrencyUnit is from joda.money
        List<CurrencyUnit> registeredCurrencies = CurrencyUnit.registeredCurrencies();

        // Currency is form java.util
        Set<Currency> availableCurrencies = Currency.getAvailableCurrencies();

        for (int i = 0; i < registeredCurrencies.size(); i++) {
            CurrencyUnit currentCurrency = registeredCurrencies.get(i);




            if ("INR".equals(registeredCurrencies.get(i).getCode())) {
                System.out.println(i);
                break;
            }
        }


        int inrIndex = registeredCurrencies.indexOf("INR");

        List<String> registeredCountries = CurrencyUnit.registeredCountries();

    }
}
