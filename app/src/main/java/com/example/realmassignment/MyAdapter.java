package com.example.realmassignment;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import io.realm.RealmResults;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private RealmResults<Student> studentRealmResults;
    private Context context;

    public MyAdapter(RealmResults<Student> realmResults, Context context) {
        this.studentRealmResults = realmResults;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Student student = studentRealmResults.get(position);

        holder.name.setText(student.getName());
        holder.dept.setText(student.getDept());
        holder.roll.setText(String.valueOf(student.getRoll()));
        holder.phone.setText(student.getPhone());
        holder.gender.setText(student.getGender());

        if(holder.dept.getText().equals("IT")) {
            holder.itemView.setBackgroundColor(Color.parseColor("#0000FF"));
        }
        else if(holder.dept.getText().equals("CSE")) {
            holder.itemView.setBackgroundColor(Color.parseColor("#00FF00"));
        }
        else if(holder.dept.getText().equals("EE")) {
            holder.itemView.setBackgroundColor(Color.parseColor("#FF0000"));
        }
        else if(holder.dept.getText().equals("ECE")) {
            holder.itemView.setBackgroundColor(Color.parseColor("#FFFF00"));
        }

    }

    public int getItemCount() {
        return studentRealmResults.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView dept;
        private TextView roll;
        private TextView phone;
        private TextView gender;

        public MyViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_tv);
            dept = itemView.findViewById(R.id.dept_tv);
            roll = itemView.findViewById(R.id.roll_tv);
            phone = itemView.findViewById(R.id.phone_tv);
            gender = itemView.findViewById(R.id.gender_tv);

        }
    }

}
