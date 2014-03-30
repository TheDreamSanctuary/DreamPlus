package com.thedreamsanctuary.main.java.dreamplus.commands;

import com.thedreamsanctuary.main.java.dreamplus.DreamPlus;
import com.thedreamsanctuary.main.java.dreamplus.listener.DPListener;
import static com.thedreamsanctuary.main.java.dreamplus.listener.DPListener.glows;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author Ajcool1050
 */

public class DreamGlowCommand implements CommandExecutor 
{

    final DreamPlus dp;
    public DreamGlowCommand(DreamPlus dp)
    {
        this.dp = dp;
    }
    
    private void listMessage(Player player)
    {
        player.sendMessage(ChatColor.GOLD + "Usage: /vglow [Glow]");
        player.sendMessage(ChatColor.DARK_GRAY + "---------=[" + ChatColor.GOLD + "Voxelglows" + ChatColor.DARK_GRAY + "]=---------");
        player.sendMessage(ChatColor.GOLD + "Sparks, Dust, BrownStar, BlueStar");
        player.sendMessage(ChatColor.GOLD + "RedStars, DarkredStar, Note, ,Portal");
        player.sendMessage(ChatColor.GOLD + "Code, Redstone, Derpy, Smoke, Snow");
        player.sendMessage(ChatColor.GOLD + "Love, BlueDust, RedDust, DerpyDust");
        player.sendMessage(ChatColor.GOLD + "Gem, Cloud, Off (Turns Off Trail DUH)");
        player.sendMessage(ChatColor.DARK_GRAY + "------------------------------");
                
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String string, String[] args)
    {
        if (sender instanceof Player)
        {
            Player player = (Player) sender;
            
            if (player.hasPermission("voxelplus2.command.vglow"))
            { 
                if (args.length == 2)
                {
                    Player receiver = player.getServer().getPlayer(args[0]);
                    if (receiver != null) 
                    {
                        DPListener.saveMap(dp, "glow", glows);
                    
                        if (args[0].toLowerCase().equals("sparks")) DPListener.addPlayerToMap(receiver, "sparks", glows);
                        else if (args[0].toLowerCase().equals("dust")) DPListener.addPlayerToMap(receiver, "dust", glows);
                        else if (args[0].toLowerCase().equals("brownstar")) DPListener.addPlayerToMap(receiver, "brownstar", glows);
                        else if (args[0].toLowerCase().equals("bluestar")) DPListener.addPlayerToMap(receiver, "bluestar", glows);
                        else if (args[0].toLowerCase().equals("redstar")) DPListener.addPlayerToMap(receiver, "redstar", glows);
                        else if (args[0].toLowerCase().equals("darkredstar")) DPListener.addPlayerToMap(receiver, "darkredstar", glows);
                        else if (args[0].toLowerCase().equals("note")) DPListener.addPlayerToMap(receiver, "note", glows);
                        else if (args[0].toLowerCase().equals("portal")) DPListener.addPlayerToMap(player, "portal", glows);
                        else if (args[0].toLowerCase().equals("code")) DPListener.addPlayerToMap(receiver, "code", glows);
                        else if (args[0].toLowerCase().equals("redstone")) DPListener.addPlayerToMap(receiver, "redstone", glows);
                        else if (args[0].toLowerCase().equals("derpy")) DPListener.addPlayerToMap(receiver, "derpy", glows);
                        else if (args[0].toLowerCase().equals("snow")) DPListener.addPlayerToMap(receiver, "snow", glows);
                        else if (args[0].toLowerCase().equals("love")) DPListener.addPlayerToMap(receiver, "love", glows);
                        else if (args[0].toLowerCase().equals("bluedust")) DPListener.addPlayerToMap(receiver, "bluedust", glows);
                        else if (args[0].toLowerCase().equals("reddust")) DPListener.addPlayerToMap(receiver, "reddust", glows);
                        else if (args[0].toLowerCase().equals("derpydust")) DPListener.addPlayerToMap(receiver, "derpydust", glows);
                        else if (args[0].toLowerCase().equals("smoke")) DPListener.addPlayerToMap(player, "smoke", glows);
                        else if (args[0].toLowerCase().equals("gem")) DPListener.addPlayerToMap(receiver, "gem", glows);
                        else if (args[0].toLowerCase().equals("cloud")) DPListener.addPlayerToMap(receiver, "cloud", glows); 
                        else if (args[0].toLowerCase().equals("off")) DPListener.removePlayerFromMap(receiver, glows);        
                        else listMessage(player);
                    } else player.sendMessage(ChatColor.GOLD + "That player could not be found.");
                }
                if (args.length == 1)
                {
                    DPListener.saveMap(dp, "glow", glows);
                    
                    if (args[0].toLowerCase().equals("sparks")) DPListener.addPlayerToMap(player, "sparks", glows);
                    else if (args[0].toLowerCase().equals("dust")) DPListener.addPlayerToMap(player, "dust", glows);
                    else if (args[0].toLowerCase().equals("brownstar")) DPListener.addPlayerToMap(player, "brownstar", glows);
                    else if (args[0].toLowerCase().equals("bluestar")) DPListener.addPlayerToMap(player, "bluestar", glows);
                    else if (args[0].toLowerCase().equals("redstar")) DPListener.addPlayerToMap(player, "redstar", glows);
                    else if (args[0].toLowerCase().equals("darkredstar")) DPListener.addPlayerToMap(player, "darkredstar", glows);
                    else if (args[0].toLowerCase().equals("note")) DPListener.addPlayerToMap(player, "note", glows);
                    else if (args[0].toLowerCase().equals("portal")) DPListener.addPlayerToMap(player, "portal", glows);
                    else if (args[0].toLowerCase().equals("code")) DPListener.addPlayerToMap(player, "code", glows);
                    else if (args[0].toLowerCase().equals("redstone")) DPListener.addPlayerToMap(player, "redstone", glows);
                    else if (args[0].toLowerCase().equals("derpy")) DPListener.addPlayerToMap(player, "derpy", glows);
                    else if (args[0].toLowerCase().equals("snow")) DPListener.addPlayerToMap(player, "snow", glows);
                    else if (args[0].toLowerCase().equals("love")) DPListener.addPlayerToMap(player, "love", glows);
                    else if (args[0].toLowerCase().equals("bluedust")) DPListener.addPlayerToMap(player, "bluedust", glows);
                    else if (args[0].toLowerCase().equals("reddust")) DPListener.addPlayerToMap(player, "reddust", glows);
                    else if (args[0].toLowerCase().equals("derpydust")) DPListener.addPlayerToMap(player, "derpydust", glows);
                    else if (args[0].toLowerCase().equals("smoke")) DPListener.addPlayerToMap(player, "smoke", glows);
                    else if (args[0].toLowerCase().equals("gem")) DPListener.addPlayerToMap(player, "gem", glows);
                    else if (args[0].toLowerCase().equals("cloud")) DPListener.addPlayerToMap(player, "cloud", glows); 
                    else if (args[0].toLowerCase().equals("off")) DPListener.removePlayerFromMap(player, glows);    
                    else listMessage(player);
                }
                else listMessage(player);
            }
            else player.sendMessage(ChatColor.GOLD + "You are not able to execute that command.");
        } 
        else sender.sendMessage("Must be and ingame player to execute command.");
        return false;
    } 
}
