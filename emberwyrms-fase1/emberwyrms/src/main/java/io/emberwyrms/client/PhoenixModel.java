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
public class PhoenixModel extends EntityModel<PhoenixRenderState> {
    private final ModelPart body;
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart crest0;
    private final ModelPart crest1;
    private final ModelPart crest2;
    private final ModelPart wingL;
    private final ModelPart wingOutL;
    private final ModelPart prim0L;
    private final ModelPart prim1L;
    private final ModelPart prim2L;
    private final ModelPart prim3L;
    private final ModelPart legL;
    private final ModelPart shinL;
    private final ModelPart footL;
    private final ModelPart wingR;
    private final ModelPart wingOutR;
    private final ModelPart prim0R;
    private final ModelPart prim1R;
    private final ModelPart prim2R;
    private final ModelPart prim3R;
    private final ModelPart legR;
    private final ModelPart shinR;
    private final ModelPart footR;
    private final ModelPart tail;
    private final ModelPart tail0;
    private final ModelPart tail1;
    private final ModelPart tail2;
    private final ModelPart tail3;
    private final ModelPart tail4;

    public PhoenixModel(ModelPart root) {
        super(root);
        this.body = root.getChild("body");
        this.neck = body.getChild("neck");
        this.head = neck.getChild("head");
        this.crest0 = head.getChild("crest_0");
        this.crest1 = head.getChild("crest_1");
        this.crest2 = head.getChild("crest_2");
        this.wingL = body.getChild("wing_l");
        this.wingOutL = wingL.getChild("wing_out_l");
        this.prim0L = wingOutL.getChild("prim_0_l");
        this.prim1L = wingOutL.getChild("prim_1_l");
        this.prim2L = wingOutL.getChild("prim_2_l");
        this.prim3L = wingOutL.getChild("prim_3_l");
        this.legL = body.getChild("leg_l");
        this.shinL = legL.getChild("shin_l");
        this.footL = shinL.getChild("foot_l");
        this.wingR = body.getChild("wing_r");
        this.wingOutR = wingR.getChild("wing_out_r");
        this.prim0R = wingOutR.getChild("prim_0_r");
        this.prim1R = wingOutR.getChild("prim_1_r");
        this.prim2R = wingOutR.getChild("prim_2_r");
        this.prim3R = wingOutR.getChild("prim_3_r");
        this.legR = body.getChild("leg_r");
        this.shinR = legR.getChild("shin_r");
        this.footR = shinR.getChild("foot_r");
        this.tail = body.getChild("tail");
        this.tail0 = tail.getChild("tail_0");
        this.tail1 = tail.getChild("tail_1");
        this.tail2 = tail.getChild("tail_2");
        this.tail3 = tail.getChild("tail_3");
        this.tail4 = tail.getChild("tail_4");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData data = new ModelData();
        ModelPartData root = data.getRoot();
        ModelPartData body = root.addChild("body", ModelPartBuilder.create()
                .uv(74, 0).cuboid(-3f, -3f, -6f, 6f, 6f, 10f)
                .uv(102, 19).cuboid(-2.5f, -2f, -8f, 5f, 5f, 2f),
                ModelTransform.of(0f, 16f, 0f, 0f, 0f, 0f));
        ModelPartData neck = body.addChild("neck", ModelPartBuilder.create()
                .uv(28, 19).cuboid(-1.5f, -1.5f, -5f, 3f, 3f, 6f),
                ModelTransform.of(0f, -1f, -6f, -0.5f, 0f, 0f));
        ModelPartData head = neck.addChild("head", ModelPartBuilder.create()
                .uv(46, 19).cuboid(-2f, -2f, -4f, 4f, 4f, 4f)
                .uv(38, 38).cuboid(-1f, -0.5f, -7f, 2f, 1f, 3f)
                .uv(56, 38).cuboid(-1f, 0.5f, -6f, 2f, 1f, 2f)
                .uv(74, 38).cuboid(1.7f, -1.2f, -3f, 1f, 1f, 1f)
                .uv(74, 38).cuboid(-2.7f, -1.2f, -3f, 1f, 1f, 1f),
                ModelTransform.of(0f, 0f, -5f, 0.5f, 0f, 0f));
        ModelPartData crest0 = head.addChild("crest_0", ModelPartBuilder.create()
                .uv(62, 19).cuboid(-0.5f, -0.5f, 0f, 1f, 1f, 7f),
                ModelTransform.of(0f, -2f, -1f, 0.9f, 0f, 0f));
        ModelPartData crest1 = head.addChild("crest_1", ModelPartBuilder.create()
                .uv(22, 32).cuboid(-0.5f, -0.5f, 0f, 1f, 1f, 5f),
                ModelTransform.of(0f, -2f, -1f, 0.7f, 0.35f, 0f));
        ModelPartData crest2 = head.addChild("crest_2", ModelPartBuilder.create()
                .uv(22, 32).cuboid(-0.5f, -0.5f, 0f, 1f, 1f, 5f),
                ModelTransform.of(0f, -2f, -1f, 0.7f, -0.35f, 0f));
        ModelPartData wingL = body.addChild("wing_l", ModelPartBuilder.create()
                .uv(20, 38).cuboid(0f, -0.5f, -1.5f, 6f, 1f, 3f)
                .uv(78, 19).cuboid(0f, -0.5f, 1.5f, 6f, 1f, 6f),
                ModelTransform.of(3f, -2f, -2f, 0f, 0f, 0f));
        ModelPartData wingOutL = wingL.addChild("wing_out_l", ModelPartBuilder.create()
                .uv(20, 38).cuboid(0f, -0.5f, -1.5f, 6f, 1f, 3f)
                .uv(0, 32).cuboid(0f, -0.5f, 1.5f, 6f, 1f, 5f),
                ModelTransform.of(6f, 0f, 0f, 0f, 0f, 0f));
        ModelPartData prim0L = wingOutL.addChild("prim_0_l", ModelPartBuilder.create()
                .uv(42, 32).cuboid(0f, -0.5f, -1f, 12f, 1f, 3f),
                ModelTransform.of(0f, 0f, 0f, 0f, -0.05f, 0f));
        ModelPartData prim1L = wingOutL.addChild("prim_1_l", ModelPartBuilder.create()
                .uv(72, 32).cuboid(0f, -0.5f, -0.5f, 11f, 1f, 3f),
                ModelTransform.of(0f, 0f, 0f, 0f, -0.25f, 0f));
        ModelPartData prim2L = wingOutL.addChild("prim_2_l", ModelPartBuilder.create()
                .uv(100, 32).cuboid(0f, -0.5f, 0f, 9f, 1f, 3f),
                ModelTransform.of(0f, 0f, 0f, 0f, -0.45f, 0f));
        ModelPartData prim3L = wingOutL.addChild("prim_3_l", ModelPartBuilder.create()
                .uv(0, 38).cuboid(0f, -0.5f, 0.5f, 7f, 1f, 3f),
                ModelTransform.of(0f, 0f, 0f, 0f, -0.65f, 0f));
        ModelPartData legL = body.addChild("leg_l", ModelPartBuilder.create()
                .uv(34, 32).cuboid(-1f, 0f, -1f, 2f, 3f, 2f),
                ModelTransform.of(1.5f, 3f, 0f, 0f, 0f, 0f));
        ModelPartData shinL = legL.addChild("shin_l", ModelPartBuilder.create()
                .uv(70, 38).cuboid(-0.5f, 0f, -0.5f, 1f, 2f, 1f),
                ModelTransform.of(0f, 3f, 0f, 0f, 0f, 0f));
        ModelPartData footL = shinL.addChild("foot_l", ModelPartBuilder.create()
                .uv(48, 38).cuboid(-1.5f, -1f, -3f, 1f, 1f, 3f)
                .uv(48, 38).cuboid(-0.5f, -1f, -3f, 1f, 1f, 3f)
                .uv(48, 38).cuboid(0.5f, -1f, -3f, 1f, 1f, 3f)
                .uv(64, 38).cuboid(-0.5f, -1f, 0f, 1f, 1f, 2f),
                ModelTransform.of(0f, 2f, 0f, 0f, 0f, 0f));
        ModelPartData wingR = body.addChild("wing_r", ModelPartBuilder.create()
                .uv(20, 38).cuboid(-6f, -0.5f, -1.5f, 6f, 1f, 3f)
                .uv(78, 19).cuboid(-6f, -0.5f, 1.5f, 6f, 1f, 6f),
                ModelTransform.of(-3f, -2f, -2f, 0f, 0f, 0f));
        ModelPartData wingOutR = wingR.addChild("wing_out_r", ModelPartBuilder.create()
                .uv(20, 38).cuboid(-6f, -0.5f, -1.5f, 6f, 1f, 3f)
                .uv(0, 32).cuboid(-6f, -0.5f, 1.5f, 6f, 1f, 5f),
                ModelTransform.of(-6f, 0f, 0f, 0f, 0f, 0f));
        ModelPartData prim0R = wingOutR.addChild("prim_0_r", ModelPartBuilder.create()
                .uv(42, 32).cuboid(-12f, -0.5f, -1f, 12f, 1f, 3f),
                ModelTransform.of(0f, 0f, 0f, 0f, 0.05f, 0f));
        ModelPartData prim1R = wingOutR.addChild("prim_1_r", ModelPartBuilder.create()
                .uv(72, 32).cuboid(-11f, -0.5f, -0.5f, 11f, 1f, 3f),
                ModelTransform.of(0f, 0f, 0f, 0f, 0.25f, 0f));
        ModelPartData prim2R = wingOutR.addChild("prim_2_r", ModelPartBuilder.create()
                .uv(100, 32).cuboid(-9f, -0.5f, 0f, 9f, 1f, 3f),
                ModelTransform.of(0f, 0f, 0f, 0f, 0.45f, 0f));
        ModelPartData prim3R = wingOutR.addChild("prim_3_r", ModelPartBuilder.create()
                .uv(0, 38).cuboid(-7f, -0.5f, 0.5f, 7f, 1f, 3f),
                ModelTransform.of(0f, 0f, 0f, 0f, 0.65f, 0f));
        ModelPartData legR = body.addChild("leg_r", ModelPartBuilder.create()
                .uv(34, 32).cuboid(-1f, 0f, -1f, 2f, 3f, 2f),
                ModelTransform.of(-1.5f, 3f, 0f, 0f, 0f, 0f));
        ModelPartData shinR = legR.addChild("shin_r", ModelPartBuilder.create()
                .uv(70, 38).cuboid(-0.5f, 0f, -0.5f, 1f, 2f, 1f),
                ModelTransform.of(0f, 3f, 0f, 0f, 0f, 0f));
        ModelPartData footR = shinR.addChild("foot_r", ModelPartBuilder.create()
                .uv(48, 38).cuboid(-1.5f, -1f, -3f, 1f, 1f, 3f)
                .uv(48, 38).cuboid(-0.5f, -1f, -3f, 1f, 1f, 3f)
                .uv(48, 38).cuboid(0.5f, -1f, -3f, 1f, 1f, 3f)
                .uv(64, 38).cuboid(-0.5f, -1f, 0f, 1f, 1f, 2f),
                ModelTransform.of(0f, 2f, 0f, 0f, 0f, 0f));
        ModelPartData tail = body.addChild("tail", ModelPartBuilder.create(),
                ModelTransform.of(0f, -1f, 4f, 0f, 0f, 0f));
        ModelPartData tail0 = tail.addChild("tail_0", ModelPartBuilder.create()
                .uv(0, 19).cuboid(-1f, -0.5f, 0f, 2f, 1f, 12f),
                ModelTransform.of(0f, 0f, 0f, -0.12f, -0.56f, 0f));
        ModelPartData tail1 = tail.addChild("tail_1", ModelPartBuilder.create()
                .uv(40, 0).cuboid(-1f, -0.5f, 0f, 2f, 1f, 15f),
                ModelTransform.of(0f, 0f, 0f, -0.12f, -0.28f, 0f));
        ModelPartData tail2 = tail.addChild("tail_2", ModelPartBuilder.create()
                .uv(0, 0).cuboid(-1f, -0.5f, 0f, 2f, 1f, 18f),
                ModelTransform.of(0f, 0f, 0f, -0.12f, 0f, 0f));
        ModelPartData tail3 = tail.addChild("tail_3", ModelPartBuilder.create()
                .uv(40, 0).cuboid(-1f, -0.5f, 0f, 2f, 1f, 15f),
                ModelTransform.of(0f, 0f, 0f, -0.12f, 0.28f, 0f));
        ModelPartData tail4 = tail.addChild("tail_4", ModelPartBuilder.create()
                .uv(0, 19).cuboid(-1f, -0.5f, 0f, 2f, 1f, 12f),
                ModelTransform.of(0f, 0f, 0f, -0.12f, 0.56f, 0f));
        return TexturedModelData.of(data, 128, 128);
    }

