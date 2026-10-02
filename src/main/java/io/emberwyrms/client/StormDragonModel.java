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
public class StormDragonModel extends EntityModel<AshwingRenderState> {
    private final ModelPart frame;
    private final ModelPart body;
    private final ModelPart neck1;
    private final ModelPart neck2;
    private final ModelPart neck3;
    private final ModelPart neck4;
    private final ModelPart neck5;
    private final ModelPart neck6;
    private final ModelPart head;
    private final ModelPart jaw;
    private final ModelPart hornL;
    private final ModelPart hornL2;
    private final ModelPart hornL3;
    private final ModelPart browL;
    private final ModelPart hornR;
    private final ModelPart hornR2;
    private final ModelPart hornR3;
    private final ModelPart browR;
    private final ModelPart tail1;
    private final ModelPart tail2;
    private final ModelPart tail3;
    private final ModelPart tail4;
    private final ModelPart tail5;
    private final ModelPart tail6;
    private final ModelPart tail7;
    private final ModelPart tail8;
    private final ModelPart tail9;
    private final ModelPart tailTip;
    private final ModelPart wingL;
    private final ModelPart armL;
    private final ModelPart foreL;
    private final ModelPart f1L;
    private final ModelPart f2L;
    private final ModelPart f3L;
    private final ModelPart f4L;
    private final ModelPart wingR;
    private final ModelPart armR;
    private final ModelPart foreR;
    private final ModelPart f1R;
    private final ModelPart f2R;
    private final ModelPart f3R;
    private final ModelPart f4R;
    private final ModelPart legBl;
    private final ModelPart shinBl;
    private final ModelPart metaBl;
    private final ModelPart footBl;
    private final ModelPart legBr;
    private final ModelPart shinBr;
    private final ModelPart metaBr;
    private final ModelPart footBr;
    private final ModelPart antlerL;
    private final ModelPart antlerLA;
    private final ModelPart antlerLB;
    private final ModelPart antlerR;
    private final ModelPart antlerRA;
    private final ModelPart antlerRB;
    private final ModelPart boltA;
    private final ModelPart boltB;
    private final ModelPart spark0;
    private final ModelPart spark1;
    private final ModelPart spark2;
    private final ModelPart spark3;

