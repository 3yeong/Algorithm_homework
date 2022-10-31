import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestRedBlackTree {
	public static void main(String[]args) throws IOException{
		
		int maxsize = 35;
		int size = 0;
		int[] list;
		
		int maxsize1 = 35;
		int size1 = 0;
		int[] list2;
		
		
		File inputFile = null;
		File inputFile2 = null;
		FileReader fileReader = null;
		BufferedReader buffReader = null;
		BufferedReader buffReader2 = null;
		
		inputFile = new File("Insert.txt");
		inputFile2 = new File("Search.txt");
		buffReader = new BufferedReader(new FileReader(inputFile));
		buffReader2 = new BufferedReader(new FileReader(inputFile2));
		
		list = new int[maxsize];
		String line = "";
		list2 = new int[maxsize1];
		
		while((line = buffReader.readLine())!=null) {
			list[size++] = Integer.parseInt(line);
			}
			
		while((line = buffReader2.readLine())!=null) {
			list2[size1++] = Integer.parseInt(line);
			}
		
		RedBlackTree tree = new RedBlackTree(list[0]);
		
		System.out.println("----insert----");
		for(int i=1; i<size; i++) {
			tree.insert(list[i]);
		}
		System.out.println("========================");
		
		System.out.println("----RedBlackTree Search----");
		for(int i = 0; i<size1; i++) {
			System.out.println(list2[i] +" -> "+ tree.Search(list2[i])+ " , 부모에서 자식까지 가는 횟수 : " + tree.count1);
			tree.count1 = 0;
		}
		System.out.println("========================");
	}
	
}
