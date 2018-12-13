/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgarena;

/**
 *
 * @author dtr63
 */
public class Announcer {
    public void stats(Contestant contestant) {
            System.out.println( contestant.getClassType() + "(" + contestant.getHealth() + ")");
    }
    
    public void attack(int damage, String damageType, Contestant attacker, Contestant victim) {
            System.out.println(victim.getClasstype() + "(" + contestant[i].getHealth()
            + ") takes " + damage + " " + damageType + " from " + attacker.getClassType());
    }
    
    public void winner(Contestant[] contestant){
        for(int i = 0; i < 6; i++) {
            if(contestant[i].isAlive) {
                    System.out.println("Winner: "+ contestant[i].getClassType() 
                    + " (" + contestant[i].getHealth() + ")");
            }
        }
    }
}
