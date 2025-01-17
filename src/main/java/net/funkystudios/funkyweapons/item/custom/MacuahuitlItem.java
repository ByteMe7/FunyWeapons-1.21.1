package net.funkystudios.funkyweapons.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.predicate.item.EnchantmentsPredicate;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class MacuahuitlItem extends SwordItem {
    private final ToolMaterial material;
    public MacuahuitlItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, settings.attributeModifiers(createAttributeModifiers(material, attackDamage, attackSpeed)));
        this.material = material;
    }
    public static AttributeModifiersComponent createAttributeModifiers(ToolMaterial material, float baseAttackDamage, float attackSpeed) {
        return AttributeModifiersComponent.builder()
                .add(
                        EntityAttributes.GENERIC_ATTACK_DAMAGE,
                        new EntityAttributeModifier(
                                BASE_ATTACK_DAMAGE_MODIFIER_ID, (double)((float)baseAttackDamage + material.getAttackDamage()), EntityAttributeModifier.Operation.ADD_VALUE
                        ),
                        AttributeModifierSlot.MAINHAND
                )
                .add(
                        EntityAttributes.GENERIC_ATTACK_SPEED,
                        new EntityAttributeModifier(BASE_ATTACK_SPEED_MODIFIER_ID, (double)attackSpeed, EntityAttributeModifier.Operation.ADD_VALUE),
                        AttributeModifierSlot.MAINHAND
                )
                .add(
                        EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO,
                        new EntityAttributeModifier(
                                Identifier.ofVanilla("sweeping_damage_ratio"),
                                3,
                                EntityAttributeModifier.Operation.ADD_VALUE ),
                        AttributeModifierSlot.MAINHAND
                )
                .build();
    }




    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return !miner.isCreative();
    }


    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        if(!attacker.getWorld().isClient){
            double knockbackMutiplier = getExtraKnockback(stack);
            double deltaX = target.getX() - attacker.getX();
            double deltaZ = target.getZ() - attacker.getZ();
            double distance = Math.sqrt(deltaX * deltaX + deltaZ * deltaZ);

            if(distance != 0){
                target.addVelocity(
                        (deltaX / distance) * knockbackMutiplier,
                        0.1,
                        (deltaZ / distance) * knockbackMutiplier
                );
                target.velocityModified = true;
            }
        }
        return true;
    }

    private float getExtraKnockback(ItemStack stack){
        float kbAmt = 0F;
        int kbLvl = 0;
        for(RegistryEntry<Enchantment> entry : EnchantmentHelper.getEnchantments(stack).getEnchantments()){
            if(entry.matchesKey(Enchantments.KNOCKBACK)){
                kbLvl = EnchantmentHelper.getLevel(entry, stack);
                break;
            }
        }
        kbAmt = 0.25F * (float) kbLvl;
        return kbAmt + 2.0F;
    }

    @Override
    public float getBonusAttackDamage(Entity target, float baseAttackDamage, DamageSource damageSource) {
        if(damageSource.getSource() instanceof LivingEntity livingEntity){
            if(shouldDealExtraDamage(livingEntity)){
                return this.getMaterial().getAttackDamage() * 0.30F;
            }
        }
        return 0.0F;
    }

    public ToolMaterial getMaterial() {
        return material;
    }

    private boolean shouldDealExtraDamage(LivingEntity attacker) {
        if(attacker instanceof PlayerEntity player){
            return player.fallDistance > 0.005F;
        }
        return false;
    }
}
