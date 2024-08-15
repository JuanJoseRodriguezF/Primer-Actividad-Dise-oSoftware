package com.balitechy.spacewar.main;

public abstract class AbstractBullet implements IBullet{
    protected double x, y;
    protected Game game;
    public static final int WIDTH = 11;
    public static final int HEIGHT = 21;

    public AbstractBullet(double x, double y, Game game) {
        this.x = x;
        this.y = y;
        this.game = game;
    }

    @Override
    public void tick() {
        y -= 5;
    }
    
    @Override
    public double getY() {
        return y;
    }
}
