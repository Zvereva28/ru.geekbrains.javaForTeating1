package javaForTesting1;

public abstract class Fruit {
    private Float fruitWt;

    public Fruit(Float fruitWt) {
        this.fruitWt = fruitWt;
    }


    public Float getFruitWt() {
        return fruitWt;
    }
}
