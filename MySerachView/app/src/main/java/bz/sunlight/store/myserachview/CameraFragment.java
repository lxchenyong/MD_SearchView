package bz.sunlight.store.myserachview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/10.
 */
public class CameraFragment extends Fragment {

    private List<Bean> beanList = new ArrayList<>();
    private CameraAdapter adapter;
    private ListView listView;

    public ListView getListView() {
        return listView;
    }

    private void initData(){
        beanList.clear();
        beanList.add(new Bean("ABCDEFG","QWERTYU436","蝴蝶飞回"));
        beanList.add(new Bean("ASDFGHGFT","4TGHGDFH","个人热议话题 "));
        beanList.add(new Bean("ADSFG444","4T543GDFG","因人而异"));
        beanList.add(new Bean("ABVETRWT","TWT252FDE","tewtew t") );
        beanList.add(new Bean("QDASFFFG","3RFEWSFEW","因人而异热"));
        beanList.add(new Bean("FDESFEW","656324TGRE","广东人风格"));
        beanList.add(new Bean("DSGWREGWR","436TERG3","供热团购网"));
        beanList.add(new Bean("EWTDETREYTRE","RTRE34634","天热太热"));
        beanList.add(new Bean("TRETY4TY4","654624WT34","日夜炎热"));
        beanList.add(new Bean("QQRTQT3RWET","436TGFDTE","幼儿园热"));
        beanList.add(new Bean("GRYRE REYRE","436TGFDTE","幼儿园热"));
        beanList.add(new Bean("EYREYER ","436TGFDTE","幼儿园热"));
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.camera,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        listView = (ListView) view.findViewById(R.id.listview);
        adapter = new CameraAdapter(getActivity(),beanList);
        listView.setAdapter(adapter);
        listView.setTextFilterEnabled(true);//设置为可过滤的
    }
}
