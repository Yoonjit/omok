public class Omok {
	
	// 오목 게임을 실행하는 클래스
	
	public static void main(String[] args) {
		GameMethod gm = new GameMethod();
		GameSize gs = new GameSize("오목", gm);
		NumberFrame nf = new NumberFrame(gm);
		gm.getNF(nf);

		while (true) {
			if (true) {
				System.out.print("");
			}
			if (nf.button1.getReady() == 1 || nf.button2.getReady() == 1) { 
				gm.timeLimit(); 
			}
		}
	}
	
}