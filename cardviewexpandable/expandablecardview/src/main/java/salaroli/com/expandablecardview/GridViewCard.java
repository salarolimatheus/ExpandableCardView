package salaroli.com.expandablecardview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public class GridViewCard extends GridView {
    public GridViewCard(Context context) {
        super(context);
    }

    public GridViewCard(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GridViewCard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public GridViewCard(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int heightSpec;

        // The great Android "hackatlon" (in order to enable "wrap_content" on grid views).
        if (getLayoutParams().height == LayoutParams.WRAP_CONTENT) {
            heightSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        }
        else {
            heightSpec = heightMeasureSpec;
        }

        super.onMeasure(widthMeasureSpec, heightSpec);
    }
}
