package net.rotgruengelb.travel_overhaul.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class NyliumPathBlock extends PathBlock {
    public NyliumPathBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        setToBase(null, state, world, pos, Blocks.NETHERRACK);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return manageGetPlacementState(ctx, Blocks.NETHERRACK);
    }
}
