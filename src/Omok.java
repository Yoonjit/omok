public class Omok {
	
	// ���� ������ �����ϴ� Ŭ����
	
	public static void main(String[] args) {
		GameMethod gm = new GameMethod();
		GameSize gs = new GameSize("����", gm);
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