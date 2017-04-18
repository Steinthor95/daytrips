import edu.princeton.cs.algs4.*;

public class DataManager{
    
    public DataManager(){}

    // Creates a 2d String array, where each line is a trip and each column represents info about that trip
    public String[][] readData(){
        String[] lines = new In("trips.txt").readAllLines();
        String[][] data = new String[lines.length-1][14];
        String[] line = new String[14];
        for(int i = 1; i < lines.length; i++){
            for(int j = 0; j < 14; j++){
                line = lines[i].split(";");
                data[i-1][j] = line[j];
            }
        }
        return data;
    }

    public static void main(String[] args){

    }
}