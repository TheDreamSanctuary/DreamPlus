package com.thedreamsanctuary.main.java.dreamplus.listener;

import com.thedreamsanctuary.main.java.dreamplus.DreamPlus;
import com.thedreamsanctuary.main.java.dreamplus.cooldown.Cooldown;
import com.thedreamsanctuary.main.java.dreamplus.effect.ParticleEffect;
import com.thedreamsanctuary.main.java.dreamplus.executors.DPMisc;
import com.thedreamsanctuary.main.java.dreamplus.executors.DPFood;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Ajcool1050
 */

public class DPListener implements Listener
{
    
    final DreamPlus dp;
    public DPListener(DreamPlus dp)
    {
        this.dp = dp;
    }
    
    public static HashMap<String, String> glows = new HashMap<String, String>();
    public static HashMap<String, String> trails = new HashMap<String, String>();
    public static List<String> firewalk = new ArrayList<String>();
    
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) 
    {
        Player player = event.getPlayer();
        
        if  (glows.containsKey(player.getName()))
        {
            DPMisc.displayGlow(player);
        }
        
        if  (trails.containsKey(player.getName()))
        {
            DPMisc.displayTrail(player);
        }
        
        if (firewalk.contains(player.getName()))
        {
            /*
            *Kesaro wanted this but it's a little, well... 
            *grefiy. so for now it only create's the particles!
            *
            player.getWorld().getBlockAt(player.getLocation()).setTypeId(51); //Kesaro's Firewalk
            */
            ParticleEffect.FLAME.display(player.getEyeLocation(), 0.1F, 0.1F, 0.1F, 0.1F, 15);
        }
    }   
    
    @EventHandler(priority=EventPriority.HIGH)
    public void consume(final PlayerItemConsumeEvent event)
    {
        Player player = event.getPlayer();
        ItemStack itemHand = player.getItemInHand();
             
        //VoxeLager
        if(itemHand.getType() == Material.MUSHROOM_SOUP)
        {
            DPFood.drinkLager(player, 10);
        }
    }
    
    @EventHandler(priority=EventPriority.HIGH)
    public void onPlayerUse(final PlayerInteractEvent event)
    {
        Player player = event.getPlayer();
        ItemStack itemHand = player.getItemInHand();
        
        Action action = event.getAction();
    
        if(action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK))
        {
            //JalapeñoSquidPopper
            if(itemHand.getType() == Material.INK_SACK 
                    && itemHand.getDurability() == 0)
            {
                if (player.getGameMode() == GameMode.CREATIVE) 
                    DPFood.eatPopper(player);
                else
                {
                    removeHandItem(player);
                    DPFood.eatPopper(player); 
                }    
            }
            
            //Wine
            if(itemHand.getType() == Material.INK_SACK
                    && itemHand.getDurability() == 1)
            {
                if (player.getGameMode() == GameMode.CREATIVE)
                {
                    DPFood.drinkWine(player, 5);
                }
                else
                {
                    removeHandItem(player);
                    DPFood.drinkWine(player, 5);
                }
            }
                       
            //VoxelLager
            if(itemHand.getType() == Material.MUSHROOM_SOUP)
            {
                if (player.getGameMode() == GameMode.CREATIVE) 
                {
                    player.sendMessage(ChatColor.GOLD + "You feel drunk!");
                    DPFood.drinkLager(player, 20 );          
                }
                else if (player.getFoodLevel() == 20)
                {
                    player.setFoodLevel(player.getFoodLevel() - 1);   
                }
            }
            
            //VoxeLagerEmpty
            if(itemHand.getType() == Material.BOWL)
            {
                if (player.getGameMode() == GameMode.CREATIVE) 
                    DPFood.drinkLagerEmpty(player);  
                else
                {
                    World world = player.getWorld();
                    world.playEffect(player.getLocation(),Effect.POTION_BREAK,1, 0);
                    
                    removeHandItem(player);
                    DPFood.drinkLagerEmpty(player);
                } 
            }
            
            //SparkRoastCoffe
            if(itemHand.getType() == Material.INK_SACK
                    && itemHand.getDurability() == 3)
            {
                if (player.getGameMode() == GameMode.CREATIVE) 
                    DPFood.drinkCoffee(player, 30);
                else
                {
                    removeHandItem(player);
                    DPFood.drinkCoffee(player, 30);
                }
            }
            
            //Smirfy Soda
            if(itemHand.getType() == Material.INK_SACK 
                    && itemHand.getDurability() == 4)
            {
                if (player.getGameMode() == GameMode.CREATIVE)
                    DPFood.drinkSoda(player);
                else
                {
                    removeHandItem(player);
                    DPFood.drinkSoda(player);
                }
            }
           
            //Neutron Rocky Road
            if(itemHand.getType() == Material.INK_SACK 
                    && itemHand.getDurability() == 5)
            {
                if (player.getGameMode() == GameMode.CREATIVE)
                    DPFood.eatIceCream(player);
                else
                {
                    removeHandItem(player);
                    DPFood.eatIceCream(player);
                }
            }
            
            //Poffertjes
            
            //Ridiculous Cashes
            
            //Doba Crackaz
            
            //Pai Pie
            
            //Cataplut Calzone
            
            //BillyBannana
            
            //Bog's Bacon Bun
            
            //NomNom Noodles
            
            //Flamin Hot Kup-Os
            
            //Fibonachos
            
            //Book
            if(itemHand.getType() == Material.BOOK)
            {
                player.setLevel(player.getLevel() + 1);
                ParticleEffect.ENCHANTMENT_TABLE.display(player.getEyeLocation(), 0.5F, 0.5F, 0.5F, 0.5F, 10);
            }
            
            //Viola
            if(itemHand.getType() == Material.ROTTEN_FLESH)
            {
                DPMisc.playViola(player); 
            } 
            
            //Lyre
            if(itemHand.getType() == Material.FERMENTED_SPIDER_EYE)
            {
                DPMisc.playLyre(player); 
            } 

            //Trumpet
            if(itemHand.getType() == Material.BLAZE_POWDER)
            {
                DPMisc.playTrumpet(player); 
            } 
            
            //Pipe
            if(itemHand.getType() == Material.INK_SACK
                    && itemHand.getDurability() == 15)
            {
                DPMisc.smokePipe(player); 
            } 
            
            //Sleuth's Magnifing Glass
            
            //Fox
            if(itemHand.getType() == Material.MELON_SEEDS)
            {
                if (Cooldown.Cooldown(player, "foxHig", 1))
                {
                    DPMisc.hugFox(player);
                }
            }
            //Cat
            if(itemHand.getType() == Material.GHAST_TEAR)
            {
                if (Cooldown.Cooldown(player, "catHug", 1)) 
                {
                    DPMisc.hugCat(player);
                }
            }
            //Dragon
            if(itemHand.getType() == Material.GOLD_NUGGET)
            {
                if (Cooldown.Cooldown(player, "dragonHug", 1)) 
                {
                    DPMisc.hugDragon(player);
                }
            }
            //Giraffe
            if(itemHand.getType() == Material.QUARTZ)
            {
                if (Cooldown.Cooldown(player, "giraffeHug", 1)) 
                {
                    DPMisc.hugGiraffe(player);
                }
            }  
        }
    }
        
    private boolean removeHandItem(Player player)
    {
        ItemStack itemStack = player.getItemInHand();
        int amount = itemStack.getAmount();
        itemStack.setAmount(amount - 1);
        player.setItemInHand(itemStack);
        return true;  
    }
  

    // For Maps
    public static void saveMap(JavaPlugin plugin, String name, HashMap<String, String> hashMap) 
    {
        try 
        {
            for(String player : plugin.getConfig().getKeys(false))
            {
                plugin.getConfig().set(player,null);
            }
            
            for (String player : hashMap.keySet())
            {
                plugin.getConfig().set(name + "Data." + player, hashMap.get(player));
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Error saving data to file.");
        }
        plugin.saveConfig();
    }
    
    public static void loadMap(JavaPlugin plugin, String name, HashMap<String, String> hashMap) 
    {
        try 
        {
            for (String player : plugin.getConfig().getConfigurationSection(name + "Data").getKeys(true)) 
            {
                String string = plugin.getConfig().getString(name + "Data." + player);
                hashMap.put(player, string);
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Error load data from file.");
        }
    }
    
    public static void addPlayerToMap(final Player player, String string, final HashMap<String, String> hashmap)
    {
        hashmap.put(player.getName(), string);
    }
    
    public static void removePlayerFromMap(final Player player, final HashMap<String, String> hashmap)
    {
        hashmap.remove(player.getName());
    }

    //For Lists
    public static void addPlayerToList(final Player player, final List<String> list)
    {
        list.add(player.getName());
    }
    
    public static void removePlayerFromList(final Player player, final List<String> list)
    {
        list.remove(player.getName());
    }
}