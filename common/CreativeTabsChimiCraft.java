package be.hydroen.chimicraft.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabsChimiCraft extends CreativeTabs 
{	
	public CreativeTabsChimiCraft(String lable) 
	{
		super(lable);
	}

	@Override
	public Item getTabIconItem() 
	{
		return Item.getItemFromBlock(ModChimiCraft.blockComposer);
	}
	
	@Override
	public boolean hasSearchBar()
	{
		return true;
	}
}
