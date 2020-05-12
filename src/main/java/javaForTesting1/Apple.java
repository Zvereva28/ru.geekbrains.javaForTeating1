package javaForTesting1;

public class Apple extends Fruit {
    // Float orangeWt;
     Float appleWt;

    public Apple (Float fruitWt){
        super(fruitWt);
        appleWt = fruitWt;
    }

//    public Float getWt() {
//        return appleWt;
//    }
// set не нужен т.к. фрукт не может менять свой вес

}
