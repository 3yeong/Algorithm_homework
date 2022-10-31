import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*; 
import java.util.Scanner;


public class WorstLinearSelect {
	File inputFile = null;
	FileReader fileReader = null;
	BufferedReader buffReader = null;
	
	int maxsize = 5000;
	int size = 0;
	int[] list;
	
	public WorstLinearSelect() throws IOException{
		inputFile = new File("test_5000.txt");
		buffReader = new BufferedReader(new FileReader(inputFile));
		
		list = new int[maxsize];
		String line = "";
		
		while((line = buffReader.readLine())!=null) {
			list[size++] = Integer.parseInt(line);
		}
		
		System.out.println("찾고 싶은 원소의 위치를 입력하세요 : ");
		Scanner input = new Scanner(System.in);
		
		int in = input.nextInt();
		
		int q = linearSelect(list, 0, size-1, in);
		
		System.out.print("i 위치의 원소는  : ");
		System.out.println(q);
		System.out.println();
		
		Quick_sort(list, 0,size-1);
		System.out.println("정렬된 배열");
		for(int i = 0; i<size;i++) {
			System.out.println(list[i]);
		}
	}
	
	int linearSelect(int[] a, int p, int r, int i) {
		int n = r - p + 1;
		if(n <= 5) {
			Arrays.sort(a,p,r+1);
			return a[p+i-1];
		}
		int[] median = new int [n/5];
		int j;
		for(j = 0; j<n/5;j++) {
			median[j] = linearSelect(a,p+5*j, p+5*(j+1)-1, 3);
		}
		
		int pivot = linearSelect(median, 0, median.length-1, median.length/2+1);
		int pivotin = partition(a,p,r,pivot);
		int k = pivotin - p + 1;
		
		if(i<=k)
			return linearSelect(a,p,pivotin,i);
		else
			
			return linearSelect(a, pivotin+1, r, i-k);
	}
	
	
	void swap(int[]a, int i, int j) {
		int ai = a[i], aj = a[j];
		if(ai==aj)return;
		a[i] = aj;
		a[j] = ai;
	}
	
	int partition(int[] a, int p, int r, int pivot) {
		int i;
		for(i=0; i<a.length;i++) 
			if(a[i]==pivot)
				break;
		swap(a,i,r);
		
		i = p;
		for(int j = p;j<=r-1;j++) {
			if(a[j]<=pivot) {
				swap(a,i,j);
				i++;
			}
		}
		swap(a,i,r);
		return i-1;
		
	}
	void Quick_sort(int[] a, int p, int r) {
		if(p<r) {
			int q = partition1(a,p,r);
			Quick_sort(a,p,q-1);
			Quick_sort(a,q+1,r);
		}
	}
	int partition1(int[] a, int p, int r) {
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
	
	

	public static void main(String[] args)throws IOException{
		new WorstLinearSelect();
	}
}
