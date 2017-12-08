package com.example.ratha.httpclientdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.ratha.httpclientdemo.entity.CategoryCreate;
import com.example.ratha.httpclientdemo.entity.CategoryPostResponse;
import com.example.ratha.httpclientdemo.entity.CategoryResponse;
import com.example.ratha.httpclientdemo.entity.DeleteResponse;
import com.example.ratha.httpclientdemo.repository.api.CategoryService;
import com.example.ratha.httpclientdemo.repository.network.ServiceGeneratorRxAndroid;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Response;

public class CategoryActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<CategoryResponse.Category> list = new ArrayList<>();
    CategoryAdapter categoryAdapter;
    CategoryService categoryService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        recyclerView=findViewById(R.id.catRecycler);

        //setObject
        createObjects();

        categoryAdapter=new CategoryAdapter(this,list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(categoryAdapter);

        this.setCategory();
    }

    private void createObjects() {
        categoryService = ServiceGeneratorRxAndroid.createService(CategoryService.class);
    }

    public void setCategory(){
       /* for(int i =0;i<10 ;i++){
            list.add(new CategoryResponse.Category("Item" +i));
        }*/
        Log.e("sms->", "on cat category");
        Observable<Response<CategoryResponse>> categoriesObservable=categoryService.getCategories();

        categoriesObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<Response<CategoryResponse>>() {
                    @Override
                    public void onNext(Response<CategoryResponse> categoryResponse) {
                        Log.e("sms->", categoryResponse.body().getMsg());
                        categoryAdapter.setCategories(categoryResponse.body().getData());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("error->", e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e("complete->", "completed");
                    }
                });
        categoriesObservable.unsubscribeOn(Schedulers.io());
    }

   /* List<CategoryResponse.Category> setToList(List<CategoryResponse.Category> list){


    }*/

   public void addCategory(){
        CategoryCreate category=new CategoryCreate();
        category.setCate_name("testert");
        category.setDes("qwertyuiopsdfghjkl");
        List<String> keyword=new ArrayList<>();
        keyword.add("qq");
        keyword.add("bb");
        category.setKeywords(keyword);

       Observable<ResponseBody> addCategoryObservable=categoryService.addCategory(category);
       addCategoryObservable.subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribeWith(new DisposableObserver<ResponseBody>() {

                   @Override
                   public void onNext(ResponseBody response) {
                       Log.e("sms->",response.toString());
                   }

                   @Override
                   public void onError(Throwable e) {
                        Log.e("error->", e.toString());
                   }

                   @Override
                   public void onComplete() {
                       Log.e("complete->", "completed");
                   }
               });

       addCategoryObservable.unsubscribeOn(Schedulers.io());

   }


   public void removeCategory(){
       Single<Response<DeleteResponse>> categoryObservable =categoryService.removeCategory(248);
       categoryObservable.subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribeWith(new DisposableSingleObserver<Response<DeleteResponse>>() {
                   @Override
                   public void onSuccess(Response<DeleteResponse> deleteResponseResponse) {
                       Toast.makeText(CategoryActivity.this,
                               deleteResponseResponse.body().getMsg(), Toast.LENGTH_SHORT).show();
                   }

                   @Override
                   public void onError(Throwable e) {

                   }
               });
       categoryObservable.unsubscribeOn(Schedulers.io());
   }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.createCategory:
                    addCategory();
                return true;
            case R.id.deleteCategory:{
                this.removeCategory();
                return true;
            }
        }

        return false;
    }
}
