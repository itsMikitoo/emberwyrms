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
public class IceDragonModel extends EntityModel<AshwingRenderState> {
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
    private final ModelPart legFl;
    private final ModelPart shinFl;
    private final ModelPart metaFl;
    private final ModelPart footFl;
    private final ModelPart legFr;
    private final ModelPart shinFr;
    private final ModelPart metaFr;
    private final ModelPart footFr;
    private final ModelPart legBl;
    private final ModelPart shinBl;
    private final ModelPart metaBl;
    private final ModelPart footBl;
    private final ModelPart legBr;
    private final ModelPart shinBr;
    private final ModelPart metaBr;
    private final ModelPart footBr;
    private final ModelPart crystal0;
    private final ModelPart crystal1;
    private final ModelPart crystal2;
    private final ModelPart crystal3;
    private final ModelPart crystal4;
    private final ModelPart crownL;
    private final ModelPart crownR;
    private final ModelPart tailCrystal;

    public IceDragonModel(ModelPart root) {
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
        this.legFl = body.getChild("leg_fl");
        this.shinFl = legFl.getChild("shin_fl");
        this.metaFl = shinFl.getChild("meta_fl");
        this.footFl = metaFl.getChild("foot_fl");
        this.legFr = body.getChild("leg_fr");
        this.shinFr = legFr.getChild("shin_fr");
        this.metaFr = shinFr.getChild("meta_fr");
        this.footFr = metaFr.getChild("foot_fr");
        this.legBl = body.getChild("leg_bl");
        this.shinBl = legBl.getChild("shin_bl");
        this.metaBl = shinBl.getChild("meta_bl");
        this.footBl = metaBl.getChild("foot_bl");
        this.legBr = body.getChild("leg_br");
        this.shinBr = legBr.getChild("shin_br");
        this.metaBr = shinBr.getChild("meta_br");
        this.footBr = metaBr.getChild("foot_br");
        this.crystal0 = body.getChild("crystal_0");
        this.crystal1 = body.getChild("crystal_1");
        this.crystal2 = body.getChild("crystal_2");
        this.crystal3 = body.getChild("crystal_3");
        this.crystal4 = body.getChild("crystal_4");
        this.crownL = head.getChild("crown_l");
        this.crownR = head.getChild("crown_r");
        this.tailCrystal = tailTip.getChild("tail_crystal");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData data = new ModelData();
        ModelPartData root = data.getRoot();
        ModelPartData frame = root.addChild("frame", ModelPartBuilder.create(),
                ModelTransform.of(0f, 24f, 0f, 0f, 0f, 0f));
        ModelPartData body = frame.addChild("body", ModelPartBuilder.create()
                .uv(0, 0).cuboid(-8f, -8.5f, -14f, 16f, 17f, 10f)
                .uv(152, 0).cuboid(-6.5f, -7f, -4f, 13f, 14f, 8f)
                .uv(52, 0).cuboid(-7.5f, -7.5f, 4f, 15f, 15f, 9f)
                .uv(88, 105).cuboid(-1.5f, -13.5f, -12f, 3f, 5f, 3f)
                .uv(160, 105).cuboid(-1.5f, -12.5f, -8f, 3f, 4f, 3f)
                .uv(160, 105).cuboid(-1.5f, -11.5f, -4f, 3f, 4f, 3f)
                .uv(160, 105).cuboid(-1.5f, -11.5f, 1f, 3f, 4f, 3f)
                .uv(160, 105).cuboid(-1.5f, -11.5f, 5f, 3f, 4f, 3f)
                .uv(88, 105).cuboid(-1.5f, -12.5f, 10f, 3f, 5f, 3f),
                ModelTransform.of(0f, -23.0123f, 0f, 0f, 0f, 0f));
        ModelPartData neck1 = body.addChild("neck1", ModelPartBuilder.create()
                .uv(104, 27).cuboid(-6f, -6f, -7f, 12f, 12f, 7f)
                .uv(84, 114).cuboid(-1.5f, -9f, -6f, 3f, 3f, 3f),
                ModelTransform.of(0f, -6.5f, -12f, -0.45f, 0f, 0f));
        ModelPartData neck2 = neck1.addChild("neck2", ModelPartBuilder.create()
                .uv(0, 48).cuboid(-5.5f, -5.5f, -7f, 11f, 11f, 7f)
                .uv(84, 114).cuboid(-1.5f, -8.5f, -6f, 3f, 3f, 3f),
                ModelTransform.of(0f, 0f, -7f, -0.25f, 0f, 0f));
        ModelPartData neck3 = neck2.addChild("neck3", ModelPartBuilder.create()
                .uv(68, 48).cuboid(-5f, -5f, -7f, 10f, 10f, 7f)
                .uv(84, 114).cuboid(-1.5f, -8f, -6f, 3f, 3f, 3f),
                ModelTransform.of(0f, 0f, -7f, -0.05f, 0f, 0f));
        ModelPartData neck4 = neck3.addChild("neck4", ModelPartBuilder.create()
                .uv(114, 48).cuboid(-4.5f, -4.5f, -7f, 9f, 9f, 7f)
                .uv(84, 114).cuboid(-1.5f, -7.5f, -6f, 3f, 3f, 3f),
                ModelTransform.of(0f, 0f, -7f, 0.1f, 0f, 0f));
        ModelPartData neck5 = neck4.addChild("neck5", ModelPartBuilder.create()
                .uv(92, 66).cuboid(-4f, -4f, -7f, 8f, 8f, 7f)
                .uv(84, 114).cuboid(-1.5f, -7f, -6f, 3f, 3f, 3f),
                ModelTransform.of(0f, 0f, -7f, 0.2f, 0f, 0f));
        ModelPartData neck6 = neck5.addChild("neck6", ModelPartBuilder.create()
                .uv(152, 66).cuboid(-3.5f, -3.5f, -7f, 7f, 7f, 7f)
                .uv(84, 114).cuboid(-1.5f, -6.5f, -6f, 3f, 3f, 3f),
                ModelTransform.of(0f, 0f, -7f, 0.2f, 0f, 0f));
        ModelPartData head = neck6.addChild("head", ModelPartBuilder.create()
                .uv(200, 27).cuboid(-5.5f, -4.5f, -9f, 11f, 9f, 9f)
                .uv(108, 114).cuboid(-6f, -5.5f, -7f, 12f, 1f, 4f)
                .uv(0, 81).cuboid(-3.5f, -2.5f, -16f, 7f, 6f, 7f)
                .uv(204, 81).cuboid(-3f, -2f, -22f, 6f, 5f, 6f)
                .uv(172, 120).cuboid(-2.5f, -2.5f, -22.5f, 1f, 1f, 1f)
                .uv(172, 120).cuboid(1.5f, -2.5f, -22.5f, 1f, 1f, 1f)
                .uv(82, 120).cuboid(5.4f, -3f, -7f, 1f, 2f, 2f)
                .uv(82, 120).cuboid(-6.4f, -3f, -7f, 1f, 2f, 2f)
                .uv(0, 105).cuboid(5.5f, -1f, -4f, 1f, 4f, 5f)
                .uv(0, 105).cuboid(-6.5f, -1f, -4f, 1f, 4f, 5f)
                .uv(58, 105).cuboid(-1f, -7f, -7f, 2f, 2f, 6f)
                .uv(168, 120).cuboid(-3.5f, 3.5f, -15f, 1f, 2f, 1f)
                .uv(168, 120).cuboid(-3.5f, 3.5f, -13f, 1f, 2f, 1f)
                .uv(168, 120).cuboid(-3.5f, 3.5f, -11f, 1f, 2f, 1f)
                .uv(168, 120).cuboid(2.5f, 3.5f, -15f, 1f, 2f, 1f)
                .uv(168, 120).cuboid(2.5f, 3.5f, -13f, 1f, 2f, 1f)
                .uv(168, 120).cuboid(2.5f, 3.5f, -11f, 1f, 2f, 1f)
                .uv(168, 120).cuboid(-3f, 3f, -21f, 1f, 2f, 1f)
                .uv(168, 120).cuboid(-3f, 3f, -19f, 1f, 2f, 1f)
                .uv(168, 120).cuboid(-3f, 3f, -17f, 1f, 2f, 1f)
                .uv(168, 120).cuboid(2f, 3f, -21f, 1f, 2f, 1f)
                .uv(168, 120).cuboid(2f, 3f, -19f, 1f, 2f, 1f)
                .uv(168, 120).cuboid(2f, 3f, -17f, 1f, 2f, 1f)
                .uv(88, 120).cuboid(-3f, 3f, -22f, 1f, 3f, 1f)
                .uv(88, 120).cuboid(2f, 3f, -22f, 1f, 3f, 1f),
                ModelTransform.of(0f, 0f, -7f, 0.4f, 0f, 0f));
        ModelPartData jaw = head.addChild("jaw", ModelPartBuilder.create()
                .uv(100, 0).cuboid(-3.5f, 0f, -20f, 7f, 3f, 19f)
                .uv(168, 120).cuboid(-3f, -2f, -19f, 1f, 2f, 1f)
                .uv(168, 120).cuboid(-3f, -2f, -17f, 1f, 2f, 1f)
                .uv(168, 120).cuboid(-3f, -2f, -15f, 1f, 2f, 1f)
                .uv(168, 120).cuboid(-3f, -2f, -13f, 1f, 2f, 1f)
                .uv(168, 120).cuboid(-3f, -2f, -11f, 1f, 2f, 1f)
                .uv(168, 120).cuboid(2f, -2f, -19f, 1f, 2f, 1f)
                .uv(168, 120).cuboid(2f, -2f, -17f, 1f, 2f, 1f)
                .uv(168, 120).cuboid(2f, -2f, -15f, 1f, 2f, 1f)
                .uv(168, 120).cuboid(2f, -2f, -13f, 1f, 2f, 1f)
                .uv(168, 120).cuboid(2f, -2f, -11f, 1f, 2f, 1f)
                .uv(74, 120).cuboid(-1f, 3f, -19f, 2f, 2f, 2f),
                ModelTransform.of(0f, 3.5f, -0.5f, 0f, 0f, 0f));
        ModelPartData hornL = head.addChild("horn_l", ModelPartBuilder.create()
                .uv(160, 81).cuboid(-2f, -2f, 0f, 4f, 4f, 8f),
                ModelTransform.of(4.5f, -4.5f, -1f, 0.2f, 0.3f, 0f));
        ModelPartData hornL2 = hornL.addChild("horn_l_2", ModelPartBuilder.create()
                .uv(0, 94).cuboid(-1.5f, -1.5f, 0f, 3f, 3f, 8f),
                ModelTransform.of(0f, 0f, 8f, 0.1f, 0.12f, 0f));
        ModelPartData hornL3 = hornL2.addChild("horn_l_3", ModelPartBuilder.create()
                .uv(186, 94).cuboid(-1f, -1f, 0f, 2f, 2f, 7f),
                ModelTransform.of(0f, 0f, 8f, 0.25f, 0.05f, 0f));
        ModelPartData browL = head.addChild("brow_l", ModelPartBuilder.create()
                .uv(204, 94).cuboid(-1.5f, -1.5f, -6f, 3f, 3f, 6f),
                ModelTransform.of(5f, -5.5f, -6f, 0.25f, -0.35f, 0f));
        ModelPartData hornR = head.addChild("horn_r", ModelPartBuilder.create()
                .uv(160, 81).cuboid(-2f, -2f, 0f, 4f, 4f, 8f),
                ModelTransform.of(-4.5f, -4.5f, -1f, 0.2f, -0.3f, 0f));
        ModelPartData hornR2 = hornR.addChild("horn_r_2", ModelPartBuilder.create()
                .uv(0, 94).cuboid(-1.5f, -1.5f, 0f, 3f, 3f, 8f),
                ModelTransform.of(0f, 0f, 8f, 0.1f, -0.12f, 0f));
        ModelPartData hornR3 = hornR2.addChild("horn_r_3", ModelPartBuilder.create()
                .uv(186, 94).cuboid(-1f, -1f, 0f, 2f, 2f, 7f),
                ModelTransform.of(0f, 0f, 8f, 0.25f, -0.05f, 0f));
        ModelPartData browR = head.addChild("brow_r", ModelPartBuilder.create()
                .uv(204, 94).cuboid(-1.5f, -1.5f, -6f, 3f, 3f, 6f),
                ModelTransform.of(-5f, -5.5f, -6f, 0.25f, 0.35f, 0f));
        ModelPartData tail1 = body.addChild("tail1", ModelPartBuilder.create()
                .uv(104, 27).cuboid(-6f, -6f, 0f, 12f, 12f, 7f)
                .uv(74, 105).cuboid(-1.5f, -10f, 1f, 3f, 4f, 4f),
                ModelTransform.of(0f, -0.5f, 13f, 0f, 0f, 0f));
        ModelPartData tail2 = tail1.addChild("tail2", ModelPartBuilder.create()
                .uv(68, 48).cuboid(-5f, -5f, 0f, 10f, 10f, 7f)
                .uv(74, 105).cuboid(-1.5f, -9f, 1f, 3f, 4f, 4f),
                ModelTransform.of(0f, 0f, 7f, 0f, 0f, 0f));
        ModelPartData tail3 = tail2.addChild("tail3", ModelPartBuilder.create()
                .uv(60, 66).cuboid(-4.5f, -4f, 0f, 9f, 8f, 7f)
                .uv(74, 105).cuboid(-1.5f, -8f, 1f, 3f, 4f, 4f),
                ModelTransform.of(0f, 0f, 7f, 0f, 0f, 0f));
        ModelPartData tail4 = tail3.addChild("tail4", ModelPartBuilder.create()
                .uv(122, 66).cuboid(-4f, -3.5f, 0f, 8f, 7f, 7f)
                .uv(74, 105).cuboid(-1.5f, -7.5f, 1f, 3f, 4f, 4f),
                ModelTransform.of(0f, 0f, 7f, 0f, 0f, 0f));
        ModelPartData tail5 = tail4.addChild("tail5", ModelPartBuilder.create()
                .uv(28, 81).cuboid(-3.5f, -3f, 0f, 7f, 6f, 7f)
                .uv(74, 105).cuboid(-1.5f, -7f, 1f, 3f, 4f, 4f),
                ModelTransform.of(0f, 0f, 7f, 0f, 0f, 0f));
        ModelPartData tail6 = tail5.addChild("tail6", ModelPartBuilder.create()
                .uv(134, 81).cuboid(-3f, -2.5f, 0f, 6f, 5f, 7f)
                .uv(74, 105).cuboid(-1.5f, -6.5f, 1f, 3f, 4f, 4f),
                ModelTransform.of(0f, 0f, 7f, 0f, 0f, 0f));
        ModelPartData tail7 = tail6.addChild("tail7", ModelPartBuilder.create()
                .uv(228, 81).cuboid(-2.5f, -2f, 0f, 5f, 4f, 7f)
                .uv(74, 105).cuboid(-1.5f, -6f, 1f, 3f, 4f, 4f),
                ModelTransform.of(0f, 0f, 7f, 0f, 0f, 0f));
        ModelPartData tail8 = tail7.addChild("tail8", ModelPartBuilder.create()
                .uv(80, 94).cuboid(-2f, -1.5f, 0f, 4f, 3f, 7f)
                .uv(74, 105).cuboid(-1.5f, -5.5f, 1f, 3f, 4f, 4f),
                ModelTransform.of(0f, 0f, 7f, 0f, 0f, 0f));
        ModelPartData tail9 = tail8.addChild("tail9", ModelPartBuilder.create()
                .uv(102, 94).cuboid(-1.5f, -1.5f, 0f, 3f, 3f, 7f),
                ModelTransform.of(0f, 0f, 7f, 0f, 0f, 0f));
        ModelPartData tailTip = tail9.addChild("tail_tip", ModelPartBuilder.create()
                .uv(180, 27).cuboid(-1.5f, -6f, 0f, 3f, 12f, 7f)
                .uv(24, 105).cuboid(-6f, -1.5f, 1f, 12f, 3f, 5f),
                ModelTransform.of(0f, 0f, 7f, 0f, 0f, 0f));
        ModelPartData wingL = body.addChild("wing_l", ModelPartBuilder.create()
                .uv(146, 48).cuboid(0f, -4f, -4f, 8f, 8f, 8f),
                ModelTransform.of(7.5f, -7.5f, -9f, 0f, 0f, 0f));
        ModelPartData armL = wingL.addChild("arm_l", ModelPartBuilder.create()
                .uv(98, 81).cuboid(0f, -3f, -3f, 12f, 6f, 6f)
                .uv(0, 27).cuboid(0f, -0.5f, 4f, 12f, 1f, 20f, new Dilation(0f, -0.25f, 0f)),
                ModelTransform.of(6f, 0f, 0f, 0f, 0f, 0f));
        ModelPartData foreL = armL.addChild("fore_l", ModelPartBuilder.create()
                .uv(38, 94).cuboid(0f, -2.5f, -2.5f, 16f, 5f, 5f)
                .uv(0, 66).cuboid(0f, -0.5f, 3f, 16f, 1f, 14f, new Dilation(0f, -0.25f, 0f))
                .uv(222, 94).cuboid(0f, -2f, -6f, 3f, 3f, 6f),
                ModelTransform.of(12f, 0f, 0f, 0f, 0f, 0f));
        ModelPartData f1L = foreL.addChild("f1_l", ModelPartBuilder.create()
                .uv(172, 105).cuboid(0f, -1.5f, -1.5f, 30f, 3f, 3f)
                .uv(92, 120).cuboid(0f, -0.5f, 1.5f, 10f, 1f, 2f, new Dilation(0f, -0.25f, 0f))
                .uv(100, 105).cuboid(10f, -0.5f, 1.5f, 10f, 1f, 6f, new Dilation(0f, -0.25f, 0f))
                .uv(56, 81).cuboid(20f, -0.5f, 1.5f, 10f, 1f, 11f, new Dilation(0f, -0.25f, 0f)),
                ModelTransform.of(16f, 0f, 0f, 0f, -0.3f, 0f));
        ModelPartData f2L = foreL.addChild("f2_l", ModelPartBuilder.create()
                .uv(0, 114).cuboid(0f, -1.5f, -1.5f, 26f, 3f, 3f)
                .uv(116, 120).cuboid(0f, -0.5f, 1.5f, 8f, 1f, 2f, new Dilation(0f, -0.25f, 0f))
                .uv(140, 114).cuboid(8f, -0.5f, 1.5f, 8f, 1f, 4f, new Dilation(0f, -0.25f, 0f))
                .uv(150, 94).cuboid(16f, -0.5f, 1.5f, 10f, 1f, 8f, new Dilation(0f, -0.25f, 0f)),
                ModelTransform.of(16f, 0f, 0f, 0f, -0.75f, 0f));
        ModelPartData f3L = foreL.addChild("f3_l", ModelPartBuilder.create()
                .uv(176, 114).cuboid(0f, -1f, -1f, 22f, 2f, 2f)
                .uv(136, 120).cuboid(0f, -0.5f, 1f, 7f, 1f, 2f, new Dilation(0f, -0.25f, 0f))
                .uv(36, 120).cuboid(7f, -0.5f, 1f, 7f, 1f, 3f, new Dilation(0f, -0.25f, 0f))
                .uv(132, 105).cuboid(14f, -0.5f, 1f, 8f, 1f, 6f, new Dilation(0f, -0.25f, 0f)),
                ModelTransform.of(16f, 0f, 0f, 0f, -1.15f, 0f));
        ModelPartData f4L = foreL.addChild("f4_l", ModelPartBuilder.create()
                .uv(0, 120).cuboid(0f, -1f, -1f, 16f, 2f, 2f)
                .uv(154, 120).cuboid(0f, -0.5f, 1f, 5f, 1f, 2f, new Dilation(0f, -0.25f, 0f))
                .uv(154, 120).cuboid(5f, -0.5f, 1f, 5f, 1f, 2f, new Dilation(0f, -0.25f, 0f))
                .uv(56, 120).cuboid(10f, -0.5f, 1f, 6f, 1f, 3f, new Dilation(0f, -0.25f, 0f)),
                ModelTransform.of(16f, 0f, 0f, 0f, -1.5f, 0f));
        ModelPartData wingR = body.addChild("wing_r", ModelPartBuilder.create()
                .uv(146, 48).cuboid(-8f, -4f, -4f, 8f, 8f, 8f),
                ModelTransform.of(-7.5f, -7.5f, -9f, 0f, 0f, 0f));
        ModelPartData armR = wingR.addChild("arm_r", ModelPartBuilder.create()
                .uv(98, 81).cuboid(-12f, -3f, -3f, 12f, 6f, 6f)
                .uv(0, 27).cuboid(-12f, -0.5f, 4f, 12f, 1f, 20f, new Dilation(0f, -0.25f, 0f)),
                ModelTransform.of(-6f, 0f, 0f, 0f, 0f, 0f));
        ModelPartData foreR = armR.addChild("fore_r", ModelPartBuilder.create()
                .uv(38, 94).cuboid(-16f, -2.5f, -2.5f, 16f, 5f, 5f)
                .uv(0, 66).cuboid(-16f, -0.5f, 3f, 16f, 1f, 14f, new Dilation(0f, -0.25f, 0f))
                .uv(222, 94).cuboid(-3f, -2f, -6f, 3f, 3f, 6f),
                ModelTransform.of(-12f, 0f, 0f, 0f, 0f, 0f));
        ModelPartData f1R = foreR.addChild("f1_r", ModelPartBuilder.create()
                .uv(172, 105).cuboid(-30f, -1.5f, -1.5f, 30f, 3f, 3f)
                .uv(92, 120).cuboid(-10f, -0.5f, 1.5f, 10f, 1f, 2f, new Dilation(0f, -0.25f, 0f))
                .uv(100, 105).cuboid(-20f, -0.5f, 1.5f, 10f, 1f, 6f, new Dilation(0f, -0.25f, 0f))
                .uv(56, 81).cuboid(-30f, -0.5f, 1.5f, 10f, 1f, 11f, new Dilation(0f, -0.25f, 0f)),
                ModelTransform.of(-16f, 0f, 0f, 0f, 0.3f, 0f));
        ModelPartData f2R = foreR.addChild("f2_r", ModelPartBuilder.create()
                .uv(0, 114).cuboid(-26f, -1.5f, -1.5f, 26f, 3f, 3f)
                .uv(116, 120).cuboid(-8f, -0.5f, 1.5f, 8f, 1f, 2f, new Dilation(0f, -0.25f, 0f))
                .uv(140, 114).cuboid(-16f, -0.5f, 1.5f, 8f, 1f, 4f, new Dilation(0f, -0.25f, 0f))
                .uv(150, 94).cuboid(-26f, -0.5f, 1.5f, 10f, 1f, 8f, new Dilation(0f, -0.25f, 0f)),
                ModelTransform.of(-16f, 0f, 0f, 0f, 0.75f, 0f));
        ModelPartData f3R = foreR.addChild("f3_r", ModelPartBuilder.create()
                .uv(176, 114).cuboid(-22f, -1f, -1f, 22f, 2f, 2f)
                .uv(136, 120).cuboid(-7f, -0.5f, 1f, 7f, 1f, 2f, new Dilation(0f, -0.25f, 0f))
                .uv(36, 120).cuboid(-14f, -0.5f, 1f, 7f, 1f, 3f, new Dilation(0f, -0.25f, 0f))
                .uv(132, 105).cuboid(-22f, -0.5f, 1f, 8f, 1f, 6f, new Dilation(0f, -0.25f, 0f)),
                ModelTransform.of(-16f, 0f, 0f, 0f, 1.15f, 0f));
        ModelPartData f4R = foreR.addChild("f4_r", ModelPartBuilder.create()
                .uv(0, 120).cuboid(-16f, -1f, -1f, 16f, 2f, 2f)
                .uv(154, 120).cuboid(-5f, -0.5f, 1f, 5f, 1f, 2f, new Dilation(0f, -0.25f, 0f))
                .uv(154, 120).cuboid(-10f, -0.5f, 1f, 5f, 1f, 2f, new Dilation(0f, -0.25f, 0f))
                .uv(56, 120).cuboid(-16f, -0.5f, 1f, 6f, 1f, 3f, new Dilation(0f, -0.25f, 0f)),
                ModelTransform.of(-16f, 0f, 0f, 0f, 1.5f, 0f));
        ModelPartData legFl = body.addChild("leg_fl", ModelPartBuilder.create()
                .uv(178, 48).cuboid(-3.5f, -2.5f, -3.5f, 7f, 9f, 7f)
                .uv(142, 27).cuboid(-4.5f, -4.5f, -5f, 9f, 9f, 10f),
                ModelTransform.of(7.5f, 7.1033f, -11f, 0.4f, 0f, 0f));
        ModelPartData shinFl = legFl.addChild("shin_fl", ModelPartBuilder.create()
                .uv(184, 81).cuboid(-2.5f, -1f, -2.5f, 5f, 7f, 5f),
                ModelTransform.of(0f, 6f, 0f, -0.85f, 0f, 0f));
        ModelPartData metaFl = shinFl.addChild("meta_fl", ModelPartBuilder.create()
                .uv(240, 94).cuboid(-2f, -0.5f, -2f, 4f, 5f, 4f),
                ModelTransform.of(0f, 6f, 0f, 0.55f, 0f, 0f));
        ModelPartData footFl = metaFl.addChild("foot_fl", ModelPartBuilder.create()
                .uv(200, 66).cuboid(-3.5f, -1f, -9f, 7f, 2f, 11f)
                .uv(164, 114).cuboid(-3.5f, -0.5f, -13f, 2f, 1f, 4f)
                .uv(164, 114).cuboid(-1f, -0.5f, -13f, 2f, 1f, 4f)
                .uv(164, 114).cuboid(1.5f, -0.5f, -13f, 2f, 1f, 4f),
                ModelTransform.of(0f, 4f, 0f, -0.1f, 0f, 0f));
        ModelPartData legFr = body.addChild("leg_fr", ModelPartBuilder.create()
                .uv(178, 48).cuboid(-3.5f, -2.5f, -3.5f, 7f, 9f, 7f)
                .uv(142, 27).cuboid(-4.5f, -4.5f, -5f, 9f, 9f, 10f),
                ModelTransform.of(-7.5f, 7.1033f, -11f, 0.4f, 0f, 0f));
        ModelPartData shinFr = legFr.addChild("shin_fr", ModelPartBuilder.create()
                .uv(184, 81).cuboid(-2.5f, -1f, -2.5f, 5f, 7f, 5f),
                ModelTransform.of(0f, 6f, 0f, -0.85f, 0f, 0f));
        ModelPartData metaFr = shinFr.addChild("meta_fr", ModelPartBuilder.create()
                .uv(240, 94).cuboid(-2f, -0.5f, -2f, 4f, 5f, 4f),
                ModelTransform.of(0f, 6f, 0f, 0.55f, 0f, 0f));
        ModelPartData footFr = metaFr.addChild("foot_fr", ModelPartBuilder.create()
                .uv(200, 66).cuboid(-3.5f, -1f, -9f, 7f, 2f, 11f)
                .uv(164, 114).cuboid(-3.5f, -0.5f, -13f, 2f, 1f, 4f)
                .uv(164, 114).cuboid(-1f, -0.5f, -13f, 2f, 1f, 4f)
                .uv(164, 114).cuboid(1.5f, -0.5f, -13f, 2f, 1f, 4f),
                ModelTransform.of(0f, 4f, 0f, -0.1f, 0f, 0f));
        ModelPartData legBl = body.addChild("leg_bl", ModelPartBuilder.create()
                .uv(36, 48).cuboid(-4f, -2.5f, -4f, 8f, 10f, 8f)
                .uv(64, 27).cuboid(-5f, -5f, -5f, 10f, 10f, 10f),
                ModelTransform.of(7f, 5.5f, 9f, -0.65f, 0f, 0f));
        ModelPartData shinBl = legBl.addChild("shin_bl", ModelPartBuilder.create()
                .uv(180, 66).cuboid(-2.5f, -1f, -2.5f, 5f, 9f, 5f),
                ModelTransform.of(0f, 6.5f, 0f, 1.2f, 0f, 0f));
        ModelPartData metaBl = shinBl.addChild("meta_bl", ModelPartBuilder.create()
                .uv(122, 94).cuboid(-2f, -0.5f, -2f, 4f, 6f, 4f),
                ModelTransform.of(0f, 7.5f, 0f, -0.7f, 0f, 0f));
        ModelPartData footBl = metaBl.addChild("foot_bl", ModelPartBuilder.create()
                .uv(200, 66).cuboid(-3.5f, -1f, -9f, 7f, 2f, 11f)
                .uv(164, 114).cuboid(-3.5f, -0.5f, -13f, 2f, 1f, 4f)
                .uv(164, 114).cuboid(-1f, -0.5f, -13f, 2f, 1f, 4f)
                .uv(164, 114).cuboid(1.5f, -0.5f, -13f, 2f, 1f, 4f),
                ModelTransform.of(0f, 5f, 0f, 0.15f, 0f, 0f));
        ModelPartData legBr = body.addChild("leg_br", ModelPartBuilder.create()
                .uv(36, 48).cuboid(-4f, -2.5f, -4f, 8f, 10f, 8f)
                .uv(64, 27).cuboid(-5f, -5f, -5f, 10f, 10f, 10f),
                ModelTransform.of(-7f, 5.5f, 9f, -0.65f, 0f, 0f));
        ModelPartData shinBr = legBr.addChild("shin_br", ModelPartBuilder.create()
                .uv(180, 66).cuboid(-2.5f, -1f, -2.5f, 5f, 9f, 5f),
                ModelTransform.of(0f, 6.5f, 0f, 1.2f, 0f, 0f));
        ModelPartData metaBr = shinBr.addChild("meta_br", ModelPartBuilder.create()
                .uv(122, 94).cuboid(-2f, -0.5f, -2f, 4f, 6f, 4f),
                ModelTransform.of(0f, 7.5f, 0f, -0.7f, 0f, 0f));
        ModelPartData footBr = metaBr.addChild("foot_br", ModelPartBuilder.create()
                .uv(200, 66).cuboid(-3.5f, -1f, -9f, 7f, 2f, 11f)
                .uv(164, 114).cuboid(-3.5f, -0.5f, -13f, 2f, 1f, 4f)
                .uv(164, 114).cuboid(-1f, -0.5f, -13f, 2f, 1f, 4f)
                .uv(164, 114).cuboid(1.5f, -0.5f, -13f, 2f, 1f, 4f),
                ModelTransform.of(0f, 5f, 0f, 0.15f, 0f, 0f));
        ModelPartData crystal0 = body.addChild("crystal_0", ModelPartBuilder.create()
                .uv(22, 94).cuboid(-2f, -7f, -2f, 4f, 7f, 4f)
                .uv(96, 114).cuboid(-1.5f, -10f, -1.5f, 3f, 3f, 3f),
                ModelTransform.of(0f, -8f, -12f, 0f, 0f, 0f));
        ModelPartData crystal1 = body.addChild("crystal_1", ModelPartBuilder.create()
                .uv(22, 94).cuboid(-2f, -7f, -2f, 4f, 7f, 4f)
                .uv(12, 105).cuboid(-1.5f, -13f, -1.5f, 3f, 6f, 3f),
                ModelTransform.of(0f, -8f, -6f, 0f, 0f, 0f));
        ModelPartData crystal2 = body.addChild("crystal_2", ModelPartBuilder.create()
                .uv(22, 94).cuboid(-2f, -7f, -2f, 4f, 7f, 4f)
                .uv(96, 114).cuboid(-1.5f, -10f, -1.5f, 3f, 3f, 3f),
                ModelTransform.of(0f, -8f, 0f, 0f, 0f, 0f));
        ModelPartData crystal3 = body.addChild("crystal_3", ModelPartBuilder.create()
                .uv(22, 94).cuboid(-2f, -7f, -2f, 4f, 7f, 4f)
                .uv(12, 105).cuboid(-1.5f, -13f, -1.5f, 3f, 6f, 3f),
                ModelTransform.of(0f, -8f, 6f, 0f, 0f, 0f));
        ModelPartData crystal4 = body.addChild("crystal_4", ModelPartBuilder.create()
                .uv(22, 94).cuboid(-2f, -7f, -2f, 4f, 7f, 4f)
                .uv(96, 114).cuboid(-1.5f, -10f, -1.5f, 3f, 3f, 3f),
                ModelTransform.of(0f, -8f, 11f, 0f, 0f, 0f));
        ModelPartData crownL = head.addChild("crown_l", ModelPartBuilder.create()
                .uv(138, 94).cuboid(-1.5f, -7f, -1.5f, 3f, 7f, 3f),
                ModelTransform.of(3.5f, -5f, -3f, -0.3f, 0f, 0.3f));
        ModelPartData crownR = head.addChild("crown_r", ModelPartBuilder.create()
                .uv(138, 94).cuboid(-1.5f, -7f, -1.5f, 3f, 7f, 3f),
                ModelTransform.of(-3.5f, -5f, -3f, -0.3f, 0f, -0.3f));
        ModelPartData tailCrystal = tailTip.addChild("tail_crystal", ModelPartBuilder.create()
                .uv(102, 48).cuboid(-1.5f, -7f, 0f, 3f, 14f, 3f)
                .uv(58, 114).cuboid(-5f, -1.5f, 0f, 10f, 3f, 3f),
                ModelTransform.of(0f, 0f, 7f, 0f, 0f, 0f));
        return TexturedModelData.of(data, 256, 256);
    }

    private static float sin(float v) { return (float) Math.sin(v); }
    private static float cos(float v) { return (float) Math.cos(v); }

    private static final float HA1 = -0.65f, HR2 = 1.2f, HR3 = -0.7f, HF = 0.15f;
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
        this.body.pitch = breathe * 0.01f;

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
        float fh = fly ? 0.6f : 0f;
        leg(legFr, shinFr, metaFr, footFr, FA1, FR2, FR3, FF, swA * 0.5f + fh, liftA * 0.6f + fh, -liftA * 0.3f);
        leg(legFl, shinFl, metaFl, footFl, FA1, FR2, FR3, FF, swB * 0.5f + fh, liftB * 0.6f + fh, -liftB * 0.3f);

        float fold = fly ? 0f : 0.9f;
        float flap = fly ? sin(t * 0.3f) : sin(t * 0.1f) * 0.04f;
        this.wingL.yaw = -0.8f * fold + (fly ? -0.1f : 0f);
        this.wingR.yaw = -this.wingL.yaw;
        this.wingL.roll = 0.3f * fold - flap * (fly ? 0.75f : 1f);
        this.wingR.roll = -this.wingL.roll;
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
