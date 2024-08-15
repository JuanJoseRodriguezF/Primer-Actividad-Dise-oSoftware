package com.balitechy.spacewar.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SpritePlayer extends AbstractPlayer{
	
	private BufferedImage image;

    public SpritePlayer(double x, double y, Game game) {
        super(x, y, game);
        
        // Obtener la imagen del jugador desde el sprite sheet
        image = game.getSprites().getImage(219, 304, WIDTH, HEIGHT);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(image, (int) x, (int) y, null);
    }

    @Override
    public void shoot() {
        IBullet b = new SpriteBullet(x + (WIDTH / 2) - 5, y - 18, game);
        game.getBullets().add(b);
    }
}
