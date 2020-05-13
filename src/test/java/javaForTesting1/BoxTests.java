package javaForTesting1;

import org.junit.Assert;
import org.junit.Test;

public class BoxTests {
    @Test
    public void BoxTestOne(){
        Apple apple1 = new Apple(1.0f);
        Orange orange1 = new Orange(1.5f);

        Box<Apple> box1 = new Box<Apple>(apple1, apple1, apple1);
        Box<Orange> box2 = new Box<Orange>(orange1, orange1);
        Box<Orange> box3 = new Box<Orange>(orange1, orange1);
        Box<Orange> box4 = new Box<Orange>(orange1, orange1, orange1);
        box1.addFruits(apple1, apple1, apple1);
        //box1.addFruits(orange1);
        //box3.addFruits(apple1);
        Assert.assertTrue(box2.compare(box1));
        Assert.assertFalse(box1.compare(box3));

        System.out.println("box2 and box1  " + box2.compare(box1));
        System.out.println("box2 and box1  " + box1.compare(box3));
        System.out.println("box1  " + box1.getWeightBox());
        System.out.println("box2  " + box2.getWeightBox());
        System.out.println("box3  " + box3.getWeightBox());

        box2.fromThisToAnother(box3);
        //box1.fromThisToAnother(box4);

        Assert.assertTrue(box2.getWeightBox() == 0.0f);
        Assert.assertTrue(box3.getWeightBox() - 6.0 < 0.00001f);

        System.out.println("box2  " + box2.getWeightBox());
        System.out.println("box3  " + box3.getWeightBox());
    }
}
