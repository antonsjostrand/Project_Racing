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

    //Ändrar farten för samtliga opponents när de kör på ett hinder.
    public void opponentCollideObstacle(){
        if (getSpeedX() > 0){
            setSpeedX(0.1f);
        }
        else if (getSpeedX() < 0){
            setSpeedX(-0.1f);
        }
        if (getSpeedY() > 0){
            setSpeedY(0.1f);
        }
        else if (getSpeedY() < 0){
            setSpeedY(-0.1f);
        }
    }

    //används när opponent inte kolliderar med hinder för att accelera igen
    public void opponentNotCollideObstacle(){
        if (getSpeedX() == 0.1f){
            setSpeedX(3);
        }
        else if (getSpeedX() == -0.1f){
            setSpeedX(-3);
        }
        if (getSpeedY() == 0.1f){
            setSpeedY(3);
        }
        else if (getSpeedY() == -0.1f){
            setSpeedY(-3);
        }
    }

    //Skapar en rektangel av ett objekt som sedan används för att kolla ifall det kolliderar på något sätt.
    //Används för att kontrollera om spelaren är utanför banan!
    public Rectangle getCollisionArea(){
        return new Rectangle(
                getSprite().getX() + SHRINK_COLLISION_RADIUS_WIDTH + 5,
                getSprite().getY() + SHRINK_COLLISION_RADIUS_HEIGHT + 5,
                getSprite().getWidth() - (5*SHRINK_COLLISION_RADIUS_WIDTH),
                getSprite().getHeight() - (5*SHRINK_COLLISION_RADIUS_HEIGHT)
        );
    }

    //Skapar en rektangel av ett objekt som sedan används för att kolla ifall det kolliderar på något sätt.
    public Rectangle getCollisionAreaRacer(){
        return new Rectangle(
                getSprite().getX() + SHRINK_COLLISION_RADIUS_WIDTH + 5,
                getSprite().getY() + SHRINK_COLLISION_RADIUS_HEIGHT + 5,
                getSprite().getWidth() - (SHRINK_COLLISION_RADIUS_WIDTH + 3),
                getSprite().getHeight() - (SHRINK_COLLISION_RADIUS_HEIGHT)
        );
    }

    //Metod som tar en rektangel som parameter och sedan kollar ifall en racer kolliderar med en annan.
    public boolean collidesWithRacer(Rectangle rectangle){
        return getCollisionAreaRacer().overlaps(rectangle);
    }

    //Metod som tar en rektangel som parameter och sedan kollar ifall spelaren kör innanför eller utanför banan.
    public boolean insideTrack(Rectangle rectangle) {
        return getCollisionArea().overlaps(rectangle);
    }
    //Metod som kollar ifall man kolliderar med ett hinder
    public boolean collidesWithObstacle(Rectangle obstacle){
        return getCollisionAreaRacer().overlaps(obstacle);
    }

    //Metod för att rita ut objekt.
    public void draw(SpriteBatch batch){
        sprite.draw(batch);
    }

}
