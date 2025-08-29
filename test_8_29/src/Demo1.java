import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo1 {
    public static void main(String[] args) throws SQLException {
        //1. 创建数据源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/109java?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("111111");

        Connection connection = dataSource.getConnection();

        //2. 写sql 语句
        String sql =  "insert into student values('胡汉三', 29)";
        PreparedStatement statement = connection.prepareStatement(sql);

        //3. 把 sql 发送给服务器
        int n = statement.executeUpdate();
        System.out.println(n);

        //关闭资源
        statement.close();
        connection.close();
        
    }
}
