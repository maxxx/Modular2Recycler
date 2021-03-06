package com.cuttingedge.PokeApp.BillsPC;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by Robbe Sneyders
 *
 * This class generates a square cell in a gridview
 */
public class GridViewItem extends androidx.appcompat.widget.AppCompatImageView {

    public GridViewItem(Context context) {
        super(context);
    }

    public GridViewItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GridViewItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //noinspection SuspiciousNameCombination
        super.onMeasure(widthMeasureSpec, widthMeasureSpec); // Set height equal to width
    }
}
