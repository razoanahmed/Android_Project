package com.example.hospitalinfo;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class jsonjava extends MainActivity {
    private static final String TAG = "MainActivity";
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json_activity);
        textView =findViewById(R.id.textView7);
        getJson();
    }
    public void getJson(){
        String json;
        try{
            InputStream is =getAssets().open("JSONLabaid.json");
            int size =is.available();
            byte[]buffer =  new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer,"UTF-8");

            JSONObject jsonObject = new JSONObject(json);
            JSONObject contacts = jsonObject.getJSONObject("Contacts");
            String emergency = contacts.getString("24 hours Emergency Service");
            String customerCare = contacts.getString("Labaid Cardiac customer care");
            String specialized = contacts.getString("Labaid Specialized customer care");
            String admission = contacts.getString("Labaid Cardiac admission");
            String specializedAdmission = contacts.getString("Labaid Specialized admission");
            String hospital_name = jsonObject.getString("Hospital Name");
            String website_link = jsonObject.getString("Website Link");
            textView.append("Hospital Name: "+hospital_name+"\n"+"For Details Visit their Official Site: "+ website_link+"\n"+"Emergency Service 1: "+emergency + "\n" +"Emergency Service 2: "+customerCare + "\n" +"Emergency Service 3: "+specialized
                    + "\n " +"Emergency Service 4: "+ admission + "\n" +"Ambulance Service: "+specializedAdmission);
            Log.d(TAG, "getJson: printing " + emergency + " "  + customerCare + " "
                    + specialized + " " + admission + " " + specializedAdmission
                    + " " + hospital_name + " " + website_link);
            JSONArray jsonArray = jsonObject.getJSONArray("Locations");
            for(int i = 0; i < jsonArray.length(); i++) {

                jsonObject = jsonArray.getJSONObject(i);
                String plot = jsonObject.getString("Plot");
                String road = jsonObject.getString("Road");
               // jsonObject = jsonArray.getJSONObject(1);
                String area = jsonObject.getString("Area");
                String city = jsonObject.getString("City");
                textView.append("House: "+plot + "\n" +"Road/Block: "+road + "\n" +"Area/Sector: "+area + "\n " +"Place: "+city + "\n");
                Log.d(TAG, "getJson: another" + plot + " " + road + " " + area + " " + city);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (JSONException e){
            e.printStackTrace();
        }
    }
}

