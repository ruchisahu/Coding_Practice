package Chap_8;

import java.util.Arrays;

import util.util;
//)(d(n+k))
public class RadixSort {
	private static void Sort(int[] array,int size) {
		int digit=countDigit(array);
		for(int i=0;i<digit;i++) {
			countingSort(array,i);
		}
		
	}


	
	//count sort
	private static void countingSort(int[] array, int digit) {
        int[] counts = new int[10];
        int[] target = new int[array.length];
        for (int i = 0; i < counts.length; i++) {
            counts[i] = 0;
        }
        for (Integer item : array) {
            counts[getDigit(item, digit)] ++;
        }
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }
        for (int i = array.length - 1; i >= 0; i--) {
            final Integer item = array[i];
            target[counts[getDigit(item, digit)] - 1] = item;
            counts[getDigit(item, digit)] --;
        }
        System.arraycopy(target, 0, array, 0, array.length);
        
    }

    private static int getDigit(int number, int digit) {
        return ((int) (number / Math.pow(10, digit))) % 10;
    }
    

	public int getdigit1(int i, int d)
	{
	    while (d > 1) {
	        d--;
	        i/=10;
	    }
	 
	    return i%10;
	}

	private static int countDigit(int[] array) {
		int digit=0;
		for(int item:array) {
			int d=(int) Math.ceil(Math.log10(item));
			if(d>digit)
				digit=d;
		}
		return digit;
	}

	public static void main(String[] args) {
		System.out.println("\nRadix Sort test");
		int[] array = new int[10];
		util.fillWithRandomInts(array);
		int size=array.length;
		System.out.println(Arrays.toString(array));
		Sort(array,size);
		System.out.println(Arrays.toString(array));

	}

	

}
