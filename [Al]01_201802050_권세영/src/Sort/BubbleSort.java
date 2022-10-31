package Sort;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class BubbleSort {
	File inputFile = null;
	File outputFile = null;
	FileReader fileReader = null;
	FileWriter fileWriter = null;
	static BufferedReader buffReader = null;
	static BufferedWriter bufferedWriter = null;
	
	int maxsize = 1000;
	int size = 0;
	int[] list;
	int count = 0;
	
	public BubbleSort() throws IOException{
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
		
		sort(list,0,size);

		System.out.println(count);
		for(int i =0; i<size;i++) {
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
	
	void sort(int[]a, int p, int q) {
		for(int i = q;i>0;i--) {
			for (int j = p; j < i; j++) {	
				if (a[j] > a[j+1]) 
					swap(a, j, j+1); 
				count ++;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		new BubbleSort();
	}
	
}
