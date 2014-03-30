package com.thedreamsanctuary.main.java.dreamplus.executors;
import com.thedreamsanctuary.main.java.dreamplus.effect.ParticleEffect;
import static com.thedreamsanctuary.main.java.dreamplus.listener.DPListener.glows;
import static com.thedreamsanctuary.main.java.dreamplus.listener.DPListener.trails;
import java.util.Random;

import org.bukkit.Location;

import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;

/**
 * @author Ajcool1050
 */

public class DPMisc 
{
    private static int section(double yaw, boolean reverse) 
    {
        double absYaw = (yaw < 0) ? (360 + yaw) : yaw;
        int section = (int) (absYaw - ((absYaw + 22.5) % 45.0) + 22.5);
        if(reverse) section = ((section + 180) > 360) ? (section - 180) : (section + 180);
        if(section == 0 || section == 360) return 1; //SOUTH -z
        if(section == 45) return 2; //SOUTHWEST +x -z
        if(section == 90) return 5; //WEST +x
        if(section == 135) return 8; //NORTHWEST +x +z
        if(section == 180) return 7; //NORTH +z
        if(section == 225) return 6; //NORTHEAST -x +z
        if(section == 270) return 3; //EAST -x
        if(section == 315) return 0; //SOUTHEAST; -x -z
        return 4;
    }
    
    public static boolean smokePipe(Player player)
    {
        World world = player.getWorld();
        int section = section(player.getLocation().getYaw(), true);
        if (!player.isSneaking()) 
        {
            double distance = 0.7;
            Location player_loc = player.getLocation();
            double rot_x = (player_loc.getYaw() + 90) % 360;
            double rot_y = player_loc.getPitch() * -1;
            double rot_ycos = Math.cos(Math.toRadians(rot_y));
            double rot_ysin = Math.sin(Math.toRadians(rot_y));
            double rot_xcos = Math.cos(Math.toRadians(rot_x));
            double rot_xsin = Math.sin(Math.toRadians(rot_x));

            double h_length = (distance * rot_ycos);
            double y_offset = (distance * rot_ysin);
            double x_offset = (h_length * rot_xcos);
            double z_offset = (h_length * rot_xsin);

            double target_x = x_offset + player_loc.getX();
            double target_y = y_offset + player_loc.getY() + 1.65;
            double target_z = z_offset + player_loc.getZ();
            
            //world.playEffect(new Location(player_loc.getWorld(), target_x, target_y, target_z), Effect.SMOKE, 4); 
            
            ParticleEffect.SMOKE.display(new Location(player_loc.getWorld(), target_x, target_y, target_z), 0.05F, 0.05F, 0.05F, 0.0F, 5);
        } 
        else 
        {
            double distance = 0.7;
            Location player_loc = player.getLocation();
            double rot_x = (player_loc.getYaw() + 90) % 360;
            double rot_y = player_loc.getPitch() * -1;
            double rot_ycos = Math.cos(Math.toRadians(rot_y));
            double rot_ysin = Math.sin(Math.toRadians(rot_y));
            double rot_xcos = Math.cos(Math.toRadians(rot_x));
            double rot_xsin = Math.sin(Math.toRadians(rot_x));

            double h_length = (distance * rot_ycos);
            double y_offset = (distance * rot_ysin);
            double x_offset = (h_length * rot_xcos);
            double z_offset = (h_length * rot_xsin);

            double target_x = x_offset + player_loc.getX();
            double target_y = y_offset + player_loc.getY() + 1.65;
            double target_z = z_offset + player_loc.getZ();
            
            
            //world.playEffect(new Location(player_loc.getWorld(), target_x, target_y, target_z), Effect.SMOKE, section);
            
            ParticleEffect.SMOKE.display(new Location(player_loc.getWorld(), target_x, target_y, target_z), 0.07F, 0.07F, 0.07F, 0.0F, 10);
        }
        return false;
    }
    
    
    public static boolean hugFox(Player player)
    {
        World world = player.getWorld();
        world.playSound(player.getLocation(),Sound.WOLF_BARK,1F, 5F);
        
        ParticleEffect.HEART.display(player.getEyeLocation(), 0.5F, 0.5F, 0.5F, 0.5F, 15);
        return true;
    }
    
