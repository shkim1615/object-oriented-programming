package com.example.term_project.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
public class CommonController {
    @PersistenceContext
    private EntityManager entityManager;

    public CommonController() {
        log.info("CommonController instantiated");
    }

    @PostMapping("/api/login1")
    public ResponseEntity<String> login1(@RequestBody Map<String, String> params, HttpServletResponse response) {
        String username = params.get("username");
        String password = params.get("password");

        log.info("username: {}", username);
        log.info("password: {}", password);

        // DB에서 해당 유저가 존재하는지 + status가 approved인지 확인
        String sql = "SELECT COUNT(*) FROM users WHERE username = :username AND password = :password AND status = 'approved'";

        Object result = entityManager.createNativeQuery(sql)
                .setParameter("username", username)
                .setParameter("password", password)
                .getSingleResult();

        Long count = (result instanceof Number) ? ((Number) result).longValue() : 0L;

        if (count > 0) {
            return ResponseEntity.ok("login success");
        } else {
            return ResponseEntity.status(401).body("login failed: 아이디/비밀번호/승인 여부 확인");
        }
    }
    @PostMapping("/api/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> params, HttpServletResponse response) {
        String username = params.get("username");
        String password = params.get("password");

        log.info("username: {}", username);
        log.info("password: {}", password);

        try {
            String sql = "SELECT * FROM users WHERE username = :username AND password = :password AND status = 'approved'";

            Object result = entityManager.createNativeQuery(sql)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();

            Object[] userRow = (Object[]) result;

            log.info("로그인 유저 정보:");
            log.info("id: {}", userRow[0]);
            log.info("username: {}", userRow[1]);
            log.info("password: {}", userRow[2]);
            log.info("name: {}", userRow[3]);
            log.info("email: {}", userRow[4]);
            log.info("is_admin: {}", userRow[5]);
            log.info("status: {}", userRow[6]);
            log.info("created_at: {}", userRow[7]);

            return ResponseEntity.ok("login success");

        } catch (NoResultException | jakarta.persistence.NonUniqueResultException e) {
            return ResponseEntity.status(401).body("login failed: 사용자 정보 없음 또는 중복됨");
        }
    }

}
