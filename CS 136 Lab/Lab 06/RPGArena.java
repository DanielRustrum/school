package rpgarena;

public class RPGArena {
    public static void main(String[] args) {
        // Initialize Announcer
        Announcer announce = new Announcer();
        // Initialize Contestants
        Contestant[] contestants = new Contestant[6];
            // Berserker
            Berserker b1 = new Berserker();
            announce.stats(b1);
            Berserker b2 = new Berserker();
            announce.stats(b1);

            // Warrior
            Warrior w1 = new Warrior();
            announce.stats(w1);
            Warrior w2 = new Warrior();
            announce.stats(w2);

            // Mage
            Mage m1 = new Mage();
            announce.stats(m1);
            Mage m2 = new Mage();
            announce.stats(m2);
            // Add To Contestants Array
            contestants[0] = b1;
            contestants[1] = b2;
            contestants[2] = w1;
            contestants[3] = w2;
            contestants[4] = m1;
            contestants[5] = m2;

        // Loop Varibles
        boolean roundWon = false;
        int contestantsAlive = 0;
        // Loop While
        while (!roundWon) {
            // Attack
            for(int i = 0; i < 6; i++){
                contestants[i].attack();
            }

            // Check for number of contestants
            for (int i = 0; i < 6; i++) {
                if (!contestants[i].isDead()) {
                    contestantsAlive++;
                }
            }

            // Check If Round has Ended
            if(contestantsAlive < 2){
                roundWon = true;
            }
        }
    }
}
