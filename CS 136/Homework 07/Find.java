import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Find {
    public static void main(String[] args) {
        try {
            // Loop through all args to find files
            String word = args[0];
            for(int i=1;i<args.length;i++){
                File file = new File(args[i]);
                FileReader filereader = new FileReader(file);
                BufferedReader buffer = new BufferedReader(filereader);
                String line;
                while((line = buffer.readLine()) != null) {
                   if(line.indexOf(word) >= 0){
                       System.out.println(line);
                   }
                }
                filereader.close();
                // file.close();
            }

        }
        catch(IOException e) {
            // filereader.close();
        }
    }
}