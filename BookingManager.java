import java.io.*;
import java.util.*;
import edu.princeton.cs.algs4.*;


public class BookingManager{

    public BookingManager(){}

    //Returns a 2D array that includes all of the bookings from bookings.txt file
    public String[][] readData(){

        String [] lines = new In("bookings.txt").readAllLines();
        String[][] data = new String[lines.length-1][2];
        String[] line = new String[2];
        for(int i = 1; i < lines.length; i++){
            for (int j = 0; j < 2; j++){
                line = lines[i].split(";");
                data[i-1][j] = line[j];
            }
        }
        return data;
    }

    //Overwrites bookings.txt with all of the new bookings and the old ones
    public void updateData(List<Booking> booking){
        try{
            File file = new File("bookings.txt");
            FileWriter writer = new FileWriter("bookings.txt");
            BufferedWriter bWriter = new BufferedWriter(writer);

            bWriter.write("UserId;TripId");
            bWriter.newLine();
            for(Booking b : booking){
                bWriter.write(b.getUserId()+";"+b.getTripId());
                bWriter.newLine();
            }
            bWriter.close();
        } catch(IOException ex){
            System.out.println("hallo!");
            ex.printStackTrace();

        }
    }

    public static void main(String[] args){

    }
}
