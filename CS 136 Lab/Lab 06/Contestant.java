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
public abstract class Contestant {
    public int health = 0;
    protected int damage = 0;
    public String damage_type = "";
    protected String target = "";
    
    public void setHealth(int health){
        this.health = health;
    }
    
    public void setHealth(int lowVal, int highVal) {
        Random rand = new Random();
        int checkNumber = 0;
        while(checkNumber < lowVal){
            checkNumber = rand.nextInt(highVal+1);
        }
        this.setHealth(checkNumber);
    }
    
    public int getHealth() {
        return this.health;
    }
    
    public abstract void attack();
    
    public void takeDamage(int attack, String type) {
        int damaged = this.getHealth() - (attack);
        this.setHealth(damaged);
    }
    
    public boolean isDead() {
        if(health <= 0) {return true;}
        return false;
    }

    public void deathToll(Contestant contestant){}
}
