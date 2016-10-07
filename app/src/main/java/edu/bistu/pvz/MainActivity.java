package edu.bistu.pvz;

import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

import org.cocos2d.nodes.CCDirector;
import org.cocos2d.opengl.CCGLSurfaceView;

import edu.bistu.pvz.layer.Loading1;
import edu.bistu.pvz.layer.manager.LayerManager;

public class MainActivity extends AppCompatActivity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CCGLSurfaceView view=new CCGLSurfaceView(this);
        setContentView(view);

        CCDirector.sharedDirector().attachInView(view);
        CCDirector.sharedDirector().setDisplayFPS(true);
        CCDirector.sharedDirector().setAnimationInterval(1/60);
        CCDirector.sharedDirector().setDeviceOrientation(CCDirector.kCCDeviceOrientationLandscapeLeft);

        CCDirector.sharedDirector().setScreenSize(480, 320);

        LayerManager.getInstance().changeLayer(new Loading1());

    }

    @Override
    protected void onDestroy() {
        CCDirector.sharedDirector().end();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        CCDirector.sharedDirector().onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        CCDirector.sharedDirector().onResume();
        super.onResume();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Process.killProcess(Process.myPid());
        return super.onKeyDown(keyCode, event);
    }
}
