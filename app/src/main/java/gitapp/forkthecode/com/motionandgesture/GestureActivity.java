package gitapp.forkthecode.com.motionandgesture;

import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class GestureActivity extends AppCompatActivity {

    GestureOverlayView gestureOverlayView;
    GestureLibrary library;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);

        gestureOverlayView = (GestureOverlayView)findViewById(R.id.gesture);
        library = GestureLibraries.fromRawResource(this,R.raw.gestures);
        library.load();

        gestureOverlayView.addOnGesturePerformedListener(new GestureOverlayView.OnGesturePerformedListener() {
            @Override
            public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
                ArrayList<Prediction> predictions = library.recognize(gesture);
                for(Prediction prediction:predictions){
                    Log.i("Gesture ",prediction.name + " " + prediction.score);
                }

                
            }
        });
    }
}
