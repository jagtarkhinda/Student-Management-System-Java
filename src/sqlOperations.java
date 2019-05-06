import java.sql.*;
import java.util.Scanner;

public class sqlOperations {
    private String phone, dob, fName, lName, major,majorforearch,lNameforsearch, gpa;
    StringBuilder sb = new StringBuilder();
    private long sid, idforsearch;
    //private float ;
    
    public void setIdForSearch(long idforsearch) {
        this.idforsearch = idforsearch;
    }
    public void setMajorForSearch(String majorForSearch) {
        this.majorforearch = majorForSearch;
    }
    public void setLNameForSearch(String LNameForSearch) {
        this.lNameforsearch = LNameForSearch;
    }

    public void tableFormat(int colnum)
    {
        String[] label = {"ID", "FirstName", "LastName", "Major", "Phone", "GPA", "DOB"};

        for (int k = 0; k < colnum; k++) {
            System.out.print(String.format("| %-12s", label[k]));
        }
        System.out.println();
        System.out.println("===========================================================" +
                           "==============================================");
    }

    /** The setSqlData Method is used to get the values from user and the insert them into table name 'sdata'
     * using the insert query MYSQL database*/
    public void setSqlData() {
            date obj = new date();
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter Studen ID");
            sid = Long.parseLong(scan.next());

            scan.nextLine();
            System.out.println("Enter Studen First Name");
            fName = scan.nextLine().toLowerCase();

            System.out.println("Enter Studen Last Name");
            lName = scan.nextLine().toLowerCase();

            System.out.println("Enter Major");
            major = scan.nextLine().toLowerCase();

            System.out.println("Enter Phone");
            phone = scan.nextLine();

            System.out.println("Enter GPA");
            gpa = scan.nextLine();

            //passing data to date class
            System.out.println("Enter DOB \n" + "Month: eg: 9 ");
            obj.setMonth(scan.nextInt());

            System.out.println("Day: eg 5 or 25 ");
            obj.setDay(scan.nextInt());

            System.out.println("Year: eg 1995 ");
            obj.setYear(scan.nextInt());

            //getting data from date class
            dob = obj.getDOB();

            //inserting data in sql
            try
            {
                String sql = ("INSERT INTO sdata " + "VALUES (?,?,?,?,?,?,?)");
                PreparedStatement pst = dbConnection.getConnection().prepareStatement(sql);
                pst.setLong(1, sid);
                pst.setNString(2, fName);
                pst.setNString(3, lName);
                pst.setNString(4, major);
                pst.setNString(5, phone);
                pst.setNString(6, gpa);
                pst.setString(7, dob);
                pst.executeUpdate();
            } catch (SQLException e1)
            {
                System.out.println("Not able to enter data in sql");
                System.out.println(e1.getErrorCode());
                System.out.println(e1.getSQLState());
            }
        }

    /** The getSqlData Method is used to fetch the table from database and show it to user*/
    public void getSqlData(){
            try{
                Statement mystm = dbConnection.getConnection().createStatement();
                ResultSet rs= mystm.executeQuery("SELECT * FROM sdata");
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                //calling tableFormat method
                tableFormat(columnsNumber);
                while (rs.next())
                {
                    for(int i = 1 ; i <= columnsNumber; i++)
                    {
                        System.out.print(String.format("| %-12s",rs.getString(i)));
                    }
                    System.out.println();
                    System.out.println("===========================================================" +
                            "==============================================");
                }
            }catch (SQLException e1){
                System.out.println("Can not Display records"); }
    }

    /** The searchSqlData Method is used to search the table by StudentID or First Name of Last Name and
     * then show the results to user*/
    public void searchSqlData(int srch)
    {
            try{
                Statement mystm = dbConnection.getConnection().createStatement();
                String srchitem=null, afterw=null;
                if(srch==1)
                {
                    srchitem = Long.toString(idforsearch);
                    afterw = "Student_ID";
                }else if(srch==2)
                {
                    srchitem = lNameforsearch;
                    afterw = "Student_Last_Name";
                }else if(srch==3)
                {
                    srchitem = majorforearch;
                    afterw = "Major";
                }
                System.out.println("SELECT * FROM sdata WHERE '"+afterw+"' =`"+srchitem+"`");
                ResultSet rs= mystm.executeQuery("SELECT * FROM sdata WHERE `"+afterw+"`='"+srchitem+"'");
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnsNumber = rsmd.getColumnCount();

                //calling tableFormat method
                tableFormat(columnsNumber);
                while (rs.next())
                {
                    for(int i = 1 ; i <= columnsNumber; i++)
                    {
                        System.out.print(String.format("| %-12s",rs.getString(i)));
                    }
                    System.out.println();
                    System.out.println("===========================================================" +
                            "==============================================");
                }
                if(rs.first()==false){
                    System.out.println("No record matching to your search");
                }
            }catch (SQLException e1){
                System.out.println("Query not wroking"); }
         }

    /** The sortSqlData Method is used to sort and display the data to user by First Name of Last Name and
     * major */
    public void sortSqlData(int srch,int order)
    {
            try{
                Statement mystm = dbConnection.getConnection().createStatement();
                String[] label = {"Student_First_Name","Student_Last_Name","Major"};
                String afterw=null,aftero=null;
                for(int i=1;i<=srch;i++)
                {
                    if(srch==i) afterw = label[i-1];
                    else if(i>srch){
                        System.out.println("Please enter a valid choice"); }
                }
                if(order ==1) aftero="ASC";
                else if (order==2) aftero="DESC";

                System.out.println("SELECT * FROM sdata ORDER BY `"+afterw+"`"+ aftero);
                ResultSet rs= mystm.executeQuery("SELECT * FROM sdata ORDER BY `"+afterw+"`"+ aftero);
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnsNumber = rsmd.getColumnCount();

                //calling tableFormat method
                tableFormat(columnsNumber);
                while (rs.next())
                {
                    for(int i = 1 ; i <= columnsNumber; i++)
                    {
                        System.out.print(String.format("| %-15s",rs.getString(i)));
                    }
                    System.out.println();
                    System.out.println("===========================================================" +
                            "==============================================");
                }
                if(rs.first()==false){
                    System.out.println("No record matching to your search");
                }
            }catch (SQLException e1){
                System.out.println("Query not wroking"); }
        }

    /** The searchSqlData Method is used to search the table by StudentID or First Name of Last Name and
     * then show the results to user*/
    public void updateSqlData(String set,String setafter,String where,String whereafter) {
            try {
                Statement mystm = dbConnection.getConnection().createStatement();

                System.out.println("update sdata set `" + set + "`='" + setafter + "' where `" + where + "`='" + whereafter + "'");
                mystm.executeUpdate("update sdata set `" + set + "`='" + setafter + "' where `" + where + "`='" + whereafter + "'");

                System.out.println("Database updated successfully");
            } catch (SQLException e1) {
                System.out.println("Query not wroking");
            }
    }
}
