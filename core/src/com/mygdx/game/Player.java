package com.mygdx.game;

public class Player extends Racer{

    public Player(String image, float x, float y, float sizeX, float sizeY){
        super(image, x, y, sizeX, sizeY);
        getSprite().setOriginCenter();
    }

    //Metod för att föra spelaren framåt, uppåt och bakåt beroende på dess rotation.
    public void accelerate(){
            if(getSprite().getRotation() >= 0 && getSprite().getRotation() < 25){
                setSpeedX(3);
                setSpeedY(0);
            }
            else if(getSprite().getRotation() >= 25 && getSprite().getRotation() < 65){
                setSpeedX(3);
                setSpeedY(3);
            }
            else if(getSprite().getRotation() >= 65 && getSprite().getRotation() < 115){
                setSpeedX(0);
                setSpeedY(3);
            }
            else if(getSprite().getRotation() >= 115 && getSprite().getRotation() < 155){
                setSpeedX(-3);
                setSpeedY(3);
            }
            else if(getSprite().getRotation() >= 155 && getSprite().getRotation() < 205){
                setSpeedX(-3);
                setSpeedY(0);
            }
            else if(getSprite().getRotation() >= 205 && getSprite().getRotation() < 245){
                setSpeedX(-3);
                setSpeedY(-3);
            }
            else if(getSprite().getRotation() >= 245 && getSprite().getRotation() < 295){
                setSpeedX(0);
                setSpeedY(-3);
            }
            else if(getSprite().getRotation() >= 295 && getSprite().getRotation() < 335){
                setSpeedX(3);
                setSpeedY(-3);
            }
            else if(getSprite().getRotation() == 360){
                getSprite().setRotation(0);
            }
            else if(getSprite().getRotation() >= 335 && getSprite().getRotation() < 25){
                setSpeedX(3);
                setSpeedY(0);
            }
            if(getSprite().getRotation() <= 0 && getSprite().getRotation() > -25){
                 setSpeedX(3);
                 setSpeedY(0);
            }
            else if(getSprite().getRotation() <= -25 && getSprite().getRotation() > -65){
                 setSpeedX(3);
                 setSpeedY(-3);
            }
            else if(getSprite().getRotation() <= -65 && getSprite().getRotation() > -115){
                 setSpeedX(0);
                 setSpeedY(-3);
            }
            else if(getSprite().getRotation() <= -115 && getSprite().getRotation() > -155){
                 setSpeedX(-3);
                 setSpeedY(-3);
            }
            else if(getSprite().getRotation() <= -155 && getSprite().getRotation() > -205){
                 setSpeedX(-3);
                 setSpeedY(0);
            }
            else if(getSprite().getRotation() <= -205 && getSprite().getRotation() > -245){
                 setSpeedX(-3);
                 setSpeedY(3);
            }
            else if(getSprite().getRotation() <= -245 && getSprite().getRotation() > -295){
                 setSpeedX(0);
                 setSpeedY(3);
            }
            else if(getSprite().getRotation() <= -295 && getSprite().getRotation() > -335){
                 setSpeedX(3);
                 setSpeedY(3);
            }
            else if(getSprite().getRotation() == -360){
                 getSprite().setRotation(0);
            }
            else if(getSprite().getRotation() <= -335 && getSprite().getRotation() > -25){
                 setSpeedX(3);
                 setSpeedY(0);
            }
    }

