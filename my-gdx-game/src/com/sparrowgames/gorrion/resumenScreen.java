package com.sparrowgames.gorrion;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


public class resumenScreen extends AbstractScreen {

	private Image imgFondo, btnLogros;
	private SpriteBatch batch;
	private Stage stage;
	private nidoActor marcador;
	private BitmapFont texto;	
	private int mostrarLogro;
	private boolean logroNuevo;
	
	public resumenScreen(Principal game) {
		super(game);
		batch = new SpriteBatch();
	}
	
	@Override
	public void render(float delta) {
		
		stage.draw();
		
		if(logroNuevo){
			batch.begin();
			mostrarLogroConseguido();
			batch.end();
		}
		
		
		
	/*	for(int i = 0; i < 11; i++){
			//if(game.logrosArray[i])
			texto.setColor(Color.BLACK);
			
			texto.draw(batch, "["+i+"] "+game.logrosArray[i], 32, 32+32*i);
			
		}
		batch.end();*/	
	}

	@Override
	public void show() {
		
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
		marcador = new nidoActor(this.game);
		stage.addActor(marcador);
		btnLogros = new Image(game.assets.manager.get("btnLogros.png", Texture.class));
		Image btnGo = new Image(game.assets.manager.get("gobtn.png", Texture.class));
		btnGo.setPosition((width/3)*2 - btnGo.getWidth()/2, height - btnGo.getHeight()*4);
		
		Image btnSal = new Image(game.assets.manager.get("boton_off.png", Texture.class));
		btnSal.setPosition(width/3 - btnSal.getWidth()/2 , height - btnSal.getHeight()*4);
		
		btnLogros.setPosition(width/2 - btnSal.getWidth()/2, height - btnSal.getHeight()*6);
		
		stage.addActor(btnGo);
		stage.addActor(btnSal);
		stage.addActor(btnLogros);
		
		btnGo.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
			//	musica.stop();
				if(game.sonido){
					game.assets.manager.get("mus1.mp3", Music.class).stop();

					game.assets.manager.get("click1.wav", Sound.class).play();
				}
				
				game.myRequestHandler.showAds(false);
				game.setScreen(game.pJuego);
				return true;
			}
		});
		
		btnSal.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				if(game.sonido){
					game.assets.manager.get("click1.wav", Sound.class).play();
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				game.myRequestHandler.showAds(false);
				game.setScreen(game.pMenu);
				return true;
			}
		});
	
		texto = new BitmapFont();
		comprobarLogros();
		
		btnLogros.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				
				game.myRequestHandler.showAds(false);
				
				if(game.sonido) {
					game.assets.manager.get("mus1.mp3", Music.class).stop();
					game.assets.manager.get("click1.wav", Sound.class).play();
				}
				game.deDondeVengoLogros = 2;
				game.setScreen(game.pLogros);
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
		
		game.pref.SavePreferences();
		batch.dispose();
		stage.dispose();

		
	}
	
	int ticksMostrar=250;
	
	private void mostrarLogroConseguido(){
		if(ticksMostrar < 200){
			ticksMostrar++;
		
			switch(mostrarLogro){
			case 0: texto.draw(batch, "Logro conseguido: Recién llegado", 100, 100);
					break;
			case 1: texto.draw(batch, "Logro conseguido: Cazador novato", 120, 100);
					break;
			}

		}else{
			ticksMostrar = 0;
			logroNuevo = false;
		}
		
	}
	
	private void comprobarLogros(){
		
		if(game.muertes >= 10 ) game.logrosArray[0] = true;
		if(game.puntosPantalla >= 20) game.logrosArray[1] = true;
		if(game.puntosPantalla >= 60) game.logrosArray[2] = true;
		if(game.puntosPantalla >= 100) game.logrosArray[3] = true;
		if(game.puntosNido >= 10) game.logrosArray[4] = true;
		if(game.puntosNido >= 20) game.logrosArray[5] = true;
		if(game.puntosNido >= 40) game.logrosArray[6] = true;
		if(game.muertes >= 20) game.logrosArray[7] = true;
		if(game.puntosNido >= 100) game.logrosArray[8] = true;
		if(game.muertes >= 100) game.logrosArray[9] = true;
		int cuenta = 0;
		
		for(int i = 0; i < 10; i++){
			if(game.logrosArray[i])
				cuenta++;
				
		}
		
		if(cuenta == 10)
			game.logrosArray[10] = true;
			
	}
	

}