    public StormDragonModel(ModelPart root) {
        super(root);
        this.frame = root.getChild("frame");
        this.body = frame.getChild("body");
        this.neck1 = body.getChild("neck1");
        this.neck2 = neck1.getChild("neck2");
        this.neck3 = neck2.getChild("neck3");
        this.neck4 = neck3.getChild("neck4");
        this.neck5 = neck4.getChild("neck5");
        this.neck6 = neck5.getChild("neck6");
        this.head = neck6.getChild("head");
        this.jaw = head.getChild("jaw");
        this.hornL = head.getChild("horn_l");
        this.hornL2 = hornL.getChild("horn_l_2");
        this.hornL3 = hornL2.getChild("horn_l_3");
        this.browL = head.getChild("brow_l");
        this.hornR = head.getChild("horn_r");
        this.hornR2 = hornR.getChild("horn_r_2");
        this.hornR3 = hornR2.getChild("horn_r_3");
        this.browR = head.getChild("brow_r");
        this.tail1 = body.getChild("tail1");
        this.tail2 = tail1.getChild("tail2");
        this.tail3 = tail2.getChild("tail3");
        this.tail4 = tail3.getChild("tail4");
        this.tail5 = tail4.getChild("tail5");
        this.tail6 = tail5.getChild("tail6");
        this.tail7 = tail6.getChild("tail7");
        this.tail8 = tail7.getChild("tail8");
        this.tail9 = tail8.getChild("tail9");
        this.tailTip = tail9.getChild("tail_tip");
        this.wingL = body.getChild("wing_l");
        this.armL = wingL.getChild("arm_l");
        this.foreL = armL.getChild("fore_l");
        this.f1L = foreL.getChild("f1_l");
        this.f2L = foreL.getChild("f2_l");
        this.f3L = foreL.getChild("f3_l");
        this.f4L = foreL.getChild("f4_l");
        this.wingR = body.getChild("wing_r");
        this.armR = wingR.getChild("arm_r");
        this.foreR = armR.getChild("fore_r");
        this.f1R = foreR.getChild("f1_r");
        this.f2R = foreR.getChild("f2_r");
        this.f3R = foreR.getChild("f3_r");
        this.f4R = foreR.getChild("f4_r");
        this.legBl = body.getChild("leg_bl");
        this.shinBl = legBl.getChild("shin_bl");
        this.metaBl = shinBl.getChild("meta_bl");
        this.footBl = metaBl.getChild("foot_bl");
        this.legBr = body.getChild("leg_br");
        this.shinBr = legBr.getChild("shin_br");
        this.metaBr = shinBr.getChild("meta_br");
        this.footBr = metaBr.getChild("foot_br");
        this.antlerL = head.getChild("antler_l");
        this.antlerLA = antlerL.getChild("antler_l_a");
        this.antlerLB = antlerL.getChild("antler_l_b");
        this.antlerR = head.getChild("antler_r");
        this.antlerRA = antlerR.getChild("antler_r_a");
        this.antlerRB = antlerR.getChild("antler_r_b");
        this.boltA = tailTip.getChild("bolt_a");
        this.boltB = boltA.getChild("bolt_b");
        this.spark0 = body.getChild("spark_0");
        this.spark1 = body.getChild("spark_1");
        this.spark2 = body.getChild("spark_2");
        this.spark3 = body.getChild("spark_3");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData data = new ModelData();
        ModelPartData root = data.getRoot();
        ModelPartData frame = root.addChild("frame", ModelPartBuilder.create(),
                ModelTransform.of(0f, 24f, 0f, 0f, 0f, 0f));
        ModelPartData body = frame.addChild("body", ModelPartBuilder.create()
                .uv(0, 0).cuboid(-8f, -8.5f, -14f, 16f, 17f, 10f)
                .uv(200, 0).cuboid(-6.5f, -7f, -4f, 13f, 14f, 8f)
                .uv(52, 0).cuboid(-7.5f, -7.5f, 4f, 15f, 15f, 9f)
                .uv(220, 92).cuboid(-1.5f, -13.5f, -12f, 3f, 5f, 3f)
                .uv(60, 102).cuboid(-1.5f, -12.5f, -8f, 3f, 4f, 3f)
                .uv(60, 102).cuboid(-1.5f, -11.5f, -4f, 3f, 4f, 3f)
                .uv(60, 102).cuboid(-1.5f, -11.5f, 1f, 3f, 4f, 3f)
                .uv(60, 102).cuboid(-1.5f, -11.5f, 5f, 3f, 4f, 3f)
                .uv(220, 92).cuboid(-1.5f, -12.5f, 10f, 3f, 5f, 3f),
                ModelTransform.of(0f, -25.9272f, 0f, 0f, 0f, 0f));
        ModelPartData neck1 = body.addChild("neck1", ModelPartBuilder.create()
                .uv(104, 27).cuboid(-6f, -6f, -7f, 12f, 12f, 7f)
                .uv(212, 102).cuboid(-1.5f, -9f, -6f, 3f, 3f, 3f),
                ModelTransform.of(0f, -6.5f, -12f, -0.45f, 0f, 0f));
        ModelPartData neck2 = neck1.addChild("neck2", ModelPartBuilder.create()
                .uv(202, 27).cuboid(-5.5f, -5.5f, -7f, 11f, 11f, 7f)
                .uv(212, 102).cuboid(-1.5f, -8.5f, -6f, 3f, 3f, 3f),
                ModelTransform.of(0f, 0f, -7f, -0.25f, 0f, 0f));
        ModelPartData neck3 = neck2.addChild("neck3", ModelPartBuilder.create()
                .uv(0, 48).cuboid(-5f, -5f, -7f, 10f, 10f, 7f)
                .uv(212, 102).cuboid(-1.5f, -8f, -6f, 3f, 3f, 3f),
                ModelTransform.of(0f, 0f, -7f, -0.05f, 0f, 0f));
        ModelPartData neck4 = neck3.addChild("neck4", ModelPartBuilder.create()
                .uv(80, 48).cuboid(-4.5f, -4.5f, -7f, 9f, 9f, 7f)
                .uv(212, 102).cuboid(-1.5f, -7.5f, -6f, 3f, 3f, 3f),
                ModelTransform.of(0f, 0f, -7f, 0.1f, 0f, 0f));
        ModelPartData neck5 = neck4.addChild("neck5", ModelPartBuilder.create()
                .uv(32, 65).cuboid(-4f, -4f, -7f, 8f, 8f, 7f)
                .uv(212, 102).cuboid(-1.5f, -7f, -6f, 3f, 3f, 3f),
                ModelTransform.of(0f, 0f, -7f, 0.2f, 0f, 0f));
        ModelPartData neck6 = neck5.addChild("neck6", ModelPartBuilder.create()
                .uv(92, 65).cuboid(-3.5f, -3.5f, -7f, 7f, 7f, 7f)
                .uv(212, 102).cuboid(-1.5f, -6.5f, -6f, 3f, 3f, 3f),
                ModelTransform.of(0f, 0f, -7f, 0.2f, 0f, 0f));
        ModelPartData head = neck6.addChild("head", ModelPartBuilder.create()
                .uv(162, 27).cuboid(-5.5f, -4.5f, -9f, 11f, 9f, 9f)
                .uv(224, 102).cuboid(-6f, -5.5f, -7f, 12f, 1f, 4f)
                .uv(120, 65).cuboid(-3.5f, -2.5f, -16f, 7f, 6f, 7f)
                .uv(106, 80).cuboid(-3f, -2f, -22f, 6f, 5f, 6f)
                .uv(244, 109).cuboid(-2.5f, -2.5f, -22.5f, 1f, 1f, 1f)
                .uv(244, 109).cuboid(1.5f, -2.5f, -22.5f, 1f, 1f, 1f)
                .uv(154, 109).cuboid(5.4f, -3f, -7f, 1f, 2f, 2f)
                .uv(154, 109).cuboid(-6.4f, -3f, -7f, 1f, 2f, 2f)
                .uv(128, 92).cuboid(5.5f, -1f, -4f, 1f, 4f, 5f)
                .uv(128, 92).cuboid(-6.5f, -1f, -4f, 1f, 4f, 5f)
                .uv(174, 92).cuboid(-1f, -7f, -7f, 2f, 2f, 6f)
                .uv(240, 109).cuboid(-3.5f, 3.5f, -15f, 1f, 2f, 1f)
                .uv(240, 109).cuboid(-3.5f, 3.5f, -13f, 1f, 2f, 1f)
                .uv(240, 109).cuboid(-3.5f, 3.5f, -11f, 1f, 2f, 1f)
                .uv(240, 109).cuboid(2.5f, 3.5f, -15f, 1f, 2f, 1f)
                .uv(240, 109).cuboid(2.5f, 3.5f, -13f, 1f, 2f, 1f)
                .uv(240, 109).cuboid(2.5f, 3.5f, -11f, 1f, 2f, 1f)
                .uv(240, 109).cuboid(-3f, 3f, -21f, 1f, 2f, 1f)
                .uv(240, 109).cuboid(-3f, 3f, -19f, 1f, 2f, 1f)
                .uv(240, 109).cuboid(-3f, 3f, -17f, 1f, 2f, 1f)
                .uv(240, 109).cuboid(2f, 3f, -21f, 1f, 2f, 1f)
                .uv(240, 109).cuboid(2f, 3f, -19f, 1f, 2f, 1f)
                .uv(240, 109).cuboid(2f, 3f, -17f, 1f, 2f, 1f)
                .uv(160, 109).cuboid(-3f, 3f, -22f, 1f, 3f, 1f)
                .uv(160, 109).cuboid(2f, 3f, -22f, 1f, 3f, 1f),
                ModelTransform.of(0f, 0f, -7f, 0.4f, 0f, 0f));
        ModelPartData jaw = head.addChild("jaw", ModelPartBuilder.create()
                .uv(148, 0).cuboid(-3.5f, 0f, -20f, 7f, 3f, 19f)
                .uv(240, 109).cuboid(-3f, -2f, -19f, 1f, 2f, 1f)
                .uv(240, 109).cuboid(-3f, -2f, -17f, 1f, 2f, 1f)
                .uv(240, 109).cuboid(-3f, -2f, -15f, 1f, 2f, 1f)
                .uv(240, 109).cuboid(-3f, -2f, -13f, 1f, 2f, 1f)
                .uv(240, 109).cuboid(-3f, -2f, -11f, 1f, 2f, 1f)
                .uv(240, 109).cuboid(2f, -2f, -19f, 1f, 2f, 1f)
                .uv(240, 109).cuboid(2f, -2f, -17f, 1f, 2f, 1f)
                .uv(240, 109).cuboid(2f, -2f, -15f, 1f, 2f, 1f)
                .uv(240, 109).cuboid(2f, -2f, -13f, 1f, 2f, 1f)
                .uv(240, 109).cuboid(2f, -2f, -11f, 1f, 2f, 1f)
                .uv(146, 109).cuboid(-1f, 3f, -19f, 2f, 2f, 2f),
                ModelTransform.of(0f, 3.5f, -0.5f, 0f, 0f, 0f));
        ModelPartData hornL = head.addChild("horn_l", ModelPartBuilder.create()
                .uv(62, 80).cuboid(-2f, -2f, 0f, 4f, 4f, 8f),
                ModelTransform.of(4.5f, -4.5f, -1f, 0.2f, 0.3f, 0f));
        ModelPartData hornL2 = hornL.addChild("horn_l_2", ModelPartBuilder.create()
                .uv(154, 80).cuboid(-1.5f, -1.5f, 0f, 3f, 3f, 8f),
                ModelTransform.of(0f, 0f, 8f, 0.1f, 0.12f, 0f));
        ModelPartData hornL3 = hornL2.addChild("horn_l_3", ModelPartBuilder.create()
                .uv(56, 92).cuboid(-1f, -1f, 0f, 2f, 2f, 7f),
                ModelTransform.of(0f, 0f, 8f, 0.25f, 0.05f, 0f));
        ModelPartData browL = head.addChild("brow_l", ModelPartBuilder.create()
                .uv(74, 92).cuboid(-1.5f, -1.5f, -6f, 3f, 3f, 6f),
                ModelTransform.of(5f, -5.5f, -6f, 0.25f, -0.35f, 0f));
        ModelPartData hornR = head.addChild("horn_r", ModelPartBuilder.create()
                .uv(62, 80).cuboid(-2f, -2f, 0f, 4f, 4f, 8f),
                ModelTransform.of(-4.5f, -4.5f, -1f, 0.2f, -0.3f, 0f));
        ModelPartData hornR2 = hornR.addChild("horn_r_2", ModelPartBuilder.create()
                .uv(154, 80).cuboid(-1.5f, -1.5f, 0f, 3f, 3f, 8f),
                ModelTransform.of(0f, 0f, 8f, 0.1f, -0.12f, 0f));
        ModelPartData hornR3 = hornR2.addChild("horn_r_3", ModelPartBuilder.create()
                .uv(56, 92).cuboid(-1f, -1f, 0f, 2f, 2f, 7f),
                ModelTransform.of(0f, 0f, 8f, 0.25f, -0.05f, 0f));
        ModelPartData browR = head.addChild("brow_r", ModelPartBuilder.create()
                .uv(74, 92).cuboid(-1.5f, -1.5f, -6f, 3f, 3f, 6f),
                ModelTransform.of(-5f, -5.5f, -6f, 0.25f, 0.35f, 0f));
        ModelPartData tail1 = body.addChild("tail1", ModelPartBuilder.create()
                .uv(104, 27).cuboid(-6f, -6f, 0f, 12f, 12f, 7f)
                .uv(206, 92).cuboid(-1.5f, -10f, 1f, 3f, 4f, 4f),
                ModelTransform.of(0f, -0.5f, 13f, 0f, 0f, 0f));
        ModelPartData tail2 = tail1.addChild("tail2", ModelPartBuilder.create()
                .uv(0, 48).cuboid(-5f, -5f, 0f, 10f, 10f, 7f)
                .uv(206, 92).cuboid(-1.5f, -9f, 1f, 3f, 4f, 4f),
                ModelTransform.of(0f, 0f, 7f, 0f, 0f, 0f));
        ModelPartData tail3 = tail2.addChild("tail3", ModelPartBuilder.create()
                .uv(0, 65).cuboid(-4.5f, -4f, 0f, 9f, 8f, 7f)
                .uv(206, 92).cuboid(-1.5f, -8f, 1f, 3f, 4f, 4f),
                ModelTransform.of(0f, 0f, 7f, 0f, 0f, 0f));
        ModelPartData tail4 = tail3.addChild("tail4", ModelPartBuilder.create()
                .uv(62, 65).cuboid(-4f, -3.5f, 0f, 8f, 7f, 7f)
                .uv(206, 92).cuboid(-1.5f, -7.5f, 1f, 3f, 4f, 4f),
                ModelTransform.of(0f, 0f, 7f, 0f, 0f, 0f));
        ModelPartData tail5 = tail4.addChild("tail5", ModelPartBuilder.create()
                .uv(148, 65).cuboid(-3.5f, -3f, 0f, 7f, 6f, 7f)
                .uv(206, 92).cuboid(-1.5f, -7f, 1f, 3f, 4f, 4f),
                ModelTransform.of(0f, 0f, 7f, 0f, 0f, 0f));
        ModelPartData tail6 = tail5.addChild("tail6", ModelPartBuilder.create()
                .uv(36, 80).cuboid(-3f, -2.5f, 0f, 6f, 5f, 7f)
                .uv(206, 92).cuboid(-1.5f, -6.5f, 1f, 3f, 4f, 4f),
                ModelTransform.of(0f, 0f, 7f, 0f, 0f, 0f));
        ModelPartData tail7 = tail6.addChild("tail7", ModelPartBuilder.create()
                .uv(130, 80).cuboid(-2.5f, -2f, 0f, 5f, 4f, 7f)
                .uv(206, 92).cuboid(-1.5f, -6f, 1f, 3f, 4f, 4f),
                ModelTransform.of(0f, 0f, 7f, 0f, 0f, 0f));
        ModelPartData tail8 = tail7.addChild("tail8", ModelPartBuilder.create()
                .uv(218, 80).cuboid(-2f, -1.5f, 0f, 4f, 3f, 7f)
                .uv(206, 92).cuboid(-1.5f, -5.5f, 1f, 3f, 4f, 4f),
                ModelTransform.of(0f, 0f, 7f, 0f, 0f, 0f));
        ModelPartData tail9 = tail8.addChild("tail9", ModelPartBuilder.create()
                .uv(0, 92).cuboid(-1.5f, -1.5f, 0f, 3f, 3f, 7f),
                ModelTransform.of(0f, 0f, 7f, 0f, 0f, 0f));
        ModelPartData tailTip = tail9.addChild("tail_tip", ModelPartBuilder.create()
                .uv(142, 27).cuboid(-1.5f, -6f, 0f, 3f, 12f, 7f)
                .uv(140, 92).cuboid(-6f, -1.5f, 1f, 12f, 3f, 5f),
                ModelTransform.of(0f, 0f, 7f, 0f, 0f, 0f));
        ModelPartData wingL = body.addChild("wing_l", ModelPartBuilder.create()
                .uv(112, 48).cuboid(0f, -4f, -4f, 8f, 8f, 8f),
                ModelTransform.of(7.5f, -7.5f, -9f, 0f, 0f, 0f));
        ModelPartData armL = wingL.addChild("arm_l", ModelPartBuilder.create()
                .uv(0, 80).cuboid(0f, -3f, -3f, 12f, 6f, 6f)
                .uv(0, 27).cuboid(0f, -0.5f, 4f, 12f, 1f, 20f, new Dilation(0f, -0.25f, 0f)),
                ModelTransform.of(6f, 0f, 0f, 0f, 0f, 0f));
        ModelPartData foreL = armL.addChild("fore_l", ModelPartBuilder.create()
                .uv(176, 80).cuboid(0f, -2.5f, -2.5f, 16f, 5f, 5f)
                .uv(168, 48).cuboid(0f, -0.5f, 3f, 16f, 1f, 14f, new Dilation(0f, -0.25f, 0f))
                .uv(92, 92).cuboid(0f, -2f, -6f, 3f, 3f, 6f),
                ModelTransform.of(12f, 0f, 0f, 0f, 0f, 0f));
        ModelPartData f1L = foreL.addChild("f1_l", ModelPartBuilder.create()
                .uv(72, 102).cuboid(0f, -1.5f, -1.5f, 30f, 3f, 3f)
                .uv(164, 109).cuboid(0f, -0.5f, 1.5f, 10f, 1f, 2f, new Dilation(0f, -0.25f, 0f))
                .uv(0, 102).cuboid(10f, -0.5f, 1.5f, 10f, 1f, 6f, new Dilation(0f, -0.25f, 0f))
                .uv(192, 65).cuboid(20f, -0.5f, 1.5f, 10f, 1f, 11f, new Dilation(0f, -0.25f, 0f)),
                ModelTransform.of(16f, 0f, 0f, 0f, -0.3f, 0f));
        ModelPartData f2L = foreL.addChild("f2_l", ModelPartBuilder.create()
                .uv(138, 102).cuboid(0f, -1.5f, -1.5f, 26f, 3f, 3f)
                .uv(188, 109).cuboid(0f, -0.5f, 1.5f, 8f, 1f, 2f, new Dilation(0f, -0.25f, 0f))
                .uv(0, 109).cuboid(8f, -0.5f, 1.5f, 8f, 1f, 4f, new Dilation(0f, -0.25f, 0f))
                .uv(20, 92).cuboid(16f, -0.5f, 1.5f, 10f, 1f, 8f, new Dilation(0f, -0.25f, 0f)),
                ModelTransform.of(16f, 0f, 0f, 0f, -0.75f, 0f));
        ModelPartData f3L = foreL.addChild("f3_l", ModelPartBuilder.create()
                .uv(24, 109).cuboid(0f, -1f, -1f, 22f, 2f, 2f)
                .uv(208, 109).cuboid(0f, -0.5f, 1f, 7f, 1f, 2f, new Dilation(0f, -0.25f, 0f))
                .uv(108, 109).cuboid(7f, -0.5f, 1f, 7f, 1f, 3f, new Dilation(0f, -0.25f, 0f))
                .uv(32, 102).cuboid(14f, -0.5f, 1f, 8f, 1f, 6f, new Dilation(0f, -0.25f, 0f)),
                ModelTransform.of(16f, 0f, 0f, 0f, -1.15f, 0f));
        ModelPartData f4L = foreL.addChild("f4_l", ModelPartBuilder.create()
                .uv(72, 109).cuboid(0f, -1f, -1f, 16f, 2f, 2f)
                .uv(226, 109).cuboid(0f, -0.5f, 1f, 5f, 1f, 2f, new Dilation(0f, -0.25f, 0f))
                .uv(226, 109).cuboid(5f, -0.5f, 1f, 5f, 1f, 2f, new Dilation(0f, -0.25f, 0f))
                .uv(128, 109).cuboid(10f, -0.5f, 1f, 6f, 1f, 3f, new Dilation(0f, -0.25f, 0f)),
                ModelTransform.of(16f, 0f, 0f, 0f, -1.5f, 0f));
        ModelPartData wingR = body.addChild("wing_r", ModelPartBuilder.create()
                .uv(112, 48).cuboid(-8f, -4f, -4f, 8f, 8f, 8f),
                ModelTransform.of(-7.5f, -7.5f, -9f, 0f, 0f, 0f));
        ModelPartData armR = wingR.addChild("arm_r", ModelPartBuilder.create()
                .uv(0, 80).cuboid(-12f, -3f, -3f, 12f, 6f, 6f)
                .uv(0, 27).cuboid(-12f, -0.5f, 4f, 12f, 1f, 20f, new Dilation(0f, -0.25f, 0f)),
                ModelTransform.of(-6f, 0f, 0f, 0f, 0f, 0f));
        ModelPartData foreR = armR.addChild("fore_r", ModelPartBuilder.create()
                .uv(176, 80).cuboid(-16f, -2.5f, -2.5f, 16f, 5f, 5f)
                .uv(168, 48).cuboid(-16f, -0.5f, 3f, 16f, 1f, 14f, new Dilation(0f, -0.25f, 0f))
                .uv(92, 92).cuboid(-3f, -2f, -6f, 3f, 3f, 6f),
                ModelTransform.of(-12f, 0f, 0f, 0f, 0f, 0f));
        ModelPartData f1R = foreR.addChild("f1_r", ModelPartBuilder.create()
                .uv(72, 102).cuboid(-30f, -1.5f, -1.5f, 30f, 3f, 3f)
                .uv(164, 109).cuboid(-10f, -0.5f, 1.5f, 10f, 1f, 2f, new Dilation(0f, -0.25f, 0f))
                .uv(0, 102).cuboid(-20f, -0.5f, 1.5f, 10f, 1f, 6f, new Dilation(0f, -0.25f, 0f))
                .uv(192, 65).cuboid(-30f, -0.5f, 1.5f, 10f, 1f, 11f, new Dilation(0f, -0.25f, 0f)),
                ModelTransform.of(-16f, 0f, 0f, 0f, 0.3f, 0f));
        ModelPartData f2R = foreR.addChild("f2_r", ModelPartBuilder.create()
                .uv(138, 102).cuboid(-26f, -1.5f, -1.5f, 26f, 3f, 3f)
                .uv(188, 109).cuboid(-8f, -0.5f, 1.5f, 8f, 1f, 2f, new Dilation(0f, -0.25f, 0f))
                .uv(0, 109).cuboid(-16f, -0.5f, 1.5f, 8f, 1f, 4f, new Dilation(0f, -0.25f, 0f))
                .uv(20, 92).cuboid(-26f, -0.5f, 1.5f, 10f, 1f, 8f, new Dilation(0f, -0.25f, 0f)),
                ModelTransform.of(-16f, 0f, 0f, 0f, 0.75f, 0f));
        ModelPartData f3R = foreR.addChild("f3_r", ModelPartBuilder.create()
                .uv(24, 109).cuboid(-22f, -1f, -1f, 22f, 2f, 2f)
                .uv(208, 109).cuboid(-7f, -0.5f, 1f, 7f, 1f, 2f, new Dilation(0f, -0.25f, 0f))
                .uv(108, 109).cuboid(-14f, -0.5f, 1f, 7f, 1f, 3f, new Dilation(0f, -0.25f, 0f))
                .uv(32, 102).cuboid(-22f, -0.5f, 1f, 8f, 1f, 6f, new Dilation(0f, -0.25f, 0f)),
                ModelTransform.of(-16f, 0f, 0f, 0f, 1.15f, 0f));
        ModelPartData f4R = foreR.addChild("f4_r", ModelPartBuilder.create()
                .uv(72, 109).cuboid(-16f, -1f, -1f, 16f, 2f, 2f)
                .uv(226, 109).cuboid(-5f, -0.5f, 1f, 5f, 1f, 2f, new Dilation(0f, -0.25f, 0f))
                .uv(226, 109).cuboid(-10f, -0.5f, 1f, 5f, 1f, 2f, new Dilation(0f, -0.25f, 0f))
                .uv(128, 109).cuboid(-16f, -0.5f, 1f, 6f, 1f, 3f, new Dilation(0f, -0.25f, 0f)),
                ModelTransform.of(-16f, 0f, 0f, 0f, 1.5f, 0f));
        ModelPartData legBl = body.addChild("leg_bl", ModelPartBuilder.create()
                .uv(64, 27).cuboid(-5f, -3f, -5f, 10f, 11f, 10f)
                .uv(100, 0).cuboid(-6f, -6f, -6f, 12f, 12f, 12f),
                ModelTransform.of(8f, 5.5f, 2f, -0.7f, 0f, 0f));
        ModelPartData shinBl = legBl.addChild("shin_bl", ModelPartBuilder.create()
                .uv(144, 48).cuboid(-3f, -1f, -3f, 6f, 10f, 6f),
                ModelTransform.of(0f, 8f, 0f, 1.3f, 0f, 0f));
        ModelPartData metaBl = shinBl.addChild("meta_bl", ModelPartBuilder.create()
                .uv(86, 80).cuboid(-2.5f, -0.5f, -2.5f, 5f, 7f, 5f),
                ModelTransform.of(0f, 9f, 0f, -0.8f, 0f, 0f));
        ModelPartData footBl = metaBl.addChild("foot_bl", ModelPartBuilder.create()
                .uv(34, 48).cuboid(-4.5f, -1f, -11f, 9f, 2f, 14f)
                .uv(196, 102).cuboid(-4.5f, -0.5f, -16f, 3f, 1f, 5f)
                .uv(196, 102).cuboid(-1.5f, -0.5f, -16f, 3f, 1f, 5f)
                .uv(196, 102).cuboid(1.5f, -0.5f, -16f, 3f, 1f, 5f),
                ModelTransform.of(0f, 6f, 0f, 0.2f, 0f, 0f));
        ModelPartData legBr = body.addChild("leg_br", ModelPartBuilder.create()
                .uv(64, 27).cuboid(-5f, -3f, -5f, 10f, 11f, 10f)
                .uv(100, 0).cuboid(-6f, -6f, -6f, 12f, 12f, 12f),
                ModelTransform.of(-8f, 5.5f, 2f, -0.7f, 0f, 0f));
        ModelPartData shinBr = legBr.addChild("shin_br", ModelPartBuilder.create()
                .uv(144, 48).cuboid(-3f, -1f, -3f, 6f, 10f, 6f),
                ModelTransform.of(0f, 8f, 0f, 1.3f, 0f, 0f));
        ModelPartData metaBr = shinBr.addChild("meta_br", ModelPartBuilder.create()
                .uv(86, 80).cuboid(-2.5f, -0.5f, -2.5f, 5f, 7f, 5f),
                ModelTransform.of(0f, 9f, 0f, -0.8f, 0f, 0f));
        ModelPartData footBr = metaBr.addChild("foot_br", ModelPartBuilder.create()
                .uv(34, 48).cuboid(-4.5f, -1f, -11f, 9f, 2f, 14f)
                .uv(196, 102).cuboid(-4.5f, -0.5f, -16f, 3f, 1f, 5f)
                .uv(196, 102).cuboid(-1.5f, -0.5f, -16f, 3f, 1f, 5f)
                .uv(196, 102).cuboid(1.5f, -0.5f, -16f, 3f, 1f, 5f),
                ModelTransform.of(0f, 6f, 0f, 0.2f, 0f, 0f));
        ModelPartData antlerL = head.addChild("antler_l", ModelPartBuilder.create()
                .uv(56, 92).cuboid(-1f, -1f, 0f, 2f, 2f, 7f),
                ModelTransform.of(4.5f, -5f, -3f, 0.9f, 0.35f, 0f));
        ModelPartData antlerLA = antlerL.addChild("antler_l_a", ModelPartBuilder.create()
                .uv(190, 92).cuboid(-1f, -1f, 0f, 2f, 2f, 6f),
                ModelTransform.of(0f, 0f, 7f, -0.5f, 0f, 0f));
        ModelPartData antlerLB = antlerL.addChild("antler_l_b", ModelPartBuilder.create()
                .uv(190, 92).cuboid(-1f, -1f, 0f, 2f, 2f, 6f),
                ModelTransform.of(0f, 0f, 3f, 0.2f, 0.7f, 0f));
        ModelPartData antlerR = head.addChild("antler_r", ModelPartBuilder.create()
                .uv(56, 92).cuboid(-1f, -1f, 0f, 2f, 2f, 7f),
                ModelTransform.of(-4.5f, -5f, -3f, 0.9f, -0.35f, 0f));
        ModelPartData antlerRA = antlerR.addChild("antler_r_a", ModelPartBuilder.create()
                .uv(190, 92).cuboid(-1f, -1f, 0f, 2f, 2f, 6f),
                ModelTransform.of(0f, 0f, 7f, -0.5f, 0f, 0f));
        ModelPartData antlerRB = antlerR.addChild("antler_r_b", ModelPartBuilder.create()
                .uv(190, 92).cuboid(-1f, -1f, 0f, 2f, 2f, 6f),
                ModelTransform.of(0f, 0f, 3f, 0.2f, -0.7f, 0f));
        ModelPartData boltA = tailTip.addChild("bolt_a", ModelPartBuilder.create()
                .uv(110, 92).cuboid(-1f, -1f, 0f, 2f, 2f, 7f),
                ModelTransform.of(0f, 0f, 7f, 0f, 0.6f, 0f));
        ModelPartData boltB = boltA.addChild("bolt_b", ModelPartBuilder.create()
                .uv(110, 92).cuboid(-1f, -1f, 0f, 2f, 2f, 7f),
                ModelTransform.of(0f, 0f, 7f, 0f, -1.2f, 0f));
        ModelPartData spark0 = body.addChild("spark_0", ModelPartBuilder.create()
                .uv(176, 65).cuboid(-2f, -9f, -2f, 4f, 9f, 4f),
                ModelTransform.of(0f, -8.5f, -11f, 0f, 0f, 0f));
        ModelPartData spark1 = body.addChild("spark_1", ModelPartBuilder.create()
                .uv(176, 65).cuboid(-2f, -9f, -2f, 4f, 9f, 4f),
                ModelTransform.of(0f, -8.5f, -4f, 0f, 0f, 0f));
        ModelPartData spark2 = body.addChild("spark_2", ModelPartBuilder.create()
                .uv(176, 65).cuboid(-2f, -9f, -2f, 4f, 9f, 4f),
                ModelTransform.of(0f, -8.5f, 3f, 0f, 0f, 0f));
        ModelPartData spark3 = body.addChild("spark_3", ModelPartBuilder.create()
                .uv(176, 65).cuboid(-2f, -9f, -2f, 4f, 9f, 4f),
                ModelTransform.of(0f, -8.5f, 10f, 0f, 0f, 0f));
        return TexturedModelData.of(data, 256, 256);
    }

