package com.huawei.androidsix;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderRelativeLayout extends RelativeLayout {
    private static String TAG = "SliderRelativeLayout";

    private TextView tv_slider_icon = null; //

    private Bitmap dragBitmap = null; //
    private Context mContext = null; //


    private Handler mainHandler = null; //

    public SliderRelativeLayout(Context context) {
        super(context);
        mContext = context;
        initDragBitmap();
    }

    public SliderRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        mContext = context;
        initDragBitmap();
    }

    public SliderRelativeLayout(Context context, AttributeSet attrs,
                                int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        initDragBitmap();
    }


    private void initDragBitmap() {
        if (dragBitmap == null)
            dragBitmap = BitmapFactory.decodeResource(mContext.getResources(),
                    R.drawable.getup_slider_ico_pressed);
    }

    @Override
    protected void onFinishInflate() {
        // TODO Auto-generated method stub
        super.onFinishInflate();
        tv_slider_icon = (TextView) findViewById(R.id.slider_icon);
    }

    private int mLastMoveX = 10000;

    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        Log.i(TAG, "onTouchEvent" + " X is " + x + " Y is " + y);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastMoveX = x + (dragBitmap.getWidth() / 2);
                return handleActionDownEvenet(event);
            case MotionEvent.ACTION_MOVE:

                mLastMoveX = x + (dragBitmap.getWidth() / 2);
                if (x + (dragBitmap.getWidth() / 2) >= getWidth()) {
//                    handleActionUpEvent(event);
                } else {
                    invalidate();
                }

                return true;
            case MotionEvent.ACTION_UP:
                handleActionUpEvent(event);
                return true;
        }
        return super.onTouchEvent(event);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        invalidateDragImg(canvas);
    }

    private void invalidateDragImg(Canvas canvas) {
        int drawXCor = mLastMoveX - dragBitmap.getWidth();
        int drawYCor = tv_slider_icon.getTop();
        Log.i(TAG, "invalidateDragImg" + " drawXCor " + drawXCor + " and drawYCor" + drawYCor);
        canvas.drawBitmap(dragBitmap, drawXCor < 0 ? 5 : drawXCor, drawYCor, null);
    }

    private boolean handleActionDownEvenet(MotionEvent event) {
        Rect rect = new Rect();
        tv_slider_icon.getHitRect(rect);
        boolean isHit = rect.contains((int) event.getX(), (int) event.getY());
        if (isHit)
            tv_slider_icon.setVisibility(View.INVISIBLE);
        return isHit;
    }


    private void handleActionUpEvent(MotionEvent event) {
        int x = (int) event.getX();
        if (x + dragBitmap.getWidth() / 2 > getWidth() / 1.5) {//如果超过1.5就直接解锁
            mLastMoveX = getWidth();
            invalidate();
            mainHandler.obtainMessage(SlidLockActivity.MSG_LOCK_SUCESS).sendToTarget();
        } else {
            if (x + dragBitmap.getWidth() / 2 >= getWidth()) {//如果到达了底部解锁
                resetViewState();
                mainHandler.obtainMessage(SlidLockActivity.MSG_LOCK_SUCESS).sendToTarget();
            } else {
                resetViewState();
            }
        }
    }

    private void resetViewState() {
        mLastMoveX = 10000;
        tv_slider_icon.setVisibility(View.VISIBLE);
        invalidate();
    }


    public void setMainHandler(Handler handler) {
        mainHandler = handler;
    }

}
