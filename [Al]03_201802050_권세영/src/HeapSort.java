import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HeapSort {
	File inputFile = null;
	File outputFile = null;
	FileReader fileReader = null;
	FileWriter fileWriter = null;
	BufferedReader buffReader = null;
	BufferedWriter bufferedWriter = null;
	
	int maxsize = 5000;
	int heap_size=0, size = 0;
	int[] list;
	
	long start, end, start1, end1;
	
	public HeapSort() throws IOException{
		inputFile = new File("test_5000.txt");
		outputFile = new File("test_5000_output.txt");
		buffReader = new BufferedReader(new FileReader(inputFile));
		bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
		
		list = new int[maxsize];
		
		String line = "";
		
		while((line = buffReader.readLine())!=null) {
			list[size++] = Integer.parseInt(line);
		}
		
		
		Max_Heap_Sort(list);
		
		System.out.print("build current Time Millis sub : ");
		System.out.println(end - start);
		
		System.out.print("heapify current Time Millis sub : ");
		System.out.println(end1 - start1);
		for(int i = 0; i<list.length;i++) {
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
	
	void Max_Heap_Sort(int[] a) {
		start = System.currentTimeMillis();
		Build_max_heap(a);
		end = System.currentTimeMillis();
		for(int i = a.length-1; i>=1; i--) {
			swap(a, 0, i);
			heap_size = heap_size-1;
			if(i == a.length -2) {start1 = System.currentTimeMillis();}
			Max_Heapify(a, 0);
			if(i == a.length-2) {end1 = System.currentTimeMillis();}
		}
	}
	
	void Build_max_heap(int[] a) {
		heap_size = a.length;
		for(int  i = (a.length/2); i>=0; i--) {
			Max_Heapify(a, i);
		}
	}
	
	void Max_Heapify(int[] a, int i) {
		int l = (2 * i) ;
		int r = ( 2 * i )+1;
		int largest;
		
		if(l<=(heap_size-1)&&a[l]>a[i]) {
			largest = l;
		}else {
			largest = i;
		}
		if(r<=(heap_size-1)&&a[r]>a[largest]) {
			largest = r;
		}
		if(largest != i) {
			swap(a,i,largest);
			Max_Heapify(a,largest);
		}
	}
	
	public static void main(String [] args) throws IOException {
		new HeapSort();
	}
}
