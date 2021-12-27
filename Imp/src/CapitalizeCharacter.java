public class CapitalizeCharacter {
    public static String changeCharacter(String text){
        if(text == null || text.length() == 0) return "";

        /*
        String[] arr = text.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < arr.length; i++){
            // string is immutable so we need to add arr[i].substring(1) to make a new string
            arr[i] = arr[i].substring(0,1).toUpperCase() + arr[i].substring(1);
            sb.append(arr[i]);
            sb.append(" ");
        }
        */
        StringBuilder sb = new StringBuilder();

        sb.append(text.substring(0,1).toUpperCase());
        for(int i = 1; i < text.length(); i++){
            if(text.charAt(i-1) == ' '){
                sb.append(Character.toUpperCase(text.charAt(i)));
            }else {
                sb.append(text.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String arg[]){
        String res = changeCharacter("hello word!");
        System.out.println(res);
    }
}
