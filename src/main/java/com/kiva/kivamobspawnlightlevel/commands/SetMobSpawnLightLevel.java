package com.kiva.kivamobspawnlightlevel.commands;

import com.fox2code.foxloader.network.ChatColors;
import com.fox2code.foxloader.network.NetworkPlayer;
import com.fox2code.foxloader.registry.CommandCompat;
import com.kiva.kivamobspawnlightlevel.KivaMobSpawnLightLevel;

public class SetMobSpawnLightLevel extends CommandCompat {
    public SetMobSpawnLightLevel(){
        super("setmobspawnlightlevel", true);
    }

    public String commandSyntax(){
        return "§e/setmobspawnlightlevel <light level number (inclusive)>";
    }

    public void onExecute(final String[] args, final NetworkPlayer commandExecutor){
        if (args.length != 2){
            commandExecutor.displayChatMessage("§aSyntax: " + commandSyntax());
            return;
        }

        try {
            int lightLevel = Integer.parseInt(args[1]);
            if (lightLevel < 0){
                commandExecutor.displayChatMessage(ChatColors.RED + "Light level can not be negative");
                return;
            }

            KivaMobSpawnLightLevel.mobSpawnLightLevel = lightLevel + 1;
            commandExecutor.displayChatMessage(ChatColors.GREEN + "Mobs will now spawn at light level " + lightLevel);
        } catch (NumberFormatException e){
            commandExecutor.displayChatMessage("§aSyntax: " + commandSyntax());
        }
    }
}
