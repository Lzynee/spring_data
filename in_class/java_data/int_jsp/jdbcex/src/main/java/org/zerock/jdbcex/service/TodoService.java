package org.zerock.jdbcex.service;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zerock.jdbcex.dao.TodoDAO;
import org.zerock.jdbcex.domain.TodoVO;
import org.zerock.jdbcex.dto.TodoDTO;
import org.zerock.jdbcex.util.MapperUtil;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum TodoService {
    INSTANCE;

    private TodoDAO dao;
    private ModelMapper modelMapper;

    TodoService() {

        dao = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();

    }

    // TodoDTO를 파라미터로 받아서 TodoVO로 변환한다.
    public void register(TodoDTO todoDTO) throws Exception {

        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);

        System.out.println("todoVO: " + todoVO);  // 변환 여부 확인

        // TodoDAO를 이용해서 insert()를 실행하고 TodoVO를 등록한다.
        dao.insert(todoVO);  // int를 반환하므로 이를 이용해서 예외처리도 가능

    }

    // 컨트롤러와 TodoService를 연동한다.
    // TodoDAO에서 가져온 TodoVO의 목록을 모두 TodoDTO로 변환해서 반환한다.
    public List<TodoDTO> listAll() throws Exception {

        List<TodoVO> voList = dao.selectAll();

        log.info("voList =======================");
        log.info(voList);

        List<TodoDTO> dtoList = voList.stream()
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());

        return dtoList;
    }

}
