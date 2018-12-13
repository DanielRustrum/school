/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package lightsout;

import java.io.File;
import java.io.*;


public class LightsOutFileLoader {
    String read;
    FileReader fr;
    public void load(LightsOut game,File inputFile){
        try {
            fr = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(fr);
            try{ 
                // Initialize Line Reader Varibles
                int sizeOfPuzzle = 0;
                // Initilize current Line
                String currentLine;
                // Initialize Lights Out Puzzle Base On Files
                while ((currentLine = br.readLine()) != null) {
                    for(int i = 0; i < currentLine.length(); i++) {
                        if(currentLine.charAt(i) != 'X' || currentLine.charAt(i) != '_') {
                            throw new UnsupportedLightsOutFileException("Unsupported File/n");
                        }
                    }
                    sizeOfPuzzle++;
                }
                // Initilize J
                int j = 0;
                // Get Characters From File
                while ((currentLine = br.readLine()) != null) {
                    char currentCharacter = ' ';
                    for (int i = 0; i < currentLine.length(); i++) {
                        currentCharacter = currentLine.charAt(i);
                        if (currentCharacter == 'X') {
                            game.forceLit(j, i, true);
                        }
                    }
                    j++;
                }
            }
            catch (UnsupportedLightsOutFileException e){
                System.out.print(e);
                fr.close();
            }
        } catch(IOException e) {
            System.out.print("Error while opening file/n");           
        }
    }
}    
