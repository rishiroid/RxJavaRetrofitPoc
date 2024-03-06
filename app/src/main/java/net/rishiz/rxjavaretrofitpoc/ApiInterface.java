package net.rishiz.rxjavaretrofitpoc;





import net.rishiz.rxjavaretrofitpoc.model.ResponseDTO;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("entries")
    Observable<ResponseDTO> getEntries();
//    @GET("entries")
//    Call<ResponseDTO> getEntries();


}
