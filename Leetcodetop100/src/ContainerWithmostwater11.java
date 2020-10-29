
public class ContainerWithmostwater11 {
	public static int maxArea(int[] a) {
        int left=0;
        int right=a.length-1;
        int area=0;
        while(left<right)
        {
            area=Math.max(area,(right-left)*Math.min(a[left],a[right]));
            if(a[left]>a[right])
            {
                right--;
            }
            else
                left++;
        }
        return area;
        
    }


	public static void main(String[] args) {
		int[] h= {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(h));

	}

}
