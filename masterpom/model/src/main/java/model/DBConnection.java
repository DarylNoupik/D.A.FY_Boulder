package model;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The Class DBConnection.
 *
 * @author Jean-Aymeric Diet
 */
final class DBConnection {
	/** The instance. */
	private static DBConnection	INSTANCE	= null;

	/** The connection. */
	private Connection					connection;
	/** The statement. */
    private Statement                      statement;
	/**
	 * Instantiates a new DB connection.
	 */
	private DBConnection() {
		this.open();
	}

	/**
	 * Gets the single instance of DBConnection.
	 *
	 * @return single instance of DBConnection
	 */
	public static synchronized DBConnection getInstance() {
		if (DBConnection.INSTANCE == null) {
			DBConnection.INSTANCE = new DBConnection();
		}
		return DBConnection.INSTANCE;
	}

	/**
	 * Open.
	 *
	 * @return the boolean
	 */
	private Boolean open() {
		final DBProperties dbProperties = new DBProperties();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(dbProperties.getUrl(), dbProperties.getLogin(), dbProperties.getPassword());
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	  public static DBConnection getINSTANCE() {
		return INSTANCE;
	}

	public static void setINSTANCE(DBConnection iNSTANCE) {
		INSTANCE = iNSTANCE;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	/**
     * Execute query.
     *
     * @param query
     *            the query
     * @return the result set
     */
    public ResultSet executeQuery(final String query) {
        try {
            return this.getStatement().executeQuery(query);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Execute update.
     *
     * @param query
     *            the query
     * @return the int
     */
    public int executeUpdate(final String query) {
        try {
            return this.statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    /**
     * Prepare call.
     *
     * @param query
     *            the query
     * @return the java.sql. callable statement
     */
    public java.sql.CallableStatement prepareCall(final String query) {
        try {
            return this.getConnection().prepareCall(query);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public Connection getConnection() {
		return this.connection;
	}
}
