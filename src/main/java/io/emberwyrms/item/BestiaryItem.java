package io.emberwyrms.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

/** Bestiario: al usarlo abre una pantalla con la foto y la informacion de cada criatura (la pantalla la registra el cliente). */
public class BestiaryItem extends Item {
    /** El cliente pone aqui la accion de abrir la pantalla; en el servidor se queda en null. */
    public static Runnable open;

    public BestiaryItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient() && open != null) open.run();
        return ActionResult.SUCCESS;
    }
}
