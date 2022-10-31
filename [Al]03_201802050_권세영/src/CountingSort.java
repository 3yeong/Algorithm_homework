import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CountingSort {
	File inputFile = null;
	File outputFile = null;
	FileReader fileReader = null;
	FileWriter fileWriter = null;
	BufferedReader buffReader = null;
	BufferedWriter bufferedWriter = null;
	
	int maxsize = 5000;
	int size = 0;
	int[] list;
	
	long start, end;
	
	public CountingSort() throws IOException{
		inputFile = new File("test_5000.txt");
		outputFile = new File("test_5000_output.txt");
		buffReader = new BufferedReader(new FileReader(inputFile));
		bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
		
		list = new int[maxsize];
		
		String line = "";
		
		while((line = buffReader.readLine())!=null) {
			list[size++] = Integer.parseInt(line);
		}
		
		start = System.currentTimeMillis();
		Counting_sort(list);
		end = System.currentTimeMillis();
		
		System.out.print(end - start);
		
		for(int i = 0; i<list.length;i++) {
			bufferedWriter.write(Integer.toString(list[i]));
			bufferedWriter.newLine();
			bufferedWriter.flush();
		}
	}
	
	void Counting_sort(int[]a) {
		int n = a.length;
		int m = getMax(a);
		int[] c = new int[m+1];
		
		for(int j = 0; j<n;j++) {
			c[a[j]]++;
		}
		for(int k = 1; k<m; k++) {
			c[k] += c[k-1];
		}
		int[] b = new int[n];
		for(int i = n-1; i>=0; i--) {
			b[--c[a[i]]] = a[i];
		}
		
		for(int l = 0; l < n; ++l) {
			a[l] = b[l];
		}
	}
	int getMax(int [] a) {
		int max = a[0];
		for(int i = 1; i<a.length; i++) {
			if(a[i] > max) {
				max = a[i];
			}
		}
		return max;
	}
	
	public static void main(String[]args)throws IOException{
		new CountingSort();
	}
}
