package test.pympack.valdemar.com.roomtest.api.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import test.pympack.valdemar.com.roomtest.helper.Constantes;

/**
 * Created by CORAIMA on 11/01/2018.
 */

public class RetrofitInstance {

    private static Retrofit mRetrofit;

    public static Retrofit getRetrofitInstance(){
        if(mRetrofit == null){
            mRetrofit = new retrofit2.Retrofit
                    .Builder()
                    .baseUrl(Constantes.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return  mRetrofit;
    }

}
