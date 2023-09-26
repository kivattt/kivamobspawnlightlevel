package com.kiva.kivamobspawnlightlevel;

import com.fox2code.foxloader.loader.Mod;

public class KivaMobSpawnLightLevel extends Mod {
    public static int mobSpawnLightLevel = 7; // Default value used in the server code
    public static String version = "1.0.0";
    public void onPreInit() {
        System.out.println("KivaMobSpawnLightLevel initializing...");
    }
}
