package model;

public class WeatherRecord {
    private String date;
    private double temp; // Celsius
    private double humidity;
    private double wind;

    public WeatherRecord(String date, double temp, double humidity, double wind) {
        this.date = date; this.temp = temp; this.humidity = humidity; this.wind = wind;
    }

    public String getDate() { return date; }
    public double getTemp() { return temp; }
    public double getHumidity() { return humidity; }
    public double getWind() { return wind; }

    @Override
    public String toString() {
        return date + " | T:" + String.format("%.1f", temp) + "C H:" + String.format("%.0f", humidity) + "% W:" + String.format("%.1f", wind) + "m/s";
    }
}

