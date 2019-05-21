package com.wyj.entity.po;

import java.io.Serializable;

public class Message implements Serializable {

    private int id;
    private String city;
    private String time;
    private String weather;

    public Message() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", time='" + time + '\'' +
                ", weather='" + weather + '\'' +
                '}';
    }
}
