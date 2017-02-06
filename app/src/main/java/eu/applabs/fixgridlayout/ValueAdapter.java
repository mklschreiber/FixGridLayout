package eu.applabs.fixgridlayout;

import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class ValueAdapter extends RecyclerView.Adapter<ValueAdapter.MyViewHolder> {

    private static final String TAG = "ValueAdapter";

    private List<String> mValueList;
    private GridLayoutManager mGridLayoutManager;

    public ValueAdapter(List<String> valueList, GridLayoutManager gridLayoutManager) {
        mValueList = valueList;
        mGridLayoutManager = gridLayoutManager;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_value, parent, false);
        float rowCount = mValueList.size() / (float) mGridLayoutManager.getSpanCount();
        float roundedCount = Math.round(rowCount);

        int calculatedRowCount = (int) (rowCount > roundedCount ? ++rowCount : roundedCount);

        view.getLayoutParams().height = parent.getMeasuredHeight() / calculatedRowCount;

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        holder.mLinearLayout.setBackgroundColor(color);
        holder.mTextView.setText(mValueList.get(position));
    }

    @Override
    public int getItemCount() {
        return mValueList != null ? mValueList.size() : 0;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout mLinearLayout;
        private TextView mTextView;

        public MyViewHolder(View itemView) {
            super(itemView);

            mLinearLayout = (LinearLayout) itemView.findViewById(R.id.llValue);
            mTextView = (TextView) itemView.findViewById(R.id.tvValue);
        }
    }

}
