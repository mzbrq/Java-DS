import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo2 {
    public static void main(String[] args) throws SQLException {
        //读操作

        //1. 创建数据库连接
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/109java?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("111111");

        Connection connection = dataSource.getConnection();

        //2. 写sql
        String sql = "select name, age from student where age <= 30";
        PreparedStatement statement = connection.prepareStatement(sql);

        //3. 发送到服务器
        ResultSet ret = statement.executeQuery(sql);

        //4. 对结果集进行处理
        while (ret.next()) {
            String name = ret.getString("name");
            int age = ret.getInt("age");
            System.out.println("name= "+name + " ,age= "+age );
        }

        //5. 关闭资源
        statement.close();
        connection.close();
    }
}
