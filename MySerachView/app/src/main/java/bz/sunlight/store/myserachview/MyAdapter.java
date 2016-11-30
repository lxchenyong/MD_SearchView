package bz.sunlight.store.myserachview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/30.
 */
public class MyAdapter extends ArrayAdapter<String> {

    private LayoutInflater inflater;
    private List<String> data;

    public MyAdapter(Context context, int resource) {
        super(context, resource);
        inflater = LayoutInflater.from(context);
        data = new ArrayList<String>();
    }

    // 更新数据并notifyDataSetChanged
    public void updateDataSource(List<String> data) {
        this.data = data;
        this.notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = inflater.inflate(android.R.layout.simple_list_item_1, null);

        TextView text = (TextView) convertView.findViewById(android.R.id.text1);
        text.setText(getItem(position));

        return convertView;
    }

    @Override
    public String getItem(int pos) {
        return data.get(pos);
    }

    @Override
    public int getCount() {
        return data.size();
    }
}