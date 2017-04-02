import java.util.*;

public class TripSearch{
    private List<Trip> listOfTrips;
    private List<Trip> filteredList;

    public TripSearch(){

        this.listOfTrips = this.getTrips();
    }

    private List<Trip> getTrips(){
        List<Trip> list = new ArrayList<Trip>();
        DataManager dM = new DataManager();
        String[][] rawData = dM.readData();
        //finna ut hvernig a ad breyta object i string, integer etc.
        for(int i = 0; i < rawData.length; i++){
            list.add(i, new Trip(rawData[i][0], rawData[i][1], rawData[i][2], rawData[i][3], Integer.parseInt(rawData[i][4]), Double.parseDouble(rawData[i][5]), Integer.parseInt(rawData[i][6]), Integer.parseInt(rawData[i][7]), Integer.parseInt(rawData[i][8]), Boolean.parseBoolean(rawData[i][9]), Boolean.parseBoolean(rawData[i][10]), Boolean.parseBoolean(rawData[i][11]), Double.parseDouble(rawData[i][12])));
        }
        return list;
    }

    private void searchTrip(String name, String location, String type, Integer date, Integer time, Integer price, Integer spots, boolean isSeniors, boolean isChildren, boolean pickUp){

        this.filteredList = new ArrayList<Trip>();

        if (name != null){
            for(Trip temp : this.listOfTrips){
                System.out.println(temp.getName());
                //afhverju virkar ekki thessi if-setning ?
                if (name.equals(temp.getName())){
                    this.filteredList.add(temp);
                }
            }
        }

        if(location != null){
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

        if(type != null){
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

        if(date != 0){
            if(this.filteredList.size() == 0) {
                for (Trip temp : this.listOfTrips) {
                    if (date == temp.getDate()) {
                        this.filteredList.add(temp);
                    }
                }
            }else{
                List<Trip> toRemove = new ArrayList<Trip>();
                for(Trip temp: this.filteredList){
                    if(date != temp.getDate()){
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
                    if(time != temp.getTime()){
                        toRemove.add(temp);
                    }
                }
                filteredList.removeAll(toRemove);
            }
        }

        if(price != 0){
            if(this.filteredList.size() == 0) {
                for (Trip temp : this.listOfTrips) {
                    if (price == temp.getPrice()) {
                        this.filteredList.add(temp);
                    }
                }
            }else{
                List<Trip> toRemove = new ArrayList<Trip>();
                for(Trip temp: this.filteredList){
                    if(price != temp.getPrice()){
                        toRemove.add(temp);
                    }
                }
                filteredList.removeAll(toRemove);
            }
        }

        if(spots != 0){
            if(this.filteredList.size() == 0) {
                for (Trip temp : this.listOfTrips) {
                    if (spots == temp.getSpots()) {
                        this.filteredList.add(temp);
                    }
                }
            }else{
                List<Trip> toRemove = new ArrayList<Trip>();
                for(Trip temp: this.filteredList){
                    if(spots != temp.getSpots()){
                        toRemove.add(temp);
                    }
                }
                filteredList.removeAll(toRemove);
            }
        }

    }
    public void sortBy(){

    }
    public static void main(String[] args){
        TripSearch ferd = new TripSearch();
        ferd.searchTrip("Aevintyrahestaferd", "Akureyri", "null",160717, 0, 0, 0, false, false, false);
        System.out.println(ferd.filteredList.size());
    }
}