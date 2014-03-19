package de.laudert.android.app_trinkspiel.sqlite.database;

/**
 * Created by Maren on 19.03.14.
 */
public class Challenge {

    public long id;
    public String title;
    public String text;
    public int points;

    public Challenge(long id, String title, String text, int points) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.points = points;
    }

    @Override
    public String toString() {
        return "Challenge{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", points=" + points +
                '}';
    }
}
