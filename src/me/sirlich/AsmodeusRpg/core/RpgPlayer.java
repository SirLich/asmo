package me.sirlich.AsmodeusRpg.core;
import me.sirlich.AsmodeusRpg.abilities.Ability;
import org.bukkit.entity.Player;

public class RpgPlayer
{
    /*
    These vars are all about player abilities.
     */
    private Ability mobilityAbility;
    private boolean canUseMobilityAbility;

    private Ability carnageAbility;
    private boolean canUseCarnageAbility;

    private int carnageAbilityLevel;

    private Ability mythicalAbility;
    private boolean canUseMythicalAbility;

    /*
    These vars are all about passive things that effect the player.
    Things that might influence these values:
     - Armour
     - Weapons
     - Classes
     - Abilities
     - Artifacts
     - Mob hits (say, that cause slowness)
     */
    private float speedModifier;
    private double staminaDrainOnRunModifier;
    private double stamineRegenRateModifier;
    private int maxStamina;
    private double staminaDrainOnSwordUseModifier;
    private double stamineDrainOnAxeUseModifier;
    private double stamineDrainOnMagicUseModifier;
    private double staminaDrainOnBowUseModifier;
    private double healthRegenPerSecond;
    private double armorValue;
    private double experienceGainedModifier;

    /*
    This method is used to add or subtract speed from a players passive walking/running speed.
    The value range is between 0 (no walk) and 1 (speed 10 in essentials)
    Vanilla walking speed: 0.2
    Sneaking walking speed: 0.1
    So boots that add 5% walking speed should add 0.01 speed (and you should add -0.01 when you take them off)
     */
    public void editSpeedModifier(Float f){
        speedModifier += f;
        System.out.println("Speed mod is " + speedModifier);
        Player player = getPlayer();
        if(speedModifier != 0 && speedModifier <= 1){
            player.setWalkSpeed(speedModifier);
        } else{
            player.setWalkSpeed(1);
        }
    }

    /*
    This method is used to SET player speed.
    This should only be used in rare cases, such as for initialization.
    Please see editSpeedModifier for a more general case method.
     */
    public void setSpeedModifier(Float f){
        speedModifier = f;
        Player player = getPlayer();
        if(speedModifier != 0 && speedModifier <= 1 && speedModifier >= 0){
            player.setWalkSpeed(speedModifier);
        } else{
            player.setWalkSpeed(1);
        }
    }


    /*
    This method is used to get a Player from an RpgPlayer.
    I make use of the PlayerList to do so.
     */
    public Player getPlayer(){
        System.out.println("Into getPlayer inside RpgPlayer!");
        return PlayerList.getPlayer(this);
    }

    public boolean isCanUseMobilityAbility()
    {
        return canUseMobilityAbility;
    }

    public void setCanUseMobilityAbility(boolean canUseMobilityAbility)
    {
        this.canUseMobilityAbility = canUseMobilityAbility;
    }

    public boolean isCanUseCarnageAbility()
    {
        return canUseCarnageAbility;
    }

    public void setCanUseCarnageAbility(boolean canUseCarnageAbility)
    {
        this.canUseCarnageAbility = canUseCarnageAbility;
    }

    public int getCarnageAbilityLevel()
    {
        return carnageAbilityLevel;
    }

    public void setCarnageAbilityLevel(int carnageAbilityLevel)
    {
        this.carnageAbilityLevel = carnageAbilityLevel;
    }

    public boolean isCanUseMythicalAbility()
    {
        return canUseMythicalAbility;
    }

    public void setCanUseMythicalAbility(boolean canUseMythicalAbility)
    {
        this.canUseMythicalAbility = canUseMythicalAbility;
    }


    public Ability getMobilityAbility() {
        return mobilityAbility;
    }

    public void setMobilityAbility(Ability doubleJumpAbility) {
        this.mobilityAbility = doubleJumpAbility;
    }

    public Ability getCarnageAbility() {
        return carnageAbility;
    }

    public void setCarnageAbility(Ability carnageAbility) {
        this.carnageAbility = carnageAbility;
    }

    public Ability getMythicalAbility() {
        return mythicalAbility;
    }

    public void setMythicalAbility(Ability mythicalAbility) {
        this.mythicalAbility = mythicalAbility;
    }
}
