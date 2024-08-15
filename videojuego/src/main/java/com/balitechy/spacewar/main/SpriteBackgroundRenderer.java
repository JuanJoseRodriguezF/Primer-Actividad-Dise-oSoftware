package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteBackgroundRenderer implements IBackgroundRender{

	@Override
    public void render(Graphics g, Canvas c) throws IOException {
        BufferedImage background;
        SpritesImageLoader bg = new SpritesImageLoader("/bg.png");
        bg.loadImage();
        background = bg.getImage(0, 0, c.getWidth(), c.getHeight());
        g.drawImage(background, 0, 0, c.getWidth(), c.getHeight(), c);
    }
	
}
