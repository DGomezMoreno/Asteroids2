package logic;

import java.util.Vector;

public class Cosmos {
	private Vector<Asteroid> asteroids = new Vector<Asteroid>();
	private Vector<Ship> ships = new Vector<Ship>();

	public Cosmos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vector<Asteroid> getAsteroids() {
		return asteroids;
	}

	public void setAsteroids(Vector<Asteroid> asteroids) {
		this.asteroids = asteroids;
	}
	
	public Vector<Ship> getShips() {
		return ships;
	}

	public void setShips(Vector<Ship> ships) {
		this.ships = ships;
	}

	@Override
	public String toString() {
		return "Cosmos [asteroids=" + asteroids + ", ships=" + ships + "]";
	}
	
	

}