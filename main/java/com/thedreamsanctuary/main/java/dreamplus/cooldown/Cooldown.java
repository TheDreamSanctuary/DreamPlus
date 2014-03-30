package com.thedreamsanctuary.main.java.dreamplus.cooldown;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.bukkit.entity.Player;

/**
 * @author Ajcool1050
 */

public class Cooldown 
{
    private static final Table<String, String, Long> cooldowns = HashBasedTable.create();

    public static long getCooldown(Player player, String key) 
    {
        return checkRemainding(cooldowns.get(player.getName(), key));
    }
    
    public static long setCooldown(Player player, String key, long delay) 
    {

        return checkRemainding(
                cooldowns.put(player.getName(), key, System.currentTimeMillis() + delay));
    }
    
    public static void removeCooldown(Player player) 
    {
        cooldowns.row(player.getName()).clear();
    }
    
    public static boolean Cooldown(Player player, String key, long delay) 
    {
        long seconds = delay * 1000;
        if (getCooldown(player, key) <= 0) {
            setCooldown(player, key, seconds);
            return true;
        }
        return false;
    }
    
    private static long checkRemainding(Long expireTime) 
    {
        return expireTime != null ? expireTime - System.currentTimeMillis() : Long.MIN_VALUE;
    }  
}
