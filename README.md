# RotateView
用于android平台上下滚动播放的一个项目

__实现一个虚方法

rotateView = (RotateView) findViewById(R.id.rotateView);//RotateView 滚动view
rotateHelper = new AbstractRotateHelper<String>(rotateView) {
	@Override
	protected View onCreateView(Context context, String item) {//实现虚方法
		TextView view = new TextView(context);
		view.setText(item);
		return view;
	}
};
   
__Gradle__
	
Add dependencies in build.gradle of your module
	dependencies {
    	     compile 'com.lenote.views:rotateview:0.0.2'
	}

