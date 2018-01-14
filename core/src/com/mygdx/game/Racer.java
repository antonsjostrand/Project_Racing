package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Racer {
    private Sprite sprite;
    private float speedX = 0, speedY = 0;
    private int laps = 0, antiCheatLaps = 0, antiCheatCount = 0;
    private int antiCheatLapsLevelTwo = 0, antiCheatCountLevelTwo = 0;
    private int antiCheatLapsLevelThree = 0, antiCheatCountLevelThree = 0;
    private final float SHRINK_HEIGHT, SHRINK_WIDTH;


    public Racer(String image, float x, float y, float sizeX, float sizeY){
        sprite = new Sprite(new Texture(image));
        sprite.setX(x);
        sprite.setY(y);
        sprite.setSize(sizeX, sizeY);
        SHRINK_HEIGHT = getSprite().getHeight()/8;
        SHRINK_WIDTH = getSprite().getWidth()/8;
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


    //Metod som förhindrar fusk på level ett och räknar varv.
    public int antiCheatingLevelOne(Racer racer) {
        if (racer.getX() >= 45 && racer.getX() <= 200 && racer.getY() >= 45 && racer.getY() <= 200) {
            antiCheatCount++;
        }
        if (racer.getX() >= 665 && racer.getX() <= 693 && racer.getY() >= 30 && racer.getY() <= 210 && antiCheatCount > 0 && antiCheatLaps == 0) {
            antiCheatLaps = 1;
            antiCheatCount = 0;
        } else if (racer.getX() >= 665 && racer.getX() <= 693 && racer.getY() >= 30 && racer.getY() <= 210 && antiCheatCount > 0 && antiCheatLaps == 1) {
            antiCheatLaps = 2;
            antiCheatCount = 0;
        } else if (racer.getX() >= 665 && racer.getX() <= 693 && racer.getY() >= 30 && racer.getY() <= 210 && antiCheatCount > 0 && antiCheatLaps == 2) {
            antiCheatLaps = 3;
            antiCheatCount = 0;
        }
        return antiCheatLaps;
    }
    //Metod som förhindrar fusk på level två och räknar varv.
    public int antiCheatingLevelTwo(Racer racer) {
        if (racer.getX() >= 45 && racer.getX() <= 200 && racer.getY() >= 45 && racer.getY() <= 200) {
            antiCheatCountLevelTwo++;
        }
        if (racer.getX() >= 665 && racer.getX() <= 693 && racer.getY() >= 30 && racer.getY() <= 210 && antiCheatCountLevelTwo > 0 && antiCheatLapsLevelTwo == 0) {
            antiCheatLapsLevelTwo = 1;
            antiCheatCountLevelTwo = 0;
        } else if (racer.getX() >= 665 && racer.getX() <= 693 && racer.getY() >= 30 && racer.getY() <= 210 && antiCheatCountLevelTwo > 0 && antiCheatLapsLevelTwo == 1) {
            antiCheatLapsLevelTwo = 2;
            antiCheatCountLevelTwo = 0;
        } else if (racer.getX() >= 665 && racer.getX() <= 693 && racer.getY() >= 30 && racer.getY() <= 210 && antiCheatCountLevelTwo > 0 && antiCheatLapsLevelTwo == 2) {
            antiCheatLapsLevelTwo = 3;
            antiCheatCountLevelTwo = 0;
        }else if (racer.getX() >= 665 && racer.getX() <= 693 && racer.getY() >= 30 && racer.getY() <= 210 && antiCheatCountLevelTwo > 0 && antiCheatLapsLevelTwo == 3) {
            antiCheatLapsLevelTwo = 4;
            antiCheatCountLevelTwo = 0;
        } else if (racer.getX() >= 665 && racer.getX() <= 693 && racer.getY() >= 30 && racer.getY() <= 210 && antiCheatCountLevelTwo > 0 && antiCheatLapsLevelTwo == 4) {
            antiCheatLapsLevelTwo = 5;
            antiCheatCountLevelTwo = 0;
        }
        return antiCheatLapsLevelTwo;
    }
    //Metod som förhindrar fusk på level tre och räknar varv.
    public int antiCheatingLevelThree(Racer racer) {
        if (racer.getX() >= 45 && racer.getX() <= 200 && racer.getY() >= 45 && racer.getY() <= 200) {
            antiCheatCountLevelThree++;
        }
        if (racer.getX() >= 665 && racer.getX() <= 693 && racer.getY() >= 30 && racer.getY() <= 210 && antiCheatCountLevelThree > 0 && antiCheatLapsLevelThree == 0) {
            antiCheatLapsLevelThree = 1;
            antiCheatCountLevelThree = 0;
        } else if (racer.getX() >= 665 && racer.getX() <= 693 && racer.getY() >= 30 && racer.getY() <= 210 && antiCheatCountLevelThree > 0 && antiCheatLapsLevelThree == 1) {
            antiCheatLapsLevelThree = 2;
            antiCheatCountLevelThree = 0;
        } else if (racer.getX() >= 665 && racer.getX() <= 693 && racer.getY() >= 30 && racer.getY() <= 210 && antiCheatCountLevelThree > 0 && antiCheatLapsLevelThree == 2) {
            antiCheatLapsLevelThree = 3;
            antiCheatCountLevelThree = 0;
        }else if (racer.getX() >= 665 && racer.getX() <= 693 && racer.getY() >= 30 && racer.getY() <= 210 && antiCheatCountLevelThree > 0 && antiCheatLapsLevelThree == 3) {
            antiCheatLapsLevelThree = 4;
            antiCheatCountLevelThree = 0;
        } else if (racer.getX() >= 665 && racer.getX() <= 693 && racer.getY() >= 30 && racer.getY() <= 210 && antiCheatCountLevelThree > 0 && antiCheatLapsLevelThree == 4) {
            antiCheatLapsLevelThree = 5;
            antiCheatCountLevelThree = 0;
        } else if (racer.getX() >= 665 && racer.getX() <= 693 && racer.getY() >= 30 && racer.getY() <= 210 && antiCheatCountLevelThree > 0 && antiCheatLapsLevelThree == 5) {
            antiCheatLapsLevelThree = 6;
            antiCheatCountLevelThree = 0;
        } else if (racer.getX() >= 665 && racer.getX() <= 693 && racer.getY() >= 30 && racer.getY() <= 210 && antiCheatCountLevelThree > 0 && antiCheatLapsLevelThree == 6) {
            antiCheatLapsLevelThree = 7;
            antiCheatCountLevelThree = 0;
        }
        return antiCheatLapsLevelThree;
    }

    //Ändrar farten för samtliga opponents när de kör på ett hinder.
    public void opponentCollideObstacle(){
        if (getSpeedX() > 0){
            setSpeedX(0.5f);
        }
        else if (getSpeedX() < 0){
            setSpeedX(-0.5f);
        }
        if (getSpeedY() > 0){
            setSpeedY(0.5f);
        }
        else if (getSpeedY() < 0){
            setSpeedY(-0.5f);
        }
    }

    //används när opponent inte kolliderar med hinder för att accelera igen
    public void opponentNotCollideObstacle(){
        if (getSpeedX() == 0.5f){
            setSpeedX(3);
        }
        else if (getSpeedX() == -0.5f){
            setSpeedX(-3);
        }
        if (getSpeedY() == 0.5f){
            setSpeedY(3);
        }
        else if (getSpeedY() == -0.5f){
            setSpeedY(-3);
        }
    }

    //Används för att kontrollera ifall en motståndare plockar upp en powerup
    public void opponentCollidePowerup(){
        if (getSpeedX() > 0){
            setSpeedX(5);
        }
        else if (getSpeedX() < 0){
            setSpeedX(-5);
        }
        if (getSpeedY() > 0){
            setSpeedY(5);
        }
        else if (getSpeedY() < 0){
            setSpeedY(-5);
        }
    }

    //Skapar en rektangel av ett objekt som sedan används för att kolla ifall det kolliderar på något sätt.
    //Används för att kontrollera om spelaren är utanför banan!
    public Rectangle getCollisionArea(){
        return new Rectangle(
                getSprite().getX() + SHRINK_WIDTH + 5,
                getSprite().getY() + SHRINK_HEIGHT + 5,
                getSprite().getWidth() - (5*SHRINK_WIDTH),
                getSprite().getHeight() - (5*SHRINK_HEIGHT)
        );
    }

    //Skapar en rektangel av ett objekt som sedan används för att kolla ifall det kolliderar på något sätt.
    public Rectangle getCollisionAreaRacer(){
        return new Rectangle(
                getSprite().getX() + SHRINK_WIDTH + 5,
                getSprite().getY() + SHRINK_HEIGHT + 5,
                getSprite().getWidth() - (SHRINK_WIDTH + 3),
                getSprite().getHeight() - (SHRINK_HEIGHT)
        );
    }
    //Används för att kontrollera om man kolliderar med powerup eller obstacle
    public Rectangle getCollisionAreaFigure(){
        return new Rectangle(
                getSprite().getX()+3,
                getSprite().getY()+2,
                getSprite().getWidth()-10,
                getSprite().getHeight()-2
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
        return getCollisionAreaFigure().overlaps(obstacle);
    }

    //Metod som kollar ifall man kolliderar med em powerup
    public boolean collidesWithPowerup(Rectangle obstacle){
        return getCollisionAreaFigure().overlaps(obstacle);
    }
    //Metod för att rita ut objekt.
    public void draw(SpriteBatch batch){
        sprite.draw(batch);
    }

}
