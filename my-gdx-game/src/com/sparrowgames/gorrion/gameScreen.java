package com.sparrowgames.gorrion;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import java.util.ArrayList;
import java.util.List;

public class gameScreen extends AbstractScreen {

	private Stage stage;
	private SpriteBatch batch;
	private playerActor player;
	
	private puntuacionActor puntuacion;
	private List<bichoActor> bichos;
	private float timer;
	private barraNido bNido;
	private Principal game;
	
	public gameScreen(Principal game) {
		super(game);
		this.game = game;
	}

	@Override
	public void render(float delta) {
		
		int width = Gdx.graphics.getWidth();
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		if(imgFondo3.getX()+imgFondo3.getWidth() <0){
			imgFondo3.setX(width);
		}else{
			imgFondo3.setX(imgFondo3.getX()-1);
		}
		if(imgFondo33.getX()+imgFondo33.getWidth() <0){
			imgFondo33.setX(width);
		}else{
			imgFondo33.setX(imgFondo33.getX()-1);
		}
		if(imgFondo2.getX()+ imgFondo2.getWidth() < 0){
			imgFondo2.setX(width);
		}else{
			imgFondo2.setX(imgFondo2.getX()-2);
		}
		if(imgFondo22.getX() + imgFondo22.getWidth() < 0){
			imgFondo22.setX(width);
		}else{
			imgFondo22.setX(imgFondo22.getX()-2);
		}
			
		if(timer > 35 && player.darGravedad()){
			crearBicho();
			timer = 0;
			imgInstrucc.remove();
		}else
			timer++;
		comprobarColisiones();
		comprobarListas();
		bVida.actualizar(player.hambre);	
		if(player.getY() + player.getHeight() < 0){
			
			if(game.sonido){
				game.assets.manager.get("Shut_Down1.wav", Sound.class).play();
			
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				game.assets.manager.get("mus2.mp3", Music.class).stop();
				
			}
			
			game.muertes++;
			if(game.puntosPantalla > game.maxPantalla)
				game.maxPantalla = game.puntosPantalla;
			game.setScreen(game.pResumen);
		}
		if(player.graciaNido >= 0)
			bNido.update(player.graciaNido);
		else
			bNido.visible = false;
		
		stage.draw();

	}

	private Image imgFondo1;
	private Image imgFondo2;
	private Image imgFondo22;
	private Image imgFondo3;
	private Image imgFondo33;
	private Image imgInstrucc;
	

	private barraVida bVida;
	
