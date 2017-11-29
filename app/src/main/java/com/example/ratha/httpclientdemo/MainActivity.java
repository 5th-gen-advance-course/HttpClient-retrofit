package com.example.ratha.httpclientdemo;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.ratha.httpclientdemo.repository.Knongdai;
import com.example.ratha.httpclientdemo.repository.network.ServiceGenerator;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Knongdai.CategoryService categoryService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.createServices();
    }

    private void createServices(){
        categoryService= ServiceGenerator.CreateService(Knongdai.CategoryService.class);
    }
    public void requestCategory() throws IOException {
        Call<JSONObject> call=categoryService.getCategories();
        call.enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                Log.e("response->","work");
                JSONObject body=response.body();
                try {
                    Log.e("message->", body.getString("msg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (null!=body){
                    try {
                        Log.e("message->", body.getString("msg"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<JSONObject> call, Throwable t) {
                Log.e("request category ->",t.toString());
            }
        });
    }

    public void onGetCategory(View view) {
        try {
            requestCategory();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
