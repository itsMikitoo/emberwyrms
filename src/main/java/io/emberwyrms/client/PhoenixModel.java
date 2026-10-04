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
    private final ModelPart neck3;
    private final ModelPart head;
    private final ModelPart crest0;
    private final ModelPart crest0B;
    private final ModelPart crest1;
    private final ModelPart crest1B;
    private final ModelPart crest2;
    private final ModelPart crest2B;
    private final ModelPart crest3;
    private final ModelPart crest3B;
    private final ModelPart crest4;
    private final ModelPart crest4B;
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
    private final ModelPart prim7L;
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
    private final ModelPart prim7R;
    private final ModelPart tail;
    private final ModelPart tail0;
    private final ModelPart tail0B;
    private final ModelPart tail1;
    private final ModelPart tail1B;
    private final ModelPart tail2;
    private final ModelPart tail2B;
    private final ModelPart tail3;
    private final ModelPart tail3B;
    private final ModelPart tail4;
    private final ModelPart tail4B;
    private final ModelPart tail5;
    private final ModelPart tail5B;
    private final ModelPart tail6;
    private final ModelPart tail6B;
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
        this.neck3 = neck2.getChild("neck3");
        this.head = neck3.getChild("head");
        this.crest0 = head.getChild("crest_0");
        this.crest0B = crest0.getChild("crest_0_b");
        this.crest1 = head.getChild("crest_1");
        this.crest1B = crest1.getChild("crest_1_b");
        this.crest2 = head.getChild("crest_2");
        this.crest2B = crest2.getChild("crest_2_b");
        this.crest3 = head.getChild("crest_3");
        this.crest3B = crest3.getChild("crest_3_b");
        this.crest4 = head.getChild("crest_4");
        this.crest4B = crest4.getChild("crest_4_b");
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
        this.prim7L = handL.getChild("prim_7_l");
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
        this.prim7R = handR.getChild("prim_7_r");
        this.tail = body.getChild("tail");
        this.tail0 = tail.getChild("tail_0");
        this.tail0B = tail0.getChild("tail_0_b");
        this.tail1 = tail.getChild("tail_1");
        this.tail1B = tail1.getChild("tail_1_b");
        this.tail2 = tail.getChild("tail_2");
        this.tail2B = tail2.getChild("tail_2_b");
        this.tail3 = tail.getChild("tail_3");
        this.tail3B = tail3.getChild("tail_3_b");
        this.tail4 = tail.getChild("tail_4");
        this.tail4B = tail4.getChild("tail_4_b");
        this.tail5 = tail.getChild("tail_5");
        this.tail5B = tail5.getChild("tail_5_b");
        this.tail6 = tail.getChild("tail_6");
        this.tail6B = tail6.getChild("tail_6_b");
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
                .uv(0, 16).cuboid(-3.5f, -3.5f, -9f, 7f, 7f, 7f)
                .uv(56, 16).cuboid(-3f, -3f, -2f, 6f, 6f, 7f)
                .uv(40, 42).cuboid(-2.5f, -2.5f, 5f, 5f, 5f, 4f)
                .uv(58, 42).cuboid(-3f, -1f, -11f, 6f, 5f, 3f)
                .uv(120, 68).cuboid(-1f, -5f, -7f, 2f, 2f, 2f)
                .uv(120, 68).cuboid(-1f, -5f, -4f, 2f, 2f, 2f)
                .uv(120, 68).cuboid(-1f, -5f, -1f, 2f, 2f, 2f)
                .uv(120, 68).cuboid(-1f, -5f, 2f, 2f, 2f, 2f)
                .uv(120, 68).cuboid(-1f, -5f, 5f, 2f, 2f, 2f),
                ModelTransform.of(0f, 14.5f, 0f, 0f, 0f, 0f));
        ModelPartData neck1 = body.addChild("neck1", ModelPartBuilder.create()
                .uv(76, 42).cuboid(-2f, -2f, -4f, 4f, 4f, 4f)
                .uv(108, 42).cuboid(-3f, -2.5f, -3f, 6f, 5f, 2f),
                ModelTransform.of(0f, -1f, -10f, -0.6f, 0f, 0f));
        ModelPartData neck2 = neck1.addChild("neck2", ModelPartBuilder.create()
                .uv(32, 52).cuboid(-1.5f, -1.5f, -4f, 3f, 3f, 4f),
                ModelTransform.of(0f, 0f, -4f, -0.15f, 0f, 0f));
        ModelPartData neck3 = neck2.addChild("neck3", ModelPartBuilder.create()
                .uv(32, 52).cuboid(-1.5f, -1.5f, -4f, 3f, 3f, 4f),
                ModelTransform.of(0f, 0f, -4f, 0.55f, 0f, 0f));
        ModelPartData head = neck3.addChild("head", ModelPartBuilder.create()
                .uv(76, 42).cuboid(-2f, -2f, -4f, 4f, 4f, 4f)
                .uv(46, 52).cuboid(-1f, -0.5f, -8f, 2f, 2f, 4f)
                .uv(6, 72).cuboid(-0.5f, 1f, -8.5f, 1f, 2f, 1f)
                .uv(100, 68).cuboid(-1f, 1.5f, -7f, 2f, 1f, 3f)
                .uv(10, 72).cuboid(1.7f, -1f, -3f, 1f, 1f, 1f)
                .uv(10, 72).cuboid(-2.7f, -1f, -3f, 1f, 1f, 1f)
                .uv(66, 59).cuboid(2f, 0f, -1f, 1f, 2f, 3f)
                .uv(66, 59).cuboid(-3f, 0f, -1f, 1f, 2f, 3f),
                ModelTransform.of(0f, 0f, -4f, 0.3f, 0f, 0f));
        ModelPartData crest0 = head.addChild("crest_0", ModelPartBuilder.create()
                .uv(58, 52).cuboid(-0.5f, -0.5f, 0f, 1f, 1f, 5f),
                ModelTransform.of(0f, -2f, -1f, 0.71f, -0.56f, 0f));
        ModelPartData crest0B = crest0.addChild("crest_0_b", ModelPartBuilder.create()
                .uv(58, 52).cuboid(-0.5f, -0.5f, 0f, 1f, 1f, 5f),
                ModelTransform.of(0f, 0f, 5f, 0.5f, 0f, 0f));
        ModelPartData crest1 = head.addChild("crest_1", ModelPartBuilder.create()
                .uv(92, 42).cuboid(-0.5f, -0.5f, 0f, 1f, 1f, 7f),
                ModelTransform.of(0f, -2f, -1f, 0.83f, -0.28f, 0f));
        ModelPartData crest1B = crest1.addChild("crest_1_b", ModelPartBuilder.create()
                .uv(58, 52).cuboid(-0.5f, -0.5f, 0f, 1f, 1f, 5f),
                ModelTransform.of(0f, 0f, 7f, 0.5f, 0f, 0f));
        ModelPartData crest2 = head.addChild("crest_2", ModelPartBuilder.create()
                .uv(0, 42).cuboid(-0.5f, -0.5f, 0f, 1f, 1f, 9f),
                ModelTransform.of(0f, -2f, -1f, 0.95f, 0f, 0f));
        ModelPartData crest2B = crest2.addChild("crest_2_b", ModelPartBuilder.create()
                .uv(58, 52).cuboid(-0.5f, -0.5f, 0f, 1f, 1f, 5f),
                ModelTransform.of(0f, 0f, 9f, 0.5f, 0f, 0f));
        ModelPartData crest3 = head.addChild("crest_3", ModelPartBuilder.create()
                .uv(92, 42).cuboid(-0.5f, -0.5f, 0f, 1f, 1f, 7f),
                ModelTransform.of(0f, -2f, -1f, 0.83f, 0.28f, 0f));
        ModelPartData crest3B = crest3.addChild("crest_3_b", ModelPartBuilder.create()
                .uv(58, 52).cuboid(-0.5f, -0.5f, 0f, 1f, 1f, 5f),
                ModelTransform.of(0f, 0f, 7f, 0.5f, 0f, 0f));
        ModelPartData crest4 = head.addChild("crest_4", ModelPartBuilder.create()
                .uv(58, 52).cuboid(-0.5f, -0.5f, 0f, 1f, 1f, 5f),
                ModelTransform.of(0f, -2f, -1f, 0.71f, 0.56f, 0f));
        ModelPartData crest4B = crest4.addChild("crest_4_b", ModelPartBuilder.create()
                .uv(58, 52).cuboid(-0.5f, -0.5f, 0f, 1f, 1f, 5f),
                ModelTransform.of(0f, 0f, 5f, 0.5f, 0f, 0f));
        ModelPartData wingL = body.addChild("wing_l", ModelPartBuilder.create()
                .uv(22, 59).cuboid(0f, -1f, -1.5f, 7f, 2f, 3f)
                .uv(94, 52).cuboid(0f, -1.5f, 1.5f, 7f, 1f, 4f)
                .uv(20, 68).cuboid(1f, -1.5f, 5.5f, 6f, 1f, 3f),
                ModelTransform.of(3.5f, -2.5f, -5f, 0f, 0f, 0f));
        ModelPartData foreL = wingL.addChild("fore_l", ModelPartBuilder.create()
                .uv(0, 59).cuboid(0f, -1f, -1.5f, 8f, 2f, 3f)
                .uv(70, 52).cuboid(0f, -1.5f, 1.5f, 8f, 1f, 4f)
                .uv(74, 30).cuboid(0f, -0.5f, 3f, 2f, 1f, 9f)
                .uv(110, 68).cuboid(0f, -0.5f, 12f, 2f, 1f, 3f)
                .uv(26, 30).cuboid(1f, -0.5f, 3f, 2f, 1f, 10f)
                .uv(110, 68).cuboid(1f, -0.5f, 13f, 2f, 1f, 3f)
                .uv(82, 16).cuboid(3f, -0.5f, 3f, 2f, 1f, 11f)
                .uv(110, 68).cuboid(3f, -0.5f, 14f, 2f, 1f, 3f)
                .uv(28, 16).cuboid(4f, -0.5f, 3f, 2f, 1f, 12f)
                .uv(110, 68).cuboid(4f, -0.5f, 15f, 2f, 1f, 3f)
                .uv(66, 0).cuboid(5f, -0.5f, 3f, 2f, 1f, 13f)
                .uv(110, 68).cuboid(5f, -0.5f, 16f, 2f, 1f, 3f)
                .uv(34, 0).cuboid(6f, -0.5f, 3f, 2f, 1f, 14f)
                .uv(110, 68).cuboid(6f, -0.5f, 17f, 2f, 1f, 3f),
                ModelTransform.of(7f, 0f, 0f, 0f, 0f, 0f));
        ModelPartData handL = foreL.addChild("hand_l", ModelPartBuilder.create()
                .uv(72, 68).cuboid(0f, -1f, -1f, 5f, 2f, 2f),
                ModelTransform.of(8f, 0f, 0f, 0f, 0f, 0f));
        ModelPartData prim0L = handL.addChild("prim_0_l", ModelPartBuilder.create()
                .uv(78, 59).cuboid(0f, -0.5f, -1f, 13f, 1f, 3f)
                .uv(78, 64).cuboid(13f, -0.5f, -1f, 8f, 1f, 3f),
                ModelTransform.of(4f, 0f, 0f, 0f, -0.04f, 0f));
        ModelPartData prim1L = handL.addChild("prim_1_l", ModelPartBuilder.create()
                .uv(78, 59).cuboid(0f, -0.5f, -1f, 13f, 1f, 3f)
                .uv(100, 64).cuboid(13f, -0.5f, -1f, 7f, 1f, 3f),
                ModelTransform.of(4f, 0f, 0f, 0f, -0.15f, 0f));
        ModelPartData prim2L = handL.addChild("prim_2_l", ModelPartBuilder.create()
                .uv(0, 64).cuboid(0f, -0.5f, -1f, 11f, 1f, 3f)
                .uv(100, 64).cuboid(11f, -0.5f, -1f, 7f, 1f, 3f),
                ModelTransform.of(4f, 0f, 0f, 0f, -0.26f, 0f));
        ModelPartData prim3L = handL.addChild("prim_3_l", ModelPartBuilder.create()
                .uv(28, 64).cuboid(0f, -0.5f, -1f, 10f, 1f, 3f)
                .uv(38, 68).cuboid(10f, -0.5f, -1f, 6f, 1f, 3f),
                ModelTransform.of(4f, 0f, 0f, 0f, -0.37f, 0f));
        ModelPartData prim4L = handL.addChild("prim_4_l", ModelPartBuilder.create()
                .uv(54, 64).cuboid(0f, -0.5f, -1f, 9f, 1f, 3f)
                .uv(38, 68).cuboid(9f, -0.5f, -1f, 6f, 1f, 3f),
                ModelTransform.of(4f, 0f, 0f, 0f, -0.48f, 0f));
        ModelPartData prim5L = handL.addChild("prim_5_l", ModelPartBuilder.create()
                .uv(54, 64).cuboid(0f, -0.5f, -1f, 9f, 1f, 3f)
                .uv(56, 68).cuboid(9f, -0.5f, -1f, 5f, 1f, 3f),
                ModelTransform.of(4f, 0f, 0f, 0f, -0.59f, 0f));
        ModelPartData prim6L = handL.addChild("prim_6_l", ModelPartBuilder.create()
                .uv(0, 68).cuboid(0f, -0.5f, -1f, 7f, 1f, 3f)
                .uv(56, 68).cuboid(7f, -0.5f, -1f, 5f, 1f, 3f),
                ModelTransform.of(4f, 0f, 0f, 0f, -0.7f, 0f));
        ModelPartData prim7L = handL.addChild("prim_7_l", ModelPartBuilder.create()
                .uv(20, 68).cuboid(0f, -0.5f, -1f, 6f, 1f, 3f)
                .uv(86, 68).cuboid(6f, -0.5f, -1f, 4f, 1f, 3f),
                ModelTransform.of(4f, 0f, 0f, 0f, -0.81f, 0f));
        ModelPartData wingR = body.addChild("wing_r", ModelPartBuilder.create()
                .uv(22, 59).cuboid(-7f, -1f, -1.5f, 7f, 2f, 3f)
                .uv(94, 52).cuboid(-7f, -1.5f, 1.5f, 7f, 1f, 4f)
                .uv(20, 68).cuboid(-7f, -1.5f, 5.5f, 6f, 1f, 3f),
                ModelTransform.of(-3.5f, -2.5f, -5f, 0f, 0f, 0f));
        ModelPartData foreR = wingR.addChild("fore_r", ModelPartBuilder.create()
                .uv(0, 59).cuboid(-8f, -1f, -1.5f, 8f, 2f, 3f)
                .uv(70, 52).cuboid(-8f, -1.5f, 1.5f, 8f, 1f, 4f)
                .uv(74, 30).cuboid(-2f, -0.5f, 3f, 2f, 1f, 9f)
                .uv(110, 68).cuboid(-2f, -0.5f, 12f, 2f, 1f, 3f)
                .uv(26, 30).cuboid(-3f, -0.5f, 3f, 2f, 1f, 10f)
                .uv(110, 68).cuboid(-3f, -0.5f, 13f, 2f, 1f, 3f)
                .uv(82, 16).cuboid(-5f, -0.5f, 3f, 2f, 1f, 11f)
                .uv(110, 68).cuboid(-5f, -0.5f, 14f, 2f, 1f, 3f)
                .uv(28, 16).cuboid(-6f, -0.5f, 3f, 2f, 1f, 12f)
                .uv(110, 68).cuboid(-6f, -0.5f, 15f, 2f, 1f, 3f)
                .uv(66, 0).cuboid(-7f, -0.5f, 3f, 2f, 1f, 13f)
                .uv(110, 68).cuboid(-7f, -0.5f, 16f, 2f, 1f, 3f)
                .uv(34, 0).cuboid(-8f, -0.5f, 3f, 2f, 1f, 14f)
                .uv(110, 68).cuboid(-8f, -0.5f, 17f, 2f, 1f, 3f),
                ModelTransform.of(-7f, 0f, 0f, 0f, 0f, 0f));
        ModelPartData handR = foreR.addChild("hand_r", ModelPartBuilder.create()
                .uv(72, 68).cuboid(-5f, -1f, -1f, 5f, 2f, 2f),
                ModelTransform.of(-8f, 0f, 0f, 0f, 0f, 0f));
        ModelPartData prim0R = handR.addChild("prim_0_r", ModelPartBuilder.create()
                .uv(78, 59).cuboid(-13f, -0.5f, -1f, 13f, 1f, 3f)
                .uv(78, 64).cuboid(-21f, -0.5f, -1f, 8f, 1f, 3f),
                ModelTransform.of(-4f, 0f, 0f, 0f, 0.04f, 0f));
        ModelPartData prim1R = handR.addChild("prim_1_r", ModelPartBuilder.create()
                .uv(78, 59).cuboid(-13f, -0.5f, -1f, 13f, 1f, 3f)
                .uv(100, 64).cuboid(-20f, -0.5f, -1f, 7f, 1f, 3f),
                ModelTransform.of(-4f, 0f, 0f, 0f, 0.15f, 0f));
        ModelPartData prim2R = handR.addChild("prim_2_r", ModelPartBuilder.create()
                .uv(0, 64).cuboid(-11f, -0.5f, -1f, 11f, 1f, 3f)
                .uv(100, 64).cuboid(-18f, -0.5f, -1f, 7f, 1f, 3f),
                ModelTransform.of(-4f, 0f, 0f, 0f, 0.26f, 0f));
        ModelPartData prim3R = handR.addChild("prim_3_r", ModelPartBuilder.create()
                .uv(28, 64).cuboid(-10f, -0.5f, -1f, 10f, 1f, 3f)
                .uv(38, 68).cuboid(-16f, -0.5f, -1f, 6f, 1f, 3f),
                ModelTransform.of(-4f, 0f, 0f, 0f, 0.37f, 0f));
        ModelPartData prim4R = handR.addChild("prim_4_r", ModelPartBuilder.create()
                .uv(54, 64).cuboid(-9f, -0.5f, -1f, 9f, 1f, 3f)
                .uv(38, 68).cuboid(-15f, -0.5f, -1f, 6f, 1f, 3f),
                ModelTransform.of(-4f, 0f, 0f, 0f, 0.48f, 0f));
        ModelPartData prim5R = handR.addChild("prim_5_r", ModelPartBuilder.create()
                .uv(54, 64).cuboid(-9f, -0.5f, -1f, 9f, 1f, 3f)
                .uv(56, 68).cuboid(-14f, -0.5f, -1f, 5f, 1f, 3f),
                ModelTransform.of(-4f, 0f, 0f, 0f, 0.59f, 0f));
        ModelPartData prim6R = handR.addChild("prim_6_r", ModelPartBuilder.create()
                .uv(0, 68).cuboid(-7f, -0.5f, -1f, 7f, 1f, 3f)
                .uv(56, 68).cuboid(-12f, -0.5f, -1f, 5f, 1f, 3f),
                ModelTransform.of(-4f, 0f, 0f, 0f, 0.7f, 0f));
        ModelPartData prim7R = handR.addChild("prim_7_r", ModelPartBuilder.create()
                .uv(20, 68).cuboid(-6f, -0.5f, -1f, 6f, 1f, 3f)
                .uv(86, 68).cuboid(-10f, -0.5f, -1f, 4f, 1f, 3f),
                ModelTransform.of(-4f, 0f, 0f, 0f, 0.81f, 0f));
        ModelPartData tail = body.addChild("tail", ModelPartBuilder.create(),
                ModelTransform.of(0f, -1f, 9f, 0f, 0f, 0f));
        ModelPartData tail0 = tail.addChild("tail_0", ModelPartBuilder.create()
                .uv(20, 42).cuboid(-1f, -0.5f, 0f, 2f, 1f, 8f),
                ModelTransform.of(0f, 0f, 0f, -0.08f, -0.54f, 0f));
        ModelPartData tail0B = tail0.addChild("tail_0_b", ModelPartBuilder.create()
                .uv(0, 52).cuboid(-1f, -0.5f, 0f, 2f, 1f, 6f)
                .uv(42, 59).cuboid(-1.5f, -0.5f, 6f, 3f, 1f, 4f),
                ModelTransform.of(0f, 0f, 8f, -0.2f, 0f, 0f));
        ModelPartData tail1 = tail.addChild("tail_1", ModelPartBuilder.create()
                .uv(50, 30).cuboid(-1f, -0.5f, 0f, 2f, 1f, 10f),
                ModelTransform.of(0f, 0f, 0f, -0.08f, -0.36f, 0f));
        ModelPartData tail1B = tail1.addChild("tail_1_b", ModelPartBuilder.create()
                .uv(20, 42).cuboid(-1f, -0.5f, 0f, 2f, 1f, 8f)
                .uv(42, 59).cuboid(-1.5f, -0.5f, 8f, 3f, 1f, 4f),
                ModelTransform.of(0f, 0f, 10f, -0.2f, 0f, 0f));
        ModelPartData tail2 = tail.addChild("tail_2", ModelPartBuilder.create()
                .uv(96, 0).cuboid(-1f, -0.5f, 0f, 2f, 1f, 13f),
                ModelTransform.of(0f, 0f, 0f, -0.08f, -0.18f, 0f));
        ModelPartData tail2B = tail2.addChild("tail_2_b", ModelPartBuilder.create()
                .uv(96, 30).cuboid(-1f, -0.5f, 0f, 2f, 1f, 9f)
                .uv(42, 59).cuboid(-1.5f, -0.5f, 9f, 3f, 1f, 4f),
                ModelTransform.of(0f, 0f, 13f, -0.2f, 0f, 0f));
        ModelPartData tail3 = tail.addChild("tail_3", ModelPartBuilder.create()
                .uv(0, 0).cuboid(-1f, -0.5f, 0f, 2f, 1f, 15f),
                ModelTransform.of(0f, 0f, 0f, -0.08f, 0f, 0f));
        ModelPartData tail3B = tail3.addChild("tail_3_b", ModelPartBuilder.create()
                .uv(0, 30).cuboid(-1f, -0.5f, 0f, 2f, 1f, 11f)
                .uv(42, 59).cuboid(-1.5f, -0.5f, 11f, 3f, 1f, 4f),
                ModelTransform.of(0f, 0f, 15f, -0.2f, 0f, 0f));
        ModelPartData tail4 = tail.addChild("tail_4", ModelPartBuilder.create()
                .uv(96, 0).cuboid(-1f, -0.5f, 0f, 2f, 1f, 13f),
                ModelTransform.of(0f, 0f, 0f, -0.08f, 0.18f, 0f));
        ModelPartData tail4B = tail4.addChild("tail_4_b", ModelPartBuilder.create()
                .uv(96, 30).cuboid(-1f, -0.5f, 0f, 2f, 1f, 9f)
                .uv(42, 59).cuboid(-1.5f, -0.5f, 9f, 3f, 1f, 4f),
                ModelTransform.of(0f, 0f, 13f, -0.2f, 0f, 0f));
        ModelPartData tail5 = tail.addChild("tail_5", ModelPartBuilder.create()
                .uv(50, 30).cuboid(-1f, -0.5f, 0f, 2f, 1f, 10f),
                ModelTransform.of(0f, 0f, 0f, -0.08f, 0.36f, 0f));
        ModelPartData tail5B = tail5.addChild("tail_5_b", ModelPartBuilder.create()
                .uv(20, 42).cuboid(-1f, -0.5f, 0f, 2f, 1f, 8f)
                .uv(42, 59).cuboid(-1.5f, -0.5f, 8f, 3f, 1f, 4f),
                ModelTransform.of(0f, 0f, 10f, -0.2f, 0f, 0f));
        ModelPartData tail6 = tail.addChild("tail_6", ModelPartBuilder.create()
                .uv(20, 42).cuboid(-1f, -0.5f, 0f, 2f, 1f, 8f),
                ModelTransform.of(0f, 0f, 0f, -0.08f, 0.54f, 0f));
        ModelPartData tail6B = tail6.addChild("tail_6_b", ModelPartBuilder.create()
                .uv(0, 52).cuboid(-1f, -0.5f, 0f, 2f, 1f, 6f)
                .uv(42, 59).cuboid(-1.5f, -0.5f, 6f, 3f, 1f, 4f),
                ModelTransform.of(0f, 0f, 8f, -0.2f, 0f, 0f));
        ModelPartData legL = body.addChild("leg_l", ModelPartBuilder.create()
                .uv(16, 52).cuboid(-2f, 0f, -2f, 4f, 3f, 4f),
                ModelTransform.of(2f, 3f, 0f, 0f, 0f, 0f));
        ModelPartData shinL = legL.addChild("shin_l", ModelPartBuilder.create()
                .uv(74, 59).cuboid(-0.5f, 0f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(0f, 3f, 0f, 0f, 0f, 0f));
        ModelPartData footL = shinL.addChild("foot_l", ModelPartBuilder.create()
                .uv(56, 59).cuboid(-1.5f, -0.5f, -4f, 1f, 1f, 4f)
                .uv(56, 59).cuboid(-0.5f, -0.5f, -4f, 1f, 1f, 4f)
                .uv(56, 59).cuboid(0.5f, -0.5f, -4f, 1f, 1f, 4f)
                .uv(0, 72).cuboid(-0.5f, -0.5f, 0f, 1f, 1f, 2f)
                .uv(14, 72).cuboid(-1.5f, -0.5f, -5f, 1f, 1f, 1f)
                .uv(14, 72).cuboid(-0.5f, -0.5f, -5f, 1f, 1f, 1f)
                .uv(14, 72).cuboid(0.5f, -0.5f, -5f, 1f, 1f, 1f),
                ModelTransform.of(0f, 3.5f, 0f, 0f, 0f, 0f));
        ModelPartData legR = body.addChild("leg_r", ModelPartBuilder.create()
                .uv(16, 52).cuboid(-2f, 0f, -2f, 4f, 3f, 4f),
                ModelTransform.of(-2f, 3f, 0f, 0f, 0f, 0f));
        ModelPartData shinR = legR.addChild("shin_r", ModelPartBuilder.create()
                .uv(74, 59).cuboid(-0.5f, 0f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(0f, 3f, 0f, 0f, 0f, 0f));
        ModelPartData footR = shinR.addChild("foot_r", ModelPartBuilder.create()
                .uv(56, 59).cuboid(-1.5f, -0.5f, -4f, 1f, 1f, 4f)
                .uv(56, 59).cuboid(-0.5f, -0.5f, -4f, 1f, 1f, 4f)
                .uv(56, 59).cuboid(0.5f, -0.5f, -4f, 1f, 1f, 4f)
                .uv(0, 72).cuboid(-0.5f, -0.5f, 0f, 1f, 1f, 2f)
                .uv(14, 72).cuboid(-1.5f, -0.5f, -5f, 1f, 1f, 1f)
                .uv(14, 72).cuboid(-0.5f, -0.5f, -5f, 1f, 1f, 1f)
                .uv(14, 72).cuboid(0.5f, -0.5f, -5f, 1f, 1f, 1f),
                ModelTransform.of(0f, 3.5f, 0f, 0f, 0f, 0f));
        return TexturedModelData.of(data, 128, 128);
    }

    private static float sin(float v) { return (float) Math.sin(v); }
    private static float cos(float v) { return (float) Math.cos(v); }

    private static final float[] NB = {-0.6f, -0.15f, 0.55f};

    @Override
    public void setAngles(PhoenixRenderState s) {
        super.setAngles(s);
        float t = s.age;
        float f = s.walkPhase * 0.6662f;
        float amp = Math.min(1f, s.walkSpeed * 1.5f);
        float yawLook = s.relativeHeadYaw * 0.0174533f;
        float pitchLook = s.pitch * 0.0174533f;

        ModelPart[] neck = {neck1, neck2, neck3};
        for (int i = 0; i < 3; i++) neck[i].pitch = NB[i] + (s.flying ? 0.25f : 0f) + sin(t * 0.08f - i * 0.7f) * 0.04f;
        this.head.pitch = 0.3f + pitchLook * 0.5f;
        this.head.yaw = yawLook * 0.6f;
        ModelPart[] crest = {crest0, crest1, crest2, crest3, crest4};
        ModelPart[] crestB = {crest0B, crest1B, crest2B, crest3B, crest4B};
        for (int i = 0; i < 5; i++) {
            int d = Math.abs(i - 2);
            crest[i].pitch = 0.95f - d * 0.12f + sin(t * 0.2f + i) * 0.1f;
            crest[i].yaw = (i - 2) * 0.28f + sin(t * 0.15f + i * 2f) * 0.06f;
            crestB[i].pitch = 0.5f + sin(t * 0.25f + i) * 0.15f;
        }

        ModelPart[] pl = {prim0L, prim1L, prim2L, prim3L, prim4L, prim5L, prim6L, prim7L};
        ModelPart[] pr = {prim0R, prim1R, prim2R, prim3R, prim4R, prim5R, prim6R, prim7R};
        float spread;
        if (s.flying) {
            float flap = sin(t * 0.5f);
            spread = 1f;
            this.body.pitch = 0.1f;
            this.wingL.yaw = 0f; this.wingR.yaw = 0f; this.foreL.yaw = 0f; this.foreR.yaw = 0f; this.handL.yaw = 0f; this.handR.yaw = 0f;
            this.wingL.roll = -flap * 0.8f;  this.wingR.roll = flap * 0.8f;
            this.foreL.roll = -flap * 0.45f - 0.05f;  this.foreR.roll = flap * 0.45f + 0.05f;
            this.handL.roll = -flap * 0.35f;  this.handR.roll = flap * 0.35f;
            this.legL.pitch = 0.9f; this.legR.pitch = 0.9f;
            this.shinL.pitch = 0.7f; this.shinR.pitch = 0.7f;
        } else {
            spread = 0.25f;
            this.body.pitch = 0f;
            this.wingL.yaw = -0.6f;  this.wingR.yaw = 0.6f;
            this.wingL.roll = 0.45f;  this.wingR.roll = -0.45f;
            this.foreL.yaw = -1.2f;  this.foreR.yaw = 1.2f;
            this.foreL.roll = 0f;  this.foreR.roll = 0f;
            this.handL.yaw = -0.8f;  this.handR.yaw = 0.8f;
            this.handL.roll = 0f;  this.handR.roll = 0f;
            float sw = cos(f) * 0.9f * amp;
            this.legL.pitch = sw;  this.legR.pitch = -sw;
            this.shinL.pitch = 0f;  this.shinR.pitch = 0f;
        }
        for (int i = 0; i < 8; i++) {
            float py = -(0.04f + 0.11f * i) * spread;
            pl[i].yaw = py;
            pr[i].yaw = -py;
        }
        ModelPart[] tf = {tail0, tail1, tail2, tail3, tail4, tail5, tail6};
        ModelPart[] tb = {tail0B, tail1B, tail2B, tail3B, tail4B, tail5B, tail6B};
        for (int i = 0; i < 7; i++) {
            tf[i].yaw = (i - 3) * 0.18f * (s.flying ? 1.25f : 0.7f) + sin(t * 0.1f + i) * 0.04f;
            tf[i].pitch = -0.08f + (s.flying ? sin(t * 0.5f) * 0.08f : 0f);
            tb[i].pitch = -0.2f + sin(t * 0.12f + i) * 0.08f;
        }
    }
}
