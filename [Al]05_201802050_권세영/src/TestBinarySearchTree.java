import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestBinarySearchTree {
	public static void main(String[]args) throws IOException{
		BinarySearchTree tree = new BinarySearchTree(); 
		BinarySearchTree tree2 = new BinarySearchTree(); 
		
		File inputFile = null;
		File inputFile2 = null;
		FileReader fileReader = null;
		BufferedReader buffReader = null;
		BufferedReader buffReader2 = null;
		
		int maxsize = 35;
		int size = 0;
		int[] list;
		
		int maxsize1 = 35;
		int size1 = 0;
		int[] list3;
		
		inputFile = new File("Insert.txt");
		inputFile2 = new File("Delete.txt");
		buffReader = new BufferedReader(new FileReader(inputFile));
		buffReader2 = new BufferedReader(new FileReader(inputFile2));
		
		list = new int[maxsize];
		String line = "";
		list3 = new int[maxsize1];
		
		while((line = buffReader.readLine())!=null) {
		list[size++] = Integer.parseInt(line);
		}
		
		while((line = buffReader2.readLine())!=null) {
			list3[size1++] = Integer.parseInt(line);
			}
		
		int[] list2 = new int[maxsize];
		int[] list4 = new int[maxsize];
		
		System.arraycopy(list,0,list4,0,list.length);
		
		int a = size;
		for(int i = 0; i<size; i++) {
			a--;
			int mid = list4[a/2];
			int ai = list4[a], aj = list[a/2];
			list4[a] = aj;
			list4[a/2] = ai;
			list2[i] = mid;
			if(a<2) {
				list2[i] = list4[0];
				list2[i+1] = list4[1];
				break;
			}
		}
		
		System.out.println("----insert----");
		for(int i=0; i<size; i++) {
			System.out.print(list[i]);
			System.out.print(" : ");
			tree.insert(list[i]);
		}
		System.out.println("========================");
		
		System.out.println("----medeian insert----");
		for(int i=0; i<size; i++) {
			System.out.print(list2[i]);
			System.out.print(" : ");
			tree2.MedianInsert(list2[i]);
		}
		System.out.println("========================");
		
		if(tree.count1 > tree.count2) {
			System.out.print("insert의 깊이 : ");
			System.out.println(tree.count1);
			System.out.println("========================");
			
		}else {
			System.out.print("insert의 깊이 : ");
			System.out.println(tree.count2);
			System.out.println("========================");
		}
		
		if(tree.count3 > tree2.count4) {
			System.out.print("median-insert의 깊이 : ");
			System.out.println(tree2.count3);
			System.out.println("========================");
		}else {
			System.out.print("median-insert의 깊이 : ");
			System.out.println(tree2.count4);
			System.out.println("========================");
		}
		
		System.out.println("----Successor----");
		System.out.println(tree.Successor());
		System.out.println("----Preducessor----");
		System.out.println(tree.Predecessor());
		System.out.println("========================");
		
		System.out.println("Delete하기 전 50, 1, 7, 8, 24, 42, 10 의 존재 여부 확인");
		System.out.println("----inerative----");
		System.out.println(tree.Inerative(50));
		System.out.println(tree.Inerative(1));
		System.out.println(tree.Inerative(7));
		System.out.println(tree.Inerative(8));
		System.out.println(tree.Inerative(24));
		System.out.println(tree.Inerative(42));
		System.out.println(tree.Inerative(10));
		System.out.println("========================");
		
		System.out.println("----Recursive----");
		System.out.println(tree.Inerative(50));
		System.out.println(tree.Inerative(1));
		System.out.println(tree.Inerative(7));
		System.out.println(tree.Inerative(8));
		System.out.println(tree.Inerative(24));
		System.out.println(tree.Inerative(42));
		System.out.println(tree.Inerative(10));
		System.out.println("========================");
		
		System.out.println("----data Delete----");
		for(int i = 0; i<list.length; i++) {
			tree.delete(list3[i]);
		}
		System.out.println("========================");
		
		
		
		
		
		
		
	}

}
