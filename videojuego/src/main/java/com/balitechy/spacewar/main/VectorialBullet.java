package com.balitechy.spacewar.main;

import java.awt.Color;
import java.awt.Graphics;

public class VectorialBullet extends AbstractBullet{
    public VectorialBullet(double x, double y, Game game) {
        super(x, y, game);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect((int) x, (int) y, WIDTH-7, HEIGHT);
    }
}
