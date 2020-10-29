
public class QuickSort {
    int[] array;
    public QuickSort(int[] a){
        array = a;
    }
    public void sort(int low, int high){
        if(low<high){
            int partition = partition(low, high);
            System.out.println(partition);
            sort(low, partition-1);
            sort(partition+1, high);
        }
    }

    public int[] getArray(){
        return array;
    }

    private int partition(int low, int high) {
        int p = high,
                j = low;
        for(int i = low; i <= high; i++){
            if(array[i] < array[p]){
                swap(array, i, j);
                j++;
            }
        }
        swap(array, j, p);
        return j;
    }

    static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args){
        int[] array = {2,30,21,24,100,101,4,56};
        QuickSort qs = new QuickSort(array);
        qs.sort(0, 7);
        int[] result = qs.getArray();
        for(int i =0; i< result.length; i++)
            System.out.println(result[i]);
    }
}