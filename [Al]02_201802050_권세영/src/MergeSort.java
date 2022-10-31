import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class MergeSort {
	File inputFile = null;
	File outputFile = null;
	FileReader fileReader = null;
	FileWriter fileWriter = null;
	BufferedReader buffReader = null;
	BufferedWriter bufferedWriter = null;
	
	int maxsize = 1000;
	int size = 0;
	int[] list;
	long start, end;
	
	public MergeSort() throws IOException{
		inputFile = new File("test_1000.txt");
		outputFile = new File("test_1000_output.txt");
		buffReader = new BufferedReader(new FileReader(inputFile));
		bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
		
		list = new int[maxsize];
		
		String line = "";
		
		while((line = buffReader.readLine())!=null) {
			list[size++] = Integer.parseInt(line);
		}
		
		size--;
		start = System.currentTimeMillis();
		Merge_sort(list,0,size);
		
		System.out.print("merge sort : ");
		System.out.println(end-start);
		
		for(int i = 0; i<size;i++) {
			bufferedWriter.write(Integer.toString(list[i]));
			bufferedWriter.newLine();
			bufferedWriter.flush();
		}
		
	}
	void Merge_sort(int[] a, int p , int r)
	{
		if(r-p<2) return;
		int mid = (p+r)/2;
		Merge_sort(a, p, mid);
		Merge_sort(a,mid,r);
		Merge(a, p, mid,r);
		
			
	}
	
	void Merge(int[]a, int p, int mid, int r) {
		if(a[mid-1]<=a[mid]) return;
		int  i = p;
		int j = mid;
		int k = 0;
		int []b = new int[r-p];
		
		while(i<mid && j<r) {
			if(a[i]<a[j])
				b[k++]=a[i++];
			else 
				b[k++] = a[j++];
		}
		
		while(i<mid) {
			b[k++] = a[i++];
		}
		while(j < r) {
			b[k++] = a[j++];
		}
		end = System.currentTimeMillis();
		for(int l = p; l < r; l++) {
			a[l] = b[l-p];
		}
	}
	public static void main(String[] args) throws IOException {
		new MergeSort();
	}

}
