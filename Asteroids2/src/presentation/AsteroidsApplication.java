package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JButton;

import logic.Asteroid;
import logic.Ship;
import logic.Cosmos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;

public class AsteroidsApplication {
	public int xIncrement = 0;
	public int yIncrement = 0;
	public String move = "";
	private Cosmos myCosmos = null;
	private Random myRandom = new Random();
	private PaintThread myPaintThread = null;
	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmExit;
	private JToolBar toolBar;
	private JPanel panel;
	private JButton btnStartCosmos;
	private JButton btnAddAsteroids;
	private JButton btnPaintPanel;
	private JButton btnStartPaintthread;
	private JButton btnLaunchShip;
	private JLabel lblWasdToControl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AsteroidsApplication window = new AsteroidsApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AsteroidsApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 501, 503);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		lblWasdToControl = new JLabel("WASD to control the ship");
		menuBar.add(lblWasdToControl);
		toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		btnStartCosmos = new JButton("Start Cosmos");
		btnStartCosmos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCosmos = new Cosmos();
				System.out.println(myCosmos);
				btnLaunchShip.requestFocusInWindow();
			}
		});
		toolBar.add(btnStartCosmos);
		btnAddAsteroids = new JButton("Add Asteroids");
		btnAddAsteroids.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Asteroid myAsteroid = new Asteroid(myRandom.nextInt(400),
						myRandom.nextInt(400), myRandom.nextInt(100));
				myAsteroid.start();
				myCosmos.getAsteroids().add(myAsteroid);
				System.out.println(myCosmos);
				btnLaunchShip.requestFocusInWindow();
			}
		});
		toolBar.add(btnAddAsteroids);
		btnPaintPanel = new JButton("Paint Panel");
		btnPaintPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = 0;
				int y = 0;
				for (int i = 0; i < myCosmos.getAsteroids().size(); i++) {
					x = myCosmos.getAsteroids().get(i).getX();
					y = myCosmos.getAsteroids().get(i).getY();
					panel.getGraphics().drawOval(x, y, 10, 10);
					btnLaunchShip.requestFocusInWindow();
				}
			}
		});
		toolBar.add(btnPaintPanel);
		btnStartPaintthread = new JButton("Start PaintThread");
		btnStartPaintthread.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myPaintThread = new PaintThread(panel, myCosmos);
				myPaintThread.start();
				btnLaunchShip.requestFocusInWindow();
			}
		});
		toolBar.add(btnStartPaintthread);

		btnLaunchShip = new JButton("Launch SHIP");
		btnLaunchShip.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_W) {
					move = "W";
					// System.out.println("Press W");					
					myCosmos.getShips().get(0)
							.setY(myCosmos.getShips().get(0).getY() - 2);
				}
				if (e.getKeyCode() == KeyEvent.VK_S) {
					move = "S";
					// System.out.println("Press S");
					myCosmos.getShips().get(0)
							.setY(myCosmos.getShips().get(0).getY() + 2);
				}
				if (e.getKeyCode() == KeyEvent.VK_A) {
					move = "A";
					// System.out.println("Press A");
					myCosmos.getShips().get(0)
							.setX(myCosmos.getShips().get(0).getX() - 2);
				}
				if (e.getKeyCode() == KeyEvent.VK_D) {
					move = "D";
					// System.out.println("Press D");
					myCosmos.getShips().get(0)
							.setX(myCosmos.getShips().get(0).getX() + 2);
				}
			}
		});
		btnLaunchShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ship myShip = new Ship(myRandom.nextInt(400), myRandom
						.nextInt(400), 10);
				myShip.start();
				myCosmos.getShips().add(myShip);
				System.out.println(myCosmos);
			}
		});
		toolBar.add(btnLaunchShip);
		panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
	}
}