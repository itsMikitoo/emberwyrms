package io.emberwyrms.entity;

import net.minecraft.entity.Entity;

/** Mide cuanto se mueve la entidad (cliente y servidor) para animar las patas. */
public class AnimTracker {
    public float speed;
    public float phase;
    private float step;
    private double lastX;
    private double lastZ;
    private boolean started;

    public void update(Entity e) {
        if (!started) {
            lastX = e.getX();
            lastZ = e.getZ();
            started = true;
        }
        double dx = e.getX() - lastX;
        double dz = e.getZ() - lastZ;
        lastX = e.getX();
        lastZ = e.getZ();
        float dist = Math.min(1f, (float) Math.sqrt(dx * dx + dz * dz) * 4f);
        speed += (dist - speed) * 0.4f;
        step = speed;
        phase += step;
    }

    public float phaseAt(float tickDelta) {
        return phase - step * (1f - tickDelta);
    }
}
