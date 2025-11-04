package org.example;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        return (name.length() >= 3 &
                name.length() < 20 &
                name.matches("^[а-яёА-ЯЁ]+( [а-яёА-ЯЁ]+)$") &
                name.trim().equals(name));
        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */
    }

}