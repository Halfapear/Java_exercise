package Lab3;

import java.awt.*;

/**
 * Title      : CatTest.java
 * Description: This class contains the test class for Cat.
 * Copyright  : Copyright (c) 2006 - 2025
 * @author  Laurissa Tokarchuk
 * @version 1.0
 * @author  Paula Fonseca
 * @version 1.4
 */
public class CatTest {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Tom", true, 500, "short", Color.BLACK);
        Cat cat2 = new Cat("Moggy", false, 400, "long", Color.WHITE);

        System.out.println("The first cat");

        System.out.println("My cat's name is: " + cat1.getName());
        System.out.println("color is" + cat1.getColour());

        cat1.run(10,false);
        


    }
}