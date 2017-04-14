import java.util.*;

public class User {
    private Integer Id;
    private String userName;
    private List<Trip> myList;
    
    public User(Integer id, String name) {
        this.Id = id;
        this.userName = name;
        this.myList = new ArrayList<Trip>();
        
    }
    public Integer getId(){
        return this.Id;
    }
    
    //public void giveScore(Trip trip, Double myScore){
      //  trip.setScore(myScore);
    //}
    
    public void setMyList(Trip trip) {
        myList.add(trip);
    }
    
    public void cancel(Trip trip) {
        myList.remove(trip);
    }
}