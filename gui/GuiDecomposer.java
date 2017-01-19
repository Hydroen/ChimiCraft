package be.hydroen.chimicraft.gui;

import org.lwjgl.opengl.GL11;

import be.hydroen.chimicraft.common.ModChimiCraft;
import be.hydroen.chimicraft.container.ContainerDecomposer;
import be.hydroen.chimicraft.tileentity.TileEntityDecomposer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiDecomposer extends GuiContainer 
{
	private static final ResourceLocation texture = new ResourceLocation(ModChimiCraft.MODID, "textures/gui/container/guidecomposer.png");
	
	private TileEntityDecomposer tileDecomposer;
	private IInventory playerInv;
	
	public GuiDecomposer(TileEntityDecomposer tile, InventoryPlayer inventory)
	{
		super(new ContainerDecomposer(tile, inventory));
		this.tileDecomposer = tile;
		this.playerInv = inventory;
		this.allowUserInput = false;
		this.xSize = 256;
		this.ySize = 256;
	}
	
	protected void drawGuiContainerForegroundLayer(float partialRenderTick, int x, int y)
	{
		this.fontRendererObj.drawString(this.playerInv.hasCustomInventoryName() ? this.playerInv.getInventoryName() : I18n.format(this.playerInv.getInventoryName()), 10, this.ySize - 98, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialRenderTick, int x, int y)
	{
		GL11.glColor4f(1.0f, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		this.drawTexturedModalRect(0, 0, 176, 14, 100 + 1, 16);
	}
}
