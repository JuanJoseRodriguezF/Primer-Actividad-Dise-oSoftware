package com.balitechy.spacewar.main;

public class ColorfulVectorialGameFactory implements GameFactory{
    @Override
    public IPlayer createPlayer(double x, double y, Game game) {
        return new ColorfulVectorialPlayer(x, y, game);
    }

    @Override
    public IBullet createBullet(double x, double y, Game game) {
        return new ColorfulVectorialBullet(x, y, game);
    }

    @Override
    public IBackgroundRender createBackgroundRenderer() {
        return new ColorfulVectorialBackgroundRender();
    }
}
