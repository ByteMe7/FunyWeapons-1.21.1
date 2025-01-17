package net.funkystudios.funkyweapons.util;

import net.funkystudios.funkyweapons.alchemy.potion.ModPotions;
import net.funkystudios.funkyweapons.block.ModBlocks;
import net.funkystudios.funkyweapons.block.custom.ApacheTearsCauldronBlock;
import net.funkystudios.funkyweapons.block.custom.ObsidianTearsCauldronBlock;
import net.funkystudios.funkyweapons.block.custom.RustyWaterCauldronBlock;
import net.funkystudios.funkyweapons.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;

import java.util.Map;

public interface ModCauldronBehavior extends CauldronBehavior {

    public static final Map<Item, CauldronBehavior> APACHE_TEARS_CAULDRON = CauldronBehavior.createMap();
    public static final Map<Item, CauldronBehavior> OBSIDIAN_TEARS_CAULDRON = CauldronBehavior.createMap();
    public static final Map<Item, CauldronBehavior> RUSTY_WATER_CAULDRON = CauldronBehavior.createMap();
    public static final CauldronBehavior EMPTY_OBSIDIAN_TEARS = ((state, world, pos, player, hand, stack) -> {
        ItemStack toReturn = PotionUtil.setPotion(new ItemStack(Items.POTION), ModPotions.OBSIDIAN_TEARS);
        if (!world.isClient){
            if(stack.getItem() != Items.GLASS_BOTTLE) return ActionResult.PASS;
            player.setStackInHand(hand, ItemUsage.exchangeStack(stack,player,toReturn));
            LeveledCauldronBlock.decrementFluidLevel(state,world,pos);
        }

        return  ActionResult.success(world.isClient);
    });
    public static final CauldronBehavior EMPTY_APACHE_TEARS = ((state, world, pos, player, hand, stack) -> {
       ItemStack toReturn = PotionUtil.setPotion(new ItemStack(Items.POTION), ModPotions.APACHE_TEARS);
       if(!world.isClient){
           if(stack.getItem() != Items.GLASS_BOTTLE) return ActionResult.PASS;
           player.setStackInHand(hand, ItemUsage.exchangeStack(stack,player,toReturn));
           LeveledCauldronBlock.decrementFluidLevel(state,world,pos);
       }

       return ActionResult.success(world.isClient);
    });


    public static final CauldronBehavior FILL_OBSIDIAN_TEARS_BUCKET = ((state, world, pos, player, hand, stack) -> CauldronBehavior.emptyCauldron(state,world,pos,player,hand,stack,new ItemStack(ModItems.OBSIDIAN_TEARS_BUCKET), statex -> statex.get(ObsidianTearsCauldronBlock.LEVEL) == 3, SoundEvents.ITEM_BUCKET_FILL));
    public static final CauldronBehavior FILL_APACHE_TEARS_BUCKET = ((state, world, pos, player, hand, stack) -> CauldronBehavior.emptyCauldron(state,world,pos,player,hand,stack,new ItemStack(ModItems.APACHE_TEARS_BUCKET), statex -> statex.get(ApacheTearsCauldronBlock.LEVEL) == 3, SoundEvents.ITEM_BUCKET_FILL));
    public static final CauldronBehavior FILL_RUSTY_WATER_BUCKET = ((state, world, pos, player, hand, stack) -> CauldronBehavior.emptyCauldron(state,world,pos,player,hand,stack,new ItemStack(ModItems.RUSTY_WATER_BUCKET), statex -> statex.get(RustyWaterCauldronBlock.LEVEL) == 3, SoundEvents.ITEM_BUCKET_FILL));

