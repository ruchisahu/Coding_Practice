import java.util.ArrayList;
import java.util.List;

public class Partition {
	public static List<Integer> partitionLabels(String S)
    {
        List<Integer> part =new ArrayList<Integer>();
        int[] lastindex=new int[26];
        for(int i=0;i<S.length();i++)
        {
            lastindex[S.charAt(i)-'a']=i;
        }
        
        int i=0;
        
        while(i <S.length())
        {
            int end=lastindex[S.charAt(i)-'a'];
           int j=i;
            while(j !=end)
            {
                end=Math.max(end, lastindex[S.charAt(j++) -'a']);
            }
            part.add(j-i+1);
                i=j+1;
        }
        return part;
    }

	public static void main(String[] args) 
	{
		String s="ababcbacadefegdehijhklij";
		System.out.println(partitionLabels(s));

	}

}
