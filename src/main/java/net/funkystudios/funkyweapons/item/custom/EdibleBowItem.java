package net.funkystudios.funkyweapons.item.custom;


import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class EdibleBowItem extends TieredBowItem {
    private final boolean isSnack;
    private UseAction currentUse = UseAction.BOW;
    private final FoodComponent foodComponent;


    public EdibleBowItem(ToolMaterial material, FoodComponent foodComponent, boolean isSnack, Settings settings) {
        super(material, settings.food(foodComponent));
        this.foodComponent = foodComponent;
        this.isSnack = isSnack;

    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if(currentUse == UseAction.EAT){
            if(user instanceof ServerPlayerEntity player && player.canConsume(foodComponent.canAlwaysEat())){
                player.getHungerManager().eat(foodComponent);
                stack.decrement(1);
                player.incrementStat(Stats.USED.getOrCreateStat(stack.getItem()));
            }
        }
        return super.finishUsing(stack, world, user);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        currentUse = UseAction.BOW;
        if(user.getProjectileType(stack).isEmpty()){
            currentUse = UseAction.EAT;
            if(user.canConsume(foodComponent.canAlwaysEat())){
                user.setCurrentHand(hand);
                return TypedActionResult.consume(stack);
            }
            return TypedActionResult.fail(stack);
        }
        return super.use(world, user, hand);
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        if(currentUse == UseAction.EAT){
            return this.isSnack ? 15 : 30;
        }
        return super.getMaxUseTime(stack, user);
    }


}
