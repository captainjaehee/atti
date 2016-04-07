<?

    header('content-type: text/html; charset=utf-8'); 
 
 
    // 데이터베이스 접속 문자열. (db위치, 유저 이름, 비밀번호)
    $connect=mysql_connect('127.0.0.1', 'root', 'apmsetup') or die( 'SQL server에 연결할 수 없습니다.');
 
    
    mysql_query('SET NAMES UTF8');
   // 데이터베이스 선택
   mysql_select_db('ps3reg',$connect);
 
 
   // 세션 시작
   session_start();
 
 
 
   $id = $_POST['u_id'];
 
   $sql = "insert into ps3reg(regID) select '$id' from dual where not exists(select * from ps3reg where regID='$id')";
 
   $result = mysql_query($sql,$connect);
 
   if(!$result)
            die('mysql query error');

   mysql_close($connect);
        
   echo "$result";
 
?>


