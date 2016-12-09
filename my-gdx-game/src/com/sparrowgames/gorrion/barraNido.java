package com.sparrowgames.gorrion;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class barraNido extends Actor {

	private TextureRegion imgnido;
	public boolean visible;
	
	public barraNido(Principal game) {
		// TODO Auto-generated constructor stub
		
		imgnido = new TextureRegion(game.assets.manager.get("barranido.png",
				Texture.class), 128 , 32);
		setSize(32,32);
		//imgnido.setRegion(0, 0, 32, 32);
	}
	
	public void update(int e){
		imgnido.setRegion(32*e, 0, 32, 32);
	}
	
	
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		if(visible){
			batch.draw(imgnido, getX(), getY(), getOriginX(), getOriginY(),
				getWidth(), getHeight(), getScaleX(), getScaleY(),
				getRotation());
		}
	}
}
