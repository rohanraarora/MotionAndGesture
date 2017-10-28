package gitapp.forkthecode.com.motionandgesture;

import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class GraphicActivity extends AppCompatActivity {

    Button button;
    CustomImageView imageView;
    int level = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_graphic);

        button = (Button)findViewById(R.id.button);
        imageView = (CustomImageView) findViewById(R.id.imageButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                level += 1000;
//                ClipDrawable clipDrawable =(ClipDrawable) imageView.getDrawable();
//                clipDrawable.setLevel(level);
//                TransitionDrawable drawable = (TransitionDrawable) imageView.getDrawable();
//                drawable.setCrossFadeEnabled(true);
//                drawable.startTransition(1000);

//                Animation animation = AnimationUtils.loadAnimation(GraphicActivity.this,R.anim.alpha);

                Animation animation = new AlphaAnimation(0,1);
                animation.setDuration(1000);
                imageView.startAnimation(animation);
                //Animation animation = AnimationUtils.loadAnimation(GraphicActivity.this,R.anim.rotate);

//                animation.setRepeatCount(2);
//                animation.setRepeatMode(Animation.REVERSE);

//                animation.setAnimationListener(new Animation.AnimationListener() {
//                    @Override
//                    public void onAnimationStart(Animation animation) {
//
//                    }
//
//                    @Override
//                    public void onAnimationEnd(Animation animation) {
//
//                    }
//
//                    @Override
//                    public void onAnimationRepeat(Animation animation) {
//
//                    }
//                });
                //button.startAnimation(animation);

                imageView.setMessage("Hello");
                imageView.invalidate();

            }
        });
    }
}
