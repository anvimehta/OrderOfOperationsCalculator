package edu.purdue.mehta109.trialanderror;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class CardAdapter {
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView equation;
        TextView answer;
        TextView ID;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.equation = (TextView) itemView.findViewById(R.id.equation);
            this.answer = (TextView) itemView.findViewById(R.id.answer);
            this.ID = (TextView) itemView.findViewById(R.id.equationID);
        }
    }
}
