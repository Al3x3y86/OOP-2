import transport.Car;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание Human");

        Human Maksim = new Human (1988, " Максим", " Минск", " бренд-менеджером");
        Maksim.printHuman();
        Human Anya = new Human (1993," Аня"," Москва", " методистом образовательных программ");
        Anya.printHuman();
        Human Katya = new Human (1992, " Катя", " Калиниград", " продакт-менеджером");
        Katya.printHuman();
        Human Artem = new Human (1995, " Артем", " Москва", " директором по развитию бизнеса");
        Artem.printHuman();
        Human Vladimir = new Human (2001, " Владимир", " Казань", " ");
        Vladimir.printHuman();

        System.out.println("Задание Car");

        Car Lada = new Car("Lada","Granta", 1.7,"желтый",2015,"Россия",
                "МКПП", "", "к123кк123", 4, false,
                new Car.Key(false,false), new Car.Insurance(LocalDate.now(),7000,"9876543231"));
        Lada.printCar();
        Lada.getInsurance().checkInsuranceNumber();
        Lada.getInsurance().checkValidity();

        Car Audi = new Car("Audi","A8 50L TDI quattro", 3.0,"черный",
                2020,"Германия");
        Audi.printCar();
        Audi.getInsurance().checkInsuranceNumber();
        Audi.getInsurance().getValidity();

        Car BMW = new Car("BMW","Z8", 3.0,"черный",2021,"Германия");
        BMW.printCar();
        BMW.getInsurance().checkInsuranceNumber();
        BMW.getInsurance().getValidity();

        Car KIA = new Car("KIA","Sportage 4-го поколения", 2.4,"красный",
                2018,"Южная Корея", "", "кроссовер", "с186с186",
                -4, true,new Car.Key(true, true),
                new Car.Insurance(LocalDate.of(2022,11,18), 13000, "123459876"));
        KIA.printCar();
        KIA.getInsurance().checkInsuranceNumber();
        KIA.getInsurance().getValidity();

        Car Hyundai = new Car("Hyundai","Avante", 1.6,"оранжевый",
                2016,"Южная Корея");
        Hyundai.printCar();
        Hyundai.getInsurance().checkInsuranceNumber();
        Hyundai.getInsurance().getValidity();

        System.out.println("Задание Flower");

        Flower rose = new Flower(null, "Голландия", 35.59);
        rose.printFlower();
        Flower chrysanthemum = new Flower(null, null, 15);
        chrysanthemum.lifeSpan = 5;
        chrysanthemum.printFlower();
        Flower peony = new Flower(null, "Англия", 69.9);
        peony.lifeSpan = 1;
        peony.printFlower();
        Flower gypsophila = new Flower(null, "Турция", 19.5);
        gypsophila.lifeSpan = 10;
        gypsophila.printFlower();

        System.out.println();

        Flower.printCostOfBouquet(rose,rose,rose,chrysanthemum,chrysanthemum,chrysanthemum,
                chrysanthemum,chrysanthemum,gypsophila);


    }
}