package com.sparrowgames.gorrion;

import com.badlogic.gdx.Game;

public class Principal extends Game {

	public Manager assets;
	public int puntosNido;
	public int puntosPantalla;
	public int puntosParcial;
	public opciones pref;
	public boolean sonido;
	public boolean idiomaENG;
	public int muertes;
	public int maxPantalla;
	public boolean logrosArray[];
	public int deDondeVengoLogros;
	
	public IActivityRequestHandler myRequestHandler;
	
	public Principal(IActivityRequestHandler handler) {
		// TODO Auto-generated constructor stub
		 myRequestHandler = handler;
	}
	
	public AbstractScreen pLoading, pMenu, pJuego, pResumen, pOpciones, pConfirma, pLogros;
	
	@Override
	public void create() {

		myRequestHandler.showAds(false);
		logrosArray = new boolean[11];
		pref = new opciones(this);	
		assets = new Manager();
		pLoading = new logoCargando(this);
		pMenu = new mainMenu(this);
		pJuego = new gameScreen(this);
		pResumen = new resumenScreen(this);
		pOpciones = new opcionesScreen(this);
		pConfirma = new confirmacionScreen(this);
		pLogros = new logrosScreen(this);
		assets.loadAssets();
		pref.GetPreferences();
		setScreen(pLoading);
		
		
	}
	
	@Override
	public void dispose() {
		pref.SavePreferences();
		super.dispose();
		assets.manager.dispose();
		
	}
}