    //Metod som används för att flytta på spelaren när den kör utanför banan.
    public void accelerateOutOfBounds(){
        if(getSprite().getRotation() >= 0 && getSprite().getRotation() < 25){
            setSpeedX(0.5f);
            setSpeedY(0);
        }
        else if(getSprite().getRotation() >= 25 && getSprite().getRotation() < 65){
            setSpeedX(0.5f);
            setSpeedY(0.5f);
        }
        else if(getSprite().getRotation() >= 65 && getSprite().getRotation() < 115){
            setSpeedX(0);
            setSpeedY(0.5f);
        }
        else if(getSprite().getRotation() >= 115 && getSprite().getRotation() < 155){
            setSpeedX(-0.5f);
            setSpeedY(0.5f);
        }
        else if(getSprite().getRotation() >= 155 && getSprite().getRotation() < 205){
            setSpeedX(-0.5f);
            setSpeedY(0);
        }
        else if(getSprite().getRotation() >= 205 && getSprite().getRotation() < 245){
            setSpeedX(-0.5f);
            setSpeedY(-0.5f);
        }
        else if(getSprite().getRotation() >= 245 && getSprite().getRotation() < 295){
            setSpeedX(0);
            setSpeedY(-0.5f);
        }
        else if(getSprite().getRotation() >= 295 && getSprite().getRotation() < 335){
            setSpeedX(0.5f);
            setSpeedY(-0.5f);
        }
        else if(getSprite().getRotation() == 360){
            getSprite().setRotation(0);
        }
        else if(getSprite().getRotation() >= 335 && getSprite().getRotation() < 25){
            setSpeedX(0.5f);
            setSpeedY(0);
        }
        if(getSprite().getRotation() <= 0 && getSprite().getRotation() > -25){
            setSpeedX(0.5f);
            setSpeedY(0);
        }
        else if(getSprite().getRotation() <= -25 && getSprite().getRotation() > -65){
            setSpeedX(0.5f);
            setSpeedY(-0.5f);
        }
        else if(getSprite().getRotation() <= -65 && getSprite().getRotation() > -115){
            setSpeedX(0);
            setSpeedY(-0.5f);
        }
        else if(getSprite().getRotation() <= -115 && getSprite().getRotation() > -155){
            setSpeedX(-0.5f);
            setSpeedY(-0.5f);
        }
        else if(getSprite().getRotation() <= -155 && getSprite().getRotation() > -205){
            setSpeedX(-0.5f);
            setSpeedY(0);
        }
        else if(getSprite().getRotation() <= -205 && getSprite().getRotation() > -245){
            setSpeedX(-0.5f);
            setSpeedY(0.5f);
        }
        else if(getSprite().getRotation() <= -245 && getSprite().getRotation() > -295){
            setSpeedX(0);
            setSpeedY(0.5f);
        }
        else if(getSprite().getRotation() <= -295 && getSprite().getRotation() > -335){
            setSpeedX(0.5f);
            setSpeedY(0.5f);
        }
        else if(getSprite().getRotation() == -360){
            getSprite().setRotation(0);
        }
        else if(getSprite().getRotation() <= -335 && getSprite().getRotation() > -25){
            setSpeedX(0.5f);
            setSpeedY(0);
        }
    }

