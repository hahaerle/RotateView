package com.lenote.example;

import android.content.Context;
import android.os.Message;
import android.widget.TextView;


import com.lenote.rotateupdown.RotateView;
import com.lenote.rotateupdown.Constants;

import java.util.List;

/**
 * Created by shangerle on 17/7/9.
 */

public class RotateHelper {
	private RotateView currentRotateView;
	private Context context;

	public RotateHelper(RotateView currentRotateView) {
		this.currentRotateView = currentRotateView;
		this.context = currentRotateView.getContext();
	}

	private _Handler handler = new _Handler(this);

	private static class _Handler extends WeakRefHandler<RotateHelper> {
		public _Handler(RotateHelper autoUpDownRotateView) {
			super(autoUpDownRotateView);
		}

		@Override
		protected void handleMessage(RotateHelper autoUpDownRotateView, Message msg) {
			if (msg.what == 0) {
				autoUpDownRotateView.addIndex();
				autoUpDownRotateView.addNewOne();
			}
		}
	}

	private void addIndex() {
		currentIndex++;
		if (currentIndex >= list.size())
			currentIndex = 0;
	}

	private List<String> list;
	private int currentIndex = 0;

	public void setList(List<String> list) {
		handler.removeMessages(0);
		this.list = list;
		currentIndex = 0;
		if (!handler.hasMessages(0)) {
			handler.sendEmptyMessage(0);
		}
	}

	private void addNewOne() {
		if (list == null || list.isEmpty()) return;
		int index = getIndex();
		addView(list.get(index));
	}

	private void addView(String item) {
		TextView view = new TextView(context);
		view.setText(item);
		currentRotateView.bindData(view);
		handler.sendEmptyMessageDelayed(0, Constants.NEW_PLAY_INTERVAL);
	}

	private int getIndex() {
		return currentIndex;
	}

	public void release() {
		handler.removeMessages(0);
		if (currentRotateView != null) {
			currentRotateView.release();
			currentRotateView = null;
		}
		context = null;
	}

}
