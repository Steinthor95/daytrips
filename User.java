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

    public List<Trip> getTrips(){ return this.myList; }
    
    public void setMyList(Trip trip) {
        myList.add(trip);
    }
    
    public void cancel(Trip trip) {
        List<Trip> toRemove = new ArrayList<Trip>();
        for(Trip temp : this.myList){
            if(trip.getId() == temp.getId()){
                toRemove.add(temp);
            }
        }
        myList.removeAll(toRemove);
    }
}