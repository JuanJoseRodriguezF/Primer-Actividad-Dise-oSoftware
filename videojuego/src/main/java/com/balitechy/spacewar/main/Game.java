package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.balitechy.spacewar.main.*;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 320;
	public static final int HEIGHT = WIDTH / 12 * 9;
	public static final int SCALE = 2;
	public final String TITLE = "Space War 2D";
	
	private boolean running = false;
	private Thread thread;
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	
	
	private SpritesImageLoader sprites;
	
	//Game components
	private GameFactory gameFactory;
    private IPlayer player;
    private List<IBullet> bullets;
    private IBackgroundRender backgRenderer;

	public Game(GameFactory gameFactory) {
        this.gameFactory = gameFactory;
		this.bullets = new ArrayList<>(); // Inicializar la lista
		this.sprites = new SpritesImageLoader("/sprites.png"); // Cambia la ruta según corresponda
    }
	
	public void init(){
		requestFocus();
		
		// Add keyboard listener
		addKeyListener(new InputHandler(this));

		// Initialize SpritesImageLoader
		try {
			sprites.loadImage(); // Cargar la imagen aquí
		} catch (IOException e) {
			e.printStackTrace();
			// Maneja el error de carga de la imagen aquí
		}
		
		// Initialize game components.
		player = gameFactory.createPlayer((WIDTH * SCALE - 50) / 2, HEIGHT * SCALE - 50, this);

		double initialX = player.getX(); // Obtiene la posición X del jugador.
		double initialY = player.getY(); // Obtiene la posición Y del jugador.

		// Set player position at the bottom center.
        backgRenderer = gameFactory.createBackgroundRenderer();
	}

	public SpritesImageLoader getSprites(){
		return sprites;
	}
	
	public List<IBullet> getBullets(){
		return bullets;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		switch(key){
			case KeyEvent.VK_RIGHT:
				player.setVelX(5);
			break;
			
			case KeyEvent.VK_LEFT:
				player.setVelX(-5);
			break;
			
			case KeyEvent.VK_UP:
				player.setVelY(-5);
			break;
			
			case KeyEvent.VK_DOWN:
				player.setVelY(5);
			break;
			
			case KeyEvent.VK_SPACE:
				player.shoot();
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		switch(key){
			case KeyEvent.VK_RIGHT:
				player.setVelX(0);
			break;
			
			case KeyEvent.VK_LEFT:
				player.setVelX(0);
			break;
			
			case KeyEvent.VK_UP:
				player.setVelY(0);
			break;
			
			case KeyEvent.VK_DOWN:
				player.setVelY(0);
			break;
			
		}
	}
	
	private synchronized void start(){
		if(running) return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	private synchronized void stop(){
		if(!running) return;
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}
	
	/*
	 * Game thread runner. 
	 */
	@Override
	public void run() {
		init();
		
		long lastTime = System.nanoTime();
		final double numOfTicks = 60.0;
		double ns = 1000000000 / numOfTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println(updates + "ticks, fps " + frames);
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}
	
	/*
	 * Run the ticks of all game components.
	 */
	public void tick(){
		player.tick();
		// Actualiza cada bala
        for (int i = 0; i < bullets.size(); i++) {
			IBullet bullet = bullets.get(i);
			bullet.tick();
			if (bullet.getY() < 0) {
				removeBullet(bullet);
				i--; // Ajustar índice después de eliminación
			}
		}
	}
	
	/*
	 * Render overall game components.
	 */
	public void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		/////////////////////////////////
		
		try {
			backgRenderer.render(g, this);
			player.render(g);
			// Renderiza cada bala
            for (IBullet bullet : bullets) {
                bullet.render(g);
            }

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		////////////////////////////////
		g.dispose();
		bs.show();
	}

	public void addBullet(IBullet bullet) {
        bullets.add(bullet);
    }

    public void removeBullet(IBullet bullet) {
        bullets.remove(bullet);
    }
	
	public static void main(String args[]){		
		GameFactory factory = new ColorfulVectorialGameFactory();
		Game game = new Game(factory);
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		
		JFrame frame = new JFrame(game.TITLE);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		game.start();
	}
	
}
