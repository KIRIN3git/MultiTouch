package com.example.shinji.multitouch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event){

		// タッチしている数を取得
		int count = event.getPointerCount();
		//タッチアクションの情報を取得
		int action = event.getAction();

		int id = (action & MotionEvent.ACTION_POINTER_INDEX_MASK) >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
		int pid;

		//イベントごとにログを出力
		switch(action & MotionEvent.ACTION_MASK) {
			case MotionEvent.ACTION_DOWN:
				Log.i("tag1", "Touch Down" + " count=" + count + ", DataIndex=" + id);
				break;
			case MotionEvent.ACTION_POINTER_DOWN:
				Log.i("tag1", "Touch PTR Down" + " count=" + count + ", DataIndex=" + id);
				break;
			case MotionEvent.ACTION_UP:
				Log.i("tag1", "Touch Up" + " count=" + count + ", DataIndex=" + id);
				break;
			case MotionEvent.ACTION_POINTER_UP:
				Log.i("tag1", "Touch PTR Up" + " count=" + count + ", DataIndex=" + id);
				break;
		}

		for(int i=0; i<count; i++) {
			// ポインタID
			pid = event.getPointerId(i);
			// データID
			id = event.findPointerIndex(pid);
			if (id == -1) continue;
			float x = event.getX(id);
			float y = event.getY(id);

			Log.i("tag2", "DataIndex[" + id + "] PointIndex[" + pid + "] x[" + x + "]");
			Log.i("tag2", "DataIndex[" + id + "] PointIndex[" + pid + "] y[" + y + "]");
		}



		return super.onTouchEvent(event);
	}

}
