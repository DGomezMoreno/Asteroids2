package logic;

public class Ship extends Thread {
	private int x = 0;
	private int y = 0;
	private int size = 0;
	
	public Ship(int x, int y, int size) {
		super();
		this.x = x;
		this.y = y;
		this.size = size;
	}

	public Ship() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Ship [x=" + x + ", y=" + y + ", size=" + size + "]";
	}

	@Override
	public void run() {
		System.out.println("Ship thread started");		
				
		while (true) {
			try {
				Thread.sleep(16);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (x < 0)
				x = 0;
			if (x > 500 - size - 3)
				x = 500 - size - 3;
			if (y < 0)
				y = 0;
			if (y > 500 - size - 3)
				y = 500 - size - 3;			
		}
	}
}
