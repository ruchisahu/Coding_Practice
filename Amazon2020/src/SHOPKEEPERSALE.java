/*
 * A shopkeeper has a sale to complete and has arranged the items being sold in a list. Starting from the left, the shop keeper rings up each item at its full price less the price of the first lower or equally priced item to its right. If there is no item to the right that costs less than or equal to the current item's price the current item is sold at full price.

For example, assume there are items priced [2, 3, 1, 2, 4, 2].
The first and second items would each be discounted by 1 unit, the first equal or lower price to the right.
The item priced 1 unit would sell at a full price.
The next item, at 2 units, would be discounted 2 units as would the 4 unit item.
The sixth and final item must be purchased at full price.
The total cost is 1+2+1+0+2+2 = 8 units.
 */
public class SHOPKEEPERSALE {

	public static  int sale(int[] a){
		int n=a.length;
		for(int i=0;i<n-1;i++) {
			int j=i+1;
			
			while(j<n-1 && a[j]>a[i]) {
				j++;
				
					
				}
			if(a[i]-a[j]>=0)
			a[i]=a[i]-a[j];
			
			
		}
		for(int k=0;k<n;k++) 
			System.out.println(a[k]);
		return 0;
		
	}
	public static void main(String[] args) {
		int[] a= {2, 3, 1, 2, 4, 2};
		System.out.println(sale(a));

	}

}
