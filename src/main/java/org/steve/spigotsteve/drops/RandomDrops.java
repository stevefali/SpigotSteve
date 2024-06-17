package org.steve.spigotsteve.drops;

import org.bukkit.Material;
import java.util.*;

public class RandomDrops {
    private static ArrayList<Material> masterList;
    private static ArrayList<Material> shuffledList;

    public static void shuffleItems(long gameSeed) {
        masterList = new ArrayList<>();
        masterList.addAll(List.of(Material.values()));
        masterList.removeAll(List.of(excludeItems));
        masterList.sort(Comparator.comparing(Material::toString));

        shuffledList = new ArrayList<>(masterList);
        Collections.shuffle(shuffledList, new Random(gameSeed));
    }

    public static Material getRandomizedItem(Material vanillaItem) {

        if (masterList != null) {
            int index = masterList.indexOf(vanillaItem);

            if (index == -1) {
                return vanillaItem;
            } else {
                return shuffledList.get(index);
            }
        }
        else {
            return vanillaItem;
        }
    }

    public static ArrayList<Material> getShuffledList() {
        return shuffledList;
    }


    private static Material[] excludeItems = {
            Material.AIR,
            Material.BEDROCK,
            Material.SPAWNER,
            Material.FARMLAND,
            Material.END_PORTAL_FRAME,
            Material.COMMAND_BLOCK,
            Material.BARRIER,
            Material.LIGHT,
            Material.REPEATING_COMMAND_BLOCK,
            Material.CHAIN_COMMAND_BLOCK,
            Material.STRUCTURE_VOID,
            Material.STRUCTURE_BLOCK,
            Material.JIGSAW,
            Material.ALLAY_SPAWN_EGG,
            Material.AXOLOTL_SPAWN_EGG,
            Material.BAT_SPAWN_EGG,
            Material.BEE_SPAWN_EGG,
            Material.BLAZE_SPAWN_EGG,
            Material.CAT_SPAWN_EGG,
            Material.CAMEL_SPAWN_EGG,
            Material.CAVE_SPIDER_SPAWN_EGG,
            Material.CHICKEN_SPAWN_EGG,
            Material.COD_SPAWN_EGG,
            Material.COW_SPAWN_EGG,
            Material.CREEPER_SPAWN_EGG,
            Material.DOLPHIN_SPAWN_EGG,
            Material.DONKEY_SPAWN_EGG,
            Material.DROWNED_SPAWN_EGG,
            Material.ELDER_GUARDIAN_SPAWN_EGG,
            Material.ENDER_DRAGON_SPAWN_EGG,
            Material.ENDERMAN_SPAWN_EGG,
            Material.ENDERMITE_SPAWN_EGG,
            Material.EVOKER_SPAWN_EGG,
            Material.FOX_SPAWN_EGG,
            Material.FROG_SPAWN_EGG,
            Material.GHAST_SPAWN_EGG,
            Material.GLOW_SQUID_SPAWN_EGG,
            Material.GOAT_SPAWN_EGG,
            Material.GUARDIAN_SPAWN_EGG,
            Material.HOGLIN_SPAWN_EGG,
            Material.HORSE_SPAWN_EGG,
            Material.HUSK_SPAWN_EGG,
            Material.IRON_GOLEM_SPAWN_EGG,
            Material.LLAMA_SPAWN_EGG,
            Material.MAGMA_CUBE_SPAWN_EGG,
            Material.MOOSHROOM_SPAWN_EGG,
            Material.MULE_SPAWN_EGG,
            Material.OCELOT_SPAWN_EGG,
            Material.PANDA_SPAWN_EGG,
            Material.PARROT_SPAWN_EGG,
            Material.PHANTOM_SPAWN_EGG,
            Material.PIG_SPAWN_EGG,
            Material.PIGLIN_SPAWN_EGG,
            Material.PIGLIN_BRUTE_SPAWN_EGG,
            Material.PILLAGER_SPAWN_EGG,
            Material.POLAR_BEAR_SPAWN_EGG,
            Material.PUFFERFISH_SPAWN_EGG,
            Material.RABBIT_SPAWN_EGG,
            Material.RAVAGER_SPAWN_EGG,
            Material.SALMON_SPAWN_EGG,
            Material.SHEEP_SPAWN_EGG,
            Material.SHULKER_SPAWN_EGG,
            Material.SILVERFISH_SPAWN_EGG,
            Material.SKELETON_SPAWN_EGG,
            Material.SKELETON_HORSE_SPAWN_EGG,
            Material.SLIME_SPAWN_EGG,
            Material.SNIFFER_SPAWN_EGG,
            Material.SNOW_GOLEM_SPAWN_EGG,
            Material.SPIDER_SPAWN_EGG,
            Material.SQUID_SPAWN_EGG,
            Material.STRAY_SPAWN_EGG,
            Material.STRIDER_SPAWN_EGG,
            Material.TADPOLE_SPAWN_EGG,
            Material.TRADER_LLAMA_SPAWN_EGG,
            Material.TROPICAL_FISH_SPAWN_EGG,
            Material.TURTLE_SPAWN_EGG,
            Material.VEX_SPAWN_EGG,
            Material.VILLAGER_SPAWN_EGG,
            Material.VINDICATOR_SPAWN_EGG,
            Material.WANDERING_TRADER_SPAWN_EGG,
            Material.WARDEN_SPAWN_EGG,
            Material.WITCH_SPAWN_EGG,
            Material.WITHER_SPAWN_EGG,
            Material.WITHER_SKELETON_SPAWN_EGG,
            Material.WOLF_SPAWN_EGG,
            Material.ZOGLIN_SPAWN_EGG,
            Material.ZOMBIE_SPAWN_EGG,
            Material.ZOMBIE_HORSE_SPAWN_EGG,
            Material.ZOMBIE_VILLAGER_SPAWN_EGG,
            Material.ZOMBIFIED_PIGLIN_SPAWN_EGG,
            Material.SKELETON_SKULL,
            Material.WITHER_SKELETON_SKULL,
            Material.PLAYER_HEAD,
            Material.ZOMBIE_HEAD,
            Material.CREEPER_HEAD,
            Material.DRAGON_HEAD,
            Material.PIGLIN_HEAD,
            Material.COMMAND_BLOCK_MINECART,
            Material.DEBUG_STICK,
            Material.WATER,
            Material.LAVA,
            Material.PISTON_HEAD,
            Material.MOVING_PISTON,
            Material.WALL_TORCH,
            Material.FIRE,
            Material.SOUL_FIRE,
            Material.REDSTONE_WIRE,
            Material.OAK_WALL_SIGN,
            Material.SPRUCE_WALL_SIGN,
            Material.BIRCH_WALL_SIGN,
            Material.ACACIA_WALL_SIGN,
            Material.CHERRY_WALL_SIGN,
            Material.JUNGLE_WALL_SIGN,
            Material.DARK_OAK_WALL_SIGN,
            Material.MANGROVE_WALL_SIGN,
            Material.BAMBOO_WALL_SIGN,
            Material.OAK_WALL_HANGING_SIGN,
            Material.SPRUCE_WALL_HANGING_SIGN,
            Material.BIRCH_WALL_HANGING_SIGN,
            Material.ACACIA_WALL_HANGING_SIGN,
            Material.CHERRY_WALL_HANGING_SIGN,
            Material.JUNGLE_WALL_HANGING_SIGN,
            Material.DARK_OAK_WALL_HANGING_SIGN,
            Material.MANGROVE_WALL_HANGING_SIGN,
            Material.CRIMSON_WALL_HANGING_SIGN,
            Material.WARPED_WALL_HANGING_SIGN,
            Material.BAMBOO_WALL_HANGING_SIGN,
            Material.REDSTONE_WALL_TORCH,
            Material.SOUL_WALL_TORCH,
            Material.NETHER_PORTAL,
            Material.ATTACHED_PUMPKIN_STEM,
            Material.ATTACHED_MELON_STEM,
            Material.PUMPKIN_STEM,
            Material.MELON_STEM,
            Material.WATER_CAULDRON,
            Material.LAVA_CAULDRON,
            Material.POWDER_SNOW_CAULDRON,
            Material.END_PORTAL,
            Material.COCOA,
            Material.TRIPWIRE,
            Material.POTTED_TORCHFLOWER,
            Material.POTTED_OAK_SAPLING,
            Material.POTTED_SPRUCE_SAPLING,
            Material.POTTED_BIRCH_SAPLING,
            Material.POTTED_JUNGLE_SAPLING,
            Material.POTTED_ACACIA_SAPLING,
            Material.POTTED_CHERRY_SAPLING,
            Material.POTTED_DARK_OAK_SAPLING,
            Material.POTTED_MANGROVE_PROPAGULE,
            Material.POTTED_FERN,
            Material.POTTED_DANDELION,
            Material.POTTED_POPPY,
            Material.POTTED_BLUE_ORCHID,
            Material.POTTED_ALLIUM,
            Material.POTTED_AZURE_BLUET,
            Material.POTTED_RED_TULIP,
            Material.POTTED_ORANGE_TULIP,
            Material.POTTED_WHITE_TULIP,
            Material.POTTED_PINK_TULIP,
            Material.POTTED_OXEYE_DAISY,
            Material.POTTED_CORNFLOWER,
            Material.POTTED_LILY_OF_THE_VALLEY,
            Material.POTTED_WITHER_ROSE,
            Material.POTTED_RED_MUSHROOM,
            Material.POTTED_BROWN_MUSHROOM,
            Material.POTTED_DEAD_BUSH,
            Material.POTTED_CACTUS,
            Material.CARROTS,
            Material.POTATOES,
            Material.SKELETON_WALL_SKULL,
            Material.WITHER_SKELETON_WALL_SKULL,
            Material.ZOMBIE_WALL_HEAD,
            Material.PLAYER_WALL_HEAD,
            Material.CREEPER_WALL_HEAD,
            Material.DRAGON_WALL_HEAD,
            Material.PIGLIN_WALL_HEAD,
            Material.WHITE_WALL_BANNER,
            Material.ORANGE_WALL_BANNER,
            Material.MAGENTA_WALL_BANNER,
            Material.LIGHT_BLUE_WALL_BANNER,
            Material.YELLOW_WALL_BANNER,
            Material.LIME_WALL_BANNER,
            Material.PINK_WALL_BANNER,
            Material.GRAY_WALL_BANNER,
            Material.LIGHT_GRAY_WALL_BANNER,
            Material.CYAN_WALL_BANNER,
            Material.PURPLE_WALL_BANNER,
            Material.BLUE_WALL_BANNER,
            Material.BROWN_WALL_BANNER,
            Material.GREEN_WALL_BANNER,
            Material.RED_WALL_BANNER,
            Material.BLACK_WALL_BANNER,
            Material.TORCHFLOWER_CROP,
            Material.PITCHER_CROP,
            Material.BEETROOTS,
            Material.END_GATEWAY,
            Material.FROSTED_ICE,
            Material.KELP_PLANT,
            Material.DEAD_TUBE_CORAL_WALL_FAN,
            Material.DEAD_BRAIN_CORAL_WALL_FAN,
            Material.DEAD_BUBBLE_CORAL_WALL_FAN,
            Material.DEAD_FIRE_CORAL_WALL_FAN,
            Material.DEAD_HORN_CORAL_WALL_FAN,
            Material.TUBE_CORAL_WALL_FAN,
            Material.BRAIN_CORAL_WALL_FAN,
            Material.BUBBLE_CORAL_WALL_FAN,
            Material.FIRE_CORAL_WALL_FAN,
            Material.HORN_CORAL_WALL_FAN,
            Material.BAMBOO_SAPLING,
            Material.POTTED_BAMBOO,
            Material.VOID_AIR,
            Material.CAVE_AIR,
            Material.BUBBLE_COLUMN,
            Material.SWEET_BERRY_BUSH,
            Material.WEEPING_VINES_PLANT,
            Material.TWISTING_VINES_PLANT,
            Material.CRIMSON_WALL_SIGN,
            Material.WARPED_WALL_SIGN,
            Material.POTTED_CRIMSON_FUNGUS,
            Material.POTTED_WARPED_FUNGUS,
            Material.POTTED_CRIMSON_ROOTS,
            Material.POTTED_WARPED_ROOTS,
            Material.CANDLE_CAKE,
            Material.WHITE_CANDLE_CAKE,
            Material.ORANGE_CANDLE_CAKE,
            Material.MAGENTA_CANDLE_CAKE,
            Material.LIGHT_BLUE_CANDLE_CAKE,
            Material.YELLOW_CANDLE_CAKE,
            Material.LIME_CANDLE_CAKE,
            Material.PINK_CANDLE_CAKE,
            Material.GRAY_CANDLE_CAKE,
            Material.LIGHT_GRAY_CANDLE_CAKE,
            Material.CYAN_CANDLE_CAKE,
            Material.PURPLE_CANDLE_CAKE,
            Material.BLUE_CANDLE_CAKE,
            Material.BROWN_CANDLE_CAKE,
            Material.GREEN_CANDLE_CAKE,
            Material.RED_CANDLE_CAKE,
            Material.BLACK_CANDLE_CAKE,
            Material.POWDER_SNOW,
            Material.CAVE_VINES,
            Material.CAVE_VINES_PLANT,
            Material.BIG_DRIPLEAF_STEM,
            Material.POTTED_AZALEA_BUSH,
            Material.POTTED_FLOWERING_AZALEA_BUSH
    };

}
