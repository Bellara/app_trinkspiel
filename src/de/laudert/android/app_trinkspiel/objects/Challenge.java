package de.laudert.android.app_trinkspiel.objects;

/**
 * Created by Maren on 19.03.14.
 */
public class Challenge {

    public String title;
    public String text;
    public int points;

    public Challenge(String title, String text, int points) {
        this.title = title;
        this.text = text;
        this.points = points;
    }
}
