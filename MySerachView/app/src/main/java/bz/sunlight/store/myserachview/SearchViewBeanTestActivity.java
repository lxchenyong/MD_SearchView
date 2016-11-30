package bz.sunlight.store.myserachview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * SearchView 实时搜索
 * Created by Administrator on 2016/11/30.
 */
public class SearchViewBeanTestActivity extends AppCompatActivity {
    private ListView listView;
    private List<Bean> beanList = new ArrayList<>();
    private CameraAdapter adapter;
    private List<Bean> searchResult = new ArrayList<>();

    private void initData() {
        beanList.clear();
        beanList.add(new Bean("ABCDEFG", "12345545", "蝴蝶飞回"));
        beanList.add(new Bean("ASDFGHGFT", "32523454", "个人热议话题 "));
        beanList.add(new Bean("ADSFG444", "543545", "因人而异"));
        beanList.add(new Bean("ABVETRWT", "TWT252FDE", "tewtew t"));
        beanList.add(new Bean("QDASFFFG", "543513523", "因人而异热"));
        beanList.add(new Bean("FDESFEW", "656324TGRE", "广东人风格"));
        beanList.add(new Bean("DSGWREGWR", "436TERG3", "供热团购网"));
        beanList.add(new Bean("EWTDETREYTRE", "RTRE34634", "天热太热"));
        beanList.add(new Bean("TRETY4TY4", "654624WT34", "日夜炎热"));
        beanList.add(new Bean("QQRTQT3RWET", "436TGFDTE", "幼儿园热"));
        beanList.add(new Bean("GRYRE REYRE", "436TGFDTE", "幼儿园热"));
        beanList.add(new Bean("EYREYER ", "436TGFDTE", "幼儿园热"));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_view);
        initData();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        assert toolbar != null;
        toolbar.setTitle("实时搜索");
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        searchResult.clear();
        searchResult.addAll(beanList);
        listView = (ListView) findViewById(R.id.list_view);
        adapter = new CameraAdapter(this,searchResult);
        listView.setAdapter(adapter);
//        adapter.updateDataSource(lists);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView mSearchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(getApplicationContext(), "onQueryTextSubmit:" + query, Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                searchResult.clear();
                for (int i = 0; i < beanList.size(); i++) {
                    if (beanList.get(i).getNumber().contains(newText))
                        searchResult.add(beanList.get(i));

                }
                adapter.notifyDataSetChanged();
//                adapter.updateDataSource(searchResult);
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
