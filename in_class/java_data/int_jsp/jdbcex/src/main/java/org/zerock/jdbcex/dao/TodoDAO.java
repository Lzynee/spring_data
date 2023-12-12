/**
 * HikariDataSource를 이용하여 SQL 처리를 전담한다.
 * */

package org.zerock.jdbcex.dao;

import lombok.Cleanup;
import org.zerock.jdbcex.domain.TodoVO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    // 등록 기능 구현
    public void insert(TodoVO vo) throws Exception {
        String sql = "INSERT INTO tbl_todo (title, dueDate, finished)" +
                " VALUES (?, ?, ?)";

        @Cleanup Connection connection
                = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement
                = connection.prepareStatement(sql);

        // sql의 컬럼 인덱스는 1부터 시작
        preparedStatement.setString(1, vo.getTitle());
        preparedStatement.setDate(2, Date.valueOf(vo.getDueDate()));
        preparedStatement.setBoolean(3, vo.isFinished());

        preparedStatement.executeUpdate();  // DML을 실행하는 경우 executeUpdate()를 실행
    }

    // 목록 기능 구현
    // tbl_todo 내의 모든 데이터를 가져온다.
    // 테이블의 각 행이 하나의 TodoVO객체가 됨 => 모든 TodoVO를 List<TodoVO>에 담아 리턴한다.
    public List<TodoVO> selectAll() throws Exception {

        String sql = "select * from tbl_todo";

        @Cleanup Connection connection
                = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement
                = connection.prepareStatement(sql);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        List<TodoVO> list = new ArrayList<>();

        while (resultSet.next()) {

            TodoVO vo = TodoVO.builder()
                    .tno(resultSet.getLong("tno"))
                    .title(resultSet.getString("title"))
                    .dueDate(resultSet.getDate("dueDate").toLocalDate())
                    .finished(resultSet.getBoolean("finished"))
                    .build();

            list.add(vo);
        }

        return list;
    }
}
