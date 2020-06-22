package com.hfad.weatherapp.Helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Helper {

    static String stream = null;

    public Helper(){

    }


    // Задаем запрос по url адресу и читаем данные
    public String getHTTPData(String urlString){
        try {
            URL url = new URL(urlString); // создаем  соединение, посредством указания адресса. Если адрес написан не правильно,
            // вываливается исключение  MalformedURLException
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection(); // соединяемся по протоколу http
            if(httpURLConnection.getResponseCode() == 200){ // соединение установленно верно
                BufferedReader r = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream())); // читает текст из потока символов по url соединению
                // и складывает в буффер в виде символов. Исп буффер удобней т.к экономит много ресурсов
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = r.readLine()) != null){ // считываем данные при помощи bufferreader не по одному символу, а целыми строками, пока не появится нулевая строка
                    sb.append(line);
                }
                stream = sb.toString();
                httpURLConnection.disconnect();
            }
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return  stream;
    }

}
