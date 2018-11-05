package com.swc.swc;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<String> names;
    private ArrayList<String> posi;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public LinearLayout LL;
        public TextView myTextView;
        public TextView myTextView_pos;
        public MyViewHolder(LinearLayout v, TextView t, TextView p) {
            super(v);
            LL = v;
            myTextView = t;
            myTextView_pos = p;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<String> names, ArrayList<String> posi) {
        this.names = names;
        this.posi = posi;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_frag_list, parent, false);

        TextView name = (TextView)v.findViewById(R.id.name_textView);
        TextView pos = (TextView)v.findViewById(R.id.position);

        MyViewHolder vh = new MyViewHolder(v, name, pos);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element


        holder.myTextView.setText(names.get(position));
        holder.myTextView_pos.setText(posi.get(position));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return names.size();
    }
}