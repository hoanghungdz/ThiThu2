package com.hunghhph44272.thithu2.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hunghhph44272.thithu2.Model.Response;
import com.hunghhph44272.thithu2.Model.SinhVien;
import com.hunghhph44272.thithu2.R;
import com.hunghhph44272.thithu2.Service.HttpRequest;
import com.hunghhph44272.thithu2.Service.OnClick;
import com.hunghhph44272.thithu2.View.AddSinhVien;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class AdapterSinhVien extends RecyclerView.Adapter<AdapterSinhVien.ViewHolder> {
    private final Context context;
    private final ArrayList<SinhVien> list;

    HttpRequest httpRequest = new HttpRequest();

    OnClick onClick;

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }

    public AdapterSinhVien(Context context, ArrayList<SinhVien> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
//        View view = inflater.inflate(R.layout.item, parent, false);
        View view = inflater.inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        String url = list.get(position).getHinh_anh_ph44272();
//        String newUrl = url.replace("localhost", "10.0.2.2");
//        Glide.with(context)
//                .load(newUrl)
//                .thumbnail(Glide.with(context).load(R.drawable.noimageicon))
//                .into(holder.imgHinhanh);
        holder.tvID.setText("MSV: " + list.get(position).getMa_sinh_vien());
        holder.tvTen.setText("Tên:" + list.get(position).getTen());
        holder.tvGioiTinh.setText("Gioi tính: " + list.get(position).getGioi_tinh());
        holder.tvNgaySinh.setText("Ngày sinh: " + list.get(position).getNgay_sinh());
        holder.tvKhoaHoc.setText("Khóa học: " + list.get(position).getKhoa_hoc());
        holder.tvLop.setText("Lớp: " + list.get(position).getLop());
        holder.tvID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SinhVien sinhVien = list.get(position);
                Dialog_ChiTiet(sinhVien);
            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SinhVien sinhVien = list.get(position);
                onClick.delete(sinhVien);
            }
        });

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SinhVien sinhVien = list.get(position);
                onClick.update(sinhVien);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvID, tvTen, tvGioiTinh, tvNgaySinh, tvKhoaHoc, tvLop;
//        ImageView imgHinhanh;
        ImageButton edit, delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvID = itemView.findViewById(R.id.tv_id);
            tvTen = itemView.findViewById(R.id.tv_ten);
            tvGioiTinh = itemView.findViewById(R.id.tv_gioi_tinh);
            tvNgaySinh = itemView.findViewById(R.id.tv_ngay_sinh);
            tvKhoaHoc = itemView.findViewById(R.id.tv_khoa_hoc);
            tvLop = itemView.findViewById(R.id.tv_lop);
            edit = itemView.findViewById(R.id.btn_edit);
            delete = itemView.findViewById(R.id.btn_delete);
        }
    }
    private void Dialog_ChiTiet(SinhVien sinhVien) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_chitiet, null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

//        ImageView img_hinhanh = view.findViewById(R.id.img_hinh_anh);

        TextView tv_ten = view.findViewById(R.id.tv_ten);
        TextView tv_gioitinh = view.findViewById(R.id.tv_gioi_tinh);
        TextView tv_ngaysinh = view.findViewById(R.id.tv_ngay_sinh);
        TextView tv_khoahoc= view.findViewById(R.id.tv_khoa_hoc);
        TextView tv_lop = view.findViewById(R.id.tv_lop);
        TextView tv_id = view.findViewById(R.id.tv_id);

//        String url = xeMay.getHinh_anh_ph44272();
//        String newUrl = url.replace("localhost", "10.0.2.2");
//        Glide.with(context)
//                .load(newUrl)
//                .thumbnail(Glide.with(context).load(R.drawable.noimageicon))
//                .into(img_hinhanh);
        tv_id.setText("MSV: " + sinhVien.getMa_sinh_vien());
        tv_ten.setText("Tên: " + sinhVien.getTen());
        tv_gioitinh.setText("Gioi tính: " + sinhVien.getGioi_tinh());
        tv_ngaysinh.setText("Ngày sinh: " + sinhVien.getNgay_sinh());
        tv_khoahoc.setText("Mô tả: " + sinhVien.getKhoa_hoc());
        tv_lop.setText("Lớp: " + sinhVien.getLop());

        view.findViewById(R.id.btn_dong).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }



}
