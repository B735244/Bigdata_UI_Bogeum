package Ch07;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class C01CharConvertStreamMain {

	public static void main(String[] args) throws Exception{
		String str = "문자 변환 스트림 사용!!";
//		
//		OutputStream out = new FileOutputStream("c:\\iotest\\test.txt");
//		OutputStreamWriter wout = new OutputStreamWriter(out);
//		BufferedWriter bout = new BufferedWriter(wout);
//		
//	
//		bout.write(str);
//		bout.flush();
//		bout.close();
		
		FileInputStream in = new FileInputStream("c:\\iotest\\test.txt");
		BufferedInputStream bin =  new BufferedInputStream(in);
		InputStreamReader rin = new InputStreamReader(bin);
		while(true) {
			int data = rin.read();
			if(data==-1)
				break;
			System.out.print((char)data);
			
		}
		
		
	}
}
