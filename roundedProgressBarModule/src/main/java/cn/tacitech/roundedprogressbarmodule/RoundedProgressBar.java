package cn.tacitech.roundedprogressbarmodule;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

public class RoundedProgressBar extends View {

    private int roundedRadius = -1;
    private int progress = 0;
    private int barBackgroundColor = -1;
    private int barProgressColor = -1;
    private int drawingDirection = 0;

    private Paint mPaint;

    public RoundedProgressBar(Context context) {
        this(context, null);
    }

    public RoundedProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundedProgressBar(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        readAttributes(attrs);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(roundedRadius < 0 || roundedRadius > canvas.getWidth() / 2 || roundedRadius > canvas.getHeight() / 2){
            roundedRadius = (canvas.getWidth() > canvas.getHeight()) ? canvas.getHeight() / 2 : canvas.getWidth() / 2;
        }

        if(barBackgroundColor == -1){
            barBackgroundColor = Color.WHITE;
        }

        if(barProgressColor == -1){
            barProgressColor = Color.BLACK;
        }

        // TODO 报错
        if(progress < 0 || progress > 100){
            progress = 0;
        }

        // 横向绘制
        if(drawingDirection == DrawingDirection.HORIZONTAL) {
            int startPointX = roundedRadius;
            int startPointY = roundedRadius;
            int endPointBackgroundX = canvas.getWidth() - roundedRadius;
            int endPointProgressX = (canvas.getWidth() - roundedRadius * 2) * progress / 100 + roundedRadius;
            int endPointY = roundedRadius;

            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setStrokeCap(Paint.Cap.ROUND);
            mPaint.setColor(barBackgroundColor);
            mPaint.setStrokeWidth(roundedRadius * 2);

            // 绘制背景
            canvas.drawLine(startPointX, startPointY, endPointBackgroundX, endPointY, mPaint);

            // 绘制进度
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setStrokeCap(Paint.Cap.ROUND);
            mPaint.setColor(barProgressColor);
            mPaint.setStrokeWidth(roundedRadius * 2);
            canvas.drawLine(startPointX, startPointY, endPointProgressX, endPointY, mPaint);
        }

        if(drawingDirection == DrawingDirection.VERTICAL){
            int startPointX = roundedRadius;
            int startPointY = canvas.getHeight() - roundedRadius;
            int endPointX = roundedRadius;
            int endPointBackgroundY = roundedRadius;
            int endPointProgressY = (canvas.getHeight() - roundedRadius * 2) * (100 - progress) / 100 + roundedRadius;

            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setStrokeCap(Paint.Cap.ROUND);
            mPaint.setColor(barBackgroundColor);
            mPaint.setStrokeWidth(roundedRadius * 2);

            // 绘制背景
            canvas.drawLine(startPointX, startPointY, endPointX, endPointBackgroundY, mPaint);

            // 绘制进度
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setStrokeCap(Paint.Cap.ROUND);
            mPaint.setColor(barProgressColor);
            mPaint.setStrokeWidth(roundedRadius * 2);
            canvas.drawLine(startPointX, startPointY, endPointX, endPointProgressY, mPaint);
        }
    }

    private void readAttributes(AttributeSet attributeSet) {
        TypedArray attrs = getContext().obtainStyledAttributes(attributeSet, R.styleable.RoundedProgressBar);

        try {
            roundedRadius =
                    attrs.getInt(R.styleable.RoundedProgressBar_roundedRadius, -1);
            progress =
                    attrs.getInt(R.styleable.RoundedProgressBar_progress, -1);
            barBackgroundColor =
                    attrs.getInt(R.styleable.RoundedProgressBar_barBackgroundColor, -1);
            barProgressColor =
                    attrs.getInt(R.styleable.RoundedProgressBar_barProgressColor, -1);
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
        this.roundedRadius = (int) dpToPixel(radius);
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
