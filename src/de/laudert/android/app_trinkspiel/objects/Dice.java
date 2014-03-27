package de.laudert.android.app_trinkspiel.objects;

import java.util.Random;

/**
 * Created by Maren on 27.03.14.
 */
public class Dice {

    public int throwDice(){
        Random random = new Random();
        return random.nextInt(6);
    }

}
