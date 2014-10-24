package com.sparrowgames.gorrion;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class logrosScreen extends AbstractScreen {

	private Image imgFondo, btnSal, imgLogros;
	private SpriteBatch batch;
	private Stage stage;
	private Principal game;
	private BitmapFont texto;
	
	public logrosScreen(Principal game) {
		super(game);
		this.game = game;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		stage.draw();
		
	/*	batch.begin();
		
		if(game.idiomaENG)
			mostrarLogrosENG();
		else
			mostrarLogrosESP();
		
		batch.end();*/
		
	}
	
	private void mostrarLogrosESP(){
		
		if(game.logrosArray[0])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		texto.drawMultiLine(batch, "Reci�n llegado (Muere 10 veces): " + game.muertes + "/10", 140, 430);
				
		if(game.logrosArray[1])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		texto.draw(batch, "Cazador novato (Coge 20 bichos de un intento): " + game.maxPantalla + "/20", 140, 410);
		
		if(game.logrosArray[2])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		texto.draw(batch, "Mejorando d�a a d�a (Coge 60 bichos de un intento): " + game.maxPantalla + "/60", 140, 390);
		
		if(game.logrosArray[3])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		texto.draw(batch, "Cazador profesional (Coge 100 bichos de un intento): " + game.maxPantalla + "/100", 140, 370);
		if(game.logrosArray[4])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		texto.draw(batch, "Generoso (Envia 10 bichos al nido): " + game.puntosNido + "/10", 140, 350);
		
		if(game.logrosArray[5])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		texto.draw(batch, "Muy generoso (Envia 20 bichos al nido): " + game.puntosNido + "/20", 140, 330);
		if(game.logrosArray[6])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		texto.draw(batch, "Piensa en los dem�s (Envia 40 bichos al nido): " + game.puntosNido + "/40", 140, 310);
		
		if(game.logrosArray[7])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		texto.draw(batch, "Insistente (Muere 20 veces): " + game.muertes + "/20", 140, 290);
		
		if(game.logrosArray[8])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		texto.draw(batch, "Robin Gorri�nhood (envia 100 bichos al nido): " + game.puntosNido + "/100", 140, 270);
		
		if(game.logrosArray[9])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		texto.draw(batch, "Tozudo (Muere 100 veces): " + game.muertes + "/100", 140, 250);
		
		if(game.logrosArray[10])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		texto.draw(batch, "Maestro gorri�n (Consigue todos los logros): 0/11", 140, 230);
		
	}

	private void mostrarLogrosENG(){

		if(game.logrosArray[0])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		texto.draw(batch, "Newcomer (Die 10 times): " + game.muertes + "/10", 140, 430);
		
		if(game.logrosArray[1])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		texto.draw(batch, "Rookie hunter (Take 20 bugs in a try): " + game.maxPantalla + "/20", 140, 410);
		
		if(game.logrosArray[2])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		texto.draw(batch, "Improving day by day (Take 60 bugs in a try): " + game.maxPantalla + "/60", 140, 390);
		
		if(game.logrosArray[3])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		texto.draw(batch, "Professional hunter (Take 100 bugs in a try): " + game.maxPantalla + "/100", 140, 370);
		if(game.logrosArray[4])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		texto.draw(batch, "Generous (Send 10 bugs to nest): " + game.puntosNido + "/10", 140, 350);
		
		if(game.logrosArray[5])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		texto.draw(batch, "Very generous (Send 20 bugs to nest): " + game.puntosNido + "/20", 140, 330);
		if(game.logrosArray[6])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		texto.draw(batch, "Thinking of others (Send 40 bugs to nest): " + game.puntosNido + "/40", 140, 310);
		
		if(game.logrosArray[7])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		texto.draw(batch, "Insistent (Die 20 times): " + game.muertes + "/20", 140, 290);
		
		if(game.logrosArray[8])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		texto.draw(batch, "Robin Sparrowhood (Send 100 bugs to nest): " + game.puntosNido + "/100", 140, 270);
		
		if(game.logrosArray[9])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		texto.draw(batch, "Stubbom (Die 100 times): " + game.muertes + "/100", 140, 250);
		
		if(game.logrosArray[10])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		texto.draw(batch, "Master sparrow (Get all achievements): 0/11", 140, 230);

	}
	
	private cartelLogros cartel;
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
		game.myRequestHandler.showAds(true);
		
		if(game.sonido) {
			game.assets.manager.get("mus2.mp3", Music.class).stop();
			game.assets.manager.get("mus1.mp3", Music.class).play();
			
		}
		
		int width = 640;
		int height = 480;
		stage = new Stage(0, 0, true, batch);
		stage.setViewport(640, 480);
		Gdx.input.setInputProcessor(stage);
		
		imgFondo = new Image(game.assets.manager.get("cielo.png", Texture.class));
		imgFondo.setFillParent(true);
		stage.addActor(imgFondo);
		
	/*	imgLogros = new Image(game.assets.manager.get("logros.png", Texture.class));
		imgLogros.setWidth(550);
		imgLogros.setHeight(275);
		imgLogros.setPosition(50, 180);
		stage.addActor(imgLogros);*/
		
		batch = new SpriteBatch();
		texto = new BitmapFont();
		
		
		btnSal = new Image(game.assets.manager.get("boton_off.png", Texture.class));
		
		btnSal.setPosition(width/2 - btnSal.getWidth()/2, height - btnSal.getHeight()*6);
		stage.addActor(btnSal);
		
		cartel = new cartelLogros(game);
		stage.addActor(cartel);
		
		btnSal.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				
				game.myRequestHandler.showAds(false);
				
				if(game.sonido) {
					game.assets.manager.get("click1.wav", Sound.class).play();
				}
							
				switch(game.deDondeVengoLogros){
					case 1: game.setScreen(game.pMenu);
							break;
					case 2:game.setScreen(game.pResumen);
							break;
				}
				return true;
			}
		});
		
	
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		batch.dispose();
		stage.dispose();
	}

}
