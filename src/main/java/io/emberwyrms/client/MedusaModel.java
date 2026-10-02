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
public class MedusaModel extends EntityModel<MedusaRenderState> {
    private final ModelPart coil1;
    private final ModelPart coil2;
    private final ModelPart coil3;
    private final ModelPart coil4;
    private final ModelPart coil5;
    private final ModelPart coil6;
    private final ModelPart coil7;
    private final ModelPart coil8;
    private final ModelPart coil9;
    private final ModelPart coil10;
    private final ModelPart coil11;
    private final ModelPart coil12;
    private final ModelPart coilEnd;
    private final ModelPart torso;
    private final ModelPart head;
    private final ModelPart armL;
    private final ModelPart armR;
    private final ModelPart snake0;
    private final ModelPart snake0B;
    private final ModelPart snake0C;
    private final ModelPart snake0H;
    private final ModelPart snake1;
    private final ModelPart snake1B;
    private final ModelPart snake1C;
    private final ModelPart snake1H;
    private final ModelPart snake2;
    private final ModelPart snake2B;
    private final ModelPart snake2C;
    private final ModelPart snake2H;
    private final ModelPart snake3;
    private final ModelPart snake3B;
    private final ModelPart snake3C;
    private final ModelPart snake3H;
    private final ModelPart snake4;
    private final ModelPart snake4B;
    private final ModelPart snake4C;
    private final ModelPart snake4H;
    private final ModelPart snake5;
    private final ModelPart snake5B;
    private final ModelPart snake5C;
    private final ModelPart snake5H;
    private final ModelPart snake6;
    private final ModelPart snake6B;
    private final ModelPart snake6C;
    private final ModelPart snake6H;
    private final ModelPart snake7;
    private final ModelPart snake7B;
    private final ModelPart snake7C;
    private final ModelPart snake7H;
    private final ModelPart snake8;
    private final ModelPart snake8B;
    private final ModelPart snake8C;
    private final ModelPart snake8H;
    private final ModelPart snake9;
    private final ModelPart snake9B;
    private final ModelPart snake9C;
    private final ModelPart snake9H;
    private final ModelPart snake10;
    private final ModelPart snake10B;
    private final ModelPart snake10C;
    private final ModelPart snake10H;
    private final ModelPart snake11;
    private final ModelPart snake11B;
    private final ModelPart snake11C;
    private final ModelPart snake11H;

