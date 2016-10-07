package edu.bistu.pvz.bean.base.product;

import org.cocos2d.actions.CCScheduler;

import java.util.Random;

import edu.bistu.pvz.bean.base.ProductPlant;
import edu.bistu.pvz.bean.product.Sun;

/**
 * 阳光
 * @author Administrator
 *
 */
public class SunProductor extends ProductPlant {

	public SunProductor(){
		super("");
		create();
	}

	public void create() {
		CCScheduler.sharedScheduler().schedule("create", this, 20, false);
	}

	public void create(float f) {
		Random random = new Random();
		int x = random.nextInt((int) getContentSize().width);
		int y = (int) getContentSize().height;
		new Sun(this.getParent(), Sun.TYPE_BIG, ccp(x, y), ccp(x,
				y+100));

	}

	@Override
	public void motionless() {

	}
}
