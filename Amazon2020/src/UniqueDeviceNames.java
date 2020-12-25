import java.util.*;

/*
 * You are working on the Amazon Devices team and need to create unique device names to be used in a residential loT (Internet of Things) system. If a device name already exists in the system, an integer number is added at the end of the name to make it unique. The integer added starts with land is incremented by 1 for each new request of an existing device name.
Given a list of device name requests, write an algorithm to process all the requests and output a list of the corresponding unique device names.

Input
The input to the function/method consists of two arguments:
num, an integer representing the number of device names;
devicenames, a list of strings representing the device names;

Output
Return a list of strings representing the usernames in the order assigned

Constraints
1 <= num <= 10^5
1 <= length of devicenames[i] >= 20
0 <= i < num

Note
devicenames contains only lowercase English letters in the range ASCII[a-z].

Example
Input:
num = 6
devicenames = ["switch", "tv", "switch", "tv","switch", "tv"]

Output:
["switch","tv","switch1", "tv1", "switch2", "tv2"]

Explanation:
devicenames[0] = "switch" is unique. uniqueDevicename[0]="switch" devicenames[1] = "tv" is unique. uniqueDevicename[1]="tv"
devicenames[2] = devicenames[0]. Add 1 at the end the previous unique username "switch", uniqueDevicename[2]="switch1"
devicenames[3] = devicenames[1]. Add 1 at the end the previous unique username "tv", uniqueDevicename[3]="tv1"
devicenames[4] = devicenames[2]. Increment by 1 the number at the end of the previous unique username "switch1", uniqueDevicenames[4]="switch2"
devicenames[5] = devicenames[3]. Increment by 1 the number at the end of the previous unique username "tv1". uniqueDevicenames[5]="tv2"
return unique Devicenames = ["switch", "tv" "switch1" "tv1", "switch2", "tv2"]

https://aonecode.com/amazon-online-assessment-unique-device-names
 */
public class UniqueDeviceNames {
	public static String[] GetUniqueNames(String[] devices){
        //maintain a hashmap for devices we have already seen
        HashMap<String,Integer> seenNames = new HashMap<>();
        for(int i = 0; i < devices.length; i++){
            if(!seenNames.containsKey(devices[i])){
                //the first time we find a device store its name and 1
                //store 1 as the value because the next time we find
                //a device with the same name it gets 1 appended to it
                seenNames.put(devices[i],1);
            }
            else{
                String updatedName = devices[i] + seenNames.get(devices[i]);
                seenNames.put(devices[i], seenNames.get(devices[i]) + 1);
                devices[i] = updatedName;
            }
        }
        return devices;
    }
	//sol2
private static String[] getNames(int n, String[] devices){
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            String device = devices[i];
            if (map.containsKey(devices[i])){
                devices[i] = devices[i] + map.get(devices[i]);
            }
            map.put(device, map.getOrDefault(device, 0) + 1);
        }
        return devices;        
    }
    public static void main(String[] args) {
        
        String[] ans = getNames(6, new String[]{"switch", "tv", "switch", "tv","switch", "tv"});
        for (String a : ans){
            System.out.print(a + ", ");
        }
    }
}
