package bz.sunlight.store.myserachview;

import android.app.SearchManager;
import android.content.Context;
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
public class SearchViewTestActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> adapter;
//    private MyAdapter adapter;
    private List<String> lists =new ArrayList<>();
    private List<String>  searchResult = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_view);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        assert toolbar != null;
        toolbar.setTitle("实时搜索");
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        for (int i = 0; i <100 ; i++) {
            lists.add(i+"");
        }
        searchResult.clear();
        searchResult.addAll(lists);
        listView = (ListView) findViewById(R.id.list_view);
//         adapter = new MyAdapter(this,-1);
         adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,searchResult);
        listView.setAdapter(adapter);
//        adapter.updateDataSource(lists);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);
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
                for (int i = 0; i <lists.size() ; i++) {
                    if (lists.get(i).contains(newText))
                        searchResult.add(lists.get(i));

                }
                adapter.notifyDataSetChanged();
//                adapter.updateDataSource(searchResult);
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
