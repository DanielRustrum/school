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
public class Warrior extends Contestant {
    private String classType = "A disciplined Warrior";

    Warrior() {
        super.setHealth(20, 40);
    }
    
    public String getClassType() {
        return classType;
    }

    private int checkTargets(Contestant[] contestants) {
        int victimIndex = 0;
        int highestHealth = 0;
        for(int i = 0; i < 6; i++){
            if(contestants[i].getHealth() > highestHealth){
                highestHealth = contestants[i].getHealth();
                victimIndex = i;
            }
        }
        return victimIndex;
    }
    
    @Override
    public void attack(Contestant[] contestants, Contestant thisContestant) {
        Announcer announce = new Announcer();
        Random rand = new Random();
        int attack = rand.nextInt(17);
        while (attack < 10) {
            attack = rand.nextInt(17);
        }
        int target = this.checkTargets(contestants);
        contestants[target].takeDamage(attack, "slash");
        announce.attack(attack, "slashing", thisContestant, contestants[target]);
        contestants[target].deathToll(thisContestant);
    }
    
    @Override
    public void takeDamage(int attack, String type) {
        boolean dodged = false;
        Random rand = new Random();
        int chance = rand.nextInt(4);
        if(chance == 3) {
            dodged = true;
        }
        if(type == "smash" && !dodged){
            super.takeDamage(attack, "");
        }
        if(type == "slash" && !dodged){
            super.takeDamage(attack, "");
        }
    }
}
