package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.security.SecureRandom;
import java.util.ArrayList;

public class MyGdxGame extends ApplicationAdapter {
	private ArrayList<Racer> racerList = new ArrayList<>();
	private ArrayList<Track> trackList = new ArrayList<>();
	private Racer[] racerArray = new Racer[2];
	private Track[] levelOne = new Track[4];
	private Track[] levelTwo = new Track[10];
	private Track[] levelThree = new Track[12];
	private SecureRandom rand = new SecureRandom();

	private enum GameState{LEVELONE, LEVELTWO, LEVELTHREE, LEVEL_ONE_MULTIPLAYER, LEVEL_TWO_MULTIPLAYER,
							LEVEL_THREE_MULTIPLAYER, MAINMENU, LEVELCHANGE, LEVEL_CHANGE_MULTIPLAYER, FINISH};
	private GameState gameState = GameState.MAINMENU;
	private PlayState levelTransition, mainMenu, finishedState;
	private PlayState HUD, HUDMultiplayer, lapOne, lapTwo, lapThree, lapFour, lapFive, lapSix, lapSeven,
						lapOneOpponentOne, lapTwoOpponentOne, lapThreeOpponentOne, lapFourOpponentOne,
						lapFiveOpponentOne, lapSixOpponentOne, lapSevenOpponentOne,
						lapOneOpponentTwo, lapTwoOpponentTwo, lapThreeOpponentTwo, lapFourOpponentTwo,
						lapFiveOpponentTwo,lapSixOpponentTwo, lapSevenOpponentTwo,
						lapOneOpponentThree, lapTwoOpponentThree, lapThreeOpponentThree, lapFourOpponentThree,
						lapFiveOpponentThree,lapSixOpponentThree, lapSevenOpponentThree;

	private SpriteBatch batch;

	private Player player, playerTwo;
	private Opponent opponentOne;
	private OpponentTwo opponentTwo;
	private OpponentThree opponentThree;

	private Obstacle obstacle;
	private int obstacleX, obstacleY;

	private Powerup powerup;
	private int powerupX, powerupY;

	private BitmapFont font;
	private String winner = "Winner: " , opponentText = "Opponent", playerText = "Player";

	private Rectangle partOne, partTwo, partThree, partFour;
	private Rectangle levelTwoPartOne, levelTwoPartTwo, levelTwoPartThree, levelTwoPartFour,
					levelTwoPartFive, levelTwoPartSix, levelTwoPartSeven, levelTwoPartEight;
	private Rectangle levelThreePartOne, levelThreePartTwo, levelThreePartThree, levelThreePartFour,
					levelThreePartFive, levelThreePartSix, levelThreePartSeven, levelThreePartEight,
					levelThreePartNine, levelThreePartTen, levelThreePartEleven, levelThreePartTwelve;


