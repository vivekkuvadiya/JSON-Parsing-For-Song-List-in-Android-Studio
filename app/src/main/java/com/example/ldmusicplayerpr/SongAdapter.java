package com.example.ldmusicplayerpr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {

    Context context;
    LayoutInflater inflater;
    List<SongModel> songList;

    public SongAdapter(Context context, List<SongModel> songList) {
        this.context = context;
        this.songList = songList;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.song_list_item,parent,false);

        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {

        holder.songTitle.setText(songList.get(position).getSongName());
        holder.songArtist.setText(songList.get(position).getSongArtist());
        Picasso.get().load(songList.get(position).getCoverImage()).into(holder.coverImage);
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }





    class SongViewHolder extends RecyclerView.ViewHolder{

        ImageView coverImage;
        TextView songTitle, songArtist;


        public SongViewHolder(@NonNull View itemView) {
            super(itemView);

            coverImage = itemView.findViewById(R.id.coverImage);
            songTitle = itemView.findViewById(R.id.songTitel);
            songArtist = itemView.findViewById(R.id.songArtist);

        }
    }

}