    public static final  CauldronBehavior EMPTY_OBSIDIAN_TEARS_BUCKET = ((state, world, pos, player, hand, stack) -> CauldronBehavior.fillCauldron(world,pos, player,hand,stack,(BlockState) ModBlocks.OBSIDIAN_TEAR_CAULDRON.getDefaultState().with(ObsidianTearsCauldronBlock.LEVEL,3),SoundEvents.ITEM_BUCKET_EMPTY));
    public static final  CauldronBehavior EMPTY_APACHE_TEARS_BUCKET = ((state, world, pos, player, hand, stack) -> CauldronBehavior.fillCauldron(world,pos, player,hand,stack,(BlockState) ModBlocks.APACHE_TEAR_CAULDRON.getDefaultState().with(ObsidianTearsCauldronBlock.LEVEL,3),SoundEvents.ITEM_BUCKET_EMPTY));
    public static final  CauldronBehavior EMPTY_RUSTY_WATER_BUCKET = ((state, world, pos, player, hand, stack) -> CauldronBehavior.fillCauldron(world,pos, player,hand,stack,(BlockState) ModBlocks.RUSTY_WATER_CAULDRON.getDefaultState().with(ObsidianTearsCauldronBlock.LEVEL,3),SoundEvents.ITEM_BUCKET_EMPTY));

    public static final  CauldronBehavior CREATE_CRYING_OBSIDIAN = ((state, world, pos, player, hand, stack) -> {
       Item item = stack.getItem();
        ItemStack created = new ItemStack(Items.CRYING_OBSIDIAN);
       if (item != Items.OBSIDIAN) return ActionResult.PASS;

       if(!world.isClient){
           if(!player.getAbilities().creativeMode){
               stack.decrement(1);
           }
           if (stack.isEmpty()){
               player.setStackInHand(hand,created);
           } else if (!player.getInventory().insertStack(created)) player.dropItem(created,false);
           LeveledCauldronBlock.decrementFluidLevel(state,world,pos);
       }
        return ActionResult.success(world.isClient);
    });

    public static final CauldronBehavior CREATE_TURQUOISE_CRYING_OBSIDIAN_SPIKE = (((state, world, pos, player, hand, stack) -> {
        Item item = stack.getItem();
        ItemStack created = new ItemStack(ModItems.TURQUOISE_OBSIDIAN_SPIKE);
        if( item != ModItems.OBSIDIAN_SPIKE) return ActionResult.PASS;

        if (!world.isClient){
            if(!player.getAbilities().creativeMode) stack.decrement(1);
            if(stack.isEmpty()){ player.setStackInHand(hand, created);}
            else if (!player.getInventory().insertStack(created)) player.dropItem(created,false);
            LeveledCauldronBlock.decrementFluidLevel(state,world,pos);
        }
        return ActionResult.success(world.isClient);
    }));
    public static final  CauldronBehavior CREATE_TURQUOISE_CRYING_OBSIDIAN = ((state, world, pos, player, hand, stack) -> {
       Item item = stack.getItem();
        ItemStack created = new ItemStack(ModBlocks.TURQUOISE_CRYING_OBSIDIAN.asItem());
       if (item != Items.CRYING_OBSIDIAN) return ActionResult.PASS;

       if(!world.isClient){
           if(!player.getAbilities().creativeMode){
               stack.decrement(1);
           }
           if (stack.isEmpty()){
               player.setStackInHand(hand,created);
           } else if (!player.getInventory().insertStack(created)) player.dropItem(created,false);
           LeveledCauldronBlock.decrementFluidLevel(state,world,pos);
       }
        return ActionResult.success(world.isClient);
    });


