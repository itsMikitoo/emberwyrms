package io.emberwyrms.client;

import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.EntityModel;

/** GENERADO por tools/generate.py. Edita el generador, no este archivo. */
public class MedusaModel extends EntityModel<LivingEntityRenderState> {
    private final ModelPart coil1;
    private final ModelPart coil2;
    private final ModelPart coil3;
    private final ModelPart coil4;
    private final ModelPart coil5;
    private final ModelPart coil6;
    private final ModelPart torso;
    private final ModelPart head;
    private final ModelPart armL;
    private final ModelPart armR;
    private final ModelPart snake0;
    private final ModelPart snake0B;
    private final ModelPart snake0H;
    private final ModelPart snake1;
    private final ModelPart snake1B;
    private final ModelPart snake1H;
    private final ModelPart snake2;
    private final ModelPart snake2B;
    private final ModelPart snake2H;
    private final ModelPart snake3;
    private final ModelPart snake3B;
    private final ModelPart snake3H;
    private final ModelPart snake4;
    private final ModelPart snake4B;
    private final ModelPart snake4H;
    private final ModelPart snake5;
    private final ModelPart snake5B;
    private final ModelPart snake5H;
    private final ModelPart snake6;
    private final ModelPart snake6B;
    private final ModelPart snake6H;
    private final ModelPart snake7;
    private final ModelPart snake7B;
    private final ModelPart snake7H;

