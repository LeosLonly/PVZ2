package edu.bistu.pvz.bean.base;

import java.util.LinkedList;

import edu.bistu.pvz.bean.product.Bullet;
import edu.bistu.pvz.engine.DieListener;

/**
 * 攻击植物
 */
public abstract class AttackPlant extends Plant implements DieListener {
	protected LinkedList<Bullet> bullets = new LinkedList<Bullet>();
	protected AttackPlant(String filepath) {
		super(filepath);
		type = Plant.TYPE_ATTACK;
	}
	public LinkedList<Bullet> getBullets() {
		return bullets;
	}
	@Override
	public void onDie(BaseElement element) {
		bullets.remove(element);
	}
}
