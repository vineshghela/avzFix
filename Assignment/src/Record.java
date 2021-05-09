package com.avatar.record_management;

public class Record {

	// define variables - artist, title and genre
	
	private String artist;
	private String title;
	private String genre;
	private int songID;
	
	// constructor
	public Record(String genre, String artist, String title, int songID) {
		this.artist = artist;
		this.title = title;
		this.genre = genre;	
		this.songID = songID;

	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public int getSongID() {
		return songID;
	}

	public void setSongID(int songID) {
		this.songID = songID;
	}

	// toString output
	public String toString() {
		return "ID:" + songID+" Artist: "+ artist + ", Title: " + title + ", Genre: " + genre;
	}
	
	
}
