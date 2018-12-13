#!/bin/bash
database_name=mysql
username=root

mysql.server start 

for file in "$@"
do
    echo "runnning $file.sql"
    mysql -h localhost -P 80 -u $username $database_name < $file.sql
    echo ""
done