    public static boolean hugCat(Player player)
    {
        World world = player.getWorld();
        world.playSound(player.getLocation(),Sound.CAT_MEOW,1F, 2F);
        
        ParticleEffect.HEART.display(player.getEyeLocation(), 0.5F, 0.5F, 0.5F, 0.5F, 15);
        return true;
    }
    
    public static boolean hugDragon(Player player)
    {
        World world = player.getWorld();
        world.playSound(player.getLocation(),Sound.ENDERDRAGON_GROWL,1F, 2F);
        
        ParticleEffect.HEART.display(player.getEyeLocation(), 0.5F, 0.5F, 0.5F, 0.5F, 15);
        return true;
    }
    
    public static boolean hugGiraffe(Player player)
    {
        World world = player.getWorld();
        world.playSound(player.getLocation(),Sound.HORSE_IDLE,1F, 2F);
        
        ParticleEffect.HEART.display(player.getEyeLocation(), 0.5F, 0.5F, 0.5F, 0.5F, 15);
        return true;
    }
    
    public static boolean playTrumpet(Player player)
    {
        ParticleEffect.NOTE.display(player.getEyeLocation(), 0.5F, 0.5F, 0.5F, 16F, 5);
        
        World world = player.getWorld();
        
        Random random = new Random();
        int number = random.nextInt(24) + 1;
        
        //I GOT LAZY OKAY!
        if (number == 1) world.playSound(player.getLocation(),Sound.NOTE_SNARE_DRUM,1F, 0.5F);
        if (number == 2) world.playSound(player.getLocation(),Sound.NOTE_SNARE_DRUM,1F, 0.53F);
        if (number == 3) world.playSound(player.getLocation(),Sound.NOTE_SNARE_DRUM,1F, 0.56F);
        if (number == 4) world.playSound(player.getLocation(),Sound.NOTE_SNARE_DRUM,1F, 0.59F);
        if (number == 5) world.playSound(player.getLocation(),Sound.NOTE_SNARE_DRUM,1F, 0.63F);
        if (number == 6) world.playSound(player.getLocation(),Sound.NOTE_SNARE_DRUM,1F, 0.71F);
        if (number == 7) world.playSound(player.getLocation(),Sound.NOTE_SNARE_DRUM,1F, 0.75F);
        if (number == 8) world.playSound(player.getLocation(),Sound.NOTE_SNARE_DRUM,1F, 0.79F);
        if (number == 9) world.playSound(player.getLocation(),Sound.NOTE_SNARE_DRUM,1F, 0.84F);
        if (number == 10) world.playSound(player.getLocation(),Sound.NOTE_SNARE_DRUM,1F, 0.89F);
        if (number == 11) world.playSound(player.getLocation(),Sound.NOTE_SNARE_DRUM,1F, 0.94F);
        if (number == 12) world.playSound(player.getLocation(),Sound.NOTE_SNARE_DRUM,1F, 1.06F);
        if (number == 13) world.playSound(player.getLocation(),Sound.NOTE_SNARE_DRUM,1F, 1.12F);
        if (number == 14) world.playSound(player.getLocation(),Sound.NOTE_SNARE_DRUM,1F, 1.19F);
        if (number == 15) world.playSound(player.getLocation(),Sound.NOTE_SNARE_DRUM,1F, 1.26F);
        if (number == 16) world.playSound(player.getLocation(),Sound.NOTE_SNARE_DRUM,1F, 1.33F);
        if (number == 17) world.playSound(player.getLocation(),Sound.NOTE_SNARE_DRUM,1F, 1.41F);
        if (number == 18) world.playSound(player.getLocation(),Sound.NOTE_SNARE_DRUM,1F, 1.5F);
        if (number == 19) world.playSound(player.getLocation(),Sound.NOTE_SNARE_DRUM,1F, 1.59F);
        if (number == 20) world.playSound(player.getLocation(),Sound.NOTE_SNARE_DRUM,1F, 1.68F);
        if (number == 22) world.playSound(player.getLocation(),Sound.NOTE_SNARE_DRUM,1F, 1.78F);
        if (number == 23) world.playSound(player.getLocation(),Sound.NOTE_SNARE_DRUM,1F, 1.89F);
        if (number == 24) world.playSound(player.getLocation(),Sound.NOTE_SNARE_DRUM,1F, 2.0F);
        return true;
    }
    