    public void acceleratePowerup(){
        if(getSprite().getRotation() >= 0 && getSprite().getRotation() < 25){
            setSpeedX(5);
            setSpeedY(0);
        }
        else if(getSprite().getRotation() >= 25 && getSprite().getRotation() < 65){
            setSpeedX(5);
            setSpeedY(5);
        }
        else if(getSprite().getRotation() >= 65 && getSprite().getRotation() < 115){
            setSpeedX(0);
            setSpeedY(5);
        }
        else if(getSprite().getRotation() >= 115 && getSprite().getRotation() < 155){
            setSpeedX(-5);
            setSpeedY(5);
        }
        else if(getSprite().getRotation() >= 155 && getSprite().getRotation() < 205){
            setSpeedX(-5);
            setSpeedY(0);
        }
        else if(getSprite().getRotation() >= 205 && getSprite().getRotation() < 245){
            setSpeedX(-5);
            setSpeedY(-5);
        }
        else if(getSprite().getRotation() >= 245 && getSprite().getRotation() < 295){
            setSpeedX(0);
            setSpeedY(-5);
        }
        else if(getSprite().getRotation() >= 295 && getSprite().getRotation() < 335){
            setSpeedX(5);
            setSpeedY(-5);
        }
        else if(getSprite().getRotation() == 360){
            getSprite().setRotation(0);
        }
        else if(getSprite().getRotation() >= 335 && getSprite().getRotation() < 25){
            setSpeedX(5);
            setSpeedY(0);
        }
        if(getSprite().getRotation() <= 0 && getSprite().getRotation() > -25){
            setSpeedX(5);
            setSpeedY(0);
        }
        else if(getSprite().getRotation() <= -25 && getSprite().getRotation() > -65){
            setSpeedX(5);
            setSpeedY(-5);
        }
        else if(getSprite().getRotation() <= -65 && getSprite().getRotation() > -115){
            setSpeedX(0);
            setSpeedY(-5);
        }
        else if(getSprite().getRotation() <= -115 && getSprite().getRotation() > -155){
            setSpeedX(-5);
            setSpeedY(-5);
        }
        else if(getSprite().getRotation() <= -155 && getSprite().getRotation() > -205){
            setSpeedX(-5);
            setSpeedY(0);
        }
        else if(getSprite().getRotation() <= -205 && getSprite().getRotation() > -245){
            setSpeedX(-5);
            setSpeedY(5);
        }
        else if(getSprite().getRotation() <= -245 && getSprite().getRotation() > -295){
            setSpeedX(0);
            setSpeedY(5);
        }
        else if(getSprite().getRotation() <= -295 && getSprite().getRotation() > -335){
            setSpeedX(5);
            setSpeedY(5);
        }
        else if(getSprite().getRotation() == -360){
            getSprite().setRotation(0);
        }
        else if(getSprite().getRotation() <= -335 && getSprite().getRotation() > -25){
            setSpeedX(5);
            setSpeedY(0);
        }
    }

    //Metod som används när spelaren inte håller inne UP-tangenten.
    public void noAccelerate(){
        if(getSprite().getRotation() >= 0 && getSprite().getRotation() < 25){
            setSpeedX(0);
            setSpeedY(0);
        }
        else if(getSprite().getRotation() >= 25 && getSprite().getRotation() < 65){
            setSpeedX(0);
            setSpeedY(0);
        }
        else if(getSprite().getRotation() >= 65 && getSprite().getRotation() < 115){
            setSpeedX(0);
            setSpeedY(0);
        }
        else if(getSprite().getRotation() >= 115 && getSprite().getRotation() < 155){
            setSpeedX(0);
            setSpeedY(0);
        }
        else if(getSprite().getRotation() >= 155 && getSprite().getRotation() < 205){
            setSpeedX(0);
            setSpeedY(0);
        }
        else if(getSprite().getRotation() >= 205 && getSprite().getRotation() < 245){
            setSpeedX(0);
            setSpeedY(0);
        }
        else if(getSprite().getRotation() >= 245 && getSprite().getRotation() < 295){
            setSpeedX(0);
            setSpeedY(0);
        }
        else if(getSprite().getRotation() >= 295 && getSprite().getRotation() < 335){
            setSpeedX(0);
            setSpeedY(0);
        }
        else if(getSprite().getRotation() == 360){
            getSprite().setRotation(0);
        }
        else if(getSprite().getRotation() >= 335 && getSprite().getRotation() < 25){
            setSpeedX(0);
            setSpeedY(0);
        }
        if(getSprite().getRotation() <= 0 && getSprite().getRotation() > -25){
            setSpeedX(0);
            setSpeedY(0);
        }
        else if(getSprite().getRotation() <= -25 && getSprite().getRotation() > -65){
            setSpeedX(0);
            setSpeedY(0);
        }
        else if(getSprite().getRotation() <= -65 && getSprite().getRotation() > -115){
            setSpeedX(0);
            setSpeedY(0);
        }
        else if(getSprite().getRotation() <= -115 && getSprite().getRotation() > -155){
            setSpeedX(0);
            setSpeedY(0);
        }
        else if(getSprite().getRotation() <= -155 && getSprite().getRotation() > -205){
            setSpeedX(0);
            setSpeedY(0);
        }
        else if(getSprite().getRotation() <= -205 && getSprite().getRotation() > -245){
            setSpeedX(0);
            setSpeedY(0);
        }
        else if(getSprite().getRotation() <= -245 && getSprite().getRotation() > -295){
            setSpeedX(0);
            setSpeedY(0);
        }
        else if(getSprite().getRotation() <= -295 && getSprite().getRotation() > -335){
            setSpeedX(0);
            setSpeedY(0);
        }
        else if(getSprite().getRotation() == -360){
            getSprite().setRotation(0);
        }
        else if(getSprite().getRotation() <= -335 && getSprite().getRotation() > -25){
            setSpeedX(0);
            setSpeedY(0);
        }
    }

