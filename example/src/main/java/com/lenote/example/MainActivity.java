package com.lenote.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lenote.rotateupdown.RotateView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
	RotateView rotateView;
	RotateHelper rotateHelper;
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
		rotateHelper = new RotateHelper(rotateView);
		rotateHelper.setList(sList);
	}
}
