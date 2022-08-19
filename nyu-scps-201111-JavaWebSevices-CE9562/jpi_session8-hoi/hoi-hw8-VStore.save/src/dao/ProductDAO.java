package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

// import javax.naming.Context;
// import javax.naming.InitialContext;
// import javax.naming.NamingException;
// import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;

import model.Actor;
import model.Artist;
import model.Category;
import model.Director;
import model.Music;
import model.Track;
import model.Video;

import com.sun.rowset.CachedRowSetImpl;

public class ProductDAO implements ProductDAOIF {

  public List<Music> getMusic(String categoryName) throws SQLException{
    Connection connection = null;
    List<Music> musicList = new ArrayList<Music>();
    try{
      String sql = "SELECT MUSICS.*, "+
       "ARTISTS.ARTIST_ID, "+
       "ARTISTS.ARTIST_NAME, "+
       "MUSIC_TRACKS.TRACK_ID, "+
       "MUSIC_TRACKS.TRACK_TITLE, "+
       "MUSIC_TRACKS.DURATION,"+
       "CATEGORIES.CATEGORY_NAME, "+
       "CATEGORIES.CATEGORY_TYPE "+
      "FROM MUSICS, CATEGORIES, ARTISTS, MUSIC_TRACKS "+
      "WHERE ARTISTS.ARTIST_ID=MUSICS.ARTIST_ID "+
      "AND CATEGORIES.CATEGORY_ID=MUSICS.CATEGORY_ID "+
      "AND MUSICS.RECORDING_ID=MUSIC_TRACKS.RECORDING_ID "+
      "AND CATEGORIES.CATEGORY_NAME=? ORDER BY RECORDING_ID";

      connection = getConnection();
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, categoryName);
      ResultSet musicsResultSet = statement.executeQuery();
      CachedRowSet musicsRowSet = new CachedRowSetImpl();
      musicsRowSet.populate(musicsResultSet);
      //you can close the connection now.
      connection.close();
      int currentMusicId=-1;
      int previousMusicId=-1;
      int currentTrackId=-1;
      int previousTrackId=-1;
      Music music = null;
      Artist artist = null;
      Category category = null;
      while (musicsRowSet.next()){
        currentMusicId=musicsRowSet.getInt("Recording_Id");

        //new Music
        if (currentMusicId!=previousMusicId){
          music = new Music();
          musicList.add(music);
          music.setId(currentMusicId);
          music.setTitle(musicsRowSet.getString("Album_Title"));
          music.setNumberOfTracks(musicsRowSet.getInt("Num_Tracks"));
          music.setPrice(musicsRowSet.getDouble("Price"));
          music.setStockCount(musicsRowSet.getInt("Stock_Count"));
          artist = new Artist();
          music.setArtist(artist);
          artist.setId(musicsRowSet.getInt("Artist_Id"));
          artist.setName(musicsRowSet.getString("Artist_Name"));
          category = new Category();
          music.setCategory(category);
          category.setId(musicsRowSet.getInt("Category_Id"));
          category.setName(musicsRowSet.getString("Category_Name"));
          category.setType(musicsRowSet.getString("Category_Type"));


        }
        previousMusicId=currentMusicId;
        currentTrackId=musicsRowSet.getInt("Track_Id");
        if (currentTrackId!=previousTrackId){
          Track track = new Track();
          music.getTracks().add(track);
          track.setId(currentTrackId);
          track.setTitle(musicsRowSet.getString("Track_Title"));
          track.setDuration(musicsRowSet.getInt("duration"));
        }
        previousTrackId = currentTrackId;
      }
    }
    catch(SQLException e){
      throw e;
    }
    finally{
      if (connection!=null){
        try{
          connection.close();
        }
        catch(Exception e2){
          //do nothing - can't do anything anyway.
        }
      }
    }
    return musicList;
  }
  public List<Video> getVideo(String title) throws SQLException {
    Connection connection = null;
    List<Video> videoList = new ArrayList<Video>();
    try{
      String sql =
        "SELECT VIDEOS.*, "+
         "ACTORS.ACTOR_ID, "+
         "ACTORS.ACTOR_NAME, "+
         "DIRECTORS.DIRECTOR_ID, "+
         "DIRECTORS.DIRECTOR_NAME, "+
         "CATEGORIES.CATEGORY_ID, "+
         "CATEGORIES.CATEGORY_NAME, "+
         "CATEGORIES.CATEGORY_TYPE "+
        "FROM DIRECTORS,CATEGORIES,VIDEOS, ACTORS, VIDEO_ACTORS "+
        "WHERE CATEGORIES.CATEGORY_ID=VIDEOS.CATEGORY_ID "+
        "AND DIRECTORS.DIRECTOR_ID=VIDEOS.DIRECTOR_ID "+
        "AND ACTORS.ACTOR_ID=VIDEO_ACTORS.ACTOR_ID "+
        "AND VIDEOS.RECORDING_ID=VIDEO_ACTORS.RECORDING_ID "+
        "AND LOWER(VIDEOS.VIDEO_TITLE) LIKE ?";
      connection = getConnection();
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, "%" +title.toLowerCase() + "%");
      ResultSet videosResultSet = statement.executeQuery();
      CachedRowSet videossRowSet = new CachedRowSetImpl();
      videossRowSet.populate(videosResultSet);
      //you can close the connection now.
      connection.close();
      int currentVidoeId=-1;
      int previousVideoId=-1;
      int currentActorId=-1;
      int previousActorId=-1;
      Video video = null;
      Category category = null;
      Director director  = null;
      while (videossRowSet.next()){
        currentVidoeId=videossRowSet.getInt("Recording_Id");

        //new Music
        if (currentVidoeId!=previousVideoId){
          video = new Video();
          videoList.add(video);
          video.setId(currentVidoeId);
          video.setTitle(videossRowSet.getString("Video_Title"));
          video.setStockCount(videossRowSet.getInt("Stock_Count"));
          video.setRating(videossRowSet.getString("rating"));
          video.setPrice(videossRowSet.getDouble("Price"));
          video.setDuration(videossRowSet.getInt("duration"));
          category = new Category();
          video.setCategory(category);
          category.setId(videossRowSet.getInt("Category_Id"));
          category.setName(videossRowSet.getString("Category_Name"));
          category.setType(videossRowSet.getString("Category_Type"));
          director = new Director();
          video.setDirector(director);
          director.setId(videossRowSet.getInt("Director_Id"));
          director.setName(videossRowSet.getString("Director_Name"));

        }
        previousVideoId=currentVidoeId;
        currentActorId=videossRowSet.getInt("Actor_Id");
        if (currentActorId!=previousActorId){
          Actor actor = new Actor();
          video.getActors().add(actor);
          actor.setId(currentActorId);
          actor.setName(videossRowSet.getString("Actor_Name"));
        }
        previousActorId = currentActorId;
      }
    }
    catch(SQLException e){
      throw e;
    }
    finally{
      if (connection!=null){
        try{
          connection.close();
        }
        catch(Exception e2){
          //do nothing - can't do anything anyway.
        }
      }
    }
    return videoList;
  }
  private Connection getConnection() throws SQLException {
    Connection connection = null;
    // load Database.properties file
    PropertyResourceBundle bundle = (PropertyResourceBundle) ResourceBundle.getBundle("Database");

    // get the JDBC driver class name from the bundle
    String driver = bundle.getString("database.JDBCDriver");

    // get the url from the bundle.
    String url = bundle.getString("database.url");

    try{
      Class.forName(driver);
    }
    catch(ClassNotFoundException e2){
      e2.printStackTrace();
    }
    connection = DriverManager.getConnection(url);
    return connection;
  }
  public Music getMusic(int id) throws SQLException{
    Connection connection = null;
    Music music = null;
    try{
      String sql = "SELECT MUSICS.*, "+
       "ARTISTS.ARTIST_ID, "+
       "ARTISTS.ARTIST_NAME, "+
       "MUSIC_TRACKS.TRACK_ID, "+
       "MUSIC_TRACKS.TRACK_TITLE, "+
       "MUSIC_TRACKS.DURATION,"+
       "CATEGORIES.CATEGORY_NAME, "+
       "CATEGORIES.CATEGORY_TYPE "+
      "FROM MUSICS, CATEGORIES, ARTISTS, MUSIC_TRACKS "+
      "WHERE ARTISTS.ARTIST_ID=MUSICS.ARTIST_ID "+
      "AND CATEGORIES.CATEGORY_ID=MUSICS.CATEGORY_ID "+
      "AND MUSICS.RECORDING_ID=MUSIC_TRACKS.RECORDING_ID "+
      "AND MUSICS.RECORDING_ID=?";
      connection = getConnection();
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setInt(1,id);
      ResultSet musicsResultSet = statement.executeQuery();
      CachedRowSet musicsRowSet = new CachedRowSetImpl();
      musicsRowSet.populate(musicsResultSet);
      //you can close the connection now.
      connection.close();
      Artist artist = null;
      Category category = null;
      int currentTrackId=-1;
      int previousTrackId=-1;
      while (musicsRowSet.next()){
        if (music ==null){
          music = new Music();
          music.setId(id);
          music.setTitle(musicsRowSet.getString("Album_Title"));
          music.setNumberOfTracks(musicsRowSet.getInt("Num_Tracks"));
          music.setPrice(musicsRowSet.getDouble("Price"));
          music.setStockCount(musicsRowSet.getInt("Stock_Count"));
          artist = new Artist();
          music.setArtist(artist);
          artist.setId(musicsRowSet.getInt("Artist_Id"));
          artist.setName(musicsRowSet.getString("Artist_Name"));
          category = new Category();
          music.setCategory(category);
          category.setId(musicsRowSet.getInt("Category_Id"));
          category.setName(musicsRowSet.getString("Category_Name"));
          category.setType(musicsRowSet.getString("Category_Type"));
        }
        currentTrackId=musicsRowSet.getInt("Track_Id");
        if (currentTrackId!=previousTrackId){
          Track track = new Track();
          music.getTracks().add(track);
          track.setId(currentTrackId);
          track.setTitle(musicsRowSet.getString("Track_Title"));
          track.setDuration(musicsRowSet.getInt("duration"));
        }
        previousTrackId = currentTrackId;
      }
    }
    catch(SQLException e){
      throw e;
    }
    finally{
      if (connection!=null){
        try{
          connection.close();
        }
        catch(Exception e2){
          //do nothing - can't do anything anyway.
        }
      }
    }
    return music;
  }


  /**
   * @param id - Id of a video
   * @return - returns on Video Object
   */
  public Video getVideo(int id) throws SQLException, ClassNotFoundException {
    Connection  connection = null;
    Video       video      = null;
    try{
      String sql =
        "SELECT VIDEOS.*, "+
         "ACTORS.ACTOR_ID, "+
         "ACTORS.ACTOR_NAME, "+
         "DIRECTORS.DIRECTOR_ID, "+
         "DIRECTORS.DIRECTOR_NAME, "+
         "CATEGORIES.CATEGORY_ID, "+
         "CATEGORIES.CATEGORY_NAME, "+
         "CATEGORIES.CATEGORY_TYPE "+
        "FROM DIRECTORS,CATEGORIES,VIDEOS, ACTORS, VIDEO_ACTORS "+
        "WHERE CATEGORIES.CATEGORY_ID=VIDEOS.CATEGORY_ID "+
        "AND DIRECTORS.DIRECTOR_ID=VIDEOS.DIRECTOR_ID "+
        "AND ACTORS.ACTOR_ID=VIDEO_ACTORS.ACTOR_ID "+
        "AND VIDEOS.RECORDING_ID=VIDEO_ACTORS.RECORDING_ID "+
        "AND VIDEOS.RECORDING_ID=id";
      connection = getConnection();
      PreparedStatement statement = connection.prepareStatement(sql);
      ResultSet videosResultSet = statement.executeQuery();
      CachedRowSet videossRowSet = new CachedRowSetImpl();
      videossRowSet.populate(videosResultSet);

      // you can close the connection now.
      connection.close();

      // init loop variables
      int currentVideoId=-1;
      int previousVideoId=-1;
      int currentActorId=-1;
      int previousActorId=-1;
      Category category = null;
      Director director = null;
      while (videossRowSet.next()){
        currentVideoId=videossRowSet.getInt("Recording_Id");

        //new Video
        if (currentVideoId!=previousVideoId){
          video = new Video();
          video.setId(currentVideoId);
          video.setTitle(videossRowSet.getString("Video_Title"));
          video.setStockCount(videossRowSet.getInt("Stock_Count"));
          video.setRating(videossRowSet.getString("rating"));
          video.setPrice(videossRowSet.getDouble("Price"));
          video.setDuration(videossRowSet.getInt("duration"));
          category = new Category();
          video.setCategory(category);
          category.setId(videossRowSet.getInt("Category_Id"));
          category.setName(videossRowSet.getString("Category_Name"));
          category.setType(videossRowSet.getString("Category_Type"));
          director = new Director();
          video.setDirector(director);
          director.setId(videossRowSet.getInt("Director_Id"));
          director.setName(videossRowSet.getString("Director_Name"));

        }
        previousVideoId=currentVideoId;
        currentActorId=videossRowSet.getInt("Actor_Id");
        if (currentActorId!=previousActorId){
          Actor actor = new Actor();
          video.getActors().add(actor);
          actor.setId(currentActorId);
          actor.setName(videossRowSet.getString("Actor_Name"));
        }
        previousActorId = currentActorId;
      }
    }
    catch(SQLException e){
      throw e;
    }
    finally{
      if (connection!=null){
        try{
          connection.close();
        }
        catch(Exception e2){
          //do nothing - can't do anything anyway.
        }
      }
    }
    return video;
  }



}
