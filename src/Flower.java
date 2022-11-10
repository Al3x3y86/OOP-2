public class Flower {

    private String flowerColor;
    private String country;
    private double cost;
    public int lifeSpan;

    public Flower(String flowerColor, String country, double cost, int lifeSpan) {
        if (flowerColor == null || flowerColor.isEmpty() || flowerColor.isBlank()) {
            this.flowerColor = "белый";
        } else {
            this.flowerColor = flowerColor;
        }
        if (country == null || country.isEmpty() || country.isBlank()) {
            this.country = "Россия";
        } else {
            this.country = country;
        }
        if (cost <= 0) {
            this.cost = 1;
        } else {
            this.cost = cost;
        }
        if (lifeSpan <= 0) {
            this.lifeSpan = 3;
        }else {
            this.lifeSpan = lifeSpan;
        }
    }

    public Flower(String flowerColor, String country, double cost) {
        this(flowerColor, country, cost, 3);
    }

    public String getFlowerColor() {
        return flowerColor;
    }

    public void setFlowerColor(String flowerColor) {
        if (flowerColor == null || flowerColor.isEmpty() || flowerColor.isBlank()) {
            this.flowerColor = "белый";
        } else {
            this.flowerColor = flowerColor;
        }
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (country == null || country.isEmpty() || country.isBlank()) {
            this.country = "Россия";
        } else {
            this.country = country;
        }
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        if (cost < 0) {
            this.cost = 1;
        } else {
            this.cost = cost;
        }
    }

    void printFlower() {
        System.out.println("Цвет: "+flowerColor+
                ", страна: " +country+
                ", стоимость штуки: " +cost+
                ", срок стояния: "+lifeSpan);
    }

    public static void printCostOfBouquet (Flower... Bouquet){
        double totalCost =0;
        int minLifeSpan = Integer.MAX_VALUE;
        for (Flower flower: Bouquet){
            if(flower.lifeSpan < minLifeSpan){
                minLifeSpan = flower.lifeSpan;
            }
            totalCost += flower.getCost();
        }
        totalCost = totalCost * 1.1;
        System.out.println("Стоимость букета: " + totalCost);
        System.out.println("Срок стояния букета: " + minLifeSpan);
    }
}
