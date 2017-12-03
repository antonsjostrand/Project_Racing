package com.mygdx.game;

import com.badlogic.gdx.ai.steer.Steerable;
import com.badlogic.gdx.ai.steer.SteeringAcceleration;
import com.badlogic.gdx.ai.steer.behaviors.Seek;
import com.badlogic.gdx.math.Vector;

public class Opponent extends Racer {

    public Opponent(String image, float x, float y, float sizeX, float sizeY){
        super(image, x, y, sizeX, sizeY);

        getSprite().setOriginCenter();
    }

    //Metod för att flytta motståndaren enligt dess koordinater
    public void followTrackLevelOne(){
        if(getX() == 605 && getY() == 60){
            setSpeedX(3);
            setSpeedY(0);
        }
        else if((getX() >= 1290 && getX() <= 1310) && (getY() >= 55 && getY() < 70)){
            setSpeedX(0);
            setSpeedY(3);
        }
        else if(getX() >= 1290 && getX() <=1310 && (getY() >= 545 && getY() < 550)){
            setSpeedX(-3);
            setSpeedY(0);
        }
        else if(getX() >= 125 && getX() < 135 && getY() >= 545 && getY() < 550){
            setSpeedY(-3);
            setSpeedX(0);
        }
        else if(getX() >= 125 && getX() <135 && getY() >= 55 && getY() < 70){
            setSpeedX(3);
            setSpeedY(0);
        }
    }
    //Metod för att ändra riktningen på motståndare bild.
    public void changeDirectionLevelOne(){
        if(getX() == 605 && getY() == 60){
            getSprite().setRotation(0);
        }
        else if((getX() >= 1290 && getX() <= 1310) && (getY() >= 55 && getY() < 70)){
            getSprite().setRotation(90);
        }
        else if(getX() >= 1290 && getX() <=1310 && (getY() >= 545 && getY() < 550)){
            getSprite().setRotation(180);
        }
        else if(getX() >= 125 && getX() < 135 && getY() >= 545 && getY() < 550){
            getSprite().setRotation(270);
        }
        else if(getX() >= 125 && getX() <135 && getY() >= 55 && getY() < 70){
            getSprite().setRotation(360);
        }
    }

    //Metod som som flyttar motståndaren på level två
    public void followTrackLevelTwo() {
        if (getX() >= 602 && getX() <= 606 && getY() >= 55 && getY() < 65) {
            setSpeedX(3);
            setSpeedY(0);
        }
        else if ((getX() >= 1290 && getX() <= 1310) && (getY() >= 55 && getY() < 70)) {
            setSpeedX(0);
            setSpeedY(3);
        }
        else if (getX() >= 1290 && getX() <= 1310 && (getY() >= 530 && getY() < 545)) {
            setSpeedX(-3);
            setSpeedY(0);
        }
        else if (getX() >= 880 && getX() < 890 && getY() >= 530 && getY() < 545) {
            setSpeedY(-3);
            setSpeedX(0);
        }
        else if (getX() >= 880 && getX() < 890 && getY() >= 230 && getY() < 245) {
            setSpeedX(-3);
            setSpeedY(0);
        }
        else if (getX() >= 540 && getX() < 550 && getY() >= 230 && getY() < 245) {
            setSpeedX(0);
            setSpeedY(3);
        }
        else if (getX() >= 540 && getX() < 550 && getY() >= 530 && getY() < 545) {
            setSpeedX(-3);
            setSpeedY(0);
        }
        else if (getX() >= 70 && getX() < 90 && getY() >= 530 && getY() < 545) {
            setSpeedX(0);
            setSpeedY(-3);
        }
        else if (getX() >= 70 && getX() < 90 && getY() >= 55 && getY() < 70) {
            setSpeedX(3);
            setSpeedY(0);
        }
    }

    //Metod som förändrar en Sprites rotation/riktning på level två.
    public void changeDirectionLevelTwo(){
        if (getX() == 605 && getY() == 60) {
            getSprite().setRotation(0);
        }
        else if ((getX() >= 1290 && getX() <= 1310) && (getY() >= 55 && getY() < 70)) {
            getSprite().setRotation(90);
        }
        else if (getX() >= 1290 && getX() <= 1310 && (getY() >= 530 && getY() < 545)) {
            getSprite().setRotation(180);
        }
        else if (getX() >= 880 && getX() < 890 && getY() >= 530 && getY() < 545) {
            getSprite().setRotation(270);
        }
        else if (getX() >= 880 && getX() < 890 && getY() >= 230 && getY() < 245) {
            getSprite().setRotation(180);
        }
        else if (getX() >= 540 && getX() < 550 && getY() >= 230 && getY() < 245) {
            getSprite().setRotation(90);
        }
        else if (getX() >= 540 && getX() < 550 && getY() >= 530 && getY() < 545) {
            getSprite().setRotation(180);
        }
        else if (getX() >= 70 && getX() < 90 && getY() >= 530 && getY() < 545) {
            getSprite().setRotation(270);
        }
        else if (getX() >= 70 && getX() < 90 && getY() >= 60 && getY() < 75) {
            getSprite().setRotation(360);
        }
    }

