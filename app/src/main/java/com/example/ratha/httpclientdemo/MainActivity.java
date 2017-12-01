package com.example.ratha.httpclientdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.ratha.httpclientdemo.entity.Category;
import com.example.ratha.httpclientdemo.entity.CategoryByIdResponse;
import com.example.ratha.httpclientdemo.entity.CategoryPost;
import com.example.ratha.httpclientdemo.entity.CategoryPostResponse;
import com.example.ratha.httpclientdemo.entity.CategoryResponse;
import com.example.ratha.httpclientdemo.entity.CategoryUpdate;
import com.example.ratha.httpclientdemo.entity.DeleteResponse;
import com.example.ratha.httpclientdemo.repository.Knongdai;
import com.example.ratha.httpclientdemo.repository.network.RxJavaServiceGenerator;
import com.example.ratha.httpclientdemo.repository.network.ServiceGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Knongdai.CategoryService categoryService;
    Knongdai.CategoryService categoryServiceRx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.createServices();
    }

    private void createServices(){
        categoryService= ServiceGenerator.createService(Knongdai.CategoryService.class);
        categoryServiceRx= RxJavaServiceGenerator.createService(Knongdai.CategoryService.class);
    }

    public void requestCategories() throws IOException {
        Call<CategoryResponse> call=categoryService.getCategories();
        call.enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                Log.e("response->","work");
                CategoryResponse  res =response.body();
                List<CategoryResponse.Category> categories= res.getData();
                    Log.e("message->", categories.toString());

            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                Log.e("request category ->",t.toString());
            }
        });
    }

    private void requestCategory(final int i) {
        Call<CategoryByIdResponse> call =categoryService.getCategory(i);
        call.enqueue(new Callback<CategoryByIdResponse>() {
            @Override
            public void onResponse(Call<CategoryByIdResponse> call, Response<CategoryByIdResponse> response) {
                Category category= response.body().getCategory();
                //Log.e("message-> ",response.body().getMsg());
                Log.e("category id "+i+"-> ",category.toString());
            }

            @Override
            public void onFailure(Call<CategoryByIdResponse> call, Throwable t) {
                Log.e("error->",t.toString());
            }
        });

    }

    private void createCategory(CategoryPost category) {

        Call<CategoryPostResponse> call= categoryService.createCategory(category);
        call.enqueue(new Callback<CategoryPostResponse>() {
            @Override
            public void onResponse(Call<CategoryPostResponse> call, Response<CategoryPostResponse> response) {

                    //Log.e("sms-> ", response.body().getSmg());
                    Log.e("sms-> ", response.body().getCategory().toString());

            }

            @Override
            public void onFailure(Call<CategoryPostResponse> call, Throwable t) {
                Log.e("create error->", t.toString());
            }
        });
    }
    public  void deleteCategory(int id){
         Call<DeleteResponse> call=categoryService.deleteCategory(id);
        call.enqueue(new Callback<DeleteResponse>() {
            @Override
            public void onResponse(Call<DeleteResponse> call, Response<DeleteResponse> response) {
                try {
                    Log.e("sms-> ", response.body().getMsg());
                }catch (Exception e){
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<DeleteResponse> call, Throwable t) {
                Log.e("error-> ", t.toString());
            }
        });
    }

    private void updateCategory(CategoryPost category) {

        Call<CategoryUpdate> call=categoryService.updateCategory(category);
        call.enqueue(new Callback<CategoryUpdate>() {
            @Override
            public void onResponse(Call<CategoryUpdate> call, Response<CategoryUpdate> response) {

                try{
                    Log.e("update->",response.body().getMsg());
                }catch (Exception e){
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<CategoryUpdate> call, Throwable t) {
                Log.e("error-> ",t.toString());
            }
        });

    }
    public void onGetCategory(View view) {
        try {
            requestCategories();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void onGetCategoryById(View view) {
       // Log.e("id-> ",1+"");
        requestCategory(1);
    }


    public void onCreateCategory(View view) {
        Log.e("click->","click");
        CategoryPost category=new CategoryPost();
        category.setCate_name("test 25");
        category.setDes("test2 test2 test2");
        List<String> keywords=new ArrayList<>();
        keywords.add("test2");
        keywords.add("test2-test2");
        category.setKeywords(keywords);
        createCategory(category);
    }

    public void onDeleteCategory(View view) {
        deleteCategory(215);
    }

    public void onUpdateCategory(View view) {
        CategoryPost category=new CategoryPost();
        category.setId(202);
        category.setCate_name("test 11 update 3");

        updateCategory(category);
    }

    public void onGetCategoryObservable(View view) {
    Log.e("click-> ","clicked");
    Observable<Response<CategoryResponse>> categoryObserver = categoryServiceRx.getCategoriesObservable();

    Observable<CategoryResponse.Category> categories=categoryObserver.flatMap(new Function<Response<CategoryResponse>, Observable<CategoryResponse.Category>>() {
        @Override
        public Observable<CategoryResponse.Category> apply(Response<CategoryResponse> categoryResponseResponse) throws Exception {
            return Observable.fromIterable(categoryResponseResponse.body().getData());
        }
    });

    categoryObserver.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(s-> Log.e("sms->", s.body().getMsg()));

    categories.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(new DisposableObserver<CategoryResponse.Category>() {
                @Override
                public void onNext(CategoryResponse.Category category) {
                    Log.e("data->",category.toString());
                }

                @Override
                public void onError(Throwable e) {
                    Log.e("error->"," "+e.toString());
                }

                @Override
                public void onComplete() {
                    Log.e("completed->","completed");
                }
            });

            categoryObserver.unsubscribeOn(Schedulers.io());
            categories.unsubscribeOn(Schedulers.io());
    }

    public void onCreateCatObservable(View view) {

        CategoryPost category=new CategoryPost();
        category.setCate_name("test 27");
        category.setDes("test2 test2 test2");
        List<String> keywords=new ArrayList<>();
        keywords.add("test2");
        keywords.add("test2-test2");
        category.setKeywords(keywords);

        Single<Response<CategoryPostResponse>> postResponse=categoryServiceRx.createCategoryObservable(category);
        postResponse.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<Response<CategoryPostResponse>>() {
                    @Override
                    public void onSuccess(Response<CategoryPostResponse> categoryPostResponseResponse) {
                        Log.e("sms-> ", categoryPostResponseResponse.body().getSmg());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("error->",e.toString());
                    }
                });
        postResponse.unsubscribeOn(Schedulers.io());
    }
}
