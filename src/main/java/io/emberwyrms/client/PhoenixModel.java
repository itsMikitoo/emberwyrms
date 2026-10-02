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
    private final ModelPart neck1;
    private final ModelPart neck2;
    private final ModelPart head;
    private final ModelPart crest0;
    private final ModelPart crest1;
    private final ModelPart crest2;
    private final ModelPart wingL;
    private final ModelPart foreL;
    private final ModelPart handL;
    private final ModelPart prim0L;
    private final ModelPart prim1L;
    private final ModelPart prim2L;
    private final ModelPart prim3L;
    private final ModelPart prim4L;
    private final ModelPart prim5L;
    private final ModelPart prim6L;
    private final ModelPart wingR;
    private final ModelPart foreR;
    private final ModelPart handR;
    private final ModelPart prim0R;
    private final ModelPart prim1R;
    private final ModelPart prim2R;
    private final ModelPart prim3R;
    private final ModelPart prim4R;
    private final ModelPart prim5R;
    private final ModelPart prim6R;
    private final ModelPart tail;
    private final ModelPart tail0;
    private final ModelPart tail1;
    private final ModelPart tail2;
    private final ModelPart tail3;
    private final ModelPart tail4;
    private final ModelPart legL;
    private final ModelPart shinL;
    private final ModelPart footL;
    private final ModelPart legR;
    private final ModelPart shinR;
    private final ModelPart footR;

    public PhoenixModel(ModelPart root) {
        super(root);
        this.body = root.getChild("body");
        this.neck1 = body.getChild("neck1");
        this.neck2 = neck1.getChild("neck2");
        this.head = neck2.getChild("head");
        this.crest0 = head.getChild("crest_0");
        this.crest1 = head.getChild("crest_1");
        this.crest2 = head.getChild("crest_2");
        this.wingL = body.getChild("wing_l");
        this.foreL = wingL.getChild("fore_l");
        this.handL = foreL.getChild("hand_l");
        this.prim0L = handL.getChild("prim_0_l");
        this.prim1L = handL.getChild("prim_1_l");
        this.prim2L = handL.getChild("prim_2_l");
        this.prim3L = handL.getChild("prim_3_l");
        this.prim4L = handL.getChild("prim_4_l");
        this.prim5L = handL.getChild("prim_5_l");
        this.prim6L = handL.getChild("prim_6_l");
        this.wingR = body.getChild("wing_r");
        this.foreR = wingR.getChild("fore_r");
        this.handR = foreR.getChild("hand_r");
        this.prim0R = handR.getChild("prim_0_r");
        this.prim1R = handR.getChild("prim_1_r");
        this.prim2R = handR.getChild("prim_2_r");
        this.prim3R = handR.getChild("prim_3_r");
        this.prim4R = handR.getChild("prim_4_r");
        this.prim5R = handR.getChild("prim_5_r");
        this.prim6R = handR.getChild("prim_6_r");
        this.tail = body.getChild("tail");
        this.tail0 = tail.getChild("tail_0");
        this.tail1 = tail.getChild("tail_1");
        this.tail2 = tail.getChild("tail_2");
        this.tail3 = tail.getChild("tail_3");
        this.tail4 = tail.getChild("tail_4");
        this.legL = body.getChild("leg_l");
        this.shinL = legL.getChild("shin_l");
        this.footL = shinL.getChild("foot_l");
        this.legR = body.getChild("leg_r");
        this.shinR = legR.getChild("shin_r");
        this.footR = shinR.getChild("foot_r");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData data = new ModelData();
        ModelPartData root = data.getRoot();
        ModelPartData body = root.addChild("body", ModelPartBuilder.create()
                .uv(0, 37).cuboid(-4f, -6f, -6f, 8f, 12f, 12f)
                .uv(40, 37).cuboid(-5f, -4f, -5f, 10f, 8f, 10f)
                .uv(216, 37).cuboid(-3f, -7f, -4f, 6f, 2f, 9f)
                .uv(52, 61).cuboid(-4f, -3f, -9f, 8f, 7f, 3f)
                .uv(96, 61).cuboid(-3f, -3f, 6f, 6f, 6f, 4f)
                .uv(24, 61).cuboid(-3f, 6f, -4f, 6f, 2f, 8f),
                ModelTransform.of(0f, 10.5f, 0f, 0f, 0f, 0f));
        ModelPartData neck1 = body.addChild("neck1", ModelPartBuilder.create()
                .uv(116, 61).cuboid(-2.5f, -2.5f, -5f, 5f, 5f, 5f),
                ModelTransform.of(0f, -3f, -8f, -0.85f, 0f, 0f));
        ModelPartData neck2 = neck1.addChild("neck2", ModelPartBuilder.create()
                .uv(176, 61).cuboid(-2f, -2f, -5f, 4f, 4f, 5f),
                ModelTransform.of(0f, 0f, -5f, -0.3f, 0f, 0f));
        ModelPartData head = neck2.addChild("head", ModelPartBuilder.create()
                .uv(116, 61).cuboid(-2.5f, -2.5f, -5f, 5f, 5f, 5f)
                .uv(136, 61).cuboid(-1.5f, -1f, -12f, 3f, 3f, 7f)
                .uv(88, 79).cuboid(-1f, 0f, -13f, 2f, 2f, 1f)
                .uv(82, 79).cuboid(2.1f, -1.5f, -3f, 1f, 2f, 2f)
                .uv(82, 79).cuboid(-3.1f, -1.5f, -3f, 1f, 2f, 2f)
                .uv(38, 72).cuboid(2.5f, 0f, -2f, 1f, 1f, 4f)
                .uv(38, 72).cuboid(-3.5f, 0f, -2f, 1f, 1f, 4f),
                ModelTransform.of(0f, 0f, -5f, 1f, 0f, 0f));
        ModelPartData crest0 = head.addChild("crest_0", ModelPartBuilder.create()
                .uv(16, 72).cuboid(-0.5f, -0.5f, 0f, 1f, 1f, 6f),
                ModelTransform.of(0f, -2.5f, -1f, 0.6f, -0.3f, 0f));
        ModelPartData crest1 = head.addChild("crest_1", ModelPartBuilder.create()
                .uv(16, 72).cuboid(-0.5f, -0.5f, 0f, 1f, 1f, 6f),
                ModelTransform.of(0f, -2.5f, -1f, 0.7f, 0f, 0f));
        ModelPartData crest2 = head.addChild("crest_2", ModelPartBuilder.create()
                .uv(16, 72).cuboid(-0.5f, -0.5f, 0f, 1f, 1f, 6f),
                ModelTransform.of(0f, -2.5f, -1f, 0.6f, 0.3f, 0f));
        ModelPartData wingL = body.addChild("wing_l", ModelPartBuilder.create()
                .uv(196, 37).cuboid(0f, -3f, -3f, 4f, 6f, 6f)
                .uv(194, 61).cuboid(3f, -1.5f, -2f, 6f, 2f, 6f),
                ModelTransform.of(5f, -4f, -1f, 0f, 0f, 0f));
        ModelPartData foreL = wingL.addChild("fore_l", ModelPartBuilder.create()
                .uv(218, 61).cuboid(0f, -1.5f, -2f, 9f, 3f, 4f)
                .uv(74, 61).cuboid(0f, -0.5f, 2f, 2f, 1f, 9f)
                .uv(62, 79).cuboid(0f, -0.5f, 11f, 2f, 1f, 3f)
                .uv(0, 61).cuboid(2f, -0.5f, 2f, 2f, 1f, 10f)
                .uv(62, 79).cuboid(2f, -0.5f, 12f, 2f, 1f, 3f)
                .uv(170, 37).cuboid(3f, -0.5f, 2f, 2f, 1f, 11f)
                .uv(62, 79).cuboid(3f, -0.5f, 13f, 2f, 1f, 3f)
                .uv(142, 37).cuboid(4f, -0.5f, 2f, 2f, 1f, 12f)
                .uv(62, 79).cuboid(4f, -0.5f, 14f, 2f, 1f, 3f)
                .uv(112, 37).cuboid(6f, -0.5f, 2f, 2f, 1f, 13f)
                .uv(62, 79).cuboid(6f, -0.5f, 15f, 2f, 1f, 3f)
                .uv(80, 37).cuboid(8f, -0.5f, 2f, 2f, 1f, 14f)
                .uv(62, 79).cuboid(8f, -0.5f, 16f, 2f, 1f, 3f),
                ModelTransform.of(8f, 0f, 0f, 0f, 0f, 0f));
        ModelPartData handL = foreL.addChild("hand_l", ModelPartBuilder.create()
                .uv(34, 79).cuboid(0f, -1f, -1f, 5f, 2f, 2f),
                ModelTransform.of(9f, 0f, 0f, 0f, 0f, 0f));
        ModelPartData prim0L = handL.addChild("prim_0_l", ModelPartBuilder.create()
                .uv(48, 72).cuboid(0f, -0.5f, -1f, 14f, 1f, 3f)
                .uv(166, 72).cuboid(14f, -0.5f, -1f, 8f, 1f, 3f),
                ModelTransform.of(4f, 0f, 0f, 0f, -0.05f, 0f));
        ModelPartData prim1L = handL.addChild("prim_1_l", ModelPartBuilder.create()
                .uv(82, 72).cuboid(0f, -0.5f, -1f, 13f, 1f, 3f)
                .uv(210, 72).cuboid(13f, -0.5f, -1f, 7f, 1f, 3f),
                ModelTransform.of(4f, 0f, 0f, 0f, -0.18f, 0f));
        ModelPartData prim2L = handL.addChild("prim_2_l", ModelPartBuilder.create()
                .uv(114, 72).cuboid(0f, -0.5f, -1f, 11f, 1f, 3f)
                .uv(210, 72).cuboid(11f, -0.5f, -1f, 7f, 1f, 3f),
                ModelTransform.of(4f, 0f, 0f, 0f, -0.31f, 0f));
        ModelPartData prim3L = handL.addChild("prim_3_l", ModelPartBuilder.create()
                .uv(114, 72).cuboid(0f, -0.5f, -1f, 11f, 1f, 3f)
                .uv(0, 79).cuboid(11f, -0.5f, -1f, 6f, 1f, 3f),
                ModelTransform.of(4f, 0f, 0f, 0f, -0.44f, 0f));
        ModelPartData prim4L = handL.addChild("prim_4_l", ModelPartBuilder.create()
                .uv(142, 72).cuboid(0f, -0.5f, -1f, 9f, 1f, 3f)
                .uv(0, 79).cuboid(9f, -0.5f, -1f, 6f, 1f, 3f),
                ModelTransform.of(4f, 0f, 0f, 0f, -0.57f, 0f));
        ModelPartData prim5L = handL.addChild("prim_5_l", ModelPartBuilder.create()
                .uv(188, 72).cuboid(0f, -0.5f, -1f, 8f, 1f, 3f)
                .uv(18, 79).cuboid(8f, -0.5f, -1f, 5f, 1f, 3f),
                ModelTransform.of(4f, 0f, 0f, 0f, -0.7f, 0f));
        ModelPartData prim6L = handL.addChild("prim_6_l", ModelPartBuilder.create()
                .uv(230, 72).cuboid(0f, -0.5f, -1f, 7f, 1f, 3f)
                .uv(48, 79).cuboid(7f, -0.5f, -1f, 4f, 1f, 3f),
                ModelTransform.of(4f, 0f, 0f, 0f, -0.83f, 0f));
        ModelPartData wingR = body.addChild("wing_r", ModelPartBuilder.create()
                .uv(196, 37).cuboid(-4f, -3f, -3f, 4f, 6f, 6f)
                .uv(194, 61).cuboid(-9f, -1.5f, -2f, 6f, 2f, 6f),
                ModelTransform.of(-5f, -4f, -1f, 0f, 0f, 0f));
        ModelPartData foreR = wingR.addChild("fore_r", ModelPartBuilder.create()
                .uv(218, 61).cuboid(-9f, -1.5f, -2f, 9f, 3f, 4f)
                .uv(74, 61).cuboid(-2f, -0.5f, 2f, 2f, 1f, 9f)
                .uv(62, 79).cuboid(-2f, -0.5f, 11f, 2f, 1f, 3f)
                .uv(0, 61).cuboid(-4f, -0.5f, 2f, 2f, 1f, 10f)
                .uv(62, 79).cuboid(-4f, -0.5f, 12f, 2f, 1f, 3f)
                .uv(170, 37).cuboid(-5f, -0.5f, 2f, 2f, 1f, 11f)
                .uv(62, 79).cuboid(-5f, -0.5f, 13f, 2f, 1f, 3f)
                .uv(142, 37).cuboid(-6f, -0.5f, 2f, 2f, 1f, 12f)
                .uv(62, 79).cuboid(-6f, -0.5f, 14f, 2f, 1f, 3f)
                .uv(112, 37).cuboid(-8f, -0.5f, 2f, 2f, 1f, 13f)
                .uv(62, 79).cuboid(-8f, -0.5f, 15f, 2f, 1f, 3f)
                .uv(80, 37).cuboid(-10f, -0.5f, 2f, 2f, 1f, 14f)
                .uv(62, 79).cuboid(-10f, -0.5f, 16f, 2f, 1f, 3f),
                ModelTransform.of(-8f, 0f, 0f, 0f, 0f, 0f));
        ModelPartData handR = foreR.addChild("hand_r", ModelPartBuilder.create()
                .uv(34, 79).cuboid(-5f, -1f, -1f, 5f, 2f, 2f),
                ModelTransform.of(-9f, 0f, 0f, 0f, 0f, 0f));
        ModelPartData prim0R = handR.addChild("prim_0_r", ModelPartBuilder.create()
                .uv(48, 72).cuboid(-14f, -0.5f, -1f, 14f, 1f, 3f)
                .uv(166, 72).cuboid(-22f, -0.5f, -1f, 8f, 1f, 3f),
                ModelTransform.of(-4f, 0f, 0f, 0f, 0.05f, 0f));
        ModelPartData prim1R = handR.addChild("prim_1_r", ModelPartBuilder.create()
                .uv(82, 72).cuboid(-13f, -0.5f, -1f, 13f, 1f, 3f)
                .uv(210, 72).cuboid(-20f, -0.5f, -1f, 7f, 1f, 3f),
                ModelTransform.of(-4f, 0f, 0f, 0f, 0.18f, 0f));
        ModelPartData prim2R = handR.addChild("prim_2_r", ModelPartBuilder.create()
                .uv(114, 72).cuboid(-11f, -0.5f, -1f, 11f, 1f, 3f)
                .uv(210, 72).cuboid(-18f, -0.5f, -1f, 7f, 1f, 3f),
                ModelTransform.of(-4f, 0f, 0f, 0f, 0.31f, 0f));
        ModelPartData prim3R = handR.addChild("prim_3_r", ModelPartBuilder.create()
                .uv(114, 72).cuboid(-11f, -0.5f, -1f, 11f, 1f, 3f)
                .uv(0, 79).cuboid(-17f, -0.5f, -1f, 6f, 1f, 3f),
                ModelTransform.of(-4f, 0f, 0f, 0f, 0.44f, 0f));
        ModelPartData prim4R = handR.addChild("prim_4_r", ModelPartBuilder.create()
                .uv(142, 72).cuboid(-9f, -0.5f, -1f, 9f, 1f, 3f)
                .uv(0, 79).cuboid(-15f, -0.5f, -1f, 6f, 1f, 3f),
                ModelTransform.of(-4f, 0f, 0f, 0f, 0.57f, 0f));
        ModelPartData prim5R = handR.addChild("prim_5_r", ModelPartBuilder.create()
                .uv(188, 72).cuboid(-8f, -0.5f, -1f, 8f, 1f, 3f)
                .uv(18, 79).cuboid(-13f, -0.5f, -1f, 5f, 1f, 3f),
                ModelTransform.of(-4f, 0f, 0f, 0f, 0.7f, 0f));
        ModelPartData prim6R = handR.addChild("prim_6_r", ModelPartBuilder.create()
                .uv(230, 72).cuboid(-7f, -0.5f, -1f, 7f, 1f, 3f)
                .uv(48, 79).cuboid(-11f, -0.5f, -1f, 4f, 1f, 3f),
                ModelTransform.of(-4f, 0f, 0f, 0f, 0.83f, 0f));
        ModelPartData tail = body.addChild("tail", ModelPartBuilder.create(),
                ModelTransform.of(0f, -1f, 10f, 0f, 0f, 0f));
        ModelPartData tail0 = tail.addChild("tail_0", ModelPartBuilder.create()
                .uv(156, 61).cuboid(-1f, -0.5f, 0f, 2f, 1f, 8f)
                .uv(74, 0).cuboid(-0.5f, -0.5f, 8f, 1f, 1f, 32f),
                ModelTransform.of(0f, 0f, 0f, 0.1f, -0.2f, 0f));
        ModelPartData tail1 = tail.addChild("tail_1", ModelPartBuilder.create()
                .uv(156, 61).cuboid(-1f, -0.5f, 0f, 2f, 1f, 8f)
                .uv(198, 0).cuboid(-0.5f, -0.5f, 8f, 1f, 1f, 26f),
                ModelTransform.of(0f, 0f, 0f, 0.1f, -0.1f, 0f));
        ModelPartData tail2 = tail.addChild("tail_2", ModelPartBuilder.create()
                .uv(156, 61).cuboid(-1f, -0.5f, 0f, 2f, 1f, 8f)
                .uv(0, 0).cuboid(-0.5f, -0.5f, 8f, 1f, 1f, 36f),
                ModelTransform.of(0f, 0f, 0f, 0.1f, 0f, 0f));
        ModelPartData tail3 = tail.addChild("tail_3", ModelPartBuilder.create()
                .uv(156, 61).cuboid(-1f, -0.5f, 0f, 2f, 1f, 8f)
                .uv(140, 0).cuboid(-0.5f, -0.5f, 8f, 1f, 1f, 28f),
                ModelTransform.of(0f, 0f, 0f, 0.1f, 0.1f, 0f));
        ModelPartData tail4 = tail.addChild("tail_4", ModelPartBuilder.create()
                .uv(156, 61).cuboid(-1f, -0.5f, 0f, 2f, 1f, 8f)
                .uv(74, 0).cuboid(-0.5f, -0.5f, 8f, 1f, 1f, 32f),
                ModelTransform.of(0f, 0f, 0f, 0.1f, 0.2f, 0f));
        ModelPartData legL = body.addChild("leg_l", ModelPartBuilder.create()
                .uv(116, 61).cuboid(-2.5f, 0f, -2.5f, 5f, 5f, 5f),
                ModelTransform.of(3.5f, 5f, 0f, 0f, 0f, 0f));
        ModelPartData shinL = legL.addChild("shin_l", ModelPartBuilder.create()
                .uv(30, 72).cuboid(-1f, 0f, -1f, 2f, 4f, 2f),
                ModelTransform.of(0f, 5f, 0f, 0f, 0f, 0f));
        ModelPartData footL = shinL.addChild("foot_l", ModelPartBuilder.create()
                .uv(0, 72).cuboid(-3f, -1f, -6f, 2f, 1f, 6f)
                .uv(0, 72).cuboid(-1f, -1f, -6f, 2f, 1f, 6f)
                .uv(0, 72).cuboid(1f, -1f, -6f, 2f, 1f, 6f)
                .uv(72, 79).cuboid(-1f, -1f, 0f, 2f, 1f, 3f)
                .uv(94, 79).cuboid(-2.5f, -1f, -8f, 1f, 1f, 2f)
                .uv(94, 79).cuboid(-0.5f, -1f, -8f, 1f, 1f, 2f)
                .uv(94, 79).cuboid(1.5f, -1f, -8f, 1f, 1f, 2f),
                ModelTransform.of(0f, 4f, 0f, 0f, 0f, 0f));
        ModelPartData legR = body.addChild("leg_r", ModelPartBuilder.create()
                .uv(116, 61).cuboid(-2.5f, 0f, -2.5f, 5f, 5f, 5f),
                ModelTransform.of(-3.5f, 5f, 0f, 0f, 0f, 0f));
        ModelPartData shinR = legR.addChild("shin_r", ModelPartBuilder.create()
                .uv(30, 72).cuboid(-1f, 0f, -1f, 2f, 4f, 2f),
                ModelTransform.of(0f, 5f, 0f, 0f, 0f, 0f));
        ModelPartData footR = shinR.addChild("foot_r", ModelPartBuilder.create()
                .uv(0, 72).cuboid(-3f, -1f, -6f, 2f, 1f, 6f)
                .uv(0, 72).cuboid(-1f, -1f, -6f, 2f, 1f, 6f)
                .uv(0, 72).cuboid(1f, -1f, -6f, 2f, 1f, 6f)
                .uv(72, 79).cuboid(-1f, -1f, 0f, 2f, 1f, 3f)
                .uv(94, 79).cuboid(-2.5f, -1f, -8f, 1f, 1f, 2f)
                .uv(94, 79).cuboid(-0.5f, -1f, -8f, 1f, 1f, 2f)
                .uv(94, 79).cuboid(1.5f, -1f, -8f, 1f, 1f, 2f),
                ModelTransform.of(0f, 4f, 0f, 0f, 0f, 0f));
        return TexturedModelData.of(data, 256, 256);
    }

    private static float sin(float v) { return (float) Math.sin(v); }
    private static float cos(float v) { return (float) Math.cos(v); }

    private static final float[] NB = {-0.85f, -0.3f};

    @Override
    public void setAngles(PhoenixRenderState s) {
        super.setAngles(s);
        float t = s.age;
        float f = s.walkPhase * 0.6662f;
        float amp = Math.min(1f, s.walkSpeed * 1.5f);
        float yawLook = s.relativeHeadYaw * 0.0174533f;
        float pitchLook = s.pitch * 0.0174533f;

        this.neck1.pitch = NB[0] + (s.flying ? 0.35f : 0f) + sin(t * 0.08f) * 0.04f;
        this.neck2.pitch = NB[1] + (s.flying ? 0.2f : 0f) + sin(t * 0.08f - 0.7f) * 0.04f;
        this.head.pitch = 1.0f + pitchLook * 0.5f;
        this.head.yaw = yawLook * 0.6f;
        ModelPart[] crest = {crest0, crest1, crest2};
        for (int i = 0; i < 3; i++) {
            crest[i].pitch = 0.7f - 0.1f * Math.abs(i - 1) + sin(t * 0.2f + i) * 0.12f;
            crest[i].yaw = (i - 1) * 0.3f + sin(t * 0.15f + i * 2f) * 0.07f;
        }

        ModelPart[] pl = {prim0L, prim1L, prim2L, prim3L, prim4L, prim5L, prim6L};
        ModelPart[] pr = {prim0R, prim1R, prim2R, prim3R, prim4R, prim5R, prim6R};
        float spread;
        if (s.flying) {
            float flap = sin(t * 0.5f);
            spread = 1f;
            this.body.pitch = 0.2f;
            this.wingL.yaw = 0f; this.wingR.yaw = 0f; this.foreL.yaw = 0f; this.foreR.yaw = 0f; this.handL.yaw = 0f; this.handR.yaw = 0f;
            this.wingL.roll = -flap * 0.8f;  this.wingR.roll = flap * 0.8f;
            this.foreL.roll = -flap * 0.45f - 0.05f;  this.foreR.roll = flap * 0.45f + 0.05f;
            this.handL.roll = -flap * 0.35f;  this.handR.roll = flap * 0.35f;
            this.legL.pitch = 0.9f; this.legR.pitch = 0.9f;
            this.shinL.pitch = 0.7f; this.shinR.pitch = 0.7f;
        } else {
            spread = 0.25f;
            this.body.pitch = 0f;
            this.wingL.yaw = -0.35f;  this.wingR.yaw = 0.35f;
            this.wingL.roll = 0.5f;  this.wingR.roll = -0.5f;
            this.foreL.yaw = -1.2f;  this.foreR.yaw = 1.2f;
            this.foreL.roll = 0f;  this.foreR.roll = 0f;
            this.handL.yaw = -0.8f;  this.handR.yaw = 0.8f;
            this.handL.roll = 0f;  this.handR.roll = 0f;
            float sw = cos(f) * 0.9f * amp;
            this.legL.pitch = sw;  this.legR.pitch = -sw;
            this.shinL.pitch = 0f;  this.shinR.pitch = 0f;
        }
        for (int i = 0; i < 7; i++) {
            float py = -(0.05f + 0.13f * i) * spread;
            pl[i].yaw = py;
            pr[i].yaw = -py;
        }
        ModelPart[] tf = {tail0, tail1, tail2, tail3, tail4};
        for (int i = 0; i < 5; i++) {
            tf[i].yaw = (i - 2) * 0.1f * (s.flying ? 1.4f : 1f) + sin(t * 0.1f + i) * 0.05f;
            tf[i].pitch = 0.1f + (s.flying ? sin(t * 0.5f) * 0.08f : sin(t * 0.07f + i) * 0.04f);
        }
    }
}
