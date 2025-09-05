package com.example.demo.Domain.Common.Repository;

import com.example.demo.Domain.Common.Entity.Memo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class MemoRepositoryTest {
@Autowired
    private MemoRepository memoRepository;
@Test
    public void t1()throws Exception{
    Memo memo = new Memo(null, "contents","tesxt@test.com", LocalDateTime.now());

    memoRepository.save(memo);
//새로추가 된 아이디를 확인할 수 있습니다.
    System.out.println("ID :" +memo.getId());
}

    @Test// Update
            public void t2()throws Exception{

            Memo memo = new Memo(1L, "수정 된 내용입니다. 수정할 때도 save를 사용한다.","tesxt@test.com", LocalDateTime.now());

            memoRepository.save(memo);
//새로추가 된 아이디를 확인할 수 있습니다.
            System.out.println("ID :" +memo.getId());

    }
    @Test//Delete
    public void t3()throws Exception{

    memoRepository.deleteById(1L);

    }

    @Test// 단건 조회
    public void t4() throws Exception{
    Optional<Memo> memoOptional = memoRepository.findById(2L);
    if(memoOptional.isPresent()){
        Memo memo = memoOptional.get();
    }
    }

    @Test
    public void t5()throws Exception{
        List<Memo> list = memoRepository.findAll();
        list.forEach(System.out::println);
}

}