    public void followTrackLevelThree(){
        if (getX() >= 602 && getX() <= 606 && getY() >= 55 && getY() < 65) {
            setSpeedX(3);
            setSpeedY(0);
        }
        else if ((getX() >= 1290 && getX() <= 1310) && (getY() >= 55 && getY() < 70)) {
            setSpeedX(0);
            setSpeedY(3);
        }
        else if (getX() >= 1290 && getX() <= 1310 && (getY() >= 530 && getY() < 545)) {
            setSpeedX(-3);
            setSpeedY(0);
        }
        else if (getX() >= 60 && getX() < 70 && getY() >= 530 && getY() < 545) {
            setSpeedY(-3);
            setSpeedX(0);
        }
        else if (getX() >= 60 && getX() < 70 && getY() >= 374 && getY() < 382) {
            setSpeedX(3);
            setSpeedY(0);
        }
        else if (getX() >= 925 && getX() < 935 && getY() >= 374 && getY() < 382) {
            setSpeedX(0);
            setSpeedY(3);
        }
        else if (getX() >= 925 && getX() < 935 && getY() >= 447 && getY() < 455) {
            setSpeedX(3);
            setSpeedY(0);
        }
        else if (getX() >= 1175 && getX() < 1185 && getY() >= 447 && getY() < 455) {
            setSpeedX(0);
            setSpeedY(-3);
        }
        else if (getX() >= 1175 && getX() < 1185 && getY() >= 221 && getY() < 228) {
            setSpeedX(-3);
            setSpeedY(0);
        }
        else if (getX() >= 925 && getX() < 935 && getY() >= 221 && getY() < 228) {
            setSpeedX(0);
            setSpeedY(3);
        }
        else if (getX() >= 925 && getX() < 935 && getY() >= 298 && getY() < 306) {
            setSpeedX(-3);
            setSpeedY(0);
        }
        else if (getX() >= 60 && getX() < 68 && getY() >= 298 && getY() < 306) {
            setSpeedX(0);
            setSpeedY(-3);
        }
        else if (getX() >= 60 && getX() < 68 && getY() >= 64 && getY() < 70) {
            setSpeedX(3);
            setSpeedY(0);
        }
    }

    public void changeDirectionLevelThree(){
        if (getX() >= 602 && getX() <= 606 && getY() >= 55 && getY() < 65) {
            getSprite().setRotation(0);
        }
        else if ((getX() >= 1290 && getX() <= 1310) && (getY() >= 55 && getY() < 70)) {
            getSprite().setRotation(90);
        }
        else if (getX() >= 1290 && getX() <= 1310 && (getY() >= 530 && getY() < 545)) {
            getSprite().setRotation(180);
        }
        else if (getX() >= 60 && getX() < 70 && getY() >= 530 && getY() < 545) {
            getSprite().setRotation(270);
        }
        else if (getX() >= 60 && getX() < 70 && getY() >= 374 && getY() < 382) {
            getSprite().setRotation(360);
        }
        else if (getX() >= 925 && getX() < 935 && getY() >= 374 && getY() < 382) {
            getSprite().setRotation(450);
        }
        else if (getX() >= 925 && getX() < 935 && getY() >= 447 && getY() < 455) {
            getSprite().setRotation(360);
        }
        else if (getX() >= 1175 && getX() < 1185 && getY() >= 447 && getY() < 455) {
            getSprite().setRotation(270);
        }
        else if (getX() >= 1175 && getX() < 1185 && getY() >= 221 && getY() < 228) {
            getSprite().setRotation(180);
        }
        else if (getX() >= 925 && getX() < 935 && getY() >= 221 && getY() < 228) {
            getSprite().setRotation(90);
        }
        else if (getX() >= 925 && getX() < 935 && getY() >= 298 && getY() < 306) {
            getSprite().setRotation(180);
        }
        else if (getX() >= 60 && getX() < 68 && getY() >= 298 && getY() < 306) {
            getSprite().setRotation(270);
        }
        else if (getX() >= 60 && getX() < 68 && getY() >= 64 && getY() < 70) {
            getSprite().setRotation(360);
        }
    }
}


