package org.zerock.w1.todo.service;

import org.zerock.w1.todo.dto.TodoDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// enum 타입 => 정해진 수만큼만 객체를 생성한다.
public enum TodoService {  // 싱글톤 패턴: 객체를 하나만 생성해서 사용한다.
    // 여러 컨트롤러들이 TodoService 객체를 통해서 원하는 데이터를 주고받는 구조
    INSTANCE;  // (객체 사용시: TodoService.INSTANCE) => 항상 하나의 객체만을 가리킨다.

    // 디버깅 용도의 서비스 객체 출력
    // 새로운 TodoDTO 객체를 받아서 확인한다.
    public void register(TodoDTO dto) {
        System.out.println("DEBUG..." + dto);
    }

    // 등록/목록 메소드
    // 10개의 TodoDTO 객체를 만들어서 반환한다.
    public List<TodoDTO> getList() {

        List<TodoDTO> todoDTOS = IntStream.range(0,10).mapToObj(i -> {
            TodoDTO dto = new TodoDTO();
            dto.setTno((long)i);
            dto.setTitle("Todo.." + i);
            dto.setDueDate(LocalDate.now());

            return dto;
        }).collect(Collectors.toList());

        return todoDTOS;
    }

    // 특정 번호 조회 기능
    public TodoDTO get(Long tno) {

        TodoDTO dto = new TodoDTO();
        dto.setTno(tno);
        dto.setTitle("Sample Todo");
        dto.setDueDate(LocalDate.now());
        dto.setFinished(true);

        return dto;
    }
}