    //Metod för att bromsa spelarens bil
    public void brake(){
        if(getSprite().getRotation() >= 0 && getSprite().getRotation() < 25){
            setSpeedX(-1);
            setSpeedY(0);
        }
        else if(getSprite().getRotation() >= 25 && getSprite().getRotation() < 65){
            setSpeedX(-1);
            setSpeedY(-1);
        }
        else if(getSprite().getRotation() >= 65 && getSprite().getRotation() < 115){
            setSpeedX(0);
            setSpeedY(-1);
        }
        else if(getSprite().getRotation() >= 115 && getSprite().getRotation() < 155){
            setSpeedX(1);
            setSpeedY(-1);
        }
        else if(getSprite().getRotation() >= 155 && getSprite().getRotation() < 205){
            setSpeedX(1);
            setSpeedY(0);
        }
        else if(getSprite().getRotation() >= 205 && getSprite().getRotation() < 245){
            setSpeedX(1);
            setSpeedY(1);
        }
        else if(getSprite().getRotation() >= 245 && getSprite().getRotation() < 295){
            setSpeedX(0);
            setSpeedY(1);
        }
        else if(getSprite().getRotation() >= 295 && getSprite().getRotation() < 335){
            setSpeedX(-1);
            setSpeedY(1);
        }
        else if(getSprite().getRotation() == 360){
            getSprite().setRotation(0);
        }
        else if(getSprite().getRotation() >= 335 && getSprite().getRotation() < 25){
            setSpeedX(-1);
            setSpeedY(0);
        }
        if(getSprite().getRotation() <= 0 && getSprite().getRotation() > -25){
            setSpeedX(-1);
            setSpeedY(0);
        }
        else if(getSprite().getRotation() <= -25 && getSprite().getRotation() > -65){
            setSpeedX(-1);
            setSpeedY(1);
        }
        else if(getSprite().getRotation() <= -65 && getSprite().getRotation() > -115){
            setSpeedX(0);
            setSpeedY(1);
        }
        else if(getSprite().getRotation() <= -115 && getSprite().getRotation() > -155){
            setSpeedX(1);
            setSpeedY(1);
        }
        else if(getSprite().getRotation() <= -155 && getSprite().getRotation() > -205){
            setSpeedX(1);
            setSpeedY(0);
        }
        else if(getSprite().getRotation() <= -205 && getSprite().getRotation() > -245){
            setSpeedX(1);
            setSpeedY(-1);
        }
        else if(getSprite().getRotation() <= -245 && getSprite().getRotation() > -295){
            setSpeedX(0);
            setSpeedY(-1);
        }
        else if(getSprite().getRotation() <= -295 && getSprite().getRotation() > -335){
            setSpeedX(-1);
            setSpeedY(-1);
        }
        else if(getSprite().getRotation() == -360){
            getSprite().setRotation(0);
        }
        else if(getSprite().getRotation() <= -335 && getSprite().getRotation() > -25){
            setSpeedX(-1);
            setSpeedY(0);
        }
    }

