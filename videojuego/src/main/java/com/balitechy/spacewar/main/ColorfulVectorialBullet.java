package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.awt.Color;

public class ColorfulVectorialBullet extends AbstractBullet{
    public ColorfulVectorialBullet(double x, double y, Game game) {
        super(x, y, game);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval((int) x, (int) y, WIDTH-7, HEIGHT);  // Dibujar la bala como un óvalo rojo
    }
}
