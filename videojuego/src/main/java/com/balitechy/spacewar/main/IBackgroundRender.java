package com.balitechy.spacewar.main;

import java.io.IOException;
import java.awt.Graphics;
import java.awt.Canvas;

public interface IBackgroundRender {
    void render(Graphics g, Canvas c) throws IOException;
}
