
public class AutoscalePolicy {
private static int getInstances(int instances, int[] utilization){
        
        int i = 0, n = utilization.length;
        while (i < n){
            if (utilization[i] < 25 && instances > 1){
                instances = (int) Math.ceil(instances / 2);
                i += 10;
                continue;
            } else if (utilization[i] > 60 && (2 * instances < 2 * Math.pow(10, 8))){
                instances *= 2;
                i += 10;
                continue;
            }
            i++;
        }
        return instances;
    }
    
    public static void main(String[] args) {
        
        int instances = 1;
       // System.out.println(getInstances(instances, new int[]{5, 10, 80}));
        
        int instances1 = 2;
        System.out.println(getInstances(instances1, new int[]{25, 23,1,2,3,4,5,6,7,8,9,10,76,80}));
    }
}
