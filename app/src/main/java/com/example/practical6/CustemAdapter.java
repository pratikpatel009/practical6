package com.example.practical6;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustemAdapter extends RecyclerView.Adapter<CustemAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList id, name, enrollmentNumber, spi, sem;
    private MyViewHolder holder;


    CustemAdapter(
//            Activity activity,
                  Context context,
                  ArrayList id,
                  ArrayList name,
                  ArrayList enrollmentNumber,
                  ArrayList spi,
                  ArrayList sem){
        this.activity = activity;
        this.context = context;
        this.id = id;
        this.name = name;
        this.enrollmentNumber = enrollmentNumber;
        this.spi = spi;
        this.sem = sem;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.id_txt.setText(String.valueOf(id.get(position)));
        holder.name_txt.setText(String.valueOf(name.get(position)));
        holder.enrollmentNumber_txt.setText(String.valueOf(enrollmentNumber.get(position)));
        holder.spi_txt.setText(String.valueOf(spi.get(position)));
        holder.sem_txt.setText(String.valueOf(sem.get(position)));
        //Recyclerview onClickListener
//        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, UpdateActivity.class);
//                intent.putExtra("id", String.valueOf(book_id.get(position)));
//                intent.putExtra("title", String.valueOf(book_title.get(position)));
//                intent.putExtra("author", String.valueOf(book_author.get(position)));
//                intent.putExtra("pages", String.valueOf(book_pages.get(position)));
//                activity.startActivityForResult(intent, 1);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView id_txt, name_txt, enrollmentNumber_txt, spi_txt,sem_txt;
            LinearLayout mainLayout;

            MyViewHolder(@NonNull View itemView) {
                super(itemView);
                id_txt = itemView.findViewById(R.id.student_id);
                name_txt = itemView.findViewById(R.id.student_name);
                enrollmentNumber_txt = itemView.findViewById(R.id.student_enrollmentNumber);
                spi_txt = itemView.findViewById(R.id.student_spi);
                sem_txt = itemView.findViewById(R.id.student_sem);
//                mainLayout = itemView.findViewById(R.id.mainLayout);
                //Animate Recyclerview
//                Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
              //  mainLayout.setAnimation(translate_anim);
            }

        }
        }


