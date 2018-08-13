package com.cozing.menupicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cozing.multipickerview.MultiPickerView;

import java.util.ArrayList;
import java.util.List;

/**
 * desc:multipickerlib demo
 * <p>
 * Author: Cozing
 * GitHub: https://github.com/Cozing
 * Date: 2018/8/6
 */
public class MainActivity extends AppCompatActivity {

    private List<String> lists1 = new ArrayList<>();
    private List<List<String>> lists2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button show_multipickerview = findViewById(R.id.show_multipickerview);
        show_multipickerview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMultiPickerView();
            }
        });

    }

    private void showMultiPickerView(){
        initDatas();

        MultiPickerView multiPickerView = new MultiPickerView(this);
        multiPickerView.setDoublePicker(lists1, lists2);
        multiPickerView.setOnMultiPickerSelectListener(new MultiPickerView.OnMultiPickerSelectListener() {
            @Override
            public void onSelect(int index1, int index2) {
                Toast.makeText(MainActivity.this, "么么哒~:" + lists1.get(index1) + ";" + lists2.get(index1).get(index2), Toast.LENGTH_SHORT).show();
            }
        });
        multiPickerView.setOnMultiPickerDismissListener(new MultiPickerView.OnMultiPickerDismissListener() {
            @Override
            public void onDismiss() {
                Toast.makeText(MainActivity.this, "dismiss listener", Toast.LENGTH_SHORT).show();
            }
        });
        multiPickerView.show();
    }

    private void initDatas(){
        for (int i = 0; i < 10; i++){
            lists1.add("第1级菜单" + i);

            List<String> item2List = new ArrayList<>();
            for(int k = 0; k < 10 ; k++){
                item2List.add("第1级中" + i + "的第" +k);
            }
            lists2.add(item2List);

        }


    }

}
