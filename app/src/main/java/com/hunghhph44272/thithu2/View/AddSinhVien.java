package com.hunghhph44272.thithu2.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.hunghhph44272.thithu2.Model.Response;
import com.hunghhph44272.thithu2.Model.SinhVien;
import com.hunghhph44272.thithu2.R;
import com.hunghhph44272.thithu2.Service.HttpRequest;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

public class AddSinhVien extends AppCompatActivity {
    private File file;
    EditText  edtMasv,edtTen, edtNgaySinh, edtKhoaHoc, edtGioiTinh, edtLop;

    HttpRequest httpRequest = new HttpRequest();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sinh_vien);
        edtMasv = findViewById(R.id.edt_masv);
        edtTen = findViewById(R.id.edt_ten);
        edtNgaySinh = findViewById(R.id.edt_ngay_sinh);
        edtKhoaHoc = findViewById(R.id.edt_khoa_hoc);
        edtGioiTinh = findViewById(R.id.edt_gioi_tinh);
        edtLop = findViewById(R.id.edt_lop);

        findViewById(R.id.btn_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, RequestBody> mapRequestBody = new HashMap<>();
                String _ma = edtMasv.getText().toString().trim();
                String _ten = edtTen.getText().toString().trim();
                String _gioitinh = edtGioiTinh.getText().toString().trim();
                String _ngaysinh = edtNgaySinh.getText().toString().trim();
                String _khoahoc = edtKhoaHoc.getText().toString().trim();
                String _lop = edtLop.getText().toString().trim();
                if (_ten.isEmpty() || _gioitinh.isEmpty() || _ngaysinh.isEmpty() || _khoahoc.isEmpty() || _lop.isEmpty()) {
                    Toast.makeText(AddSinhVien.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }

//                mapRequestBody.put("ma_sinh_vien", getRequestBody(_ma));
//                mapRequestBody.put("ten", getRequestBody(_ten));
//                mapRequestBody.put("gioi_tinh", getRequestBody(_gioitinh));
//                mapRequestBody.put("ngay_sinh", getRequestBody(_ngaysinh));
//                mapRequestBody.put("khoa_hoc", getRequestBody(_khoahoc));
//                mapRequestBody.put("lop", getRequestBody(_lop));
                SinhVien sinhVien = new SinhVien(_ma,_ten,_gioitinh,_ngaysinh,_khoahoc,_lop);
                if (getIntent().getStringExtra("type").equals("update")){
                    Toast.makeText(AddSinhVien.this, "cập nhật", Toast.LENGTH_SHORT).show();
                    httpRequest.callAPI().UpdateSinhVien(getIntent().getStringExtra("id"),sinhVien).enqueue(new Callback<Response<SinhVien>>() {
                        @Override
                        public void onResponse(Call<Response<SinhVien>> call, retrofit2.Response<Response<SinhVien>> response) {
                            Toast.makeText(AddSinhVien.this, "oke", Toast.LENGTH_SHORT).show();
                            if (response.isSuccessful()) {
                                Log.d("123123", "onResponse: " + response.body().getStatus());
                                if (response.body().getStatus() == 200) {
                                    Toast.makeText(AddSinhVien.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                                    finish();
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<Response<SinhVien>> call, Throwable t) {

                        }
                    });
                }else {
                    httpRequest.callAPI().addSinhVien(sinhVien).enqueue(new Callback<Response<SinhVien>>() {
                        @Override
                        public void onResponse(Call<Response<SinhVien>> call, retrofit2.Response<Response<SinhVien>> response) {
                            if (response.isSuccessful()) {
                                Log.d("123123", "onResponse: " + response.body().getStatus());
                                if (response.body().getStatus() == 200) {
                                    Toast.makeText(AddSinhVien.this, "Thêm mới thành công", Toast.LENGTH_SHORT).show();
                                    finish();
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<Response<SinhVien>> call, Throwable t) {
                            // Handle failure
                        }
                    });
                }

            }
        });

    }

    private RequestBody getRequestBody(String value) {
        return RequestBody.create(MediaType.parse("multipart/form-data"),value);
    }
}