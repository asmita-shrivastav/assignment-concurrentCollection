package Day8;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class sortFiles {
	private final static String FOLDER_NAME = "F://Test/";

	public void sortbyName(List<String> all) {
		System.out.println("-----Sort by Name----");
		Collections.sort(all);
		for (String c : all)
			System.out.println(c);
	}

	public void sortByTypeAsc(List<File> all) {
		System.out.println("-----Sort by TYPE ASC-----");
		Collections.sort(all, new Comparator<File>() {
			public int compare(File f1, File f2) {

				String t1 = f1.getName().split("\\.")[1];
				String t2 = f2.getName().split("\\.")[1];

				return t1.compareTo(t2);
			}
		});

		for (File file : all) {
			System.out.println(file.getName());
		}
	}

	public void sortByTypeDESC(List<File> all) {
		System.out.println("-----Sort by TYPE DESC-----");
		Collections.sort(all, new Comparator<File>() {
			public int compare(File f1, File f2) {

				String t1 = f1.getName().split("\\.")[1];
				String t2 = f2.getName().split("\\.")[1];

				return t2.compareTo(t1);
			}
		});

		for (File file : all) {
			System.out.println(file.getName());
		}
	}

	public void sortbyDate(File[] all) {
		System.out.println("-----Sort by DATE-----");
		Arrays.sort(all, new Comparator<File>() {
			public int compare(File f1, File f2) {
				long l1 = getFileTime(f1);
				long l2 = getFileTime(f2);
				return Long.valueOf(l1).compareTo(l2);
			}
		});
		for (File file : all)
			System.out.println(file.getName());

	}

	public static long getFileTime(File file) {
		try {
			BasicFileAttributes attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
			return attr.creationTime().toInstant().toEpochMilli();
		} catch (IOException e) {
			throw new RuntimeException(file.getAbsolutePath(), e);
		}
	}

	public static void main(String[] args) throws IOException {

		sortFiles sc = new sortFiles();
		File directoryPath = new File(FOLDER_NAME);
		List<File> fileNames = new ArrayList<>();

		File filesList[] = directoryPath.listFiles();
		List<String> all = new ArrayList<String>();
		for (File file : filesList) {
			all.add(file.getName());

			if (file.isFile())
				fileNames.add(file);

		}

		System.out.println("1: Sort by Name");
		System.out.println("2: Sort by Date");
		System.out.println("3: Sort by Type(ASC)");
		System.out.println("4: Sort by Type (DESC)");

		int i = 0;
		Scanner scanner = new Scanner(System.in);
		i = scanner.nextInt();

		if (i == 1)
			sc.sortbyName(all);
		else if (i == 2)
			sc.sortbyDate(filesList);
		else if (i == 3)
			sc.sortByTypeAsc(fileNames);
		else if (i == 4)
			sc.sortByTypeDESC(fileNames);

	}
}
