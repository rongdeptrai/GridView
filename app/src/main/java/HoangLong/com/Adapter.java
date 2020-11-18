package HoangLong.com;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends ArrayAdapter {
    Activity activity;
    int row_layout;
    ArrayList<LS> lsArrayList;

    public Adapter(@NonNull Activity activity, int row_layout, @NonNull ArrayList<LS> lsArrayList) {
        super(activity, row_layout, lsArrayList);
         this.activity=activity;
         this.row_layout=row_layout;
         this.lsArrayList=lsArrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=activity.getLayoutInflater();
        convertView=layoutInflater.inflate(row_layout,null);
        ImageView avata=(ImageView) convertView.findViewById(R.id.image);
        TextView title=(TextView) convertView.findViewById(R.id.tx);
        TextView des=(TextView) convertView.findViewById(R.id.ds) ;
        avata.setImageResource(lsArrayList.get(position).getImage());
        des.setText(lsArrayList.get(position).getDesciption());
        title.setText(lsArrayList.get(position).getTitle());
        return convertView;
    }
    public  void removeItem(List<LS> items){
        for(LS item: items ){
            lsArrayList.remove(item);
        }
        notifyDataSetChanged();
    }
}
