import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/discuss/interview-question/948919/Amazon-or-OA2-or-Fill-The-Truck
//https://aonecode.com/amazon-online-assessment-fill-the-truck
public class FillTheTruck {
	
	//sol2
	public int fillTheTruck1(int num, int[] boxes, int unitSize, int[] unitsPerBox, long truckSize) {
	    Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);
	    for(int i=0;i<boxes.length;i++) {
	        for(int j=0;j<boxes[i];j++){
	            maxHeap.offer(unitsPerBox[i]);
	        }
	    }
	    int res = 0;
	    while(truckSize-- > 0 && !maxHeap.isEmpty()){
	        res += maxHeap.poll();
	    }
	    return res;
	}
	
	//sol1
	public static int fillTheTruck(int num, int[] boxes, int unitSize, int[] unitsPerBox, long truckSize) {
        int i, ans =0;
        ArrayList<ArrayList<Integer>> boxUnits = new ArrayList();
        ArrayList<Integer> temp;
        for(i=0; i<boxes.length; i++){
            temp = new ArrayList();
            temp.add(unitsPerBox[i]);
            temp.add(boxes[i]);
            boxUnits.add(temp);
        }
        Collections.sort(boxUnits, new Comparator<ArrayList<Integer>>(){
           public int compare(ArrayList<Integer> a1, ArrayList<Integer> a2){
            if(a1.get(0) < a2.get(0))
                return 1;
            if(a1.get(0) > a2.get(0))
                return -1;
            return 0;    
           } 
        });
        for(i=0; i<boxUnits.size(); i++){
            if (truckSize - boxUnits.get(i).get(1) >=0){
                truckSize = truckSize - boxUnits.get(i).get(1);
                ans += (boxUnits.get(i).get(1) * boxUnits.get(i).get(0));
            }else{
                ans += (truckSize * boxUnits.get(i).get(0));
                break;
            }
        }
        return ans;
    }

	public static void main(String[] args) {
		int num=3;
		int[] boxes= {1,2,3};
		int unitSize=3;
		int[] unitsPerBox= {1,2,3};
		long truckSize=3;
		fillTheTruck(num,boxes,unitSize,unitsPerBox,truckSize);

	}

}
