import java.awt.Container;

import javax.swing.JFrame;

public class GameSize extends JFrame {
	
	// ���� ȭ�� ũ�⸦ �����ϴ� Ŭ����
	
	private Container c;
	MapSize size = new MapSize();

	public GameSize(String title, GameMethod gm) { // Constructor (������)
		setTitle(title);
		setBounds(200, 20, 644, 720);
		setLocation(440, 70);
		
		c = getContentPane();
		c.setLayout(null);
		
		ShowMap sm = new ShowMap(size, gm);
		setContentPane(sm);
		
		add(gm.label);
		gm.label.setBounds(195, 600, 1000, 80);
		
		MouseAction mc = new MouseAction(gm, size, sm, this);
		addMouseListener(mc);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}