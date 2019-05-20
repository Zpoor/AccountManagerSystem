package cn.zpoor.account.utils;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

/**
 * 获取数据库连接的工具类，实现DBCP连接池
 */
public class JDBCUtil {
    private static BasicDataSource dataSource = new BasicDataSource();

    //设置连接池
    static {
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/account");
        dataSource.setUsername("root");
        dataSource.setPassword("19950820");
        dataSource.setMaxActive(10);
        dataSource.setMaxIdle(5);
        dataSource.setMinIdle(2);
        dataSource.setInitialSize(10);
    }

    //获取数据源
    public static DataSource getDataSource() {
        return dataSource;
    }
}
