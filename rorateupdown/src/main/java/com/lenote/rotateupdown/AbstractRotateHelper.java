package com.lenote.rotateupdown;

import android.content.Context;
import android.os.Message;
import android.view.View;

import java.util.List;

/**
 * Created by shangerle on 17/7/9.
 */

public abstract class AbstractRotateHelper<T> {
	private RotateView currentRotateView;
	private Context context;

	public AbstractRotateHelper(RotateView currentRotateView) {
		this.currentRotateView = currentRotateView;
		this.context = currentRotateView.getContext();
	}

	private _Handler handler = new _Handler(this);

	private static class _Handler extends WeakRefHandler<AbstractRotateHelper> {
		public _Handler(AbstractRotateHelper autoUpDownRotateView) {
			super(autoUpDownRotateView);
		}

		@Override
		protected void handleMessage(AbstractRotateHelper autoUpDownRotateView, Message msg) {
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

	private List<T> list;
	private int currentIndex = 0;

	public void setList(List<T> list) {
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

	private void addView(T item) {
		View view = onCreateView(context,item);
		currentRotateView.bindData(view);
		handler.sendEmptyMessageDelayed(0, Constants.NEW_PLAY_INTERVAL);
	}

	protected abstract View onCreateView(Context context, T item);

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
