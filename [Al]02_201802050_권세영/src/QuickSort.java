import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class QuickSort {
	File inputFile = null;
	File outputFile = null;
	FileReader fileReader = null;
	FileWriter fileWriter = null;
	BufferedReader buffReader = null;
	BufferedWriter bufferedWriter = null;
	
	int maxsize = 5000;
	int size = 0;
	int[] list;
	
	long start, end, start_random, end_random;
	
	public QuickSort() throws IOException{
		inputFile = new File("sorted_5000.txt");
		outputFile = new File("sorted_ 5000_output.txt");
		buffReader = new BufferedReader(new FileReader(inputFile));
		bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
		
		list = new int[maxsize];
		
		String line = "";
		
		while((line = buffReader.readLine())!=null) {
			list[size++] = Integer.parseInt(line);
		}
		
		size--;
		start = System.currentTimeMillis();
		Quick_sort(list, 0, size);
		end = System.currentTimeMillis();
		
		System.out.print("quick sort : ");
		System.out.println(end-start);
		
		
		for(int i = 0; i<size;i++) {
			bufferedWriter.write(Integer.toString(list[i]));
			bufferedWriter.newLine();
			bufferedWriter.flush();
			}
		
		start_random = System.currentTimeMillis();
		Quick_sort_random(list,0,size);
		end_random = System.currentTimeMillis();
		
		System.out.print("quick random sort : ");
		System.out.println(end_random - start_random);
		
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
		a[j] = ai;
	}
	
	void Quick_sort(int[] a, int p, int r) {
		if(p<r) {
			int q = partition(a,p,r);
			Quick_sort(a,p,q-1);
			Quick_sort(a,q+1,r);
		}
	}
	
	int partition(int[] a, int p, int r) {
		int pivot = a[r];
		int i = p-1;
		int j = p;
		for(;j<r; j++) {
			if(a[j]<=pivot) {
				i++;
				swap(a,i,j);}
		}
		swap(a,i+1,r);
		return i+1;
	}
	
	void Quick_sort_random(int[] a, int p, int r) {
		if(p<r) {
			int q = partition_random(a,p,r);
			Quick_sort(a,p,q-1);
			Quick_sort(a,q+1,r);
		}
	}
	
	int partition_random(int[] a, int p, int r) {
		int pivot =(int) (Math.random()*(r-p))+ p;
		int i = p-1;
		int j = p;
		for(;j<r; j++) {
			if(a[j]<=a[pivot]) {
				i++;
				swap(a,i,j);}
		}
		swap(a,i+1,pivot);
		return i+1;
	}
	
	public static void main(String[] args) throws IOException {
		new QuickSort();
	}


}
