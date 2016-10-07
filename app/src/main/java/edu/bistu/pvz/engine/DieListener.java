package edu.bistu.pvz.engine;

import edu.bistu.pvz.bean.base.BaseElement;

/**
 * 处理僵尸或植物死亡
 */
public interface DieListener {
	void onDie(BaseElement element);
}
