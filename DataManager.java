import edu.princeton.cs.algs4.*;

public class DataManager{
    
    public DataManager(){}

    public String[][] readData(){
        String[] lines = new In("trips.txt").readAllLines();
        String[][] data = new String[lines.length][13];
        String[] line = new String[13];
        for(int i = 0; i < lines.length; i++){
            for(int j = 0; j < 13; j++){
                line = lines[i].split(";");
                data[i][j] = line[j];
            }
        }
        return data;
    }

    public static void main(String[] args){

    }
}