package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyJDBConnection {
	enum FinishFlag {
		RAN_SUCCESFULLY, COULD_NOT_ESTABLISH_CONNECTION, DID_NOT_START
	}

	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "org.sqlite.JDBC";  

	// database link: jdbc:mysql://localhost/EMP
	// parameters start with '?' and are separated by &
	   static final String DB_URL = "jdbc:sqlite:Resources/EMP.db";//"jdbc:sqlite:Resources/EMP.db";

	public String connectCustom1() {

		// used to print output text; instead of system.out
		StringBuilder sbLog = new StringBuilder();

		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			sbLog.append("Connecting to database...\n");
			conn = DriverManager.getConnection(DB_URL);

			// STEP 4: Execute a query
			sbLog.append("Creating statement...\n");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT id, first, last, age FROM Employees";
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				int age = rs.getInt("age");
				String first = rs.getString("first");
				String last = rs.getString("last");

				// Display values
				sbLog.append("ID: " + id);
				sbLog.append(", Age: " + age);
				sbLog.append(", First: " + first);
				sbLog.append(", Last: " + last + "\n");
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		sbLog.append("Goodbye!\n");

		return sbLog.toString();
	}// end main

	public String connectCustom2() {

		// used to print output text; instead of system.out
		StringBuilder sbLog = new StringBuilder();

		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			sbLog.append("Connecting to database...\n");
			conn = DriverManager.getConnection(DB_URL);

			// STEP 4: Execute a query
			sbLog.append("Creating statement...\n");
			stmt = conn.createStatement();
			String sql;
			sql = "INSERT INTO Employees VALUES (104, 27, 'Fernez', 'Mandiga')";

			final int rs = stmt.executeUpdate(sql);

			if (rs > 0)
				sbLog.append("newRows: " + rs + "\n");

			// STEP 5: Extract data from result set
			// while(rs.next()){
			// //Retrieve by column name
			// int id = rs.getInt("id");
			// int age = rs.getInt("age");
			// String first = rs.getString("first");
			// String last = rs.getString("last");
			//
			// //Display values
			// sbLog.append("ID: " + id);
			// sbLog.append(", Age: " + age);
			// sbLog.append(", First: " + first);
			// sbLog.append(", Last: " + last+"\n");
			// }
			// STEP 6: Clean-up environment
			// rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		sbLog.append("Goodbye!\n");

		return sbLog.toString();
	}// end main

	public String connectCustom3() {

		// used to print output text; instead of system.out
		StringBuilder sbLog = new StringBuilder();

		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			sbLog.append("Connecting to database...\n");
			conn = DriverManager.getConnection(DB_URL);

			// STEP 4: Execute a query
			sbLog.append("Creating statement...\n");
			stmt = conn.createStatement();
			String sql;
			sql = "DELETE FROM Employees WHERE id=104 AND age=27 AND first='Fernez' AND last='Mandiga'";

			final int rs = stmt.executeUpdate(sql);

			if (rs > 0)
				sbLog.append("newRows: " + rs + "\n");

			// STEP 5: Extract data from result set
			// while(rs.next()){
			// //Retrieve by column name
			// int id = rs.getInt("id");
			// int age = rs.getInt("age");
			// String first = rs.getString("first");
			// String last = rs.getString("last");
			//
			// //Display values
			// sbLog.append("ID: " + id);
			// sbLog.append(", Age: " + age);
			// sbLog.append(", First: " + first);
			// sbLog.append(", Last: " + last+"\n");
			// }
			// STEP 6: Clean-up environment
			// rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		sbLog.append("Goodbye!\n");

		return sbLog.toString();
	}// end main

	/**
	 * @param sql
	 *            SQL statement, meant to be executed
	 * @return log generated by the statement execution
	 */
	public String executeSQL_StatementForDatabaseEmployees(final String sql) {
		// used to print output text; instead of system.out
		StringBuilder sbLog = new StringBuilder();
		FinishFlag finishFlag = FinishFlag.DID_NOT_START;
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			sbLog.append("Connecting to database...\n");
			
				conn = DriverManager.getConnection(DB_URL);
			

			// STEP 4: Execute a query
			sbLog.append("Creating statement...\n");
			stmt = conn.createStatement();

			// execute statement
			final boolean bReturnedResultSet = stmt.execute(sql);
			// STEP 5: Get and append result to log

			if (bReturnedResultSet == true) {
				final ResultSet rs = stmt.getResultSet();
				while (rs.next()) {
					// Retrieve by column name
					int id = rs.getInt("id");
					int age = rs.getInt("age");
					String first = rs.getString("first");
					String last = rs.getString("last");

					// Display values
					sbLog.append("ID: " + id);
					sbLog.append(", Age: " + age);
					sbLog.append(", First: " + first);
					sbLog.append(", Last: " + last + "\n");
				}
				rs.close();
			} else {
				final int uc = stmt.getUpdateCount();
				sbLog.append("newRows: " + uc + "\n");
			}
			// STEP 6: Clean-up environment
			stmt.close();
			conn.close();
			finishFlag = FinishFlag.RAN_SUCCESFULLY;
		} catch (SQLException se) {
			finishFlag=FinishFlag.COULD_NOT_ESTABLISH_CONNECTION;
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		if (finishFlag != FinishFlag.RAN_SUCCESFULLY)
			return null;
		
		return sbLog.toString();
	}

}
