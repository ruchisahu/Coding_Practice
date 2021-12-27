public class CampusBikePair {
    int distance;
    int workerId;
    int bikeId;
    public CampusBikePair(int distance, int workerId, int bikeId){
        this.distance = distance;
        this.workerId = workerId;
        this.bikeId = bikeId;
    }

    public int getDistance(){
        return distance;
    }

    public int getBikeId() {
        return bikeId;
    }

    public int getWorkerId(){
        return workerId;
    }
}
