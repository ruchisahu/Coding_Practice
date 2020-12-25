
public class AutoscalePolicy {
	//good
	 public static int finalInstances(int instances, int[] averageUtil) {
	        int maxLimit = (int) (2 * (Math.pow(10, 8)));

	        // Average utilization < 25%: Half the current number of instances if the instances > 1 && sleep 10 seconds
	        // 25% <= Average utilization <= 60%: Take no action.
	        // Average utilization > 60%: Double instances if newly computed value <= 2* 10^8 && sleep 10 seconds. If the number of instances exceeds this limit upon doubling, perform no action.

	        if(averageUtil == null || averageUtil.length == 0 || instances == 0)
	            return 0;

	        int cursor = 0;
	        while(cursor < averageUtil.length){
	            int utilization = averageUtil[cursor];
	            if(utilization > 60 && instances * 2 <= maxLimit){
	                instances *= 2;
	                cursor += 10;
	            } else if(utilization < 25 && instances > 1){
	                instances = (int) Math.ceil((float)instances / 2);
	                cursor += 10;
	            }
	            cursor++;
	        }
	        System.out.println(instances);
	        return instances;
	    }
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
