/*
 * ���� 28 : �ؽøʿ��� 
 */
package Day07;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
// �ؽø��� ���ڷ� �޾Ƽ� ���͸� �����ϴ� hashToVector �޼ҵ带 ������ �ִ�.
// 
public class Problem_28_HashMapPractice {
	public static Vector<String> hashToVector(HashMap<String,String> h){
		Vector<String> v = new Vector<String>();
		Set<String> s = h.keySet(); // key���ڿ��� ���� ���� set�÷��� ����
		Iterator<String> it = s.iterator(); // key���ڿ��� ������� ������ �� �ִ� iterator ����.
		while(it.hasNext()) {
			String key=it.next();
			v.add(h.get(key));
			//System.out.println(v.get(0));
		}
		return v;
	}
	public static void main(String args[]) {
		HashMap<String, String> h = new HashMap<String,String>();
		h.put("����","112");
		h.put("ȭ��","119");
		h.put("��ȭ��ȣ","114");
		
		Vector<String> v = hashToVector(h);
		for(int n=0; n<v.size(); n++) {
			System.out.print(v.get(n) + " ");
		}
	}
}