    private static float sin(float v) { return (float) Math.sin(v); }
    private static float cos(float v) { return (float) Math.cos(v); }

    @Override
    public void setAngles(PhoenixRenderState s) {
        super.setAngles(s);
        float t = s.age;
        float f = s.limbFrequency * 0.6662f;
        float amp = Math.min(1f, s.limbAmplitudeMultiplier * 1.5f);
        float yawLook = s.relativeHeadYaw * 0.0174533f;
        float pitchLook = s.pitch * 0.0174533f;

        this.body.pivotY = 16f + sin(t * 0.1f) * 0.3f;
        this.neck.pitch = -0.5f;
        this.head.pitch = 0.5f + pitchLook * 0.5f;
        this.head.yaw = yawLook * 0.6f;
        float[] crestYaw = {0f, 0.35f, -0.35f};
        ModelPart[] crest = {crest0, crest1, crest2};
        for (int i = 0; i < 3; i++) {
            crest[i].pitch = 0.7f + sin(t * 0.2f + i) * 0.12f;
            crest[i].yaw = crestYaw[i] + sin(t * 0.17f + i * 2f) * 0.08f;
        }

        ModelPart[] primL = {prim0L, prim1L, prim2L, prim3L};
        ModelPart[] primR = {prim0R, prim1R, prim2R, prim3R};
        float[] py = {-0.05f, -0.25f, -0.45f, -0.65f};
        float spread;
        if (s.flying) {
            float flap = sin(t * 0.9f);
            spread = 1f;
            this.body.pitch = 0.1f;
            this.wingL.yaw = 0f; this.wingR.yaw = 0f; this.wingOutL.yaw = 0f; this.wingOutR.yaw = 0f;
            this.wingL.roll = -flap * 0.9f;  this.wingR.roll = flap * 0.9f;
            this.wingOutL.roll = -flap * 0.5f - 0.1f;  this.wingOutR.roll = flap * 0.5f + 0.1f;
            this.legL.pitch = 0.9f; this.legR.pitch = 0.9f;
            this.shinL.pitch = 0.7f; this.shinR.pitch = 0.7f;
        } else {
            spread = 0.3f;
            this.body.pitch = 0f;
            this.wingL.yaw = -0.7f;  this.wingR.yaw = 0.7f;
            this.wingL.roll = 0.5f;  this.wingR.roll = -0.5f;
            this.wingOutL.yaw = -1.1f; this.wingOutR.yaw = 1.1f;
            this.wingOutL.roll = 0f; this.wingOutR.roll = 0f;
            float sw = cos(f) * 0.9f * amp;
            this.legL.pitch = sw; this.legR.pitch = -sw;
            this.shinL.pitch = 0f; this.shinR.pitch = 0f;
        }
        for (int i = 0; i < 4; i++) {
            primL[i].yaw = py[i] * spread;
            primR[i].yaw = -py[i] * spread;
        }
        ModelPart[] tf = {tail0, tail1, tail2, tail3, tail4};
        for (int i = 0; i < 5; i++) {
            tf[i].yaw = (i - 2) * 0.28f * (s.flying ? 1.15f : 0.8f) + sin(t * 0.12f + i) * 0.05f;
            tf[i].pitch = -0.12f + (s.flying ? sin(t * 0.9f) * 0.08f : 0f);
        }
    }
}