	@Override
	public void show() {
		
		if(game.sonido){
			game.assets.manager.get("mus2.mp3", Music.class).setLooping(true);
			game.assets.manager.get("mus2.mp3", Music.class).play();
		}
		bichos = new ArrayList<bichoActor>();
		 
		int width = 640;
		int height = 480;
		stage = new Stage(0, 0, true, batch);
		stage.setViewport(640, 480);
		Gdx.input.setInputProcessor(stage);
		
		
		
		imgFondo1 = new Image(game.assets.manager.get("cielo.png", Texture.class));
		imgFondo1.setFillParent(true);
		stage.addActor(imgFondo1);
		
		if(game.idiomaENG)
			imgInstrucc = new Image(game.assets.manager.get("instrucc_en.png", Texture.class));
		else
			imgInstrucc = new Image(game.assets.manager.get("instrucc.png", Texture.class));
		
		
		imgFondo2 = new Image(game.assets.manager.get("ciudad.png", Texture.class));
		imgFondo22 = new Image(game.assets.manager.get("ciudad.png", Texture.class));
		imgFondo2.setFillParent(true);
		imgFondo22.setFillParent(true);
		
		stage.addActor(imgFondo2);
		imgFondo22.setPosition(width, imgFondo22.getY());
		stage.addActor(imgFondo22);
		
		player = new playerActor(game);
		stage.addActor(player);
		
		imgFondo33 = new Image(game.assets.manager.get("fondonuves.png", Texture.class));
		imgFondo3 = new Image(game.assets.manager.get("fondonuves.png", Texture.class));
		imgFondo3.setFillParent(true);
		imgFondo33.setFillParent(true);
		stage.addActor(imgFondo3);
		imgFondo33.setPosition(width, imgFondo3.getY());
		stage.addActor(imgFondo33);
			
		imgInstrucc.setPosition(0, height - imgInstrucc.getHeight());
		stage.addActor(imgInstrucc);
		
			Image btnSalir = new Image(game.assets.manager.get("salir.png", Texture.class));
		btnSalir.setSize(32, 32);
		btnSalir.setPosition(width-btnSalir.getWidth(), height-btnSalir.getHeight());
		stage.addActor(btnSalir);
		btnSalir.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				//Gdx.app.exit();
				
				if(game.sonido){
					game.assets.manager.get("click1.wav", Sound.class).play();
					game.assets.manager.get("mus2.mp3", Music.class).stop();
				}
				game.setScreen(game.pResumen);
				return true;
			}
		});
		
		puntuacion = new puntuacionActor(new BitmapFont(), game.idiomaENG);
		game.puntosPantalla = game.puntosParcial = puntuacion.puntuacion;
		puntuacion.setPosition(10, stage.getHeight() - 10);
		stage.addActor(puntuacion);
		stage.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// CLICK
								player.cambiarGravedad();
				return true;
			}
		});
		
		bVida = new barraVida(game);
		bVida.setPosition(10, stage.getHeight() - 40);
		stage.addActor(bVida);
		
		bNido = new barraNido(game);
		bNido.setPosition(bVida.getRight()+10,  stage.getHeight() - 40);
		bNido.visible = false;
		stage.addActor(bNido);
	}
	
	private void crearBicho() {
		bichoActor bicho = new bichoActor(game);
		bicho.setPosition(stage.getWidth(), 0.1f * stage.getHeight() + 
				0.8f * stage.getHeight() * (float) Math.random());
		
		bicho.bb.x = bicho.getX();
		bicho.bb.y = bicho.getY();
		bicho.activo=true;
		stage.addActor(bicho);
		bichos.add(bicho);
		
	}
	
	private void comprobarListas() {
		for(int i = 0; i < bichos.size(); i++) {
			if(bichos.get(i).getRight() < 0) {
				bichos.get(i).remove();
				bichos.remove(i);
				
			}
		}
		
	}
	private void comprobarColisiones() {
		bichoActor b;
		for(int i = 0; i < bichos.size(); i++) {
			b = bichos.get(i);
			
			 
			
			if(b.bb.overlaps(player.bb) && b.activo) {
			   			   
				if(player.graciaNido >= 0){
					b.activo = false;
					if(game.sonido) {
						game.assets.manager.get("vaalnido.wav", Sound.class).play();
					}
				}else{
					b.remove();
					bichos.remove(i);
				}
				/*if(player.hambre >= 120){
					 game.puntosNido++;
					 game.puntosParcial++;
			    }*/
							
				if(player.hambre + 30 < 128){
					player.hambre += 30;
				
				}else{
					player.hambre = 128;
				}
				
				if(player.hambre >= 128){
					if(!bNido.visible){
						player.graciaNido = 3;
						bNido.visible = true;
					}else{
						
					}
					
					bNido.update(player.graciaNido);
				}
			
				 puntuacion.puntuacion++;
				 game.puntosPantalla = puntuacion.puntuacion;
			 
				 if(game.sonido){
					 game.assets.manager.get("comebicho.mp3", Sound.class).play();
				 }
			}
		
			if(b.activo==false){
				
				if(b.getY() < bNido.getY())
					b.setY(b.getY()+7);
				if(b.getX() > bNido.getX())
						b.setX(b.getX()-7);
				
				if(b.getY() >= bNido.getY() && b.getX() <= bNido.getX()){
					if(game.sonido) {
						game.assets.manager.get("bichonido.wav", Sound.class).play();
					}
					game.puntosNido++;
					game.puntosParcial++;
					b.remove();
					bichos.remove(i);
				}
				
			}
		
		}//fin for
		
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
