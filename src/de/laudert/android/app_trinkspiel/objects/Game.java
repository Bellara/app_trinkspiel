package de.laudert.android.app_trinkspiel.objects;

import java.util.ArrayList;

/**
 * Created by Maren on 19.03.14.
 */
public class Game {

    public ArrayList<Player> players;
    public ArrayList<Drink> drinks;

    public int maxPoints;
    public int challengeQuotient;
    public int round;

    public Game() {
        this.round = 0;
    }

    public void addPlayer(String name){
        if(players.isEmpty()){
            players = new ArrayList<Player>();
        }
        players.add(new Player(name));
    }

    public void addDrink(String name, String unit){
        if(drinks.isEmpty()){
            drinks = new ArrayList<Drink>();
        }
        drinks.add(new Drink(name, unit));
    }

    public boolean gameFinished(){
        for (Player player : players) {
            if (player.credits >= maxPoints) {
                return true;
            }
        }
        return false;
    }
}
