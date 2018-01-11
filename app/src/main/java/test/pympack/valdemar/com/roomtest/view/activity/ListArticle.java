package test.pympack.valdemar.com.roomtest.view.activity;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import test.pympack.valdemar.com.roomtest.AppDataBase;
import test.pympack.valdemar.com.roomtest.R;
import test.pympack.valdemar.com.roomtest.adapter.NewApapter;
import test.pympack.valdemar.com.roomtest.api.network.RetrofitInstance;
import test.pympack.valdemar.com.roomtest.api.servicio.NewApiService;
import test.pympack.valdemar.com.roomtest.helper.Constantes;
import test.pympack.valdemar.com.roomtest.model.News;
import test.pympack.valdemar.com.roomtest.model.NewsResponse;
import test.pympack.valdemar.com.roomtest.model.Users;


public class ListArticle extends AppCompatActivity {

    @BindView(R.id.btnAdd)
    Button mBtnAdd;
    @BindView(R.id.recycler)
    RecyclerView mRecycler;

    private NewApapter mNewApapter;
    private LinearLayoutManager mLinearLayoutManager;
    //private ArrayList<String> newUser = new ArrayList<>();
    private ArrayList<Users> users;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_article);

        ButterKnife.bind(this);

        initRecycler();

        //readDataService();
        //insertData();
        //deleteDatabase();
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });
    }

    private void deleteDatabase() {
        AppDataBase db = Room.databaseBuilder(getApplicationContext(),AppDataBase.class,"Developers")
                .allowMainThreadQueries()
                .build();
        Users user = new Users();
        db.userDao().deleteAll(user);
    }

    private void initRecycler() {
        mRecycler.hasFixedSize();

       /* users= new ArrayList<>();
        for (int i = 0; i<50;i++){
            Users user  = new Users("juan"+i,"colichón","juanvcr@outlook.com");
            users.add(user);
        }*/


        AppDataBase db = Room.databaseBuilder(getApplicationContext(),AppDataBase.class,"Developers")
                .allowMainThreadQueries()
                .build();

        List<Users> users = db.userDao().getAllUsers();
        mNewApapter = new NewApapter(users);
        mLinearLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecycler.setLayoutManager(mLinearLayoutManager);
        mRecycler.setAdapter(mNewApapter);
    }


    private void insertData() {
        AppDataBase db = Room.databaseBuilder(getApplicationContext(),AppDataBase.class,"Developers")
                .allowMainThreadQueries()
                .build();

            Users user = new Users("1","2","3");
            Log.v("TAG_DB",user.getFirstName());
            db.userDao().insertAll(user);
        initRecycler();
       // db.userDao().insertAll(new Users("bryan","Malone","oin@gmail.com"));
    }



    /*private void initRecycler() {
        mRecycler.hasFixedSize();


        for (int i = 0; i<50;i++){
            newUser.add("Juan"+i);
        }
        mNewApapter = new NewApapter(newUser);
        mLinearLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecycler.setLayoutManager(mLinearLayoutManager);
        mRecycler.setAdapter(mNewApapter);
    }*/


    private void readDataService() {
        NewApiService newApiService= RetrofitInstance.getRetrofitInstance().create(NewApiService.class);
        Call<NewsResponse> newsResponseCall = newApiService.obtenerListaArticle();

        newsResponseCall.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if(response.isSuccessful()){
                    NewsResponse newsResponse = response.body();
                    ArrayList<News> news = newsResponse.getArticles();
                    for(int i = 0; i < news.size();i++){
                        News article = news.get(i);
                        Log.v(Constantes.TAG_MESSAGE,"Articulos: "+article.getTitle());
                        Log.v(Constantes.TAG_MESSAGE,"Articulos: "+article.getDescription());
                        Log.v(Constantes.TAG_MESSAGE,"Articulos: "+article.getUrlToImage());
                    }

                }else{
                    Log.v(Constantes.TAG_MESSAGE,"Error: "+response.errorBody());

                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Log.v(Constantes.TAG_MESSAGE,"Error: "+t.getMessage());

            }
        });

    }


}
