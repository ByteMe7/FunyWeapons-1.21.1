package net.funkystudios.funkyweapons.util;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.funkystudios.funkyweapons.item.utiil.ModItemTags;
import net.funkystudios.funkyweapons.item.custom.HammerItem;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

public class ExpandedMiningToolUsageEvent implements PlayerBlockBreakEvents.Before {
    // Done with the help of https://github.com/CoFH/CoFHCore/blob/c23d117dcd3b3b3408a138716b15507f709494cd/src/main/java/cofh/core/event/AreaEffectEvents.java
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    @Override
    public boolean beforeBlockBreak(World world, PlayerEntity player, BlockPos pos,
                                    BlockState state, @Nullable BlockEntity blockEntity) {
        ItemStack mainHandItem = player.getMainHandStack();

        if(isExpandable(mainHandItem)
                && mainHandItem.getItem() instanceof MiningToolItem tool
                && player instanceof ServerPlayerEntity serverPlayer) {
            if(HARVESTED_BLOCKS.contains(pos)) {
                return true;
            }

            for(BlockPos position : HammerItem.getBlocksToBeDestroyed(1, pos, serverPlayer)) {
                if(pos == position || !tool.isCorrectForDrops(mainHandItem, world.getBlockState(position))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(position);
                serverPlayer.interactionManager.tryBreakBlock(position);
                HARVESTED_BLOCKS.remove(position);
            }
        }

        return true;
    }


    private static boolean isExpandable(ItemStack tool){
        return tool.isIn(ModItemTags.EXPANDABLE_MINING_TOOL) ;
    }
}
