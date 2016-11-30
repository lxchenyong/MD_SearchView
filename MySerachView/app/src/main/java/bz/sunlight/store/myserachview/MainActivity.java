package bz.sunlight.store.myserachview;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private CameraFragment cameraFragment;
    private List<Bean> beanList = new ArrayList<>();
    private CameraAdapter adapter;
    private ListView listView;
    private List<String> strs = new ArrayList<>();

    private void initdata() {
        strs.add("1234567890");
        strs.add("1348769");
        strs.add("123456578");
        strs.add("564458498");
        strs.add("qqq5634634");
        strs.add("qq434tg");
    }

    ;

    private void initData() {
        beanList.clear();
        beanList.add(new Bean("ABCDEFG", "QWERTYU436", "蝴蝶飞回"));
        beanList.add(new Bean("ASDFGHGFT", "4TGHGDFH", "个人热议话题 "));
        beanList.add(new Bean("ADSFG444", "4T543GDFG", "因人而异"));
        beanList.add(new Bean("ABVETRWT", "TWT252FDE", "tewtew t"));
        beanList.add(new Bean("QDASFFFG", "3RFEWSFEW", "因人而异热"));
        beanList.add(new Bean("FDESFEW", "656324TGRE", "广东人风格"));
        beanList.add(new Bean("DSGWREGWR", "436TERG3", "供热团购网"));
        beanList.add(new Bean("EWTDETREYTRE", "RTRE34634", "天热太热"));
        beanList.add(new Bean("TRETY4TY4", "654624WT34", "日夜炎热"));
        beanList.add(new Bean("QQRTQT3RWET", "436TGFDTE", "幼儿园热"));
        beanList.add(new Bean("GRYRE REYRE", "436TGFDTE", "幼儿园热"));
        beanList.add(new Bean("EYREYER ", "436TGFDTE", "幼儿园热"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
//        initdata();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.listview);
        adapter = new CameraAdapter(this, beanList);
//        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,strs);

        listView.setAdapter(adapter);
        listView.setTextFilterEnabled(true);//设置为可过滤的

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);//
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);//加载searchview
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(MainActivity.this, "~~~" + newText, Toast.LENGTH_SHORT).show();
                if (TextUtils.isEmpty((newText))) {
                    listView.clearTextFilter();
                } else {
                    listView.setFilterText(newText);
                }
                return true;
            }
        });//为搜索框设置监听事件
//        searchView.setSubmitButtonEnabled(true);//设置是否显示搜索按钮
        searchView.setQueryHint("查找");//设置提示信息
//        searchView.setIconifiedByDefault(true);//设置搜索默认为图标
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
//            cameraFragment = new CameraFragment();
//            replaceFragment(cameraFragment, "Test");
        } else if (id == R.id.nav_gallery) {
            startActivity(new Intent(MainActivity.this, SearchViewTestActivity.class));
        } else if (id == R.id.nav_slideshow) {
            startActivity(new Intent(MainActivity.this, SearchViewBeanTestActivity.class));
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
//    private void replaceFragment(final Fragment newFragment, String title) {
//        getSupportActionBar().setTitle(title);
//        FragmentTransaction transaction =
//                getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.contentFragment, newFragment);
//        transaction.commit();
//    }
}
