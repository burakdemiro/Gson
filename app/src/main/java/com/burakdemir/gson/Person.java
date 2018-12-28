package com.burakdemir.gson;

import com.google.gson.annotations.SerializedName;

public class Person {

    // Bu sınıf, bir kişinin adını ve soyismini temsil eden iki field'a sahiptir.
    // Bu alanlara @SerializedName ek açıklaması eklenmiştir.
    // Bu ek açıklamanın parametresi (değeri), nesnelerin serileştirilmesi ve Deserileştirme hale getirilmesi sırasında kullanılacak addır.
    // Bu annotation, Gson nesnesinde uygulandığında geçerli field adını override eder
    // Json üzerinde name alanı -> n olarak gösterilecektir. ve tekrar deserileştirme işleminde n -> name olarak dönecektir.
    // Özellikle database işlemlerinde az karakter kullanmak veri transferini hızlandırmada ve veri tasarrufunda iyi bir teknik olduğu
    // için field'a "n" gibi bir alan adı vermek kodun okunurluğunu azaltacaktır. Bu durumda @SerializedName("n") annotation'ı kullanmak pratiklik sağlar
    @SerializedName("n")
    private String name;
    @SerializedName("s")
    private String surname;

    public Person() {
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
