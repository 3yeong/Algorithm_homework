import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class TestUnion {
	public static void main(String[]args) throws IOException {
		
		int maxsize = 100;
		int size = 0;
		char[] list;
		
		File inputFile = null;
		File outputFile = null;
		FileReader fileReader = null;
		FileWriter fileWriter = null;
		BufferedReader buffReader = null;
		BufferedWriter bufferedWriter = null;
		
		inputFile = new File("data2.txt"); 
		outputFile = new File("data2_output.txt");
		buffReader = new BufferedReader(new FileReader(inputFile));
		bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
		
		list = new char[maxsize];
		
		String line = "";
		int count2 =0;//파일에서 line의 위치
		
		
		 try{
	         BufferedReader br = new BufferedReader( new FileReader(inputFile) );
	         while( br.ready( ) ){    // 파일에 읽을 수 있는 데이터가 남아있는 지 확인
	        	 count2++;
	        	 line = br.readLine( );    // 파일에서 데이터를 한 줄 읽음
	             StringTokenizer parser = new StringTokenizer(line, " ");//공백 문자를 기준으로 문자열 line을 자름
	             int count = 0;
	             while( parser.hasMoreTokens( ) ) { // parser에 token이 남아 있는지 확인
	            	 count++;//line에서 원소 개수
	                char x = parser.nextToken().charAt(0);
	            	 list[size++] = x;
	             }
	             if(count2 > 0 && count == 2) {
	            	 list[size++] = '-';
	             }else if(count2 > 0 && count > 1) {
	            	 list[size++] = '-';
	             }
	         }
	          br.close( );
	      } catch(IOException e) { System.out.println(e); }		
		
		 UnionSet u = new UnionSet();
		 
		 int count3 = 0;//make할 원소들
		 
		 for(int i  = 0; i<size; i++) {
			count3++;
			char k = list[i];
			u.Make_Set(k);
			if(list[i+1]=='-') {
				break;
			}
		 }
		 int save1 = count3;
		 count3++;	 
		
		 
		 int num = 0;		 
		 int count4 = 0;
		 for(int i = count3; i<size; i++) {
			 count4 ++;
			 num ++;
			 if(list[i+1] == '-') {
				 count4 = 0;
				 num ++;
				 i++;
				 continue;
			 }else if(count4 > 2) {
				 break;
			 }
		 }
		 
		 num = num-4;
		 char[] uni = new char[4];//union할 원소가 들어갈 배열
		 int p = 0;
		 for(int i = count3; i < count3+num; i++) {
			 if(list[i] == '-') {
				 i++;
			 }
			uni[p] = list[i];
			
			p++;
			if(p == 2) {
				u.Union(uni[0],uni[1]);
				p = 0;
			}
			 
		 }
		 count3++;
		 
		 for(int k = count3+num; k<size; k++) {
			char a = u.Find_Set(list[k]).key;
		 }
		 

		for(int i = 0; i<save1;i++) {
			bufferedWriter.write(list[i] + " " + u.parn(list[i]) + " " + u.root.key);
			bufferedWriter.newLine();
			bufferedWriter.flush();
		}
		
	}
}
