/**
 * HikariDataSource를 이용하여 SQL 처리를 전담한다.
 * */

package org.zerock.jdbcex.dao;

import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TodoDAO {

    // try-with-resources 기능을 이용해서
    // try() 내에 선언된 변수들이 자동으로 close()되도록 한다.
    public String getTime() {

        String now = null;

        try (Connection connection = ConnectionUtil.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select now()");
             ResultSet resultSet = preparedStatement.executeQuery();
             )
                
        {
            resultSet.next();
            now = resultSet.getString(1);
        }
        
        catch (Exception e) {
            System.out.println("현재 시각 출력 실패");
            e.printStackTrace();
        }

        return now;
    }

    // try-with-resource 대신 Lombok의 @CLeanup을 이용하는
    // getTime()과 동일한 메서드
    public String getTime2() throws Exception {

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement("select now()");
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();

        String now = resultSet.getString(1);

        return now;
    }
}
