import java.sql.*;

/**This class is used to make a connection with Database*/

public class dbConnection {
    static Connection mycon=null;

    public static Connection getConnection()
    {
        String db="studata", user = "root", pass = "";
        if (mycon != null) return mycon;
        return getConnection(db,user,pass);
    }

    private static Connection getConnection(String db_name,String user_name,String password)
    {
        try
        {
            mycon=DriverManager.getConnection("jdbc:mysql://localhost/"+db_name+"?user="+user_name+"&password="+password);
        }
        catch(Exception e)
        {
            System.out.println("Not able to connect to the database!, Please Check the connection");
            e.printStackTrace();
        }
        return mycon;
    }
} 