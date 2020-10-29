import java.util.*;

public class CollectionMaptoArrayList {
    public static void main(String[] args) {
	 Map<String, String> map = new HashMap<String, String>();
	 
	 
	 map.put("Android", "Mobile");
     map.put("Eclipse IDE", "Java");
     map.put("Eclipse RCP", "Java");
     map.put("Git", "Version control system");

     // convert keys to array
     String[] strings = keysAsArray(map);
     for (String string : strings) {
         System.out.println(string);
     }
     // convert keys to list
     List<String> list = keysAsList(map);
     for (String string : list) {
         System.out.println(string);
     }
 }



 private static String[] keysAsArray(Map<String, String> map) {
     return map.keySet().toArray(new String[map.keySet().size()]);
 }

 // assumes the key is of type String
 private static List<String> keysAsList(Map<String, String> map) {
     List<String> list = new ArrayList<String>(map.keySet());
     return list;
 }


}
