import edu.princeton.cs.algs4.*;

public class DataManager{
    
    public DataManager(){}

    public String[][] readData(){
        String[] lines = new In("trips.txt").readAllLines();
        String[][] splitline = new String[lines.length][13];
        String[] line = new String[13];
        for(int i = 0; i < lines.length; i++){
            for(int j = 0; j < 13; j++){
                line = lines[i].split(";");
                splitline[i][j] = line[j];
            }
        }

        String[][] data = new String[lines.length][13];
        for(int i = 0; i < lines.length; i++){
            data[i][0] = splitline[i][0];
            data[i][1] = splitline[i][1];
            data[i][2] = splitline[i][2];
            data[i][3] = splitline[i][3];
            data[i][4] = splitline[i][4];
            data[i][5] = splitline[i][5];
            data[i][6] = splitline[i][6];
            data[i][7] = splitline[i][7];
            data[i][8] = splitline[i][8];
            data[i][9] = splitline[i][9];
            data[i][10] = splitline[i][10];
            data[i][11] = splitline[i][11];
            data[i][12] = splitline[i][12];
        }
        return data;
    }

    public static void main(String[] args){
        DataManager dM = new DataManager();
        Object[][] data = dM.readData();
        for(int i = 0; i < data.length; i++){
            for(int j = 0; j < data[0].length; j++){
                System.out.print(data[i][j] + " - ");
            }
            System.out.println();
        }

    }
}