	private int powerupCount = 0, powerupDraw = 0, powerupTime = 0, powerupRemove = 0, powerupStop = 0;
	private int powerupTimeTwo = 0, powerupRemoveTwo = 0, powerupStopTwo = 0;
	private int levelChangeOne = 0, levelChangeTwo = 0, levelChangeMultiplayer = 0;
	private int mainMenuOne = 0, mainMenuTwo = 0;
	private int exitGame = 0;
	private int lapCheck = 0, lapCheckPlayerTwo = 0, lapCheckOpponentOne = 0, lapCheckOpponentTwo = 0, lapCheckOpponentThree = 0;

	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.BLACK);

		createHUD();
		createLevelChange();
		createMainMenu();
		createFinishedState();

		createPlayer();
		createLevelOne();
		createLevelTwo();
		createLevelThree();
		createOpponents();
		createObstacle();
		createPowerup();

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

	//Metod för att skapa spelare ett och spelare två
	public void createPlayer(){
		player = new Player("Player.png", 605,150,35,17.5f);
		racerArray[0] = player;

		playerTwo = new Player("Player.png", 605, 100,35,17.5f);
		racerArray[1] = playerTwo;
	}
	//Metod för att skapa HUD:en
	public void createHUD(){
		HUD = new PlayState("HUD.png",0,618,1366,150);
		HUDMultiplayer = new PlayState("HUD_MULTIPLAYER.png",0,618,1366,150);

		//Skapar spelarens varvbilder
		lapOne = new PlayState("LapOne.png", 429,690,50,50);
		lapTwo = new PlayState("LapTwo.png", 429,690,50,50);
		lapThree = new PlayState("LapThree.png", 429,690,50,50);
		lapFour = new PlayState("LapFour.png", 429,690,50,50);
		lapFive = new PlayState("LapFive.png", 429,690,50,50);
		lapSix = new PlayState("LapSix.png", 429,690,50,50);
		lapSeven = new PlayState("LapSeven.png", 429,690,50,50);

		//Skapar motståndare etts varv bilder
		lapOneOpponentOne = new PlayState("LapOne.png",429,625,50,50);
		lapTwoOpponentOne = new PlayState("LapTwo.png",429,625,50,50);
		lapThreeOpponentOne = new PlayState("LapThree.png",429,625,50,50);
		lapFourOpponentOne = new PlayState("LapFour.png",429,625,50,50);
		lapFiveOpponentOne = new PlayState("LapFive.png",429,625,50,50);
		lapSixOpponentOne = new PlayState("LapSix.png",429,625,50,50);
		lapSevenOpponentOne = new PlayState("LapSeven.png",429,625,50,50);

		//Skapar motståndare två varv bilder
		lapOneOpponentTwo = new PlayState("LapOne.png",1292,690,50,50);
		lapTwoOpponentTwo = new PlayState("LapTwo.png",1292,690,50,50);
		lapThreeOpponentTwo = new PlayState("LapThree.png",1292,690,50,50);
		lapFourOpponentTwo = new PlayState("LapFour.png",1292,690,50,50);
		lapFiveOpponentTwo = new PlayState("LapFive.png",1292,690,50,50);
		lapSixOpponentTwo = new PlayState("LapSix.png",1292,690,50,50);
		lapSevenOpponentTwo = new PlayState("LapSeven.png",1292,690,50,50);

		//Skapar motståndare tres varv bilder
		lapOneOpponentThree = new PlayState("LapOne.png",1292,625,50,50);
		lapTwoOpponentThree = new PlayState("LapTwo.png",1292,625,50,50);
		lapThreeOpponentThree = new PlayState("LapThree.png",1292,625,50,50);
		lapFourOpponentThree = new PlayState("LapFour.png",1292,625,50,50);
		lapFiveOpponentThree = new PlayState("LapFive.png",1292,625,50,50);
		lapSixOpponentThree = new PlayState("LapSix.png",1292,625,50,50);
		lapSevenOpponentThree = new PlayState("LapSeven.png",1292,625,50,50);

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
		levelThreePartFour = levelThreeTrack.trackPartArea(45,453,60,42);
		levelThreePartFive = levelThreeTrack.trackPartArea(45,354,862,100);
		levelThreePartSix = levelThreeTrack.trackPartArea(906,354,90,121);
		levelThreePartSeven = levelThreeTrack.trackPartArea(996,385,118,90);
		levelThreePartEight = levelThreeTrack.trackPartArea(1111,204,90,271);
		levelThreePartNine = levelThreeTrack.trackPartArea(996,204,118,90);
		levelThreePartTen = levelThreeTrack.trackPartArea(906,204,90,121);
		levelThreePartEleven = levelThreeTrack.trackPartArea(45,224,862,100);
		levelThreePartTwelve = levelThreeTrack.trackPartArea(45,185,60,42);

		Track roadOne = new Track("Player.png", 45,45,1277,140);
		levelThree[0] = roadOne;

		Track roadTwo = new Track("Player.png",1221,185,100,390);
		levelThree[1] = roadTwo;

		Track roadThree = new Track("Player.png", 45,493,1178,80);
		levelThree[2] = roadThree;

		Track roadFour = new Track("Player.png", 45,453,60,42);
		levelThree[3] = roadFour;

		Track roadFive = new Track("Player.png", 45,354,862,100);
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

		Track roadEleven = new Track("Player.png", 45,224,862,100);
		levelThree[10] = roadEleven;

		Track roadTwelve = new Track("Player.png", 45,185,60,42);
		levelThree[11] = roadTwelve;
	}

	//Skapa obstacle
	public void createObstacle(){
		obstacleY = rand.nextInt(618);
		obstacleX = rand.nextInt(1320);
		obstacle = new Obstacle("Obstacle.png", obstacleX,obstacleY,50);
	}
	//Skapa powerup
	public void createPowerup(){
		powerupX = rand.nextInt(1320);
		powerupY = rand.nextInt(618);
		powerup = new Powerup("Powerup.png", powerupX, powerupY, 25);

	}
	//Skapar levelchange gamestate
	public void createLevelChange(){
		levelTransition = new PlayState("LevelChange.png", 0, 0, 1366,618);
	}
	//Skapar mainmenu gamestate
	public void createMainMenu(){
		mainMenu = new PlayState("MainMenu.png",0,0,1366,618);
	}
	//Skapar finished gamestate
	public void createFinishedState(){
		finishedState = new PlayState("FinishedState.png",0,0,1366,618);
	}

	//Metod som används för att rendera level change.
	public GameState renderLevelChange(int levelChangeTwo){
		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
			levelChangeOne++;
		}

		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		levelTransition.draw(batch);
		batch.end();


		if (levelChangeOne == 1 && levelChangeTwo == 0){
			gameState = GameState.LEVELTWO;
		}
		else if (levelChangeOne == 2 && levelChangeTwo == 1){
			gameState = GameState.LEVELTHREE;
		}

		return gameState;
	}

	//Metod som renderar level change i multiplayer mode
	public GameState renderLevelChangeMultiPlayer(int levelChangeMultiplayer){
		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
			levelChangeOne++;
		}

		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		levelTransition.draw(batch);
		batch.end();


		if (levelChangeOne == 1 && levelChangeMultiplayer == 0){
			gameState = GameState.LEVEL_TWO_MULTIPLAYER;
		}
		else if (levelChangeOne == 2 && levelChangeMultiplayer == 1){
			gameState = GameState.LEVEL_THREE_MULTIPLAYER;
		}

		return gameState;
	}
	//Metod som renderar huvudmenyn
	public GameState renderMainMenu() {
		if (Gdx.input.isKeyJustPressed(Input.Keys.M)){
			mainMenuOne++;
		}
		else if (Gdx.input.isKeyJustPressed(Input.Keys.N)){
			mainMenuTwo++;
		}

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		mainMenu.draw(batch);
		batch.end();


		if (mainMenuOne == 1){
			gameState = GameState.LEVEL_ONE_MULTIPLAYER;
		}
		else if (mainMenuTwo == 1){
			gameState = GameState.LEVELONE;
		}

		return gameState;
	}

	//Metod som renderar den så kallade finished screen.
	public void renderFinishedState(){
		if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
			exitGame++;
		}

		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		finishedState.draw(batch);
		batch.end();


		if (exitGame == 1){
			System.exit(0);
		}
	}

	//Metod som används för att rendera level ett.
	public GameState renderLevelOne(){
		//Uppdaterar positionen av samtliga Racer objekt
		racerList.get(0).updatePostion();
		racerArray[0].updatePostion();


		//Kollar ifall spelare och opponents plockar upp en powerup. checkKeys är metoden som styr bilen ifall man inte kolliderar med hinder/powerup
		if (player.collidesWithPowerup(powerup.figureArea())){
			powerupTime = 1;
			powerupRemove = 1;
			//powerupCount = rand.nextInt(1000);
		}
		if (powerupRemove >= 1 && powerupRemove <= 100){
			powerupStop++;
		}
		if (powerupStop == 30){
			powerup.setX(rand.nextInt(1321));
			powerup.setY(rand.nextInt(618));
			powerupRemove = 0;
			powerupStop = 0;
		}
		if (powerupTime >= 1 && powerupTime < 90){
			powerupTime++;
			checkKeysPowerup();
		}
		else{
			checkKeys();
		}


		if (opponentOne.collidesWithPowerup(powerup.figureArea())){
			opponentOne.opponentCollidePowerup();
			powerupRemove = 1;
			//powerupCount = rand.nextInt(1000);
		}
		if (powerupRemove >= 1 && powerupRemove <= 100){
			powerupStop++;
		}
		if (powerupStop == 30){
			powerup.setX(rand.nextInt(1321));
			powerup.setY(rand.nextInt(618));
			powerupRemove = 0;
			powerupStop = 0;
		}




		//Kollar ifall spelaren kolliderar med ett hinder och sänker farten ifall det är sant!
			if (player.collidesWithObstacle(obstacle.figureArea())){
				checkKeysOutOfBounds();
			}

			if (opponentOne.collidesWithObstacle(obstacle.figureArea())){
				opponentOne.opponentCollideObstacle();
			}
			else{
				opponentOne.opponentNotCollideObstacle();
			}

		//Kollar ifall spelaren kolliderar med en motståndare
		if (player.collidesWithRacer(opponentOne.getCollisionAreaRacer())) {
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

		//Kollar så att spelaren/motståndare inte fuskar.
		lapCheck = player.antiCheatingLevelOne(player);
		lapCheckOpponentOne = opponentOne.antiCheatingLevelOne(opponentOne);

		//Ändrar riktningen och åt vilket håll motståndaren kör
		opponentOne.changeDirectionLevelOne();
		opponentOne.followTrackLevelOne();

		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		//Ritar ut level ett.
		trackList.get(0).draw(batch);

		//Ritar ut HUD:en
		HUD.draw(batch);


		//Kontrollerar så att arean av delarna stämmer.
		//levelOne[0].draw(batch);
		//levelOne[1].draw(batch);
		//levelOne[2].draw(batch);
		//levelOne[3].draw(batch);

		//Ritar ut obstacle
		obstacle.obstacleDrawLevelOne(obstacle, partOne, partTwo, partThree, partFour, batch);

		//Ritar ut powerup
		powerupCount = rand.nextInt(100);
		if(powerupCount == 99){
			powerupDraw = 1;
		}
		if(powerupDraw == 1){
			powerup.powerupDrawLevelOne(powerup, partOne, partTwo, partThree, partFour, batch);
		}

		//Ritar ut samtliga racer objekt.
		racerList.get(0).draw(batch);
		racerArray[0].draw(batch);

		//Ritar ut hur många varv spelaren kört.
		if (lapCheck == 1){
			lapOne.draw(batch);
		}else if (lapCheck == 2){
			lapTwo.draw(batch);
		}else if (lapCheck == 3){
			lapThree.draw(batch);
		}

		//Ritar ut hur många varv motståndaren kört.
		if (lapCheckOpponentOne == 1){
			lapOneOpponentOne.draw(batch);
		}else if (lapCheckOpponentOne == 2){
			lapTwoOpponentOne.draw(batch);
		}else if (lapCheckOpponentOne == 3){
			lapThreeOpponentOne.draw(batch);
		}

		batch.end();

		//När man kör klart så återställer denna IF-sats spelarens och motståndare etts position.
		if (lapCheck == 3 || lapCheckOpponentOne == 3 ){
			gameState = GameState.LEVELCHANGE;

			player.setX(605);
			player.setY(155);
			player.getSprite().setRotation(0);

			opponentOne.setX(605);
			opponentOne.setY(60);
			opponentOne.getSprite().setRotation(0);

			obstacleX = rand.nextInt(1321);
			obstacleY = rand.nextInt(618);
			obstacle.setX(obstacleX);
			obstacle.setY(obstacleY);

			powerupCount = 0;
			powerupDraw = 0;
			powerupTime = 400;
			powerup.setX(rand.nextInt(1321));
			powerup.setY(rand.nextInt(618));

		}
		return gameState;
	}

	//Metod som ritar ut level två.
	public GameState renderLevelTwo(){
		//Uppdaterar positionen av samtliga Racer objekt
		racerList.get(0).updatePostion();
		racerList.get(1).updatePostion();
		racerArray[0].updatePostion();


		//Kollar ifall spelare och opponents plockar upp en powerup. checkKeys är metoden som styr bilen ifall man inte kolliderar med hinder/powerup
		if (player.collidesWithPowerup(powerup.figureArea())){
			powerupTime = 1;
			powerupRemove = 1;
			//powerupCount = rand.nextInt(1000);
		}
		if (powerupRemove >= 1 && powerupRemove <= 100){
			powerupStop++;
		}
		if (powerupStop == 30){
			powerup.setX(rand.nextInt(1321));
			powerup.setY(rand.nextInt(618));
			powerupRemove = 0;
			powerupStop = 0;
		}
		if (powerupTime >= 1 && powerupTime < 90){
			powerupTime++;
			checkKeysPowerup();
		}
		else{
			checkKeys();
		}


		if (opponentOne.collidesWithPowerup(powerup.figureArea())){
			opponentOne.opponentCollidePowerup();
			powerupRemove = 1;
			//powerupCount = rand.nextInt(1000);
		}
		if (powerupRemove >= 1 && powerupRemove <= 100){
			powerupStop++;
		}
		if (powerupStop == 30){
			powerup.setX(rand.nextInt(1321));
			powerup.setY(rand.nextInt(618));
			powerupRemove = 0;
			powerupStop = 0;
		}
		if (opponentTwo.collidesWithPowerup(powerup.figureArea())){
			opponentTwo.opponentCollidePowerup();
			powerupRemove = 1;
			//powerupCount = rand.nextInt(1000);
		}
		if (powerupRemove >= 1 && powerupRemove <= 100){
			powerupStop++;
		}
		if (powerupStop == 30){
			powerup.setX(rand.nextInt(1321));
			powerup.setY(rand.nextInt(618));
			powerupRemove = 0;
			powerupStop = 0;
		}


		//Kollar ifall spelaren kolliderar med ett hinder och sänker farten ifall det är sant!
		if (player.collidesWithObstacle(obstacle.figureArea())){
			checkKeysOutOfBounds();
		}

		if (opponentOne.collidesWithObstacle(obstacle.figureArea())){
			opponentOne.opponentCollideObstacle();
		}
		else{
			opponentOne.opponentNotCollideObstacle();
		}

		if (opponentTwo.collidesWithObstacle(obstacle.figureArea())){
			opponentTwo.opponentCollideObstacle();
		}
		else{
			opponentTwo.opponentNotCollideObstacle();
		}



			//Kollar ifall spelaren kolliderar med en motståndare
			if (player.collidesWithRacer(opponentOne.getCollisionAreaRacer())){
				player.setSpeedX(-(player.getSpeedX()+1));
				player.setSpeedY(-(player.getSpeedY()+1));
			}
			if(player.collidesWithRacer(opponentTwo.getCollisionAreaRacer())){
				player.setSpeedX(-(player.getSpeedX()+1));
				player.setSpeedY(-(player.getSpeedY()+1));
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


		//Kollar så att spelaren/motståndare inte fuskar.
		lapCheck = player.antiCheatingLevelTwo(player);
		lapCheckOpponentOne = opponentOne.antiCheatingLevelTwo(opponentOne);
		lapCheckOpponentTwo = opponentTwo.antiCheatingLevelTwo(opponentTwo);


		//Kallar på metoderna som flyttar motståndare ett
		opponentOne.followTrackLevelTwo();
		opponentOne.changeDirectionLevelTwo();
		opponentTwo.followTrackLevelTwo();
		opponentTwo.changeDirectionLevelTwo();


        Gdx.gl.glClearColor(0, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

		//Ritar ut level två
		trackList.get(1).draw(batch);

		//Ritar ut HUD:en
		HUD.draw(batch);

		//Kontroll av arean så den stämmer.
		//levelTwo[0].draw(batch);
		//levelTwo[1].draw(batch);
		//levelTwo[2].draw(batch);
		//levelTwo[3].draw(batch);
		//levelTwo[4].draw(batch);
		//levelTwo[5].draw(batch);
		//levelTwo[6].draw(batch);
		//levelTwo[7].draw(batch);

		//Ritar ut hinder
		obstacle.obstacleDrawLevelTwo(obstacle, levelTwoPartOne, levelTwoPartTwo, levelTwoPartThree, levelTwoPartFour, levelTwoPartFive,
									levelTwoPartSix, levelTwoPartSeven, levelTwoPartEight, batch);

		//Ritar ut powerup
		powerupCount = rand.nextInt(100);
		if(powerupCount == 99){
			powerupDraw = 1;
		}
		if(powerupDraw == 1){
			powerup.powerupDrawLevelTwo(powerup, levelTwoPartOne, levelTwoPartTwo, levelTwoPartThree, levelTwoPartFour, levelTwoPartFive,
					levelTwoPartSix, levelTwoPartSeven, levelTwoPartEight, batch);
		}

		//Ritar ut samtliga racing objekt
		racerList.get(0).draw(batch);
		racerList.get(1).draw(batch);
		racerArray[0].draw(batch);

		//Ritar ut vinnarens namn
		font.draw(batch, winner,700,600);
		if (lapCheck == 5){
			font.draw(batch, playerText, 752,600);
		}
		if(lapCheckOpponentOne == 5){
			font.draw(batch, opponentText,752,600);
		}

		//Ritar ut hur många varv spelaren kört.
		if (lapCheck == 1){
			lapOne.draw(batch);
		}else if (lapCheck == 2){
			lapTwo.draw(batch);
		}else if (lapCheck == 3){
			lapThree.draw(batch);
		}else if (lapCheck == 4){
			lapFour.draw(batch);
		}else if (lapCheck == 5){
			lapFive.draw(batch);
		}

		//Ritar ut hur många varv motståndare ett kört.
		if (lapCheckOpponentOne == 1){
			lapOneOpponentOne.draw(batch);
		}else if (lapCheckOpponentOne == 2){
			lapTwoOpponentOne.draw(batch);
		}else if (lapCheckOpponentOne == 3){
			lapThreeOpponentOne.draw(batch);
		}else if (lapCheckOpponentOne == 4){
			lapFourOpponentOne.draw(batch);
		}else if (lapCheckOpponentOne == 5){
			lapFiveOpponentOne.draw(batch);
		}

		//Ritar ut hur många varv motståndare två kört.
		if (lapCheckOpponentTwo == 1){
			lapOneOpponentTwo.draw(batch);
		}else if (lapCheckOpponentTwo == 2){
			lapTwoOpponentTwo.draw(batch);
		}else if (lapCheckOpponentTwo == 3){
			lapThreeOpponentTwo.draw(batch);
		}else if (lapCheckOpponentTwo == 4){
			lapFourOpponentTwo.draw(batch);
		}else if (lapCheckOpponentTwo == 5){
			lapFiveOpponentTwo.draw(batch);
		}

        batch.end();
		//När man kör klart så återställer denna IF-sats spelarens och motståndare etts position.
		if (lapCheck == 5 || lapCheckOpponentOne == 5 || lapCheckOpponentTwo == 5){
			gameState = GameState.LEVELCHANGE;

			player.setX(605);
			player.setY(155);
			player.getSprite().setRotation(0);

			opponentOne.setX(605);
			opponentOne.setY(60);
			opponentOne.getSprite().setRotation(0);

			opponentTwo.setX(605);
			opponentTwo.setY(120);
			opponentTwo.getSprite().setRotation(0);

			obstacleX = rand.nextInt(1321);
			obstacleY = rand.nextInt(618);
			obstacle.setX(obstacleX);
			obstacle.setY(obstacleY);

			powerupCount = 0;
			powerupDraw = 0;
			powerupTime = 400;
			powerup.setX(rand.nextInt(1321));
			powerup.setY(rand.nextInt(618));

			levelChangeTwo = 1;

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

	//Metod som kontrollerar om spelare två trycker på några tangenter.
	public void checkKeysMultiPlayer(){
		if(Gdx.input.isKeyPressed(Input.Keys.W)){
			playerTwo.accelerate();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.S)) {
			playerTwo.brake();
		}
		else if(!Gdx.input.isKeyPressed(Input.Keys.W)){
			playerTwo.noAccelerate();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			playerTwo.turnRight();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			playerTwo.turnLeft();
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
		else if(!Gdx.input.isKeyPressed(Input.Keys.UP)){
			player.noAccelerate();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			player.turnRightOutOfBounds();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			player.turnLeftOutOfBounds();
		}
	}

	//Metod som kontrollerar om spelare två trycker på några tangenterna när han är utanför banan.
	public void checkKeysOutOfBoundsMultiPlayer(){
		if(Gdx.input.isKeyPressed(Input.Keys.W)){
			playerTwo.accelerateOutOfBounds();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.S)) {
			playerTwo.brake();
		}
		else if(!Gdx.input.isKeyPressed(Input.Keys.W)){
			playerTwo.noAccelerate();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			playerTwo.turnRightOutOfBounds();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			playerTwo.turnLeftOutOfBounds();
		}
	}
	//Styr spelaren när man kört över en powerup
	public void checkKeysPowerup(){
		if(Gdx.input.isKeyPressed(Input.Keys.UP)){
			player.acceleratePowerup();
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
	//Styr spelare två när man kört över en powerup
	public void checkKeysPowerupMultiPlayer(){
		if(Gdx.input.isKeyPressed(Input.Keys.W)){
			playerTwo.acceleratePowerup();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.S)) {
			playerTwo.brake();
		}
		else if(!Gdx.input.isKeyPressed(Input.Keys.W)){
			playerTwo.noAccelerate();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			playerTwo.turnRight();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			playerTwo.turnLeft();
		}
	}

	//Metod som används för att rendera level tre
	public GameState renderLevelThree(){
		//Uppdaterar positionen av samtliga opponet objekt
		for(Racer racer : racerList) {
			racer.updatePostion();
		}
			//Uppdaterar spelarens position
			racerArray[0].updatePostion();

		//Kollar ifall spelare och opponents plockar upp en powerup. checkKeys är metoden som styr bilen ifall man inte kolliderar med hinder/powerup
		if (player.collidesWithPowerup(powerup.figureArea())){
			powerupTime = 1;
			powerupRemove = 1;
			//powerupCount = rand.nextInt(1000);
		}
		if (powerupRemove >= 1 && powerupRemove <= 100){
			powerupStop++;
		}
		if (powerupStop == 30){
			powerup.setX(rand.nextInt(1321));
			powerup.setY(rand.nextInt(618));
			powerupRemove = 0;
			powerupStop = 0;
		}
		if (powerupTime >= 1 && powerupTime < 90){
			powerupTime++;
			checkKeysPowerup();
		}
		else{
			checkKeys();
		}


		if (opponentOne.collidesWithPowerup(powerup.figureArea())){
			opponentOne.opponentCollidePowerup();
			powerupRemove = 1;
			//powerupCount = rand.nextInt(1000);
		}
		if (powerupRemove >= 1 && powerupRemove <= 100){
			powerupStop++;
		}
		if (powerupStop == 30){
			powerup.setX(rand.nextInt(1321));
			powerup.setY(rand.nextInt(618));
			powerupRemove = 0;
			powerupStop = 0;
		}
		if (opponentTwo.collidesWithPowerup(powerup.figureArea())){
			opponentTwo.opponentCollidePowerup();
			powerupRemove = 1;
			//powerupCount = rand.nextInt(1000);
		}
		if (powerupRemove >= 1 && powerupRemove <= 100){
			powerupStop++;
		}
		if (powerupStop == 30){
			powerup.setX(rand.nextInt(1321));
			powerup.setY(rand.nextInt(618));
			powerupRemove = 0;
			powerupStop = 0;
		}
		if (opponentThree.collidesWithPowerup(powerup.figureArea())){
			opponentThree.opponentCollidePowerup();
			powerupRemove = 1;
		}
		if (powerupRemove >= 1 && powerupRemove <= 100){
			powerupStop++;
		}
		if (powerupStop == 30){
			powerup.setX(rand.nextInt(1321));
			powerup.setY(rand.nextInt(618));
			powerupRemove = 0;
			powerupStop = 0;
		}

		//Kollar ifall spelaren kolliderar med ett hinder och sänker farten ifall det är sant!
		if (player.collidesWithObstacle(obstacle.figureArea())){
			checkKeysOutOfBounds();
		}

		if (opponentOne.collidesWithObstacle(obstacle.figureArea())){
			opponentOne.opponentCollideObstacle();
		}
		else{
			opponentOne.opponentNotCollideObstacle();
		}

		if (opponentTwo.collidesWithObstacle(obstacle.figureArea())){
			opponentTwo.opponentCollideObstacle();
		}
		else{
			opponentTwo.opponentNotCollideObstacle();
		}

		if (opponentThree.collidesWithObstacle(obstacle.figureArea())){
			opponentThree.opponentCollideObstacle();
		}
		else{
			opponentThree.opponentNotCollideObstacle();
		}


			//Kollar ifall spelaren kolliderar med en motståndare
			if (player.collidesWithRacer(opponentOne.getCollisionAreaRacer())){
				player.setSpeedX(-(player.getSpeedX()+1));
				player.setSpeedY(-(player.getSpeedY()+1));
			}

			if(player.collidesWithRacer(opponentTwo.getCollisionAreaRacer())){
			player.setSpeedX(-(player.getSpeedX()+1));
			player.setSpeedY(-(player.getSpeedY()+1));
			}

			if(player.collidesWithRacer(opponentThree.getCollisionAreaRacer())){
			player.setSpeedX(-(player.getSpeedX()+1));
			player.setSpeedY(-(player.getSpeedY()+1));
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

		//Kollar så att spelaren/motståndare inte fuskar.
		lapCheck = player.antiCheatingLevelThree(player);
		lapCheckOpponentOne = opponentOne.antiCheatingLevelThree(opponentOne);
		lapCheckOpponentTwo = opponentTwo.antiCheatingLevelThree(opponentTwo);
		lapCheckOpponentThree = opponentThree.antiCheatingLevelThree(opponentThree);

		//Ändrar riktningen och åt vilket håll motståndaren kör
		opponentOne.followTrackLevelThree();
		opponentOne.changeDirectionLevelThree();
		opponentTwo.followTrackLevelThree();
		opponentTwo.changeDirectionLevelThree();
		opponentThree.followTrackLevelThree();
		opponentThree.changeDirectionLevelThree();

		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		//Ritar ut level tre.
		trackList.get(2).draw(batch);

		//Ritar ut HUD:en
		HUD.draw(batch);

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

		//Ritar ut hindret
		obstacle.obstacleDrawLevelThree(obstacle, levelThreePartOne, levelThreePartTwo, levelThreePartThree, levelThreePartFive,
				levelThreePartSix, levelThreePartSeven, levelTwoPartEight, levelThreePartNine, levelThreePartTen, levelThreePartEleven, batch);

		//Ritar ut powerup
		powerupCount = rand.nextInt(100);
		if(powerupCount == 99){
			powerupDraw = 1;
		}
		if(powerupDraw == 1){
			powerup.powerupDrawLevelThree(powerup, levelThreePartOne, levelThreePartTwo, levelThreePartThree, levelThreePartFive,
					levelThreePartSix, levelThreePartSeven, levelTwoPartEight, levelThreePartNine, levelThreePartTen, levelThreePartEleven, batch);
		}


		//Ritar ut samtliga racer objekt.
		for(Racer player : racerList){
			player.draw(batch);
		}

		//Ritar ut spelaren
		racerArray[0].draw(batch);

		//Ritar ut hur många varv spelaren kört.
		if (lapCheck == 1){
			lapOne.draw(batch);
		}else if (lapCheck == 2){
			lapTwo.draw(batch);
		}else if (lapCheck == 3){
			lapThree.draw(batch);
		}else if (lapCheck == 4){
			lapFour.draw(batch);
		}else if (lapCheck == 5){
			lapFive.draw(batch);
		}else if (lapCheck == 6){
			lapSix.draw(batch);
		}else if (lapCheck == 7){
			lapSeven.draw(batch);
		}

		//Ritar ut hur många varv motståndare ett kört.
		if (lapCheckOpponentOne == 1){
			lapOneOpponentOne.draw(batch);
		}else if (lapCheckOpponentOne == 2){
			lapTwoOpponentOne.draw(batch);
		}else if (lapCheckOpponentOne == 3){
			lapThreeOpponentOne.draw(batch);
		}else if (lapCheckOpponentOne == 4){
			lapFourOpponentOne.draw(batch);
		}else if (lapCheckOpponentOne == 5){
			lapFiveOpponentOne.draw(batch);
		}else if (lapCheckOpponentOne == 6){
			lapSixOpponentOne.draw(batch);
		}else if (lapCheckOpponentOne == 7){
			lapSevenOpponentOne.draw(batch);
		}

		//Ritar ut hur många varv motståndare två kört.
		if (lapCheckOpponentTwo == 1){
			lapOneOpponentTwo.draw(batch);
		}else if (lapCheckOpponentTwo == 2){
			lapTwoOpponentTwo.draw(batch);
		}else if (lapCheckOpponentTwo == 3){
			lapThreeOpponentTwo.draw(batch);
		}else if (lapCheckOpponentTwo == 4){
			lapFourOpponentTwo.draw(batch);
		}else if (lapCheckOpponentTwo == 5) {
			lapFiveOpponentTwo.draw(batch);
		}else if (lapCheckOpponentTwo == 6){
			lapSixOpponentTwo.draw(batch);
		}else if (lapCheckOpponentTwo == 7){
			lapSevenOpponentTwo.draw(batch);
		}

		//Ritar ut hur många varv motståndare två kört.
		if (lapCheckOpponentThree == 1){
			lapOneOpponentThree.draw(batch);
		}else if (lapCheckOpponentThree == 2){
			lapTwoOpponentThree.draw(batch);
		}else if (lapCheckOpponentThree == 3){
			lapThreeOpponentThree.draw(batch);
		}else if (lapCheckOpponentThree == 4){
			lapFourOpponentThree.draw(batch);
		}else if (lapCheckOpponentThree == 5){
			lapFiveOpponentThree.draw(batch);
		}else if (lapCheckOpponentThree == 6){
			lapSixOpponentThree.draw(batch);
		}else if (lapCheckOpponentThree == 7){
			lapSevenOpponentThree.draw(batch);
		}
		batch.end();

		//När man kör klart så återställer denna IF-sats spelarens och motståndare etts position.
		if (lapCheck == 7 || lapCheckOpponentOne == 7 || lapCheckOpponentTwo == 7 || lapCheckOpponentThree == 7){
			gameState = GameState.FINISH;

			player.setX(605);
			player.setY(155);
			player.getSprite().setRotation(0);

			opponentOne.setX(605);
			opponentOne.setY(100);
			opponentOne.getSprite().setRotation(0);

		}
		return gameState;
	}

	//Metod som används för att rendera level ett när man spelar flera spelare.
	public GameState renderLevelOneMultiPlayer(){
		//Uppdaterar positionen av samtliga Racer objekt
		racerArray[0].updatePostion();
		racerArray[1].updatePostion();


		//Kollar ifall spelare och opponents plockar upp en powerup. checkKeys är metoden som styr bilen ifall man inte kolliderar med hinder/powerup
		if (player.collidesWithPowerup(powerup.figureArea())){
			powerupTime = 1;
			powerupRemove = 1;
			//powerupCount = rand.nextInt(1000);
		}
		if (powerupRemove >= 1 && powerupRemove <= 100){
			powerupStop++;
		}
		if (powerupStop == 30){
			powerup.setX(rand.nextInt(1321));
			powerup.setY(rand.nextInt(618));
			powerupRemove = 0;
			powerupStop = 0;
		}
		if (powerupTime >= 1 && powerupTime < 90){
			powerupTime++;
			checkKeysPowerup();
		}
		else{
			checkKeys();
		}

		if (playerTwo.collidesWithPowerup(powerup.figureArea())){
			powerupTimeTwo = 1;
			powerupRemoveTwo = 1;
			//powerupCount = rand.nextInt(1000);
		}
		if (powerupRemoveTwo >= 1 && powerupRemoveTwo <= 100){
			powerupStopTwo++;
		}
		if (powerupStopTwo == 30){
			powerup.setX(rand.nextInt(1321));
			powerup.setY(rand.nextInt(618));
			powerupRemoveTwo = 0;
			powerupStopTwo = 0;
		}
		if (powerupTimeTwo >= 1 && powerupTimeTwo < 90){
			powerupTimeTwo++;
			checkKeysPowerupMultiPlayer();
		}
		else{
			checkKeysMultiPlayer();
		}


		//Kollar ifall spelaren kolliderar med ett hinder och sänker farten ifall det är sant!
		if (player.collidesWithObstacle(obstacle.figureArea())){
			checkKeysOutOfBounds();
		}

		if (playerTwo.collidesWithObstacle(obstacle.figureArea())){
			checkKeysOutOfBoundsMultiPlayer();
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

		if (!playerTwo.insideTrack(partOne) && !playerTwo.insideTrack(partTwo) &&
				!playerTwo.insideTrack(partThree) && !playerTwo.insideTrack(partFour)) {

			if (playerTwo.getX() > 1336 || playerTwo.getX() < 30 || playerTwo.getY() > 588 || playerTwo.getY() < 30) {
				playerTwo.bounceOfEdge();
			} else {
				checkKeysOutOfBoundsMultiPlayer();
			}
			playerTwo.setSpeedOutOfBounds();

		}

		//Kollar så att ingen av spelarna fuskar
		lapCheck = player.antiCheatingLevelOne(player);
		lapCheckPlayerTwo = playerTwo.antiCheatingLevelOne(playerTwo);


		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		//Ritar ut level ett.
		trackList.get(0).draw(batch);

		//Ritar ut HUD:en
		HUDMultiplayer.draw(batch);

		//Kontrollerar så att arean av delarna stämmer.
		//levelOne[0].draw(batch);
		//levelOne[1].draw(batch);
		//levelOne[2].draw(batch);
		//levelOne[3].draw(batch);

		//Ritar ut obstacle
		obstacle.obstacleDrawLevelOne(obstacle, partOne, partTwo, partThree, partFour, batch);

		//Ritar ut powerup
		powerupCount = rand.nextInt(100);
		if(powerupCount == 99){
			powerupDraw = 1;
		}
		if(powerupDraw == 1){
			powerup.powerupDrawLevelOne(powerup, partOne, partTwo, partThree, partFour, batch);
		}

		//Ritar ut samtliga racer objekt.
		racerArray[0].draw(batch);
		racerArray[1].draw(batch);

		//Ritar ut vinnarens namn.
		//Ritar ut hur många varv spelaren kört.
		if (lapCheck == 1){
			lapOne.draw(batch);
		}else if (lapCheck == 2){
			lapTwo.draw(batch);
		}else if (lapCheck == 3){
			lapThree.draw(batch);
		}

		//Ritar ut hur många varv motståndaren kört.
		if (lapCheckPlayerTwo == 1){
			lapOneOpponentOne.draw(batch);
		}else if (lapCheckPlayerTwo == 2){
			lapTwoOpponentOne.draw(batch);
		}else if (lapCheckPlayerTwo == 3){
			lapThreeOpponentOne.draw(batch);
		}
		batch.end();

		//När man kör klart så återställer denna IF-sats spelarens och motståndare etts position.
		if (lapCheck == 3 || lapCheckPlayerTwo == 3 ){
			gameState = GameState.LEVEL_CHANGE_MULTIPLAYER;

			player.setX(605);
			player.setY(155);
			player.getSprite().setRotation(0);

			playerTwo.setX(605);
			playerTwo.setY(100);
			playerTwo.getSprite().setRotation(0);

			obstacleX = rand.nextInt(1321);
			obstacleY = rand.nextInt(618);
			obstacle.setX(obstacleX);
			obstacle.setY(obstacleY);

			powerupCount = 0;
			powerupDraw = 0;
			powerupTime = 400;
			powerupTimeTwo = 400;
			powerup.setX(rand.nextInt(1321));
			powerup.setY(rand.nextInt(618));

		}
		return gameState;
	}

	//Metod som används för att rendera level två när man spelar flera spelare.
	public GameState renderLevelTwoMultiPlayer(){
		//Uppdaterar positionen av samtliga Racer objekt
		racerArray[0].updatePostion();
		racerArray[1].updatePostion();


		//Kollar ifall spelare och opponents plockar upp en powerup. checkKeys är metoden som styr bilen ifall man inte kolliderar med hinder/powerup
		if (player.collidesWithPowerup(powerup.figureArea())){
			powerupTime = 1;
			powerupRemove = 1;
			//powerupCount = rand.nextInt(1000);
		}
		if (powerupRemove >= 1 && powerupRemove <= 100){
			powerupStop++;
		}
		if (powerupStop == 30){
			powerup.setX(rand.nextInt(1321));
			powerup.setY(rand.nextInt(618));
			powerupRemove = 0;
			powerupStop = 0;
		}
		if (powerupTime >= 1 && powerupTime < 90){
			powerupTime++;
			checkKeysPowerup();
		}
		else{
			checkKeys();
		}

		if (playerTwo.collidesWithPowerup(powerup.figureArea())){
			powerupTimeTwo = 1;
			powerupRemoveTwo = 1;
			//powerupCount = rand.nextInt(1000);
		}
		if (powerupRemoveTwo >= 1 && powerupRemoveTwo <= 100){
			powerupStopTwo++;
		}
		if (powerupStopTwo == 30){
			powerup.setX(rand.nextInt(1321));
			powerup.setY(rand.nextInt(618));
			powerupRemoveTwo = 0;
			powerupStopTwo = 0;
		}
		if (powerupTimeTwo >= 1 && powerupTimeTwo < 90){
			powerupTimeTwo++;
			checkKeysPowerupMultiPlayer();
		}
		else{
			checkKeysMultiPlayer();
		}


		//Kollar ifall spelaren kolliderar med ett hinder och sänker farten ifall det är sant!
		if (player.collidesWithObstacle(obstacle.figureArea())){
			checkKeysOutOfBounds();
		}

		if (playerTwo.collidesWithObstacle(obstacle.figureArea())){
			checkKeysOutOfBoundsMultiPlayer();
		}

		//Kollar ifall spelaren är på banan eller utanför, agerar därefter.
		if (!player.insideTrack(levelTwoPartOne) && !player.insideTrack(levelTwoPartTwo) &&
				!player.insideTrack(levelTwoPartThree) && !player.insideTrack(levelTwoPartFour) &&
				!player.insideTrack(levelTwoPartFive) && !player.insideTrack(levelTwoPartSix) &&
				!player.insideTrack(levelTwoPartSeven) && !player.insideTrack(levelTwoPartEight)) {

			if (player.getX() > 1336 || player.getX() < 30 || player.getY() > 588 || player.getY() < 30) {
				player.bounceOfEdge();
			} else {
				checkKeysOutOfBounds();
			}
			player.setSpeedOutOfBounds();

		}

		if (!playerTwo.insideTrack(levelTwoPartOne) && !playerTwo.insideTrack(levelTwoPartTwo) &&
				!playerTwo.insideTrack(levelTwoPartThree) && !playerTwo.insideTrack(levelTwoPartFour) &&
				!playerTwo.insideTrack(levelTwoPartFive) && !playerTwo.insideTrack(levelTwoPartSix) &&
				!playerTwo.insideTrack(levelTwoPartSeven) && !playerTwo.insideTrack(levelTwoPartEight)) {

			if (playerTwo.getX() > 1336 || playerTwo.getX() < 30 || playerTwo.getY() > 588 || playerTwo.getY() < 30) {
				playerTwo.bounceOfEdge();
			} else {
				checkKeysOutOfBoundsMultiPlayer();
			}
			playerTwo.setSpeedOutOfBounds();

		}

		//Kollar så att ingen av spelarna fuskar
		lapCheck = player.antiCheatingLevelTwo(player);
		lapCheckPlayerTwo = playerTwo.antiCheatingLevelTwo(playerTwo);

		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		//Ritar ut level två.
		trackList.get(1).draw(batch);

		//Ritar ut HUD:en
		HUDMultiplayer.draw(batch);

		//Kontrollerar så att arean av delarna stämmer.
		//levelOne[0].draw(batch);
		//levelOne[1].draw(batch);
		//levelOne[2].draw(batch);
		//levelOne[3].draw(batch);

		//Ritar ut obstacle
		obstacle.obstacleDrawLevelTwo(obstacle, levelTwoPartOne, levelTwoPartTwo, levelTwoPartThree, levelTwoPartFour, levelTwoPartFive,
				levelTwoPartSix, levelTwoPartSeven, levelTwoPartEight, batch);

		//Ritar ut powerup
		powerupCount = rand.nextInt(100);
		if(powerupCount == 99){
			powerupDraw = 1;
		}
		if(powerupDraw == 1){
			powerup.powerupDrawLevelTwo(powerup, levelTwoPartOne, levelTwoPartTwo, levelTwoPartThree, levelTwoPartFour, levelTwoPartFive,
					levelTwoPartSix, levelTwoPartSeven, levelTwoPartEight, batch);
		}

		//Ritar ut samtliga racer objekt.
		racerArray[0].draw(batch);
		racerArray[1].draw(batch);

		//Ritar ut hur många varv spelaren kört.
		if (lapCheck == 1){
			lapOne.draw(batch);
		}else if (lapCheck == 2){
			lapTwo.draw(batch);
		}else if (lapCheck == 3){
			lapThree.draw(batch);
		}else if (lapCheck == 4){
			lapFour.draw(batch);
		}else if (lapCheck == 5) {
			lapFive.draw(batch);
		}

		//Ritar ut hur många varv motståndare ett kört.
		if (lapCheckPlayerTwo == 1){
			lapOneOpponentOne.draw(batch);
		}else if (lapCheckPlayerTwo == 2){
			lapTwoOpponentOne.draw(batch);
		}else if (lapCheckPlayerTwo == 3){
			lapThreeOpponentOne.draw(batch);
		}else if (lapCheckPlayerTwo == 4){
			lapFourOpponentOne.draw(batch);
		}else if (lapCheckPlayerTwo == 5) {
			lapFiveOpponentOne.draw(batch);
		}
		batch.end();

		//När man kör klart så återställer denna IF-sats spelarens och motståndare etts position.
		if (lapCheck == 5 || lapCheckPlayerTwo == 5){
			gameState = GameState.LEVEL_CHANGE_MULTIPLAYER;

			player.setX(605);
			player.setY(155);
			player.getSprite().setRotation(0);

			playerTwo.setX(605);
			playerTwo.setY(100);
			playerTwo.getSprite().setRotation(0);

			obstacleX = rand.nextInt(1321);
			obstacleY = rand.nextInt(618);
			obstacle.setX(obstacleX);
			obstacle.setY(obstacleY);

			powerupCount = 0;
			powerupDraw = 0;
			powerupTime = 400;
			powerupTimeTwo = 400;
			powerup.setX(rand.nextInt(1321));
			powerup.setY(rand.nextInt(618));

			levelChangeMultiplayer = 1;

		}
		return gameState;
	}

	//Metod som används för att rendera level tre när man spelar flera spelare.
	public GameState renderLevelThreeMultiPlayer(){
		//Uppdaterar positionen av samtliga Racer objekt
		racerArray[0].updatePostion();
		racerArray[1].updatePostion();


		//Kollar ifall spelare och opponents plockar upp en powerup. checkKeys är metoden som styr bilen ifall man inte kolliderar med hinder/powerup
		if (player.collidesWithPowerup(powerup.figureArea())){
			powerupTime = 1;
			powerupRemove = 1;
			//powerupCount = rand.nextInt(1000);
		}
		if (powerupRemove >= 1 && powerupRemove <= 100){
			powerupStop++;
		}
		if (powerupStop == 30){
			powerup.setX(rand.nextInt(1321));
			powerup.setY(rand.nextInt(618));
			powerupRemove = 0;
			powerupStop = 0;
		}
		if (powerupTime >= 1 && powerupTime < 90){
			powerupTime++;
			checkKeysPowerup();
		}
		else{
			checkKeys();
		}

		if (playerTwo.collidesWithPowerup(powerup.figureArea())){
			powerupTimeTwo = 1;
			powerupRemoveTwo = 1;
			//powerupCount = rand.nextInt(1000);
		}
		if (powerupRemoveTwo >= 1 && powerupRemoveTwo <= 100){
			powerupStopTwo++;
		}
		if (powerupStopTwo == 30){
			powerup.setX(rand.nextInt(1321));
			powerup.setY(rand.nextInt(618));
			powerupRemoveTwo = 0;
			powerupStopTwo = 0;
		}
		if (powerupTimeTwo >= 1 && powerupTimeTwo < 90){
			powerupTimeTwo++;
			checkKeysPowerupMultiPlayer();
		}
		else{
			checkKeysMultiPlayer();
		}


		//Kollar ifall spelaren kolliderar med ett hinder och sänker farten ifall det är sant!
		if (player.collidesWithObstacle(obstacle.figureArea())){
			checkKeysOutOfBounds();
		}

		if (playerTwo.collidesWithObstacle(obstacle.figureArea())){
			checkKeysOutOfBoundsMultiPlayer();
		}

		//Kollar ifall spelaren är på banan eller utanför, agerar därefter.
		if (!player.insideTrack(levelThreePartOne) && !player.insideTrack(levelThreePartTwo) &&
				!player.insideTrack(levelThreePartThree) && !player.insideTrack(levelThreePartFour) &&
				!player.insideTrack(levelThreePartFive) && !player.insideTrack(levelThreePartSix) &&
				!player.insideTrack(levelThreePartSeven) && !player.insideTrack(levelThreePartEight) &&
				!player.insideTrack(levelThreePartNine) && !player.insideTrack(levelThreePartTen) &&
				!player.insideTrack(levelThreePartEleven) && !player.insideTrack(levelThreePartTwelve)) {

			if (player.getX() > 1336 || player.getX() < 30 || player.getY() > 588 || player.getY() < 30) {
				player.bounceOfEdge();
			} else {
				checkKeysOutOfBounds();
			}
			player.setSpeedOutOfBounds();

		}

		if (!playerTwo.insideTrack(levelThreePartOne) && !playerTwo.insideTrack(levelThreePartTwo) &&
				!playerTwo.insideTrack(levelThreePartThree) && !playerTwo.insideTrack(levelThreePartFour) &&
				!playerTwo.insideTrack(levelThreePartFive) && !playerTwo.insideTrack(levelThreePartSix) &&
				!playerTwo.insideTrack(levelThreePartSeven) && !playerTwo.insideTrack(levelThreePartEight) &&
				!playerTwo.insideTrack(levelThreePartNine) && !playerTwo.insideTrack(levelThreePartTen) &&
				!playerTwo.insideTrack(levelThreePartEleven) && !playerTwo.insideTrack(levelThreePartTwelve)) {

			if (playerTwo.getX() > 1336 || playerTwo.getX() < 30 || playerTwo.getY() > 588 || playerTwo.getY() < 30) {
				playerTwo.bounceOfEdge();
			} else {
				checkKeysOutOfBoundsMultiPlayer();
			}
			playerTwo.setSpeedOutOfBounds();

		}

		//Kollar så att ingen av spelarna fuskar
		lapCheck = player.antiCheatingLevelThree(player);
		lapCheckPlayerTwo = playerTwo.antiCheatingLevelThree(playerTwo);

		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		//Ritar ut level två.
		trackList.get(2).draw(batch);

		//Ritar ut HUD:en
		HUDMultiplayer.draw(batch);

		//Kontrollerar så att arean av delarna stämmer.
		//levelOne[0].draw(batch);
		//levelOne[1].draw(batch);
		//levelOne[2].draw(batch);
		//levelOne[3].draw(batch);

		//Ritar ut obstacle
		obstacle.obstacleDrawLevelThree(obstacle, levelThreePartOne, levelThreePartTwo, levelThreePartThree, levelThreePartFive,
				levelThreePartSix, levelThreePartSeven, levelTwoPartEight, levelThreePartNine, levelThreePartTen, levelThreePartEleven, batch);

		//Ritar ut powerup
		powerupCount = rand.nextInt(100);
		if(powerupCount == 99){
			powerupDraw = 1;
		}
		if(powerupDraw == 1){
			powerup.powerupDrawLevelThree(powerup, levelThreePartOne, levelThreePartTwo, levelThreePartThree, levelThreePartFive,
					levelThreePartSix, levelThreePartSeven, levelTwoPartEight, levelThreePartNine, levelThreePartTen, levelThreePartEleven, batch);
		}

		//Ritar ut samtliga racer objekt.
		racerArray[0].draw(batch);
		racerArray[1].draw(batch);

		//Ritar ut hur många varv spelaren kört.
		if (lapCheck == 1){
			lapOne.draw(batch);
		}else if (lapCheck == 2){
			lapTwo.draw(batch);
		}else if (lapCheck == 3){
			lapThree.draw(batch);
		}else if (lapCheck == 4){
			lapFour.draw(batch);
		}else if (lapCheck == 5){
			lapFive.draw(batch);
		}else if (lapCheck == 6){
			lapSix.draw(batch);
		}else if (lapCheck == 7){
			lapSeven.draw(batch);
		}

		//Ritar ut hur många varv motståndare ett kört.
		if (lapCheckPlayerTwo == 1){
			lapOneOpponentOne.draw(batch);
		}else if (lapCheckPlayerTwo == 2){
			lapTwoOpponentOne.draw(batch);
		}else if (lapCheckPlayerTwo == 3){
			lapThreeOpponentOne.draw(batch);
		}else if (lapCheckPlayerTwo == 4){
			lapFourOpponentOne.draw(batch);
		}else if (lapCheckPlayerTwo == 5){
			lapFiveOpponentOne.draw(batch);
		}else if (lapCheckPlayerTwo == 6){
			lapSixOpponentOne.draw(batch);
		}else if (lapCheckPlayerTwo == 7){
			lapSevenOpponentOne.draw(batch);
		}
		batch.end();

		//När man kör klart så återställer denna IF-sats spelarens och motståndare etts position.
		if (lapCheck == 7 || lapCheckPlayerTwo == 7){
			gameState = GameState.FINISH;

			player.setX(605);
			player.setY(155);
			player.getSprite().setRotation(0);

			playerTwo.setX(605);
			playerTwo.setY(100);
			playerTwo.getSprite().setRotation(0);

			obstacleX = rand.nextInt(1321);
			obstacleY = rand.nextInt(618);
			obstacle.setX(obstacleX);
			obstacle.setY(obstacleY);

			powerupCount = 0;
			powerupDraw = 0;
			powerupTime = 400;
			powerupTimeTwo = 400;
			powerup.setX(rand.nextInt(1321));
			powerup.setY(rand.nextInt(618));

			levelChangeMultiplayer = 1;

		}
		return gameState;
	}

	@Override
	public void render () {

		if (gameState == GameState.MAINMENU){
			gameState = renderMainMenu();
		}
		else if (gameState == GameState.LEVELCHANGE){
			gameState = renderLevelChange(levelChangeTwo);
		}
		else if (gameState == GameState.LEVEL_CHANGE_MULTIPLAYER){
			renderLevelChangeMultiPlayer(levelChangeMultiplayer);
		}
		else if(gameState == GameState.LEVELONE){
			gameState = renderLevelOne();
		}
		else if(gameState == GameState.LEVELTWO){
            gameState = renderLevelTwo();
		}
		else if(gameState == GameState.LEVELTHREE){
			renderLevelThree();
		}
		else if (gameState == GameState.LEVEL_ONE_MULTIPLAYER){
			renderLevelOneMultiPlayer();
		}
		else if (gameState == GameState.LEVEL_TWO_MULTIPLAYER){
			renderLevelTwoMultiPlayer();
		}
		else if (gameState == GameState.LEVEL_THREE_MULTIPLAYER){
			renderLevelThreeMultiPlayer();
		}
		else if (gameState == GameState.FINISH){
			renderFinishedState();
		}

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}
}
