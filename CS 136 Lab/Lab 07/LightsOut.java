// package lightsout;


public class LightsOut {
    private int size;
    public char[][] gameArray;
    
    
    LightsOut(int size){
        this.size = size;
        this.gameArray = new char[size][size];
    }
    
    public int getSize(){
        return size;
    }
    
    public boolean isLit(int row, int col){
        if (this.gameArray[row][col] == 'X'){
            return true;
        }else{
            return false;
        }
    }
    
    public void forceLit(int row, int col, boolean value){
        if (value == true){
            this.gameArray[row][col] = 'X';
        }else{
            this.gameArray[row][col] = '_';
        }
    }
    
    public char getCharacterInArray(int row, int col){
        return this.gameArray[row][col];
    }

    public void press(int row, int col){
        this.forceLit(row, col, !(isLit(row,col)));
        for (int i=0; i<4; i++){
            try{
                if((this.getCharacterInArray(row - 1, col) == 'X' || this.getCharacterInArray(row - 1, col) == '_') && i == 0){
                    this.forceLit(row-1, col, !(isLit(row-1,col)));
                    String button = "button: " + i;
                    System.out.println(button);
                }
                
                else if (((this.getCharacterInArray(row, col - 1) == 'X' || this.getCharacterInArray(row, col - 1) == '_') && i == 1)){
                    this.forceLit(row, col-1, !(isLit(row,col-1)));
                    String button = "button: " + i;
                    System.out.println(button);
                }
                
                else if((this.getCharacterInArray(row + 1, col) == 'X' || this.getCharacterInArray(row + 1, col) == '_') && i == 2){
                    this.forceLit(row+1, col, !(isLit(row+1,col)));
                    String button = "button: " + i;
                    System.out.println(button);
                }
                
                else if((this.getCharacterInArray(row, col + 1) == 'X' || this.getCharacterInArray(row, col + 1) == '_') && i == 3){
                    this.forceLit(row, col+1, !(isLit(row,col+1)));
                    String button = "button: " + i;
                    System.out.println(button);
                }

            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println("error");
            }
        }
    }
    
    
}
