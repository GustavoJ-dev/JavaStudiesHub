package pratices.exercise49;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album{
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String title, double duration){
        return songs.add(new Song(title, duration));
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList){
        Song checkedSound = songs.findSong(trackNumber);
        if (checkedSound != null){
            playList.add(checkedSound);
            return true;
        }else{
            System.out.println("This album does not have a track " + trackNumber);
            return false;
        }
    }
    public boolean addToPlayList(String title, LinkedList<Song> playList){
        Song checkedSong = songs.findSong(title);
        if (checkedSong != null){
            playList.add(checkedSong);
            return true;
        }else {
            System.out.println("The song " + title + " is not in this album");
            return false;
        }
    }
    public static class SongList{

        private ArrayList<Song> songs;

        private SongList(){
            songs = new ArrayList<Song>();
        }

        private boolean add(Song song){
            if (songs.contains(song)){
                return false;
            }
            songs.add(song);
            return true;
        }

        private Song findSong(String title){
            for(Song checkSong : songs){
                if (checkSong.getTitle().equals(title)){
                    return checkSong;
                }
            }
            return null;
        }

        private Song findSong(int trackNumber){
            int index = trackNumber - 1;
            if (index >= 0 && index < songs.size()){
                return songs.get(index);
            }
            return null;
        }
    }
}
