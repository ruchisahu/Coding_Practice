import java.util.Comparator;
import java.util.PriorityQueue;

public class BuySellProfit {
	/*
	   price  share buy/sell
	  ['150', '5', 'buy'],    # Order A
	  ['190', '1', 'sell'],   # Order B
	  ['200', '1', 'sell'],   # Order C
	  ['100', '9', 'buy'],    # Order D
	  ['140', '8', 'sell'],   # Order E 5
	  ['210', '4', 'buy'],    # Order F 3 + 1

	  output: 9;
	*/

	//100, 140, 150,
	//rule1: buy
	private class Node {
	    public int price;
	    public int share;
	    public Node(int price, int share) {
	        this.price = price;
	        this.share = share;
	    }
	}

	private class BuyNodeComparator implements Comparator<Node> {
	    @Override
	    public int compare(Node a, Node b) {
	        return b.price - a.price;
	    }
	}

	private class SellNodeComparator implements Comparator<Node> {
	    @Override
	    public int compare(Node a, Node b) {
	        return a.price - b.price;
	    }
	}

	int order_book(String[][] orders) {
	    if(orders == null || orders.length == 0 || orders[0].length == 0) {
	        return 0;
	    }
	    int res = 0;
	    PriorityQueue<Node> buypq = new PriorityQueue<Node>(new BuyNodeComparator());
	    PriorityQueue<Node> sellpq = new PriorityQueue<Node>(new SellNodeComparator());

	    for(int i = 0; i < orders.length; i++) {
	        int price = Integer.parseInt(orders[i][0]);
	        int share = Integer.parseInt(orders[i][1]);

	        if(orders[i][2].equals("buy")) {
	            Node buynode = new Node(price, share);
	            while(!sellpq.isEmpty() && sellpq.peek().price <= buynode.price && buynode.share > 0) {
	                Node sellnode = sellpq.poll();
	                if(sellnode.share > buynode.share) {
	                    res += buynode.share;
	                    sellnode.share = sellnode.share - buynode.share;
	                    sellpq.offer(sellnode);
	                    buynode.share = 0;
	                } else {
	                    // sellnode.share <= buynode.share;
	                    res += sellnode.share;
	                    buynode.share -= sellnode.share;
	                }
	            }
	            if(buynode.share > 0) {
	                buypq.offer(buynode);
	            }
	        } else {
	            // “SELL” buy price >= sell price;
	            Node sellnode = new Node(price, share);
	            while(!buypq.isEmpty() && buypq.peek().price >= sellnode.price && sellnode.share > 0) {
	                Node buynode = buypq.poll();
	                if(buynode.share > sellnode.share) {
	                    res += sellnode.share;
	                    buynode.share = buynode.share - sellnode.share;
	                    buypq.offer(buynode);
	                    sellnode.share = 0;
	                } else {
	                    // buynode.share >= sellnode.share;
	                    res += buynode.share;
	                    sellnode.share -= buynode.share;
	                }
	            }
	            if(sellnode.share > 0) {
	                sellpq.offer(sellnode);
	            }
	        }
	    }
	    return res;
	
	}
	public static void main(String[] args) {
		
		String[][] orders= {{"150", "5", "buy"},{"190", "1", "sell"},{"200","1","sell"},{"100", "9", "buy"},{"140", "8", "sell"},{"210", "4", "buy"}};
		BuySellProfit b=new BuySellProfit(); 
		 System.out.println(b.order_book(orders));


	}

}
