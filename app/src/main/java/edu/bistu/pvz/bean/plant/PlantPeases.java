package edu.bistu.pvz.bean.plant;

import edu.bistu.pvz.bean.base.AttackPlant;
import edu.bistu.pvz.bean.base.ElementAction;
import edu.bistu.pvz.bean.product.Bullet;
import edu.bistu.pvz.bean.product.BulletCommon;

/**
 * Created by Administrator on 2016/10/6.
 */

public class PlantPeases extends AttackPlant {


    public PlantPeases() {
        super("image/plant/pease/Repeater.png");
        life = 100;
        price = 200;
    }

    @Override
    public void attack(ElementAction action) {
        if (bullets.size() < 2) {
            BulletCommon common = new BulletCommon(this);
            common.setListener(this);
            bullets.addLast(common);
        }
    }

    @Override
    public void motionless() {
        for (Bullet item : bullets) {
            item.removeSelf();
        }
        super.distory();
    }
}
