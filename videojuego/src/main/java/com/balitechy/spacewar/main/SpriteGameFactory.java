package com.balitechy.spacewar.main;

public class SpriteGameFactory implements GameFactory{
    @Override
    public IPlayer createPlayer(double x, double y, Game game) {
        return new SpritePlayer(x, y, game);
    }

    @Override
    public IBullet createBullet(double x, double y, Game game) {
        return new SpriteBullet(x, y, game);
    }

    @Override
    public IBackgroundRender createBackgroundRenderer() {
        return new SpriteBackgroundRenderer();
    }
}
