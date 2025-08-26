package Ch05;

import javax.swing.JFrame;

public class C01SwingMain {

	public static void main(String[] args) {
	JFrame frame = new JFrame("첫번째 프레임입니다.");//상단에 보여지는 창 제목
	frame.setBounds(100,100,500,500);//x =100 y=100 너비=500 높이=500
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//x버튼 눌렀을 때 backgroung에서도 종료시키려면 이 함수 사용
	frame.setVisible(true);
	}

}
