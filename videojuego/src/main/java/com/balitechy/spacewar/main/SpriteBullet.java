package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SpriteBullet extends AbstractBullet{
	
	private BufferedImage image;

    public SpriteBullet(double x, double y, Game game) {
        super(x, y, game);
        image = game.getSprites().getImage(35, 52, WIDTH, HEIGHT);  // Cargar la imagen de la bala
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(image, (int) x, (int) y, null);  // Dibujar la bala usando la imagen
    }
}
