package Day8;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

public class removeThread  extends Thread{
	private ConcurrentMap<String, List<Integer>> map;
	private String key;

	public removeThread(ConcurrentMap<String, List<Integer>> map, String key) {
		this.map = map;
		this.key = key;
	}

	public void run() {
		map.remove(key);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e);

		}

	}
}
