package bz.sunlight.store.myserachview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/11/10.
 */
public class CameraAdapter extends BaseAdapter {
    private List<Bean> beans;
    private LayoutInflater inflater;

    public CameraAdapter(Context mContext,List<Bean> beans) {
        this.beans = beans;
        this.inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return beans.size();
    }

    @Override
    public Object getItem(int i) {
        return beans.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHodler hodler;
        if (view == null){
            view = inflater.inflate(R.layout.list_item,viewGroup,false);
            hodler = new ViewHodler();
            hodler.nametv = (TextView) view.findViewById(R.id.name);
            hodler.numbertv = (TextView) view.findViewById(R.id.number);
            hodler.stornametv = (TextView) view.findViewById(R.id.storname);
            view.setTag(hodler);
        }else {
           hodler = (ViewHodler) view.getTag();
        }
        Bean bean = beans.get(i);
        hodler.nametv.setText(bean.getName());
        hodler.numbertv.setText(bean.getNumber());
        hodler.stornametv.setText(bean.getStorName());
        return view;
    }

    static class ViewHodler{
        TextView nametv;
        TextView numbertv;
        TextView stornametv;

    }
}
