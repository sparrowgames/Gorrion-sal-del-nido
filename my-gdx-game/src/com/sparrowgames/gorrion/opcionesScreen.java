package com.sparrowgames.gorrion;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class opcionesScreen extends AbstractScreen {

	private Image imgFondo;
	private SpriteBatch batch;
	private Stage stage;	
	private BitmapFont texto;
	public opcionesScreen(Principal game) {
		super(game);
		batch = new SpriteBatch();
		texto = new BitmapFont();
	}
		
	@Override
	public void render(float delta) {
			stage.draw();
	}

	Image btnRst, btnSal, btnSo, btnIdioma;
	
	@Override
	public void show() {

		game.myRequestHandler.showAds(true);
		
		stage = new Stage(0, 0, true, batch);
		stage.setViewport(640, 480);
		Gdx.input.setInputProcessor(stage);
		
		imgFondo = new Image(game.assets.manager.get("cielo.png", Texture.class));
		imgFondo.setFillParent(true);
		stage.addActor(imgFondo);
		
		btnSal = new Image(game.assets.manager.get("boton_off.png", Texture.class));
		btnRst = new Image(game.assets.manager.get("reset.png", Texture.class));
				
		TextureRegion btnAudio = new TextureRegion(game.assets.manager.get("audio.png", Texture.class), 64,64);
		
		TextureRegion btnIdiomaTR = new TextureRegion(game.assets.manager.get("idioma.png", Texture.class), 64,64);
		
		
		if(game.idiomaENG)
			btnIdiomaTR.setRegion(64, 0, 64, 64);
		else
			btnIdiomaTR.setRegion(0, 0, 64, 64);
		
		btnIdioma = new Image(btnIdiomaTR);
		
		if(game.sonido){
			btnAudio.setRegion(0, 0, 64, 64);
		}else{
			btnAudio.setRegion(64, 0, 64, 64);
		}
		
		btnSo = new Image(btnAudio);
		
		
		btnIdioma.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				if(game.sonido) {
					game.assets.manager.get("click1.wav", Sound.class).play();
				}
				
				if(game.idiomaENG)
					game.idiomaENG = false;
				else
					game.idiomaENG = true;
				
				game.setScreen(game.pOpciones);
				return true;
			}
			
		});
		
		btnSo.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				if(game.sonido) {
					game.assets.manager.get("click1.wav", Sound.class).play();
					game.sonido = false;
					game.assets.manager.get("mus1.mp3", Music.class).stop();
				}else{
					game.sonido = true;
					game.assets.manager.get("mus1.mp3", Music.class).play();
				}
				game.setScreen(game.pOpciones);
				return true;
			}
			
		});
		

		btnRst.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				if(game.sonido) {
					game.assets.manager.get("click1.wav", Sound.class).play();
				}
				
			//	game.puntosNido = 0;
				
				game.myRequestHandler.showAds(false);
				game.setScreen(game.pConfirma);
				return true;
			}
			
		});
		
		btnSal.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				if(game.sonido) {
					game.assets.manager.get("click1.wav", Sound.class).play();
				}
				
				game.myRequestHandler.showAds(false);
				game.setScreen(game.pMenu);
				return true;
			}
		});

		/*if(Gdx.app.getType() == ApplicationType.Android) {
			
			colocarBotonesAndroid();
			
		}else if(Gdx.app.getType() == ApplicationType.Desktop){
			
			colocarBotonesDesktop();
			
		}*/
		
		colocarBotonesAndroid();
		
		stage.addActor(btnSo);
		stage.addActor(btnRst);
		stage.addActor(btnSal);
		stage.addActor(btnIdioma);
	}

/*private void colocarBotonesDesktop(){
		
		int width = Gdx.graphics.getWidth();
		int height = Gdx.graphics.getHeight();
		
		btnSo.setPosition(width/3 - btnSo.getWidth()/2 , height/2 - btnSo.getHeight());
	
		btnRst.setPosition(width/2 - btnRst.getWidth()/2, height/2 - btnRst.getHeight());
	
		btnSal.setPosition((width/3)*2 - btnSal.getWidth()/2, height/2 - btnSal.getHeight());
	}*/

	private void colocarBotonesAndroid(){
		
		int width = 640;
		int height = 480;
		
		btnSo.setPosition(width/3 - btnSo.getWidth()/2 , height /2);
	
		btnRst.setPosition((width/3)*2 - btnRst.getWidth()/2, height/2);
	//(width/2 - btnRst.getWidth()/2, height - btnRst.getHeight()*6);
		btnSal.setPosition(width/2 - btnSal.getWidth()/2, height - btnSal.getHeight()*6);
		
		btnIdioma.setPosition(width/2 - btnIdioma.getWidth()/2, height/2);
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

}
