package dao;
import java.sql.SQLException;
import java.util.List;

import model.Music;
import model.Video;

public interface ProductDAOIF {

  /**
   * @param categoryName - The music category name like 'Jazz'
   * @return a List of Music that matches the categoryName - exact match
   */
  public List<Music> getMusic(String categoryName) throws SQLException;

  /**
   * @param title - Partial video title like 'star' or 'the'
   * @return a List of Video that matches the title - NOT case sensitive and SQL like match
   */
  public List<Video> getVideo(String title) throws SQLException;

  /**
   * @param id - Id of a music
   * @return - returns on Music Object
   */
  public Music getMusic(int id) throws SQLException;

  /**
   * @param id - Id of a video
   * @return - returns on Video Object
   */
  public Video getVideo(int id) throws SQLException, ClassNotFoundException;

}
