package com.example.blog.board;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// 책임: DB 상호작용
@RequiredArgsConstructor
@Repository
public class BoardRepository {
    // JPA는 EntityManager로 DB에 접근한다 (자바에서 DBConnection)
    private final EntityManager entityManager;

    public void delete(int id) {
        entityManager.createQuery("delete from Board b where id=:id").setParameter("id", id).executeUpdate();
    }

    public void save(Board board) {
        // 비영속
        entityManager.persist(board);
        // 동기화 완료 (영속화됨)
    }

    public List<Board> findAll() {
        return entityManager.createQuery("select b from Board b order by b.id desc", Board.class).getResultList();
    }

    public Optional<Board> findById(int id) {
        return Optional.ofNullable(entityManager.find(Board.class, id));
    }
}
