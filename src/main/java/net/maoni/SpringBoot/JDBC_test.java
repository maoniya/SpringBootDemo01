package net.maoni.SpringBoot;

import java.sql.*;

public class JDBC_test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载JDBC驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //创建数据库的连接
        String url="jdbc:mysql://127.0.0.1:3306/maoni_test2?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String username="root";
        String password="root";
        //获取链接对象并连接数据库
        Connection connection = DriverManager.getConnection(url,username,password);
        //建preparedStatement
        Statement statement =connection.createStatement();
        //执⾏SQL语句
        ResultSet resultSet = statement.executeQuery("select * from video");
        //处理结果集
        while (resultSet.next()){
            System.out.println("视频标题:"+resultSet.getString("title"));
        }
        //闭JDBC对象资源
        statement.close();
    }
}
