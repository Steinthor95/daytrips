public class User {
    private Integer ID;
    private String userName;
    private List<Trip> myList;
    
    public User{Integer id, String name) {
        ID = id;
        name = UserName;
        List<Trip> myList = new ArrayList<Trip>();
        
    }
    
    public void giveScore(Trip trip, Double myScore){
        trip.setScore(myScore);
    }
    
    public void setMylist(Trip trip) {
        myList.add(trip);
    }
    
    public void cancel(Trip trip) {
        myList.remove(trip);
    }
}