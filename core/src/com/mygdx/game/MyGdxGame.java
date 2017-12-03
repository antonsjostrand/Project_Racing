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
	private Racer[] racerArray = new Racer[1];
	private Track[] levelOne = new Track[4];
	private Track[] levelTwo = new Track[10];
	private Track[] levelThree = new Track[12];

	private enum GameState{LEVELONE, LEVELTWO, LEVELTHREE, MAINMENU, LEVELCHANGE, FINISH};
	private GameState gameState = GameState.LEVELONE;

	private SpriteBatch batch;
	private Texture img;

	private Player player;
	private Opponent opponentOne;
	private OpponentTwo opponentTwo;
	private OpponentThree opponentThree;

	private BitmapFont font;
	private String winner = "Winner: " , opponentText = "Opponent", playerText = "Player";

	private Rectangle partOne, partTwo, partThree, partFour;
	private Rectangle levelTwoPartOne, levelTwoPartTwo, levelTwoPartThree, levelTwoPartFour,
					levelTwoPartFive, levelTwoPartSix, levelTwoPartSeven, levelTwoPartEight;
	private Rectangle levelThreePartOne, levelThreePartTwo, levelThreePartThree, levelThreePartFour,
					levelThreePartFive, levelThreePartSix, levelThreePartSeven, levelThreePartEight,
					levelThreePartNine, levelThreePartTen, levelThreePartEleven, levelThreePartTwelve;



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
		createLevelThree();
		createOpponents();

	}
	//Metod för att skapa motståndare
	public void createOpponents(){
		opponentOne = new Opponent("Opponent.png",605,60,35,17.5f);
		racerList.add(opponentOne);

		opponentTwo = new OpponentTwo("Opponent.png", 605,120,35,17.5f);
		racerList.add(opponentTwo);

		opponentThree = new OpponentThree ("Opponent.png",605,90,35,17.5f);
		racerList.add(opponentThree);
	}

	//Metod för att skapa spelaren
	public void createPlayer(){
		player = new Player("Player.png", 605,150,35,17.5f);
		//racerList.add(player);
		racerArray[0] = player;
	}
	//Metod för att skapa HUD:en
	public void createHUD(){
		Track HUD = new Track("Opponent.png",0,618,1366,150);
		levelTwo[9] = HUD;
	}
	//Skapar level ett och rektanglar som representerar en del av banan.
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
	//Skapar level två och de rektanglar som representerar en del av banan.
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

	public void createLevelThree(){
		Track levelThreeTrack = new Track("LevelThreeTemplate.png",0,0,1366,618);
		trackList.add(levelThreeTrack);

		levelThreePartOne = levelThreeTrack.trackPartArea(45,45,1277,140);
		levelThreePartTwo = levelThreeTrack.trackPartArea(1221,185,100,390);
		levelThreePartThree = levelThreeTrack.trackPartArea(45,493,1178,80);
		levelThreePartFour = levelThreeTrack.trackPartArea(45,403,60,92);
		levelThreePartFive = levelThreeTrack.trackPartArea(45,354,862,50);
		levelThreePartSix = levelThreeTrack.trackPartArea(906,354,90,121);
		levelThreePartSeven = levelThreeTrack.trackPartArea(996,385,118,90);
		levelThreePartEight = levelThreeTrack.trackPartArea(1111,204,90,271);
		levelThreePartNine = levelThreeTrack.trackPartArea(996,204,118,90);
		levelThreePartTen = levelThreeTrack.trackPartArea(906,204,90,121);
		levelThreePartEleven = levelThreeTrack.trackPartArea(45,274,862,50);
		levelThreePartTwelve = levelThreeTrack.trackPartArea(45,185,60,92);

		Track roadOne = new Track("Player.png", 45,45,1277,140);
		levelThree[0] = roadOne;

		Track roadTwo = new Track("Player.png",1221,185,100,390);
		levelThree[1] = roadTwo;

		Track roadThree = new Track("Player.png", 45,493,1178,80);
		levelThree[2] = roadThree;

		Track roadFour = new Track("Player.png", 45,403,60,92);
		levelThree[3] = roadFour;

		Track roadFive = new Track("Player.png", 45,354,862,50);
		levelThree[4] = roadFive;

		Track roadSix = new Track("Player.png", 906,354,90,121);
		levelThree[5] = roadSix;

		Track roadSeven = new Track("Player.png", 996,385,118,90);
		levelThree[6] = roadSeven;

		Track roadEight = new Track("Player.png", 1111,204,90,271);
		levelThree[7] = roadEight;

		Track roadNine = new Track("Player.png", 996,204, 118,90);
		levelThree[8] = roadNine;

		Track roadTen = new Track("Player.png", 906,204,90,121);
		levelThree[9] = roadTen;

		Track roadEleven = new Track("Player.png", 45,274,862,50);
		levelThree[10] = roadEleven;

		Track roadTwelve = new Track("Player.png", 45,185,60,92);
		levelThree[11] = roadTwelve;
	}

	//Metod som används för att rendera level ett.
	public GameState renderLevelOne(){
		//Uppdaterar positionen av samtliga Racer objekt
		racerList.get(0).updatePostion();
		racerArray[0].updatePostion();

			//Kollar vilka knappar som är intryckta
			checkKeys();

			//Kollar ifall spelaren kolliderar med en motståndare
			if (player.collidesWithRacer(opponentOne.getCollisionAreaRacer())) {
				//player.setX(opponentOne.getX()-50);
				//player.setY(opponentOne.getY());

				player.setSpeedX(-(player.getSpeedX() + 1));
				player.setSpeedY(-(player.getSpeedY() + 1));
			}


			//Kollar ifall spelaren är på banan eller utanför, agerar därefter.
			if (!player.insideTrack(partOne) && !player.insideTrack(partTwo) &&
					!player.insideTrack(partThree) && !player.insideTrack(partFour)) {

				if (player.getX() > 1336 || player.getX() < 30 || player.getY() > 588 || player.getY() < 30) {
					player.bounceOfEdge();
				} else {
					checkKeysOutOfBounds();
				}
				player.setSpeedOutOfBounds();

			}



		//Ändrar riktningen och åt vilket håll motståndaren kör
		opponentOne.changeDirectionLevelOne();
		opponentOne.followTrackLevelOne();

		//Ökar variablerna när spelaren/motståndaren kört ett varv.
		int test = opponentOne.checkLaps(opponentOne);
		int testTwo = player.checkLaps(player);

		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		//Ritar ut level ett.
		trackList.get(0).draw(batch);

		//Ritar ut HUD:en (RÖDA FÄLTET)
		levelTwo[9].draw(batch);

		//Kontrollerar så att arean av delarna stämmer.
		//levelOne[0].draw(batch);
		//levelOne[1].draw(batch);
		//levelOne[2].draw(batch);
		//levelOne[3].draw(batch);

		//Ritar ut samtliga racer objekt.
		racerList.get(0).draw(batch);
		racerArray[0].draw(batch);

		//Ritar ut vinnarens namn.
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

		//När man kör klart så återställer denna IF-sats spelarens och motståndare etts position.
		if (test == 4 || testTwo == 4 ){
			gameState = GameState.LEVELTWO;

			player.setX(605);
			player.setY(155);
			player.getSprite().setRotation(0);

			opponentOne.setX(605);
			opponentOne.setY(60);
			opponentOne.getSprite().setRotation(0);

			test = 0;
			testTwo = 0;

		}
		return gameState;
	}

	//Metod som ritar ut level två.
	public GameState renderLevelTwo(){
		//Uppdaterar positionen av samtliga Racer objekt
		racerList.get(0).updatePostion();
		racerList.get(1).updatePostion();
		racerArray[0].updatePostion();

			//Kollar vilka knappar som är intryckta
			checkKeys();

			//Kollar ifall spelaren kolliderar med en motståndare
			if (player.collidesWithRacer(opponentOne.getCollisionAreaRacer())){
				player.setSpeedX(0);
				player.setSpeedY(0);
			}
			if(player.collidesWithRacer(opponentTwo.getCollisionAreaRacer())){
				player.setSpeedY(0);
				player.setSpeedX(0);
			}

			if(opponentTwo.collidesWithRacer(opponentOne.getCollisionAreaRacer())){
				opponentTwo.setSpeedX(2.5f);
				opponentTwo.setSpeedY(2.5f);
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
						checkKeysOutOfBounds();
					}
						player.setSpeedOutOfBounds();
			}


		//Kallar på metoderna som flyttar motståndare ett
		opponentOne.followTrackLevelTwo();
		opponentOne.changeDirectionLevelTwo();
		opponentTwo.followTrackLevelTwo();
		opponentTwo.changeDirectionLevelTwo();

		//Ökar variablerna när man kört ett varv.
		int test = opponentOne.checkLaps(opponentOne);
		int testTwo = player.checkLaps(player);

        Gdx.gl.glClearColor(0, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

		//Ritar ut level två
		trackList.get(1).draw(batch);

		//Ritar ut HUD:en
		levelTwo[9].draw(batch);

		//Kontroll av arean så den stämmer.
		//levelTwo[0].draw(batch);
		//levelTwo[1].draw(batch);
		//levelTwo[2].draw(batch);
		//levelTwo[3].draw(batch);
		//levelTwo[4].draw(batch);
		//levelTwo[5].draw(batch);
		//levelTwo[6].draw(batch);
		//levelTwo[7].draw(batch);


		//Ritar ut samtliga racing objekt
		racerList.get(0).draw(batch);
		racerList.get(1).draw(batch);
		racerArray[0].draw(batch);

		//Ritar ut vinnarens namn
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
		//När man kör klart så återställer denna IF-sats spelarens och motståndare etts position.
		if (test == 8 || testTwo == 8 ){
			gameState = GameState.LEVELTHREE;

			player.setX(605);
			player.setY(155);
			player.getSprite().setRotation(0);

			opponentOne.setX(605);
			opponentOne.setY(60);
			opponentOne.getSprite().setRotation(0);

			opponentTwo.setX(605);
			opponentTwo.setY(120);
			opponentTwo.getSprite().setRotation(0);

			test = 0;
			testTwo = 0;

		}
		return gameState;
    }


	//Metod som kontrollerar om spelaren trycker på några tangenter.
	public void checkKeys(){
		if(Gdx.input.isKeyPressed(Input.Keys.UP)){
			player.accelerate();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			player.brake();
		}
		else if(!Gdx.input.isKeyPressed(Input.Keys.UP)){
			player.noAccelerate();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			player.turnRight();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			player.turnLeft();
		}


	}

	//Metod som kontrollerar om spelaren trycker på några tangenterna när han är utanför banan.
	public void checkKeysOutOfBounds(){
		if(Gdx.input.isKeyPressed(Input.Keys.UP)){
			player.accelerateOutOfBounds();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			player.brake();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			player.turnRightOutOfBounds();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			player.turnLeftOutOfBounds();
		}

	}

	public GameState renderLevelThree(){
		//Uppdaterar positionen av samtliga opponet objekt
		for(Racer racer : racerList) {
			racer.updatePostion();
		}
			//Uppdaterar spelarens position
			racerArray[0].updatePostion();

			//Kollar vilka knappar som är intryckta
			checkKeys();

			//Kollar ifall spelaren kolliderar med en motståndare
			if (player.collidesWithRacer(opponentOne.getCollisionAreaRacer())){
				//player.setX(opponentOne.getX()-50);
				//player.setY(opponentOne.getY());

				player.setSpeedX(-(player.getSpeedX()+1));
				player.setSpeedY(-(player.getSpeedY()+1));
			}
		if(player.collidesWithRacer(opponentTwo.getCollisionAreaRacer())){
			player.setSpeedY(0);
			player.setSpeedX(0);
		}

		if(opponentTwo.collidesWithRacer(opponentOne.getCollisionAreaRacer())){
			opponentTwo.setSpeedX(2.5f);
			opponentTwo.setSpeedY(2.5f);
		}

		//Kollar ifall spelaren är på banan eller utanför, agerar därefter.
			if(!player.insideTrack(levelThreePartOne) && !player.insideTrack(levelThreePartTwo) &&
					!player.insideTrack(levelThreePartThree) && !player.insideTrack(levelThreePartFour) &&
					!player.insideTrack(levelThreePartFive) && !player.insideTrack(levelThreePartSix) &&
					!player.insideTrack(levelThreePartSeven) && !player.insideTrack(levelThreePartEight) &&
					!player.insideTrack(levelThreePartNine) && !player.insideTrack(levelThreePartTen) &&
					!player.insideTrack(levelThreePartEleven) && !player.insideTrack(levelThreePartTwelve)){

				if(player.getX() > 1336 || player.getX() < 30 || player.getY() > 588 || player.getY() < 30){
					player.bounceOfEdge();
				}
				else{
					checkKeysOutOfBounds();
				}
				player.setSpeedOutOfBounds();

			}

		//Ändrar riktningen och åt vilket håll motståndaren kör
		opponentOne.followTrackLevelThree();
		opponentOne.changeDirectionLevelThree();
		opponentTwo.followTrackLevelThree();
		opponentTwo.changeDirectionLevelThree();

		//Ökar variablerna när spelaren/motståndaren kört ett varv.
		int test = opponentOne.checkLaps(opponentOne);
		int testTwo = player.checkLaps(player);

		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		//Ritar ut level ett.
		trackList.get(2).draw(batch);

		//Ritar ut HUD:en (RÖDA FÄLTET)
		levelTwo[9].draw(batch);

		//Kontrollerar så att arean av delarna stämmer.
	//	levelThree[0].draw(batch);
	//	levelThree[1].draw(batch);
	//	levelThree[2].draw(batch);
	//	levelThree[3].draw(batch);
	//	levelThree[4].draw(batch);
	//	levelThree[5].draw(batch);
	//	levelThree[6].draw(batch);
	//	levelThree[7].draw(batch);
	//	levelThree[8].draw(batch);
	//	levelThree[9].draw(batch);
	//	levelThree[10].draw(batch);
	//	levelThree[11].draw(batch);

		//Ritar ut samtliga racer objekt.
		for(Racer player : racerList){
			player.draw(batch);
		}

		//Ritar ut spelaren
		racerArray[0].draw(batch);

		//Ritar ut vinnarens namn.
		font.draw(batch, winner,700,600);
		if (testTwo == 12){
			font.draw(batch, playerText, 752,600);
		}
		if(test == 12){
			font.draw(batch, opponentText,752,600);
		}

		//printar ut antal varv körda
		font.draw(batch, String.valueOf(testTwo),100,600);
		font.draw(batch, String.valueOf(test), 100,700);
		batch.end();

		//När man kör klart så återställer denna IF-sats spelarens och motståndare etts position.
		if (test == 12 || testTwo == 12 ){
			gameState = GameState.FINISH;

			player.setX(605);
			player.setY(155);
			player.getSprite().setRotation(0);

			opponentOne.setX(605);
			opponentOne.setY(100);
			opponentOne.getSprite().setRotation(0);



			test = 0;
			testTwo = 0;

		}
		return gameState;
	}

	@Override
	public void render () {

		if(gameState == GameState.LEVELONE){
			gameState = renderLevelOne();
		}
		else if(gameState == GameState.LEVELTWO){
            gameState = renderLevelTwo();
		}
		else if(gameState == GameState.LEVELTHREE){
			renderLevelThree();
		}

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}
}
