package moneycalculator;

import moneycalculator_model.Currency;
import moneycalculator_model.CurrencyList;
import moneycalculator_model.ExchangeRate;
import moneycalculator_model.Money;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class MoneyCalculator {
    public static void main(String[] args) throws Exception {
      MoneyCalculator moneyCalculator = new MoneyCalculator();
      moneyCalculator.execute();       
    }

    private final CurrencyList currencyList;
    private Money money;
    private Currency currencyTo;
    private ExchangeRate exchangeRate;

    public MoneyCalculator() {
        this.currencyList = new CurrencyList();
    }
    
    private void execute() throws Exception{
        input();
        process();
        output();
    }

    private void input(){
        System.out.println("Introduzca cantidad");
        Scanner scanner = new Scanner(System.in);
        double amount = Double.parseDouble(scanner.next());
        
        while (true) {
            System.out.println("Introduzca c�digo divisa origen");
            Currency currency = currencyList.get(scanner.next().toUpperCase());
            money = new Money(amount, currency);
            if (currency != null) break;
            System.out.println("Divisa no conocida");
        }

        while (true) {
            System.out.println("Introduzca codigo divisa destino");
            currencyTo = currencyList.get(scanner.next().toUpperCase());
            if (currencyTo != null) break;
            System.out.println("Divisa no conocida");
        }
    }
    
    private void process() throws Exception{
        exchangeRate = getExchangeRate(money.getCurrency(), currencyTo);
    }
    
    private void output(){
        System.out.println(money.getAmount() + " " 
                + money.getCurrency().getSymbol() + " equivalen a "
                + money.getAmount() * exchangeRate.getRate() + " "
                + currencyTo.getSymbol());
    }
    
    private static ExchangeRate getExchangeRate(Currency from, Currency to) 
            throws IOException {
        URL url = 
            new URL("http://free.currencyconverterapi.com/api/v5/convert?q=" +
                    from.getCode() + "_" + to.getCode() + "&compact=y");
        URLConnection connection = url.openConnection();
        try (BufferedReader reader = 
                new BufferedReader(
                        new InputStreamReader(connection.getInputStream()))) {
            String line = reader.readLine();
            String line1 = line.substring(line.indexOf(to.getCode())+12, line.indexOf("}"));
            return new ExchangeRate(from, to, 
                    LocalDate.of(2018, Month.SEPTEMBER, 26), 
                    Double.parseDouble(line1));
        }
    }
}