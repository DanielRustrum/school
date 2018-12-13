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
public class Mage extends Contestant {
    private String classType = "A Wild Mage";
    Mage() {
        super.setHealth(10, 60);
    }

    public String getClassType() {
        return classType;
    }
    
    @Override
    public void deathToll(Contestant contestant) {
        if(super.getHealth() <= 0){
            this.classType = "A Dead Mage";
            attacker.setHealth(contestants.getHealth() - 5);
        }
    }
    
    @Override
    public void attack(Contestant[] contestants, Contestant thisContestant) {
        Announcer announce = new Announcer();
        Random rand = new Random();
        int currentAttack;
        for(int i = 0; i < 6; i++){
            currentAttack = rand.nextInt(7);
            contestants[i].takeDamage(attack, "fire");
            announce.attack(currentAttack, "fire", thisContestant, contestants[i]);
            contestants[i].deathToll(thisContestant);
        }
    }
}
