package javaForTesting1;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    ArrayList<T> fruitsInBox = new ArrayList();

    public Box(){}

    public Box(T ... fruits){
        for (T fruit : fruits) {
            this.fruitsInBox.add(fruit);
        }
    }

    public void addFruits(T... fruits){
        for (T fruit : fruits) {
            this.fruitsInBox.add(fruit);
        }
    }

    public Float getWeightBox(){
        Float sum = 0.0f;
        for (T fruit : fruitsInBox){
            sum = sum + fruit.getFruitWt();
        }
        return sum;
    }

    public boolean compare(Box anotherBox){
        return (this.getWeightBox() - anotherBox.getWeightBox()) < 0.000001f;
    }

    public void takeOutAllFruits(){
        this.fruitsInBox.clear();
        }


    public void  fromThisToAnother(Box<T> anotherBox){
       for(T fruit:this.fruitsInBox){
           anotherBox.addFruits(fruit);
       }
       this.takeOutAllFruits();
    }
}
