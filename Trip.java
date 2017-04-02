public class Trip{
    private String name; 
    private String location; 
    private String type;
    private String company;
    private Integer date; 
    private Double duration;
    private Integer time ;
    private Integer price; 
    private Integer spots;
    private boolean isSeniors; 
    private boolean isChildren; 
    private boolean pickUp;
    private double score;

    public Trip(String name0, String location0, String type0, String company0, Integer date0, Double duration0, Integer time0, Integer price0, Integer spots0, boolean isSeniors0, boolean isChildren0, boolean pickUp0, double score0){
        this.name = name0;
        this.location = location0;
        this.type = type0;
        this.company = company0;
        this.date = date0;
        this.duration = duration0;
        this.time = time0;
        this.price = price0;
        this.spots = spots0;
        this.isSeniors = isSeniors0;
        this.pickUp = pickUp0;
        this.score = score0;
    }

    public String getName(){
        return this.name;
    }

    public String getLocation(){
        return this.location;
    }

    public String getType(){
        return this.type;
    }
    
    public String getCompany(){
        return this.company;
    }
    public Integer getDate(){
        return this.date;
    }

    public Double getDuration(){
        return this.duration;
    }
    public Integer getTime(){
        return this.time;
    }

    public Integer getPrice(){
        return this.price;
    }

    public Integer getSpots(){
        return this.spots;
    }

    public boolean getIsSeniors(){
        return this.isSeniors;
    }

    public boolean getIsChildren(){
        return this.isChildren;
    }

    public boolean getPickUp(){
        return this.pickUp;
    }

    public Double getScore(){
        return this.score;
    }

    public static void main (String[] args){
        
    }
}