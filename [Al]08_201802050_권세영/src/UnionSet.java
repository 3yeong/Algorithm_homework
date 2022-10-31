
public class UnionSet {
	Set root;
	
	Set[] us = new Set[100] ;
	int i =0;
	
	Set Find(char x) {//배열에 저장된 Set 찾기
		for(int j = 0; j < i+1; j++) {
			if(us[j].key == x)
				return us[j];
		}
		return root;
	}
	
	void Make_Set(char x) {
		Set a = new Set(x);
		a.parant = a;
		a.rank = 0;
		us[i++]=a;	
	}
	
	void Union(char x, char y) {		
		Set p = Find_Set(x);
		Set q = Find_Set(y);
		
		if(p == q) {
			System.out.println("이미 부모가 같습니다.");
			return;
		}
		
		if(p.rank > q.rank) {
			q.parant = p;
			root = p;
		}else {
			p.parant = q;
			root = q;
			if(p.rank == q.rank) {
				q.rank ++;
			}
		}
	}
	
	Set Find_Set(char x) {
		Set a = Find(x);
		if(a.parant != a) {
			a.parant = Find_Set(a.parant.key);
		}
		return a.parant;
	}
	
	char parn(char x) //바로 위 부모 찾기
	{
		Set a = Find(x);
		return a.parant.key;
	}
	
}
	
class Set{
        char key;
        int rank;
        Set parant;
        public Set(char key) {
        	this.key = key;
        }
        public Set(char key, int rank, Set parant ){
            this.key = key;
            this.rank = rank;
            this.parant = parant;
        }
        public int getKey(){
            return key;
        }
        public  void setKey(char key){
            this.key = key;
        }
        public int getRank() {
        	return rank;
        }
        public void setRank(int rank) {
        	this.rank = rank;
        }
        public Set getParant() {
        	return parant;
        }
        public void setParant(Set parant) {
        	this.parant = parant;
        }
        
    }


