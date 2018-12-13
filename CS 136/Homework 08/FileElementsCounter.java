import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * FileElementsCounter
 */
public class FileElementsCounter {

    public static void main(String[] args) {
        int words = 0;
        int lines = 0;
        int chars = 0;
        try {
            Scanner user = new Scanner(System.in);
            System.out.println("What File Do You Want To Check?");
            String wantedFile = user.next();
            Scanner file = new Scanner(wantedFile);

            while(file.hasNextLine() != EOF) {
                for(int i = 0; i < file.next().length(); i++){
                    char currentChar = file.next().charAt(i);
                    if(currentChar == ' '){
                        word++;
                    }
                    chars++;
                }
                lines++;
            }
        } catch(FileNotFoundException e) {
            System.out.println(e);
        }

        System.out.println(chars);
        System.out.println(word);
        System.out.println(lines);
    }

}