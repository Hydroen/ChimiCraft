package be.hydroen.chimicraft.items;

import be.hydroen.chimicraft.common.ModChimiCraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemsChimiCraft extends Item
{
	@Override
	public void registerIcons(IIconRegister iconregister)
	{
		this.itemIcon = iconregister.registerIcon(ModChimiCraft.MODID + ":hydrogene");
		this.setCreativeTab(ModChimiCraft.creativeTabsChimiCraft);
	}
}
