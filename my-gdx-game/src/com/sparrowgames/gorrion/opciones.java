package com.sparrowgames.gorrion;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class opciones {
	private Principal game;
	private Preferences pref;
	
	public opciones(Principal game) {
		this.game = game;
		pref = Gdx.app.getPreferences("preferencias-gorrion");
	}
	
	public void GetPreferences(){
           game.puntosNido = pref.getInteger("nido", 0); 
           game.maxPantalla = pref.getInteger("maxPantalla", 0);
           game.muertes = pref.getInteger("muertes", 0);
           game.sonido = pref.getBoolean("sonido", true);
           game.idiomaENG = pref.getBoolean("idioma",false);
           
           for(int i = 0; i < 11; i++){
        	   game.logrosArray[i] = pref.getBoolean("logro"+i, false);        	   
   		   }
  }
	public void SavePreferences(){
		pref.putInteger("nido", game.puntosNido);
		pref.putInteger("maxPantalla", game.maxPantalla);
		pref.putInteger("muertes", game.muertes);
		pref.putBoolean("sonido", game.sonido);
		pref.putBoolean("idioma", game.idiomaENG);
		
		for(int i = 0; i < 11; i++){
			pref.putBoolean("logro"+i, game.logrosArray[i]);
		}
		pref.flush();
	}
}
