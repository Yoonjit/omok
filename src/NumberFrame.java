import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class NumberFrame extends JFrame{
	
	// ���� ���� �� �÷��̾� �ο��� �����ϴ� ��ư�� ��� �����ӿ� ���� Ŭ����
	
	public NumberButton button1;
	public NumberButton button2;

	public NumberFrame(GameMethod gm) { // Constructor (������)
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());

		button1 = new NumberButton("2��", gm, this);
		button2 = new NumberButton("3��", gm, this);
		cp.add(button1);
		cp.add(button2);
		
		setTitle("�÷��̾� �� ����");
		setSize(284, 80);
		setLocation(620, 340);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
}