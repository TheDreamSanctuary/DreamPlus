package com.thedreamsanctuary.main.java.dreamplus.commands;

import com.thedreamsanctuary.main.java.dreamplus.DreamPlus;
import com.thedreamsanctuary.main.java.dreamplus.listener.DPListener;
import static com.thedreamsanctuary.main.java.dreamplus.listener.DPListener.trails;
import java.util.regex.Pattern;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author Ajcool1050
 */

public class DreamTrailCommand implements CommandExecutor 
{

    final DreamPlus dp;
    public DreamTrailCommand(DreamPlus dp)
    {
        this.dp = dp;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String string, String[] args)
    {
        if (sender instanceof Player)
        {
            Player player = (Player) sender;
            if (player.hasPermission("dreamplus.command.dtrail"))
            {
                if (args.length == 1)
                {
                    if (!Pattern.matches("[a-zA-Z]+", args[0])) 
                    {
                        if (args[0].contains(":"))
                        {
                            DPListener.addPlayerToMap(player, args[0], trails);
                        }
                        else
                        {
                            DPListener.addPlayerToMap(player, args[0], trails);
                        }
                    }
                    else if (args[0].toLowerCase().equals("off")) DPListener.removePlayerFromMap(player, trails);
                    else player.sendMessage(ChatColor.GOLD + "Usage: /dtrail [Trail]or[Block Id:Data]]");
                }
                else player.sendMessage(ChatColor.GOLD + "Usage: /dtrail [Trail]or[Block Id:Data]");
            }
            else player.sendMessage(ChatColor.GOLD +  "You are not able to execute that command.");
        } 
        else sender.sendMessage("Must be and ingame player to execute command.");
        return false;
    }
}
