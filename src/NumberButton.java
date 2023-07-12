import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class NumberButton extends JButton implements ActionListener{
	
	// ���� ���� �� �÷��̾� �ο��� �����ϴ� ��ư�� ���� Ŭ����
	
	private GameMethod gm;
	private NumberFrame nf;
	public int ready = 0; // Ÿ�̸Ӱ� �غ� ����
	
	public NumberButton(String s, GameMethod g, NumberFrame n) { // Constructor (������)
		super(s);
		gm = g;
		nf = n;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae) { // ��ư Ŭ�� �� ������ �̺�Ʈ�� ���� �޼ҵ�
		String player_cnt = getText();
		
		if (player_cnt == "2��") {
			gm.setGameMode(2);
			gm.init();
			nf.setVisible(false);
			ready = 1; // Ÿ�̸� Ȱ��ȭ
		}
		else if (player_cnt == "3��") {
			gm.setGameMode(3);
			gm.init();
			nf.setVisible(false);
			ready = 1; // Ÿ�̸� Ȱ��ȭ
		}
	}
	
	public int getReady() { // Ÿ�̸Ӱ� �غ� �������� ��ȯ
		return ready;
	}

}