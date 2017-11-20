package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Racer {
    private Sprite sprite;
    private float speedX = 0, speedY = 0;
    private int laps = 0;
    private final float SHRINK_COLLISION_RADIUS_HEIGHT, SHRINK_COLLISION_RADIUS_WIDTH;


    public Racer(String image, float x, float y, float sizeX, float sizeY){
        sprite = new Sprite(new Texture(image));
        sprite.setX(x);
        sprite.setY(y);
        sprite.setSize(sizeX, sizeY);
        SHRINK_COLLISION_RADIUS_HEIGHT = getSprite().getHeight()/8;
        SHRINK_COLLISION_RADIUS_WIDTH = getSprite().getWidth()/8;
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

    public float getSpeedX() {
        return speedX;
    }

    public void setSpeedX(float speedX) {
        this.speedX = speedX;
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
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
                //System.exit(0);
            }
        }
        return laps;
    }

    public Rectangle getCollisionArea(){
        return new Rectangle(
                getSprite().getX() + SHRINK_COLLISION_RADIUS_WIDTH,
                getSprite().getY() + SHRINK_COLLISION_RADIUS_HEIGHT,
                getSprite().getWidth() - (4*SHRINK_COLLISION_RADIUS_WIDTH),
                getSprite().getHeight() - (4*SHRINK_COLLISION_RADIUS_HEIGHT)
        );
    }

    public boolean collidesWithRacer(Rectangle rectangle){
        return getCollisionArea().overlaps(rectangle);
    }

    public boolean insideTrack(Rectangle rectangle) {
        return getCollisionArea().overlaps(rectangle);
    }

    //Metod för att rita ut objekt.
    public void draw(SpriteBatch batch){
        sprite.draw(batch);
    }

}
