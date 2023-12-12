package org.zerock.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectTests {

    /* 간단한 연산을 통해 JUnit이 바르게 작동하는지 먼저 시험해 본 후,
    * 정상 작동하면 드라이버와 연결하도록 한다. */

    /*
    // 1. JUnit 동작 테스트
    @Test
    public void test1() {

        int v1 = 10;
        int v2 = 10;

        Assertions.assertEquals(v1, v2);
    }
    */

    // 2. 드라이버 연결 테스트
    /*
    @Test
    public void testConnection() throws Exception {

        Class.forName("org.mariadb.jdbc.Driver");

        // 드라이버 연결 : url, user, password 받아오기
        Connection connection = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/webdb",
                "webuser",
                "webuser");

        Assertions.assertNotNull(connection);

        connection.close();
    }
    */

    // HikariCP 테스트
    @Test
    public void testHikariCP() throws Exception {
        HikariConfig config = new HikariConfig();

        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3306/webdb");
        config.setUsername("webuser");
        config.setPassword("webuser");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource ds = new HikariDataSource(config);
        Connection connection = ds.getConnection();

        System.out.println(connection);

        connection.close();
    }
}