    public MedusaModel(ModelPart root) {
        super(root);
        this.coil1 = root.getChild("coil1");
        this.coil2 = coil1.getChild("coil2");
        this.coil3 = coil2.getChild("coil3");
        this.coil4 = coil3.getChild("coil4");
        this.coil5 = coil4.getChild("coil5");
        this.coil6 = coil5.getChild("coil6");
        this.torso = root.getChild("torso");
        this.head = torso.getChild("head");
        this.armL = torso.getChild("arm_l");
        this.armR = torso.getChild("arm_r");
        this.snake0 = head.getChild("snake0");
        this.snake0B = snake0.getChild("snake0_b");
        this.snake0H = snake0B.getChild("snake0_h");
        this.snake1 = head.getChild("snake1");
        this.snake1B = snake1.getChild("snake1_b");
        this.snake1H = snake1B.getChild("snake1_h");
        this.snake2 = head.getChild("snake2");
        this.snake2B = snake2.getChild("snake2_b");
        this.snake2H = snake2B.getChild("snake2_h");
        this.snake3 = head.getChild("snake3");
        this.snake3B = snake3.getChild("snake3_b");
        this.snake3H = snake3B.getChild("snake3_h");
        this.snake4 = head.getChild("snake4");
        this.snake4B = snake4.getChild("snake4_b");
        this.snake4H = snake4B.getChild("snake4_h");
        this.snake5 = head.getChild("snake5");
        this.snake5B = snake5.getChild("snake5_b");
        this.snake5H = snake5B.getChild("snake5_h");
        this.snake6 = head.getChild("snake6");
        this.snake6B = snake6.getChild("snake6_b");
        this.snake6H = snake6B.getChild("snake6_h");
        this.snake7 = head.getChild("snake7");
        this.snake7B = snake7.getChild("snake7_b");
        this.snake7H = snake7B.getChild("snake7_h");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData data = new ModelData();
        ModelPartData root = data.getRoot();
        ModelPartData coil1 = root.addChild("coil1", ModelPartBuilder.create()
                .uv(0, 0).cuboid(-5f, -4f, -5f, 10f, 8f, 10f),
                ModelTransform.of(0f, 20f, 2f, 0f, 0f, 0f));
        ModelPartData coil2 = coil1.addChild("coil2", ModelPartBuilder.create()
                .uv(98, 0).cuboid(-4f, -3.5f, 0f, 8f, 7f, 7f),
                ModelTransform.of(0f, 0f, 5f, 0f, 0.25f, 0f));
        ModelPartData coil3 = coil2.addChild("coil3", ModelPartBuilder.create()
                .uv(0, 18).cuboid(-3f, -3f, 0f, 6f, 6f, 7f),
                ModelTransform.of(0f, 0f, 7f, 0f, 0.25f, 0f));
        ModelPartData coil4 = coil3.addChild("coil4", ModelPartBuilder.create()
                .uv(38, 18).cuboid(-2.5f, -2.5f, 0f, 5f, 5f, 7f),
                ModelTransform.of(0f, 0f, 7f, 0f, 0.25f, 0f));
        ModelPartData coil5 = coil4.addChild("coil5", ModelPartBuilder.create()
                .uv(0, 31).cuboid(-1.5f, -1.5f, 0f, 3f, 3f, 7f),
                ModelTransform.of(0f, 0f, 7f, 0f, 0.25f, 0f));
        ModelPartData coil6 = coil5.addChild("coil6", ModelPartBuilder.create()
                .uv(50, 31).cuboid(-1f, -1f, 0f, 2f, 2f, 6f),
                ModelTransform.of(0f, 0f, 7f, 0f, 0.25f, 0f));
        ModelPartData torso = root.addChild("torso", ModelPartBuilder.create()
                .uv(40, 0).cuboid(-4f, -12f, -2.5f, 8f, 12f, 5f)
                .uv(98, 18).cuboid(-4.5f, -11f, -3f, 9f, 4f, 6f)
                .uv(20, 31).cuboid(-4.5f, -2f, -3f, 9f, 2f, 6f),
                ModelTransform.of(0f, 16f, -1f, 0f, 0f, 0f));
        ModelPartData head = torso.addChild("head", ModelPartBuilder.create()
                .uv(66, 0).cuboid(-4f, -8f, -4f, 8f, 8f, 8f)
                .uv(62, 18).cuboid(-4.5f, -7f, -4.5f, 9f, 1f, 9f),
                ModelTransform.of(0f, -12f, 0f, 0f, 0f, 0f));
        ModelPartData armL = torso.addChild("arm_l", ModelPartBuilder.create()
                .uv(26, 18).cuboid(-1.5f, -1f, -1.5f, 3f, 10f, 3f)
                .uv(66, 31).cuboid(-2f, 5f, -2f, 4f, 2f, 4f)
                .uv(82, 31).cuboid(-1.5f, 9f, -1.5f, 3f, 2f, 3f)
                .uv(108, 31).cuboid(-1.5f, 11f, -1.5f, 1f, 2f, 1f)
                .uv(108, 31).cuboid(-0.5f, 11f, -1.5f, 1f, 2f, 1f)
                .uv(108, 31).cuboid(0.5f, 11f, -1.5f, 1f, 2f, 1f),
                ModelTransform.of(5.5f, -11f, 0f, 0f, 0f, 0f));
        ModelPartData armR = torso.addChild("arm_r", ModelPartBuilder.create()
                .uv(26, 18).cuboid(-1.5f, -1f, -1.5f, 3f, 10f, 3f)
                .uv(66, 31).cuboid(-2f, 5f, -2f, 4f, 2f, 4f)
                .uv(82, 31).cuboid(-1.5f, 9f, -1.5f, 3f, 2f, 3f)
                .uv(108, 31).cuboid(-1.5f, 11f, -1.5f, 1f, 2f, 1f)
                .uv(108, 31).cuboid(-0.5f, 11f, -1.5f, 1f, 2f, 1f)
                .uv(108, 31).cuboid(0.5f, 11f, -1.5f, 1f, 2f, 1f),
                ModelTransform.of(-5.5f, -11f, 0f, 0f, 0f, 0f));
        ModelPartData snake0 = head.addChild("snake0", ModelPartBuilder.create()
                .uv(104, 31).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(3f, -7.5f, 0f, 0f, 0f, 0.6f));
        ModelPartData snake0B = snake0.addChild("snake0_b", ModelPartBuilder.create()
                .uv(104, 31).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(0f, -4f, 0f, 0f, 0f, 0.4f));
        ModelPartData snake0H = snake0B.addChild("snake0_h", ModelPartBuilder.create()
                .uv(94, 31).cuboid(-1f, -2f, -1.5f, 2f, 2f, 3f),
                ModelTransform.of(0f, -4f, 0f, 0f, 0f, 0f));
        ModelPartData snake1 = head.addChild("snake1", ModelPartBuilder.create()
                .uv(104, 31).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(2.1213f, -7.5f, 2.1213f, -0.4243f, 0f, 0.4243f));
        ModelPartData snake1B = snake1.addChild("snake1_b", ModelPartBuilder.create()
                .uv(104, 31).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(0f, -4f, 0f, -0.2828f, 0f, 0.2828f));
        ModelPartData snake1H = snake1B.addChild("snake1_h", ModelPartBuilder.create()
                .uv(94, 31).cuboid(-1f, -2f, -1.5f, 2f, 2f, 3f),
                ModelTransform.of(0f, -4f, 0f, 0f, 0f, 0f));
        ModelPartData snake2 = head.addChild("snake2", ModelPartBuilder.create()
                .uv(104, 31).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(0f, -7.5f, 3f, -0.6f, 0f, 0f));
        ModelPartData snake2B = snake2.addChild("snake2_b", ModelPartBuilder.create()
                .uv(104, 31).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(0f, -4f, 0f, -0.4f, 0f, 0f));
        ModelPartData snake2H = snake2B.addChild("snake2_h", ModelPartBuilder.create()
                .uv(94, 31).cuboid(-1f, -2f, -1.5f, 2f, 2f, 3f),
                ModelTransform.of(0f, -4f, 0f, 0f, 0f, 0f));
        ModelPartData snake3 = head.addChild("snake3", ModelPartBuilder.create()
                .uv(104, 31).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(-2.1213f, -7.5f, 2.1213f, -0.4243f, 0f, -0.4243f));
        ModelPartData snake3B = snake3.addChild("snake3_b", ModelPartBuilder.create()
                .uv(104, 31).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(0f, -4f, 0f, -0.2828f, 0f, -0.2828f));
        ModelPartData snake3H = snake3B.addChild("snake3_h", ModelPartBuilder.create()
                .uv(94, 31).cuboid(-1f, -2f, -1.5f, 2f, 2f, 3f),
                ModelTransform.of(0f, -4f, 0f, 0f, 0f, 0f));
        ModelPartData snake4 = head.addChild("snake4", ModelPartBuilder.create()
                .uv(104, 31).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(-3f, -7.5f, 0f, 0f, 0f, -0.6f));
        ModelPartData snake4B = snake4.addChild("snake4_b", ModelPartBuilder.create()
                .uv(104, 31).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(0f, -4f, 0f, 0f, 0f, -0.4f));
        ModelPartData snake4H = snake4B.addChild("snake4_h", ModelPartBuilder.create()
                .uv(94, 31).cuboid(-1f, -2f, -1.5f, 2f, 2f, 3f),
                ModelTransform.of(0f, -4f, 0f, 0f, 0f, 0f));
        ModelPartData snake5 = head.addChild("snake5", ModelPartBuilder.create()
                .uv(104, 31).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(-2.1213f, -7.5f, -2.1213f, 0.4243f, 0f, -0.4243f));
        ModelPartData snake5B = snake5.addChild("snake5_b", ModelPartBuilder.create()
                .uv(104, 31).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(0f, -4f, 0f, 0.2828f, 0f, -0.2828f));
        ModelPartData snake5H = snake5B.addChild("snake5_h", ModelPartBuilder.create()
                .uv(94, 31).cuboid(-1f, -2f, -1.5f, 2f, 2f, 3f),
                ModelTransform.of(0f, -4f, 0f, 0f, 0f, 0f));
        ModelPartData snake6 = head.addChild("snake6", ModelPartBuilder.create()
                .uv(104, 31).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(0f, -7.5f, -3f, 0.6f, 0f, 0f));
        ModelPartData snake6B = snake6.addChild("snake6_b", ModelPartBuilder.create()
                .uv(104, 31).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(0f, -4f, 0f, 0.4f, 0f, 0f));
        ModelPartData snake6H = snake6B.addChild("snake6_h", ModelPartBuilder.create()
                .uv(94, 31).cuboid(-1f, -2f, -1.5f, 2f, 2f, 3f),
                ModelTransform.of(0f, -4f, 0f, 0f, 0f, 0f));
        ModelPartData snake7 = head.addChild("snake7", ModelPartBuilder.create()
                .uv(104, 31).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(2.1213f, -7.5f, -2.1213f, 0.4243f, 0f, 0.4243f));
        ModelPartData snake7B = snake7.addChild("snake7_b", ModelPartBuilder.create()
                .uv(104, 31).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(0f, -4f, 0f, 0.2828f, 0f, 0.2828f));
        ModelPartData snake7H = snake7B.addChild("snake7_h", ModelPartBuilder.create()
                .uv(94, 31).cuboid(-1f, -2f, -1.5f, 2f, 2f, 3f),
                ModelTransform.of(0f, -4f, 0f, 0f, 0f, 0f));
        return TexturedModelData.of(data, 128, 128);
    }

