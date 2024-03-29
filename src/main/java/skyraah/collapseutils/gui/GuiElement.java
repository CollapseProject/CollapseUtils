package skyraah.collapseutils.gui;

import javax.annotation.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import skyraah.collapseutils.CollapseUtils;
import skyraah.collapseutils.block.tileentity.TileEntityBarrel;
import skyraah.collapseutils.gui.inventory.ContainerBarrel;
import skyraah.collapseutils.gui.inventory.GuiContainerBarrel;

/**
 * @author skyraah
 */
public class GuiElement implements IGuiHandler {

    public static final int GUI_BARREL = 1;

    public GuiElement() {
        NetworkRegistry.INSTANCE.registerGuiHandler(CollapseUtils.INSTANCE, this);
    }

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == GUI_BARREL) {
            TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
            if (te instanceof TileEntityBarrel) {
                return new ContainerBarrel(player.inventory, (TileEntityBarrel) te);
            }
        }
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == GUI_BARREL) {
            TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
            if (te instanceof TileEntityBarrel) {
                return new GuiContainerBarrel(new ContainerBarrel(player.inventory, (TileEntityBarrel) te));
            }
        }
        return null;
    }
}