    private static float sin(float v) { return (float) Math.sin(v); }
    private static float cos(float v) { return (float) Math.cos(v); }

    private static final float HA1 = -0.7f, HR2 = 1.3f, HR3 = -0.8f, HF = 0.2f;
    private static final float FA1 = 0.4f, FR2 = -0.85f, FR3 = 0.55f, FF = -0.1f;
    private static final float[] NECK = {-0.45f, -0.25f, -0.05f, 0.1f, 0.2f, 0.2f};
    private static final float[] FING = {0.3f, 0.75f, 1.15f, 1.5f};

    private static void leg(ModelPart leg, ModelPart shin, ModelPart meta, ModelPart foot,
                            float a1, float r2, float r3, float ff, float dh, float dk, float da) {
        leg.pitch = a1 + dh;
        shin.pitch = r2 + dk;
        meta.pitch = r3 + da;
        foot.pitch = ff - (dh + dk + da);
    }

    @Override
    public void setAngles(AshwingRenderState s) {
        super.setAngles(s);
        float t = s.age;
        float amp = Math.min(1f, s.walkSpeed * 1.6f);
        float f = s.walkPhase * 0.6662f;
        float breathe = sin(t * 0.09f);
        float yawLook = s.relativeHeadYaw * 0.0174533f;
        float pitchLook = s.pitch * 0.0174533f;
        boolean sit = s.sitting;
        boolean fly = s.flying;

        this.frame.pitch = sit ? -0.4f : (fly ? 0.12f : 0f);
        this.body.pitch = breathe * 0.01f + sin(f * 2f) * 0.03f * amp;

        ModelPart[] neck = {neck1, neck2, neck3, neck4, neck5, neck6};
        for (int i = 0; i < 6; i++) {
            neck[i].pitch = NECK[i] + (fly ? 0.06f : 0f) + (s.breathing ? -0.04f : 0f) + (sit ? 0.08f : 0f);
            neck[i].yaw = yawLook * 0.1f + sin(t * 0.05f - i * 0.5f) * 0.03f;
        }
        this.head.yaw = yawLook * 0.4f;
        this.head.pitch = 0.4f + pitchLook * 0.5f + breathe * 0.02f - (s.breathing ? 0.35f : 0f);
        this.jaw.pitch = s.breathing ? 0.85f : 0.2f + (breathe + 1f) * 0.03f;

        ModelPart[] tail = {tail1, tail2, tail3, tail4, tail5, tail6, tail7, tail8, tail9};
        float walkSway = cos(f) * 0.06f * amp;
        for (int i = 0; i < 9; i++) {
            tail[i].yaw = sin(t * 0.06f - i * 0.55f) * (0.06f + i * 0.012f) + walkSway;
            tail[i].pitch = sit ? (i == 0 ? 0.35f : 0.05f) : (fly ? -0.02f : 0f);
        }
        this.tailTip.yaw = sin(t * 0.06f - 5f) * 0.2f;

        float swA = cos(f) * amp, swB = -swA;
        float liftA = Math.max(0f, sin(f)) * amp, liftB = Math.max(0f, -sin(f)) * amp;
        float sh = sit ? -0.9f : (fly ? 0.9f : 0f);
        float sk = sit ? 1.1f : (fly ? 0.8f : 0f);
        float sa = sit ? -0.2f : (fly ? 0.2f : 0f);
        leg(legBl, shinBl, metaBl, footBl, HA1, HR2, HR3, HF, swA * 0.55f + sh, liftA * 0.7f + sk, -liftA * 0.35f + sa);
        leg(legBr, shinBr, metaBr, footBr, HA1, HR2, HR3, HF, swB * 0.55f + sh, liftB * 0.7f + sk, -liftB * 0.35f + sa);

        float fold = fly ? 0f : 0.9f;
        float flap = fly ? sin(t * 0.3f) : sin(t * 0.1f) * 0.04f;
        this.wingL.yaw = -0.8f * fold + (fly ? -0.1f : 0f);
        this.wingR.yaw = -this.wingL.yaw;
        this.wingL.roll = 0.3f * fold - flap * (fly ? 0.75f : 1f);
        this.wingR.roll = -this.wingL.roll;
        if (!fly) { this.wingL.yaw += swA * 0.14f; this.wingR.yaw += swB * 0.14f; }
        this.armL.roll = fly ? -flap * 0.25f : 0f;
        this.armR.roll = -this.armL.roll;
        this.foreL.yaw = -1.2f * fold;
        this.foreR.yaw = -this.foreL.yaw;
        this.foreL.roll = fly ? -flap * 0.5f : 0f;
        this.foreR.roll = -this.foreL.roll;
        ModelPart[] fl = {f1L, f2L, f3L, f4L};
        ModelPart[] fr = {f1R, f2R, f3R, f4R};
        for (int i = 0; i < 4; i++) {
            fl[i].yaw = -FING[i] * (1f - 0.72f * fold);
            fr[i].yaw = -fl[i].yaw;
            fl[i].roll = fly ? -flap * 0.25f * (i + 1) / 4f : 0f;
            fr[i].roll = -fl[i].roll;
        }
    }
}
