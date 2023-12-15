package org.zerock.w2.listener;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

@WebListener
@Log4j2
public class ServletContextListener implements javax.servlet.ServletContextListener {

    // 프로젝트 실행 시 로그 출력
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        log.info("----------------init---------------------------");
        log.info("----------------init---------------------------");
        log.info("----------------init---------------------------");
    }

    // 프로젝트 종료 시 로그 기록
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        log.info("----------------destroy---------------------------");
        log.info("----------------destroy---------------------------");
        log.info("----------------destroy---------------------------");
    }
}
