/*
 * ���� 35 : .txt���� ��� �����ϴ� ���α׷� �ۼ� 
 */
package Day08;

import java.io.File;
import java.util.Scanner;

public class Problem_35_File_Delete {

	public Problem_35_File_Delete() {
		Scanner scanner = new Scanner(System.in);
		String a= scanner.next();
		if(a.equals("go")){
				File f = new File("c:\\Temp\\");
				String fileList[] = f.list();
				for(int i=0; i<fileList.length; i++) {
					if(fileList[i].lastIndexOf(".txt")==fileList[i].length()-1) {
						File g = new File("c:\\Temp\\"+fileList[i]);
						g.delete();
						System.out.println(fileList[i]+"�����Ϸ�");					
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		new Problem_35_File_Delete();
	}

}