    public static boolean playLyre(Player player)
    {
        ParticleEffect.NOTE.display(player.getEyeLocation(), 0.5F, 0.5F, 0.5F, 16F, 5);
        
        World world = player.getWorld();
        
        Random random = new Random();
        int number = random.nextInt(24) + 1;
        
        //I GOT LAZY OKAY!
        if (number == 1) world.playSound(player.getLocation(),Sound.NOTE_PLING,1F, 0.5F);
        if (number == 2) world.playSound(player.getLocation(),Sound.NOTE_PLING,1F, 0.53F);
        if (number == 3) world.playSound(player.getLocation(),Sound.NOTE_PLING,1F, 0.56F);
        if (number == 4) world.playSound(player.getLocation(),Sound.NOTE_PLING,1F, 0.59F);
        if (number == 5) world.playSound(player.getLocation(),Sound.NOTE_PLING,1F, 0.63F);
        if (number == 6) world.playSound(player.getLocation(),Sound.NOTE_PLING,1F, 0.71F);
        if (number == 7) world.playSound(player.getLocation(),Sound.NOTE_PLING,1F, 0.75F);
        if (number == 8) world.playSound(player.getLocation(),Sound.NOTE_PLING,1F, 0.79F);
        if (number == 9) world.playSound(player.getLocation(),Sound.NOTE_PLING,1F, 0.84F);
        if (number == 10) world.playSound(player.getLocation(),Sound.NOTE_PLING,1F, 0.89F);
        if (number == 11) world.playSound(player.getLocation(),Sound.NOTE_PLING,1F, 0.94F);
        if (number == 12) world.playSound(player.getLocation(),Sound.NOTE_PLING,1F, 1.06F);
        if (number == 13) world.playSound(player.getLocation(),Sound.NOTE_PLING,1F, 1.12F);
        if (number == 14) world.playSound(player.getLocation(),Sound.NOTE_PLING,1F, 1.19F);
        if (number == 15) world.playSound(player.getLocation(),Sound.NOTE_PLING,1F, 1.26F);
        if (number == 16) world.playSound(player.getLocation(),Sound.NOTE_PLING,1F, 1.33F);
        if (number == 17) world.playSound(player.getLocation(),Sound.NOTE_PLING,1F, 1.41F);
        if (number == 18) world.playSound(player.getLocation(),Sound.NOTE_PLING,1F, 1.5F);
        if (number == 19) world.playSound(player.getLocation(),Sound.NOTE_PLING,1F, 1.59F);
        if (number == 20) world.playSound(player.getLocation(),Sound.NOTE_PLING,1F, 1.68F);
        if (number == 22) world.playSound(player.getLocation(),Sound.NOTE_PLING,1F, 1.78F);
        if (number == 23) world.playSound(player.getLocation(),Sound.NOTE_PLING,1F, 1.89F);
        if (number == 24) world.playSound(player.getLocation(),Sound.NOTE_PLING,1F, 2.0F);
        return true;
    }
    
