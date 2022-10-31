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
		int count2 =0;//���Ͽ��� line�� ��ġ
		
		
		 try{
	         BufferedReader br = new BufferedReader( new FileReader(inputFile) );
	         while( br.ready( ) ){    // ���Ͽ� ���� �� �ִ� �����Ͱ� �����ִ� �� Ȯ��
	        	 count2++;
	        	 line = br.readLine( );    // ���Ͽ��� �����͸� �� �� ����
	             StringTokenizer parser = new StringTokenizer(line, " ");//���� ���ڸ� �������� ���ڿ� line�� �ڸ�
	             int count = 0;
	             while( parser.hasMoreTokens( ) ) { // parser�� token�� ���� �ִ��� Ȯ��
	            	 count++;//line���� ���� ����
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
		 
		 int count3 = 0;//make�� ���ҵ�
		 
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
		 char[] uni = new char[4];//union�� ���Ұ� �� �迭
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
