package cn.tacitech.roundedprogressbarmodule;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

public class RoundedProgressBar extends View {

    private float roundedRadius = -1;
    private int progress = 0;
    private int barBackgroundColor = 0;
    private int barProgressColor = 0;
    private int drawingDirection = 0;

    private Paint mPaint;
    private Path mPath;

    public RoundedProgressBar(Context context) {
        this(context, null);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPath = new Path();
    }

    public RoundedProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPath = new Path();
    }

    public RoundedProgressBar(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        readAttributes(attrs);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPath = new Path();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(roundedRadius < 0f || roundedRadius > canvas.getWidth() / 2f || roundedRadius > canvas.getHeight() / 2f){
            roundedRadius = (canvas.getWidth() > canvas.getHeight()) ? canvas.getHeight() / 2f : canvas.getWidth() / 2f;
        }

        if(barBackgroundColor == 0){
            barBackgroundColor = Color.WHITE;
        }

        if(barProgressColor == 0){
            barProgressColor = Color.BLACK;
        }

        // TODO 报错
        if(progress < 0 || progress > 100){
            progress = 0;
        }

        // 横向绘制
        if(drawingDirection == DrawingDirection.HORIZONTAL) {
            // 绘制背景
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(barBackgroundColor);
            RectF rectF_background = new RectF(0, 0, canvas.getWidth(), canvas.getHeight());
            canvas.drawRoundRect(rectF_background, roundedRadius, roundedRadius, mPaint);

            mPath.addRoundRect(rectF_background, roundedRadius, roundedRadius,
                    Path.Direction.CW);
            canvas.clipPath(mPath, Region.Op.INTERSECT);

            // 绘制进度
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(barProgressColor);
            RectF rectF_progress = new RectF(roundedRadius * -2f, 0,
                    canvas.getWidth() * progress / 100, canvas.getHeight());
            canvas.drawRoundRect(rectF_progress, roundedRadius, roundedRadius, mPaint);
        }

        if(drawingDirection == DrawingDirection.VERTICAL){
            // 绘制背景
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(barBackgroundColor);
            RectF rectF_background = new RectF(0, 0, canvas.getWidth(), canvas.getHeight());
            canvas.drawRoundRect(rectF_background, roundedRadius, roundedRadius, mPaint);

            mPath.addRoundRect(rectF_background, roundedRadius, roundedRadius,
                    Path.Direction.CW);
            canvas.clipPath(mPath, Region.Op.INTERSECT);

            // 绘制进度
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(barProgressColor);
            RectF rectF_progress = new RectF(0, canvas.getHeight() * (100 - progress) / 100,
                    canvas.getWidth(), canvas.getHeight() + roundedRadius * 2f);
            canvas.drawRoundRect(rectF_progress, roundedRadius, roundedRadius, mPaint);
        }
    }

    private void readAttributes(AttributeSet attributeSet) {
        TypedArray attrs = getContext().obtainStyledAttributes(attributeSet, R.styleable.RoundedProgressBar);

        try {
            roundedRadius =
                    attrs.getDimension(R.styleable.RoundedProgressBar_roundedRadius, -1f);
            progress =
                    attrs.getInt(R.styleable.RoundedProgressBar_progress, -1);
            barBackgroundColor =
                    attrs.getColor(R.styleable.RoundedProgressBar_barBackgroundColor, 0);
            barProgressColor =
                    attrs.getColor(R.styleable.RoundedProgressBar_barProgressColor, 0);
            drawingDirection =
                    attrs.getInt(R.styleable.RoundedProgressBar_drawingDirection, 0);
        } finally {
            attrs.recycle();
        }
    }

    public void setProgress(int progress){
        this.progress = progress;
        invalidate();
    }

    /**
     * 单位为dp
     * @param radius
     */
    public void setRoundedRadius(int radius){
        this.roundedRadius = dpToPixel(radius);
        invalidate();
    }

    public void setBarBackgroundColor(int color){
        this.barBackgroundColor = color;
        invalidate();
    }

    public void setBarProgressColor(int color){
        this.barProgressColor = color;
        invalidate();
    }

    public void setDrawingDirection(int value){
        this.drawingDirection = value;
        invalidate();
    }

    private float dpToPixel(float dpValue) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpValue, getResources().getDisplayMetrics());
    }

    /**
     * 方向变量预设类
     */
    public class DrawingDirection{
        public static final int HORIZONTAL = 0;
        public static final int VERTICAL = 1;
    }

}
