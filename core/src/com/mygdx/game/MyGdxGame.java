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
	private ArrayList<Track> trackList = new ArrayList<>();
	private SpriteBatch batch;
	private Texture img;
	private Player player;
	private Opponent opponent;
	private BitmapFont font;

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
	//Metod för att skapa motståndare
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
		Track newTrack = new Track("TrackTest2.png",0,0,1366,540);
		trackList.add(newTrack);

	//	Track newTrack = new Track("Track.png",50,50,1200,100);
	//	Track newTrack2 = new Track("Track.png", 1200,50,100,600);
	//	trackList.add(newTrack2);
	//	trackList.add(newTrack);
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
		else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			player.brake();
		}

	}

	@Override
	public void render () {
		checkKeys();

			//Uppdaterar positionen av samtliga Racer objekt
			for(Racer racer : racerList){
				racer.updatePostion();
			}


			opponent.followTrack();
			opponent.changeDirection();
			int test = opponent.checkLaps(opponent);

			int testTwo = player.checkLaps(player);

		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

			for(Track track : trackList){
				track.draw(batch);
			}

			for(Racer player : racerList){
				player.draw(batch);
			}

			font.draw(batch, String.valueOf(testTwo),100,600);
			font.draw(batch, String.valueOf(test), 100,700);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}
}
