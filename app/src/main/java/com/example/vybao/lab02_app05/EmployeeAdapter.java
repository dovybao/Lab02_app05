package com.example.vybao.lab02_app05;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.RecyclerViewHolder> {
    ArrayList<Employee> listEmployee ;
    private Context mContext;
    public EmployeeAdapter(Context mContext, ArrayList<Employee> employees){
        this.mContext = mContext;
        this.listEmployee = employees;
    }
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View employeeView = inflater.inflate(R.layout.my_item_layout, parent, false);

       return new RecyclerViewHolder(employeeView);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewHolder recyclerViewHolder, int i) {
         final Employee employee = listEmployee.get(i);
         TextView name = recyclerViewHolder.tvName;
         TextView staff = recyclerViewHolder.tvStaff;
         ImageView img = recyclerViewHolder.imgManager;

         name.setText(employee.getName());
         if (employee.isManager()){
              staff.setVisibility(View.GONE);
              img.setVisibility(View.VISIBLE);
         }else {
             staff.setVisibility(View.VISIBLE);
             img.setVisibility(View.GONE);
         }
         recyclerViewHolder.itemEmployee.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 recyclerViewHolder.itemEmployee.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorAccent));
                 if (onItemClickedListener != null){
                     onItemClickedListener.onItemClick(employee);

                 }
             }
         });

    }
    public interface OnItemClickedListener{
        void onItemClick(Employee employee);
    }
    private OnItemClickedListener onItemClickedListener;

    public void setOnItemClickedListener(OnItemClickedListener onItemClickedListener){
        this.onItemClickedListener = onItemClickedListener;
    }
    @Override
    public int getItemCount() {
        return listEmployee.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        LinearLayout itemEmployee;
        TextView tvName;
        TextView tvStaff;
        ImageView imgManager;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = (TextView)itemView.findViewById(R.id.tvName);
            tvStaff = (TextView)itemView.findViewById(R.id.tvStaff);
            imgManager = (ImageView)itemView.findViewById(R.id.imageManager);
            itemEmployee = (LinearLayout)itemView.findViewById(R.id.item_employee_ll_parent);

        }

    }



}
