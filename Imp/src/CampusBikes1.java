import java.util.PriorityQueue;

public class CampusBikes1 {
    public static int[] campusBike(int[][] workers, int[][] bikes) {
        if(workers == null || bikes == null) return new int[]{};

        int wLen = workers.length, bLen = bikes.length;

        PriorityQueue<CampusBikePair> pq = new PriorityQueue<CampusBikePair>((p1,p2) -> {
           if(p1.getDistance() == p2.getDistance()){
               if(p1.getWorkerId() == p2.getWorkerId()){
                   return p1.getBikeId() - p2.getBikeId();
               }else{
                   return p1.getWorkerId() - p2.getBikeId();
               }
           }else{
               return p1.getDistance() - p2.getDistance();
           }
        });

        for(int i = 0;  i< wLen; i++){
            for(int j = 0; j < bLen; j++){
                int dis = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
                CampusBikePair pair = new CampusBikePair(dis,i,j);
                pq.offer(pair);
            }
        }

        int index = 0;
        int[] res = new int[wLen];
        boolean[] isWorker = new boolean[wLen];
        boolean[] isBike = new boolean[bLen];

        while(index < wLen){
            CampusBikePair pair = pq.poll();
            int workerId = pair.getWorkerId();
            int bikeId = pair.getBikeId();

            if(!isWorker[workerId] && !isBike[bikeId]){
                res[workerId] = bikeId;
                isWorker[workerId] = true;
                isBike[bikeId] = true;
                index++;
            }
        }

        return res;
    }

    public static void main(String args[]){
        int[][] workers = new int[][]{{0,0},{2,1}};
        int[][] bikes = new int[][]{{1,2},{3,3}};
        int[] res = campusBike(workers,bikes);

        for(int i = 0; i < res.length; i++){
            System.out.println(res[i]);
        }
    }
}
