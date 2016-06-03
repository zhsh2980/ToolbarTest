package com.zhangshan.guibai.toolbartest;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends BaseActivity {
    private int menu_id = R.menu.menu_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View customLayoutInToolbar = View.inflate(this, R.layout.custom_layout_in_toolbar, null);
        getToolbar().setDisplayHomeAsUpEnabled(false)
                //***************   如何让 title 居中 ??  ***********
                // 办法  :  第一步 setTitle("")  第二步 setCustomView(view)  搞定收工
                .setTitle(R.string.app_name)
                //.setSubTitle("subTitle")
                .setNavigationIcon(R.mipmap.ic_launcher)
                .setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "heheda", Toast.LENGTH_LONG).show();
                    }
                });
        //.setCustomView(customLayoutInToolbar);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (menu_id == -1) {
            menu.clear();
        } else {
            getMenuInflater().inflate(menu_id, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_one:
                Toast.makeText(MainActivity.this, "点了第一个菜单", Toast.LENGTH_LONG).show();
                break;
            case R.id.action_two:
                Toast.makeText(MainActivity.this, "点了第二个菜单", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
        return true;

    }

}