    public static final CauldronBehavior FILL_UP_WITH_WATER_POTION = ((state, world, pos, player, hand, stack) -> {
        Potion potion = PotionUtil.getPotion(stack);
        ItemStack toReturn = new ItemStack(Items.GLASS_BOTTLE);

        if(!world.isClient){
            if(potion == Potions.WATER){
                player.setStackInHand(hand, ItemUsage.exchangeStack(stack,player,toReturn));
                world.setBlockState(pos, (BlockState) state.cycle(LeveledCauldronBlock.LEVEL));
            } else {
                return ActionResult.PASS;
            }
        }

        return ActionResult.success(world.isClient);
    });
    public static final CauldronBehavior FILL_UP_WITH_OBSIDIAN_TEARS = ((state, world, pos, player, hand, stack) -> {
        Potion potion = PotionUtil.getPotion(stack);
        ItemStack toReturn = new ItemStack(Items.GLASS_BOTTLE);

        if(!world.isClient){
            if(potion == ModPotions.OBSIDIAN_TEARS && state.get(ObsidianTearsCauldronBlock.LEVEL) != 3){
                player.setStackInHand(hand, ItemUsage.exchangeStack(stack,player,toReturn));
                world.setBlockState(pos, (BlockState) state.cycle(ObsidianTearsCauldronBlock.LEVEL));
            } else {
                return ActionResult.PASS;
            }
        }

        return ActionResult.success(world.isClient);
    });

    public static final CauldronBehavior FILL_UP_WITH_APACHE_TEARS = ((state, world, pos, player, hand, stack) -> {
        Potion potion = PotionUtil.getPotion(stack);
        ItemStack toReturn = new ItemStack(Items.GLASS_BOTTLE);

        if(!world.isClient){
            if(potion == ModPotions.APACHE_TEARS && state.get(ApacheTearsCauldronBlock.LEVEL) != 3){
                player.setStackInHand(hand, ItemUsage.exchangeStack(stack,player,toReturn));
                world.setBlockState(pos, (BlockState) state.cycle(ApacheTearsCauldronBlock.LEVEL));
            } else {
                return ActionResult.PASS;
            }
        }

        return ActionResult.success(world.isClient);
    });

    public static void registerBehavior(){
        APACHE_TEARS_CAULDRON.put(ModItems.OBSIDIAN_SPIKE, CREATE_TURQUOISE_CRYING_OBSIDIAN_SPIKE);
        APACHE_TEARS_CAULDRON.put(Items.CRYING_OBSIDIAN, CREATE_TURQUOISE_CRYING_OBSIDIAN);
        APACHE_TEARS_CAULDRON.put(Items.GLASS_BOTTLE, EMPTY_APACHE_TEARS);
        APACHE_TEARS_CAULDRON.put(Items.BUCKET,FILL_APACHE_TEARS_BUCKET);
        APACHE_TEARS_CAULDRON.put(Items.POTION,FILL_UP_WITH_APACHE_TEARS);

        RUSTY_WATER_CAULDRON.put(Items.BUCKET, FILL_RUSTY_WATER_BUCKET);

        OBSIDIAN_TEARS_CAULDRON.put(Items.OBSIDIAN, CREATE_CRYING_OBSIDIAN);
        OBSIDIAN_TEARS_CAULDRON.put(Items.GLASS_BOTTLE, EMPTY_OBSIDIAN_TEARS);
        OBSIDIAN_TEARS_CAULDRON.put(Items.POTION, FILL_UP_WITH_OBSIDIAN_TEARS);
        OBSIDIAN_TEARS_CAULDRON.put(Items.BUCKET, FILL_OBSIDIAN_TEARS_BUCKET);


        EMPTY_CAULDRON_BEHAVIOR.put(Items.POTION,FILL_UP_WITH_WATER_POTION);
        EMPTY_CAULDRON_BEHAVIOR.put(ModItems.APACHE_TEARS_BUCKET, EMPTY_APACHE_TEARS_BUCKET);
        EMPTY_CAULDRON_BEHAVIOR.put(ModItems.OBSIDIAN_TEARS_BUCKET, EMPTY_OBSIDIAN_TEARS_BUCKET);
        EMPTY_CAULDRON_BEHAVIOR.put(ModItems.RUSTY_WATER_BUCKET, EMPTY_RUSTY_WATER_BUCKET);

    }

}
