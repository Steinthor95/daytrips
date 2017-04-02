import java.util.Comparator;
import java.util.*;
import java.text.*;

public class Trip{
    private String name;
    private String location;
    private String type;
    private String company;
    private String date;
    private Double duration;
    private Integer time ;
    private Integer price;
    private Integer spots;
    private boolean isSeniors;
    private boolean isChildren;
    private boolean pickUp;
    private double score;
    private Integer Ordered;

    public Trip(String name0, String location0, String type0, String company0, String date0, Double duration0, Integer time0, Integer price0, Integer spots0, boolean isSeniors0, boolean isChildren0, boolean pickUp0, double score0){
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
        this.Ordered = 0;
    }

    public String getDate() {return this.date;}

    public Integer getOrdered() {return this.Ordered;}

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

    public void setOrdered(int a) {this.Ordered+= a;}

    static Comparator<Trip> PriceComparator() {
        return new Comparator<Trip>() {
            public int compare(Trip a, Trip b) {
                return a.getPrice().compareTo(b.getPrice());
            }
        };
    }

    static Comparator<Trip> DurationComparator() {
        return new Comparator<Trip>() {
            public int compare(Trip a, Trip b) {
                return a.getDuration().compareTo(b.getDuration());
            }
        };
    }


    static Comparator<Trip> ScoreComparator() {
        return new Comparator<Trip>() {
            public int compare(Trip a, Trip b) {
                return b.getScore().compareTo(a.getScore());
            }
        };
    }

    static Comparator<Trip> DateComparator() {
        return new Comparator<Trip>() {
            public int compare(Trip a, Trip b) {
                int test = 0;
                String pattern = "dd-MM-yyyy";
                SimpleDateFormat format = new SimpleDateFormat(pattern);
                try {
                    Date d1 = format.parse(a.getDate());
                    Date d2 = format.parse(b.getDate());
                    test = d1.compareTo(d2);
                }
                catch (ParseException e) {
                    e.printStackTrace();
                }
                return test;

            }
        };
    }



    public static void main (String[] args){

    }
}