    public static boolean playViola(Player player)
    {
        ParticleEffect.NOTE.display(player.getEyeLocation(), 0.5F, 0.5F, 0.5F, 16F, 5);
        
        World world = player.getWorld();
        
        Random random = new Random();
        int number = random.nextInt(24) + 1;
        
        //I GOT LAZY OKAY!
        if (number == 1) world.playSound(player.getLocation(),Sound.NOTE_BASS_GUITAR,1F, 0.5F);
        if (number == 2) world.playSound(player.getLocation(),Sound.NOTE_BASS_GUITAR,1F, 0.53F);
        if (number == 3) world.playSound(player.getLocation(),Sound.NOTE_BASS_GUITAR,1F, 0.56F);
        if (number == 4) world.playSound(player.getLocation(),Sound.NOTE_BASS_GUITAR,1F, 0.59F);
        if (number == 5) world.playSound(player.getLocation(),Sound.NOTE_BASS_GUITAR,1F, 0.63F);
        if (number == 6) world.playSound(player.getLocation(),Sound.NOTE_BASS_GUITAR,1F, 0.71F);
        if (number == 7) world.playSound(player.getLocation(),Sound.NOTE_BASS_GUITAR,1F, 0.75F);
        if (number == 8) world.playSound(player.getLocation(),Sound.NOTE_BASS_GUITAR,1F, 0.79F);
        if (number == 9) world.playSound(player.getLocation(),Sound.NOTE_BASS_GUITAR,1F, 0.84F);
        if (number == 10) world.playSound(player.getLocation(),Sound.NOTE_BASS_GUITAR,1F, 0.89F);
        if (number == 11) world.playSound(player.getLocation(),Sound.NOTE_BASS_GUITAR,1F, 0.94F);
        if (number == 12) world.playSound(player.getLocation(),Sound.NOTE_BASS_GUITAR,1F, 1.06F);
        if (number == 13) world.playSound(player.getLocation(),Sound.NOTE_BASS_GUITAR,1F, 1.12F);
        if (number == 14) world.playSound(player.getLocation(),Sound.NOTE_BASS_GUITAR,1F, 1.19F);
        if (number == 15) world.playSound(player.getLocation(),Sound.NOTE_BASS_GUITAR,1F, 1.26F);
        if (number == 16) world.playSound(player.getLocation(),Sound.NOTE_BASS_GUITAR,1F, 1.33F);
        if (number == 17) world.playSound(player.getLocation(),Sound.NOTE_BASS_GUITAR,1F, 1.41F);
        if (number == 18) world.playSound(player.getLocation(),Sound.NOTE_BASS_GUITAR,1F, 1.5F);
        if (number == 19) world.playSound(player.getLocation(),Sound.NOTE_BASS_GUITAR,1F, 1.59F);
        if (number == 20) world.playSound(player.getLocation(),Sound.NOTE_BASS_GUITAR,1F, 1.68F);
        if (number == 22) world.playSound(player.getLocation(),Sound.NOTE_BASS_GUITAR,1F, 1.78F);
        if (number == 23) world.playSound(player.getLocation(),Sound.NOTE_BASS_GUITAR,1F, 1.89F);
        if (number == 24) world.playSound(player.getLocation(),Sound.NOTE_BASS_GUITAR,1F, 2.0F);
        return true;
    }
  
