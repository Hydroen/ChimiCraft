package be.hydroen.chimicraft.common;

import be.hydroen.chimicraft.gui.GuiHandlerChimiCraft;
import be.hydroen.chimicraft.items.ItemsChimiCraft;
import be.hydroen.chimicraft.tileentity.TileEntityComposer;
import be.hydroen.chimicraft.tileentity.TileEntityDecomposer;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

@Mod(modid = ModChimiCraft.MODID, name = "ModChimiCraft", version = "1.0.0")
public class ModChimiCraft 
{
	public static final String MODID = "chimicraft";
	
	public static CreativeTabs creativeTabsChimiCraft = new CreativeTabsChimiCraft("chimicraft_creative_tabs");
	
	@Instance(MODID)
	public static ModChimiCraft instance;
	
	@SidedProxy(clientSide = "be.hydroen.chimicraft.client.ClientProxy", serverSide = "be.hydroen.common.CommonProxy")
	public static CommonProxy proxy;
	
	public static Item itemchimicraft;
	public static Block blockComposer, blockDecomposer;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		// ITEMS
		itemchimicraft = new ItemsChimiCraft().setUnlocalizedName("hydrogene");
		GameRegistry.registerItem(itemchimicraft, "hydrogene");
		
		// BLOCKS
		blockComposer = new be.hydroen.chimicraft.blocks.BlockComposer(Material.rock).setBlockName("composer").setBlockTextureName(MODID + ":composer");		
		blockDecomposer = new be.hydroen.chimicraft.blocks.BlockDecomposer(Material.rock).setBlockName("decomposer").setBlockTextureName(MODID + ":decomposer");
		
		GameRegistry.registerBlock(blockComposer, "composer");
		GameRegistry.registerBlock(blockDecomposer, "decomposer");
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.registerRender();
		
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandlerChimiCraft());
		
		GameRegistry.registerTileEntity(TileEntityComposer.class, MODID + "TileEntityComposer");
		GameRegistry.registerTileEntity(TileEntityDecomposer.class, MODID + ":TileEntityDecomposer");
	}
	
	
}
