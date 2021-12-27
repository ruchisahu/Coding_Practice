public class KthSamllestInTwoSortedArrays {
    public static int findKthInTwo(int[] arr1, int[] arr2, int k){
        if(arr1 == null && arr2 == null) return -1;
        if(k == 0) return -1;
        if(arr1 == null || arr1.length == 0) return arr2[k - 1];
        if(arr2 == null || arr2.length == 0) return arr1[k - 1];

        int index1 = 0, index2 = 0;
        int min = 0, count = 0;

        while(index1 < arr1.length && index2 < arr2.length){
            if(arr1[index1] < arr2[index2]){
                min = arr1[index1];
                index1++;
            }else{
                min = arr2[index2];
                index2++;
            }

            if(++count == k) return min;
        }

        if(index1 < arr1.length){
            for(int i = index1; i < arr1.length; i++){
                min = arr1[i];
                if(++count == k) return min;
            }
        }

        if(index2 < arr2.length){
            for(int i = index2; i < arr2.length; i++){
                min = arr2[i];
                if(++count == k) return min;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        //int[] arr1 = new int[]{2,5,6,8};
        int[] arr1 = new int[]{1,4,5,10};
        int[] arr2 = new int[]{2,7};
        System.out.println(findKthInTwo(arr1,arr2,0 ));
    }
}
