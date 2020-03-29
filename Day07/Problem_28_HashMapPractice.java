/*
 * 문제 28 : 해시맵연습 
 */
package Day07;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
// 해시맵을 인자로 받아서 백터를 리턴하는 hashToVector 메소드를 가지고 있다.
// 
public class Problem_28_HashMapPractice {
	public static Vector<String> hashToVector(HashMap<String,String> h){
		Vector<String> v = new Vector<String>();
		Set<String> s = h.keySet(); // key문자열을 가진 집합 set컬렉션 리턴
		Iterator<String> it = s.iterator(); // key문자열을 순서대로 접근할 수 있는 iterator 리턴.
		while(it.hasNext()) {
			String key=it.next();
			v.add(h.get(key));
			//System.out.println(v.get(0));
		}
		return v;
	}
	public static void main(String args[]) {
		HashMap<String, String> h = new HashMap<String,String>();
		h.put("범죄","112");
		h.put("화재","119");
		h.put("전화번호","114");
		
		Vector<String> v = hashToVector(h);
		for(int n=0; n<v.size(); n++) {
			System.out.print(v.get(n) + " ");
		}
	}
}
