package gitapp.forkthecode.com.motionandgesture;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by ralph on 28/10/17.
 */

public class CustomImageView extends AppCompatImageView {

    String message;

    public CustomImageView(Context context) {
        super(context);
    }

    public CustomImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        this.invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(message != null){
            Paint paint = new Paint();
            paint.setColor(Color.BLACK);
            paint.setTextSize(128);
            canvas.drawText(message,0,128,paint);
        }

    }
}
