import java.util.*;

public class TripSearch implements Iterable<Trip>{
    private List<Trip> listOfTrips;
    private List<Trip> filteredList;

    public TripSearch(){

        this.listOfTrips = this.getTrips();
        this.filteredList = this.getTrips();
    }

    /*Creates new List of <Trip> that includes every trip that DataManager returns*/
    private List<Trip> getTrips(){
        List<Trip> list = new ArrayList<Trip>();
        DataManager dM = new DataManager();
        String[][] rawData = dM.readData();
        for(int i = 0; i < rawData.length; i++){
            list.add(i, new Trip(rawData[i][0], rawData[i][1], rawData[i][2], rawData[i][3], rawData[i][4], Double.parseDouble(rawData[i][5]), Integer.parseInt(rawData[i][6]), Integer.parseInt(rawData[i][7]), Integer.parseInt(rawData[i][8]), Boolean.parseBoolean(rawData[i][9]), Boolean.parseBoolean(rawData[i][10]), Boolean.parseBoolean(rawData[i][11]), Double.parseDouble(rawData[i][12]), Integer.parseInt(rawData[i][13])));
        }
        return list;
    }

    public void searchTrip(String name, String location, String type, String date, Integer time, Integer price, Integer spots){

        /*If user doesn't search for anything all of the trips will be returned*/
        if (name.equals("null") && location.equals("null") && type.equals("null") && date.equals("null") && time == 0 && price == 0 && spots == 0){
            return;
        }

        /*New empty list of trips that will include the trips that matches the search*/
        this.filteredList = new ArrayList<Trip>();
        /*If we have already added to the list and emptied it*/
        boolean isEmptyAfterFilteration = false;

        /*adds all of the trips that match the name*/
        if (!name.equals("null")){
            for(Trip temp : this.listOfTrips){
                if (name.equals(temp.getName())){
                    this.filteredList.add(temp);
                }
            }
            isEmptyAfterFilteration = true;
        }

        if(!location.equals("null")){
            /*If the list is empty we put all of the trips in the list that match location*/
            if(this.filteredList.size() == 0 && isEmptyAfterFilteration == false) {
                for (Trip temp : this.listOfTrips) {
                    if (location.equals(temp.getLocation())) {
                        this.filteredList.add(temp);
                    }
                }
            /*If the List contains Trips, we remove those that do not match location*/
            }else{
                List<Trip> toRemove = new ArrayList<Trip>();
                for(Trip temp: this.filteredList){
                    if(!location.equals(temp.getLocation())){
                        toRemove.add(temp);
                    }
                }
                filteredList.removeAll(toRemove);
                isEmptyAfterFilteration = true;
            }
        }

        //All of the if-statements work the same way as the one above.
        if(!type.equals("null")) {
            if (this.filteredList.size() == 0 && isEmptyAfterFilteration == false) {
                for (Trip temp : this.listOfTrips) {
                    if (type.equals(temp.getType())) {
                        this.filteredList.add(temp);
                    }
                }
            } else {
                List<Trip> toRemove = new ArrayList<Trip>();
                for (Trip temp : this.filteredList) {
                    if (!type.equals(temp.getType())) {
                        toRemove.add(temp);
                    }
                }
                isEmptyAfterFilteration = true;
                filteredList.removeAll(toRemove);
            }
        }

        if(!date.equals("null")){
            if(this.filteredList.size() == 0 && isEmptyAfterFilteration == false) {
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
                isEmptyAfterFilteration = true;
                filteredList.removeAll(toRemove);
            }
        }

        if(time != 0){
            if(this.filteredList.size() == 0 && isEmptyAfterFilteration == false) {
                for (Trip temp : this.listOfTrips) {
                    if (time.compareTo(temp.getTime()) == 0) {
                        this.filteredList.add(temp);
                    }
                }
            }else{
                List<Trip> toRemove = new ArrayList<Trip>();
                for(Trip temp: this.filteredList){
                    if(time.compareTo(temp.getTime()) != 0){
                        toRemove.add(temp);
                    }
                }
                isEmptyAfterFilteration = true;
                filteredList.removeAll(toRemove);
            }
        }

        if(price != 0){
            if(this.filteredList.size() == 0 && isEmptyAfterFilteration == false) {
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
                isEmptyAfterFilteration = true;
                filteredList.removeAll(toRemove);
            }
        }

        if(spots != 0){
            if(this.filteredList.size() == 0 && isEmptyAfterFilteration == false) {
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
                isEmptyAfterFilteration = true;
                filteredList.removeAll(toRemove);
            }
            this.sortBy("price");
        }

    }
    public void sortBy(String a){
        if(a.equals("Price")){
            Collections.sort(this.filteredList, Trip.PriceComparator());
        }
        else if(a.equals("Score"))
        {
            Collections.sort(this.filteredList, Trip.ScoreComparator());
        }
        else if(a.equals("Duration"))
        {
            Collections.sort(this.filteredList, Trip.DurationComparator());
        }
        else if(a.equals("Date"))
        {
            Collections.sort(this.filteredList, Trip.DateComparator());
        }
        else throw new IllegalArgumentException("You need to sort by one of the following: Price, Score, Duration or Date");
    }

    public List<Trip> getFilteredList(){
        return this.filteredList;
    }

    @Override
    public Iterator<Trip> iterator() {
        return filteredList.iterator();
    }

    public static void main(String[] args){
        TripSearch ferd = new TripSearch();
        ferd.searchTrip("Hestaferdin mikla", "null", "null", "null", 0, 0, 0);
        for(Trip temp : ferd){
            System.out.println(temp.getName());
        }

    }
}