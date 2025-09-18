package com.example.demo.domain.repository;

import com.example.demo.domain.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




//interface가 원래 Dao역할을 대신함.
//여기서 Memo는 현재 Repository가 다룰 엔티티이고
//Long은 엔티티의 Primary Key타입을 말합니다.
//이렇게하면 Memo 엔티티를 관리할 수 있는 Repository가 자동으로 구현 됨.
@Repository
public interface MemoRepository extends JpaRepository<Memo,Long> {
}
