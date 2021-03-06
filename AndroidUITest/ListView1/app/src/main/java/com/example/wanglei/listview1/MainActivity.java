package com.example.wanglei.listview1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list1 = (ListView)findViewById(R.id.list1);
        ListView list2 = (ListView)findViewById(R.id.list2);
        String[] arr1 = {"孙悟空","猪八戒","沙和尚"};
        //将数组封装成ArrayAdapter
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,R.layout.array_item,arr1);

        list1.setAdapter(adapter1);

        String[] arr2 = {"白骨精","黄风怪","牛魔王","红孩儿","金角","银角"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,R.layout.checked_item,arr2);
        list2.setAdapter(adapter2);

    }
}
