<?php

require_once "DataObject.class.php";

class Message extends DataObject {

  protected $data = array(
    "id" => "",
    "member_id" => "",
    "message_text" => "",
    "create_timestamp" => "",
    "num_access" => "",
    "subject" => ""
  );

  public static function getMessages( $member_id ) {
    $conn = parent::connect();
    $sql = "SELECT * FROM " . TBL_MESSAGE . " WHERE member_id = :member_id ORDER BY create_timestamp DESC";

    try {
      $st = $conn->prepare( $sql );
      $st->bindValue( ":member_id", $member_id, PDO::PARAM_INT );
      $st->execute();
      $messages = array();
      foreach ( $st->fetchAll() as $row ) {
        $messages[] = new Message( $row );
      }
      parent::disconnect( $conn );
      return $logMesssages;
    } catch ( PDOException $e ) {
      parent::disconnect( $conn );
      die( "Query failed: " . $e->getMessage() );
    }
  }


  public function record() {
    $conn = parent::connect();
    $sql  = "SELECT * FROM " . TBL_MESSAGE . " ";
    $sql .= "WHERE member_id = :member_id and message_text = :message_text and subject = :subject";

    try {
      $st = $conn->prepare( $sql );
      $st->bindValue( ":member_id", $this->data["member_id"], PDO::PARAM_INT );
      $st->bindValue( ":message_text", $this->data["message_text"], PDO::PARAM_STR );
      $st->bindValue( ":subject", $this->data["subject"], PDO::PARAM_STR );
      $st->execute();
      //  var_dump($sql, $this->data, $st);

      if ( $st->fetch() ) {
        $sql  = "UPDATE " . TBL_MESSAGE . " SET num_access = num_access + 1 ";
        $sql .= "WHERE member_id = :member_id and message_text = :message_text and subject = :subject";
        $st = $conn->prepare( $sql );
        $st->bindValue( ":member_id", $this->data["member_id"], PDO::PARAM_INT );
        $st->bindValue( ":message_text", $this->data["message_text"], PDO::PARAM_STR );
        $st->bindValue( ":subject", $this->data["subject"], PDO::PARAM_STR );
        //  var_dump($sql, $st);
        $st->execute();
      } else {
        $sql  = "INSERT INTO " . TBL_MESSAGE . " ( member_id, message_text, num_access, subject ) ";
        $sql .=                         " VALUES ( :member_id, :message_text, 1, :subject )";
        $st = $conn->prepare( $sql );
        $st->bindValue( ":member_id", $this->data["member_id"], PDO::PARAM_INT );
        $st->bindValue( ":message_text", $this->data["message_text"], PDO::PARAM_STR );
        $st->bindValue( ":subject", $this->data["subject"], PDO::PARAM_STR );
        //  var_dump($sql, $st);
        $st->execute();
      }

      //  var_dump($sql, $st);

      parent::disconnect( $conn );
    } catch ( PDOException $e ) {
      parent::disconnect( $conn );
      die( "Query failed: " . $e->getMessage() );
    }
  }


}

?>
