<?php
    $servername = "tund";
    $username = "dtr63";
    $password = "Gamma666";
    $dbname = "dtr63";
    $conn = new mysqli($servername, $username, $password, $dbname);
    $sql = "SELECT `note` FROM `id`";
    if ($result->num_rows > 0) {
        while($row = $result->fetch_assoc()) {
            echo  $row["name"] . "<br>";
        }
    } else {
        echo "0 results";
    }
    $conn->close();
?>