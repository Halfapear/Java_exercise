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
 * @
 */
public class CatTest {
    public static void main(String[] args) {
        Cat myCat = new Cat();
	myCat.name = "Napoleon";
        myCat.furType = "short";
        myCat.tail = true;
        myCat.colour = Color.ORANGE;
        myCat.speed = 300; // in metres per minute
        
	myCat.sleep(5);
        int numMetres = myCat.run(10, true);
	System.out.println("I have run " + numMetres + " metres.");	
    }
}