public class TripSearch{
    private List<Trips> listOfTrips;
    private List<Trips> filteredList;

    public TripSearch(){
        this.listOfTrips = this.getTrips();
        this.filteredList;
    }

    private List<Trips> getTrips(){
        List<Trips> list;
        DataManager dM = new DataManager();
        Object[][] rawData = dM.readData();
        for(int i = 0; i < rawData[0].length; i++){
            list.add(i, new Trip(rawData[i][0], rawData[i][1], rawData[i][2], rawData[i][3], rawData[i][4], rawData[i][5], rawData[i][6],rawData[i][7], rawData[i][8], rawData[i][9], rawData[i][10], rawData[i][11], rawData[i][12]))
        }
        return list;
    }

    private searchTrip(String name, String location, String type, String company, Integer date, Integer duration, Integer time, Integer price, Integer spots, boolean isSeniors, boolean isChildren, boolean pickUp, double score){
        this.filteredList = new ArrayList<Trips>;
        
        //testa search Trip
        //testa sortby
    }

    public static void main(String[] args){

    }
}