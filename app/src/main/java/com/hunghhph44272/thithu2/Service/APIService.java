package com.hunghhph44272.thithu2.Service;


import com.hunghhph44272.thithu2.Model.Response;
import com.hunghhph44272.thithu2.Model.SinhVien;

import java.util.ArrayList;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {

    //leTai: 192.168.1.11  vietBach: 192.168.1.23  hoanghung: 172.20.10.2
    String ipv4 = "172.20.10.2";
    String DOMAIN = "http://"+ ipv4 +":3000/api/";

    @GET("get-list-sinhvien")
    Call<Response<ArrayList<SinhVien>>> getXeMay();
    @DELETE("delete-sinhvien-by-id/{id}")
    Call<Response<Void>> deleteSinhVien(@Path("id") String id);

//    @Multipart
//    @POST("add-sinhvien")
//    Call<Response<SinhVien>> addXeMayWithFileImage(@PartMap Map<String, RequestBody> requestBodyMap);
    @POST("add-sinhvien")
    Call<Response<SinhVien>> addSinhVien(@Body SinhVien sinhVien);

    @PUT("update-sinhvien-by-id/{id}")
    Call<Response<SinhVien>> UpdateSinhVien(@Path("id") String id,@Body SinhVien sinhVien);

    @GET("search-sinhvien-by-name")
    Call<Response<ArrayList<SinhVien>>> searchXeMayByName(@Query("name") String name);
}
