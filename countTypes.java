package Day8;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

public class countTypes {
	private final static String FOLDER_NAME = "F://Test/";

	public static void main(String[] args) throws IOException {
		File directoryPath = new File(FOLDER_NAME);
		Queue<String> fileNamesJPG = new ArrayDeque<String>();
		Queue<String> fileNamesTXT = new ArrayDeque<String>();
		Queue<String> fileNamesDOCX = new ArrayDeque<String>();

		File filesListJPG[] = directoryPath.listFiles(new FileFilter() {
			@Override
			public boolean accept(File file) {
					return file.getName().endsWith(".jpg");
			}
		});

		File filesListDOC[] = directoryPath.listFiles(new FileFilter() {
			@Override
			public boolean accept(File file) {
					return file.getName().endsWith(".docx");
			}
			
		});
		
		File filesListTXT[] = directoryPath.listFiles(new FileFilter() {
			@Override
			public boolean accept(File file) {
					return file.getName().endsWith(".txt");
			}
		});
		
		for (File file : filesListJPG) {
			if (file.isFile())
				fileNamesJPG.add(file.getName());
		}
		for (File file : filesListDOC) {
			if (file.isFile())
				fileNamesDOCX.add(file.getName());
		}
		for (File file : filesListTXT) {
			if (file.isFile())
				fileNamesTXT.add(file.getName());
		}
		
		System.out.println("No. of JPG files = "+fileNamesJPG.size());
		System.out.println("No. of DOCX files = "+fileNamesDOCX.size());
		System.out.println("No. of TXT files = "+fileNamesTXT.size());
	}

}