    public MedusaModel(ModelPart root) {
        super(root);
        this.coil1 = root.getChild("coil1");
        this.coil2 = coil1.getChild("coil2");
        this.coil3 = coil2.getChild("coil3");
        this.coil4 = coil3.getChild("coil4");
        this.coil5 = coil4.getChild("coil5");
        this.coil6 = coil5.getChild("coil6");
        this.coil7 = coil6.getChild("coil7");
        this.coil8 = coil7.getChild("coil8");
        this.coil9 = coil8.getChild("coil9");
        this.coil10 = coil9.getChild("coil10");
        this.coil11 = coil10.getChild("coil11");
        this.coil12 = coil11.getChild("coil12");
        this.coilEnd = coil12.getChild("coil_end");
        this.torso = root.getChild("torso");
        this.head = torso.getChild("head");
        this.armL = torso.getChild("arm_l");
        this.armR = torso.getChild("arm_r");
        this.snake0 = head.getChild("snake0");
        this.snake0B = snake0.getChild("snake0_b");
        this.snake0C = snake0B.getChild("snake0_c");
        this.snake0H = snake0C.getChild("snake0_h");
        this.snake1 = head.getChild("snake1");
        this.snake1B = snake1.getChild("snake1_b");
        this.snake1C = snake1B.getChild("snake1_c");
        this.snake1H = snake1C.getChild("snake1_h");
        this.snake2 = head.getChild("snake2");
        this.snake2B = snake2.getChild("snake2_b");
        this.snake2C = snake2B.getChild("snake2_c");
        this.snake2H = snake2C.getChild("snake2_h");
        this.snake3 = head.getChild("snake3");
        this.snake3B = snake3.getChild("snake3_b");
        this.snake3C = snake3B.getChild("snake3_c");
        this.snake3H = snake3C.getChild("snake3_h");
        this.snake4 = head.getChild("snake4");
        this.snake4B = snake4.getChild("snake4_b");
        this.snake4C = snake4B.getChild("snake4_c");
        this.snake4H = snake4C.getChild("snake4_h");
        this.snake5 = head.getChild("snake5");
        this.snake5B = snake5.getChild("snake5_b");
        this.snake5C = snake5B.getChild("snake5_c");
        this.snake5H = snake5C.getChild("snake5_h");
        this.snake6 = head.getChild("snake6");
        this.snake6B = snake6.getChild("snake6_b");
        this.snake6C = snake6B.getChild("snake6_c");
        this.snake6H = snake6C.getChild("snake6_h");
        this.snake7 = head.getChild("snake7");
        this.snake7B = snake7.getChild("snake7_b");
        this.snake7C = snake7B.getChild("snake7_c");
        this.snake7H = snake7C.getChild("snake7_h");
        this.snake8 = head.getChild("snake8");
        this.snake8B = snake8.getChild("snake8_b");
        this.snake8C = snake8B.getChild("snake8_c");
        this.snake8H = snake8C.getChild("snake8_h");
        this.snake9 = head.getChild("snake9");
        this.snake9B = snake9.getChild("snake9_b");
        this.snake9C = snake9B.getChild("snake9_c");
        this.snake9H = snake9C.getChild("snake9_h");
        this.snake10 = head.getChild("snake10");
        this.snake10B = snake10.getChild("snake10_b");
        this.snake10C = snake10B.getChild("snake10_c");
        this.snake10H = snake10C.getChild("snake10_h");
        this.snake11 = head.getChild("snake11");
        this.snake11B = snake11.getChild("snake11_b");
        this.snake11C = snake11B.getChild("snake11_c");
        this.snake11H = snake11C.getChild("snake11_h");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData data = new ModelData();
        ModelPartData root = data.getRoot();
        ModelPartData coil1 = root.addChild("coil1", ModelPartBuilder.create()
                .uv(0, 0).cuboid(-5.5f, -4.5f, -5f, 11f, 9f, 10f),
                ModelTransform.of(0f, 19.5f, 2f, 0f, 0f, 0f));
        ModelPartData coil2 = coil1.addChild("coil2", ModelPartBuilder.create()
                .uv(0, 19).cuboid(-5f, -4f, 0f, 10f, 8f, 7f),
                ModelTransform.of(0f, 0.5f, 5f, 0f, 0.22f, 0f));
        ModelPartData coil3 = coil2.addChild("coil3", ModelPartBuilder.create()
                .uv(34, 19).cuboid(-4.5f, -3.5f, 0f, 9f, 7f, 7f),
                ModelTransform.of(0f, 0.5f, 7f, 0f, 0.22f, 0f));
        ModelPartData coil4 = coil3.addChild("coil4", ModelPartBuilder.create()
                .uv(90, 19).cuboid(-4f, -3f, 0f, 8f, 6f, 7f),
                ModelTransform.of(0f, 0.5f, 7f, 0f, 0.22f, 0f));
        ModelPartData coil5 = coil4.addChild("coil5", ModelPartBuilder.create()
                .uv(0, 34).cuboid(-3.5f, -3f, 0f, 7f, 6f, 7f),
                ModelTransform.of(0f, 0f, 7f, 0f, 0.22f, 0f));
        ModelPartData coil6 = coil5.addChild("coil6", ModelPartBuilder.create()
                .uv(46, 34).cuboid(-3f, -2.5f, 0f, 6f, 5f, 7f),
                ModelTransform.of(0f, 0.5f, 7f, 0f, 0.22f, 0f));
        ModelPartData coil7 = coil6.addChild("coil7", ModelPartBuilder.create()
                .uv(46, 34).cuboid(-3f, -2.5f, 0f, 6f, 5f, 7f),
                ModelTransform.of(0f, 0f, 7f, 0f, 0.22f, 0f));
        ModelPartData coil8 = coil7.addChild("coil8", ModelPartBuilder.create()
                .uv(28, 47).cuboid(-2.5f, -2f, 0f, 5f, 4f, 6f),
                ModelTransform.of(0f, 0.5f, 7f, 0f, 0.22f, 0f));
        ModelPartData coil9 = coil8.addChild("coil9", ModelPartBuilder.create()
                .uv(50, 47).cuboid(-2f, -2f, 0f, 4f, 4f, 6f),
                ModelTransform.of(0f, 0f, 6f, 0f, 0.22f, 0f));
        ModelPartData coil10 = coil9.addChild("coil10", ModelPartBuilder.create()
                .uv(98, 47).cuboid(-2f, -1.5f, 0f, 4f, 3f, 6f),
                ModelTransform.of(0f, 0.5f, 6f, 0f, 0.22f, 0f));
        ModelPartData coil11 = coil10.addChild("coil11", ModelPartBuilder.create()
                .uv(0, 57).cuboid(-1.5f, -1.5f, 0f, 3f, 3f, 6f),
                ModelTransform.of(0f, 0f, 6f, 0f, 0.22f, 0f));
        ModelPartData coil12 = coil11.addChild("coil12", ModelPartBuilder.create()
                .uv(18, 57).cuboid(-1.5f, -1f, 0f, 3f, 2f, 6f),
                ModelTransform.of(0f, 0.5f, 6f, 0f, 0.22f, 0f));
        ModelPartData coilEnd = coil12.addChild("coil_end", ModelPartBuilder.create()
                .uv(16, 66).cuboid(-1f, -1f, 0f, 2f, 2f, 4f)
                .uv(40, 66).cuboid(-1.5f, -1.5f, 3f, 3f, 3f, 2f),
                ModelTransform.of(0f, 0f, 6f, 0f, 0f, 0f));
        ModelPartData torso = root.addChild("torso", ModelPartBuilder.create()
                .uv(78, 57).cuboid(-3f, -3f, -2f, 6f, 3f, 4f)
                .uv(66, 19).cuboid(-3.5f, -11f, -2.5f, 7f, 9f, 5f)
                .uv(0, 47).cuboid(-4f, -9f, -3f, 8f, 4f, 6f)
                .uv(48, 57).cuboid(-5f, -12f, -2.5f, 10f, 2f, 5f)
                .uv(98, 57).cuboid(-4f, -3f, -2.5f, 8f, 1f, 5f)
                .uv(70, 47).cuboid(-4f, -2f, -3f, 8f, 3f, 6f),
                ModelTransform.of(0f, 16f, -1f, 0f, 0f, 0f));
        ModelPartData head = torso.addChild("head", ModelPartBuilder.create()
                .uv(80, 0).cuboid(-4f, -8f, -4f, 8f, 8f, 8f)
                .uv(72, 34).cuboid(-4.5f, -7f, -4.5f, 9f, 1f, 9f)
                .uv(42, 0).cuboid(-9f, -11f, 4.5f, 18f, 15f, 1f)
                .uv(28, 34).cuboid(-4f, -7f, 4f, 8f, 12f, 1f)
                .uv(60, 66).cuboid(4f, -4f, -0.5f, 1f, 2f, 3f)
                .uv(60, 66).cuboid(-5f, -4f, -0.5f, 1f, 2f, 3f),
                ModelTransform.of(0f, -12f, 0f, 0f, 0f, 0f));
        ModelPartData armL = torso.addChild("arm_l", ModelPartBuilder.create()
                .uv(36, 57).cuboid(-1.5f, -1f, -1.5f, 3f, 5f, 3f)
                .uv(36, 57).cuboid(-1.5f, 4f, -1.5f, 3f, 5f, 3f)
                .uv(0, 66).cuboid(-2f, 5f, -2f, 4f, 2f, 4f)
                .uv(28, 66).cuboid(-1.5f, 9f, -1.5f, 3f, 2f, 3f)
                .uv(76, 66).cuboid(-1.5f, 11f, -1.5f, 1f, 2f, 1f)
                .uv(76, 66).cuboid(-0.5f, 11f, -1.5f, 1f, 2f, 1f)
                .uv(76, 66).cuboid(0.5f, 11f, -1.5f, 1f, 2f, 1f),
                ModelTransform.of(5f, -11f, 0f, 0f, 0f, 0f));
        ModelPartData armR = torso.addChild("arm_r", ModelPartBuilder.create()
                .uv(36, 57).cuboid(-1.5f, -1f, -1.5f, 3f, 5f, 3f)
                .uv(36, 57).cuboid(-1.5f, 4f, -1.5f, 3f, 5f, 3f)
                .uv(0, 66).cuboid(-2f, 5f, -2f, 4f, 2f, 4f)
                .uv(28, 66).cuboid(-1.5f, 9f, -1.5f, 3f, 2f, 3f)
                .uv(76, 66).cuboid(-1.5f, 11f, -1.5f, 1f, 2f, 1f)
                .uv(76, 66).cuboid(-0.5f, 11f, -1.5f, 1f, 2f, 1f)
                .uv(76, 66).cuboid(0.5f, 11f, -1.5f, 1f, 2f, 1f),
                ModelTransform.of(-5f, -11f, 0f, 0f, 0f, 0f));
        ModelPartData snake0 = head.addChild("snake0", ModelPartBuilder.create()
                .uv(68, 66).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(3.8f, -8f, 0f, 0f, 0f, 0.55f));
        ModelPartData snake0B = snake0.addChild("snake0_b", ModelPartBuilder.create()
                .uv(68, 66).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(0f, -4f, 0f, 0f, 0f, 0.35f));
        ModelPartData snake0C = snake0B.addChild("snake0_c", ModelPartBuilder.create()
                .uv(72, 66).cuboid(-0.5f, -3f, -0.5f, 1f, 3f, 1f),
                ModelTransform.of(0f, -4f, 0f, 0f, 0f, 0.3f));
        ModelPartData snake0H = snake0C.addChild("snake0_h", ModelPartBuilder.create()
                .uv(50, 66).cuboid(-1f, -2.5f, -1.5f, 2f, 2f, 3f),
                ModelTransform.of(0f, -3f, 0f, 0.6f, 0f, 0f));
        ModelPartData snake1 = head.addChild("snake1", ModelPartBuilder.create()
                .uv(68, 66).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(3.2909f, -8f, 1.9f, -0.275f, 0f, 0.4763f));
        ModelPartData snake1B = snake1.addChild("snake1_b", ModelPartBuilder.create()
                .uv(68, 66).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(0f, -4f, 0f, -0.175f, 0f, 0.3031f));
        ModelPartData snake1C = snake1B.addChild("snake1_c", ModelPartBuilder.create()
                .uv(72, 66).cuboid(-0.5f, -3f, -0.5f, 1f, 3f, 1f),
                ModelTransform.of(0f, -4f, 0f, -0.15f, 0f, 0.2598f));
        ModelPartData snake1H = snake1C.addChild("snake1_h", ModelPartBuilder.create()
                .uv(50, 66).cuboid(-1f, -2.5f, -1.5f, 2f, 2f, 3f),
                ModelTransform.of(0f, -3f, 0f, 0.6f, 0f, 0f));
        ModelPartData snake2 = head.addChild("snake2", ModelPartBuilder.create()
                .uv(68, 66).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(1.9f, -8f, 3.2909f, -0.4763f, 0f, 0.275f));
        ModelPartData snake2B = snake2.addChild("snake2_b", ModelPartBuilder.create()
                .uv(68, 66).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(0f, -4f, 0f, -0.3031f, 0f, 0.175f));
        ModelPartData snake2C = snake2B.addChild("snake2_c", ModelPartBuilder.create()
                .uv(72, 66).cuboid(-0.5f, -3f, -0.5f, 1f, 3f, 1f),
                ModelTransform.of(0f, -4f, 0f, -0.2598f, 0f, 0.15f));
        ModelPartData snake2H = snake2C.addChild("snake2_h", ModelPartBuilder.create()
                .uv(50, 66).cuboid(-1f, -2.5f, -1.5f, 2f, 2f, 3f),
                ModelTransform.of(0f, -3f, 0f, 0.6f, 0f, 0f));
        ModelPartData snake3 = head.addChild("snake3", ModelPartBuilder.create()
                .uv(68, 66).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(0f, -8f, 3.8f, -0.55f, 0f, 0f));
        ModelPartData snake3B = snake3.addChild("snake3_b", ModelPartBuilder.create()
                .uv(68, 66).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(0f, -4f, 0f, -0.35f, 0f, 0f));
        ModelPartData snake3C = snake3B.addChild("snake3_c", ModelPartBuilder.create()
                .uv(72, 66).cuboid(-0.5f, -3f, -0.5f, 1f, 3f, 1f),
                ModelTransform.of(0f, -4f, 0f, -0.3f, 0f, 0f));
        ModelPartData snake3H = snake3C.addChild("snake3_h", ModelPartBuilder.create()
                .uv(50, 66).cuboid(-1f, -2.5f, -1.5f, 2f, 2f, 3f),
                ModelTransform.of(0f, -3f, 0f, 0.6f, 0f, 0f));
        ModelPartData snake4 = head.addChild("snake4", ModelPartBuilder.create()
                .uv(68, 66).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(-1.9f, -8f, 3.2909f, -0.4763f, 0f, -0.275f));
        ModelPartData snake4B = snake4.addChild("snake4_b", ModelPartBuilder.create()
                .uv(68, 66).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(0f, -4f, 0f, -0.3031f, 0f, -0.175f));
        ModelPartData snake4C = snake4B.addChild("snake4_c", ModelPartBuilder.create()
                .uv(72, 66).cuboid(-0.5f, -3f, -0.5f, 1f, 3f, 1f),
                ModelTransform.of(0f, -4f, 0f, -0.2598f, 0f, -0.15f));
        ModelPartData snake4H = snake4C.addChild("snake4_h", ModelPartBuilder.create()
                .uv(50, 66).cuboid(-1f, -2.5f, -1.5f, 2f, 2f, 3f),
                ModelTransform.of(0f, -3f, 0f, 0.6f, 0f, 0f));
        ModelPartData snake5 = head.addChild("snake5", ModelPartBuilder.create()
                .uv(68, 66).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(-3.2909f, -8f, 1.9f, -0.275f, 0f, -0.4763f));
        ModelPartData snake5B = snake5.addChild("snake5_b", ModelPartBuilder.create()
                .uv(68, 66).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(0f, -4f, 0f, -0.175f, 0f, -0.3031f));
        ModelPartData snake5C = snake5B.addChild("snake5_c", ModelPartBuilder.create()
                .uv(72, 66).cuboid(-0.5f, -3f, -0.5f, 1f, 3f, 1f),
                ModelTransform.of(0f, -4f, 0f, -0.15f, 0f, -0.2598f));
        ModelPartData snake5H = snake5C.addChild("snake5_h", ModelPartBuilder.create()
                .uv(50, 66).cuboid(-1f, -2.5f, -1.5f, 2f, 2f, 3f),
                ModelTransform.of(0f, -3f, 0f, 0.6f, 0f, 0f));
        ModelPartData snake6 = head.addChild("snake6", ModelPartBuilder.create()
                .uv(68, 66).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(-3.8f, -8f, 0f, 0f, 0f, -0.55f));
        ModelPartData snake6B = snake6.addChild("snake6_b", ModelPartBuilder.create()
                .uv(68, 66).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(0f, -4f, 0f, 0f, 0f, -0.35f));
        ModelPartData snake6C = snake6B.addChild("snake6_c", ModelPartBuilder.create()
                .uv(72, 66).cuboid(-0.5f, -3f, -0.5f, 1f, 3f, 1f),
                ModelTransform.of(0f, -4f, 0f, 0f, 0f, -0.3f));
        ModelPartData snake6H = snake6C.addChild("snake6_h", ModelPartBuilder.create()
                .uv(50, 66).cuboid(-1f, -2.5f, -1.5f, 2f, 2f, 3f),
                ModelTransform.of(0f, -3f, 0f, 0.6f, 0f, 0f));
        ModelPartData snake7 = head.addChild("snake7", ModelPartBuilder.create()
                .uv(68, 66).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(-3.2909f, -8f, -1.9f, 0.275f, 0f, -0.4763f));
        ModelPartData snake7B = snake7.addChild("snake7_b", ModelPartBuilder.create()
                .uv(68, 66).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(0f, -4f, 0f, 0.175f, 0f, -0.3031f));
        ModelPartData snake7C = snake7B.addChild("snake7_c", ModelPartBuilder.create()
                .uv(72, 66).cuboid(-0.5f, -3f, -0.5f, 1f, 3f, 1f),
                ModelTransform.of(0f, -4f, 0f, 0.15f, 0f, -0.2598f));
        ModelPartData snake7H = snake7C.addChild("snake7_h", ModelPartBuilder.create()
                .uv(50, 66).cuboid(-1f, -2.5f, -1.5f, 2f, 2f, 3f),
                ModelTransform.of(0f, -3f, 0f, 0.6f, 0f, 0f));
        ModelPartData snake8 = head.addChild("snake8", ModelPartBuilder.create()
                .uv(68, 66).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(-1.9f, -8f, -3.2909f, 0.4763f, 0f, -0.275f));
        ModelPartData snake8B = snake8.addChild("snake8_b", ModelPartBuilder.create()
                .uv(68, 66).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(0f, -4f, 0f, 0.3031f, 0f, -0.175f));
        ModelPartData snake8C = snake8B.addChild("snake8_c", ModelPartBuilder.create()
                .uv(72, 66).cuboid(-0.5f, -3f, -0.5f, 1f, 3f, 1f),
                ModelTransform.of(0f, -4f, 0f, 0.2598f, 0f, -0.15f));
        ModelPartData snake8H = snake8C.addChild("snake8_h", ModelPartBuilder.create()
                .uv(50, 66).cuboid(-1f, -2.5f, -1.5f, 2f, 2f, 3f),
                ModelTransform.of(0f, -3f, 0f, 0.6f, 0f, 0f));
        ModelPartData snake9 = head.addChild("snake9", ModelPartBuilder.create()
                .uv(68, 66).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(0f, -8f, -3.8f, 0.55f, 0f, 0f));
        ModelPartData snake9B = snake9.addChild("snake9_b", ModelPartBuilder.create()
                .uv(68, 66).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(0f, -4f, 0f, 0.35f, 0f, 0f));
        ModelPartData snake9C = snake9B.addChild("snake9_c", ModelPartBuilder.create()
                .uv(72, 66).cuboid(-0.5f, -3f, -0.5f, 1f, 3f, 1f),
                ModelTransform.of(0f, -4f, 0f, 0.3f, 0f, 0f));
        ModelPartData snake9H = snake9C.addChild("snake9_h", ModelPartBuilder.create()
                .uv(50, 66).cuboid(-1f, -2.5f, -1.5f, 2f, 2f, 3f),
                ModelTransform.of(0f, -3f, 0f, 0.6f, 0f, 0f));
        ModelPartData snake10 = head.addChild("snake10", ModelPartBuilder.create()
                .uv(68, 66).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(1.9f, -8f, -3.2909f, 0.4763f, 0f, 0.275f));
        ModelPartData snake10B = snake10.addChild("snake10_b", ModelPartBuilder.create()
                .uv(68, 66).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(0f, -4f, 0f, 0.3031f, 0f, 0.175f));
        ModelPartData snake10C = snake10B.addChild("snake10_c", ModelPartBuilder.create()
                .uv(72, 66).cuboid(-0.5f, -3f, -0.5f, 1f, 3f, 1f),
                ModelTransform.of(0f, -4f, 0f, 0.2598f, 0f, 0.15f));
        ModelPartData snake10H = snake10C.addChild("snake10_h", ModelPartBuilder.create()
                .uv(50, 66).cuboid(-1f, -2.5f, -1.5f, 2f, 2f, 3f),
                ModelTransform.of(0f, -3f, 0f, 0.6f, 0f, 0f));
        ModelPartData snake11 = head.addChild("snake11", ModelPartBuilder.create()
                .uv(68, 66).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(3.2909f, -8f, -1.9f, 0.275f, 0f, 0.4763f));
        ModelPartData snake11B = snake11.addChild("snake11_b", ModelPartBuilder.create()
                .uv(68, 66).cuboid(-0.5f, -4f, -0.5f, 1f, 4f, 1f),
                ModelTransform.of(0f, -4f, 0f, 0.175f, 0f, 0.3031f));
        ModelPartData snake11C = snake11B.addChild("snake11_c", ModelPartBuilder.create()
                .uv(72, 66).cuboid(-0.5f, -3f, -0.5f, 1f, 3f, 1f),
                ModelTransform.of(0f, -4f, 0f, 0.15f, 0f, 0.2598f));
        ModelPartData snake11H = snake11C.addChild("snake11_h", ModelPartBuilder.create()
                .uv(50, 66).cuboid(-1f, -2.5f, -1.5f, 2f, 2f, 3f),
                ModelTransform.of(0f, -3f, 0f, 0.6f, 0f, 0f));
        return TexturedModelData.of(data, 128, 128);
    }