    public static boolean displayGlow(Player player)
    {   
        double distance = 0.7;
        Location player_loc = player.getLocation();
        double rot_x = (player_loc.getYaw() - 90) % 360;
        double rot_y = player_loc.getY() * -1;
        double rot_ycos = Math.cos(Math.toRadians(rot_y));
        double rot_xcos = Math.cos(Math.toRadians(rot_x));
        double rot_xsin = Math.sin(Math.toRadians(rot_x));

        double h_length = (distance * rot_ycos);
        double x_offset = (h_length * rot_xcos);
        double z_offset = (h_length * rot_xsin);

        double target_x = x_offset + player_loc.getX();
        double target_y = player_loc.getY() + 1.25;
        double target_z = z_offset + player_loc.getZ();
        
        Location trailLocation = new Location(player_loc.getWorld(), target_x, target_y, target_z);
        Location portalTrailLocation = new Location(player_loc.getWorld(), target_x, target_y -0.45, target_z);
        
        String getGlow = glows.get(player.getName());
        
        if (glows.get(player.getName()).equalsIgnoreCase("sparks")) 
            ParticleEffect.FIREWORKS_SPARK.display(trailLocation, 0.05F, 0.05F, 0.05F, 0.02F, 5);
        else if (getGlow.equalsIgnoreCase("dust")) 
            ParticleEffect.TOWN_AURA.display(trailLocation, 0.05F, 0.05F, 0.05F, 0.02F, 5);
        else if (getGlow.equalsIgnoreCase("brownstar")) 
            ParticleEffect.CRIT.display(trailLocation, 0.05F, 0.05F, 0.05F, 0.02F, 5);
        else if (getGlow.equalsIgnoreCase("bluestar")) 
            ParticleEffect.MAGIC_CRIT.display(trailLocation, 0.05F, 0.05F, 0.05F, 0.02F, 5);
        else if (getGlow.equalsIgnoreCase("redstar")) 
            ParticleEffect.INSTANT_SPELL.display(trailLocation, 0.05F, 0.05F, 0.05F, 0.0F, 5);
        else if (getGlow.equalsIgnoreCase("darkredstar")) 
            ParticleEffect.WITCH_MAGIC.display(trailLocation, 0.05F, 0.05F, 0.05F, 0.0F, 5);
        else if (getGlow.equalsIgnoreCase("note")) 
            ParticleEffect.NOTE.display(trailLocation, 0.05F, 0.05F, 0.05F, 16F, 5);
        else if (getGlow.equalsIgnoreCase("portal")) 
            ParticleEffect.PORTAL.display(portalTrailLocation, 0.05F, 0.05F, 0.05F, 0.0F, 5);
        else if (getGlow.equalsIgnoreCase("code")) 
            ParticleEffect.ENCHANTMENT_TABLE.display(trailLocation, 0.05F, 0.05F, 0.05F, 0.02F, 5);
        else if (getGlow.equalsIgnoreCase("redstone")) 
            ParticleEffect.RED_DUST.display(trailLocation, 0.05F, 0.05F, 0.05F, 0.00F, 5);
        else if (getGlow.equalsIgnoreCase("derpy")) 
            ParticleEffect.SNOWBALL_POOF.display(trailLocation, 0.05F, 0.05F, 0.05F, 0.02F, 5);
        else if (getGlow.equalsIgnoreCase("snow")) 
            ParticleEffect.SNOW_SHOVEL.display(trailLocation, 0.05F, 0.05F, 0.05F, 0.02F, 5);
        else if (getGlow.equalsIgnoreCase("bluedust")) 
            ParticleEffect.DRIP_WATER.display(trailLocation, 0.05F, 0.05F, 0.05F, 0.02F, 5);
        else if (getGlow.equalsIgnoreCase("reddust")) 
            ParticleEffect.DRIP_LAVA.display(trailLocation, 0.05F, 0.05F, 0.05F, 0.02F, 5);
        else if (getGlow.equalsIgnoreCase("derpydust")) 
            ParticleEffect.SLIME.display(trailLocation, 0.05F, 0.05F, 0.05F, 0.02F, 5);
        else if (getGlow.equalsIgnoreCase("smoke")) 
            ParticleEffect.SMOKE.display(trailLocation, 0.05F, 0.05F, 0.05F, 0.02F, 5);
        else if (getGlow.equalsIgnoreCase("love")) 
            ParticleEffect.HEART.display(trailLocation, 0.05F, 0.05F, 0.05F, 0.02F, 5);
        else if (getGlow.equalsIgnoreCase("cloud")) 
            ParticleEffect.ANGRY_VILLAGER.display(trailLocation, 0.05F, 0.05F, 0.05F, 0.02F, 5);
        else if (getGlow.equalsIgnoreCase("gem")) 
            ParticleEffect.HAPPY_VILLAGER.display(trailLocation, 0.05F, 0.05F, 0.05F, 0.02F, 5);
        else if (getGlow.contains(":"))
        { 
            String[] split = getGlow.split(":");
            int itemID = Integer.parseInt(split[0]);
            int itemData = Integer.parseInt(split[1]);
            
            ParticleEffect.displayBlockCrack(trailLocation, itemID, (byte) itemData,  0.05F, 0.05F, 0.05F, 5);
        } else if (isInt(getGlow))
        {
            int itemID = Integer.parseInt(getGlow);
            ParticleEffect.displayBlockCrack(trailLocation, itemID, (byte) 0,  0.05F, 0.05F, 0.05F, 5);
        }
        return false;
    }
    
    public static boolean displayTrail(Player player)
    {
        Location glowLocation = player.getLocation();
        
        String getTrail = trails.get(player.getName());
        if (getTrail.contains(":"))
        { 
            String[] split = getTrail.split(":");
            int itemID = Integer.parseInt(split[0]);
            int itemData = Integer.parseInt(split[1]);
            
            ParticleEffect.displayBlockCrack(glowLocation, itemID, (byte) itemData,  0.05F, 0.05F, 0.05F, 5);
        } else if (isInt(getTrail))
        {
            int itemID = Integer.parseInt(getTrail);
            ParticleEffect.displayBlockCrack(glowLocation, itemID, (byte) 0,  0.05F, 0.05F, 0.05F, 5);
        }
        return false;
    }
    
    private static boolean isInt(String s) 
    {
        try 
        {
            Integer.parseInt(s);
        } 
        catch (NumberFormatException nfe) 
        {
            return false;
        }
        return true;
    }
}
