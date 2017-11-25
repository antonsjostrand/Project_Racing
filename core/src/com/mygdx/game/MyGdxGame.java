package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import java.util.ArrayList;

public class MyGdxGame extends ApplicationAdapter {
	private ArrayList<Racer> racerList = new ArrayList<>();
	private ArrayList<Track> trackList = new ArrayList<>();
	private Track[] levelOne = new Track[4];
	private Track[] levelTwo = new Track[10];

	private enum GameState{LEVELONE, LEVELTWO, LEVELTHREE, MAINMENU, LEVELCHANGE};
	private GameState gameState = GameState.LEVELONE;

	private SpriteBatch batch;
	private Texture img;

	private Player player;
	private Opponent opponent;

	private BitmapFont font;
	private String winner = "Winner: " , opponentText = "Opponent", playerText = "Player";

	private Rectangle partOne, partTwo, partThree, partFour;
	private Rectangle levelTwoPartOne, levelTwoPartTwo, levelTwoPartThree, levelTwoPartFour,
					levelTwoPartFive, levelTwoPartSix, levelTwoPartSeven, levelTwoPartEight;



	private int testTwo = 0, test = 0;

	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.BLACK);

		createHUD();

		createPlayer();
		createLevelOne();
		createLevelTwo();
		createOpponent();

	}
	//Metod för att skapa motståndare 1
	public void createOpponent(){
		opponent = new Opponent("Opponent.png",605,100,50,25);
		racerList.add(opponent);
	}
	//Metod för att skapa spelaren
	public void createPlayer(){
		player = new Player("Player.png", 605,155,35,17.5f);
		racerList.add(player);
	}
	//Metod för att skapa HUD:en
	public void createHUD(){
		Track HUD = new Track("Opponent.png",0,618,1366,150);
		levelTwo[9] = HUD;
	}
	//Metod för att skapa banor.
	public void createLevelOne(){
		Track levelOneTrack = new Track("LevelOneTemplate.png",0,0,1366,618);
		trackList.add(levelOneTrack);

		partOne = levelOneTrack.trackPartArea(45,45,1277,140);
		partTwo = levelOneTrack.trackPartArea(1181,185,140,251);
		partThree = levelOneTrack.trackPartArea(45,434,1277,140);
		partFour = levelOneTrack.trackPartArea(45,185,140,251);

		Track roadOne = new Track("Player.png", 45,45,1277,140);
		levelOne[0] = roadOne;

		Track roadTwo = new Track("Player.png", 1181,185,140,251);
		levelOne[1] = roadTwo;

		Track roadThree = new Track("Player.png", 45,434,1277,140);
		levelOne[2] = roadThree;

		Track roadFour = new Track("Player.png", 45,185,140,251);
		levelOne[3] = roadFour;



	}

	public void createLevelTwo(){
		Track levelTwoTrack = new Track("LevelTwoTemplate.png",0,0,1366,618);
		trackList.add(levelTwoTrack);

		levelTwoPartOne = levelTwoTrack.trackPartArea(45,45,1277,140);
		levelTwoPartTwo = levelTwoTrack.trackPartArea(1181,185,140,251);
		levelTwoPartThree = levelTwoTrack.trackPartArea(784, 434,539,140);
		levelTwoPartFour = levelTwoTrack.trackPartArea(784,309,140,126);
		levelTwoPartFive = levelTwoTrack.trackPartArea(444,209,480,100);
		levelTwoPartSix = levelTwoTrack.trackPartArea(444,309,140,126);
		levelTwoPartSeven = levelTwoTrack.trackPartArea(45,434,539,140);
		levelTwoPartEight = levelTwoTrack.trackPartArea(45,185,140,251);

		Track roadOne = new Track("Player.png", 45,45,1277,140);
		levelTwo[0] = roadOne;

		Track roadTwo = new Track("Player.png",1181,185,140,251);
		levelTwo[1] = roadTwo;

		Track roadThree = new Track("Player.png", 784,434,539,140);
		levelTwo[2] = roadThree;

		Track roadFour = new Track("Player.png", 784,309,140,126);
		levelTwo[3] = roadFour;

		Track roadFive = new Track("Player.png", 444,209,480,100);
		levelTwo[4] = roadFive;

		Track roadSix = new Track("Player.png", 444,309,140,126);
		levelTwo[5] = roadSix;

		Track roadSeven = new Track("Player.png", 45,434,539,140);
		levelTwo[6] = roadSeven;

		Track roadEight = new Track("Player.png", 45,185,140,251);
		levelTwo[7] = roadEight;

	}

	public GameState renderLevelOne(){
		//Uppdaterar positionen av samtliga Racer objekt
		for(Racer racer : racerList){
			racer.updatePostion();

			checkKeys();

			//Kollar ifall spelaren kolliderar med en motståndare
			if (player.collidesWithRacer(opponent.getCollisionArea())){
				player.setSpeedX(0);
				player.setSpeedY(0);
			}

			//Kollar ifall spelaren är på banan eller utanför.
			if(!player.insideTrack(partOne) && !player.insideTrack(partTwo) &&
					!player.insideTrack(partThree) && !player.insideTrack(partFour)){

				if(player.getX() > 1336 || player.getX() < 30 || player.getY() > 588 || player.getY() < 30){
					player.bounceOfEdge();
				}
				else{
					checkKeysOutOfBounds();
				}


				player.setSpeedOutOfBounds();

			}

		}

		//Ändrar riktningen och åt vilket håll motståndaren kör
		opponent.changeDirection();
		opponent.followTrack();

		int test = opponent.checkLaps(opponent);
		int testTwo = player.checkLaps(player);

		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();



		//Ritar ut level ett.
		trackList.get(0).draw(batch);

		levelTwo[9].draw(batch);

		//Kontrollerar så att arean av delarna stämmer.
		//levelOne[0].draw(batch);
		//levelOne[1].draw(batch);
		//levelOne[2].draw(batch);
		//levelOne[3].draw(batch);

		//Ritar ut samtliga racer objekt.
		for(Racer player : racerList){
			player.draw(batch);
		}

		font.draw(batch, winner,700,600);
		if (testTwo == 4){
			font.draw(batch, playerText, 752,600);
		}
		if(test == 4){
			font.draw(batch, opponentText,752,600);
		}

		//printar ut antal varv körda
		font.draw(batch, String.valueOf(testTwo),100,600);
		font.draw(batch, String.valueOf(test), 100,700);
		batch.end();

		if (test == 4 || testTwo == 4 ){
			gameState = GameState.LEVELTWO;

			player.setX(605);
			player.setY(155);
			player.getSprite().setRotation(0);

			test = 0;
			testTwo = 0;

		}
		return gameState;
	}

	//Metod som ritar ut level två.
	public void renderLevelTwo(){
		//Uppdaterar positionen av samtliga Racer objekt
		for(Racer racer : racerList){
			racer.updatePostion();


			player.bounceOfEdge();
			checkKeys();

			//Kollar ifall spelaren kolliderar med en motståndare
			if (player.collidesWithRacer(opponent.getCollisionArea())){
				player.setSpeedX(0);
				player.setSpeedY(0);
			}

			//Kollar ifall spelaren är på banan eller utanför.
			if(!player.insideTrack(levelTwoPartOne) && !player.insideTrack(levelTwoPartTwo) &&
					!player.insideTrack(levelTwoPartThree) && !player.insideTrack(levelTwoPartFour) &&
					!player.insideTrack(levelTwoPartFive) && !player.insideTrack(levelTwoPartSix) &&
					!player.insideTrack(levelTwoPartSeven) && !player.insideTrack(levelTwoPartEight)){

				if(player.getX() > 1336 || player.getX() < 30 || player.getY() > 588 || player.getY() < 30) {
					player.bounceOfEdge();
				}
				else{
				player.setSpeedOutOfBounds();
				checkKeysOutOfBounds();
				}
			}
		}




        Gdx.gl.glClearColor(0, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

		//Ritar ut level två
		trackList.get(1).draw(batch);

		//Kontroll av arean så den stämmer.
		//levelTwo[0].draw(batch);
		//levelTwo[1].draw(batch);
		//levelTwo[2].draw(batch);
		//levelTwo[3].draw(batch);
		//levelTwo[4].draw(batch);
		//levelTwo[5].draw(batch);
		//levelTwo[6].draw(batch);
		//levelTwo[7].draw(batch);



		for(Racer player : racerList){
			player.draw(batch);
		}



		font.draw(batch, winner,700,600);
		if (testTwo == 4){
			font.draw(batch, playerText, 752,600);
		}
		if(test == 4){
			font.draw(batch, opponentText,752,600);
		}

		//printar ut antal varv körda
		font.draw(batch, String.valueOf(testTwo),100,600);
		font.draw(batch, String.valueOf(test), 100,700);

        batch.end();

    }



	//Metod som kontrollerar om spelaren trycker på några tangenter.
	public void checkKeys(){
		if(Gdx.input.isKeyPressed(Input.Keys.UP)){
			if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
				player.accelerate();
				player.turnLeft();
			}
			else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
				player.accelerate();
				player.turnRight();
			}
			else{
				player.accelerate();
			}
		}
		else if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
			player.brake();
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			player.turnRight();
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			player.turnLeft();
		}

	}

	public void checkKeysOutOfBounds(){
		if(Gdx.input.isKeyPressed(Input.Keys.UP)){
			if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
				player.accelerateOutOfBounds();
				player.turnLeftOutOfBounds();
			}
			else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
				player.accelerateOutOfBounds();
				player.turnRightOutOfBounds();
			}
			else{
				player.accelerateOutOfBounds();
			}
		}
		else if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
			player.brake();
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			player.turnRightOutOfBounds();
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			player.turnLeftOutOfBounds();
		}

	}

	@Override
	public void render () {

		if(gameState == GameState.LEVELONE){
			gameState = renderLevelOne();
		}
		else if(gameState == GameState.LEVELTWO){
            renderLevelTwo();
		}

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}
}
