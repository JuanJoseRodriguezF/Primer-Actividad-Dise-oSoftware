package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class VectorialBackgroundRender extends AbstractBackgroundRender{
    @Override
    protected void drawAdditionalElements(Graphics g, Canvas c) {
        g.setColor(Color.WHITE);
        // Parámetros para la circunferencia
        int diameter = 160; // Diámetro de la circunferencia
        int x = 10; // Coordenada X en la esquina superior izquierda
        int y = 10; // Coordenada Y en la esquina superior izquierda
        
        // Dibujar una circunferencia en la esquina superior izquierda
        g.drawOval(x, y, diameter, diameter);
    }
}
