package test.pympack.valdemar.com.roomtest.api.servicio;


import retrofit2.Call;
import retrofit2.http.GET;
import test.pympack.valdemar.com.roomtest.helper.Constantes;
import test.pympack.valdemar.com.roomtest.model.NewsResponse;

/**
 * Created by CORAIMA on 11/01/2018.
 */

public interface NewApiService {

    @GET(Constantes.BASE_ROOT)
    Call<NewsResponse> obtenerListaArticle();

}
