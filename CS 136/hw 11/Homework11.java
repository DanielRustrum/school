/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework.pkg11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author danielrustrum
 */
public class Homework11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Please Enter A Suitable File");
        Scanner in = new Scanner(System.in);
        String input = in.next();
        
        String line = null;
        try {
            FileReader fileReader = 
                new FileReader(input);

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                String[] numbers = line.split("\\s+");
                float result = (Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]))/2;
                System.out.println(result);
            }

            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                input + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + input + "'");                  
        }
        finally {
            System.out.println("-------------  END  ------------");
        }
    }
}
