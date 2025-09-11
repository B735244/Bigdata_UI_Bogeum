package com.example.demo.Domain.Common.Repository;

import com.example.demo.Domain.Common.Entity.Memo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

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
@BeforeEach
public void post1000(){
    if(memoRepository.count()==0){
        for(int i =0; i<1000; i++){
            memoRepository.save(new Memo(null,"This is Test "+i,"Writer-"+i,LocalDateTime.now()));
        }
    }
}
//@@@Paging@@@
@Test
    public void t6() throws Exception{
 //   System.out.println(memoRepository.count());
    Pageable pageable =  PageRequest.of(0,10);
   Page<Memo> page =  memoRepository.findAll(pageable);

    System.out.println("현재 페이지 번호: " +page.getNumber());
    System.out.println("한 페이지에 표시 할 건수: "+page.getSize());
    System.out.println("총 게시물 갯수: "+page.getTotalElements());
    System.out.println("총 페이지 갯수: "+page.getTotalPages());
    System.out.println("첫번째 페이지인지의 여부: "+ page.isFirst());
    System.out.println("다음 페이지가 있는지의 여부: "+page.hasNext());
    System.out.println("이전 페이지가 있는지의 여부: "+page.hasPrevious());

    List<Memo> list =page.getContent();
    list.forEach(System.out::println);
    System.out.println("===================");
    Page<Memo> nextPage = memoRepository.findAll(page.nextPageable());
    nextPage.forEach(System.out::println);
    System.out.println("다음페이지 넘버는? :"+nextPage.getNumber());

    //내림차순으로 정렬한 뒤 요청하겠음.
//    Pageable pageable1 = PageRequest.of(0, 10, Sort.by("id").ascending());
//
//    Slice<Memo> slice = memoRepository.findByTextContaining("memo", pageable);
//    System.out.println(slice.getContent());
//    System.out.println(slice.hasNext());
}

}