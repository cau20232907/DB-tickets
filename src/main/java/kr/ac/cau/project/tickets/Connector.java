package kr.ac.cau.project.tickets;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Connector {
    Map<String, String> env = System.getenv();
    String dbUrl = "jdbc:mysql://localhost:3306/tickets";
    String dbUser = "root";
    String dbPassword = "N*3XnSw5JNL9";

    Connection dbconn = null;

    public void dbConnection()
    {
        Connection connection = null;

        try
        {
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            dbconn = connection;

            System.out.println("DB Connection [Success]");
        }
        catch (SQLException e)
        {
            System.out.println("DB Connection [fail]");
            e.printStackTrace();
        }
    }
    public void dbClose()
    {
        try
        {
            if(dbconn != null)
            {
                dbconn.close();
                dbconn = null;
                System.out.println("DB Close [success]");
            }
        }
        catch (SQLException e)
        {
            System.out.println("DB Close [fail]");
            e.printStackTrace();
        }
    }

    public List<Object> selectSample(String sql) {

        Statement st = null;

        Map<String, Object> tempMap = new HashMap<String, Object>();
        List<Object> resultList = new ArrayList<Object>();

        try {
            st = dbconn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //System.out.println("Query : " + sql);

            while (rs.next()) {
                for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                    tempMap.put(rs.getMetaData().getColumnName(i + 1), rs.getString(rs.getMetaData().getColumnName(i + 1)));
                }

                resultList.add(tempMap);
                tempMap = new HashMap<>();    // tempMap reset
            }

            rs.close();
            st.close();
        } catch (SQLException se1) {
            se1.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
        }

        return resultList;
    }
}