    private static float sin(float v) { return (float) Math.sin(v); }
    private static float cos(float v) { return (float) Math.cos(v); }

    private static final float[] SNAKE_DX = {1f, 0.866f, 0.5f, 0f, -0.5f, -0.866f, -1f, -0.866f, -0.5f, 0f, 0.5f, 0.866f};
    private static final float[] SNAKE_DZ = {0f, 0.5f, 0.866f, 1f, 0.866f, 0.5f, 0f, -0.5f, -0.866f, -1f, -0.866f, -0.5f};

    @Override
    public void setAngles(MedusaRenderState s) {
        super.setAngles(s);
        float t = s.age;
        float f = s.walkPhase * 0.6662f;
        float amp = Math.min(1f, s.walkSpeed * 1.6f);
        float yawLook = s.relativeHeadYaw * 0.0174533f;
        float pitchLook = s.pitch * 0.0174533f;

        this.head.yaw = yawLook * 0.8f;
        this.head.pitch = pitchLook * 0.7f;
        this.torso.yaw = sin(t * 0.06f) * 0.06f + cos(f) * 0.15f * amp;

        float sw = 0.08f + 0.22f * amp;
        float sp = t * 0.07f + f * 0.5f;
        this.coil1.yaw = sin(sp) * sw;
        ModelPart[] coil = {coil2, coil3, coil4, coil5, coil6, coil7, coil8, coil9, coil10, coil11, coil12};
        for (int i = 0; i < coil.length; i++) coil[i].yaw = 0.22f + sin(sp - 0.6f * (i + 1)) * (sw + 0.05f * i);
        this.coilEnd.pitch = -0.4f + sin(t * 0.3f) * 0.2f;

        this.armL.pitch = -0.25f + cos(f) * 0.5f * amp;
        this.armR.pitch = -0.25f - cos(f) * 0.5f * amp;
        this.armL.roll = -0.12f + sin(t * 0.05f) * 0.03f;
        this.armR.roll = 0.12f - sin(t * 0.05f) * 0.03f;

        ModelPart[] a = {snake0, snake1, snake2, snake3, snake4, snake5, snake6, snake7, snake8, snake9, snake10, snake11};
        ModelPart[] b = {snake0B, snake1B, snake2B, snake3B, snake4B, snake5B, snake6B, snake7B, snake8B, snake9B, snake10B, snake11B};
        ModelPart[] c = {snake0C, snake1C, snake2C, snake3C, snake4C, snake5C, snake6C, snake7C, snake8C, snake9C, snake10C, snake11C};
        for (int i = 0; i < 12; i++) {
            a[i].roll = 0.55f * SNAKE_DX[i] + sin(t * 0.15f + i * 1.3f) * 0.2f;
            a[i].pitch = -0.55f * SNAKE_DZ[i] + sin(t * 0.13f + i) * 0.16f;
            b[i].roll = 0.35f * SNAKE_DX[i] + sin(t * 0.17f + i * 0.9f) * 0.3f;
            b[i].pitch = -0.35f * SNAKE_DZ[i] + cos(t * 0.15f + i) * 0.25f;
            c[i].roll = 0.3f * SNAKE_DX[i] + sin(t * 0.19f + i * 1.7f) * 0.4f;
            c[i].pitch = -0.3f * SNAKE_DZ[i] + cos(t * 0.21f + i * 1.1f) * 0.35f;
        }
    }
}
