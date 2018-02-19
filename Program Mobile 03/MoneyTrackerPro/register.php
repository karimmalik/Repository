<?php
$con = mysqli_connect("localhost", "id4652187_moneytracker", "120612juni", "id4652187_moneytracker");
    $email = $_POST["email"];
    $username = $_POST["username"];
    $password = $_POST["password"];
    $statement = mysqli_prepare($con, "INSERT INTO user (email, username, password) VALUES (?, ?, ?)");
    mysqli_stmt_bind_param($statement, "sss", $email ,$username, $password);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
?>