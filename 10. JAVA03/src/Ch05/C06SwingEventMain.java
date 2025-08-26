package Ch05;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class C06GUI extends JFrame implements ActionListener, KeyListener, MouseListener {
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	JTextArea area;
	JTextField txt1;

	public C06GUI(String title) {
		// Frame기본설정
		super(title);
		setBounds(100, 100, 400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Pannel 설정
		JPanel panel = new JPanel();
		panel.setLayout(null);

		//
		btn1 = new JButton("파일로저장");
		btn1.setBounds(270, 10, 110, 30);
		btn2 = new JButton("1:1요청");
		btn2.setBounds(270, 50, 110, 30);
		btn3 = new JButton("대화기록보기");
		btn3.setBounds(270, 90, 110, 30);
		btn4 = new JButton("입력");
		btn4.setBounds(270, 300, 110, 30);
		area = new JTextArea();
		JScrollPane scroll = new JScrollPane(area);
		scroll.setBounds(10, 10, 250, 280);
		//
		txt1 = new JTextField();
		txt1.setBounds(10, 300, 250, 30);

		// Event 처리
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		txt1.addKeyListener(this);
		area.addMouseListener(this);
		//

		// Panel에 Component추가
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(scroll);
		panel.add(txt1);

		// Frame에 Panel추가
		add(panel);

		// Frame표시여부
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println(btn1);
//		System.out.println("BTN 클릭!! " + e.getSource());
		if (e.getSource() == btn1) {
			System.out.println("파일로 저장 버튼 클릭!");
		} else if (e.getSource() == btn2) {
			System.out.println("1:1 요청 버튼 클릭");
		} else if (e.getSource() == btn3) {
			System.out.println("대화기록보기 버튼 클릭");
		} else if (e.getSource() == btn4) {
			System.out.println("입력 버튼 클릭");
			String message = txt1.getText();
			area.append(message + "\n");
			txt1.setText("");
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("keyTyped..." + e.getKeyChar());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 10) {
			String message = txt1.getText();
			System.out.println("message:" + message);
			area.append(message + "\n");
			txt1.setText("");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("keyReleased..." + e.getKeyCode());
	}

	// ----------------------------
	// MouseListener
	// ----------------------------
	@Override
	public void mouseClicked(MouseEvent e) {

		try {
			System.out.println("클릭됨!");
			int offset = area.viewToModel(e.getPoint());
			System.out.println("offset:" + offset);
			int row = area.getLineOfOffset(offset);
			System.out.println("row:" + row);
			int startOffset = area.getLineStartOffset(row);
			int endOffset = area.getLineEndOffset(row);
			System.out.printf("start :%d = end : %d\n", startOffset, endOffset);
			String str = area.getText(startOffset, endOffset - startOffset);
			System.out.println("str:" + str);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed... " + e.getPoint());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased... " + e.getPoint());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered... ");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited... ");
	}

}

public class C06SwingEventMain {

	public static void main(String[] args) {
		new C06GUI("Chatting");
	}
}
