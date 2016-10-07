package edu.bistu.pvz.layer.manager;

import android.app.Activity;
import android.view.MotionEvent;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCNode;
import org.cocos2d.sound.SoundEngine;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGRect;
import org.cocos2d.types.CGSize;

import edu.bistu.pvz.R;


public abstract class BaseLayer extends CCLayer{
	protected static SoundEngine engine;
	protected CGSize winSize;//大小
	
	// 切屏类型
	protected int transitionSceneType = 0;
	
	static{
		engine=SoundEngine.sharedEngine();
		//声音引擎
		engine.preloadSound(getContext(), R.raw.start);
		engine.preloadSound(getContext(), R.raw.day);
		engine.preloadSound(getContext(), R.raw.night);
		//单击声音
		engine.preloadEffect(getContext(), R.raw.onclick);
	}
	
	protected BaseLayer()
	{
		winSize=CCDirector.sharedDirector().getWinSize();
		this.setIsTouchEnabled(true);
	}
	
	/**
	 *
	 * @return
	 */
	protected static Activity getContext() {
		return CCDirector.sharedDirector().getActivity();
	}

	protected boolean isClick(MotionEvent event,CCNode sprite)
	{
		CGPoint clickPoint = this.convertTouchToNodeSpace(event);
		return CGRect.containsPoint(sprite.getBoundingBox(), clickPoint);
	}

	public int getTransitionSceneType() {
		return transitionSceneType;
	}
	
	
}
