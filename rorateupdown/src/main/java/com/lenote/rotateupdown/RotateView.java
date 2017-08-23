package com.lenote.rotateupdown;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;

/**
 * Created by shangerle on 17/7/9.
 */
public class RotateView extends FrameLayout {
	public RotateView(Context context) {
		this(context, null);
	}

	public RotateView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public RotateView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initView(context);
	}

	private void initView(Context context) {
		View.inflate(context,R.layout.view_auto_updown_rotate,null);
	}

	public void bindData(View view,IViewStatusListener listener) {
		lastView = currentView;
		currentView = view;
		this.listener=listener;
		startRotate();
	}

	private void startRotate() {
		if (lastView != null) {
			outAnimation(lastView);
			inAnimation(currentView);
		} else {
			addViewAndMatchParent(currentView);
		}
	}

	private void addViewAndMatchParent(View view) {
		addView(view);
	}

	private void inAnimation(final View view) {
		addViewAndMatchParent(view);
		TranslateAnimation translate = AnimationUtil.moveToViewLocation();
		view.startAnimation(translate);
	}

	private void outAnimation(final View view) {
		TranslateAnimation translate = AnimationUtil.moveToViewUp();
		translate.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				removeView(view);
				if (listener != null) {
					listener.onRemove(view);
				}
			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}
		});
		view.startAnimation(translate);
	}

	private View currentView;
	private View lastView;

	public void release() {
		removeAllViews();
		if (currentView != null) {
			currentView.clearAnimation();
			currentView = null;
		}
		if (lastView != null) {
			lastView.clearAnimation();
			lastView = null;
		}
	}


	IViewStatusListener listener;

	public void setListener(IViewStatusListener listener) {
		this.listener = listener;
	}

	public interface IViewStatusListener {
		void onRemove(View view);
	}

}
