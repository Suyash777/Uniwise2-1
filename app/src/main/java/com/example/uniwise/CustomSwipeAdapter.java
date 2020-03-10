package com.example.uniwise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;

public class CustomSwipeAdapter extends PagerAdapter {
    private int[] image_resource = {R.drawable.gpp1, R.drawable.gpp2, R.drawable.gpp3, R.drawable.gpp4,R.drawable.gpp4,R.drawable.gpp5,R.drawable.gpp6};
    private Context ctx;
    private LayoutInflater layoutInflater;

    public CustomSwipeAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return image_resource.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.swipe_layout,container,false);
        ImageView imageview = (ImageView) item_view.findViewById(R.id.image_view);
        TextView textView = (TextView)  item_view.findViewById(R.id.image_count);
        imageview.setImageResource(image_resource[position]);
        textView.setText("" + position);
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
