import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ShowMap extends JPanel{
	
	// ���콺�� Ŭ���ϸ� ��ǥ���� GameMethod Ŭ������ �����ϱ� ���� �����ϴ� Ŭ����
	
	private MapSize size;
	private GameMethod gm;
	private final int STONE_SIZE = 28; // �ٵϵ� ũ�� ����
	
	public ShowMap(MapSize ms, GameMethod gm) { // Constructor (������)
		setBackground(new Color(206, 167, 61)); 
		size = ms;
		setLayout(null);
		this.gm = gm;
	}

	@Override
	public void paintComponent(Graphics g) { // �ٵ��ǰ� �ٵϵ��� �׸��� �޼ҵ�
		super.paintComponent(g);
		g.setColor(Color.BLACK); 
		board(g);
		drawStone(g); 
	}
	
	public void board(Graphics g) { // �ٵ����� �׸��� ���� �޼ҵ�
		for (int i = 1; i <= size.getSize(); i++){
			g.drawLine(size.getCell(), i*size.getCell(), 
					size.getCell()*size.getSize(), i*size.getCell()); 
			g.drawLine(i*size.getCell(), size.getCell(), 
					i*size.getCell() , size.getCell()*size.getSize()); 
		}
	}
	
	public void drawStone(Graphics g) { // �ٵϵ��� �׸��� ���� �޼ҵ�
			for (int y = 0; y < size.getSize(); y++){
				for (int x = 0; x < size.getSize(); x++){
					if (gm.getMap()[y][x] == 1)
						drawBlack(g, x, y+1);
					else if (gm.getMap()[y][x] == 2)
						drawWhite(g, x, y+1);
					else if (gm.getMap()[y][x] == 3)
						drawRed(g, x, y+1);
				}
			}
	}
	
	public void drawBlack(Graphics g, int x, int y){ // �浹 �׸��� �޼ҵ�
		g.setColor(Color.BLACK);
		g.fillOval(x*size.getCell()+15, y*size.getCell()-15, STONE_SIZE, STONE_SIZE);
	}
	
	public void drawWhite(Graphics g, int x, int y){ // �鵹 �׸��� �޼ҵ�
		g.setColor(Color.WHITE);
		g.fillOval(x*size.getCell()+15, y*size.getCell()-15, STONE_SIZE, STONE_SIZE);
	}
	
	public void drawRed(Graphics g, int x, int y){ // ���� �׸��� �޼ҵ�
		g.setColor(Color.RED);
		g.fillOval(x*size.getCell()+15, y*size.getCell()-15, STONE_SIZE, STONE_SIZE);
	}
	
}