package main;

import service.WeatherSimulator;
import model.WeatherRecord;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WeatherSimulator sim = new WeatherSimulator();
        Scanner in = new Scanner(System.in);
        System.out.print("Days to simulate: "); int d = Integer.parseInt(in.nextLine());
        System.out.print("Base temp (C): "); double t = Double.parseDouble(in.nextLine());
        List<WeatherRecord> recs = sim.simulateDays(d, t);
        System.out.println("\nRecords:");
        recs.forEach(System.out::println);
        System.out.println("\nASCII Chart:");
        System.out.println(sim.asciiTempChart(recs));
    }
}

