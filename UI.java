import edu.princeton.cs.algs4.*;
import java.util.*;

public class UI{

    private TripSearch leit;
    private TripBooker booker;
    private User user;

    public UI() {
        this.leit = new TripSearch();
        this.booker = new TripBooker();
    }

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
            StdOut.println("Put in your filters below:");
            StdOut.println("Name: (If you dont want to use this filter, press 0)");
            String n = StdIn.readString();
            if(n.equals("0")) n="null";
            StdOut.println("location:");
            StdOut.println("Do you want to search by location? Press 1 for yes and 0 for no");
            String l = "";
            String loc = "";
            int ans= StdIn.readInt();
            if(ans == 0) l="null";
            else {
                Picture pic = new Picture("iceland.png");
                pic.show();
                System.out.println("Pick a location:");
                System.out.println("A: Westfjords");
                System.out.println("B: Northwest");
                System.out.println("C: Norheast");
                System.out.println("D: East");
                System.out.println("E: South");
                System.out.println("F: West");
                System.out.println("G: Capital region");
                System.out.println("H: Southern Pensula");
                s = StdIn.readString();
                if(s.equals("A")) loc = "Westfjords";
                if(s.equals("B")) loc = "Northwest";
                if(s.equals("C")) loc = "Norheast";
                if(s.equals("D")) loc = "East";
                if(s.equals("E")) loc = "South";
                if(s.equals("F")) loc = "West";
                if(s.equals("G")) loc = "Capital";
                if(s.equals("H")) loc = "SouthernPensula";
                l = loc;
            }
            StdOut.println("Type of trip: (If you dont want to use this filter, press 0)");
            String t = StdIn.readString();

            if(t.equals("0")) t="null";
            else {
                System.out.println("Choose type:");
                System.out.println("A: hestaferd/horseback riding");
                System.out.println("B: gonguferd/hiking tour");
                System.out.println("C: skidaferd/skiing trip");
                System.out.println("D: skodunarferd/sightseeing tour");
                String type = StdIn.readString();
                String tegund;
                if (type.equals("A")) t = "hestaferd";
                if (type.equals("B")) t = "gonguferd";
                if (type.equals("C")) t = "skidaferd";
                if (type.equals("D")) t = "skodunarferd";
            }
            StdOut.println("Date: (If you dont want to use this filter, press 0)");
            String d= StdIn.readString();
            if(d.equals("0")) d="null";
            StdOut.println("Time: (If you don't want to use this filter, press 0)");
            Integer t2= StdIn.readInt();
            StdOut.println("Price: (If you dont want to use this filter, press 0)");
            Integer p= StdIn.readInt();
            StdOut.println("How big is your group? (If you dont want to use this filter, press 0)");
            Integer a= StdIn.readInt();

            leit.searchTrip(n, l, t, d, t2, p, a);
            printTrips();
            System.out.println("Would you like to");
            System.out.println("A: Search/sort again");
            System.out.println("B: Book a trip ?");
            System.out.println("Any key: Continue");
            String b = StdIn.readString();
            if(b.equals("A")){
                this.searchMenu();
            }else if (b.equals("B")) this.bookingMenu();

        }else if(s.equals("B")){
            StdOut.println("How would you like to sort ?");
            StdOut.println(  "A. By price");
            StdOut.println(  "B. By score");
            StdOut.println(  "C. By duration");
            StdOut.println(  "D. By date");
            String s3 = StdIn.readString();
            String rada="";
            if(s3.equals("A")) rada="Price";
            if(s3.equals("B")) rada="Score";
            if(s3.equals("C")) rada="Duration";
            if(s3.equals("D")) rada="Date";
            leit.sortBy(rada);
            printTrips();
            System.out.println("Would you like to");
            System.out.println("A: Search/sort again");
            System.out.println("B: Book a trip");
            System.out.println("Any Key: Continue");
            String a = StdIn.readString();
            if(a.equals("A")){
                this.searchMenu();
            }else if(a.equals("B")) this.bookingMenu();
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
  
  private void bookingMenu(){
      StdOut.println("Would you like to book one of the following trips?");
      this.printTrips();
      StdOut.println("If yes, enter the number in front of the trip:");
      StdOut.println("else, press 0") ;
      int n = StdIn.readInt();
      if(n == 0){
          return;
      }
      StdOut.println("How many tickets would you like ?");
      int howMany = StdIn.readInt();
      boolean book = false;
      Trip trip = null;
      for(Trip t : leit) {
          if(t.getId() == n){
              Booking booking = new Booking(user.getId(), n);
              book = true;
              for(int i = 0; i < howMany; i++){
                  booker.bookTrip(t, user);
              }
              trip = t;
              break;
          }
      }
      if(book != true) {
          StdOut.println("No trip matches this Id");
      }
      else if(book == true) {
          StdOut.println("You have booked the following trip for " + howMany + " people:");
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

  private void cancelTrip(){
      boolean toCancel = false;
      while(toCancel == false){
          System.out.println("These are the trips that you have booked: ");
          List<Trip> bookedTrips = this.user.getTrips();
          for(Trip trip : bookedTrips) {
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
          System.out.println("What trip would you like to cancel? \nPlease enter the number in front of the trip:");
          Integer iD = Integer.parseInt(StdIn.readString());
          Trip tripToRemove = null;

          for(Trip trip : bookedTrips){
              if(trip.getId() == iD){
                  tripToRemove = trip;
              }
          }

          System.out.println("how many tickets would you like to cancel ?");
          int howMany = StdIn.readInt();
          booker.cancelTrip(tripToRemove, this.user, howMany);
          System.out.println("Would you like to cancel any other trip ? Yes or No");
          String yes = StdIn.readString();
          if(yes.equals("No")){
              toCancel = true;
          }
      }
  }
  
  private void printTrips(){
      if(leit.getFilteredList().isEmpty()){
          System.out.println("Unfortunately there are no such trips");
          System.out.println("Would you like to search again ? Y or N");
          String searchAgain = StdIn.readString();
          if(searchAgain.equals("Y")){
              this.searchMenu();
          }
      }
      else{
          System.out.println("Identification number, name, location, type, company, date, duration, time, price, available spots, suitable for seniors, suitable for children, pickup within 30 km radius, score");
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
      }
  }
  
  public static void main(String[] args){
      StdOut.println("Welcome.");
      UI userint= new UI();
      userint.userMenu();
      userint.mainMenu();

      boolean search = false;
      while(search == false) {
          StdOut.println("Can we help you with anything else?");
          StdOut.println("Press Y for yes or N for no");
          String p = StdIn.readString();
          if (p.equals("Y")) {
              userint.leit.resetFilteredList();
              userint.mainMenu();
          }else if (p.equals("N")) {
              StdOut.println("Are you sure or would you like to cancel any of your booked trips?");
              StdOut.println("Press S if you are sure or C if you would like to cancel:");
              String k = StdIn.readString();
              if(k.equals("C")){
                  userint.cancelTrip();
              }
              search = true;
          }
      }
      StdOut.println("Thank you. Have a nice day!");
      userint.booker.updateBookings();
  }
}
