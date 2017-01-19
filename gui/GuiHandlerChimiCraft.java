package be.hydroen.chimicraft.gui;


import be.hydroen.chimicraft.container.ContainerComposer;
import be.hydroen.chimicraft.container.ContainerDecomposer;
import be.hydroen.chimicraft.tileentity.TileEntityComposer;
import be.hydroen.chimicraft.tileentity.TileEntityDecomposer;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandlerChimiCraft implements IGuiHandler 
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity tile = world.getTileEntity(x, y, z);
		
		if(tile instanceof TileEntityComposer)
		{
			return new ContainerComposer((TileEntityComposer)tile, player.inventory);
		}
		if(tile instanceof TileEntityDecomposer)
		{
			return new ContainerDecomposer((TileEntityDecomposer)tile, player.inventory);
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity tile = world.getTileEntity(x, y, z);
		
		if(tile instanceof TileEntityComposer)
		{
			return new GuiComposer((TileEntityComposer)tile, player.inventory);
		}
		if(tile instanceof TileEntityDecomposer)
		{
			return new GuiDecomposer((TileEntityDecomposer)tile, player.inventory);
		}
		
		return null;
	}

}
