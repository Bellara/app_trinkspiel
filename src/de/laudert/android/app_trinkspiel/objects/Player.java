package de.laudert.android.app_trinkspiel.objects;

/**
 * Created by Maren on 19.03.14.
 */
public class Player {

    public String name;
    public int credits;

    public Player(String name) {
        this.name = name;
        this.credits = 0;
    }

    public void increaseCredits(){
        credits++;
    }
}
