package edu.upc.dsa.minim2dsa;

import edu.upc.dsa.minimo2entregable.models.Museums;
import retrofit2.Call;
import retrofit2.http.GET;

public interface UserService {
    //aqui treurem la api d'on conseguirem la informació
    @GET("api/dataset/museus/format/json/pag-ini/1/pag-fi/15")
    Call<Museums> getDatos();
}