    private static float sin(float v) { return (float) Math.sin(v); }
    private static float cos(float v) { return (float) Math.cos(v); }

    private static final float[] SNAKE_DX = {1f, 0.7071f, 0f, -0.7071f, -1f, -0.7071f, 0f, 0.7071f};
    private static final float[] SNAKE_DZ = {0f, 0.7071f, 1f, 0.7071f, 0f, -0.7071f, -1f, -0.7071f};

    @Override
    public void setAngles(LivingEntityRenderState s) {
        super.setAngles(s);
        float t = s.age;
        float f = s.limbFrequency * 0.6662f;
        float amp = Math.min(1f, s.limbAmplitudeMultiplier * 1.6f);
        float yawLook = s.relativeHeadYaw * 0.0174533f;
        float pitchLook = s.pitch * 0.0174533f;

        this.head.yaw = yawLook * 0.8f;
        this.head.pitch = pitchLook * 0.7f;
        this.torso.yaw = sin(t * 0.06f) * 0.05f + cos(f) * 0.15f * amp;
        this.torso.pivotY = 16f + sin(t * 0.08f) * 0.3f;

        float sw = 0.1f + 0.25f * amp;
        float sp = t * 0.07f + f * 0.5f;
        this.coil1.yaw = sin(sp) * sw;
        ModelPart[] coil = {coil2, coil3, coil4, coil5, coil6};
        for (int i = 0; i < coil.length; i++) {
            coil[i].yaw = 0.25f + sin(sp - 0.7f * (i + 1)) * (sw + 0.08f * i);
        }

        this.armL.pitch = -0.2f + cos(f) * 0.5f * amp;
        this.armR.pitch = -0.2f - cos(f) * 0.5f * amp;
        this.armL.roll = -0.12f + sin(t * 0.05f) * 0.03f;
        this.armR.roll = 0.12f - sin(t * 0.05f) * 0.03f;

        ModelPart[] a = {snake0, snake1, snake2, snake3, snake4, snake5, snake6, snake7};
        ModelPart[] b = {snake0B, snake1B, snake2B, snake3B, snake4B, snake5B, snake6B, snake7B};
        for (int i = 0; i < 8; i++) {
            float w = sin(t * 0.15f + i * 1.3f);
            a[i].roll = 0.6f * SNAKE_DX[i] + w * 0.22f;
            a[i].pitch = -0.6f * SNAKE_DZ[i] + sin(t * 0.13f + i) * 0.18f;
            b[i].roll = 0.4f * SNAKE_DX[i] + sin(t * 0.17f + i * 0.9f) * 0.3f;
            b[i].pitch = -0.4f * SNAKE_DZ[i] + cos(t * 0.15f + i) * 0.25f;
        }
    }
}
