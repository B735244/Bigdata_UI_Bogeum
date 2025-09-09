package Ch06;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class C06FileOutStreamMain {

	public static void main(String[] args)throws Exception {
		OutputStream fout = new FileOutputStream("c:\\iotest\\test6.txt");
		
		//유니코드 문자가 문제임
		fout.write('괙');//한글같은 경우는 넘어갈 때 문제가 생기게 됨.
		//byte단위로 나눠서 전달해줘야 함!!!
		fout.write(' ');
		fout.write("가나다".getBytes(StandardCharsets.UTF_8));
		fout.write('a');
		fout.write('b');
		fout.write('b');
		fout.flush();
		fout.close();

	}

}