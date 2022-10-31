package Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InsertionSort {
	File inputFile = null;
	File outputFile = null;
	FileReader fileReader = null;
	FileWriter fileWriter = null;
	BufferedReader buffReader = null;
	BufferedWriter bufferedWriter = null;
	
	int maxsize = 1000;
	int size = 0;
	int[] list;
	int count=0;
	
	public InsertionSort() throws IOException {
		inputFile = new File("test_1000.txt");
		outputFile = new File("test_1000_output.txt");
		buffReader = new BufferedReader(new FileReader(inputFile));
		bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
		
		list = new int[maxsize];
		
		String line = "";
		
		while ((line=buffReader.readLine())!=null) {
			list[size++] = Integer.parseInt(line);

		}
		size--;
		
		sort(list);
		
		System.out.println(count);
		
		for(int i = 0; i<size;i++) {
			bufferedWriter.write(Integer.toString(list[i]));
			bufferedWriter.newLine();
			bufferedWriter.flush();
		}
		
	}
	
	 void sort(int[] a) {
	      sort(a,1);
	   }
	   void sort(int[] a, int n) {
	      if(n>a.length-1)
	         return;
	      int ai = a[n], j=n;
	      for(j=n; j>0&&a[j-1]>ai; j--) {
	    	  count++;
	         a[j]=a[j-1];
	         }
	      a[j]=ai;
	      sort(a,n+1);
	   }


	public static void main(String[]args) throws IOException{
		new InsertionSort();
	}
}
