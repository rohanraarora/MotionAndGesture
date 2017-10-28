package gitapp.forkthecode.com.motionandgesture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener{

    RelativeLayout root;
    //VelocityTracker velocityTracker;
    HashMap<Integer,View> viewMap = new HashMap<>();

    GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        root = (RelativeLayout)findViewById(R.id.root);

        gestureDetector = new GestureDetector(this,new GestureDetector.SimpleOnGestureListener(){

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                Log.i("Gesture ","Simple Scroll");
                return true;
            }

        });

        root.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                gestureDetector.onTouchEvent(event);

                int action = event.getActionMasked();
                int index = event.getActionIndex();
                int id = event.getPointerId(index);
                View view;

                float x = event.getX(index);
                float y = event.getY(index);
                switch (action){

                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_POINTER_DOWN:
//                        if(velocityTracker == null){
//                            velocityTracker = VelocityTracker.obtain();
//                        }
                        view = new View(MainActivity.this);
                        view.setLayoutParams(new RelativeLayout.LayoutParams(100,100));
                        view.setBackgroundResource(R.color.colorAccent);
                        view.setX(x);
                        view.setY(y);
                        root.addView(view);
                        viewMap.put(id,view);
                        //velocityTracker.addMovement(event);
                        return true;


                    case MotionEvent.ACTION_MOVE:

//                        velocityTracker.addMovement(event);
//                        velocityTracker.computeCurrentVelocity(1000);

                        for(int i= 0;i<event.getPointerCount();i++){
                            id = event.getPointerId(i);
                            view = viewMap.get(id);
                            x = event.getX(i);
                            y = event.getY(i);
                            view.setX(x);
                            view.setY(y);


                        }

//                        view = viewMap.get(id);
//                        view.setX(x);
//                        view.setY(y);

//                        float xV = velocityTracker.getXVelocity();
//                        float yV = velocityTracker.getYVelocity();
//
//                        Log.i("Velocity ","X: " + xV + " Y: " + yV);



                        return true;

                    case MotionEvent.ACTION_POINTER_UP:
                    case MotionEvent.ACTION_UP:

                        view = viewMap.get(id);
                        root.removeView(view);
                        viewMap.remove(id);
//                        velocityTracker.addMovement(event);
//                        velocityTracker.clear();

                        return true;

                }


                return false;
            }
        });


    }

    @Override
    public boolean onDown(MotionEvent e) {
        Log.i("Gesture ","Down");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Log.i("Gesture ","Show Press");

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.i("Gesture ","Single Tap");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.i("Gesture ","Scroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Log.i("Gesture ","Long Press");

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.i("Gesture ","Fling");
        return true;
    }
}
