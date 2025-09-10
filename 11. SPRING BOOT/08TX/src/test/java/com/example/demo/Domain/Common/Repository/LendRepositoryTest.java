package com.example.demo.Domain.Common.Repository;

import com.example.demo.Domain.Common.Entity.Book;
import com.example.demo.Domain.Common.Entity.Lend;
import com.example.demo.Domain.Common.Entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class LendRepositoryTest {
@Autowired
private LendRepository lendRepository;
@Autowired
private UserRepository userRepository;
@Autowired
private BookRepository bookRepository;


@Test
    public void t1()throws Exception{
//    List<Lend> list = lendRepository.findAll();
//    list.forEach(System.out::println);

// Insert
User user =userRepository.findById("손보금").get();
Book book = bookRepository.findById(1L).get();
    Lend lend = Lend.builder()
            .id(null)
            .user(user)
            .book(book)
            .build();
    lendRepository.save(lend);
}


@Test
    public void t2() throws Exception{
//    Book book2 = bookRepository.findById(2L).get();
//    Lend lend2 = new Lend();
//    lend2.setBook(book2);
//    lend2.setUser(user2);
//    lendRepository.save(lend2);
//
//    User user2 = userRepository.findById("손보동").get();


    User user3 = userRepository.findById("손금동").get();
    Book book3 = bookRepository.findById(2L).get();
    Lend lend3 = Lend.builder()
            .id(null)
            .user(user3)
            .book(book3)
            .build();
    lendRepository.save(lend3);

    User user2 = userRepository.findById("손보동").get();
    Book book2 = bookRepository.findById(3L).get();
    Lend lend2 = Lend.builder()
            .id(null)
            .user(user2)
            .book(book2)
            .build();
    lendRepository.save(lend2);



}

@Test
    public void t3() throws Exception{
//   List<Lend> list =  lendRepository.findAllLendsByUser("손금동");
//   list.forEach(System.out::println);


List<Lend> list =  lendRepository.findAllLendsByBook(2L);
list.forEach(System.out::println);

}
@Test
    public void t4() throws Exception{
    System.out.println("-----------------FETCH TEST START--------------------");
    Optional<Lend > lendOptional = lendRepository.findById(2L);
    System.out.println("------------------ lendRepository.findById(2L) invoke...-------------------");
    Lend lend = lendOptional.get();
    System.out.println("------------------ lendOptional.get(); invoke...-------------------");
    User user = lend.getUser();
    System.out.println("------------------lend.getUser(); invoke ... -------------------");
    Book book =lend.getBook();
    System.out.println("------------------lend.getBook() invoke ... -------------------");
    System.out.println("-----------------FETCH TEST END--------------------");


    Book bok = lend.getBook();





}

}




