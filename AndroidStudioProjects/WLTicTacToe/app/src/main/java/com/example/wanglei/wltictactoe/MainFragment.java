package com.example.wanglei.wltictactoe;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wanglei on 15/12/24.
 */
public class MainFragment extends Fragment {
    private AlertDialog mDialog;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main,container,false);
        //在这里添加处理按钮的代码

        View aboutButton = rootView.findViewById(R.id.about_button);
        aboutButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.about_title);
                builder.setMessage(R.string.about_text);
                builder.setCancelable(false);
                builder.setPositiveButton(R.string.ok_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //确定方法  为空
                    }
                });
                mDialog = builder.show();
            }
        });
        return rootView;

    }

    @Override
    public void onPause(){
        super.onPause();

        if (mDialog != null){
            mDialog.dismiss();
        }
    }
}
