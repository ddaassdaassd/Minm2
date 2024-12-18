package com.example.robacobres_androidclient;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.robacobres_androidclient.models.User;
import com.example.robacobres_androidclient.services.ServiceBBDD;

public class SeeMyDataActivity extends AppCompatActivity {
//    EditText actualPassword;
//    EditText newPassword1;
//    EditText newPassword2;
    private Context context;
    ServiceBBDD service;
    User user;
    EditText userName;
    EditText userCorreo;
    EditText userCobre;
    EditText userMoney;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_my_data);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        context=SeeMyDataActivity.this;
        service = ServiceBBDD.getInstance(context);
        user = (User) getIntent().getSerializableExtra("userInfo");
        progressBar = findViewById(R.id.progressBar);

        userName=findViewById(R.id.NameText);
        userCorreo=findViewById(R.id.CorreoText);
        userCobre=findViewById(R.id.MoneyText);
        userMoney=findViewById(R.id.CobreText);

        userName.setText("Name: "+user.getName());
        userCorreo.setText("Correo: "+user.getCorreo());
        userCobre.setText("Cobre: "+String.valueOf(user.getCobre()));
        userMoney.setText("Money: "+String.valueOf(user.getMoney()));
    }


    public void onClickChangePassword(View V){
        Intent intent = new Intent(context, ChangePasswordActivity.class);
        context.startActivity(intent);
    }

    public void onClickChangeCorreo(View V){
        Intent intent = new Intent(context, ChangeCorreoActivity.class);
        intent.putExtra("correo",user.getCorreo());
        context.startActivity(intent);
    }

    public void onClickClose(View V){
        this.finish();
    }
}
