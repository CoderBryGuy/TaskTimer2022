package com.example.tasktimer2022;

import android.database.Cursor;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class CursorRecyclerViewAdapter extends RecyclerView.Adapter<CursorRecyclerViewAdapter.TaskViewHolder> {
    private static final String TAG = "CursorRecyclerViewAdapt";
    private Cursor mCursor;

    public CursorRecyclerViewAdapter(Cursor cursor) {
        Log.d(TAG, "CursorViewAdapter: constructor called");
        mCursor = cursor;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: new view requested");

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_list_items, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: starts");

        if((mCursor == null) || (mCursor.getCount() == 0)){
            Log.d(TAG, "onBindViewHolder: providing instructions");
            holder.name.setText(R.string.tli_name_null_text);
            holder.description.setText(R.string.tli_description_null_text);
            holder.editButton.setVisibility(View.GONE);
            holder.deleteButton.setVisibility(View.GONE);
        }else{
            if(!mCursor.moveToPosition(position)){
                throw new IllegalStateException("Couldn't move cursor to position " + position);
            }
            holder.name.setText(mCursor.getColumnIndex(TasksContract.Columns.TASKS_NAME));
            holder.description.setText(mCursor.getColumnIndex(TasksContract.Columns.TASKS_DESCRIPTION));
            holder.editButton.setVisibility(View.VISIBLE); //TODO add onclick listener
            holder.deleteButton.setVisibility(View.VISIBLE); //TODO add onclick listener
        }

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: started");
        if((mCursor == null) || (mCursor.getCount() == 0)){
            return 1;
        }else {
            return mCursor.getCount();
        }
    }
    /**
     * Swap in a new cursor, return the older cursor
     * The returned old cursor is NOT closed.
     *
     * @param newCursor the new cursor to be used
     * @return returns the previously used cursor, or null if there wasn't one
     * If the given new cursor is teh same instance as the previously set Cursor, null is also returned
     */
    Cursor swapCursor(Cursor newCursor){
            if(newCursor == mCursor){
                return null;
            }

            final Cursor oldCursor = mCursor;
            mCursor = newCursor;
            if(newCursor != null){
                //notify the observers abut the new cursor
                notifyDataSetChanged();
            }else {
                //notify the observers abut the lack of a data set
                notifyItemRangeRemoved(0, getItemCount());
            }
            return oldCursor;
    }

    static class TaskViewHolder extends RecyclerView.ViewHolder{
        private static final String TAG = "TaskViewHolder";

        TextView name = null;
        TextView description = null;
        ImageButton editButton = null;
        ImageButton deleteButton = null;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.d(TAG, "TaskViewHolder: starts");

            this.name = (TextView)itemView.findViewById(R.id.tli_name);
            this.description = (TextView)itemView.findViewById(R.id.tli_description);
            this.editButton = (ImageButton) itemView.findViewById(R.id.tli_edit);
            this.deleteButton = (ImageButton) itemView.findViewById(R.id.tli_delete);

        }
    }

}
