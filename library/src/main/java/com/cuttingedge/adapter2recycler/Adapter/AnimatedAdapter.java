package com.cuttingedge.adapter2recycler.Adapter;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.recyclerview.widget.ItemTouchHelper;

/**
 * Created by Robbe Sneyders
 *
 * Base adapter class with all code for the animation of views.
 */
@SuppressWarnings("WeakerAccess")
public abstract class AnimatedAdapter<VH extends ViewHolder> extends Adapter<VH> {

    protected ItemTouchHelper.Callback itemTouchHelperCallback;

    public AnimatedAdapter(@Nullable ItemTouchHelper.Callback itemTouchHelperCallback) {
        this.itemTouchHelperCallback = itemTouchHelperCallback;
    }

    public AnimatedAdapter(RecyclerView recyclerView, @Nullable ItemTouchHelper.Callback itemTouchHelperCallback) {
        this.itemTouchHelperCallback = itemTouchHelperCallback;
        if (itemTouchHelperCallback != null) {
            ItemTouchHelper mItemTouchHelper = new ItemTouchHelper(itemTouchHelperCallback);
            mItemTouchHelper.attachToRecyclerView(recyclerView);
        }
    }

    protected void attachToRecyclerView(RecyclerView recyclerView) {
        if (itemTouchHelperCallback != null) {
            ItemTouchHelper mItemTouchHelper = new ItemTouchHelper(itemTouchHelperCallback);
            mItemTouchHelper.attachToRecyclerView(recyclerView);
        }
    }


    /**
     * Get the directions in which the touched item can be swiped.
     *
     * @param position position of the touched item in the adapter.
     * @return enabled directions: flags ItemTouchHelper.LEFT or RIGHT.
     */
    protected abstract int getItemSwipeDirs(int position);


    /**
     * Is drag and drop enabled for the touched item?
     *
     * @param position position of the touched item in the adapter.
     * @return true if enabled, false otherwise.
     */
    protected abstract int getDragDirs(int position);


    /**
     * Called while viewHolder is dragged.
     *
     * @param fromPosition current position of viewHolder in adapter.
     * @param toPosition position of viewHolder which place will be taken.
     * @return True if the viewHolder has been moved to target position in adapter.
     */
    protected abstract boolean onDrag(int fromPosition, int toPosition);


    /**
     * Called when item is swiped away
     * @param position position of item in adapter
     * @param swipeDir direction of swipe
     */
    protected abstract void onSwiped(int position, int swipeDir);
}
