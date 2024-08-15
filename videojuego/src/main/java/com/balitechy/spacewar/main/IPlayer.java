package com.balitechy.spacewar.main;

import java.awt.Graphics;

public interface IPlayer {
    void tick();
    void render(Graphics g);
    void setVelX(double velX);
    void setVelY(double velY);
    void shoot();

    double getX(); // Método para obtener la posición X
    double getY(); // Método para obtener la posición Y
}
