package com.example.new_ergasia;

import android.os.*;
import org.json.*;
import java.util.*;
import okhttp3.*;
public class OkHttpHandler {
    public OkHttpHandler() {
        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
    ArrayList<String> getAdmininfo(String url) throws Exception {
        ArrayList<String> Admin = new ArrayList<String>();
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        RequestBody body = RequestBody.create("",
                MediaType.parse("text/plain"));
        Request request = new Request.Builder().url(url).method("POST",
                body).build();
        Response response = client.newCall(request).execute();
        String data = response.body().string();
        //System.out.println("My Response: " + data);
        try {
//            JSONObject json = new JSONObject(data);
//            Iterator<String> keys = json.keys();
//            while(keys.hasNext()) {
//                String name = keys.next();
//                String pass = json.get(name).toString();
//                Admin.add(name);
//                Admin.add(pass);
                JSONArray jsonArray = new JSONArray(data);//To ekana JSONArray giati san Object moy evgaze error kai den ta epairne
                for (int i=0; i<jsonArray.length();i++){
                    Admin.add(jsonArray.getJSONArray(i).getString(0));//Pairnw ta 2 prwta stoixeia toy pinaka
                    Admin.add(jsonArray.getJSONArray(i).getString(1));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return Admin;
    }
    public void logHistory(String url) throws Exception {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        RequestBody body = RequestBody.create("",
                MediaType.parse("text/plain"));
        Request request = new Request.Builder().url(url).method("POST",
                body).build();
        Response response = client.newCall(request).execute();
        //System.out.println("My Response: " + response);
    }

    ArrayList<String> getListofPhysio_R1(String url) throws Exception {
        ArrayList<String> list_Physio = new ArrayList<String>();
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        RequestBody body = RequestBody.create("",
                MediaType.parse("text/plain"));
        Request request = new Request.Builder().url(url).method("POST",
                body).build();
        Response response = client.newCall(request).execute();
        String data = response.body().string();
        //System.out.println("My Response: " + data);
        try {

            JSONArray jsonArray = new JSONArray(data);//To ekana JSONArray giati san Object moy evgaze error kai den ta epairne

            for (int i=0; i<jsonArray.length();i++){
                JSONArray innerJsonArray = jsonArray.getJSONArray(i);//Epeidh exei pinaka mesa se pinaka to kanw etsi
                for (int j=0; j<innerJsonArray.length(); j++){
                    list_Physio.add(innerJsonArray.getString(j));
                    //System.out.println(innerJsonArray.getString(j));
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //System.out.println(list_Physio);
        return list_Physio;
    }
}
