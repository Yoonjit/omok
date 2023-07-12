import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GameMethod {
	
	// 오목 게임 설정과 오목 알고리즘이 있는 클래스
	// 마우스를 통해 각 좌표들의 값을 받으면 map[][] 변수에 현재 플레이어의 바둑돌을 배치함
	
	private int max_size = 20; // 바둑판의 가로 또는 세로 길이
	private int map[][] = new int[max_size][max_size]; // 바둑판은 20 * 20 사이즈
	private int game_play_cnt = 2; // 게임 실행 시 처음 플레이어 인원 수 (디폴트 값)
	public int cun_game_player = 1; // 처음 바둑돌을 놓는 플레이어의 번호 (순서)
	public JLabel label = new JLabel(); // 타이머를 생성할 라벨
	public NumberFrame pass; // NumberFrame을 담을 변수

	public void init() { // 바둑판을 만드는 메소드
		for (int i = 0; i < max_size; i++) {
			for (int j = 0; j < max_size; j++) {
				map[i][j] = 0;
			}
		}
	}

	public void nextPlayer(int cun_p) { // 다음 플레이어에게 턴이 넘어가도록 하는 메소드
		cun_p++;
		
		if (game_play_cnt < cun_p) {
			cun_game_player = 1;
		} 
		else {
			cun_game_player = cun_p;
		}
	}
	
	public boolean endGame(Stone s) { // 게임 승패 판단을 위한 메소드
		int now_color = s.getColor();
		int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, 
						{ -1, 1 }, { 1, -1 }, { -1, -1 }, { 1, 1 } };

		for (int i = 0; i < 8; i = i + 2) {
			int same_cnt = 1; // same_cnt가 5가 되면 (한 줄에 바둑돌 5개) 승리
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

	public void inputWord(Stone s) { // 마우스 클릭을 통해 받아온 바둑돌의 정보에 대한 메소드
		map[s.getY()][s.getX()] = s.getColor();
	}

	public boolean checkInput(int y, int x) { // 바둑돌이 놓여질 수 있는 범위에 대한 메소드
		if (map[y][x] != 0 || y < 0 || y >= max_size || x < 0 || x >= max_size) {
			return false;
		}
		
		return true;
	}
	
	public void setGameMode(int max) { // 플레이어 수에 따라 게임을 세팅하는 메소드
		this.game_play_cnt = max;
	}
	
	public int getGamePlayCnt() { // 게임 플레이어의 수를 반환하는 메소드
		return game_play_cnt;
	}
	
	public int[][] getMap() { // 바둑판 정보를 반환하는 메소드
		return map;
	}
	
	public int getCunGamePlayer() { // 플레이어의 현재 순서를 반환하는 메소드
		return cun_game_player;
	}
	
	public void getNF(NumberFrame nf) { // NumberFrame을 받는 메소드
		pass = nf;
	}
		
	public void timeLimit() { // 제한 시간을 보여주고 시간 초과 시 다음 플레이어 순서로 넘어가는 메소드
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
					Font font = new Font("맑은 고딕", Font.PLAIN, 20);
					label.setFont(font);
					label.setText("제한 시간 " + (11-count) + "초 남았습니다...");
				}
			}
				
			if (count == 11) {
				JOptionPane.showMessageDialog(null, "시간 초과! 다음 사람으로 넘어갑니다.");		
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
					label.setText("제한 시간 " + (11-count) + "초 남았습니다...");
				}
			}
				
			if (count == 11) {
				JOptionPane.showMessageDialog(null, "시간 초과! 다음 사람으로 넘어갑니다.");
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
					label.setText("제한 시간 " + (11-count) + "초 남았습니다...");
				}
			}
				
			if (count == 11) {
				JOptionPane.showMessageDialog(null, "시간 초과! 다음 사람으로 넘어갑니다.");
				nextPlayer(cun_game_player);
			}
		}
	}
	
}