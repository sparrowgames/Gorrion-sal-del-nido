package com.sparrowgames.gorrion;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class cartelLogros extends Actor {
	
	private Principal game;
	private BitmapFont texto;
	private TextureRegion imgFondo;
	
	public cartelLogros(Principal game) {
		// TODO Auto-generated constructor stub
		this.game = game;
		imgFondo = new TextureRegion(game.assets.manager.get("logros.png", Texture.class),256,128);
		imgFondo.setRegion(0, 0, 256, 128);
		
		setSize(imgFondo.getRegionWidth(), imgFondo.getRegionHeight());
		setPosition(640/2 - imgFondo.getRegionWidth()/2 ,260);
		texto = new BitmapFont();
		texto.setScale(1, 1);
		setX(50);
		setY(180);
		setHeight(275);
		
		
	}
	
	

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		/*		imgLogros.setWidth(550);
		imgLogros.setHeight(275);
		imgLogros.setPosition(50, 180);*/
		super.draw(batch, parentAlpha);
		batch.draw(imgFondo, getX(), getY(), getOriginX(), getOriginY(),
				550, 275, getScaleX(), getScaleY(),
				getRotation());
		if(game.idiomaENG)
			mostrarLogrosENG(batch);
		else
			mostrarLogrosESP(batch);
		
	}

	private float linea;
	
private void mostrarLogrosESP(SpriteBatch batch){
	
		linea = getTop() - 25;
	
		if(game.logrosArray[0])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		texto.drawMultiLine(batch, "Recién llegado (Muere 10 veces): " + game.muertes + "/10", getX()+90, linea);
				
		if(game.logrosArray[1])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		linea = linea - 20;
		texto.draw(batch, "Cazador novato (Coge 20 bichos de un intento): " + game.maxPantalla + "/20", getX()+90, linea);
		
		if(game.logrosArray[2])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		linea = linea - 20;
		texto.draw(batch, "Mejorando día a día (Coge 60 bichos de un intento): " + game.maxPantalla + "/60", getX()+90, linea);
		
		if(game.logrosArray[3])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		linea = linea - 20;
		texto.draw(batch, "Cazador profesional (Coge 100 bichos de un intento): " + game.maxPantalla + "/100", getX()+90, linea);
		if(game.logrosArray[4])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		linea = linea - 20;
		texto.draw(batch, "Generoso (Envia 10 bichos al nido): " + game.puntosNido + "/10", getX()+90, linea);
		
		if(game.logrosArray[5])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		linea = linea - 20;
		texto.draw(batch, "Muy generoso (Envia 20 bichos al nido): " + game.puntosNido + "/20", getX()+90, linea);
		
		if(game.logrosArray[6])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		linea = linea - 20;
		texto.draw(batch, "Piensa en los demás (Envia 40 bichos al nido): " + game.puntosNido + "/40", getX()+90, linea);
		
		if(game.logrosArray[7])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		linea = linea - 20;
		texto.draw(batch, "Insistente (Muere 20 veces): " + game.muertes + "/20", getX()+90, linea);
		
		if(game.logrosArray[8])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		linea = linea - 20;
		texto.draw(batch, "Robin Gorriónhood (envia 100 bichos al nido): " + game.puntosNido + "/100", getX()+90, linea);
		
		if(game.logrosArray[9])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		linea = linea - 20;
		texto.draw(batch, "Tozudo (Muere 100 veces): " + game.muertes + "/100", getX()+90, linea);
		
		if(game.logrosArray[10])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		linea = linea - 20;
		texto.draw(batch, "Maestro gorrión (Consigue todos los logros): 0/11", getX()+90, linea);
		
	}

	private void mostrarLogrosENG(SpriteBatch batch){

		linea = getTop() - 25;
		
		if(game.logrosArray[0])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		texto.draw(batch, "Newcomer (Die 10 times): " + game.muertes + "/10", getX()+90, linea);
		
		if(game.logrosArray[1])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		linea = linea - 20;
		texto.draw(batch, "Rookie hunter (Take 20 bugs in a try): " + game.maxPantalla + "/20", getX()+90, linea);
		
		if(game.logrosArray[2])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		linea = linea - 20;
		texto.draw(batch, "Improving day by day (Take 60 bugs in a try): " + game.maxPantalla + "/60", getX()+90, linea);
		
		if(game.logrosArray[3])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		linea = linea - 20;
		texto.draw(batch, "Professional hunter (Take 100 bugs in a try): " + game.maxPantalla + "/100", getX()+90, linea);
		
		if(game.logrosArray[4])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		linea = linea - 20;
		texto.draw(batch, "Generous (Send 10 bugs to nest): " + game.puntosNido + "/10", getX()+90, linea);
		
		if(game.logrosArray[5])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		linea = linea - 20;
		texto.draw(batch, "Very generous (Send 20 bugs to nest): " + game.puntosNido + "/20", getX()+90, linea);
		
		if(game.logrosArray[6])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		linea = linea - 20;
		texto.draw(batch, "Thinking of others (Send 40 bugs to nest): " + game.puntosNido + "/40", getX()+90, linea);
		
		if(game.logrosArray[7])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		linea = linea - 20;
		texto.draw(batch, "Insistent (Die 20 times): " + game.muertes + "/20", getX()+90, linea);
		
		if(game.logrosArray[8])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		linea = linea - 20;
		texto.draw(batch, "Robin Sparrowhood (Send 100 bugs to nest): " + game.puntosNido + "/100", getX()+90, linea);
		
		if(game.logrosArray[9])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		linea = linea - 20;
		texto.draw(batch, "Stubbom (Die 100 times): " + game.muertes + "/100", getX()+90, linea);
		
		if(game.logrosArray[10])
			texto.setColor(Color.GREEN);
		else
			texto.setColor(Color.RED);
		
		linea = linea - 20;
		texto.draw(batch, "Master sparrow (Get all achievements): 0/11", getX()+90, linea);

	}

	
}
