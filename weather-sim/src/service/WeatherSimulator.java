package service;

import model.WeatherRecord;

import java.time.LocalDate;
import java.util.*;

public class WeatherSimulator {
    private Random rnd = new Random();

    public List<WeatherRecord> simulateDays(int days, double baseTemp) {
        List<WeatherRecord> out = new ArrayList<>();
        LocalDate d = LocalDate.now();
        for (int i=0;i<days;i++) {
            double temp = baseTemp + rnd.nextGaussian()*3;
            double humidity = 40 + rnd.nextDouble()*60;
            double wind = rnd.nextDouble()*10;
            out.add(new WeatherRecord(d.plusDays(i).toString(), temp, humidity, wind));
        }
        return out;
    }

    public String asciiTempChart(List<WeatherRecord> recs) {
        StringBuilder sb = new StringBuilder();
        for (WeatherRecord r : recs) {
            int len = (int) (r.getTemp() + 10); // shift
            sb.append(r.getDate()).append(" ");
            for (int i=0;i<len;i++) sb.append("*");
            sb.append(" ").append(String.format("%.1f", r.getTemp())).append("C\n");
        }
        return sb.toString();
    }
}

