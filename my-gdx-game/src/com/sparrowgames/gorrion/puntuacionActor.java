package com.sparrowgames.gorrion;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class puntuacionActor extends Actor {

	public int puntuacion;
	private boolean idioma;
	private BitmapFont font;

	public puntuacionActor(BitmapFont font, Boolean i) {
		this.font = font;
		puntuacion = 0;
		idioma = i;
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		if(idioma)
			font.draw(batch, "BUGS: " + puntuacion, getX(), getY());
		else
			font.draw(batch, "BICHOS: " + puntuacion, getX(), getY());
	}
	
}
