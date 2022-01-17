package ru.gb.task2;

public class Task2 {
    interface Moveable {
        void move();
    }

    interface Stopable {
        void stop();
    }
    //интерыейсы Moveable и Stopable должны быть объединены в один (например Rideable), тк семантически реализуют общее поведение - спообность двигаться.

    interface Rideable {
        void move();
        void stop();
    }
    //Создал класс Engine чтобы не было ошибок типа данных
    private class Engine{
        private String type;

        public Engine (String type){
            this.type = type;
        }
    }

    //abstract class Car {   //Класс должен реализовать классы Moveable и Stopable если реализует метожды start() stop()

    abstract class Car implements Rideable{
        private Engine engine;
        private String color;
        private String name;


        public void move() {
            System.out.println("Car starting");
        }

        public void stop() {
            System.out.println("Car stopping");
        }

        abstract void open();

        public Engine getEngine() {
            return engine;
        }

        public void setEngine(Engine engine) {
            this.engine = engine;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    //class LightWeightCar extends Car implements Moveable{

    class LightWeightCar extends Car{

        @Override
        void open() {
            System.out.println("Car is open");
        }

    }

    //class Lorry extends Car, Moveable, Stopable{

    class Lorry extends Car{

        @Override
        void open() {

        }

    }

}
