package com.example.ldmusicplayerpr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView songList;
    List<SongModel> list;
    private static String JSON_URL = "http://starlord.hackerearth.com/studio";
    SongAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songList = findViewById(R.id.songList);

        list = new ArrayList<>();

        extractSong();



    }

    private void extractSong() {

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = response.getJSONObject(i);

                        SongModel songModel = new SongModel();
                        songModel.setSongName(object.getString("song").toString());
                        songModel.setSongURL(object.getString("url"));
                        songModel.setSongArtist(object.getString("artists").toString());
                        songModel.setCoverImage(object.getString("cover_image"));

                        list.add(songModel);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    songList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                    adapter = new SongAdapter(getApplicationContext(),list);

                    songList.setAdapter(adapter);

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag","on Error Responce "+error.getMessage());
            }
        });

        requestQueue.add(request);

    }

}
