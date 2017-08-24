package bitmovers.elementaldimensions;

import bitmovers.elementaldimensions.blocks.GenericBlock;
import bitmovers.elementaldimensions.items.GenericItem;
import elec332.core.util.RegistryHelper;
import net.minecraft.block.Block;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientForgeEventHandlers {

    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {
        for (Block block : RegistryHelper.getBlockRegistry().getValues()){
            if (block instanceof GenericBlock){
                ((GenericBlock) block).initClient();
            }
        }
        DelayedRegister.getItems().forEach(item -> {
            if (item instanceof GenericItem) {
                ((GenericItem) item).initModel();
            }
        });
    }

}
