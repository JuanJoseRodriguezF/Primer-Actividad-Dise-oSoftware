package com.balitechy.spacewar.main;

import java.awt.Graphics;

public abstract class AbstractPlayer implements IPlayer{
    protected double x, y;
    protected double velX, velY;
    protected final int WIDTH = 56;
    protected final int HEIGHT = 28;
    protected Game game;

    public AbstractPlayer(double x, double y, Game game) {
        this.x = x;
        this.y = y;
        this.game = game;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        // Limitar los movimientos del jugador dentro del área del juego
        if (x <= 0) x = 0;
        if (x >= (Game.WIDTH * Game.SCALE) - WIDTH) x = (Game.WIDTH * Game.SCALE) - WIDTH;
        if (y <= 0) y = 0;
        if (y >= (Game.HEIGHT * Game.SCALE) - HEIGHT) y = (Game.HEIGHT * Game.SCALE) - HEIGHT;
    }

    @Override
    public void setVelX(double velX) {
        this.velX = velX;
    }

    @Override
    public void setVelY(double velY) {
        this.velY = velY;
    }

    // Implementación de los métodos getX y getY
    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    // Cada clase concreta implementará su propio método render()
    @Override
    public abstract void render(Graphics g);
}
