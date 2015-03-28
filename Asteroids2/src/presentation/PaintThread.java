package presentation;

import javax.swing.JPanel;
import logic.Cosmos;

public class PaintThread extends Thread {
	private JPanel panel = null;
	private Cosmos myCosmos = null;

	public PaintThread(JPanel panel, Cosmos myCosmos) {
		super();
		this.panel = panel;
		this.myCosmos = myCosmos;
	}

	@Override
	public void run() {
		System.out.println("PainThread started");
		int x = 0;
		int y = 0;
		int size = 0;

		while (true) {

			try {
				Thread.sleep(32);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			panel.getGraphics().clearRect(0, 0, 500, 500);

			for (int i = 0; i < myCosmos.getAsteroids().size(); i++) {

				x = myCosmos.getAsteroids().get(i).getX();
				y = myCosmos.getAsteroids().get(i).getY();
				size = myCosmos.getAsteroids().get(i).getSize();
				panel.getGraphics().drawOval(x, y, size, size);
			}

			for (int i = 0; i < myCosmos.getShips().size(); i++) {

				x = myCosmos.getShips().get(i).getX();
				y = myCosmos.getShips().get(i).getY();
				size = myCosmos.getShips().get(i).getSize();
				panel.getGraphics().drawRect(x, y, size, size);
			}

			for (int i = 0; i < myCosmos.getAsteroids().size(); i++) {

				x = myCosmos.getAsteroids().get(i).getX();
				y = myCosmos.getAsteroids().get(i).getY();
				size = myCosmos.getAsteroids().get(i).getSize();

				for (int j = 0; j < myCosmos.getShips().size(); j++) {

					double astX = myCosmos.getAsteroids().get(i).getX()
							+ myCosmos.getAsteroids().get(i).getSize() / 2;
					double astY = myCosmos.getAsteroids().get(i).getY()
							+ myCosmos.getAsteroids().get(i).getSize() / 2;
					double shiX = myCosmos.getShips().get(j).getX()
							+ myCosmos.getShips().get(j).getSize() / 2;
					double shiY = myCosmos.getShips().get(j).getY()
							+ myCosmos.getShips().get(j).getSize() / 2;

					double xDif = astX - shiX;
					double yDif = astY - shiY;
					double distanceSquared = xDif * xDif + yDif * yDif;
					boolean collision = distanceSquared < (myCosmos
							.getAsteroids().get(i).getSize() / 2 + myCosmos
							.getShips().get(j).getSize() / 2)
							* (myCosmos.getAsteroids().get(i).getSize() / 2 + myCosmos
									.getShips().get(j).getSize() / 2);

					if (collision == true) {
						System.out.println("FIN FIN FIN");
					}
				}
			}
		}
	}
}