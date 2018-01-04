package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;


import java.security.SecureRandom;

public class Figure {
    private Sprite sprite;


    public Figure(String image, float x, float y, float size){
        sprite = new Sprite(new Texture(image));
        sprite.setX(x);
        sprite.setY(y);
        sprite.setSize(size, size);

        getSprite().setOriginCenter();

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

    //Används vid placering av hinder.
    public Rectangle figureRectangle(){
        return new Rectangle(
                getSprite().getX() + 25,
                getSprite().getY() + 25,
                getSprite().getWidth() - 49,
                getSprite().getHeight() -49
        );

    }
    //Används vid placering av powerups
    public Rectangle figureRectanglePowerup(){
        return new Rectangle(
                getSprite().getX() + 12.5f,
                getSprite().getY() + 12.5f,
                getSprite().getWidth() - 24,
                getSprite().getHeight() -24
        );

    }

    //Används vid kontroll av kollision med hinder och powerups.
    public Rectangle figureArea(){
        return new Rectangle(
                getSprite().getX(),
                getSprite().getY(),
                getSprite().getWidth()-5,
                getSprite().getHeight()
        );
    }

    //Metod som kollar om man kan placera obstacle på en viss plats.
    public boolean figurePlacement(Rectangle rectangle){
        return figureRectangle().overlaps(rectangle);
    }

    public boolean figurePlacementPowerup(Rectangle rectangle){
        return figureRectanglePowerup().overlaps(rectangle);
    }

    public void draw(SpriteBatch batch){
        sprite.draw(batch);
    }
}
