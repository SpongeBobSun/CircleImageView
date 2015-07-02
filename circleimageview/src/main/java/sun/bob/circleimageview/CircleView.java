package sun.bob.circleimageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by bobsun on 15-6-26.
 */
public class CircleView extends ImageView {
    BitmapShader shader;
    ShapeDrawable drawable;
    private String ATTR_TAG = "http://schemas.android.com/apk/res/android";
    private int width,height;
    private int defaultImgId;

    public CircleView(Context context){
        super(context);
        drawable = new ShapeDrawable(new OvalShape());
    }
    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        drawable = new ShapeDrawable(new OvalShape());
        defaultImgId = attrs.getAttributeResourceValue(ATTR_TAG, "src", -1);
    }

    @Override
    public void onDraw(Canvas canvas){
        if (defaultImgId > 0)
            setImageBitmap(BitmapFactory.decodeResource(getResources(),defaultImgId));
        drawable.draw(canvas);
    }

    @Override
    public void setImageBitmap(Bitmap bmp){
        this.defaultImgId = -1;
        super.setImageBitmap(bmp);
        shader = new BitmapShader(((BitmapDrawable) getDrawable()).getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        drawable.getPaint().setShader(shader);
        drawable.setBounds(0,0,width, height);
    }

    @Override
    protected void onMeasure(int measureWidthSpec,int measureHeightSpec){
        super.onMeasure(measureWidthSpec, measureHeightSpec);
        width = measureWidth(measureWidthSpec);
        height = measureHeight(measureHeightSpec);
        this.setMeasuredDimension(width, height);
    }

    private int measureWidth(int measureSpec) {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        int result = 0;
        if (specMode == MeasureSpec.AT_MOST) {
            result = getWidth();
        } else if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        }
        return result;
    }
    private int measureHeight(int measureSpec) {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        int result = 0;
        if (specMode == MeasureSpec.AT_MOST) {
            result = getWidth();
        } else if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        }
        return result;
    }
}
