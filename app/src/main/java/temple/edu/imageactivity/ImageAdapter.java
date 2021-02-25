package temple.edu.imageactivity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.util.Pair;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> items;
    int[] imageRes;

    //Create Constructor
    public ImageAdapter (Context context, ArrayList items, int[] imageRes){
      this.context = context;
      this.items = items;
      this.imageRes = imageRes;
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        //Pair<String, String> pair = new Pair(items.get(position),category.get(position));
        //return pair;
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout linearLayout;
        TextView catTextView;
        ImageView imageView;

        if(convertView == null){
            linearLayout = new LinearLayout(context);
            catTextView = new TextView(context);
            imageView = new ImageView(context);

            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            catTextView.setTextSize(22);
            catTextView.setPadding(8,8,0,8);

            linearLayout.addView(imageView);
            linearLayout.addView(catTextView);

            imageView.getLayoutParams().height = 150;
            imageView.getLayoutParams().width = 150;

        }else{
            linearLayout = (LinearLayout) convertView;
            imageView = (ImageView) linearLayout.getChildAt(0);
            catTextView = (TextView) linearLayout.getChildAt(1);
        }
        catTextView.setText(items.get(position));
        imageView.setImageResource(imageRes[position]);
        return linearLayout;
    }
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent){
        LinearLayout layout = (LinearLayout) getView(position, convertView, parent);

        return layout;
    }
}
