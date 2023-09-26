package com.kiva.kivamobspawnlightlevel;

import com.fox2code.foxloader.loader.ServerMod;
import com.fox2code.foxloader.network.NetworkPlayer;
import com.fox2code.foxloader.registry.CommandCompat;
import com.kiva.kivamobspawnlightlevel.commands.GetMobSpawnLightLevel;
import com.kiva.kivamobspawnlightlevel.commands.KivaMobSpawnLightLevelVersion;
import com.kiva.kivamobspawnlightlevel.commands.SetMobSpawnLightLevel;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class KivaMobSpawnLightLevelServer extends KivaMobSpawnLightLevel implements ServerMod {
    public void onInit(){
        Integer loadedLightLevel = FileWriteAndLoadInteger.loadIntegerFromFile("mods/KivaMobSpawnLightLevel/lightlevel.txt");
        if (loadedLightLevel != null)
            KivaMobSpawnLightLevel.mobSpawnLightLevel = loadedLightLevel;

        CommandCompat.registerCommand(new KivaMobSpawnLightLevelVersion());
        CommandCompat.registerCommand(new GetMobSpawnLightLevel());
        CommandCompat.registerCommand(new SetMobSpawnLightLevel());

        System.out.println("KivaMobSpawnLightLevel initialized");
    }

    @Override // TODO: Check if this is necessary or not
    public void onServerStop(NetworkPlayer.ConnectionType connectionType){
        super.onServerStop(connectionType);

        // Make sure mods/KivaMobSpawnLightLevel directory exists
        Path modsPath = Paths.get("mods/KivaMobSpawnLightLevel");
        try {
            Files.createDirectory(modsPath);
        } catch (IOException e){
            if (!(e instanceof FileAlreadyExistsException)) {
                e.printStackTrace();
                return;
            }
        }

        FileWriteAndLoadInteger.writeIntegerToFile(KivaMobSpawnLightLevel.mobSpawnLightLevel, "mods/KivaMobSpawnLightLevel/lightlevel.txt");
    }
}
