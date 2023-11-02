package net.rotgruengelb.infracubed.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.rotgruengelb.infracubed.InfraCubed;
import net.rotgruengelb.infracubed.block.custom.NyliumPathBlock;

public class ModBlocks {
    public static final Block CRIMSON_NYLIUM_PATH = registerBlock("crimson_nylium_path", new NyliumPathBlock(FabricBlockSettings.copyOf(Blocks.DIRT_PATH).sounds(BlockSoundGroup.NYLIUM)));

    public static final Block WARPED_NYLIUM_PATH = registerBlock("warped_nylium_path", new NyliumPathBlock(FabricBlockSettings.copyOf(Blocks.DIRT_PATH).sounds(BlockSoundGroup.NYLIUM)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(InfraCubed.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(InfraCubed.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        InfraCubed.LOGGER.info("Registering ModBlocks for " + InfraCubed.MOD_ID);
    }
}