package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class MyGdxGame extends ApplicationAdapter {
	ArrayList<Racer> racerList = new ArrayList<>();
	ArrayList<Track> trackList = new ArrayList<>();
	SpriteBatch batch;
	Texture img;
	Player player;

	@Override
	public void create () {
		batch = new SpriteBatch();
		createPlayer();
		createTrack();

	}

	public void createPlayer(){
		player = new Player("Player.png", 500,300,50,25);
		racerList.add(player);
	}

	public void createTrack(){
		Track newTrack = new Track("Track.png",50,50,1200,100);
		Track newTrack2 = new Track("Track.png", 1200,50,100,600);
		trackList.add(newTrack2);
		trackList.add(newTrack);
	}

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

			for(Racer racer : racerList){
				racer.updatePostion();
			}

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

			for(Track track : trackList){
				track.draw(batch);
			}

			for(Racer player : racerList){
				player.draw(batch);
			}

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}
}
