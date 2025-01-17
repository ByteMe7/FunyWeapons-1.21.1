package net.funkystudios.funkyweapons.item.custom;

import net.funkystudios.funkyweapons.block.ModBlockTags;
import net.minecraft.block.Block;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class ChainsawItem extends AxeItem {
    private static final int range = 20;
    public ChainsawItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed,settings);
    }



    public static List<BlockPos> getBlocksToBeDestroyed(BlockPos initalBlockPos, ServerPlayerEntity player) {
        List<BlockPos> positions = new ArrayList<>();
        HitResult hit = player.raycast(20, 0, false);
        if(hit.getType() == HitResult.Type.BLOCK){
            for(int x = -range; x <= range; x++){
                for (int z = -range; z <= range; z++){
                    for (int y = -range; y <= range; y++){
                        BlockPos newPos = new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY() + y, initalBlockPos.getZ() + z);
                        if(isInBlocks(newPos, player.getServerWorld())){
                            positions.add(newPos);
                        }
                    }
                }
            }
        }

        return positions;
    }

    private static boolean isInBlocks(BlockPos pos, World world){
        return world.getBlockState(pos).isIn(ModBlockTags.TREE_FELL_BLOCKS);
    }
}
