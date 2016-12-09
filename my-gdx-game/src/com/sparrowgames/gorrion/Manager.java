package com.sparrowgames.gorrion;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class Manager {
	
    public AssetManager manager;
    
   
    public Manager(){
        manager = new AssetManager();
        manager.load("logo.png",Texture.class); 
    }
    
    public void loadAssets() {
     
         manager.load("fondo.png",Texture.class);
         manager.load("fondo_en.png",Texture.class);
         manager.load("pajaro.png",Texture.class);
         manager.load("fondo_resumen.png",Texture.class);
         manager.load("salir.png",Texture.class);
         manager.load("instrucc.png",Texture.class);
         manager.load("instrucc_en.png",Texture.class);
         manager.load("gobtn.png",Texture.class);
         manager.load("boton_off.png",Texture.class);
         manager.load("boton_go.png",Texture.class);
         manager.load("salbtn.png",Texture.class);
         manager.load("fondonuves.png",Texture.class);
         manager.load("cielo.png",Texture.class);
         manager.load("nido.png",Texture.class);
         manager.load("audio.png",Texture.class);
         manager.load("reset.png",Texture.class);
         manager.load("btnajustes.png",Texture.class);
         manager.load("ciudad.png",Texture.class);
         manager.load("bugs.png",Texture.class);
         manager.load("vida.png",Texture.class);
         manager.load("barranido.png",Texture.class);
         manager.load("si.png",Texture.class);
         manager.load("no.png",Texture.class);
         manager.load("info.png",Texture.class);
         manager.load("idioma.png",Texture.class);
         manager.load("btnLogros.png",Texture.class);
         manager.load("logros.png",Texture.class);
         
         manager.load("click1.wav", Sound.class);
         manager.load("fx02.wav", Sound.class);
         manager.load("comebicho.mp3", Sound.class);
         manager.load("Shut_Down1.wav", Sound.class);
         manager.load("bichonido.wav", Sound.class);
         manager.load("vaalnido.wav", Sound.class);
                  
         manager.load("mus1.mp3", Music.class);
         manager.load("mus2.mp3", Music.class);
     }

}