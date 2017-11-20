package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Track {
        private Sprite sprite;

        public Track(String image, float x, float y, float sizeX, float sizeY){
            sprite = new Sprite(new Texture(image));
            sprite.setX(x);
            sprite.setY(y);
            sprite.setSize(sizeX,sizeY);
        }

        public float getX(){
              return sprite.getX();
          }

        public float getY(){
              return sprite.getY();
          }

        public void setX(float x){
             sprite.setX(x);
         }

        public void setY(float y){
             sprite.setY(y);
         }

        public Sprite getSprite() {
            return sprite;
         }

        public Rectangle trackArea(){
            return new Rectangle(
                     getSprite().getX(),
                     getSprite().getY(),
                     getSprite().getWidth(),
                     getSprite().getHeight()
             );
          }


        public void draw(SpriteBatch batch){
            sprite.draw(batch);
        }
}
