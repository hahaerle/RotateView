package com.lenote.example;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lenote.rotateupdown.AbstractRotateHelper;
import com.lenote.rotateupdown.RotateView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
	private RotateView rotateView;
	private AbstractRotateHelper<String> rotateHelper;
	private static List<String> sList = new ArrayList<>();

	static {
		for (int i = 0; i < 10; i++) {
			sList.add("测试数据" + i);
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		rotateView = (RotateView) findViewById(R.id.rotateView);
		rotateHelper = new AbstractRotateHelper<String>(rotateView) {
			@Override
			protected View onCreateView(Context context, String item) {
				TextView view = new TextView(context);
				view.setText(item);
				return view;
			}

		};
		rotateHelper.setList(sList);
	}
}
