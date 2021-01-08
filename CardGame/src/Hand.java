import java.util.*;

public class Hand<T extends Card> {
	public List<T> cards=new ArrayList<T>();
	/*public int score() {
		int score=0;
		for(T card:cards) {
			
		}
	}
	*/
	public void addCard(T card) {
		cards.add(card);
	}
	public void print() {
		for (Card card : cards) {
			System.out.println(card);
		}
	}	

}
