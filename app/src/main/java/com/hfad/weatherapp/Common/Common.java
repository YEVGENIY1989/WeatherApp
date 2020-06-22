package com.hfad.weatherapp.Common;

import androidx.annotation.NonNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {

    public static String API_KEY = "b80444170fb6140f444c036b0632a7ea";
    public static String API_LINK = "http//api.openweathermap.org/data/2.5/weather";

    // Метод по запросу для api по координатом т.е широты и долготы
    @NonNull // Анотация показывает что объект не может быть null т.е не пустой
    public static String apiRequest(String lat, String lng){
        StringBuilder sb = new StringBuilder(API_LINK); // Класс позволяет вставлять символы и строки в любую подстроку
        // в нашел случае начальная строка равна API_LINK

        // String.format позволяет нам форматировать строку как нам надо, и вместо %s мы ставим значение, которые хотим добавить
        // метод append добовляет к концу строки нашу строку в скобках
        sb.append(String.format("?lat=%s&lon=%s&APPID=%s&units=metric", lat, lng, API_KEY));
        // передаем строку
        return sb.toString();
    }

    public static String unixTimeStampToDateTime(double unixTimeStamp){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm"); // форматирование времени по шаблону HH:mm , в удобной форме
        Date date = new Date(); // объект инициализируется текущем временем и датой начиная с 1 января 1970 года
        date.setTime((long) unixTimeStamp * 1000);
        return dateFormat.format(date);
    }

}
