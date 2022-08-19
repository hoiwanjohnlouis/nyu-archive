<?php

/**
    Cloned from "Beginning PHP 5.3" Wrox book
*/

require_once "DataObject.class.php";

class Member extends DataObject {

  protected $data = array(
    "id" => "",
    "username" => "",
    "first_name" => "",
    "last_name" => "",
    "email" => "",
    "update_timestamp" => "",
    "create_timestamp" => ""
  );

  /**
  */
  public function authenticate() {
    $conn = parent::connect();
    $sql = "SELECT * FROM " . TBL_MEMBER . " WHERE username = :username";

    try {
      $st = $conn->prepare( $sql );
      $st->bindValue( ":username", $this->data["username"], PDO::PARAM_STR );
      $st->execute();
      $row = $st->fetch();
      parent::disconnect( $conn );
      if ( $row ) {
        $member = new Member( $row );
        // var_dump($row);
        // var_dump($member);
        return $member;
      }
    } catch ( PDOException $e ) {
      parent::disconnect( $conn );
      die( "Query failed: " . $e->getMessage() );
    }
  }


  /**
  */
//  public function delete() {
//    $conn = parent::connect();
//    $sql = "DELETE FROM " . TBL_MEMBER . " WHERE id = :id";
//
//    try {
//      $st = $conn->prepare( $sql );
//      $st->bindValue( ":id", $this->data["id"], PDO::PARAM_INT );
//      $st->execute();
//      parent::disconnect( $conn );
//    } catch ( PDOException $e ) {
//      parent::disconnect( $conn );
//      die( "Query failed: " . $e->getMessage() );
//    }
//  }


  /**
  */
  public static function getByUsername( $username ) {
    $conn = parent::connect();
    $sql = "SELECT * FROM " . TBL_MEMBER . " WHERE username = :username";

    try {
      $st = $conn->prepare( $sql );
      $st->bindValue( ":username", $username, PDO::PARAM_STR );
      $st->execute();
      $row = $st->fetch();
      parent::disconnect( $conn );
      if ( $row ) return new Member( $row );
    } catch ( PDOException $e ) {
      parent::disconnect( $conn );
      die( "Query failed: " . $e->getMessage() );
    }
  }


  /**
  */
  public static function getByEmailAddress( $email ) {
    $conn = parent::connect();
    $sql = "SELECT * FROM " . TBL_MEMBER . " WHERE email = :email";

    try {
      $st = $conn->prepare( $sql );
      $st->bindValue( ":email", $email, PDO::PARAM_STR );
      $st->execute();
      $row = $st->fetch();
      parent::disconnect( $conn );
      if ( $row ) return new Member( $row );
    } catch ( PDOException $e ) {
      parent::disconnect( $conn );
      die( "Query failed: " . $e->getMessage() );
    }
  }


  /**
  */
  public static function getMember( $id ) {
    $conn = parent::connect();
    $sql = "SELECT * FROM " . TBL_MEMBER . " WHERE id = :id";

    try {
      $st = $conn->prepare( $sql );
      $st->bindValue( ":id", $id, PDO::PARAM_INT );
      $st->execute();
      $row = $st->fetch();
      parent::disconnect( $conn );
      if ( $row ) {
        return new Member( $row );
      } else {
        return false;
      }
    } catch ( PDOException $e ) {
      parent::disconnect( $conn );
      die( "Query failed: " . $e->getMessage() );
    }
  }


  /**
  */
  public static function getMembers() {
    $conn = parent::connect();
    $sql = "SELECT * FROM " . TBL_MEMBER . " ORDER BY email";

    try {
      $st = $conn->prepare( $sql );
      $st->execute();
      $members = array();
      foreach ( $st->fetchAll() as $row ) {
        $members[] = new Member( $row );
      }
      $st = $conn->query( "SELECT found_rows() as totalRows" );
      $row = $st->fetch();
      parent::disconnect( $conn );
      return array( $members, $row["totalRows"] );
    } catch ( PDOException $e ) {
      parent::disconnect( $conn );
      die( "Query failed: " . $e->getMessage() );
    }
  }


  /**
  */
  public function insert() {
    $conn = parent::connect();
    $sql = "INSERT INTO " . TBL_MEMBER . " (
              username,
              first_name,
              last_name,
              email,
              update_timestamp,
              create_timestamp
        ) VALUES (
              :username,
              :first_name,
              :last_name,
              :email,
              :update_timestamp,
              :create_timestamp
        )";

    try {
      $st = $conn->prepare( $sql );
      $st->bindValue( ":username", $this->data["username"], PDO::PARAM_STR );
      $st->bindValue( ":first_name", $this->data["first_name"], PDO::PARAM_STR );
      $st->bindValue( ":last_name", $this->data["last_name"], PDO::PARAM_STR );
      $st->bindValue( ":email", $this->data["email"], PDO::PARAM_STR );
      $st->bindValue( ":update_timestamp", $this->data["update_timestamp"], PDO::PARAM_STR );
      $st->bindValue( ":create_timestamp", $this->data["create_timestamp"], PDO::PARAM_STR );
      $st->execute();
      parent::disconnect( $conn );
    } catch ( PDOException $e ) {
      parent::disconnect( $conn );
      die( "Query failed: " . $e->getMessage() );
    }
  }


  /**
  */
//  public function update() {
//    $conn = parent::connect();
//    $sql = "UPDATE " . TBL_MEMBER . " SET
//              username = :username,
//              first_name = :firstName,
//              last_name = :lastName,
//              email = :email,
//              update_timestamp = :updateTimestamp
//            WHERE id = :id";
//
//    try {
//      $st = $conn->prepare( $sql );
//      $st->bindValue( ":id", $this->data["id"], PDO::PARAM_INT );
//      $st->bindValue( ":username", $this->data["username"], PDO::PARAM_STR );
//      $st->bindValue( ":first_name", $this->data["first_name"], PDO::PARAM_STR );
//      $st->bindValue( ":last_name", $this->data["last_name"], PDO::PARAM_STR );
//      $st->bindValue( ":email", $this->data["email"], PDO::PARAM_STR );
//      $st->bindValue( ":update_timestamp", $this->data["update_timestamp"], PDO::PARAM_STR );
//      $st->execute();
//      parent::disconnect( $conn );
//    } catch ( PDOException $e ) {
//      parent::disconnect( $conn );
//      die( "Query failed: " . $e->getMessage() );
//    }
//  }


}

?>
