<?

    header('content-type: text/html; charset=utf-8'); 
 
 
    // �����ͺ��̽� ���� ���ڿ�. (db��ġ, ���� �̸�, ��й�ȣ)
    $connect=mysql_connect('127.0.0.1', 'root', 'apmsetup') or die( 'SQL server�� ������ �� �����ϴ�.');
 
    
    mysql_query('SET NAMES UTF8');
   // �����ͺ��̽� ����
   mysql_select_db('ps3reg',$connect);
 
 
   // ���� ����
   session_start();
 
 
 
   $id = $_POST['u_id'];
 
   $sql = "insert into ps3reg(regID) select '$id' from dual where not exists(select * from ps3reg where regID='$id')";
 
   $result = mysql_query($sql,$connect);
 
   if(!$result)
            die('mysql query error');

   mysql_close($connect);
        
   echo "$result";
 
?>


