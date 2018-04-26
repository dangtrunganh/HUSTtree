package com.dt.anh.husttree;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dt.anh.husttree.model.User;
import com.dt.anh.husttree.utils.Constant;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = LoginActivity.class.getName();
    public static final String TRANSFER_USER = "TRANSFER_USER";
    private Button btnLogin;

    private TextInputEditText edtUsername;
    private TextInputEditText edtPassword;
    private ArrayList<User> arrUser;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prepareData();
        setContentView(R.layout.activity_login);
        initViews();

        readListAccount();
    }

    private void readListAccount() {
        mDatabase.child("users").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                User user = dataSnapshot.getValue(User.class);
                String id = dataSnapshot.getKey();
                if (id != null) {
                    user.setId(id);
                } else {
                    user.setId("");
                }
                arrUser.add(user);
//                Log.e(TAG, arrUser.toString());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
//        DatabaseReference myRef = database.getReference("message");
//
//        myRef.setValue("Hello, World!");

    }

    private void prepareData() {
        arrUser = new ArrayList<>();
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    private void initViews() {
        btnLogin = (Button) findViewById(R.id.btn_server_login);
        edtUsername = (TextInputEditText) findViewById(R.id.edt_username);
        edtPassword = (TextInputEditText) findViewById(R.id.edt_password);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_server_login:
                if (!checkField()) {
                    return;
                } else {
                    login();
                }
                break;
            default:
                break;
        }
    }

    private void login() {
        hideKeyboard();
        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();

        for (int i = 0; i < arrUser.size(); i++) {
            User user = arrUser.get(i);
            if (user.getName().equals(username) && user.getMat_khau().equals(password)) {
                if (!user.getRole().equals(Constant.ROLE_ADMIN)) {
                    Toast.makeText(this, "Please use account admin to login", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(this, "Login successfully", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Welcome " + username, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putParcelable(TRANSFER_USER, user);
                intent.putExtras(bundle);
                intent.setClass(this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }

        showSnackBar("Username or Password is not correct");
    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private void showSnackBar(String message) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
                message, Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView
                .findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, R.color.white));
        snackbar.show();
    }

    private boolean checkField() {
        String usernameCheckField = edtUsername.getText().toString();
        String passCheckField = edtPassword.getText().toString();
        if(usernameCheckField.equals("")) {
            showSnackBar("Please provide a non empty username");
            return false;
        } else if(passCheckField.isEmpty()) {
            Toast.makeText(this, "Please provide a non empty password", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
