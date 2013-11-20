mysqladmin --host=localhost --user=%2 --password=%3 create %1
mysql --host=localhost --user=%2 --password=%3 --database=%1 < ebus.sql
