package com.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
/**
 * @Author tdragon.
 * @Date 2020/11/28.
 * @Time 10:44
 * @Description:
 */
public class BaseDao {

    private Connection connection=null;

    private PreparedStatement ps=null;

    private ResultSet rs=null;

    private static String driver;

    private static String url;

    private static String username;

    private static String password;



//    static{
//        initial();
//    }
//
//    public static void initial(){
//        Properties properties=new Properties();
//        InputStream is=BaseDao.class.getClassLoader().getResourceAsStream("database.properties");
//        try {
//            properties.load(is);
//
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        driver=properties.getProperty("driver");
//        url=properties.getProperty("url");
//        username=properties.getProperty("username");
//        password=properties.getProperty("password");
//
//    }

    //链接数据库
    public boolean getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
//            Class.forName(driver);
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/qfsys","root","root");
        } catch (SQLException  | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }


    //关闭数据库
    public void closeall(Connection connection,PreparedStatement ps,ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }



    //增删改
    public int executeUpdate(String sql,Object[] params){
        int count=0;
        if(this.getConnection()){
            try {
                ps=connection.prepareStatement(sql);
                for(int i=0;i<params.length;i++){
                    ps.setObject(i+1, params[i]);
                }
                count=ps.executeUpdate();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        return count;
    }

    //查询
    public ResultSet executeSQL(String sql,Object[] params){
        if(this.getConnection()){
            try {
                ps=connection.prepareStatement(sql);
                for(int i=0;i<params.length;i++){
                    ps.setObject(i+1, params[i]);
                }
                rs=ps.executeQuery();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                    e.printStackTrace();
            }
        }
        return rs;
    }

    public static void main(String[] args) throws Exception {

        System.out.println(new BaseDao().getConnection());
    }
}
