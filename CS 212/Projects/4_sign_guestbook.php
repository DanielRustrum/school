<?php
    $servername = "tund";
    $username = "dtr63";
    $password = "Gamma666";
    $dbname = "dtr63";

    $conn = new mysqli($servername, $username, $password, $dbname);
    $query  = "INSERT INTO `id` (`name`, `note`) 
            VALUES (`".$_POST["name"]."`,`".$_POST["note"]."`)";
    mysqli_query($connection, $query);


    header("Location: http://cefns.nau.edu/~dtr63/projects/4.html"); /* Redirect browser */
exit();
?>