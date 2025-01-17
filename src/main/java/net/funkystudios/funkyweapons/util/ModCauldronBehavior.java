package net.funkystudios.funkyweapons.util;

import net.funkystudios.funkyweapons.alchemy.potion.ModPotions;
import net.funkystudios.funkyweapons.block.ModBlocks;
import net.funkystudios.funkyweapons.block.custom.cauldron.ApacheTearsCauldronBlock;
import net.funkystudios.funkyweapons.block.custom.cauldron.ObsidianTearsCauldronBlock;
import net.funkystudios.funkyweapons.block.custom.cauldron.RustyWaterCauldronBlock;
import net.funkystudios.funkyweapons.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ItemActionResult;

import java.util.HashMap;
import java.util.Map;

import static net.minecraft.block.cauldron.CauldronBehavior.EMPTY_CAULDRON_BEHAVIOR;

public class ModCauldronBehavior  {

    public static final Map<Item, CauldronBehavior> APACHE_TEARS_CAULDRON = new HashMap<>();
    public static final Map<Item, CauldronBehavior> OBSIDIAN_TEARS_CAULDRON = new HashMap<>();
    public static final Map<Item, CauldronBehavior> RUSTY_WATER_CAULDRON = new HashMap<>();
    public static final CauldronBehavior EMPTY_OBSIDIAN_TEARS = ((state, world, pos, player, hand, stack) -> {
        ItemStack toReturn = potionStack(ModPotions.OBSIDIAN_TEARS);
        if (!world.isClient){
            if(stack.getItem() != Items.GLASS_BOTTLE) return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
            player.setStackInHand(hand, ItemUsage.exchangeStack(stack,player, toReturn));
            LeveledCauldronBlock.decrementFluidLevel(state,world,pos);
        }

        return  ItemActionResult.SUCCESS;
    });
    public static final CauldronBehavior EMPTY_APACHE_TEARS = ((state, world, pos, player, hand, stack) -> {
       ItemStack toReturn = potionStack(ModPotions.APACHE_TEARS);
       if(!world.isClient){
           if(stack.getItem() != Items.GLASS_BOTTLE) return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
           player.setStackInHand(hand, ItemUsage.exchangeStack(stack,player,toReturn));
           LeveledCauldronBlock.decrementFluidLevel(state,world,pos);
       }

       return ItemActionResult.SUCCESS;
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
       if (item != Items.OBSIDIAN) return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;

       if(!world.isClient){
           if(!player.getAbilities().creativeMode){
               stack.decrement(1);
           }
           if (stack.isEmpty()){
               player.setStackInHand(hand,created);
           } else if (!player.getInventory().insertStack(created)) player.dropItem(created,false);
           LeveledCauldronBlock.decrementFluidLevel(state,world,pos);
       }
        return ItemActionResult.SUCCESS;
    });

    public static final CauldronBehavior CREATE_TURQUOISE_CRYING_OBSIDIAN_SPIKE = (((state, world, pos, player, hand, stack) -> {
        Item item = stack.getItem();
        ItemStack created = new ItemStack(ModItems.TURQUOISE_OBSIDIAN_SPIKE);
        if( item != ModItems.OBSIDIAN_SPIKE) return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;

        if (!world.isClient){
            if(!player.getAbilities().creativeMode) stack.decrement(1);
            if(stack.isEmpty()){ player.setStackInHand(hand, created);}
            else if (!player.getInventory().insertStack(created)) player.dropItem(created,false);
            LeveledCauldronBlock.decrementFluidLevel(state,world,pos);
        }
        return ItemActionResult.SUCCESS;
    }));
    public static final  CauldronBehavior CREATE_TURQUOISE_CRYING_OBSIDIAN = ((state, world, pos, player, hand, stack) -> {
       Item item = stack.getItem();
        ItemStack created = new ItemStack(ModBlocks.TURQUOISE_CRYING_OBSIDIAN.asItem());
       if (item != Items.CRYING_OBSIDIAN) return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;

       if(!world.isClient){
           if(!player.getAbilities().creativeMode){
               stack.decrement(1);
           }
           if (stack.isEmpty()){
               player.setStackInHand(hand,created);
           } else if (!player.getInventory().insertStack(created)) player.dropItem(created,false);
           LeveledCauldronBlock.decrementFluidLevel(state,world,pos);
       }
        return ItemActionResult.SUCCESS;
    });


    public static final CauldronBehavior FILL_UP_WITH_WATER_POTION = ((state, world, pos, player, hand, stack) -> {
        PotionContentsComponent potion = stack.get(DataComponentTypes.POTION_CONTENTS);
        ItemStack toReturn = new ItemStack(Items.GLASS_BOTTLE);

        if(!world.isClient){
            if(potion != null && potion.matches(Potions.WATER)){
                player.setStackInHand(hand, ItemUsage.exchangeStack(stack,player,toReturn));
                world.setBlockState(pos, (BlockState) state.cycle(LeveledCauldronBlock.LEVEL));
            } else {
                return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
            }
        }

        return ItemActionResult.SUCCESS;
    });
    public static final CauldronBehavior FILL_UP_WITH_OBSIDIAN_TEARS = ((state, world, pos, player, hand, stack) -> {
        PotionContentsComponent potion = stack.get(DataComponentTypes.POTION_CONTENTS);
        ItemStack toReturn = new ItemStack(Items.GLASS_BOTTLE);

        if(!world.isClient){
            if(potion != null && state.get(ObsidianTearsCauldronBlock.LEVEL) != 3){
                player.setStackInHand(hand, ItemUsage.exchangeStack(stack,player,toReturn));
                world.setBlockState(pos, (BlockState) state.cycle(ObsidianTearsCauldronBlock.LEVEL));
            } else {
                return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
            }
        }

        return ItemActionResult.SUCCESS;
    });

    public static final CauldronBehavior FILL_UP_WITH_APACHE_TEARS = ((state, world, pos, player, hand, stack) -> {
        PotionContentsComponent potion = stack.get(DataComponentTypes.POTION_CONTENTS);
        ItemStack toReturn = new ItemStack(Items.GLASS_BOTTLE);

        if(!world.isClient){
            if(isPotion(potion, ModPotions.APACHE_TEARS) && state.get(ApacheTearsCauldronBlock.LEVEL) != 3){
                player.setStackInHand(hand, ItemUsage.exchangeStack(stack,player,toReturn));
                world.setBlockState(pos, (BlockState) state.cycle(ApacheTearsCauldronBlock.LEVEL));
            } else {
                return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
            }
        }

        return ItemActionResult.SUCCESS;
    });


    private static ItemStack potionStack(RegistryEntry<Potion> potion){
        return PotionContentsComponent.createStack(Items.POTION, potion);
    }

    private static boolean isPotion(PotionContentsComponent contentsComponent, RegistryEntry<Potion> potion){
        return contentsComponent != null && contentsComponent.matches(potion);
    }


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


        EMPTY_CAULDRON_BEHAVIOR.map().put(Items.POTION,FILL_UP_WITH_WATER_POTION);
        EMPTY_CAULDRON_BEHAVIOR.map().put(ModItems.APACHE_TEARS_BUCKET, EMPTY_APACHE_TEARS_BUCKET);
        EMPTY_CAULDRON_BEHAVIOR.map().put(ModItems.OBSIDIAN_TEARS_BUCKET, EMPTY_OBSIDIAN_TEARS_BUCKET);
        EMPTY_CAULDRON_BEHAVIOR.map().put(ModItems.RUSTY_WATER_BUCKET, EMPTY_RUSTY_WATER_BUCKET);

    }

}
