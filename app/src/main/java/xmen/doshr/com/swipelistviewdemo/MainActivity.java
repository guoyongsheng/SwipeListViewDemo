package xmen.doshr.com.swipelistviewdemo;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import java.util.ArrayList;
import java.util.List;

import xmen.doshr.com.adapter.TextAdapter;

public class MainActivity extends Activity
{
    private SwipeMenuListView listView;
    private float scale;
    private List<String> list;
    private TextAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    //初始化view
    private void initView()
    {
        scale = getResources().getDisplayMetrics().density;
        listView = (SwipeMenuListView) findViewById(R.id.listView);
        listView.setMenuCreator(createMenuCreator());

        adapter = new TextAdapter(getDataSource(), this);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new OnItemClickListView());
        listView.setOnMenuItemClickListener(new OnItemMenuClickListView());
    }

    //获取数据源
    private List<String> getDataSource()
    {
        list = new ArrayList<>();
        list.add("鸣人");
        list.add("佐助");
        list.add("小樱");
        list.add("卡卡西");
        list.add("鹿丸");
        list.add("井野");
        list.add("雏田");
        return list;
    }



    //创建SwipeMenuCreator
    private SwipeMenuCreator createMenuCreator()
    {
        SwipeMenuCreator swipeMenuCreator = new SwipeMenuCreator()
        {
            @Override
            public void create(SwipeMenu menu)
            {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(MainActivity.this);
                // set item background
                openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9, 0xCE)));
                // set item width
                openItem.setWidth(190);
                // set item title
                openItem.setTitle("编辑");
                // set item title fontsize
                openItem.setTitleSize(15);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);

                // create "delete" item
               // SwipeMenuItem deleteItem = new SwipeMenuItem(MainActivity.this);
                // set item background
               // deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9, 0x3F, 0x25)));
                // set item width
               // deleteItem.setWidth(190);
                // set a icon
               // deleteItem.setIcon(R.mipmap.ic_launcher);
                // add to menu
               // menu.addMenuItem(deleteItem);

                // create "open" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(MainActivity.this);
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9, 0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(190);
                // set item title
                deleteItem.setTitle("删除");
                // set item title fontsize
                deleteItem.setTitleSize(15);
                // set item title font color
                deleteItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };

        return swipeMenuCreator;
    }

    //内部类
    private final class OnItemClickListView implements AdapterView.OnItemClickListener
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            String value = list.get(position);
            Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
        }
    }

    //内部类
    private final class OnItemMenuClickListView implements SwipeMenuListView.OnMenuItemClickListener
    {

        @Override
        public boolean onMenuItemClick(int position, SwipeMenu menu, int index)
        {
            switch (index)
            {
            /**
             * 编辑
             */
            case 0:
                Toast.makeText(MainActivity.this, position + "编辑", Toast.LENGTH_SHORT).show();
                break;

            /**
             * 删除
             */
            case 1:
                Toast.makeText(MainActivity.this, position + "删除", Toast.LENGTH_SHORT).show();
                list.remove(position);
                adapter.notifyDataSetChanged();
                break;
            }
            return false;
        }
    }
}
