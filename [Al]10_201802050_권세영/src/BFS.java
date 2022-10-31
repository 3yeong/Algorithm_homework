import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Graph{
	int color;//���� WHITE = 0, GRAY = 1, BLACK = 2
	int d;//�湮Ƚ��
	int pa;//�θ�
	int ver;//vertex
	int n;//��������
	Graph[][]adj; //�������
	Graph vertex[]; //vertex �迭
	Graph(){
		
	}
	Graph(int num){
		adj = new Graph[num][num];
		vertex = new Graph[num];
		for(int i = 0; i<num; i++) {
			for(int j = 0; j < num; j++) {
				adj[i][j] = new Graph();
			}
		}
		for(int i = 0; i<num; i++) {
			vertex[i] = new Graph();
			vertex[i].ver = i;
		}
		
		
	}
	
	public void bfs(Graph g, int v) {
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = v+1; i<g.adj.length; i++) {
			g.vertex[i].color = 0;
			g.vertex[i].d = Integer.MAX_VALUE;
			g.vertex[i].pa = 0;
		}
		g.vertex[v].color = 1;
		g.vertex[v].d = 0;
		g.vertex[v].pa = 0;
		
		q.offer(v);
		
		while (!q.isEmpty()) {
			v = q.poll();
			for(int j = 0; j < g.vertex.length; j++) {
				if(g.vertex[j].color == 0 && g.adj[v][j].n == 1) {
					g.vertex[j].color = 1;
					g.vertex[j].d = (g.vertex[v].d) + 1;
					g.vertex[j].pa = v;
					q.offer(j);
				}
			}
			g.vertex[v].color = 2;
		}
		
	}
}
public class BFS {
	
	public static void main(String[]args) throws IOException {
		
		File inputFile = null;
		File outputFile = null;
		FileReader fileReader = null;
		FileWriter fileWriter = null;
		BufferedReader buffReader = null;
		BufferedWriter bufferedWriter = null;
		
		inputFile = new File("graph.txt");
		outputFile = new File("graph_output_BFS.txt");
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
	
		Graph h = new Graph();
		Graph g = new Graph(num); 
		
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
		 System.out.println("----------------------------------");
		 
		 h.bfs(g,0);
		 
		 for(int m = 0; m<num; m++) {
			 bufferedWriter.write(m + "  "+g.vertex[m].d );
			 bufferedWriter.newLine();
			 bufferedWriter.flush();
	     	}
		 

	}

}
