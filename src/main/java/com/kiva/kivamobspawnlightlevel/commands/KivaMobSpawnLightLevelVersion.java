package com.kiva.kivamobspawnlightlevel.commands;

import com.fox2code.foxloader.network.ChatColors;
import com.fox2code.foxloader.network.NetworkPlayer;
import com.fox2code.foxloader.registry.CommandCompat;
import com.kiva.kivamobspawnlightlevel.KivaMobSpawnLightLevel;

public class KivaMobSpawnLightLevelVersion extends CommandCompat {
    public KivaMobSpawnLightLevelVersion(){
        super("kivamobspawnlightlevelversion", false);
    }

    public String commandSyntax(){
        return "§e/kivamobspawnlightlevelversion";
    }

    public void onExecute(final String[] args, final NetworkPlayer commandExecutor){
        commandExecutor.displayChatMessage(ChatColors.GREEN + "KivaMobSpawnLightLevel" + ChatColors.RESET + " is on version " + ChatColors.YELLOW + KivaMobSpawnLightLevel.version + ChatColors.RESET);
    }
}
