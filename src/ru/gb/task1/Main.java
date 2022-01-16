package ru.gb.task1;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person.Builder()
                .addFirstName("Ivan")
                .addMiddleName("Ivanovi4")
                .addLastName("Ivanov")
                .addAddress("address")
                .addPhone("23424234")
                .addCountry("Russia")
                .addAge(22)
                .addGender("Female")
                .build();

        System.out.println(person1.toString());
    }
}
