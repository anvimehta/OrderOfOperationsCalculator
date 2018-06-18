package edu.purdue.mehta109.trialanderror;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.purdue.mehta109.trialanderror.Model.AbstractEquationModel;

public class HistoryListAdapter extends RecyclerView.Adapter<HistoryListAdapter.MyViewHolder> {

    private List<AbstractEquationModel> mEquationModelList;

    public HistoryListAdapter(List<AbstractEquationModel> mEquationModelList) {
        this.mEquationModelList = mEquationModelList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_history, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if (mEquationModelList.size() > 0) {
            holder.mTextViewId.setText(mEquationModelList.get(position).getNumberID() + "");
            holder.mTextViewEquation.setText(mEquationModelList.get(position).getEquation());
            holder.mTextViewAnswer.setText(mEquationModelList.get(position).getAnswer());
        }
    }

    @Override
    public int getItemCount() {
        return mEquationModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.equationID)
        protected TextView mTextViewId;

        @BindView(R.id.equation)
        protected TextView mTextViewEquation;

        @BindView(R.id.answer)
        protected TextView mTextViewAnswer;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
