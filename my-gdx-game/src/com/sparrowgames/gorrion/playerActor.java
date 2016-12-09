package com.sparrowgames.gorrion;


import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class playerActor extends Actor {
	private int caida;
	private int width = 640, heigth = 480;
	private int ticks=41;
	private boolean gravedad = false;
	public Rectangle bb;
	private TextureRegion player;
	private int anim = 0;
	public int hambre=128;
	private Principal game;
	private boolean inicio  = false;
	public int graciaNido;
	
	
	public playerActor(Principal game) {
		this.game = game;
		player = new TextureRegion(game.assets.manager.get("pajaro.png",
				Texture.class), 64 , 67);
		setSize(player.getRegionWidth(), player.getRegionHeight());
		
		setX((width / 2) - getWidth());
		setY(heigth / 2);
		player.setRegion(2 * 64, 0, 64, 67);
		bb = new Rectangle(getX(), getY(), getWidth(), getHeight());
		gravedad=false;
		inicio = false;
		


	}

	public void cambiarGravedad(){
		
		inicio = gravedad = true;
		
		if(hambre > 0){
			if(graciaNido >= 0){
				graciaNido--;
				hambre-=5;
			}else{
				hambre-=10;
			}
			if(game.sonido){
				game.assets.manager.get("fx02.wav", Sound.class).play();
			}
			gravedad = false;
			ticks =0;
			
		}else{
			hambre = 0;			
		}
	}

	public void update(){
	  if(inicio){	
		if(gravedad){
			setY(getY()- caida);
			if(this.getRotation() > -90){
				this.rotate(-2);
			}
			if(caida < 4)
				caida++;
			
		}else{
			if(ticks < 20){
				this.setRotation(5);
				if(getY() + getHeight() + 2 < 480){
					setY(getY()+2);
				
				}else{
					setY(480-getHeight());
				}
				ticks++;
			}else{
				gravedad = true;
				this.setRotation(0);
				caida = 2;
			}
		}
	  }
		if(anim+1 > 30){
			anim=0;
		}else{
			anim++;
		}
		player.setRegion(anim/10 * 64, 0, 64, 67);
		bb.x = getX();
		bb.y = getY();
		bb.width = getWidth();
		bb.height = getHeight();
	  
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		update();
		batch.draw(player, getX(), getY(), getOriginX(), getOriginY(),
				getWidth(), getHeight(), getScaleX(), getScaleY(),
				getRotation());

	}
	
	public boolean darGravedad(){
		return inicio;
	}
	
	
}
