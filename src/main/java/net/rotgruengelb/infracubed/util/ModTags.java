package net.rotgruengelb.infracubed.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.rotgruengelb.infracubed.InfraCubed;

public class ModTags {

    public static void registerModTags() {
        InfraCubed.LOGGER.info("Registering ModTags for " + InfraCubed.MOD_ID);
    }

    public static class Blocks {

        public static final TagKey<Block> PATH_BLOCKS = createTag("path_blocks");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(InfraCubed.MOD_ID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(InfraCubed.MOD_ID, name));
        }
    }
}
