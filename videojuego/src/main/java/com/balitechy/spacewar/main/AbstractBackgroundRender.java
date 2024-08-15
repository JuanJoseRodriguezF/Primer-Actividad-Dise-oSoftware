package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public abstract class AbstractBackgroundRender implements IBackgroundRender{
    protected void drawBackground(Graphics g, Canvas c) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, c.getWidth(), c.getHeight());  // Fondo negro
    }
    
    protected abstract void drawAdditionalElements(Graphics g, Canvas c);

    @Override
    public void render(Graphics g, Canvas c) {
        drawBackground(g, c);
        drawAdditionalElements(g, c);
    }
}
