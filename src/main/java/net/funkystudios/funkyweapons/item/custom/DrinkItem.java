package net.funkystudios.funkyweapons.item.custom;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;

import net.minecraft.world.World;

public class DrinkItem extends Item {
    private final int useTime;
    private final Item used;
    public DrinkItem(int useTime, Item used, Settings settings) {
        super(settings);
        this.useTime = useTime;
        this.used = used;
    }


    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if(user instanceof ServerPlayerEntity serverPlayer){
            Criteria.CONSUME_ITEM.trigger(serverPlayer,stack);
            serverPlayer.incrementStat(Stats.USED.getOrCreateStat(this));
            if(stack.isEmpty()){
                return new ItemStack(this.used);
            }
            if(!serverPlayer.getInventory().insertStack(new ItemStack(this.used))) serverPlayer.dropItem(new ItemStack(this.used), false);
        }

        return stack;
    }



    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return useTime;
    }




}
