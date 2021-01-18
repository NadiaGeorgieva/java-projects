import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DBConnector {//�������� �������� � h2

	private static Connection conn=null;// � �������� �������� � 0
	public static Connection getConnection() {//start connection
		try {
			Class.forName("org.h2.Driver");//����� ����� ����� h2
			conn=DriverManager.getConnection("jdbc:h2:E:\\Cinema\\CinemaDB;AUTO_SERVER=TRUE", "sa", "sa");//����� ����� h2
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return conn;
	}//end connnection
	public static MyModel selectAll(String nameTable) {//start query
		String sql="SELECT * FROM "+nameTable;
		conn=getConnection();
		MyModel model=null;
		ResultSet result=null;
		try {
			PreparedStatement state=conn.prepareStatement(sql);
			result=state.executeQuery();
			try {
				model=new MyModel(result);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return model;
	}//end query
	// ����� �� ��������� �� ����� �� ��
	//table clients delete row
	public static void deleteRow(String tableName, int id) {
		String sql = "delete from " + tableName + " where CLIENT_ID=?";
		conn = DBConnector.getConnection();
		PreparedStatement state = null;
		try {
			state = conn.prepareStatement(sql);
			state.setInt(1, id);
			state.execute();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	//table media delete row
	public static void deleteRow2(String tableName, int id) {
		String sql = "delete from " + tableName + " where MEDIA_ID=?";
		conn = DBConnector.getConnection();
		PreparedStatement state = null;
		try {
			state = conn.prepareStatement(sql);
			state.setInt(1, id);
			state.execute();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	//table clients_media delete row
		public static void deleteRow3(String tableName, int id) {
			String sql = "delete from " + tableName + " where ID=?";
			conn = DBConnector.getConnection();
			PreparedStatement state = null;
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, id);
				state.execute();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	//table client update row
	public static void updateRow(String tableName, int id ) {
		String sql="update"+tableName+" where CLIENT_ID=?";
		conn = DBConnector.getConnection();
		PreparedStatement state = null;
		try {
			state = conn.prepareStatement(sql);
			state.setInt(1, id);	
			state.execute();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	//table media update row
		public static void updateRow2(String tableName, int id ) {
			String sql="update"+tableName+" where MEDIA_ID=?";
			conn = DBConnector.getConnection();
			PreparedStatement state = null;
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, id);	
				state.execute();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		//table clients_media update row
				public static void updateRow3(String tableName, int id ) {
					String sql="update"+tableName+" where ID=?";
					conn = DBConnector.getConnection();
					PreparedStatement state = null;
					try {
						state = conn.prepareStatement(sql);
						state.setInt(1, id);	
						state.execute();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
}
