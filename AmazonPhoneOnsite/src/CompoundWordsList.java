import java.util.*;

public class CompoundWordsList {

	public static List<List<String>> getCompoundWords(List<String> inputList) {
		List<List<String>> result = new ArrayList<>();
		Set<String> hashSet = new HashSet<>();
		for(int i = 0; i < inputList.size(); i++) {
			hashSet.add(inputList.get(i));
		}

		for(int i = 0; i < inputList.size(); i++) {
			String word = inputList.get(i);

			for(int j = 0; j < word.length(); j++) {
				String subStringFirst = word.substring(0, j+1);
				String subStringLast = word.substring(j+1);

				List<String> internal = new ArrayList<>();
				if(hashSet.contains(subStringFirst) && hashSet.contains(subStringLast)) {
					internal.add(subStringFirst);
					internal.add(subStringLast);
					result.add(internal);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String[] stringArray = {"rockstar", "rock", "stars", "rocks", "tar", "star", "rockstars", "super", "highway", "high", "way", "superhighway"};
		List<String> inputList = new ArrayList<>();
		for (int i = 0; i < stringArray.length; i++) {
			inputList.add(stringArray[i]);
		}
		System.out.println(getCompoundWords(inputList));
	}
}