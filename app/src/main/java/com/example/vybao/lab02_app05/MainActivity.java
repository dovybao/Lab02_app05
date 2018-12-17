package com.example.vybao.lab02_app05;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView employeeRecycleView;
    EmployeeAdapter employeeAdapter;
    ArrayList<Employee> listEmployee ;
    Context mContext;

    Button btnNhap;
    EditText editMa,editTen;
    CheckBox position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNhap = (Button)findViewById(R.id.btnNhap);
        editMa = (EditText)findViewById(R.id.inputMaNV);
        editTen = (EditText)findViewById(R.id.inputTenNV);
        position = (CheckBox)findViewById(R.id.cbPosition);


        employeeRecycleView = (RecyclerView)findViewById(R.id.recycler_view);



        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        listEmployee = new ArrayList<Employee>();
        employeeAdapter = new EmployeeAdapter(getApplicationContext(),listEmployee);
        employeeRecycleView.setAdapter(employeeAdapter);
        employeeRecycleView.setLayoutManager(mLayoutManager);

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processNhap();
            }
        });
        employeeAdapter.setOnItemClickedListener(new EmployeeAdapter.OnItemClickedListener() {
            @Override
            public void onItemClick(Employee employee) {

            }
        });

    }
    public void processNhap(){
        String id = editMa.getText().toString();
        String  name = editTen.getText().toString();

        boolean isamanager = position.isChecked();

        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setPosition(isamanager);

        listEmployee.add(employee);
        employeeAdapter.notifyDataSetChanged();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        employeeRecycleView.setLayoutManager(layoutManager);


    }
    public void deleteEmployee(Employee employee){
        listEmployee.remove(employee);
        employeeAdapter.notifyDataSetChanged();
    }
}
