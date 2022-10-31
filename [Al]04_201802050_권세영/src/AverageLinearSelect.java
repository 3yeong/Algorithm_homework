import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AverageLinearSelect {
	File inputFile = null;
	FileReader fileReader = null;
	BufferedReader buffReader = null;
	
	int maxsize = 5000;
	int size = 0;
	int[] list;
	
	public AverageLinearSelect() throws IOException{
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
		
		int k = select(list, 0,size-1, in);
		
		System.out.print("i 위치의 원소는  : ");
		System.out.println(k);
		System.out.println();
		
		
		Quick_sort(list, 0,size-1);
		System.out.println("정렬된 배열");
		for(int i = 0; i<size;i++) {
			System.out.println(list[i]);
		}
	}
	
	void Quick_sort(int[] a, int p, int r) {
		if(p<r) {
			int q = partition(a,p,r);
			Quick_sort(a,p,q-1);
			Quick_sort(a,q+1,r);
		}
	}
	
	void swap(int[]a, int i, int j) {
		int ai = a[i], aj = a[j];
		if(ai==aj)return;
		a[i] = aj;
		a[j] = ai;
	}
	
	int select(int[] a, int p, int r, int i) {
		if(p==r) return a[p];
		int q = partition(a,p,r);
		int k = q-p+1;
		if(i<k) return select(a, p,q-1, i);
		else if(i==k) return a[q];
		else return select(a, q+1,r, i-k);
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
	
	public static void main(String[] args) throws IOException{
		new AverageLinearSelect();
	}
}
