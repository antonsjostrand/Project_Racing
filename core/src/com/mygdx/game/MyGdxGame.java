package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class MyGdxGame extends ApplicationAdapter {
	private ArrayList<Racer> racerList = new ArrayList<>();
	private Track[] trackList = new Track[5];

	private enum GameState{LEVELONE, LEVELTWO, LEVELTHREE, MAINMENU};
	private GameState gameState = GameState.LEVELONE;

	private SpriteBatch batch;
	private Texture img;

	private Player player;
	private Opponent opponent;

	private BitmapFont font;
	private String winner = "Winner: " , opponentText = "Opponent", playerText = "Player";

	private int testTwo = 0;

	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.BLACK);

		createPlayer();
		createTrack();
		createOpponent();

	}
	//Metod för att skapa motståndare 1
	public void createOpponent(){
		opponent = new Opponent("Opponent.png",605,100,50,25);
		racerList.add(opponent);
	}
	//Metod för att skapa spelaren
	public void createPlayer(){
		player = new Player("Player.png", 605,155,50,25);
		racerList.add(player);
	}
	//Metod för att skapa banor.
	public void createTrack(){
		Track levelOne = new Track("TrackTest2.png",0,0,1360,540);
		trackList[0] = levelOne;

		Track roadOne = new Track("Track.png", 45,45,1270,150);
		trackList[1] = roadOne;

		Track roadTwo = new Track("Track.png", 1165,195,150,132);
		trackList[2] = roadTwo;

		Track roadThree = new Track("Track.png", 45,327,1270,150);
		trackList[3] = roadThree;

		Track roadFour = new Track("Track.png", 45,195,150,132);
		trackList[4] = roadFour;

	//	Track newTrack = new Track("Track.png",50,50,1200,100);
	//	Track newTrack2 = new Track("Track.png", 1200,50,100,600);
	//	trackList.add(newTrack2);
	//	trackList.add(newTrack);
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
			if(!player.insideTrack(trackList[1].trackArea()) && !player.insideTrack(trackList[2].trackArea()) &&
				!player.insideTrack(trackList[3].trackArea()) && !player.insideTrack(trackList[4].trackArea())){
				checkKeysOutOfBounds();
			}

		}

		//Förändrar riktningen och åt vilket håll motståndaren kör
		opponent.changeDirection();
		opponent.followTrack();

		int test = opponent.checkLaps(opponent);
		int testTwo = player.checkLaps(player);

		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		//Ritar ut level ett.
		trackList[1].draw(batch);
		trackList[2].draw(batch);
		trackList[3].draw(batch);
		trackList[4].draw(batch);

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
		}
		return gameState;
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
			renderLevelOne();
		}
		else if(gameState == GameState.LEVELTWO){

		}

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}
}
