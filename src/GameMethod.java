import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GameMethod {
	
	// ���� ���� ������ ���� �˰����� �ִ� Ŭ����
	// ���콺�� ���� �� ��ǥ���� ���� ������ map[][] ������ ���� �÷��̾��� �ٵϵ��� ��ġ��
	
	private int max_size = 20; // �ٵ����� ���� �Ǵ� ���� ����
	private int map[][] = new int[max_size][max_size]; // �ٵ����� 20 * 20 ������
	private int game_play_cnt = 2; // ���� ���� �� ó�� �÷��̾� �ο� �� (����Ʈ ��)
	public int cun_game_player = 1; // ó�� �ٵϵ��� ���� �÷��̾��� ��ȣ (����)
	public JLabel label = new JLabel(); // Ÿ�̸Ӹ� ������ ��
	public NumberFrame pass; // NumberFrame�� ���� ����

	public void init() { // �ٵ����� ����� �޼ҵ�
		for (int i = 0; i < max_size; i++) {
			for (int j = 0; j < max_size; j++) {
				map[i][j] = 0;
			}
		}
	}

	public void nextPlayer(int cun_p) { // ���� �÷��̾�� ���� �Ѿ���� �ϴ� �޼ҵ�
		cun_p++;
		
		if (game_play_cnt < cun_p) {
			cun_game_player = 1;
		} 
		else {
			cun_game_player = cun_p;
		}
	}
	
	public boolean endGame(Stone s) { // ���� ���� �Ǵ��� ���� �޼ҵ�
		int now_color = s.getColor();
		int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, 
						{ -1, 1 }, { 1, -1 }, { -1, -1 }, { 1, 1 } };

		for (int i = 0; i < 8; i = i + 2) {
			int same_cnt = 1; // same_cnt�� 5�� �Ǹ� (�� �ٿ� �ٵϵ� 5��) �¸�
			int cun_y = s.getY();
			int cun_x = s.getX();

			for (int j = 0; j < 5; j++) {
				cun_y = cun_y + dir[i][0];
				cun_x = cun_x + dir[i][1];
				
				if (cun_y < 0 || cun_y >= max_size || cun_x < 0 || cun_x >= max_size)
					break;
				if (now_color != map[cun_y][cun_x])
					break;

				same_cnt++;
			}
			
			cun_y = s.getY();
			cun_x = s.getX();

			for (int j = 0; j < 5; j++) {
				cun_y = cun_y + dir[i + 1][0];
				cun_x = cun_x + dir[i + 1][1];
				
				if (cun_y < 0 || cun_y >= max_size || cun_x < 0 || cun_x >= max_size)
					break;
				if (now_color != map[cun_y][cun_x])
					break;
				
				same_cnt++;
			}

			if (same_cnt >= 5) {
				return true;
			}
		}
		
		return false;
	}

	public void inputWord(Stone s) { // ���콺 Ŭ���� ���� �޾ƿ� �ٵϵ��� ������ ���� �޼ҵ�
		map[s.getY()][s.getX()] = s.getColor();
	}

	public boolean checkInput(int y, int x) { // �ٵϵ��� ������ �� �ִ� ������ ���� �޼ҵ�
		if (map[y][x] != 0 || y < 0 || y >= max_size || x < 0 || x >= max_size) {
			return false;
		}
		
		return true;
	}
	
	public void setGameMode(int max) { // �÷��̾� ���� ���� ������ �����ϴ� �޼ҵ�
		this.game_play_cnt = max;
	}
	
	public int getGamePlayCnt() { // ���� �÷��̾��� ���� ��ȯ�ϴ� �޼ҵ�
		return game_play_cnt;
	}
	
	public int[][] getMap() { // �ٵ��� ������ ��ȯ�ϴ� �޼ҵ�
		return map;
	}
	
	public int getCunGamePlayer() { // �÷��̾��� ���� ������ ��ȯ�ϴ� �޼ҵ�
		return cun_game_player;
	}
	
	public void getNF(NumberFrame nf) { // NumberFrame�� �޴� �޼ҵ�
		pass = nf;
	}
		
	public void timeLimit() { // ���� �ð��� �����ְ� �ð� �ʰ� �� ���� �÷��̾� ������ �Ѿ�� �޼ҵ�
		int count = 0;
		
		if (cun_game_player == 1) {
			for (int i = 11; i >= 1; i--) {
				if (cun_game_player == 1) {
					try {
						Thread.sleep(1000);
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					count++;
					Font font = new Font("���� ���", Font.PLAIN, 20);
					label.setFont(font);
					label.setText("���� �ð� " + (11-count) + "�� ���ҽ��ϴ�...");
				}
			}
				
			if (count == 11) {
				JOptionPane.showMessageDialog(null, "�ð� �ʰ�! ���� ������� �Ѿ�ϴ�.");		
				nextPlayer(cun_game_player);
			}
		}
		
		else if (cun_game_player == 2) {
			for (int i = 11; i >= 1; i--) {
				if (cun_game_player == 2) {
					try {
						Thread.sleep(1000);
					} 
					catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					count++;
					label.setText("���� �ð� " + (11-count) + "�� ���ҽ��ϴ�...");
				}
			}
				
			if (count == 11) {
				JOptionPane.showMessageDialog(null, "�ð� �ʰ�! ���� ������� �Ѿ�ϴ�.");
				nextPlayer(cun_game_player);
			}
		}
		
		else if (cun_game_player == 3) {
			for (int i = 11; i >= 1; i--) {
				if (cun_game_player == 3) {
					try {
						Thread.sleep(1000);
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					count++;
					label.setText("���� �ð� " + (11-count) + "�� ���ҽ��ϴ�...");
				}
			}
				
			if (count == 11) {
				JOptionPane.showMessageDialog(null, "�ð� �ʰ�! ���� ������� �Ѿ�ϴ�.");
				nextPlayer(cun_game_player);
			}
		}
	}
	
}