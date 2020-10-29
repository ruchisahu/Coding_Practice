import java.util.*;

public class PopularNtoys {
public static List<String> getTopToys(int numCompetitors, int topNCompetitors, String[] competitors, int numReviews, String[] reviews) {
	List<String> word=new ArrayList<String>();
    HashMap<String, Integer> map=new HashMap<String, Integer>();
	
	for(String wor:competitors)
	{
		/*if(map.containsKey(word))
		{
			map.put(word, map.get(word)+1);
		}
		else
		*/
			map.put(wor, 0);
	}
	
	for(String review: reviews)
	{
		String[] strs = review.split("\\W");
		Set<String> allword = new HashSet<String>();
		for(String s : strs) {
			
			allword.add(s.toLowerCase());
		}
		
		Iterator<String> i=allword.iterator();  
        while(i.hasNext())  
        {  
        	String w=i.next();
        
        if(map.containsKey(w))
        	 if(map.containsKey(w))
 			{
 				map.put(w, map.get(w)+1);
 				// System.out.println(w+"   "+map.get(w)); 
 			}
 		 
 			}
 		}
        Queue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a, b)->a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
		maxHeap.addAll(map.entrySet());
		while(!maxHeap.isEmpty() && numCompetitors-- > 0) {
			word.add(maxHeap.poll().getKey());
		}
		//print result
		for(int i=0; i<word.size();i++)
		{
			System.out.println(word.get(i));
		}
		
		return word;
		
	}

	public static void main(String[] args) {
		String[] reviews1 = {"Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
				"The new Elmo dolls are super high quality",
				"Expect the Elsa dolls to be very popular this year, Elsa!",
				"Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
				"For parents of older kids, look into buying them a drone",
				"Warcraft is slowly rising in popularity ahead of the holiday season"};
				
				String[] keywords1 = {"elmo", "elsa", "legos", "drone", "tablet", "warcraft"};
				int k=2;
				getTopToys(k, 6,  keywords1, 2, reviews1);
		    //  FindTop(k,keywords1, reviews1);
				int numToys = 3;
			      int topToys = 2;
			      String[] toys = {"source","point","discover"};
			      int numQuotes = 3;
			      String[] quotes = {
			      "suffer like institution enjoy nation federal audience still in ",
			      "can discover ",
			      "point "};
			      getTopToys(k, 6,  toys, 2, quotes);
			      
			      /////
			      String[] toys1 ={"region","clearly","follow","business","describe","authority","everyone","power","home","education"};
			    		 String[] quotes1 = {
			      "school people clearly religious agreement? church scene bit every technology back! entire against everybody civil region never? industry business describe laugh suffer? everyone. television push service energy report clearly president everyone. home",
			      "region describe left region power seek describe authority interest often. everyone general ",
			      "business must clearly period, price? describe several goal decade power home leader sit talk charge standard movie reality business foreign especially. away I program become anything interview class business shake` power else space particularly home partner method parent? study come describe history same? film, against pretty. ",
			      "garden last kind behind may animal mind point step oil any` authority education deep? country none. scientist space imagine moment ten sound before deal industry since ahead finally hit problem run` identify. college member remember ",
			      "color sex baby house five hear result` really any situation talk himself back somebody special media first report style spring board after likely seat agency point purpose apply financial because seven because` Mr` Republican ago huge look policy church from history stand ",
			      "follow recently product business clearly road him? next everyone cancer lay` member on sure, movement come everyone! method region air, church see quite` shoulder down parent beat quickly authority especially likely follow form seem discussion present ",
			      "final cost cultural floor legal Mr! professor? home amount skill follow ",
			      "laugh business lie region morning key carry rest inside indicate oil over pattern power region before color summer maintain power region possible method baby, describe century education option peace chair few item stock hear cell message picture anyone follow language authority agreement movement stage foot ",
			      "follow heat soldier. enough sexual soldier perform future must degree matter affect fine legal no contain, leg able! off information born article record join role American clearly generation material among new structure power during stuff financial power plan avoid speak figure notice party international? cover crime growth take power program our never cost team ",
			      "education power show child particular! else! television management ground standard cause receive suddenly smile scene along consumer number make perform follow serve power home common, enough hundred employee character region option policy pretty professional power tend region` image? step fall different law huge state history like agency home! exist pass everyone legal "};
                 
			    		 
			    		 getTopToys(k, 6,  toys1, 2, quotes1);

	}

}
