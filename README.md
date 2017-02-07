#This is a Test Case for Hibernate bug HHH-5998.

As the default H2 database accepts the generated SQL, a MySQL DB is needed for the test to run meaningfully.

Edit the mysql connection parameters in persistence.xml so that it points to an empty mysql database before running.

