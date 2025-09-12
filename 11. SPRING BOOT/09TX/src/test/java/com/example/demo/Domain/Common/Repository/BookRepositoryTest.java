package com.example.demo.Domain.Common.Repository;

import com.example.demo.Domain.Common.Entity.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @DisplayName("===기본 CRUD확인====")
    @Test
    public void t1() throws Exception{
        Book book = Book.builder()
                .bookCode(1L)
                .bookName("이게자바?")
                .publisher("한빛")
                .isbn("1111-1111")
                .build();





    //Insert
//        bookRepository.save(book);
    //Update
    // bookRepository.save(book);
    //Delete
//        bookRepository.deleteById(1L);
    //Select
     Optional<Book> bookOptional = bookRepository.findById(2L);
     Book book1 = null;
     if(bookOptional.isPresent()){
         book1 =bookOptional.get();
         System.out.println(book1);




     }
     //SelectAll
      List<Book> list= bookRepository.findAll();
     list.forEach(System.out::println);


     //

    };
    @DisplayName("===2. 함수 명명법====")
    @Test
    public void t2()throws Exception{
//        List <Book> list = bookRepository.findByBookName("a");
//        list.forEach(System.out::println);

//        List <Book> list2 = bookRepository.findByPublisher("fdg");
//        list2.forEach(System.out::println);

        List <Book> list3 = bookRepository.findByBookNameContains("a");
        list3.forEach(System.out::println);

    }

}