    //Metod för att förändra rotationen och spelarens position på Y-axlen.
    public void turnLeft(){
        getSprite().rotate(3);

        if ((getSprite().getRotation() >= 0 && getSprite().getRotation() < 90)){
            getSprite().translateY(0.1f);
        }
        else if(getSprite().getRotation() >= 90 && getSprite().getRotation() < 180){
            getSprite().translateX(-0.1f);
        }
        else if(getSprite().getRotation() >= 180 && getSprite().getRotation() < 270){
            getSprite().translateY(-0.1f);
        }
        else if(getSprite().getRotation() >= 270 && getSprite().getRotation() < 360){
            getSprite().translateX(0.1f);
        }
        else if(getSprite().getRotation() >= 360){
            getSprite().setRotation(0);
        }
    }

    //Metod för att förändra rotationen och spelarens position på Y-axlen när man är utanför banan.
    public void turnLeftOutOfBounds(){
        getSprite().rotate(0.01f);

        if ((getSprite().getRotation() >= 0 && getSprite().getRotation() < 90)){
            getSprite().translateY(0.1f);
        }
        else if(getSprite().getRotation() >= 90 && getSprite().getRotation() < 180){
            getSprite().translateX(-0.1f);
        }
        else if(getSprite().getRotation() >= 180 && getSprite().getRotation() < 270){
            getSprite().translateY(-0.1f);
        }
        else if(getSprite().getRotation() >= 270 && getSprite().getRotation() < 360){
            getSprite().translateX(0.1f);
        }
        else if(getSprite().getRotation() >= 360){
            getSprite().setRotation(0);
        }
    }

    //Metod för att förändra rotationen och spelarens plats på Y-axlen.
    public void turnRight(){
        getSprite().rotate(-3);

        if(getSprite().getRotation() <= -1 && getSprite().getRotation() > -88){
            getSprite().translateY(-0.1f);
        }
        else if (getSprite().getRotation() <= -88 && getSprite().getRotation() > -158){
            getSprite().translateX(0.1f);
        }
        else if (getSprite().getRotation() <= -158 && getSprite().getRotation() > -268){
            getSprite().translateY(0.1f);
        }
        else if (getSprite().getRotation() <= -268 && getSprite().getRotation() > -358){
            getSprite().translateX(-0.1f);
        }
        else if(getSprite().getRotation() <= -358){
            getSprite().setRotation(0);

        }
    }

    //Metod för att förändra rotationen och spelarens position på Y-axlen utanför banan.
    public void turnRightOutOfBounds(){
        getSprite().rotate(-0.01f);

        if(getSprite().getRotation() <= -1 && getSprite().getRotation() > -88){
            getSprite().translateY(-0.1f);
        }
        else if (getSprite().getRotation() <= -88 && getSprite().getRotation() > -158){
            getSprite().translateX(0.1f);
        }
        else if (getSprite().getRotation() <= -158 && getSprite().getRotation() > -268){
            getSprite().translateY(0.1f);
        }
        else if (getSprite().getRotation() <= -268 && getSprite().getRotation() > -358){
            getSprite().translateX(-0.1f);
        }
        else if(getSprite().getRotation() <= -358){
            getSprite().setRotation(0);

        }
    }

    //Metod som används för att spelaren inte ska kunna köra utanför skärmen.
    public void bounceOfEdge(){
        if(getX() > 1336){
            setSpeedX(-3);
        }
        else if(getX() < 1){
            setSpeedX(3);
        }
        else if(getY() > 588){
            setSpeedY(-3);
        }
        else if(getY() < 1){
            setSpeedY(3);
        }
    }

    //Metod som gör så att så fort man är utanför banan så kör man saktare.
    public void setSpeedOutOfBounds(){
        if(getSpeedX() > 0){
            setSpeedX(0.1f);
        }
        if(getSpeedX() < 0){
            setSpeedX(-0.1f);
        }
        if(getSpeedY() > 0){
            setSpeedY(0.1f);
        }
        if(getSpeedY() < 0){
            setSpeedY(-0.1f);
        }

    }

}
