import java.util.HashMap;

//Rearrange string containing only 'W','D','L' such that it always has this order till any of the characters exhaust
//eg: S="WLDLLD"
//o/p: "WDLDLL"
public class RearrangeString {
	public static String rearrange(String S){
        HashMap<Character,Integer> seen=new HashMap<>();
        StringBuilder sb=new StringBuilder();
        char[] ch=S.toCharArray();
        
        for(int i=0;i<ch.length;i++){
            if(!seen.containsKey(ch[i]))
                seen.put(ch[i],1);
            else
                seen.put(ch[i],seen.get(ch[i])+1);
        }
        
       // for(int i=0;i<S.length();i++){
            int w=seen.getOrDefault('W',0);
            int d=seen.getOrDefault('D',0);
            int l=seen.getOrDefault('L',0);
            int total=d+l+w,i=0;
            
            while(i < total){
                if(w > 0){
                    sb.append('W');
                    w--;
                    i++;
                }
                 if(d > 0){
                    sb.append('D');
                    d--;
                    i++;
                        
                }
                 if(l > 0){
                    sb.append('L');
                    l--;
                    i++;
                    
                }
                
              //  i++;
                   // sb.append('W');
                
            //}
        }
        
        return sb.toString();
    }

	public static void main(String[] args) {
		System.out.println(rearrange("WLDLLD"));

	}

}
