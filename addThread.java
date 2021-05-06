package Day8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

public class addThread extends Thread {
	private ConcurrentMap<String, List<Integer>> map;
	private String threadName;
	private int k;

	public addThread(ConcurrentMap<String, List<Integer>> map, String threadName, int k) {
		this.map = map;
		this.threadName = threadName;
		this.k = k;
	}

	public void run() {
		
		List<Integer> list =  new ArrayList<Integer>();
		for(int i = k; i< k+5; i++) {
			list.add(i);
		}
		map.put(threadName, list);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e);

		}
	}
}
