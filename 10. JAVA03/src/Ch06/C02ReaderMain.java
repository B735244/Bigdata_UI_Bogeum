package Ch06;

import java.io.Reader;
import java.io.FileReader;
import java.io.IOException;

public class C02ReaderMain {

	public static void main(String[] args) throws IOException {
		Reader fin = new FileReader("c:\\iotest\\test1.txt");
//		while (true) {
//			int data = fin.read();
//			if(data==-1) {
//				break;
//				System.out.print((char)data);
//			}
//		}
		
		int data ;
		while ((data = fin.read())!=-1) {
			
			
				System.out.print((char)data);
			}
		fin.close();
	}

}
