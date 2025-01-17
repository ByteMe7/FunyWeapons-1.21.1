package net.funkystudios.funkyweapons.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.funkystudios.funkyweapons.FunkyWeapons;
import net.funkystudios.funkyweapons.fluid.ModFluids;
import net.funkystudios.funkyweapons.item.custom.*;
import net.funkystudios.funkyweapons.item.utiil.ModFoodComponents;
import net.funkystudios.funkyweapons.item.utiil.ModToolMaterials;
import net.funkystudios.funkyweapons.util.Constants.Colors;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    public static final Item TURQUOISE;
    public static final Item RAW_TURQUOISE;
    public static final Item TURQUOISE_ALLOY_INGOT;
    public static final Item TURQUOISE_ALLOY_NUGGET;
    public static final Item TURQUOISE_SWORD;
    public static final Item TURQUOISE_PICKAXE;
    public static final Item TURQUOISE_SHOVEL;
    public static final Item TURQUOISE_AXE;
    public static final Item TURQUOISE_HOE;
    public static final Item TURQUOISE_HAMMER;
    public static final Item CANDY_CANE;
    public static final Item CANDY_CANE_SWORD;
    public static final Item CANDY_CANE_PICKAXE;
    public static final Item CANDY_CANE_SHOVEL;
    public static final Item CANDY_CANE_AXE;
    public static final Item CANDY_CANE_HOE;
    public static final Item CANDY_CANE_HAMMER;
    public static final Item CANDY_CANE_BOW;
    public static final Item CHAINSAW;
    public static final Item WOODEN_HAMMER;
    public static final Item STONE_HAMMER;
    public static final Item IRON_HAMMER;
    public static final Item GOLD_HAMMER;
    public static final Item DIAMOND_HAMMER;
    public static final Item NETHERITE_HAMMER;
    public static final Item WOODEN_MACUAHUITL;
    public static final Item STONE_MACUAHUITL;
    public static final Item IRON_MACUAHUITL;
    public static final Item GOLD_MACUAHUITL;
    public static final Item DIAMOND_MACUAHUITL;
    public static final Item NETHERITE_MACUAHUITL;
    public static final Item OBSIDIAN_MACUAHUITL;
    public static final Item TURQUOISE_OBSIDIAN_MACUAHUITL;
    public static final Item WOODEN_SHARD;
    public static final Item STONE_FRAGMENT;
    public static final Item IRON_FRAGMENT;
    public static final Item GOLD_FRAGMENT;
    public static final Item DIAMOND_SHARD;
    public static final Item NETHERITE_FRAGMENT;
    public static final Item OBSIDIAN_SHARD;
    public static final Item TURQUOISE_OBSIDIAN_SHARD;
    public static final Item WOODEN_SPIKE;
    public static final Item STONE_SPIKE;
    public static final Item IRON_SPIKE;
    public static final Item GOLD_SPIKE;
    public static final Item DIAMOND_SPIKE;
    public static final Item NETHERITE_SPIKE;
    public static final Item OBSIDIAN_SPIKE;
    public static final Item TURQUOISE_OBSIDIAN_SPIKE;
    public static final Item CLAY_MUG;
    public static final Item MUG;
    public static final Item HOT_CHOCOLATE;
    public static final Item PABLANO_PEPPER;
    public static final Item APACHE_TEARS_BUCKET;
    public static final Item OBSIDIAN_TEARS_BUCKET;
    public static final Item RUSTY_WATER_BUCKET;


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(FunkyWeapons.MOD_ID, name), item);
    }

    private static Item registerSwordItem(String name, ToolMaterial material){
        return registerSwordItem(name, material, new Item.Settings());
    }

    private static Item registerSwordItem(String name, ToolMaterial material, Item.Settings settings){
        return registerItem(name, new SwordItem(material, settings.attributeModifiers(SwordItem.createAttributeModifiers(material, 3, -2.4F))));
    }

    private static Item registerAxeItem(String name, ToolMaterial material){
        return registerAxeItem(name, material, new Item.Settings());
    }

    private static Item registerAxeItem(String name, ToolMaterial material, Item.Settings settings){
        return registerItem(name, new AxeItem(material, settings.attributeModifiers(AxeItem.createAttributeModifiers(material, 6, -3.2F))));
    }

    private static Item registerPickaxeItem(String name, ToolMaterial material){
        return registerPickaxeItem(name, material, new Item.Settings());
    }

    private static Item registerPickaxeItem(String name, ToolMaterial material, Item.Settings settings){
        return registerItem(name, new PickaxeItem(material, settings.attributeModifiers(PickaxeItem.createAttributeModifiers(material, 1, -2.8F))));
    }

    private static Item registerShovelItem(String name, ToolMaterial material){
        return registerShovelItem(name, material, new Item.Settings());
    }

    private static Item registerShovelItem(String name, ToolMaterial material, Item.Settings settings){
        return registerItem(name, new ShovelItem(material, settings.attributeModifiers(ShovelItem.createAttributeModifiers(material, 1.5F, -3.0F))));
    }

    private static Item registerHoeItem(String name, ToolMaterial material){
        return registerHoeItem(name, material, new Item.Settings());
    }

    private static Item registerHoeItem(String name, ToolMaterial material, Item.Settings settings){
        return registerItem(name, new HoeItem(material, settings.attributeModifiers(HoeItem.createAttributeModifiers(material, 0, -3.0F))));
    }

    private static Item registerHammerItem(String name, ToolMaterial material){
        return registerHammerItem(name, material, new Item.Settings());
    }

    private static Item registerHammerItem(String name, ToolMaterial material, Item.Settings settings){
        return registerItem(name, new HammerItem(material, 5, -1.5F, settings));
    }

    private static Item registerMacuahuitlItem(String name, ToolMaterial material){
        return registerMacuahuitlItem(name, material, new Item.Settings());
    }

    private static Item registerMacuahuitlItem(String name, ToolMaterial material, Item.Settings settings){
        return registerItem(name, new MacuahuitlItem(material, 7, -1.2F, settings));
    }
    
    public static void register(){
        FunkyWeapons.LOGGER.info("Registering items for: " + FunkyWeapons.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(TURQUOISE);
            entries.add(RAW_TURQUOISE);
            entries.add(TURQUOISE_ALLOY_INGOT);
            entries.add(TURQUOISE_ALLOY_NUGGET);

            entries.add(WOODEN_SHARD);
            entries.add(STONE_FRAGMENT);
            entries.add(IRON_FRAGMENT);
            entries.add(GOLD_FRAGMENT);
            entries.add(DIAMOND_SHARD);
            entries.add(NETHERITE_FRAGMENT);
            entries.add(OBSIDIAN_SHARD);
            entries.add(TURQUOISE_OBSIDIAN_SHARD);

            entries.add(WOODEN_SPIKE);
            entries.add(STONE_SPIKE);
            entries.add(IRON_SPIKE);
            entries.add(GOLD_SPIKE);
            entries.add(DIAMOND_SPIKE);
            entries.add(NETHERITE_SPIKE);
            entries.add(OBSIDIAN_SPIKE);
            entries.add(TURQUOISE_OBSIDIAN_SPIKE);

            entries.add(CLAY_MUG);
            entries.add(MUG);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(CANDY_CANE);
            entries.add(HOT_CHOCOLATE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries ->{

            entries.add(TURQUOISE_SWORD);
            entries.add(TURQUOISE_AXE);
            entries.add(CANDY_CANE_SWORD);
            entries.add(CANDY_CANE_AXE);
            entries.add(CANDY_CANE_BOW);

            entries.add(WOODEN_MACUAHUITL);
            entries.add(STONE_MACUAHUITL);
            entries.add(IRON_MACUAHUITL);
            entries.add(GOLD_MACUAHUITL);
            entries.add(DIAMOND_MACUAHUITL);
            entries.add(NETHERITE_HAMMER);
            entries.add(OBSIDIAN_MACUAHUITL);
            entries.add(TURQUOISE_OBSIDIAN_MACUAHUITL);

        } );

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {

            entries.add(WOODEN_HAMMER);
            entries.add(STONE_HAMMER);
            entries.add(IRON_HAMMER);
            entries.add(GOLD_HAMMER);
            entries.add(DIAMOND_HAMMER);
            entries.add(NETHERITE_HAMMER);

            entries.add(TURQUOISE_PICKAXE);
            entries.add(TURQUOISE_SHOVEL);
            entries.add(TURQUOISE_HOE);
            entries.add(TURQUOISE_HAMMER);

            entries.add(CANDY_CANE_PICKAXE);
            entries.add(CANDY_CANE_SHOVEL);
            entries.add(CANDY_CANE_HOE);
            entries.add(CANDY_CANE_HAMMER);

        });
    }

    static {
        RAW_TURQUOISE = registerItem("raw_turquoise", new Item(new Item.Settings()));
        TURQUOISE = registerItem("turquoise", new Item(new Item.Settings()));
        TURQUOISE_ALLOY_INGOT = registerItem("turquoise_alloy_ingot", new Item(new Item.Settings()));
        TURQUOISE_ALLOY_NUGGET = registerItem("turqoise_alloy_nugget", new Item(new Item.Settings().fireproof()));

        TURQUOISE_SWORD = registerSwordItem("turquoise_sword", ModToolMaterials.TURQUOISE);
        TURQUOISE_PICKAXE = registerPickaxeItem("turquoise_pickaxe", ModToolMaterials.TURQUOISE);
        TURQUOISE_SHOVEL = registerShovelItem("turquoise_shovel", ModToolMaterials.TURQUOISE);
        TURQUOISE_AXE = registerAxeItem("turquoise_axe", ModToolMaterials.TURQUOISE);
        TURQUOISE_HOE = registerHoeItem("turquoise_hoe", ModToolMaterials.TURQUOISE);
        TURQUOISE_HAMMER = registerHammerItem("turquoise_hammer", ModToolMaterials.TURQUOISE);

        CANDY_CANE = registerItem("candy_cane", new Item(new Item.Settings().food(ModFoodComponents.CANDY_CANE)));

        CANDY_CANE_SWORD = registerSwordItem("candy_cane_sword", ModToolMaterials.CANDY_CANE, new Item.Settings().food(ModFoodComponents.CANDY_CANE));
        CANDY_CANE_PICKAXE = registerPickaxeItem("candy_cane_pickaxe", ModToolMaterials.CANDY_CANE, new Item.Settings().food(ModFoodComponents.CANDY_CANE));
        CANDY_CANE_SHOVEL = registerShovelItem("candy_cane_shovel", ModToolMaterials.CANDY_CANE, new Item.Settings().food(ModFoodComponents.CANDY_CANE));
        CANDY_CANE_AXE = registerAxeItem("candy_cane_axe", ModToolMaterials.CANDY_CANE, new Item.Settings().food(ModFoodComponents.CANDY_CANE));
        CANDY_CANE_HOE = registerHoeItem("candy_cane_hoe", ModToolMaterials.CANDY_CANE, new Item.Settings().food(ModFoodComponents.CANDY_CANE));
        CANDY_CANE_HAMMER = registerHammerItem("candy_cane_hammer", ModToolMaterials.CANDY_CANE, new Item.Settings().food(ModFoodComponents.CANDY_CANE));
        CANDY_CANE_BOW = registerItem("candy_cane_bow", new EdibleBowItem(ModToolMaterials.CANDY_CANE, ModFoodComponents.CANDY_CANE, false, new Item.Settings()){
            @Override
            public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                tooltip.add(Text.translatable("item.funkyweapons.candy_cane_bow.tooltip0").formatted(Formatting.RED));
                tooltip.add(Text.translatable("item.funkyweapons.candy_cane_bow.tooltip1").formatted(Formatting.RED));
            }
        });

        CHAINSAW = registerItem("chainsaw", new ChainsawItem(ToolMaterials.IRON, 7, -1.2F,new Item.Settings()));

        WOODEN_HAMMER = registerHammerItem("wooden_hammer", ToolMaterials.WOOD);
        STONE_HAMMER = registerHammerItem("stone_hammer", ToolMaterials.STONE);
        IRON_HAMMER = registerHammerItem("iron_hammer", ToolMaterials.IRON);
        GOLD_HAMMER = registerHammerItem("gold_hammer", ToolMaterials.GOLD);
        DIAMOND_HAMMER = registerHammerItem("diamond_hammer", ToolMaterials.DIAMOND);
        NETHERITE_HAMMER = registerHammerItem("netherite_hammer", ToolMaterials.NETHERITE, new Item.Settings().fireproof());

        WOODEN_MACUAHUITL = registerMacuahuitlItem("wooden_macuahuitl", ToolMaterials.WOOD);
        STONE_MACUAHUITL = registerMacuahuitlItem("stone_macuahuitl", ToolMaterials.STONE);
        IRON_MACUAHUITL = registerMacuahuitlItem("iron_macuahuitl", ToolMaterials.IRON);
        GOLD_MACUAHUITL = registerMacuahuitlItem("gold_macuahuitl", ToolMaterials.GOLD);
        DIAMOND_MACUAHUITL = registerMacuahuitlItem("diamond_macuahuitl", ToolMaterials.DIAMOND);
        NETHERITE_MACUAHUITL = registerMacuahuitlItem("netherite_macuahitl", ToolMaterials.NETHERITE, new Item.Settings().fireproof());
        OBSIDIAN_MACUAHUITL = registerMacuahuitlItem("obsidian_macuahuitl", ModToolMaterials.OBSIDIAN, new Item.Settings().fireproof());
        TURQUOISE_OBSIDIAN_MACUAHUITL = registerMacuahuitlItem("turquoise_obsidian_macuahuitl", ModToolMaterials.TURQUOISE_OBSIDIAN, new Item.Settings().fireproof());

        WOODEN_SHARD = registerItem("wooden_shard", new Item(new Item.Settings()));
        STONE_FRAGMENT = registerItem("stone_fragment", new Item(new Item.Settings()));
        IRON_FRAGMENT = registerItem("iron_fragment", new Item(new Item.Settings()));
        GOLD_FRAGMENT = registerItem("gold_fragment", new Item(new Item.Settings()));
        DIAMOND_SHARD = registerItem("diamond_shard", new Item(new Item.Settings()));
        NETHERITE_FRAGMENT = registerItem("netherite_fragment", new Item(new Item.Settings().fireproof()));
        OBSIDIAN_SHARD = registerItem("obsidian_shard", new Item(new Item.Settings()));
        TURQUOISE_OBSIDIAN_SHARD = registerItem("turquoise_obsidian_shard", new Item(new Item.Settings()));

        WOODEN_SPIKE = registerItem("wooden_spike", new Item(new Item.Settings()));
        STONE_SPIKE = registerItem("stone_spike", new Item(new Item.Settings()));
        IRON_SPIKE = registerItem("iron_spike", new Item(new Item.Settings()));
        GOLD_SPIKE = registerItem("gold_spike", new Item(new Item.Settings()));
        DIAMOND_SPIKE = registerItem("diamond_spike", new Item(new Item.Settings()));
        NETHERITE_SPIKE = registerItem("netherite_spike", new Item(new Item.Settings().fireproof()));
        OBSIDIAN_SPIKE = registerItem("obsidian_spike", new Item(new Item.Settings().fireproof()));
        TURQUOISE_OBSIDIAN_SPIKE = registerItem("turquoise_obsidian_spike", new Item(new Item.Settings().fireproof()));

        CLAY_MUG = registerItem("clay_mug", new Item(new Item.Settings()));
        MUG = registerItem("mug", new Item(new Item.Settings()));

        HOT_CHOCOLATE = registerItem("hot_chocolate", new DrinkItem(60, MUG, new Item.Settings().maxCount(16).food(ModFoodComponents.HOT_CHOCOLATE)));
        PABLANO_PEPPER = registerItem("pablano_pepper", new Item(new Item.Settings()));

        APACHE_TEARS_BUCKET = registerItem("apache_tears_bucket", new CustomBucketItem(ModFluids.APACHE_TEARS_STILL, Colors.APACHE_TEARS.getIntColor(), new Item.Settings()));
        OBSIDIAN_TEARS_BUCKET = registerItem("obsidian_tears_bucket", new CustomBucketItem(ModFluids.OBSIDIAN_TEARS_STILL, Colors.OBSIDIAN_TEARS.getIntColor(), new Item.Settings()));
        RUSTY_WATER_BUCKET = registerItem("rusty_water_bucket", new CustomBucketItem(ModFluids.RUSTY_WATER_STILL, Colors.RUSTY_WATER.getIntColor(), new Item.Settings()));
    }
}
