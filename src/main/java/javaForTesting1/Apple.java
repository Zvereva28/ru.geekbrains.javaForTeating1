package javaForTesting1;

public class Apple extends Fruit {
    Float appleWt;

    public Apple (Float fruitWt){
        super(fruitWt);
        appleWt = fruitWt;
    }
// set не нужен т.к. фрукт не может менять свой вес
}
