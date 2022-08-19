package edu.nyu.jws.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;


import edu.nyu.jws.model.Actor;
import edu.nyu.jws.model.Artist;
import edu.nyu.jws.model.Category;
import edu.nyu.jws.model.Director;
import edu.nyu.jws.model.Music;
import edu.nyu.jws.model.Track;
import edu.nyu.jws.model.Video;


/**
 * @author root
 *
 */
public class ProductDAO implements ProductDAOIF {

	public ProductDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param categoryName - The music category name like 'Jazz'
	 * @return a List of Music that matches the categoryName - exact match
	 */
	public List<Music> getMusic(String categoryName) throws SQLException, ClassNotFoundException {
		List<Music>       myList               = null;
		Connection        myConnection         = null;
	    CachedRowSet      myCachedRowSet       = null;
		PreparedStatement myPreparedStatement  = null;
	    String            mySql                = null;
	    ResultSet         myResultSet          = null;

	    Music         myMusic        = null;
		Artist        myArtist       = null;
		Track         myTrack        = null;
		Category      myCategory     = null;

	    // use this as a switch field when videoId changes value
	    int           currentMusicId    = -1;
	    int           previousMusicId   = -1;

	    // use this as a switch field when actorId changes value
	    int           currentTrackId    = -1;
	    int           previousTrackId   = -1;

	    // MUSICS table variables
	    int           musicId           = -1;
//	    int           musicArtistId     = -1;
	    String        musicTitle        = null;
	    int           musicNumTracks    = -1;
	    Double        musicPrice        = -1.0;
	    int           musicStockCount   = -1;
//	    int           musicCategoryId   = -1;

	    // CATEGORIES table variables
	    int           categoryId        = -1;
	    String        categoryNameTemp  = null;
	    String        categoryType      = null;

	    // ARTISTS table variables
	    int           artistId          = -1;
	    String        artistName        = null;

	    // MUSIC_TRACKS table variables
	    int           musictrackTrackId     = -1;
//	    int           musictrackRecordingId = -1;
	    String        musictrackTrackTitle  = null;
	    int           musictrackDuration    = -1;


	    // instantiate the myList object.
	    myList       = new ArrayList<Music>();

	    // build MUSICS sql
	    mySql = new String("SELECT DISTINCT ");
	    mySql = mySql.concat("  MUSICS.RECORDING_ID");
//	    mySql = mySql.concat(", MUSICS.ARTIST_ID");
	    mySql = mySql.concat(", MUSICS.ALBUM_TITLE");
	    mySql = mySql.concat(", MUSICS.NUM_TRACKS");
	    mySql = mySql.concat(", MUSICS.PRICE");
	    mySql = mySql.concat(", MUSICS.STOCK_COUNT");
//	    mySql = mySql.concat(", MUSICS.CATEGORY_ID");
	    mySql = mySql.concat(", CATEGORIES.CATEGORY_ID");
	    mySql = mySql.concat(", CATEGORIES.CATEGORY_NAME");
	    mySql = mySql.concat(", CATEGORIES.CATEGORY_TYPE");
	    mySql = mySql.concat(", ARTISTS.ARTIST_ID");
	    mySql = mySql.concat(", ARTISTS.ARTIST_NAME");
	    mySql = mySql.concat(", MUSIC_TRACKS.TRACK_ID");
//	    mySql = mySql.concat(", MUSIC_TRACKS.RECORDING_ID");
	    mySql = mySql.concat(", MUSIC_TRACKS.TRACK_TITLE");
	    mySql = mySql.concat(", MUSIC_TRACKS.DURATION");
	    mySql = mySql.concat("  from  MUSICS, CATEGORIES, ARTISTS, MUSIC_TRACKS");
	    mySql = mySql.concat("  where MUSICS.RECORDING_ID=MUSIC_TRACKS.RECORDING_ID ");
	    mySql = mySql.concat("  and   MUSICS.ARTIST_ID=ARTISTS.ARTIST_ID");
	    mySql = mySql.concat("  and   MUSICS.CATEGORY_ID=CATEGORIES.CATEGORY_ID");
	    mySql = mySql.concat("  and   LOWER(CATEGORIES.CATEGORY_NAME)=?");
	    mySql = mySql.concat("  ORDER BY MUSICS.RECORDING_ID");
        System.out.println("getMusics SQL:[" + mySql.toString() + "]");

	    myConnection = getConnection();
	    if (null != myConnection) {

	    	// get the data
		    try {
		    	// prepare and execute the statement
		    	myPreparedStatement = myConnection.prepareStatement(mySql);
				myPreparedStatement.setString(1, categoryName.toLowerCase());
	            System.out.println(myPreparedStatement.getClass().getName());
		        myResultSet = myPreparedStatement.executeQuery();
	            System.out.println(myResultSet.getClass().getName());

		        // create into CachedRowSet object
				myCachedRowSet = new CachedRowSetImpl();
		        // populate CachedRowSet object
	            myCachedRowSet.populate(myResultSet);
	            System.out.println(myCachedRowSet.getClass().getName());

	            // db socket is no longer needed, clean it up.
				myConnection.close();

				// null check
    	    	if (null != myCachedRowSet) {

    	    		// scan CachedRowSet for data
    	    		while (myCachedRowSet.next()){

    	    			// get the current recording id from row set
    	    			currentMusicId = myCachedRowSet.getInt("Recording_Id");
    	    		    // test the video switch values
    	    			if (currentMusicId != previousMusicId) {

    	    				// create new video object
    	    				myMusic = new Music();

    	    				// save myMusic object into List
    		    		    myList.add(myMusic);

        	    		    // save music fields into local variables
    	        		    musicId         = myCachedRowSet.getInt("Recording_Id");
    	        		    musicTitle      = myCachedRowSet.getString("Album_Title");
    	        		    musicNumTracks  = myCachedRowSet.getInt("Num_Tracks");
    	        		    musicPrice      = myCachedRowSet.getDouble("Price");
    	        		    musicStockCount = myCachedRowSet.getInt("Stock_Count");
    	    	    	    // save data into music object
                            myMusic.setId(musicId);
                            myMusic.setTitle(musicTitle);
                            myMusic.setNumberOfTracks(musicNumTracks);
                            myMusic.setPrice(musicPrice);
                            myMusic.setStockCount(musicStockCount);


    	    	    	    // create the category object
    	    	    	    myCategory = new Category();
    	    	    	    // save category object into music object
    	    	    	    myMusic.setCategory(myCategory);
    	    	    	    // save category fields into local variables
    	    	    	    categoryId       = myCachedRowSet.getInt("Category_Id");
    	    	    	    categoryNameTemp = myCachedRowSet.getString("Category_Name");
    	    	    	    categoryType     = myCachedRowSet.getString("Category_Type");
    	    	    	    // save data into category object
    	    	    	    myCategory.setId(categoryId);
               	    	    myCategory.setName(categoryNameTemp);
    	    	    	    myCategory.setType(categoryType);


    	    	    	    // create the artist object
    	    	    	    myArtist = new Artist();
    	    	    	    // save category object into music object
    	    	    	    myMusic.setArtist(myArtist);
    	    	    	    // save category fields into local variables
    	    	    	    artistId   = myCachedRowSet.getInt("Artist_Id");
    	    	    	    artistName = myCachedRowSet.getString("Artist_Name");
      	    	    	    // save data into category object
    	    	    	    myArtist.setId(artistId);
    	    	    	    myArtist.setName(artistName);
    	    	    	    
    	    			}   //  if (currentMusicId != previousMusicId) {
    	    			previousMusicId = currentMusicId;
    	    			
    	    			// append to track list
    					currentTrackId = myCachedRowSet.getInt("Track_Id");
    					if (currentTrackId != previousTrackId){
        	    		    // create a new track object
    						myTrack = new Track();
        	    		    // save track object into list
    						myMusic.getTracks().add(myTrack);

        	    		    // save music_track fields into local variables
    						musictrackTrackId    = currentTrackId;
    						musictrackTrackTitle = myCachedRowSet.getString("Track_Title");
    						musictrackDuration   = myCachedRowSet.getInt("Duration");
        	    		    // save local fields into music_track fields into local variables
    						myTrack.setId(currentTrackId);
    						myTrack.setTitle(musictrackTrackTitle);
    						myTrack.setDuration(musictrackDuration);
    					}   //  if (currentTrackId!=previousTrackId){
    					previousTrackId = currentTrackId;

	    		    }   //  while (myCachedRowSet.next()){
	    	    }   //  if (null != myCachedRowSet) {

		    }
	        catch(SQLException e){
	            while (null != e){
	                e.printStackTrace();
	                e = e.getNextException();
	            }
	        }
	        catch(Exception e){
	            e.printStackTrace();
	        }

	    }   //  if (null != myConnection) {

	    
		return myList;
	};

