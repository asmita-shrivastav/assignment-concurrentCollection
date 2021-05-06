package Day8;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class concurrentHashmapThread {
	
	public static void main(String[] args) {
		ConcurrentMap<String, List<Integer>> chm = new ConcurrentHashMap<>();
		
		new addThread(chm, "Student 1", 3).start();
		new addThread(chm, "Student 2", 52).start();
		new addThread(chm, "Student 3", 82).start();
		new removeThread(chm, "Student 2");
		new addThread(chm, "Student 4", 61).start();
		new removeThread(chm, "Student 3");
		new addThread(chm, "Student 5", 45).start();
		
		for(int i =0;i<2; i++) {
			new readThread(chm).start();
		}

	}

}
