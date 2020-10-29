
public class state {


		 public static int[] cellComplete(int[] states, int days)

	     {

	         int leftNeighbor = 0;

	         int rightNeighbor = 0;

	         int[] previousState = null;



	         for (int i = 0; i < days; i++)

	         {

	             previousState = states.clone();

	             for (int j = 0; j < states.length; j++)

	             {
	                 if (j == 0)

	                 {
	                     leftNeighbor = 0;

	                     rightNeighbor = previousState[j + 1];
	                 }
	                 else if (j == states.length - 1)

	                 {

	                     leftNeighbor = previousState[j - 1];

	                     rightNeighbor = 0;

	                 }

	                 else

	                 {

	                     leftNeighbor = previousState[j - 1];

	                     rightNeighbor = previousState[j + 1];

	                 }



	                 states[j] = 1;

	                 if (leftNeighbor == rightNeighbor)

	                     states[j] = 0;

	             }

	         }



	         return states;

	     }

	 


		public static void main(String[] args) 
		{
			int[] states= {1, 0, 1, 1, 0, 1, 0};
			int days=3;
			System.out.println(cellComplete(states,days));

		}

	}