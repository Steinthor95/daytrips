import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class UI{
  
  TripSearch leit = new TripSearch();
  
  private void mainMenu(){
  StdOut.println("Would you like to search for trips or go to the booking section?");
  StdOut.println("Press S for searching or B for booking");
  String m=StdIn.readString();
    if(m.equals("S")) searchMenu();
    else if(m.equals("B")) bookingMenu();
    else mainMenu();
  }
  
  private void searchMenu(){
     StdOut.println("Press A to search or B to sort");
  String s = StdIn.readString();
  if(s.equals("A")){
    StdOut.println("Eftir hverju viltu leita? Sláðu inn tilsvarandi númer:");
    StdOut.println(  "1. Nafni");
    StdOut.println(  "2. Staðsetningu");
    StdOut.println(  "3. Tegund ferðar");
    StdOut.println(  "4. Dagsetningu");
    StdOut.println(  "5. Tímasetningu");
    StdOut.println(  "6. Verði");
    StdOut.println(  "7. Fjölda lausra sæta");
    int s2=StdIn.readInt();
    if(s2==1){
      StdOut.println("Sláðu inn nafnið hér að neðan: ");
      String nafn= StdIn.readString();
      leit.searchTrip(nafn, "null", "null", "null", 0, 0, 0);
      printTrips();
    }
  }
  else if(s.equals("B")){
    StdOut.println("Eftir hverju viltu raða? Sláðu inn tilsvarandi númer:");
    StdOut.println(  "1. Verði");
    StdOut.println(  "2. Einkunn");
    StdOut.println(  "3. Lengd ferðar");
    StdOut.println(  "4. Dagsetningu");
    int s3 = StdIn.readInt();
    String rada="";
    if(s3==1) rada="Price";
    if(s3==2) rada="Score";
    if(s3==3) rada="Duration";
    if(s3==4) rada="Date";
    leit.sortBy(rada);
    printTrips();
    //bookingMenu();
  }
  }
  
  private void bookingMenu(){
    StdOut.println("Would you like to book a trip or cancel an already booked one?");
    StdOut.println("Press B to book or C to cancel:");
    
    
  }
  
  private void printTrips(){
    if(leit.getFilteredList().isEmpty()) throw new IllegalArgumentException("Unfortunately there are no such trips");
    int i=1;
   for(Trip trip : leit.getFilteredList()) {
            System.out.print(i + ". " + trip.getName());
            System.out.print(", " + trip.getLocation());
            System.out.print(", " + trip.getType());
            System.out.print(", " + trip.getCompany());
            System.out.print(", " + trip.getDate());
            System.out.print(", " + trip.getDuration());
            System.out.print(", " + trip.getTime());
            System.out.print(", " + trip.getPrice());
            System.out.print(", " + trip.getSpots());
            System.out.print(", " + trip.getIsSeniors());
            System.out.print(", " + trip.getIsChildren());
            System.out.print(", " + trip.getPickUp());
            System.out.println(", " + trip.getScore());
            i++;
        }
   // System.out.println(Arrays.toString(leit.getFilteredList().toArray()));
  }
  
  public static void main(String[] args){
    StdOut.println("Welcome.");
    UI userint= new UI();
    TripSearch ts = new TripSearch();
    userint.mainMenu();
    //userint.printTrips();
    //userint.leit.searchTrip("Hestaferdin mikla", "null", "null", "null", 0, 0, 0);
    //userint.printTrips();
  }
}