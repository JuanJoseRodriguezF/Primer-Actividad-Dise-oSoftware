package com.balitechy.spacewar.main;

public interface GameFactory {
    IPlayer createPlayer(double x, double y, Game game);
    IBullet createBullet(double x, double y, Game game);
    IBackgroundRender createBackgroundRenderer();
}
