package com.kiva.kivamobspawnlightlevel.commands;

import com.fox2code.foxloader.network.NetworkPlayer;
import com.fox2code.foxloader.registry.CommandCompat;
import com.kiva.kivamobspawnlightlevel.KivaMobSpawnLightLevel;

public class GetMobSpawnLightLevel extends CommandCompat {
    public GetMobSpawnLightLevel(){
        super("getmobspawnlightlevel", false);
    }

    public String commandSyntax(){
        return "§e/getmobspawnlightlevel";
    }

    public void onExecute(final String[] args, final NetworkPlayer commandExecutor){
        // Since lightlevel is used in java.util.random.rand.nextInt(...), the range is 0 to lightlevel - 1
        commandExecutor.displayChatMessage("Mobs will spawn at light level " + (KivaMobSpawnLightLevel.mobSpawnLightLevel - 1) + " or below");
    }
}
