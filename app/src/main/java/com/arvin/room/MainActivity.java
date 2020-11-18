package com.arvin.room;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.arvin.room.database.MyDataBase;
import com.arvin.room.entity.UserModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.input_et)
    EditText inputET;
    @BindView(R.id.result_tv)
    TextView resultTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.set_btn)
    void setUser() {
        String name = inputET.getText().toString();
        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setAddress("山东青岛");
        userModel.setAge(99);
        userModel.setPhone("15006512345");
        MyDataBase.getInstance(this).userDao().insertUser(userModel);
    }

    @OnClick(R.id.get_btn)
    void getUser(View v) {
        List<UserModel> users = MyDataBase.getInstance(this).userDao().getAllUsers();
        if (users != null && users.size() > 0) {
            resultTV.setText(users.get(0).getName());
        }
    }
}