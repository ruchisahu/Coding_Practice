import java.util.ArrayList;
import java.util.List;

public class FindPossibleFreeSizesCount {
	public static int findPossibleFreeSizesCount(int size0,int n,int mult, int offset, int modVal,int maxArea){
	    List<Integer> wallLengths=new ArrayList<>();
	    wallLengths.add(size0);
	    int possibleCombinations=(size0*size0)<=maxArea?1:0;
	    int previousSize=size0;
	    while(wallLengths.size()<n){
	        int currentCount=0;
	        int currentLength=(mult*previousSize+offset)%modVal+1+previousSize;
	        previousSize=currentLength;
	        if(currentLength*currentLength<=maxArea){
	            currentCount+=1+2*wallLengths.size();
	        }
	        else{
	            currentCount+=2*(binarySearch(wallLengths,currentLength,maxArea)+1);
	        }
	        possibleCombinations+=currentCount;
	        wallLengths.add(currentLength);
	        if(currentCount==0){
	            break;
	        }
	    }
	    return possibleCombinations;
	}

	private static int binarySearch(List<Integer> sizes,int search, int target){
	    int low=0;
	    int high=sizes.size()-1;
	    while(low<=high){
	        int mid=(low+high)/2;
	        if((sizes.get(mid)*search)==target){
	            return mid;
	        }
	        else if((sizes.get(mid)*search)<target){
	            low=mid+1;
	        }
	        else{
	            high=mid-1;
	        }
	    }
	    return low-1;
	}

	public static void main(String args[]){
	    System.out.println(findPossibleFreeSizesCount(2,3,3,3,2,15));
	}
}