	/**
	 * @param title - Partial video title like 'star' or 'the'
	 * @return a List of Video that matches the title
	 *         - NOT case sensitive and SQL like match
	 */
	public List<Video> getVideo(String title) throws SQLException, ClassNotFoundException {
		List<Video>       myList         = null;
		Connection        myConnection         = null;
	    CachedRowSet      myCachedRowSet       = null;
		PreparedStatement myPreparedStatement  = null;
	    String            mySql                = null;
	    ResultSet         myResultSet          = null;

		Video         myVideo        = null;
		Category      myCategory     = null;
		Director      myDirector     = null;
		Actor         myActor        = null;

	    // use this as a switch field when videoId changes value
	    int           currentVideoId    = -1;
	    int           previousVideoId   = -1;

	    // use this as a switch field when actorId changes value
	    int           currentActorId    = -1;
	    int           previousActorId   = -1;

	    // VIDEOS table variables
	    int           videoId           = -1;
	    String        videoTitle        = null;
//	    int           videoCategoryId   = -1;
	    int           videoDuration     = -1;
	    String        videoRating       = null;
	    Double        videoPrice        = -1.0;
	    int           videoStockCount   = -1;
//	    int           videoDirectorId   = -1;
	    int           videoYearReleased = -1;

	    // CATEGORIES table variables
	    int           categoryId        = -1;
	    String        categoryName      = null;
	    String        categoryType      = null;

	    // DIRECTORS table variables
	    int           directorId        = -1;
	    String        directorName      = null;

	    // VIDEO_ACTORS table variables
//	    int           videoactorRowId       = -1;
//	    int           videoactorActorId     = -1;
//	    int           videoactorRecordingId = -1;

	    // ACTORS table variables
	    int           actorId           = -1;
	    String        actorName         = null;


	    // instantiate the myList object.
	    myList = new ArrayList<Video>();

	    // build VIDEOS sql
		mySql = new String("SELECT DISTINCT ");
	    mySql = mySql.concat("  VIDEOS.RECORDING_ID");
	    mySql = mySql.concat(", VIDEOS.VIDEO_TITLE");
//	    mySql = mySql.concat(", VIDEOS.CATEGORY_ID");
	    mySql = mySql.concat(", VIDEOS.DURATION");
	    mySql = mySql.concat(", VIDEOS.RATING");
	    mySql = mySql.concat(", VIDEOS.PRICE");
	    mySql = mySql.concat(", VIDEOS.STOCK_COUNT");
//	    mySql = mySql.concat(", VIDEOS.DIRECTOR_ID");
	    mySql = mySql.concat(", VIDEOS.YEAR_RELEASED");
	    mySql = mySql.concat(", CATEGORIES.CATEGORY_ID");
	    mySql = mySql.concat(", CATEGORIES.CATEGORY_NAME");
	    mySql = mySql.concat(", CATEGORIES.CATEGORY_TYPE");
	    mySql = mySql.concat(", DIRECTORS.DIRECTOR_ID");
	    mySql = mySql.concat(", DIRECTORS.DIRECTOR_NAME");
//	    mySql = mySql.concat(", VIDEO_ACTORS.ROW_ID");
//	    mySql = mySql.concat(", VIDEO_ACTORS.ACTOR_ID");
//	    mySql = mySql.concat(", VIDEO_ACTORS.RECORDING_ID");
	    mySql = mySql.concat(", ACTORS.ACTOR_ID");
	    mySql = mySql.concat(", ACTORS.ACTOR_NAME");
	    mySql = mySql.concat("  from  VIDEOS, CATEGORIES, DIRECTORS, VIDEO_ACTORS, ACTORS ");
	    mySql = mySql.concat("  where VIDEOS.CATEGORY_ID=CATEGORIES.CATEGORY_ID");
	    mySql = mySql.concat("  and   VIDEOS.DIRECTOR_ID=DIRECTORS.DIRECTOR_ID");
	    mySql = mySql.concat("  and   VIDEOS.RECORDING_ID=VIDEO_ACTORS.RECORDING_ID");
	    mySql = mySql.concat("  and   VIDEO_ACTORS.ACTOR_ID=ACTORS.ACTOR_ID");
	    mySql = mySql.concat("  and   LOWER(VIDEOS.VIDEO_TITLE) LIKE ?");
	    mySql = mySql.concat("  ORDER BY VIDEOS.RECORDING_ID");
        System.out.println("getVideos SQL:[" + mySql.toString() + "]");

	    myConnection = getConnection();
	    if (null != myConnection) {

	    	// get the data
		    try {
		    	// prepare and execute the statement
		    	myPreparedStatement = myConnection.prepareStatement(mySql);
				myPreparedStatement.setString(1, "%" +title.toLowerCase() + "%");
	            System.out.println(myPreparedStatement.getClass().getName());
		        myResultSet = myPreparedStatement.executeQuery();
	            System.out.println(myResultSet.getClass().getName());

		        // create into CachedRowSet object
				myCachedRowSet = new CachedRowSetImpl();
		        // populate CachedRowSet object
	            myCachedRowSet.populate(myResultSet);
	            System.out.println(myCachedRowSet.getClass().getName());

	            // db socket is no longer needed, clean it up.
				myConnection.close();
    	
		    	
		    	if (null != myCachedRowSet) {

		    		// save into list.
		    		while (myCachedRowSet.next()){

		    			// get the current recording id from row set
		    			currentVideoId = myCachedRowSet.getInt("Recording_Id");
		    		    // test the video switch values
		    			if (currentVideoId != previousVideoId) {

		    				// create new video object
		    				myVideo = new Video();

		    				// save myMusic object into List
			    		    myList.add(myVideo);

	    	    		    // save video fields into local variables
		        		    videoId           = currentVideoId;
		        		    videoTitle        = myCachedRowSet.getString("Video_Title");
		    	    	    videoDuration     = myCachedRowSet.getInt("Duration");
		    	    	    videoRating       = myCachedRowSet.getString("Rating");;
		    	    	    videoPrice        = myCachedRowSet.getDouble("Price");
		    	    	    videoStockCount   = myCachedRowSet.getInt("Stock_Count");
		    	    	    videoYearReleased = myCachedRowSet.getInt("Year_Released");
	    	    	        // store data into video object
		    	    	    myVideo.setId(videoId);
		    	    	    myVideo.setTitle(videoTitle);
		    	    	    myVideo.setDuration(videoDuration);
		    	    	    myVideo.setRating(videoRating);
		    	    	    myVideo.setPrice(videoPrice);
		    	    	    myVideo.setStockCount(videoStockCount);
		    	    	    myVideo.setYearReleased(videoYearReleased);


		    	    	    // create the category object
		    	    	    myCategory = new Category();
		    	    	    // save category object into video object
		    	    	    myVideo.setCategory(myCategory);
		    	    	    // save category fields into local variables
		    	    	    categoryId       = myCachedRowSet.getInt("Category_Id");
		    	    	    categoryName     = myCachedRowSet.getString("Category_Name");
		    	    	    categoryType     = myCachedRowSet.getString("Category_Type");
		    	    	    // save data into category object
		    	    	    myCategory.setId(categoryId);
		    	    	    myCategory.setName(categoryName);
		    	    	    myCategory.setType(categoryType);


		    	    	    // create the director object
	                        myDirector = new Director();
		    	    	    // save director object into video object
		    	    	    myVideo.setDirector(myDirector);
	    	    		    // save director fields into local variables
		    	    	    directorId       = myCachedRowSet.getInt("Director_Id");
		    	    	    directorName     = myCachedRowSet.getString("Director_Name");
		    	    	    // save data into director object
		    	    	    myDirector.setId(directorId);
		    	    	    myDirector.setName(directorName);

		    			}
		    			// reset the video switch
						previousVideoId = currentVideoId;

						// get the current actor switch from row set
						currentActorId = myCachedRowSet.getInt("Actor_Id");

		    		    // test the actor switch values
						if (currentActorId!=previousActorId){
							// actors have changed, create a new actor object
							myActor = new Actor();
							// save actor into current video object
							myVideo.getActors().add(myActor);
	    	    		    // save actor fields into local variables
							actorId   = currentActorId;
							actorName = myCachedRowSet.getString("Actor_Name");
							// save local data into actor object
							myActor.setId(actorId);
							myActor.setName(actorName);
						}
						previousActorId = currentActorId;

		    		}   //  while (myCachedRowSet.next()){

		    	}   //  if (null != myCachedRowSet) {

		    }
	        catch(SQLException e){
	            while (null != e){
	                e.printStackTrace();
	                e = e.getNextException();
	            }
	        }
	        catch(Exception e){
	            e.printStackTrace();
	        }

	    }   //  if (null != myConnection) {


	    return myList;
	};


	/**
	0 * @param - none
	 * @return a connection object
	 */
	public Connection getConnection() {

	    PropertyResourceBundle bundle = null;
	    String driver                 = null;
	    String connectionString       = null;
	    Connection connection         = null;

	    try{
	        // load Database.properties file
	        bundle = (PropertyResourceBundle) ResourceBundle.getBundle("Database");

	        // get the JDBC driver class name from the bundle
	        driver = bundle.getString("database.JDBCDriver");

	        // load the driver class.
	        Class.forName(driver);

	        // get the url from the bundle.
	        connectionString = bundle.getString("database.connectionString");

	        // get a db connection for caller
	        connection = DriverManager.getConnection(connectionString);
	    }
        catch(SQLException e){
            while (null != e){
                e.printStackTrace();
                e = e.getNextException();
            }
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }

		return connection;
	}

}
