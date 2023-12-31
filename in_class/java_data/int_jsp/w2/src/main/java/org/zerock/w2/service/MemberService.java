package org.zerock.w2.service;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zerock.w2.dao.MemberDAO;
import org.zerock.w2.domain.MemberVO;
import org.zerock.w2.dto.MemberDTO;
import org.zerock.w2.util.MapperUtil;

@Log4j2
public enum MemberService {

    INSTANCE;

    private MemberDAO dao;
    private ModelMapper modelMapper;

    MemberService() {

        dao  = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    // 로그인 처리를 위한 login() 메소드
    public MemberDTO login(String mid, String mpw) throws Exception {

        MemberVO vo = dao.getWithPassword(mid, mpw);

        MemberDTO memberDTO = modelMapper.map(vo, MemberDTO.class);

        return memberDTO;
    }
    // login(mid, mpw)

    // 자동 로그인 처리
    public void updateUuid(String mid, String uuid) throws Exception {
        dao.updateUuid(mid, uuid);
    }
    // 자동 로그인 처리 메소드 끝

    // 쿠키의 값을 이용한 사용자 조회
    public MemberDTO getByUUID(String uuid) throws Exception {

        MemberVO vo = dao.selectUUID(uuid);

        MemberDTO memberDTO = modelMapper.map(vo, MemberDTO.class);

        return memberDTO;
    }
    // 쿠키의 값을 이용한 사용자 조회 메소드 끝
}
