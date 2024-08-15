package com.balitechy.spacewar.main;

public class VectorialGameFactory implements GameFactory{
    @Override
    public IPlayer createPlayer(double x, double y, Game game) {
        return new VectorialPlayer(x, y, game);
    }

    @Override
    public IBullet createBullet(double x, double y, Game game) {
        return new VectorialBullet(x, y, game);
    }

    @Override
    public IBackgroundRender createBackgroundRenderer() {
        return new VectorialBackgroundRender();
    }
}
