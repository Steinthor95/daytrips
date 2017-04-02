import java.util.*;

public class TripSearch implements Iterable<Trip>{
    private List<Trip> listOfTrips;
    private List<Trip> filteredList;

    public TripSearch(){

        this.listOfTrips = this.getTrips();
        this.filteredList = this.getTrips();
    }

    private List<Trip> getTrips(){
        List<Trip> list = new ArrayList<Trip>();
        DataManager dM = new DataManager();
        String[][] rawData = dM.readData();
        //finna ut hvernig a ad breyta object i string, integer etc.
        for(int i = 0; i < rawData.length; i++){
            list.add(i, new Trip(rawData[i][0], rawData[i][1], rawData[i][2], rawData[i][3], rawData[i][4], Double.parseDouble(rawData[i][5]), Integer.parseInt(rawData[i][6]), Integer.parseInt(rawData[i][7]), Integer.parseInt(rawData[i][8]), Boolean.parseBoolean(rawData[i][9]), Boolean.parseBoolean(rawData[i][10]), Boolean.parseBoolean(rawData[i][11]), Double.parseDouble(rawData[i][12])));
        }
        return list;
    }

    private void searchTrip(String name, String location, String type, String date, Integer time, Integer price, Integer spots){

        this.filteredList = new ArrayList<Trip>();

        if (!name.equals("null")){
            for(Trip temp : this.listOfTrips){
                if (name.equals(temp.getName())){
                    this.filteredList.add(temp);
                }
            }
        }

        if(!location.equals("null")){
            if(this.filteredList.size() == 0) {
                for (Trip temp : this.listOfTrips) {
                    if (location.equals(temp.getLocation())) {
                        this.filteredList.add(temp);
                    }
                }
            }else{
                List<Trip> toRemove = new ArrayList<Trip>();
                for(Trip temp: this.filteredList){
                    if(!location.equals(temp.getLocation())){
                        toRemove.add(temp);
                    }
                }
                filteredList.removeAll(toRemove);
            }
        }

        if(!type.equals("null")){
            if(this.filteredList.size() == 0) {
                for (Trip temp : this.listOfTrips) {
                    if (type.equals(temp.getType())) {
                        this.filteredList.add(temp);
                    }
                }
            }else{
                List<Trip> toRemove = new ArrayList<Trip>();
                for(Trip temp: this.filteredList){
                    if(!type.equals(temp.getType())){
                        toRemove.add(temp);
                    }
                }
                filteredList.removeAll(toRemove);
            }
        }

        if(!date.equals("null")){
            if(this.filteredList.size() == 0) {
                for (Trip temp : this.listOfTrips) {
                    if (date.equals(temp.getDate())) {
                        this.filteredList.add(temp);
                    }
                }
            }else{
                List<Trip> toRemove = new ArrayList<Trip>();
                for(Trip temp : this.filteredList){
                    if(!date.equals(temp.getDate())){
                        toRemove.add(temp);
                    }
                }
                filteredList.removeAll(toRemove);
            }
        }

        if(time != 0){
            if(this.filteredList.size() == 0) {
                for (Trip temp : this.listOfTrips) {
                    if (time == temp.getTime()) {
                        this.filteredList.add(temp);
                    }
                }
            }else{
                List<Trip> toRemove = new ArrayList<Trip>();
                for(Trip temp: this.filteredList){
                    if(!time.equals(temp.getTime())){
                        toRemove.add(temp);
                    }
                }
                filteredList.removeAll(toRemove);
            }
        }

        if(price != 0){
            if(this.filteredList.size() == 0) {
                for (Trip temp : this.listOfTrips) {
                    if (price.compareTo(temp.getPrice()) != -1) {
                        this.filteredList.add(temp);
                    }
                }
            }else{
                List<Trip> toRemove = new ArrayList<Trip>();
                for(Trip temp: this.filteredList){
                    if(price.compareTo(temp.getPrice()) == -1){
                        toRemove.add(temp);
                    }
                }
                filteredList.removeAll(toRemove);
            }
        }

        if(spots != 0){
            if(this.filteredList.size() == 0) {
                for (Trip temp : this.listOfTrips) {
                    if (spots.compareTo(temp.getSpots()) != 1) {
                        this.filteredList.add(temp);
                    }
                }
            }else{
                List<Trip> toRemove = new ArrayList<Trip>();
                for(Trip temp: this.filteredList){
                    if(spots.compareTo(temp.getSpots()) == 1){
                        toRemove.add(temp);
                    }
                }
                filteredList.removeAll(toRemove);
            }
        }

    }
    public void sortBy(String a){
        if(a.equals("price"))
        {
            Collections.sort(this.filteredList, Trip.PriceComparator());
        }

        if(a.equals("Score"))
        {
            Collections.sort(this.filteredList, Trip.ScoreComparator());
        }
        if(a.equals("Duration"))
        {
            Collections.sort(this.filteredList, Trip.DurationComparator());
        }
        if(a.equals("Date"))
        {
            Collections.sort(this.filteredList, Trip.DateComparator());
        }
        else throw new IllegalArgumentException("ekki loglegt");
    }

    @Override
    public Iterator<Trip> iterator() {
        return filteredList.iterator();
    }

    public static void main(String[] args){
        TripSearch ferd = new TripSearch();
        ferd.searchTrip("null", "Akranes", "null", "11-06-2017", 0, 12000, 12);
        System.out.println(ferd.filteredList.size());
    }
}