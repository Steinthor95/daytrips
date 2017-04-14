import java.util.*;

public class Booking {
    
    private Integer userId;
    private Integer tripId;

    public Booking(Integer user0, Integer trip0) {
        this.userId = user0;
        this.tripId = trip0;
    }

    public Integer getUserId(){
        return this.userId;
    }

    public Integer getTripId(){
        return this.tripId;
    }

    static Comparator<Booking> UserIdComparator(){
        return new Comparator<Booking>() {
            public int compare(Booking a, Booking b){
                return a.getUserId().compareTo(b.getUserId());
            }
        };
    }

    static Comparator<Booking> TripIdComparator(){
        return new Comparator<Booking>() {
            public int compare(Booking a, Booking b) {
                return a.getTripId().compareTo(b.getTripId());
            }
        };
    }
    public static void main(String[] args){

    }
}
    
    