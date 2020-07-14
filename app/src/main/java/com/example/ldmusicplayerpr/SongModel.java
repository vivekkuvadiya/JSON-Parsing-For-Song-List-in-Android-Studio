package com.example.ldmusicplayerpr;

public class SongModel {

    private String songName;
    private String songURL;
    private String songArtist;
    private String coverImage;

    public SongModel(){}

    public SongModel(String songName , String songURL, String songArtist, String coverImage){
        this.songName = songName;
        this.songURL = songURL;
        this.songArtist = songArtist;
        this.coverImage = coverImage;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongURL() {
        return songURL;
    }

    public void setSongURL(String songURL) {
        this.songURL = songURL;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }
}
