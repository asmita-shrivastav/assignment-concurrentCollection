package Day8;

import java.util.*;

public class linkedHM {

	public static void main(String[] args) {
		LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

		// adding key-value pairs to LinkedHashMap object
		lhm.put("cb", 52);
		lhm.put("op", 74);
		lhm.put("ab", 5);
		lhm.put("sd", 0);
		lhm.put("hy", 881);
		System.out.println("Sorted Keys :\n");

		Map<String, Integer> map = new TreeMap<>(lhm);

		for (String key : map.keySet()) {
			System.out.println("Key -> " + key + ": Value -> " + lhm.get(key));
		}
	}

}
