package com.sparrowgames.gorrion;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class confirmacionScreen extends AbstractScreen {

	
	private Image imgFondo;
	private SpriteBatch batch;
	private Stage stage;
	private BitmapFont texto; 
	
	Image btnSi, btnNo, imgInfo;
	
	public confirmacionScreen(Principal game) {
		super(game);
		// TODO Auto-generated constructor stub
		batch = new SpriteBatch();
	}
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		stage.draw();
		batch.begin();
		

		texto.setColor(Color.RED);
		texto.setScale(2, 2);
		
		if(game.idiomaENG)
			texto.drawMultiLine(batch, "¡ATTENTION!", 155, 285, 200, HAlignment.CENTER);
		else
			texto.drawMultiLine(batch, "¡ATENCION!", 155, 285, 200, HAlignment.CENTER);
		
		texto.setColor(Color.BLACK);
		texto.setScale(1, 1);
		
		if(game.idiomaENG)
		texto.drawMultiLine(batch, "This will erase all the progress, statistics and achievements.\n Are you sure you want to delete?", 175, 250, 200, HAlignment.LEFT);
		else
			texto.drawMultiLine(batch, "Esto borrará todos los avances, estadísticas y logros.\n¿Estás seguro que quieres borrarlos?", 175, 250, 200, HAlignment.LEFT);
		batch.end();
			
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		stage = new Stage(0, 0, true, batch);
		stage.setViewport(640, 480);
		Gdx.input.setInputProcessor(stage);
		
		imgFondo = new Image(game.assets.manager.get("cielo.png", Texture.class));
		imgFondo.setFillParent(true);
		stage.addActor(imgFondo);
		
		btnSi = new Image(game.assets.manager.get("si.png", Texture.class));
		btnNo = new Image(game.assets.manager.get("no.png", Texture.class));
		imgInfo = new Image(game.assets.manager.get("info.png", Texture.class));
		texto = new BitmapFont();
		
		btnSi.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				if(game.sonido) {
					game.assets.manager.get("click1.wav", Sound.class).play();
				}
				
				hacerReset();
				
				game.setScreen(game.pOpciones);
				return true;
			}
			
		});
		
		btnNo.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				if(game.sonido) {
					game.assets.manager.get("click1.wav", Sound.class).play();
				}
				game.setScreen(game.pOpciones);
				return true;
			}
		});

		
		
		colocarBotonesAndroid();
		
		stage.addActor(btnSi);
		stage.addActor(btnNo);
		stage.addActor(imgInfo);
	}

	private void hacerReset(){
		
		game.puntosNido = 0;
		game.muertes = 0;
		game.maxPantalla = 0;
		
		for(int i = 0; i < 11; i++){
			game.logrosArray[i] = false;
		}
		
	}
	
	private void colocarBotonesAndroid(){
		
		int width = 640;
		int height = 480;
		
		imgInfo.setPosition(105, 207);
		
		btnSi.setPosition(width/3 - btnSi.getWidth()/2 , height - btnSi.getHeight()*6);
		
		btnNo.setPosition((width/3)*2 - btnNo.getWidth()/2, height - btnNo.getHeight()*6);
	}
	
	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		game.pref.SavePreferences();
		batch.dispose();
		stage.dispose();
	}

}
