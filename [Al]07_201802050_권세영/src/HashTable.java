
public class HashTable {
	
	int NIL = 0;
	int deleted = -2;
	static int count1 = 0;
	static int count2 = 0;
	static int count3 = 0;
	
	void Linear_insert(int[] a, int x) {
		int key = x % a.length;
		while(a[key]!=NIL&&a[key]!=deleted) {
			key = key + 1 % a.length;
			count1++;
		}
		a[key] = x;
	}
	
	void Quadratic_Insert(int[]a, int x){
		int key = x % a.length;
		int i =0;
		while(a[key]!=NIL&&a[key]!=deleted) {
			i++;
			key = ((x%a.length)+i*i)%a.length;
			count2++;
		}
		a[key] = x;
	}
	
	void Double_Insert(int[]a, int x) {
		int key = x%a.length;
		int i = 0;
		while(a[key]!=NIL&&a[key]!=deleted) {
			i++;
			key = ((x%59)+i*(x%31))%a.length;
			count3++;
		}
		a[key] = x;
	}
	boolean Linear_Search(int[]a, int x) {
		int key = x%a.length;
		while(a[key]!=NIL) {
			if(a[key]==x) {
				return true;
			}else {
				key = key+1%a.length;
			}
		}
		return false;
	}
	
	boolean Quadratic_Search(int[]a, int x) {
		int key = x%a.length;
		int i =0;
		while(a[key]!=NIL) {
			i++;
			if(a[key]==x) {
				return true;
			}else {
				key = ((x%a.length)+i*i)%a.length;
			}
		}
		return false;
	}
	
	boolean Double_Search(int[]a, int x) {
		int key = x%a.length;
		int i =0;
		while(a[key]!=NIL) {
			i++;
			if(a[key]==x) {
				return true;
			}else {
				key = ((x%59)+i*(x%31))%a.length;
			}
		}
		return false;
	}
	
	boolean Linear_Delete(int[]a, int x) {
		int key = x%a.length;
		while(a[key]!=NIL) {
			if(a[key] == x) {
				a[key] = deleted;
				return true;
			}else {
				key = key+1%a.length;
			}
		}
		return false;
	}
	
	boolean Quadratic_Delete(int[]a, int x) {
		int key = x%a.length;
		int i = 0;
		while(a[key]!=NIL) {
			i++;
			if(a[key] == x) {
				a[key] = deleted;
				return true;
			}else {
				key = ((x%a.length)+i*i)%a.length;
			}
		}
		return false;
	}
	
	boolean Double_Delete(int[]a, int x) {
		int key = x%a.length;
		int i = 0;
		while(a[key]!=NIL) {
			i++;
			if(a[key] == x) {
				a[key] = deleted;
				return true;
			}else {
				key = ((x%59)+i*(x%31))%a.length;
			}
		}
		return false;
	}

}
