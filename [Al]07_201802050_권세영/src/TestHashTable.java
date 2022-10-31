import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestHashTable {
	public static void main(String[]args) throws IOException{
		
		int maxSize1 = 97; //insert
		int maxSize2 = 12; //delete
		int maxSize3 = 13; //search
		int size = 0;
		int size1 = 0; //insert
		int size2 = 0; //delete
		int size3 = 0; //search
		int[] list1_1;//Linear
		int[] list1_2;//Quadratic
		int[] list1_3;//Double
		int[] list;
		int[] list2; //delete
		int[] list3; //search
		
		File inputFile = null;
		File inputFile2 = null;
		File inputFile3 = null;
		File outputFile = null;
		File outputFile2 = null;
		File outputFile3 = null;
		FileReader fileReader = null;
		FileWriter fileWriter = null;
		BufferedReader buffReader = null;
		BufferedReader buffReader2 = null;
		BufferedReader buffReader3 = null;
	    BufferedWriter bufferedWriter = null;
	    BufferedWriter bufferedWriter2 = null;
	    BufferedWriter bufferedWriter3 = null;
		
		inputFile = new File("Data1.txt");
		inputFile2 = new File("Data2.txt");
		inputFile3 = new File("Data3.txt");
		outputFile = new File("Linear_Output.txt");
		outputFile2 = new File("Quadratic_Output.txt");
		outputFile3 = new File("Double_Output.txt");
		buffReader = new BufferedReader(new FileReader(inputFile));
		buffReader2 = new BufferedReader(new FileReader(inputFile2));
		buffReader3 = new BufferedReader(new FileReader(inputFile3));
		bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
		bufferedWriter2 = new BufferedWriter(new FileWriter(outputFile2));
		bufferedWriter3 = new BufferedWriter(new FileWriter(outputFile3));
		
		list1_1 = new int[maxSize1];
		list1_2 = new int[maxSize1];
		list1_3 = new int[maxSize1];
		list = new int[57];
		list2 = new int[maxSize2];
		list3 = new int[maxSize3];
		String line = "";
		
		while((line = buffReader.readLine())!=null) {
			list[size++] = Integer.parseInt(line);
		}
		
		while((line = buffReader2.readLine())!=null) {
			list2[size2++] = Integer.parseInt(line);
		}
		
		while((line = buffReader3.readLine())!=null) {
			list3[size3++] = Integer.parseInt(line);
		}
		
		HashTable ht = new HashTable();
		
		System.out.println("====== Linear_insert ======");
		for(int i = 0; i<list.length-1;i++) {
			ht.Linear_insert(list1_1,list[i]);
		}
		
		System.out.println("====== Quadratic_Insert ======");
		for(int i = 0; i<list.length-1;i++) {
			ht.Quadratic_Insert(list1_2,list[i]);
		}
		
		System.out.println("====== Double_Insert ======");
		for(int i = 0; i<list.length-1;i++) {
			ht.Double_Insert(list1_3,list[i]);
		}
		
		System.out.println("====== Ãæµ¹ È½¼ö ======");
		System.out.println("Linear: "+ht.count1 );
		System.out.println("Quadratic: "+ht.count2 );
		System.out.println("Double: "+ht.count3 );
		
		System.out.println("====== Linear_Delete ======");
	
		for(int i = 0; i<list2.length-1;i++) {
			ht.Linear_Delete(list1_1, list2[i]);
		}
		System.out.println("====== Quadratic_Delete ======");
		
		for(int i = 0; i<list2.length-1;i++) {
			ht.Quadratic_Delete(list1_2, list2[i]);
		}
		System.out.println("====== Double_Delete ======");
		
		for(int i = 0; i<list2.length-1;i++) {
			ht.Double_Delete(list1_3, list2[i]);
		}
		
		
		
		System.out.println("====== Linear_Search ======");	
		for(int i =0; i<list3.length-1;i++) {
			if(ht.Linear_Search(list1_1, list3[i]) == true) {
				bufferedWriter.write(Integer.toString(list3[i])+" ");
				bufferedWriter.flush();
			}else {
				bufferedWriter.write("\n");
				//bufferedWriter.newLine();
				bufferedWriter.flush();
			}
			
		}
		
		
		System.out.println("====== Quadratic_Search ======");	
		for(int i =0; i<list3.length-1;i++) {
			if(ht.Quadratic_Search(list1_2, list3[i]) == true) {
				bufferedWriter2.write(Integer.toString(list3[i])+" ");
				bufferedWriter2.flush();
			}else {
				bufferedWriter2.write("\n");
				//bufferedWriter.newLine();
				bufferedWriter2.flush();
			}
			
		}
		
		System.out.println("====== Double_Search ======");	
		for(int i =0; i<list3.length-1;i++) {
			if(ht.Double_Search(list1_3, list3[i]) == true) {
				bufferedWriter3.write(Integer.toString(list3[i])+" ");
				bufferedWriter3.flush();
			}else {
				bufferedWriter3.write("\n");
				//bufferedWriter.newLine();
				bufferedWriter3.flush();
			}
			
		}
		
	}
}
