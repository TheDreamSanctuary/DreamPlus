package com.thedreamsanctuary.main.java.dreamplus.executors;

import com.thedreamsanctuary.main.java.dreamplus.DreamPlus;
import com.thedreamsanctuary.main.java.dreamplus.effect.ParticleEffect;
import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * @author Ajcool1050
 */

public class DPFood 
{  
    final DreamPlus dp;
    public DPFood(DreamPlus dp)
    {
        this.dp = dp;
    }
    
    public static boolean eatPopper(Player player) 
    {
        player.sendMessage(ChatColor.GOLD + "Your mouth is on fire!");
        ParticleEffect.FLAME.display(player.getEyeLocation(), 0.5F, 0.5F, 0.5F, 0.5F, 15);
        player.setFireTicks(80);
        return true;
    }

    public static boolean drinkWine(Player player, int seconds) 
    {
        int ticks = seconds * 20;
        player.sendMessage(ChatColor.GOLD + "You feel rather tipsy!");
        PotionEffect confEffect = new PotionEffect(PotionEffectType.CONFUSION, ticks, 1);
        confEffect.apply(player);
        return true;
    }
    
    public static boolean drinkLager(Player player, int seconds) 
    {
        int ticks = seconds * 20;
        player.sendMessage(ChatColor.GOLD + "You feel drunk!");
        PotionEffect confEffect = new PotionEffect(PotionEffectType.CONFUSION, ticks, 2);
        confEffect.apply(player);
        
        return true;  
    }
    
    public static boolean drinkLagerEmpty(Player player) 
    {  
        World world = player.getWorld();
        player.sendMessage(ChatColor.GOLD + "Your stien is empty but, you got the last drop!");
        PotionEffect confEffect = new PotionEffect(PotionEffectType.CONFUSION, 120, 1);
        confEffect.apply(player);
        world.playEffect(player.getLocation(),Effect.POTION_BREAK,1, 5);
        return true;  
    }
    
    public static boolean drinkCoffee(Player player, int seconds)
    {
        int ticks = seconds * 20;
        player.sendMessage(ChatColor.GOLD + "You feel energyzed!");
        player.removePotionEffect(PotionEffectType.CONFUSION);
        PotionEffect speedEffect = new PotionEffect(PotionEffectType.SPEED, ticks, 10);
        PotionEffect jumpEffect = new PotionEffect(PotionEffectType.JUMP, ticks, 5);
        speedEffect.apply(player);
        jumpEffect.apply(player);
        return true; 
    }
    
    public static boolean drinkSoda(Player player)
    {
        player.sendMessage(ChatColor.GOLD + "You feel rather smurfy!");
        sodaSpeak(player);
        return true;
    }
    
    public static boolean sodaSpeak(Player player)
    {
        Random random = new Random();
        int number = random.nextInt(50) + 1;
        if(number == 10) player.chat(ChatColor.AQUA + "haw i get bl0x???"); 
        if(number == 20) player.chat(ChatColor.AQUA + "can haz op????"); 
        if(number == 30) player.chat(ChatColor.AQUA + "whear do pvp"); 
        if(number == 40) player.chat(ChatColor.AQUA + "t/ell " + player.getName() + " can build on my serwer??"); 
        if(number == 50) player.chat(ChatColor.AQUA + "who iz mod?"); 
        return true;
    }
    
    public static boolean eatIceCream(Player player)
    {
        player.sendMessage(ChatColor.GOLD + "You feel the neutron in your veins!");
        PotionEffect speedEffect = new PotionEffect(PotionEffectType.SPEED, 200, 10);
        PotionEffect jumpEffect = new PotionEffect(PotionEffectType.JUMP, 200, 5);
        speedEffect.apply(player);
        jumpEffect.apply(player);
        
        return true; 
    }
}
