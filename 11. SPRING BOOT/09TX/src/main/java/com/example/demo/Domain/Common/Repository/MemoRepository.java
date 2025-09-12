package com.example.demo.Domain.Common.Repository;

import com.example.demo.Domain.Common.Entity.Memo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MemoRepository  extends JpaRepository<Memo,Long> {

    Slice<Memo> findByTextContaining(String keyword, Pageable pageable);
}
