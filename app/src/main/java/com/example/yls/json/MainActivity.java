package com.example.yls.json;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private TextView textResult;
    private  String jsonStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
textResult= (TextView) findViewById(R.id.textview);
        Student s1 = new Student(1,"张1" ,10);
        Student s2 = new Student(2,"张2" ,20);
        Student s3 = new Student(3,"张3" ,30);
        final Student[] stus ={s1,s2,s3};
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONArray array = new JSONArray();
                for (int i=0;i<array.length();i++){
                    JSONObject stuObj = getStudentJsonObj(stus[i]);
                    array.put(stuObj);
                }
                JSONObject obj = new JSONObject();
                try {
                    obj.put("stuList", array);
                } catch (JSONException e){
                    Log.i("MainActivity", e.toString());
                }
                jsonStr = obj.toString();
                textResult.setText(obj.toString());
            }
        });
        btn2= (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                JSONObject obj = new JSONObject(jsonStr);
                JSONObject array = obj.getJSONObject("stuList");
                ArrayList<Student> stuList = new ArrayList<Student>();
                for(int i=0;i<array.length();i++){
                    //这个不会
                    JSONObject stuObj = array.getJSONObject(i);
                    int id = stuObj.getInt("id");
                    String name = stuObj.getString("name");
                    int age = stuObj.getInt("age");
                    Student s = new Student(id, name, age);
                    stuList.add(s);
                }
                }catch (JSONException e){
                    Log.i("MainActivity", e.toString());
                }
            }
        });
        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String jsonStr = "{\"id\":1,\"name\":\"张三\",\"age\":30}";
                //不会
                Gson gson = new Gson();
                Student s = gson.fromJson(jsonStr, Student.class);
                textResult.setText(s.getName() + "   " + s.getAge());

            }
        });
    }

    private JSONObject getStudentJsonObj(Student stu) {
        JSONObject obj = new JSONObject();

        try {
            obj.put("id", stu.getId());
            obj.put("name", stu.getName());
            obj.put("age", stu.getAge());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
