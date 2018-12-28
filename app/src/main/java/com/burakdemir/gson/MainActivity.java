package com.burakdemir.gson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// Gson, Java Nesnelerini JSON temsillerine dönüştürmek için kullanılabilecek bir Java kütüphanesidir
// Bir JSON dizesini eşdeğer bir Java nesnesine dönüştürmek için de kullanılabilir.
// Gson, Google tarafından oluşturulan ve google projelerinde kullanılmış bir kütüphanedir.
// Birçok sayıda açık kaynak kodlu bu dönüşümü yapan kütüphaneler var fakat bunlarda birkaç sorun var
// Birçoğu sınıfarına Java annotation'ları koymanı gerektirir kaynak koda erişimin yoksa bunu yapamazsın
// Birçoğu Javada generic yapıları tam anlamıyla desteklemez
// Gson da bu problemler aşıldığı için kullanılması mantıklı bir kütüphanedir

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jsonFiledanVeriOku();
    }

    private void modeldenJsonOlustur() {

        Person person = new Person();
        person.setName("Burak");
        person.setSurname("Demir");

        Person person2 = new Person();
        person2.setName("Serkan");
        person2.setSurname("Yılmaz");

        Person person3 = new Person();
        person3.setName("Mahmut");
        person3.setSurname("Erdem");

        // tek bir obje üzerinden JsonObject oluşturabildiğin gibi bir liste içerisine atıp aynı şekilde JsonArray'de elde edebilirsin
        List<Person> personList = new ArrayList<>();
        personList.add(person);
        personList.add(person2);
        personList.add(person3);

        String json = new Gson().toJson(personList);
        Log.d("etiket", json);
    }

    private void jsonFiledanVeriOku() {

        try {
            InputStream is = MainActivity.this.getResources().openRawResource(R.raw.json_file);

            Gson gson = new Gson();
            JsonParser parser = new JsonParser();  // json ayrıştırıcısı
            JsonArray jsonArray = (JsonArray) parser.parse(new InputStreamReader(is, "UTF-8")); // Burada beklediğimiz değer bir JsonArray

            for (int i = 0; i < jsonArray.size(); i++) { // JsonArray'in her bir dizisinde bulunan objeleri geziyor

                JsonElement obj = jsonArray.get(i); // alınan objeler buray atılıyor
                Person person = gson.fromJson(obj, Person.class); // sınıfla denk olduğu için doğrudan Gson, Json -> Model dönüşümü yapıyor

                Log.d("etiket", person.getSurname());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
