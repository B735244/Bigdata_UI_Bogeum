package Ch05;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class C04GUI extends JFrame {
	public C04GUI(String title) {

		// Frame Setting
		super(title);
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		// Panel Setting
		JPanel panel = new JPanel();
		panel.setLayout(null);
		Color col = new Color(20, 100, 190);
		panel.setBackground(col);
		
		
		//Component Setting
		JButton button = new JButton("보동금동");
		button.setBounds(10,10,100,30);
		JButton button2 = new JButton("손보금");
		button2.setBounds(120,10,100,30);
		
		//Input Type
		JTextField txt1 = new JTextField();
		txt1.setBounds(10,50,210,30);
		
		//Input TextArea
		JTextArea area1 = new JTextArea();
		area1.setBounds(10,90,210,210);
		//JScroll
		JScrollPane scroll1= new JScrollPane(area1);
		scroll1.setBounds(10,90,210,300);
		
		//Panel에 Component추가
		panel.add(button);
		panel.add(button2);
		panel.add(txt1);
		panel.add(area1);
		panel.add(scroll1);
		add(panel);// Frame에 Panel 추가하는 작업
		setVisible(true);
	}

}

public class C04SwingMain {

	public static void main(String[] args) {

		new C04GUI("네번째 프레임 창입니다.");
	}

}
