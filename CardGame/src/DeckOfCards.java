import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DeckOfCards {
	private ArrayList<Card>deck;
	//private Image backofCardImage;

	public DeckOfCards(ArrayList<Card> deck) {
		super();
		this.deck = deck;
	}
	//zero argument constructor
	public DeckOfCards() {
		List<String> suits=Card.getValidSuits();
		List<String> faceNames=Card.getValidFaceNames();
		deck=new ArrayList<Card>();
		for(String suit:suits) {
			for(String faceName:faceNames) {
				deck.add(new Card(faceName,suit));
			}
		}
	}
	
	public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }


    /**
     * This method will "deal" the top card off the deck
     */
    public Card dealTopCard()
    {
        if (deck.size()>0)
            return deck.remove(0);
        else
            return null;
    }

    /**
     * This method will shuffle the deck of cards
     */
    public void shuffle()
    {
        Collections.shuffle(deck);
    }

}
