package transport;

import java.time.LocalDate;

public class Car {
    private final String brand;
    private final String model;
    private double engineVolume;
    private  String color;
    private final int year;
    private final String country;
    private String transmission;
    private final String bodyType;
    private String registrationNumber;
    private final int numberOfSeats;
    private boolean summerOrWinterTires;
    private Key key;
    private Insurance insurance;

    public Car(String brand, String model, double engineVolume, String color, int year, String country,
               String transmission,  String bodyType, String registrationNumber, int numberOfSeats,
               boolean summerOrWinterTires, Key key, Insurance insurance) {
        if (brand == null || brand.isEmpty() || brand.isBlank()) {
            this.brand = "default";
        } else {
            this.brand = brand;
        }
        if (model == null || model.isEmpty() || model.isBlank()) {
            this.model = "default";
        } else {
            this.model = model;
        }
        if (Double.compare(engineVolume, 0) <= 0) {
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }
        if (color == null || color.isEmpty() || color.isBlank()) {
            this.color = "белый";
        } else {
            this.color = color;
        }
        if (year <= 0) {
            this.year = 2000;
        } else {
            this.year = year;
        }
        if (country == null || country.isEmpty() || country.isBlank()) {
            this.country = "default";
        } else {
            this.country = country;
        }
        if (transmission == null || transmission.isEmpty() || transmission.isBlank()) {
            this.transmission = "АКПП";
        } else {
            this.transmission = transmission;
        }
        if (bodyType == null || bodyType.isEmpty() || bodyType.isBlank()) {
            this.bodyType = "седан";
        } else {
            this.bodyType = bodyType;
        }
        if (registrationNumber == null || registrationNumber.isEmpty()
                || registrationNumber.isBlank() || registrationNumber.length() != 9 ) {
            this.registrationNumber = "х000хх000";
        } else {
            this.registrationNumber = registrationNumber;
        }
        if (numberOfSeats <= 0) {
            this.numberOfSeats = 5;
        } else {
            this.numberOfSeats = numberOfSeats;
        }
        if (key == null) {
            this.key = new Key();
        } else {
            this.key = key;
        }
        if (insurance == null) {
            this.insurance = new Insurance();
        } else {
            this.insurance = insurance;
        }
        this.summerOrWinterTires = summerOrWinterTires;
    }

    public Car(String brand, String model, double engineVolume, String color, int year, String country){
        this(brand,model,engineVolume,color,year,country, "АКПП", "седан",
                "х000хх000", 5, true, new Key(), new Insurance());
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        if (transmission == null || transmission.isEmpty() || transmission.isBlank()) {
            this.transmission = "АКПП";
        } else {
            this.transmission = transmission;
        }
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        if (registrationNumber == null || registrationNumber.isEmpty() || registrationNumber.isBlank()) {
            this.registrationNumber = "х000хх000";
        } else {
            this.registrationNumber = registrationNumber;
        }
    }

    public boolean isSummerOrWinterTires() {
        return summerOrWinterTires;
    }

    public void setSummerOrWinterTires(boolean summerOrWinterTires) {
        this.summerOrWinterTires = summerOrWinterTires;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public String getBodyType() {
        return bodyType;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public void printCar() {
        System.out.println(brand+" "+model+ ", сборка " +country+
                ", цвет кузова — " +color+", объем двигателя — " +engineVolume+
                "л., год выпуска — "+year+ "год, коробка передач - " + transmission+
                ", тип кузова - " + bodyType + ", рег. номер - " + registrationNumber +
                ", количество мест - " + numberOfSeats + ","
                + (changeTyres(summerOrWinterTires) ? "летняя" : "зимняя" ) + " резина,"
                + (getKey().keylessEntry ? " доступ без ключа" : " доступ с ключем" )
                + (getKey().remoteEngineStart ? ", удаленный запуск" : ", запуск ключем")
                + ", номер страховки - " + getInsurance().insuranceNumber
                + ", стоимость страховки - " + getInsurance().cost
                + ", срок действия страховки - " + getInsurance().validity );
    }

    public boolean changeTyres (boolean summerOrWinterTires){
        this.summerOrWinterTires = !this.summerOrWinterTires;
        return summerOrWinterTires;
    }

    public boolean checkRegistrationNumber (){
        if (registrationNumber.length() != 9){
            return false;
        }
        char [] chars = registrationNumber.toCharArray();
        if (!Character.isAlphabetic(chars[0]) || !Character.isAlphabetic(chars[4])
                || !Character.isAlphabetic(chars[5])){
            return false;
        }
        return Character.isDigit(chars[1]) && Character.isDigit(chars[2]) && Character.isDigit(chars[3]) &&
                Character.isDigit(chars[6]) && Character.isDigit(chars[7]) && Character.isDigit(chars[8]);
    }

    public static class Key {

        private final boolean remoteEngineStart;
        private final boolean keylessEntry;

        public Key(boolean remoteEngineStart, boolean keylessEntry) {
            this.remoteEngineStart = remoteEngineStart;
            this.keylessEntry = keylessEntry;
        }

        public Key() {
            this( false,false);
        }

        public boolean isRemoteEngineStart() {
            return remoteEngineStart;
        }

        public boolean isKeylessEntry() {
            return keylessEntry;
        }
    }

    public static class Insurance {

        private final LocalDate validity;
        private final double cost;
        private  final  String insuranceNumber;

        public Insurance(LocalDate validity, double cost, String insuranceNumber) {
            if (validity == null ) {
                this.validity = LocalDate.now().plusDays(365);
            } else {
                this.validity = validity;
            }
            this.cost = cost;
            if (insuranceNumber == null) {
                this.insuranceNumber = "123456789";
            } else {
                this.insuranceNumber = insuranceNumber;
            }

        }
        public Insurance(){
            this (null, 5000,null);
        }

        public LocalDate getValidity() {
            return validity;
        }

        public double getCost() {
            return cost;
        }

        public String getInsuranceNumber() {
            return insuranceNumber;
        }

        public void checkValidity() {
            if (validity.isBefore(LocalDate.now()) || validity.isEqual(LocalDate.now())) ;
            System.out.println("Нужно срочно ехать оформлять новую страховку!");
        }

        public void checkInsuranceNumber(){
            if (insuranceNumber.length()!=9){
                System.out.println("Номер страховки некорректный!");
            }
        }
    }


}
