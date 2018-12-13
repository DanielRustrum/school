/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgarena;

import java.util.Random;

/**
 *
 * @author dtr63
 */
public class Berserker extends Contestant {
    private String classType = "A raging Berserker";

    Berserker() {
        super.setHealth(35);
    }
    
    public String getClassType() {
        return classType;
    }

    @Override
    public void attack(Contestant[] contestants, Contestant thisContestant) {
        Announcer announce = new Announcer();
        int attack = 20;
        Random rand = new Random();
        int victimIndex = rand.nextInt(6);
        contestants[victimIndex].takeDamage(attack, "smash");
        announce.attack(attack, "Smashing", thisContestant, contestants[victimIndex]);
        contestants[victimIndex].deathToll(thisContestant);
    }
    
    @Override
    public void takeDamage(int attack, String type) {
        if(type == "fire"){
            int damaged = super.getHealth() - (attack/2);
            super.setHealth(damaged);
        }
        if(type == "slash"){
            int damaged = super.getHealth() - (attack*2);
            super.setHealth(damaged);
        }
        super.takeDamage(attack, "");
    }
}
