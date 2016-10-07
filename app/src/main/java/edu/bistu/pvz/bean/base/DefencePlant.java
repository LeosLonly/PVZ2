package edu.bistu.pvz.bean.base;

/**
 * 防御性植物
 * 
 * @author Administrator
 * 
 */
public abstract class DefencePlant extends Plant {

	public DefencePlant(String filepath) {
		super(filepath);
		type = Plant.TYPE_DEFENSE;
	}

	@Override
	public void attack(ElementAction action) {
	}

}
