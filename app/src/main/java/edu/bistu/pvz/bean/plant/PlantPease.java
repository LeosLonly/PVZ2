package edu.bistu.pvz.bean.plant;

import org.cocos2d.actions.base.CCRepeatForever;
import org.cocos2d.actions.interval.CCAnimate;
import org.cocos2d.nodes.CCAnimation;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.nodes.CCSpriteFrame;

import java.util.ArrayList;

import edu.bistu.pvz.bean.base.AttackPlant;
import edu.bistu.pvz.bean.base.ElementAction;
import edu.bistu.pvz.bean.product.Bullet;
import edu.bistu.pvz.bean.product.BulletCommon;

/**
 * 豌豆
 *
 * @author Administrator
 */
public class PlantPease extends AttackPlant {
    private static final String resPath = "image/plant/pease/p_2_%02d.png";
    // 静止帧
    protected static ArrayList<CCSpriteFrame> motionlessFrames;// 静止帧集合
    protected CCAnimation motionlessAnimation;// 静止的帧
    protected CCAnimate motionlessAnimate;// 静止动作

    static {
        motionlessFrames = new ArrayList<CCSpriteFrame>();
        for (int i = 1; i < 9; i++) {
            motionlessFrames.add(CCSprite.sprite(String.format(resPath, i)).displayedFrame());
        }
    }

    public PlantPease() {
        super("image/plant/pease/p_2_01.png");
        life = 100;
        price = 100;
        motionless();
    }

    /**
     * 植物的攻击
     */
    @Override
    public void attack(ElementAction action) {
        if (bullets.size() < 1) {
            BulletCommon common = new BulletCommon(this);
            common.setListener(this);
            bullets.addLast(common);
        }
    }

    @Override
    public void motionless() {
        motionlessAnimation = CCAnimation.animation("", 0.3f, motionlessFrames);
        motionlessAnimate = CCAnimate.action(motionlessAnimation);
        runAction(CCRepeatForever.action(motionlessAnimate));
    }

    @Override
    public void distory() {
        for (Bullet item : bullets) {
            item.removeSelf();
        }
        super.distory();
    }

}
