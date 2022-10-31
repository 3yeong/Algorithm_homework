package Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SelectionSort {
	File inputFile = null;
	File outputFile = null;
	FileReader fileReader = null;
	FileWriter fileWriter = null;
	BufferedReader buffReader = null;
	BufferedWriter bufferedWriter = null;
	
	int maxsize = 1000;
	int size = 0;
	int[] list;
	int count = 0;
	
	public SelectionSort() throws IOException{
		inputFile = new File("test_1000.txt");
		outputFile = new File("test_1000_output.txt");
		buffReader = new BufferedReader(new FileReader(inputFile));
		bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
		
		list = new int[maxsize];
		
		String line = " ";
		
		while((line = buffReader.readLine())!=null) {
			list[size++] = Integer.parseInt(line);
		}
		size--;
		
		sort(list,size);
		
		System.out.println(count);
		
		for(int i = 0; i<size;i++) {
			bufferedWriter.write(Integer.toString(list[i]));
			bufferedWriter.newLine();
			bufferedWriter.flush();
		}
	}
	
	void swap(int[]a, int i, int j) {
		int ai = a[i], aj = a[j];
		if(ai==aj)return;
		a[i] = aj;
		a[j] =ai;
	}
	void sort(int [] a, int q) {
		for(int i = q; i>0; i--) {
			select(a,i);
		}
	}
	void select(int[]a, int i) {
		int m=0; 
		int p = 1;
		 for (int j = p; j <= i; j++) { 
			 count ++;
			 if (a[j] > a[m]) m = j; }
		 swap(a, i, m); 
	}
	
	public static void main(String[] args) throws IOException{
		new SelectionSort();
	}

}
