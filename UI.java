import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class UI{
  
  TripSearch leit = new TripSearch();
  private User user;
  
  private void mainMenu(){
  StdOut.println("Would you like to search for trips or go to the booking section?");
  StdOut.println("Press S for searching or B for booking");
  String m=StdIn.readString();
    if(m.equals("S")) searchMenu();
    else if(m.equals("B")) bookingMenu(user);
    else mainMenu();
  }
  
  private void searchMenu(){
     StdOut.println("Press A to search or B to sort");
  String s = StdIn.readString();
  if(s.equals("A")){
    StdOut.println("Put in your filters below:");
    StdOut.println("Name: (If you dont want to use this filter, press 0");
    String n = StdIn.readString();
    if(n.equals("0")) n="null";
    StdOut.println("Location:");
    String l= StdIn.readString();
    if(l.equals("0")) l="null";
    StdOut.println("Type of trip:");
    String t= StdIn.readString();
    if(t.equals("0")) t="null";
    StdOut.println("Date:");
    String d= StdIn.readString();
    if(d.equals("0")) d="null";
    StdOut.println("Time: (If you don't want to use this filter, press 0");
    Integer t2= StdIn.readInt();
    StdOut.println("Price:");
    Integer p= StdIn.readInt();
    StdOut.println("How big is your group?");
    Integer a= StdIn.readInt();
    
    leit.searchTrip(n, l, t, d, t2, p, a);
    printTrips();
       
    /*
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
    }*/
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
  public void userMenu(){
    StdOut.println("Please enter your name and a 4 digit passcode: ");
    StdOut.println("Name:");
    String name= StdIn.readLine();
    StdOut.println("Passcode:");
    Integer ssn= StdIn.readInt();
    user = new User(ssn, name);
  }
  
  private void bookingMenu(User user){
    StdOut.println("Would you like to book one of the following trips?");
    StdOut.println("If yes, enter the number in front of the trip:");
    StdOut.println("else, press 0") ;
    int n = StdIn.readInt();
    boolean book = false;
    Trip trip = null;
    if(n!=0) {
        for(Trip t : leit) {
            if(t.getId() == n)
            {
                Booking booking = new Booking(user.getId(), n);
                book = true;
                user.setMyList(t);
                trip = t;
                break;
                
            }
        }
        if(book != true)
        StdOut.println("No trip matches this Id");
        else if(book == true) {
        StdOut.println("You have booked the following trip:");
            System.out.print(n + ". " + trip.getName());
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
        }
    }
  }
  
  private void printTrips(){
    if(leit.getFilteredList().isEmpty()) throw new IllegalArgumentException("Unfortunately there are no such trips");
   for(Trip trip : leit) {
            System.out.print(trip.getId() + ". " + trip.getName());
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
        }
   // System.out.println(Arrays.toString(leit.getFilteredList().toArray()));
  }
  
  public static void main(String[] args){
    StdOut.println("Welcome.");
    UI userint= new UI();
    userint.userMenu();
    userint.mainMenu();
    //userint.bookingMenu(userint.user);
    
    
    StdOut.println("Can we help you with anything else?");
    StdOut.println("Press Y for yes or N for no");
    String p = StdIn.readString();
    if(p.equals("Y")){
      UI userint2= new UI();
      userint2.mainMenu();
    }
    else if(p.equals("N")){
      StdOut.println("Are you sure or would you like to cancel any of your booked trips?");
      StdOut.println("Press S if you are sure or C if you would like to cancel:");
      String k = StdIn.readString();
      if(k.equals("S")) StdOut.println("Thank you. Have a nice day!");
      //else if (k.equals("C")) userint.cancelMenu();
    }
   
    //userint.printTrips();
    //userint.leit.searchTrip("Hestaferdin mikla", "null", "null", "null", 0, 0, 0);
    //userint.printTrips();
  }
}
