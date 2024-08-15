package com.balitechy.spacewar.main;

import java.awt.Color;
import java.awt.Graphics;

public class VectorialPlayer extends AbstractPlayer{
    public VectorialPlayer(double x, double y, Game game) {
        super(x, y, game);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        // Triángulo exterior (más alargado verticalmente)
        int[] xPointsOuter = {
            (int) x + (WIDTH / 2), // Vértice superior
            (int) x,               // Vértice inferior izquierdo
            (int) x + WIDTH        // Vértice inferior derecho
        };
        int[] yPointsOuter = {
            (int) y - (HEIGHT / 2), // Vértice superior (más alto que el triángulo interior)
            (int) y + HEIGHT,       // Vértice inferior izquierdo
            (int) y + HEIGHT        // Vértice inferior derecho
        };

        // Dibuja el triángulo exterior
        g.fillPolygon(xPointsOuter, yPointsOuter, 3);

        // Triángulo interior (ajustado dentro del triángulo exterior)
        int innerHeight = HEIGHT / 2; // Altura del triángulo interior
        int innerWidth = WIDTH / 2;   // Anchura del triángulo interior
        int[] xPointsInner = {
            (int) x + (WIDTH / 2), // Vértice superior
            (int) x + (WIDTH / 4), // Vértice inferior izquierdo
            (int) x + (3 * WIDTH / 4) // Vértice inferior derecho
        };
        int[] yPointsInner = {
            (int) y,               // Vértice superior
            (int) y + innerHeight, // Vértice inferior izquierdo
            (int) y + innerHeight  // Vértice inferior derecho
        };

        // Dibuja el triángulo interior
        g.setColor(Color.BLACK); // Cambia el color si lo deseas
        g.fillPolygon(xPointsInner, yPointsInner, 3);
    }

    @Override
    public void shoot() {
        IBullet b = new VectorialBullet(x + (WIDTH / 2) - 5, y - 18, game);
        game.getBullets().add(b);
    }
}
