package com.example.configwork;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ContentAdapter extends BaseAdapter implements OnLongClick,OnClick {
    List<ContentList> items;
    LayoutInflater inflaiter;
    Context context;

    public ContentAdapter(Context ctx,List<ContentList> items){
        this.context=ctx;
        this.items=items;
        inflaiter= (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        View view=convertView;

        if(view==null){
            view=inflaiter.inflate(R.layout.item_list_view,parent,false);
        }

        ContentList contentList=items.get(position);

        ImageView image=view.findViewById(R.id.itemImage);
        TextView heading=view.findViewById(R.id.heading);
        TextView body=view.findViewById(R.id.body);
        Button btnDelete=view.findViewById(R.id.btnDelete);

        final int pos=position;
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnClick(pos);
            }
        });
        btnDelete.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                OnLongClick(items.get(pos).getHeading(),parent);
                return false;
            }
        });
        image.setImageDrawable(contentList.getItemImage());
        heading.setText(contentList.getHeading());
        body.setText(contentList.getBody());

        return view;
    }

    @Override
    public void OnClick(int position) {
        items.remove(position);
        this.notifyDataSetChanged();
    }

    @Override
    public void OnLongClick(String title, ViewGroup parent) {
        Toast.makeText(parent.getContext(),title,Toast.LENGTH_LONG).show();
    }
}
