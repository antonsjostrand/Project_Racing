package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Track {
        private Sprite sprite;

        public Track(String image, float x, float y, float sizeX, float sizeY){
            sprite = new Sprite(new Texture(image));
            sprite.setX(x);
            sprite.setY(y);
            sprite.setSize(sizeX,sizeY);
        }

        public void draw(SpriteBatch batch){
            sprite.draw(batch);
        }
}
