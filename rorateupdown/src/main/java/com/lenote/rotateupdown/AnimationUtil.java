package com.lenote.rotateupdown;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

/**
 * Created by shangerle on 17/7/9.
 */
public class AnimationUtil {
	/**
	 * 从控件所在位置移动到控件的顶部
	 *
	 * @return
	 */
	public static TranslateAnimation moveToViewUp() {
		TranslateAnimation mHiddenAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
				Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
				0.0f, Animation.RELATIVE_TO_SELF, -1.0f);
		mHiddenAction.setDuration(Constants.NEWS_DURATION_LEN);
		return mHiddenAction;
	}

	/**
	 * 从控件的底部移动到控件所在位置
	 *
	 * @return
	 */
	public static TranslateAnimation moveToViewLocation() {
		TranslateAnimation mHiddenAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
				Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
				1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
		mHiddenAction.setDuration(Constants.NEWS_DURATION_LEN);
		return mHiddenAction;
	}
}
