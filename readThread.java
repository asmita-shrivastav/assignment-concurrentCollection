package Day8;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

public class readThread extends Thread {

	private ConcurrentMap<String, List<Integer>> map;

	public readThread(ConcurrentMap<String, List<Integer>> map) {
		this.map = map;

	}

	public void run() {
		Set<String> ksv = map.keySet();
		Iterator<String> i = ksv.iterator();
		
		while (i.hasNext()) {
			
			String key = i.next();
			List<Integer> val = map.get(key);
			System.out.println("\n");
			System.out.println(key +" :  "+val);
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e);

		}

	}

}
