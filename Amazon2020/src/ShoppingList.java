/*
 * Example: shopping list={Apple, Mango, Apple, Banana, Kiwi, Grapes, Watermelon}
Coupon list{
{Apple, Mango},
{Banana, Anything, Grapes}
}

List 1 = List<List> Coupon
List 2 = List shoppingCart
Coupon= {{orange},{apple,apple},{apple,anything,orange}}
shoppingCart= {orange,apple,apple,apple,apricot,,orange}
o/p= true

shoppingCart= {orange,apple,apple,orange,apple,apricot,,orange}
o/p= true

shoppingCart= {orange,apple,apple,orange,appricote,apple,orange,apple}
o/p= false

shoppingCart= {apple,apple,orange,apple,appricote,orange}
o/p= true
If everything in the coupon list match with the shopping list in the same order than the coupon will apply else it wont. In the coupon list the sublists have to match as is but
 there cna be more elements between two lists.
 */
public class ShoppingList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
