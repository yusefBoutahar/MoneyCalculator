package moneycalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 *
 * @author boutahar
 */
public class MoneyCalculator {
	

	/** 
	 * VERSION PRINCIPAL 
    public static void main(String[] args) throws IOException {
        System.out.println("Introduce una cantidad de dolares: ");
        Scanner scanner = new Scanner(System.in);
        double amount = scanner.nextDouble();
        double exchangerate = getExchangeRate("USD","EUR");
        System.out.println(amount + " USD equivalen a " + amount*exchangerate + " EUR");
    }

    private static double getExchangeRate(String from, String to) throws IOException {
        URL url = 
            new URL("http://free.currencyconverterapi.com/api/v5/convert?q=" +
                    from + "_" + to + "&compact=y");
        URLConnection connection = url.openConnection();
        try (BufferedReader reader = 
                new BufferedReader(
                        new InputStreamReader(connection.getInputStream()))) {
            String line = reader.readLine();
            String line1 = line.substring(line.indexOf(to)+12, line.indexOf("}"));
            return Double.parseDouble(line1);
        }
    }
	*/
	
	/*
	// version 2
	double amount;
    double exchangerate;
    
    public static void main(String[] args) throws IOException {
        MoneyCalculator moneycalculator = new MoneyCalculator();
        moneycalculator.control();
    }

    private static double getExchangeRate(String from, String to) throws IOException {
        URL url = 
            new URL("http://free.currencyconverterapi.com/api/v5/convert?q=" +
                    from + "_" + to + "&compact=y");
        URLConnection connection = url.openConnection();
        try (BufferedReader reader = 
                new BufferedReader(
                        new InputStreamReader(connection.getInputStream()))) {
            String line = reader.readLine();
            String line1 = line.substring(line.indexOf(to)+12, line.indexOf("}"));
            return Double.parseDouble(line1);
        }
    }

    private void control() throws IOException {
        input();
        process();
        output();
    }

    private void input() {
        System.out.println("Introduce una cantidad de dolares: ");
        Scanner scanner = new Scanner(System.in);
        amount = scanner.nextDouble();
    }

    private void process() throws IOException {
        exchangerate = getExchangeRate("USD","EUR");
    }

    private void output() {
        System.out.println(amount + " USD equivalen a " +
			amount*exchangerate + " EUR");
    }
	*/
	
	
	/*
	// version 2.1
	// Introducir la cantidad inicial en cualquier divisa y lugo se pasa a EUR
	double amount;
    double exchangerate;
    String currency;
    
    public static void main(String[] args) throws IOException {
        MoneyCalculator moneycalculator = new MoneyCalculator();
        moneycalculator.control();
    }

        private void control() throws IOException {
        input();
        process();
        output();
    }

    private void input() {
        System.out.println("Introduce una cantidad: ");
        Scanner scanner = new Scanner(System.in);
        amount = scanner.nextDouble();
        
        System.out.println("Introduce una divisa: ");
        currency = scanner.next();
    }

    private void process() throws IOException {
        exchangerate = getExchangeRate(currency,"EUR");
    }

    private void output() {
        System.out.println(amount + " " + currency + " = " +
                amount*exchangerate + " €");
    }
    
    private static double getExchangeRate(String from, String to) throws IOException {
        URL url = 
            new URL("http://free.currencyconverterapi.com/api/v5/convert?q=" +
                    from + "_" + to + "&compact=y");
        URLConnection connection = url.openConnection();
        try (BufferedReader reader = 
                new BufferedReader(
                        new InputStreamReader(connection.getInputStream()))) {
            String line = reader.readLine();
            String line1 = line.substring(line.indexOf(to)+12, line.indexOf("}"));
            return Double.parseDouble(line1);
        }
    }
	*/
	
	
	/*
	//VERSIÓN 2.2. Introducir la cantidad inicial en cualquier divisa y
	//especificar la divisa a la que se desea convertir
	double amount;
    double exchangerate;
    String currencyFrom;
    String currencyTo;
    
    public static void main(String[] args) throws IOException {
        MoneyCalculator moneycalculator = new MoneyCalculator();
        moneycalculator.control();
    }

    private void control() throws IOException {
        input();
        process();
        output();
    }

    private void input() {
        System.out.println("Introduce una cantidad: ");
        Scanner scanner = new Scanner(System.in);
        amount = scanner.nextDouble();
        
        System.out.println("Introduce una divisa inicial: ");
        currencyFrom = scanner.next();
        
        System.out.println("Introduce una divisa final: ");
        currencyTo = scanner.next();
    }

    private void process() throws IOException {
        exchangerate = getExchangeRate(currencyFrom,currencyTo);
    }

    private void output() {
        System.out.println(amount + " " + currencyFrom + " = " +
                amount*exchangerate + currencyTo);
    }

    private static double getExchangeRate(String from, String to) throws IOException {
        URL url = 
            new URL("http://free.currencyconverterapi.com/api/v5/convert?q=" +
                    from + "_" + to + "&compact=y");
        URLConnection connection = url.openConnection();
        try (BufferedReader reader = 
                new BufferedReader(
                        new InputStreamReader(connection.getInputStream()))) {
            String line = reader.readLine();
            String line1 = line.substring(line.indexOf(to)+12, line.indexOf("}"));
            return Double.parseDouble(line1);
        }
    }
	*/
}
