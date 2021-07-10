import java.util.Stack;

public class simplifyPath {
	 public static String normalize(String path) {
         Stack<String> s = new Stack<>();
       for (String p : path.split("/")) {
           if (p.isEmpty() || ".".equals(p)) continue;
           if ("..".equals(p)) {
               if (!s.isEmpty()) s.pop();
           } else s.push(p);
       }
       return "/" + String.join("/", s);
   }

	public static void main(String[] args) {
		System.out.println(normalize("/abc/def/../"));    //#=> 'abc/'
		System.out.println(normalize("/abc/def/../../"));  // #=> ''
		System.out.println(normalize("abc/def/../../../"));// #=> '../'
		System.out.println(normalize("/abc/def/../../../"));// #=> Invalid path name

	}

}
