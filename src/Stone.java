public class Stone {
	
	// �ٵϵ��� ������ �����ϴ� Ŭ����
	// get�� set�� �̿�
	
	private int x; // ���� �ٵϵ� x�� ��ġ
	private int y; // ���� �ٵϵ� y�� ��ġ
	private int color; // ���� �ٵϵ� ���� (���� �������� ��Ÿ��)
	
	public Stone(int y, int x, int color) { // Constructor (������)
		this.y = y;
		this.x = x;
		this.color = color;
	}
	
	public int getX() { // x�� ������ �޾ƿ��� �޼ҵ�
		return x;
	}
	
	public void setX(int x) { // x�� ������ �����ϴ� �޼ҵ�
		this.x = x;
	}
	
	public int getY() { // y�� ������ �޾ƿ��� �޼ҵ�
		return y;
	}
	
	public void setY(int y) { // y�� ������ �����ϴ� �޼ҵ�
		this.y = y;
	}
	
	public int getColor() { // �ٵϵ� ������ �޾ƿ��� �޼ҵ�
		return color;
	}
	
	public void setColor(int color) { // �ٵϵ� ������ �����ϴ� �޼ҵ�
		this.color = color;
	}
	
}