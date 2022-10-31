import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LCS {
	static File inputFile = null;
	static File outputFile = null;
	static FileReader fileReader = null;
	static FileWriter fileWriter = null;
	static BufferedReader buffReader = null;
	static BufferedWriter bufferedWriter = null;
	
	int num;
	int arrow;
	public LCS() {
		
	}
	LCS[][] LCS_LENGTH(char[]y, char[]z ){
		int a = y.length;
		int b = z.length;
		LCS[][] x = new LCS[a+1][b+1];
		for(int i = 0; i<a+1; i++) {
			for(int j = 0; j < b+1; j++) {
				x[i][j] = new LCS();
			}
		}
		for(int i = 0; i<a+1; i++) {
			x[i][0].num = 0;
		}
		for(int j = 0;j<b+1; j++) {
			x[0][j].num = 0;
		}
		for(int i = 1; i < a+1; i++) {
			for(int j = 1; j < b+1; j++) {
				if(y[i-1] == z[j-1]) {
					x[i][j].num = x[i-1][j-1].num+1;
					x[i][j].arrow = 0;
				}else if(x[i-1][j].num >= x[i][j-1].num) {
					x[i][j].num = x[i-1][j].num;
					x[i][j].arrow = 1;
				}else {
					x[i][j].num = x[i][j-1].num;
					x[i][j].arrow = 2;
				}
			}
		}
		return x;
	}
	
	void Print_LCS(LCS[][] b,char[] x, int i, int j) throws IOException {
		if(i==0 || j==0) {
			return;
		}
		if(b[i][j].arrow==0) {
			Print_LCS(b,x,i-1,j-1);
			bufferedWriter.write(x[i-1]);
			bufferedWriter.flush();
		}else if(b[i][j].arrow == 1) {
			Print_LCS(b, x, i-1, j);
		}else {
			Print_LCS(b, x, i, j-1);
		}
	}
	
	public static void main(String[]args) throws IOException {
		inputFile = new File("LCS_Data.txt"); 
		outputFile = new File("LCS_Data_output.txt");
		buffReader = new BufferedReader(new FileReader(inputFile));
		bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
		
		LCS l = new LCS();		
		
		int a = 0,b = 0;
		int count = 0;
		char[] x = null;
		char[] y = null; 
		
		String line = "";
		
		 try{
	         while( buffReader.ready( ) ){    // 파일에 읽을 수 있는 데이터가 남아있는 지 확인 
	        	 line = buffReader.readLine( ); 
	        	  // 파일에서 데이터를 한 줄 읽음
	        	 if(count == 0) {
	        		 a = Integer.parseInt(line);
	        	 }
	        	 else if(count == 1) {
	        		 x= line.toCharArray();
	        	 }else if(count == 2) {
	        		 b = Integer.parseInt(line);
	        	 }else {
	        		 y= line.toCharArray();
	        	 }
	             count ++;

	         }
	          buffReader.close( );
	      } catch(IOException e) { System.out.println(e); }	
	
		LCS[][] k = new LCS[a+1][b+1];
		k = l.LCS_LENGTH(x, y);
		for(int i = 1; i<a+1; i++) {
			for(int j = 1; j<b+1; j++) {
				System.out.print(k[i][j].num);
			}
			System.out.println();
			
		}
		
		l.Print_LCS(k,x,a,b);
		
	}
}
