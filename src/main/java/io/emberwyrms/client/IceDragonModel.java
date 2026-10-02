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
    private final ModelPart head;
    private final ModelPart jaw;
    private final ModelPart hornL;
    private final ModelPart hornLTip;
    private final ModelPart hornR;
    private final ModelPart hornRTip;
    private final ModelPart frillL;
    private final ModelPart frillR;
    private final ModelPart tail1;
    private final ModelPart tail2;
    private final ModelPart tail3;
    private final ModelPart tail4;
    private final ModelPart tailTip;
    private final ModelPart wingL;
    private final ModelPart armL;
    private final ModelPart foreL;
    private final ModelPart f1L;
    private final ModelPart f2L;
    private final ModelPart f3L;
    private final ModelPart wingR;
    private final ModelPart armR;
    private final ModelPart foreR;
    private final ModelPart f1R;
    private final ModelPart f2R;
    private final ModelPart f3R;
    private final ModelPart legFl;
    private final ModelPart shinFl;
    private final ModelPart footFl;
    private final ModelPart legFr;
    private final ModelPart shinFr;
    private final ModelPart footFr;
    private final ModelPart legBl;
    private final ModelPart shinBl;
    private final ModelPart footBl;
    private final ModelPart legBr;
    private final ModelPart shinBr;
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
        this.head = neck2.getChild("head");
        this.jaw = head.getChild("jaw");
        this.hornL = head.getChild("horn_l");
        this.hornLTip = hornL.getChild("horn_l_tip");
        this.hornR = head.getChild("horn_r");
        this.hornRTip = hornR.getChild("horn_r_tip");
        this.frillL = neck2.getChild("frill_l");
        this.frillR = neck2.getChild("frill_r");
        this.tail1 = body.getChild("tail1");
        this.tail2 = tail1.getChild("tail2");
        this.tail3 = tail2.getChild("tail3");
        this.tail4 = tail3.getChild("tail4");
        this.tailTip = tail4.getChild("tail_tip");
        this.wingL = body.getChild("wing_l");
        this.armL = wingL.getChild("arm_l");
        this.foreL = armL.getChild("fore_l");
        this.f1L = foreL.getChild("f1_l");
        this.f2L = foreL.getChild("f2_l");
        this.f3L = foreL.getChild("f3_l");
        this.wingR = body.getChild("wing_r");
        this.armR = wingR.getChild("arm_r");
        this.foreR = armR.getChild("fore_r");
        this.f1R = foreR.getChild("f1_r");
        this.f2R = foreR.getChild("f2_r");
        this.f3R = foreR.getChild("f3_r");
        this.legFl = body.getChild("leg_fl");
        this.shinFl = legFl.getChild("shin_fl");
        this.footFl = shinFl.getChild("foot_fl");
        this.legFr = body.getChild("leg_fr");
        this.shinFr = legFr.getChild("shin_fr");
        this.footFr = shinFr.getChild("foot_fr");
        this.legBl = body.getChild("leg_bl");
        this.shinBl = legBl.getChild("shin_bl");
        this.footBl = shinBl.getChild("foot_bl");
        this.legBr = body.getChild("leg_br");
        this.shinBr = legBr.getChild("shin_br");
        this.footBr = shinBr.getChild("foot_br");
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
                .uv(0, 0).cuboid(-6f, -5f, -11f, 12f, 11f, 22f)
                .uv(44, 47).cuboid(-5.5f, -4f, -14f, 11f, 10f, 3f)
                .uv(30, 73).cuboid(-5f, -7f, -9f, 10f, 2f, 8f)
                .uv(30, 98).cuboid(-0.5f, -8f, -9f, 1f, 3f, 2f)
                .uv(30, 98).cuboid(-0.5f, -8f, -5f, 1f, 3f, 2f)
                .uv(30, 98).cuboid(-0.5f, -8f, -1f, 1f, 3f, 2f)
                .uv(30, 98).cuboid(-0.5f, -8f, 3f, 1f, 3f, 2f)
                .uv(30, 98).cuboid(-0.5f, -8f, 7f, 1f, 3f, 2f),
                ModelTransform.of(0f, -14f, 0f, 0f, 0f, 0f));
        ModelPartData neck1 = body.addChild("neck1", ModelPartBuilder.create()
                .uv(30, 33).cuboid(-3f, -3f, -7f, 6f, 6f, 8f)
                .uv(88, 98).cuboid(-0.5f, -5f, -6f, 1f, 2f, 2f)
                .uv(88, 98).cuboid(-0.5f, -5f, -2f, 1f, 2f, 2f),
                ModelTransform.of(0f, -2f, -13f, -0.55f, 0f, 0f));
        ModelPartData neck2 = neck1.addChild("neck2", ModelPartBuilder.create()
                .uv(72, 47).cuboid(-2.5f, -2.5f, -7f, 5f, 5f, 8f)
                .uv(88, 98).cuboid(-0.5f, -4.5f, -5f, 1f, 2f, 2f),
                ModelTransform.of(0f, 0f, -7f, 0.25f, 0f, 0f));
        ModelPartData head = neck2.addChild("head", ModelPartBuilder.create()
                .uv(0, 33).cuboid(-3.5f, -3f, -8f, 7f, 6f, 8f)
                .uv(102, 91).cuboid(-4f, -4f, -6f, 8f, 1f, 4f)
                .uv(66, 73).cuboid(-2.5f, -1.5f, -14f, 5f, 3f, 6f)
                .uv(82, 103).cuboid(-2f, -1.7f, -14.3f, 1f, 1f, 1f)
                .uv(82, 103).cuboid(1f, -1.7f, -14.3f, 1f, 1f, 1f)
                .uv(94, 98).cuboid(-2f, 1.5f, -13f, 1f, 1f, 2f)
                .uv(94, 98).cuboid(1f, 1.5f, -13f, 1f, 1f, 2f)
                .uv(86, 103).cuboid(-2f, 1.5f, -9f, 1f, 1f, 1f)
                .uv(86, 103).cuboid(1f, 1.5f, -9f, 1f, 1f, 1f)
                .uv(100, 98).cuboid(3.3f, -2f, -6f, 1f, 1f, 2f)
                .uv(100, 98).cuboid(-4.3f, -2f, -6f, 1f, 1f, 2f)
                .uv(22, 98).cuboid(3.5f, -1f, -3f, 1f, 2f, 3f)
                .uv(22, 98).cuboid(-4.5f, -1f, -3f, 1f, 2f, 3f)
                .uv(92, 91).cuboid(-0.5f, -5f, -6f, 1f, 2f, 4f)
                .uv(22, 98).cuboid(-0.5f, -5f, -1f, 1f, 2f, 3f),
                ModelTransform.of(0f, 0f, -7f, 0.4f, 0f, 0f));
        ModelPartData jaw = head.addChild("jaw", ModelPartBuilder.create()
                .uv(14, 60).cuboid(-2.5f, 0f, -12f, 5f, 1f, 11f)
                .uv(112, 98).cuboid(-0.5f, 1f, -12f, 1f, 2f, 1f)
                .uv(94, 98).cuboid(-2f, -1f, -12f, 1f, 1f, 2f)
                .uv(94, 98).cuboid(1f, -1f, -12f, 1f, 1f, 2f),
                ModelTransform.of(0f, 1.5f, -1f, 0f, 0f, 0f));
        ModelPartData hornL = head.addChild("horn_l", ModelPartBuilder.create()
                .uv(96, 73).cuboid(-1f, -1f, 0f, 2f, 2f, 6f),
                ModelTransform.of(3f, -3f, -1f, 0.7f, 0.3f, 0f));
        ModelPartData hornLTip = hornL.addChild("horn_l_tip", ModelPartBuilder.create()
                .uv(80, 91).cuboid(-0.5f, -0.5f, 0f, 1f, 1f, 5f),
                ModelTransform.of(0f, 0f, 6f, 0.35f, 0.15f, 0f));
        ModelPartData hornR = head.addChild("horn_r", ModelPartBuilder.create()
                .uv(96, 73).cuboid(-1f, -1f, 0f, 2f, 2f, 6f),
                ModelTransform.of(-3f, -3f, -1f, 0.7f, -0.3f, 0f));
        ModelPartData hornRTip = hornR.addChild("horn_r_tip", ModelPartBuilder.create()
                .uv(80, 91).cuboid(-0.5f, -0.5f, 0f, 1f, 1f, 5f),
                ModelTransform.of(0f, 0f, 6f, 0.35f, -0.15f, 0f));
        ModelPartData frillL = neck2.addChild("frill_l", ModelPartBuilder.create()
                .uv(38, 91).cuboid(0f, -3f, 0f, 5f, 6f, 1f, new Dilation(0f, 0f, -0.25f)),
                ModelTransform.of(2.5f, 0f, -3f, 0f, -0.5f, 0f));
        ModelPartData frillR = neck2.addChild("frill_r", ModelPartBuilder.create()
                .uv(38, 91).cuboid(-5f, -3f, 0f, 5f, 6f, 1f, new Dilation(0f, 0f, -0.25f)),
                ModelTransform.of(-2.5f, 0f, -3f, 0f, 0.5f, 0f));
        ModelPartData tail1 = body.addChild("tail1", ModelPartBuilder.create()
                .uv(68, 0).cuboid(-3f, -3f, 0f, 6f, 6f, 9f)
                .uv(22, 98).cuboid(-0.5f, -5f, 2f, 1f, 2f, 3f),
                ModelTransform.of(0f, -1f, 10f, 0f, 0f, 0f));
        ModelPartData tail2 = tail1.addChild("tail2", ModelPartBuilder.create()
                .uv(58, 33).cuboid(-2.5f, -2.5f, 0f, 5f, 5f, 9f)
                .uv(22, 98).cuboid(-0.5f, -4.5f, 2f, 1f, 2f, 3f),
                ModelTransform.of(0f, 0f, 9f, 0f, 0f, 0f));
        ModelPartData tail3 = tail2.addChild("tail3", ModelPartBuilder.create()
                .uv(98, 47).cuboid(-2f, -2f, 0f, 4f, 4f, 9f)
                .uv(22, 98).cuboid(-0.5f, -3.5f, 2f, 1f, 2f, 3f),
                ModelTransform.of(0f, 0f, 9f, 0f, 0f, 0f));
        ModelPartData tail4 = tail3.addChild("tail4", ModelPartBuilder.create()
                .uv(0, 73).cuboid(-1.5f, -1.5f, 0f, 3f, 3f, 8f),
                ModelTransform.of(0f, 0f, 9f, 0f, 0f, 0f));
        ModelPartData tailTip = tail4.addChild("tail_tip", ModelPartBuilder.create()
                .uv(0, 60).cuboid(-0.5f, -3.5f, 0f, 1f, 7f, 6f)
                .uv(0, 98).cuboid(-3.5f, -0.5f, 1f, 7f, 1f, 4f),
                ModelTransform.of(0f, 0f, 8f, 0f, 0f, 0f));
        ModelPartData wingL = body.addChild("wing_l", ModelPartBuilder.create()
                .uv(112, 73).cuboid(0f, -2f, -2f, 4f, 4f, 4f),
                ModelTransform.of(5f, -4f, -5f, 0f, 0f, 0f));
        ModelPartData armL = wingL.addChild("arm_l", ModelPartBuilder.create()
                .uv(54, 91).cuboid(0f, -1.5f, -1.5f, 10f, 3f, 3f)
                .uv(0, 47).cuboid(0f, -0.5f, 1.5f, 10f, 1f, 12f, new Dilation(0f, -0.25f, 0f))
                .uv(80, 98).cuboid(0f, -1f, -4f, 1f, 1f, 3f),
                ModelTransform.of(4f, 0f, 0f, 0f, 0f, 0f));
        ModelPartData foreL = armL.addChild("fore_l", ModelPartBuilder.create()
                .uv(36, 98).cuboid(0f, -1f, -1f, 10f, 2f, 2f),
                ModelTransform.of(10f, 0f, 0f, 0f, 0f, 0f));
        ModelPartData f1L = foreL.addChild("f1_l", ModelPartBuilder.create()
                .uv(0, 103).cuboid(0f, -0.5f, -0.5f, 15f, 1f, 1f)
                .uv(0, 84).cuboid(0f, -0.5f, 0.5f, 15f, 1f, 6f, new Dilation(0f, -0.25f, 0f)),
                ModelTransform.of(10f, 0f, 0f, 0f, -0.45f, 0f));
        ModelPartData f2L = foreL.addChild("f2_l", ModelPartBuilder.create()
                .uv(32, 103).cuboid(0f, -0.5f, -0.5f, 13f, 1f, 1f)
                .uv(42, 84).cuboid(0f, -0.5f, 0.5f, 13f, 1f, 6f, new Dilation(0f, -0.25f, 0f)),
                ModelTransform.of(10f, 0f, 0f, 0f, -0.95f, 0f));
        ModelPartData f3L = foreL.addChild("f3_l", ModelPartBuilder.create()
                .uv(60, 103).cuboid(0f, -0.5f, -0.5f, 10f, 1f, 1f)
                .uv(80, 84).cuboid(0f, -0.5f, 0.5f, 10f, 1f, 6f, new Dilation(0f, -0.25f, 0f)),
                ModelTransform.of(10f, 0f, 0f, 0f, -1.45f, 0f));
        ModelPartData wingR = body.addChild("wing_r", ModelPartBuilder.create()
                .uv(112, 73).cuboid(-4f, -2f, -2f, 4f, 4f, 4f),
                ModelTransform.of(-5f, -4f, -5f, 0f, 0f, 0f));
        ModelPartData armR = wingR.addChild("arm_r", ModelPartBuilder.create()
                .uv(54, 91).cuboid(-10f, -1.5f, -1.5f, 10f, 3f, 3f)
                .uv(0, 47).cuboid(-10f, -0.5f, 1.5f, 10f, 1f, 12f, new Dilation(0f, -0.25f, 0f))
                .uv(80, 98).cuboid(-2f, -1f, -4f, 1f, 1f, 3f),
                ModelTransform.of(-4f, 0f, 0f, 0f, 0f, 0f));
        ModelPartData foreR = armR.addChild("fore_r", ModelPartBuilder.create()
                .uv(36, 98).cuboid(-10f, -1f, -1f, 10f, 2f, 2f),
                ModelTransform.of(-10f, 0f, 0f, 0f, 0f, 0f));
        ModelPartData f1R = foreR.addChild("f1_r", ModelPartBuilder.create()
                .uv(0, 103).cuboid(-15f, -0.5f, -0.5f, 15f, 1f, 1f)
                .uv(0, 84).cuboid(-15f, -0.5f, 0.5f, 15f, 1f, 6f, new Dilation(0f, -0.25f, 0f)),
                ModelTransform.of(-10f, 0f, 0f, 0f, 0.45f, 0f));
        ModelPartData f2R = foreR.addChild("f2_r", ModelPartBuilder.create()
                .uv(32, 103).cuboid(-13f, -0.5f, -0.5f, 13f, 1f, 1f)
                .uv(42, 84).cuboid(-13f, -0.5f, 0.5f, 13f, 1f, 6f, new Dilation(0f, -0.25f, 0f)),
                ModelTransform.of(-10f, 0f, 0f, 0f, 0.95f, 0f));
        ModelPartData f3R = foreR.addChild("f3_r", ModelPartBuilder.create()
                .uv(60, 103).cuboid(-10f, -0.5f, -0.5f, 10f, 1f, 1f)
                .uv(80, 84).cuboid(-10f, -0.5f, 0.5f, 10f, 1f, 6f, new Dilation(0f, -0.25f, 0f)),
                ModelTransform.of(-10f, 0f, 0f, 0f, 1.45f, 0f));
        ModelPartData legFl = body.addChild("leg_fl", ModelPartBuilder.create()
                .uv(46, 60).cuboid(-2.5f, -1f, -3f, 5f, 6f, 6f)
                .uv(76, 60).cuboid(-3f, -2f, -3.5f, 6f, 4f, 7f),
                ModelTransform.of(5.5f, 4f, -8f, 0f, 0f, 0f));
        ModelPartData shinFl = legFl.addChild("shin_fl", ModelPartBuilder.create()
                .uv(112, 73).cuboid(-2f, 0f, -2f, 4f, 4f, 4f),
                ModelTransform.of(0f, 5f, 0f, 0f, 0f, 0f));
        ModelPartData footFl = shinFl.addChild("foot_fl", ModelPartBuilder.create()
                .uv(0, 91).cuboid(-2.5f, 0f, -4f, 5f, 1f, 6f)
                .uv(106, 98).cuboid(-2f, 0f, -6f, 1f, 1f, 2f)
                .uv(106, 98).cuboid(-0.5f, 0f, -6f, 1f, 1f, 2f)
                .uv(106, 98).cuboid(1f, 0f, -6f, 1f, 1f, 2f),
                ModelTransform.of(0f, 4f, 0f, 0f, 0f, 0f));
        ModelPartData legFr = body.addChild("leg_fr", ModelPartBuilder.create()
                .uv(46, 60).cuboid(-2.5f, -1f, -3f, 5f, 6f, 6f)
                .uv(76, 60).cuboid(-3f, -2f, -3.5f, 6f, 4f, 7f),
                ModelTransform.of(-5.5f, 4f, -8f, 0f, 0f, 0f));
        ModelPartData shinFr = legFr.addChild("shin_fr", ModelPartBuilder.create()
                .uv(112, 73).cuboid(-2f, 0f, -2f, 4f, 4f, 4f),
                ModelTransform.of(0f, 5f, 0f, 0f, 0f, 0f));
        ModelPartData footFr = shinFr.addChild("foot_fr", ModelPartBuilder.create()
                .uv(0, 91).cuboid(-2.5f, 0f, -4f, 5f, 1f, 6f)
                .uv(106, 98).cuboid(-2f, 0f, -6f, 1f, 1f, 2f)
                .uv(106, 98).cuboid(-0.5f, 0f, -6f, 1f, 1f, 2f)
                .uv(106, 98).cuboid(1f, 0f, -6f, 1f, 1f, 2f),
                ModelTransform.of(0f, 4f, 0f, 0f, 0f, 0f));
        ModelPartData legBl = body.addChild("leg_bl", ModelPartBuilder.create()
                .uv(98, 0).cuboid(-3f, -2f, -3.5f, 6f, 8f, 7f)
                .uv(102, 60).cuboid(-3.5f, -3f, -3f, 7f, 5f, 6f),
                ModelTransform.of(6f, 4f, 7f, 0f, 0f, 0f));
        ModelPartData shinBl = legBl.addChild("shin_bl", ModelPartBuilder.create()
                .uv(22, 91).cuboid(-2f, 0f, -2f, 4f, 3f, 4f),
                ModelTransform.of(0f, 6f, 0f, 0f, 0f, 0f));
        ModelPartData footBl = shinBl.addChild("foot_bl", ModelPartBuilder.create()
                .uv(0, 91).cuboid(-2.5f, 0f, -4f, 5f, 1f, 6f)
                .uv(106, 98).cuboid(-2f, 0f, -6f, 1f, 1f, 2f)
                .uv(106, 98).cuboid(-0.5f, 0f, -6f, 1f, 1f, 2f)
                .uv(106, 98).cuboid(1f, 0f, -6f, 1f, 1f, 2f),
                ModelTransform.of(0f, 3f, 0f, 0f, 0f, 0f));
        ModelPartData legBr = body.addChild("leg_br", ModelPartBuilder.create()
                .uv(98, 0).cuboid(-3f, -2f, -3.5f, 6f, 8f, 7f)
                .uv(102, 60).cuboid(-3.5f, -3f, -3f, 7f, 5f, 6f),
                ModelTransform.of(-6f, 4f, 7f, 0f, 0f, 0f));
        ModelPartData shinBr = legBr.addChild("shin_br", ModelPartBuilder.create()
                .uv(22, 91).cuboid(-2f, 0f, -2f, 4f, 3f, 4f),
                ModelTransform.of(0f, 6f, 0f, 0f, 0f, 0f));
        ModelPartData footBr = shinBr.addChild("foot_br", ModelPartBuilder.create()
                .uv(0, 91).cuboid(-2.5f, 0f, -4f, 5f, 1f, 6f)
                .uv(106, 98).cuboid(-2f, 0f, -6f, 1f, 1f, 2f)
                .uv(106, 98).cuboid(-0.5f, 0f, -6f, 1f, 1f, 2f)
                .uv(106, 98).cuboid(1f, 0f, -6f, 1f, 1f, 2f),
                ModelTransform.of(0f, 3f, 0f, 0f, 0f, 0f));
        ModelPartData crystal0 = body.addChild("crystal_0", ModelPartBuilder.create()
                .uv(88, 73).cuboid(-1f, -7f, -1f, 2f, 7f, 2f),
                ModelTransform.of(0f, -7f, -8f, 0f, 0f, 0f));
        ModelPartData crystal1 = body.addChild("crystal_1", ModelPartBuilder.create()
                .uv(22, 73).cuboid(-1f, -9f, -1f, 2f, 9f, 2f),
                ModelTransform.of(0f, -7f, -4f, 0f, 0f, 0f));
        ModelPartData crystal2 = body.addChild("crystal_2", ModelPartBuilder.create()
                .uv(88, 73).cuboid(-1f, -7f, -1f, 2f, 7f, 2f),
                ModelTransform.of(0f, -7f, 0f, 0f, 0f, 0f));
        ModelPartData crystal3 = body.addChild("crystal_3", ModelPartBuilder.create()
                .uv(22, 73).cuboid(-1f, -9f, -1f, 2f, 9f, 2f),
                ModelTransform.of(0f, -7f, 4f, 0f, 0f, 0f));
        ModelPartData crystal4 = body.addChild("crystal_4", ModelPartBuilder.create()
                .uv(88, 73).cuboid(-1f, -7f, -1f, 2f, 7f, 2f),
                ModelTransform.of(0f, -7f, 8f, 0f, 0f, 0f));
        ModelPartData crownL = head.addChild("crown_l", ModelPartBuilder.create()
                .uv(50, 91).cuboid(-0.5f, -6f, -0.5f, 1f, 6f, 1f),
                ModelTransform.of(2f, -3f, -2f, -0.3f, 0f, 0.3f));
        ModelPartData crownR = head.addChild("crown_r", ModelPartBuilder.create()
                .uv(50, 91).cuboid(-0.5f, -6f, -0.5f, 1f, 6f, 1f),
                ModelTransform.of(-2f, -3f, -2f, -0.3f, 0f, -0.3f));
        ModelPartData tailCrystal = tailTip.addChild("tail_crystal", ModelPartBuilder.create()
                .uv(68, 60).cuboid(-1f, -5f, 0f, 2f, 10f, 2f)
                .uv(60, 98).cuboid(-4f, -1f, 0f, 8f, 2f, 2f),
                ModelTransform.of(0f, 0f, 6f, 0f, 0f, 0f));
        return TexturedModelData.of(data, 128, 128);
    }

    private static float sin(float v) { return (float) Math.sin(v); }
    private static float cos(float v) { return (float) Math.cos(v); }

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

        this.frame.pitch = sit ? -0.45f : 0f;
        this.body.pitch = breathe * 0.01f;
        this.neck1.pitch = -0.55f + (sit ? 0.35f : 0f);
        this.neck2.pitch = 0.25f;
        this.neck1.yaw = yawLook * 0.3f;
        this.neck2.yaw = yawLook * 0.3f;
        this.head.yaw = yawLook * 0.4f;
        this.head.pitch = 0.4f + pitchLook * 0.6f + breathe * 0.02f - (s.breathing ? 0.3f : 0f);
        this.jaw.pitch = s.breathing ? 0.8f : 0.06f + (breathe + 1f) * 0.04f;

        float sway = sin(t * 0.07f);
        float walkSway = cos(f) * 0.1f * amp;
        this.tail1.yaw = sway * 0.12f + walkSway;
        this.tail2.yaw = sin(t * 0.07f - 0.6f) * 0.16f + walkSway;
        this.tail3.yaw = sin(t * 0.07f - 1.2f) * 0.2f;
        this.tail4.yaw = sin(t * 0.07f - 1.8f) * 0.24f;
        this.tailTip.yaw = sin(t * 0.07f - 2.4f) * 0.28f;
        this.tail1.pitch = sit ? 0.45f : 0f;

        float fold = 0.88f;
        float flutter = sin(t * 0.1f) * 0.025f;
        this.wingL.yaw = -0.8f * fold;  this.wingR.yaw = 0.8f * fold;
        this.wingL.roll = 0.3f * fold + flutter;  this.wingR.roll = -(0.3f * fold + flutter);
        this.foreL.yaw = -1.2f * fold;  this.foreR.yaw = 1.2f * fold;
        float[] base = {-0.45f, -0.95f, -1.45f};
        ModelPart[] fl = {f1L, f2L, f3L};
        ModelPart[] fr = {f1R, f2R, f3R};
        for (int i = 0; i < 3; i++) {
            fl[i].yaw = base[i] * (1f - 0.7f * fold);
            fr[i].yaw = -base[i] * (1f - 0.7f * fold);
        }

        if (sit) {
            this.legFl.pitch = 0.5f; this.legFr.pitch = 0.5f;
            this.legBl.pitch = -0.9f; this.legBr.pitch = -0.9f;
        } else {
            float sw = cos(f) * 1.1f * amp;
            this.legFl.pitch = sw;  this.legBr.pitch = sw;
            this.legFr.pitch = -sw; this.legBl.pitch = -sw;
        }
    }
}
