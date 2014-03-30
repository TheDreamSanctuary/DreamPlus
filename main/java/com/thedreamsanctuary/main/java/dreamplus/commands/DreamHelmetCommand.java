package com.thedreamsanctuary.main.java.dreamplus.commands;

import com.thedreamsanctuary.main.java.dreamplus.DreamPlus;
import java.util.regex.Pattern;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * @author Ajcool1050
 */
public class DreamHelmetCommand implements CommandExecutor 
{
    final DreamPlus dp;
    public DreamHelmetCommand(DreamPlus dp)
    {
        this.dp = dp;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String string, String[] args)
    {
        if (sender instanceof Player)
        {
            Player player = (Player) sender;
            if (player.hasPermission("voxelplus2.command.vhelm"))
            {
                if (args.length < 1)
                {
                    Material itemID = player.getInventory().getItemInHand().getType();
                    if (itemID == Material.AIR) player.sendMessage(ChatColor.GOLD + "You can't put air on your head silly."); 
                    else
                    {
                        short itemData = player.getInventory().getItemInHand().getDurability();
                        ItemStack itemstack = new ItemStack(itemID, 1, (short) itemData);
                        
                        player.getInventory().setHelmet(itemstack);
                        player.sendMessage(ChatColor.GOLD + "You have somthing on your head. LOL!");
                    }     
                }
                else if (args.length == 1)
                {
                    if (!Pattern.matches("[a-zA-Z]+", args[0])) 
                    {
                        if (args[0].contains(":"))
                        {
                            String[] split = args[0].split(":");
                            int itemID = Integer.parseInt(split[0]);
                            int itemData = Integer.parseInt(split[1]);
                            ItemStack itemstack = new ItemStack(itemID, 1 , (short) itemData);
                            player.getInventory().setHelmet(itemstack);
                            player.sendMessage(ChatColor.GOLD + "You have somthing on your head. LOL!");
                        }
                        else
                        {
                            int itemID = Integer.parseInt(args[0]);
                            ItemStack itemstack = new ItemStack(itemID);
                            player.getInventory().setHelmet(itemstack);
                            player.sendMessage(ChatColor.GOLD + "You have somthing on your head. LOL!");
                        }
                    }
                    else player.sendMessage(ChatColor.GOLD + "Usage: /vhelm [Item Id]");
                }
                else player.sendMessage(ChatColor.GOLD + "Usage: /vhelm [Item Id]");
            }
            else player.sendMessage(ChatColor.GOLD +  "You are not able to execute that command.");
        } 
        else sender.sendMessage("Must be and ingame player to execute command.");
        return false;
    }  
}
