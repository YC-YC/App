/**
 * 
 */
package com.zhonghong.camera;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.widget.RelativeLayout.LayoutParams;

import com.zhonghong.log.L;
  
/**
 * @author zhonghong.chenli
 * date:2015-10-1下午5:29:21	<br/> 
 */
public class CameraSurfaceView extends SurfaceView{
	

	private static final String tag = "CameraSurfaceView";
	
	public CameraSurfaceView(Context context, AttributeSet attrs) {
		super(context, attrs);
			init();
	}


	private void init(){
		getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		getHolder().setKeepScreenOn(true);
		getHolder().addCallback(mCallback);
	}
	 
	private Callback mCallback = new Callback() {
		
		@Override
		public void surfaceDestroyed(SurfaceHolder holder) {
			// TODO Auto-generated method stub
			Log.e(tag, "surfaceDestroyed");
		}
		
		@Override
		public void surfaceCreated(SurfaceHolder holder) {
			// TODO Auto-generated method stub
			Log.e(tag, "surfaceCreated");
		}
		
		@Override
		public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
			// TODO Auto-generated method stub
			Log.e(tag, "surfaceChanged width = " + width + " height = " + height);
			
		}
	}; 

	Camera camera;
	@SuppressLint("NewApi")
	private void initCamera(){ 
		if(camera == null){
			camera = Camera.open(100);				//关键步骤1
		}
		
		try {    
			camera.setPreviewDisplay(getHolder());	//这里是会异常，不用理会
		} catch (Exception e) {  
			// TODO Auto-generated catch block
			e.printStackTrace();   
			L.e(tag, "打开camera error");
		}    
		camera.startPreview(); 						//关键步骤2
	} 
	
	
	
	private void close(){
		if(camera == null){
			L.w(tag, "camera == null Exception");
			return;
		}
		try{
			camera.stopPreview();
		}catch(Exception e){
			e.printStackTrace();
		}
		camera.release();
		camera = null;
		
	}
	
	public void openCamera(){ 
		initCamera();
	}
	
	
	public void closeCamera(){
		close();
	}
	
}
