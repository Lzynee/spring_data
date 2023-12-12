/**
 * TodoDAO에서 HikariDataSource에 대한 처리를 쉽게 사용할 수 있도록
 * HikariConfig를 이용해서 HikariDataSource를 enum으로 구성한다.
 * 외부에서 HikariDataSource를 사용할 때 =>
 * ConnectionUtil.INSTANCE.getConnection()을 통해 Connection을 얻는다.
 * */
package org.zerock.jdbcex.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;

public enum ConnectionUtil {

    INSTANCE;

    private HikariDataSource ds;

    ConnectionUtil() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3306/webdb");
        config.setUsername("webuser");
        config.setPassword("webuser");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        ds = new HikariDataSource(config);
    }

    public Connection getConnection() throws Exception {
        return ds.getConnection();
    }
}
