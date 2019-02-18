import java.util.List;
import java.util.ArrayList;

/**
 * The Deck class represents a shuffled deck of cards.
 * It provides several operations including
 *      initialize, shuffle, deal, and check if empty.
 */
public class Deck {

 /**
  * cards contains all the cards in the deck.
  */
 private List<Card> cards;

 /**
  * size is the number of not-yet-dealt cards.
  * Cards are dealt from the top (highest index) down.
  * The next card to be dealt is at size - 1.
  */
 private int size;


 /**
  * Creates a new <code>Deck</code> instance.<BR>
  * It pairs each element of ranks with each element of suits,
  * and produces one of the corresponding card.
  * @param ranks is an array containing all of the card ranks.
  * @param suits is an array containing all of the card suits.
  * @param values is an array containing all of the card point values.
  */
 public Deck(String[] ranks, String[] suits, int[] values) {
   cards = new ArrayList<Card>();
   int i = 0;
   for(String item : suits)
   {
     while(i<ranks.length)
     {
       cards.add(new Card(ranks[i], item, values[i]));
       //System.out.println(cards.get(i));
       i++;
     }
     i = 0;
   }
   size = cards.size();
 }


 /**
  * Determines if this deck is empty (no undealt cards).
  * @return true if this deck is empty, false otherwise.
  */
 public boolean isEmpty() {
  if(size == 0)
    return true;
  return false;
 }

 /**
  * Accesses the number of undealt cards in this deck.
  * @return the number of undealt cards in this deck.
  */
 public int size() {
  return size;
 }


   public void shuffle() {
   size = cards.size();
    double rand = 0;
    int temp = 0;
    Card hold;
    Card temps;
    for(int k = size-1; k > 0; k--)
    {
      rand = Math.random();
      temp = (int)(rand * (k+1));
      hold = cards.get(k);
      temps = cards.get(temp);
      cards.set(k, temps);
      cards.set(temp, hold);
    }
   }

 /**
  * Deals a card from this deck.
  * @return the card just dealt, or null if all the cards have been
  *         previously dealt.
  */
 public Card deal() {
   size--;
 //  System.out.println(size);
   if(size == -1)
     return null;
  return cards.get(size);
 }

 /**
  * Generates and returns a string representation of this deck.
  * @return a string representation of this deck.
  */
 @Override
 public String toString() {
  String rtn = "size = " + size + "\nUndealt cards: \n";

  for (int k = size - 1; k >= 0; k--) {
   rtn = rtn + cards.get(k);
   if (k != 0) {
    rtn = rtn + ", ";
   }
   if ((size - k) % 2 == 0) {
    // Insert carriage returns so entire deck is visible on console.
    rtn = rtn + "\n";
   }
  }

  rtn = rtn + "\nDealt cards: \n";
  for (int k = cards.size() - 1; k >= size; k--) {
   rtn = rtn + cards.get(k);
   if (k != size) {
    rtn = rtn + ", ";
   }
   if ((k - cards.size()) % 2 == 0) {
    // Insert carriage returns so entire deck is visible on console.
    rtn = rtn + "\n";
   }
  }

  rtn = rtn + "\n";
  return rtn;
 }
}

