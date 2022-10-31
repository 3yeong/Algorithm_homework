import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Graph1{
	int color;//��
	int pa; //�θ�
	int d; //������ �ð�
	int f;//�������� �ð�
	int ver; //vertex ��ȣ
	int n; //���� ���� 0, 1
	int time; //�ð� ����
	Graph1[][]adj; //�������
	Graph1 vertex[]; //vertex �迭
	Graph1(){
		
	}
	Graph1(int num){
		adj = new Graph1[num][num];
		vertex = new Graph1[num];
		for(int i = 0; i<num; i++) {
			for(int j = 0; j < num; j++) {
				adj[i][j] = new Graph1();
			}
		}
		for(int i = 0; i<num; i++) {
			vertex[i] = new Graph1();
			vertex[i].ver = i;
		}
	}
	
	
	public void dfs(Graph1 g){
		for(int u = 0; u < g.vertex.length; u++) {
			g.vertex[u].color = 0;
			g.vertex[u].pa = 0;
		}
		time = 0;
		for(int u = 0; u < g.vertex.length; u++) {
			if(g.vertex[u].color == 0) {
				dfs_visit(g, u);
			}
		}
	}
	
	public void dfs_visit(Graph1 g, int u) {
		time = time + 1;
		g.vertex[u].d = time;
		g.vertex[u].color = 1;
		for(int v = 0; v<g.vertex.length; v++) {
			if(g.vertex[v].color == 0 && g.adj[u][v].n == 1) {
				g.vertex[v].pa = u;
				dfs_visit(g, v);
			}
		}
		g.vertex[u].color = 2;
		time = time+1;
		g.vertex[u].f = time;
	}
	
}

public class DFS {
public static void main(String[]args) throws IOException {
		
		File inputFile = null;
		File outputFile = null;
		FileReader fileReader = null;
		FileWriter fileWriter = null;
		BufferedReader buffReader = null;
		BufferedWriter bufferedWriter = null;
		
		inputFile = new File("graph.txt");
		outputFile = new File("graph_output_DFS.txt");
		buffReader = new BufferedReader(new FileReader(inputFile));
		bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
		
		int count = 0;
		String line = "";
		int num = 0;
		try{
	         while( buffReader.ready( ) ){    // ���Ͽ� ���� �� �ִ� �����Ͱ� �����ִ� �� Ȯ�� 
	        	 line = buffReader.readLine( ); 
	        	  // ���Ͽ��� �����͸� �� �� ����
	        	 if(count == 0) {
	        		num = Integer.parseInt(line);
	        	 }
	             count ++;
	         }
	          buffReader.close( );
	      } catch(IOException e) { System.out.println(e); }	
	
		Graph1 h = new Graph1();
		Graph1 g = new Graph1(num); 
		
		count = 0;
		int i = 0;
		try{
	         BufferedReader br = new BufferedReader( new FileReader(inputFile) );
	         while( br.ready( ) ){    // ���Ͽ� ���� �� �ִ� �����Ͱ� �����ִ� �� Ȯ��
	        	 
	        	 line = br.readLine( );    // ���Ͽ��� �����͸� �� �� ����
	             StringTokenizer parser = new StringTokenizer(line, " ");//���� ���ڸ� �������� ���ڿ� line�� �ڸ�
	             int  j = 0;
	             while( parser.hasMoreTokens( ) ) { // parser�� token�� ���� �ִ��� Ȯ��
	            	
	                int x = parser.nextToken().charAt(0) - '0';
	                if(count > 0 && count < num+1) {
	                	g.adj[i][j].n = x;
	                	j++;
	                }
	             }
	             count++;
	             if(count > 1) {
	            	 i++;
	             }
	         }
	          br.close( );
	      } catch(IOException e) { System.out.println(e); }		

		 for(int m = 0; m<num; m++) {
     		for(int n = 0; n <num; n++) {
     			System.out.print(g.adj[m][n].n);
     		}
     		System.out.println();
     	}
 
		 h.dfs(g);
		 
		 for(int m = 0; m<num; m++) {
			 bufferedWriter.write(m + "  "+g.vertex[m].d + "  " + g.vertex[m].f);
			 bufferedWriter.newLine();
			 bufferedWriter.flush();
	     	}
		 
	}
}
