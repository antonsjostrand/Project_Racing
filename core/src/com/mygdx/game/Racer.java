package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Racer {
    private Sprite sprite;
    private int speedX = 0, speedY = 0;
    private int laps = 0;


    public Racer(String image, float x, float y, float sizeX, float sizeY){
        sprite = new Sprite(new Texture(image));
        sprite.setX(x);
        sprite.setY(y);
        sprite.setSize(sizeX, sizeY);
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

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public Sprite getSprite() {
        return sprite;
    }

    //Uppdaterar bilens position beroende på hur snabbt man kör.
    public void updatePostion(){
        setX(getX() + getSpeedX());
        setY(getY() + getSpeedY());
    }
    //Metod för att stänga av spelet när någon kört 3 varv.
    public int checkLaps(Racer racer){
        float x = racer.getX();
        float y = racer.getY();

        if ((x >= 690 && x <= 693) && (y >= 46 && y <= 205)){
            laps++;
            if(laps == 4){
                System.exit(0);
            }
        }

        return laps;
    }

    //Metod för att rita ut objekt.
    public void draw(SpriteBatch batch){
        sprite.draw(batch);
    }

}
