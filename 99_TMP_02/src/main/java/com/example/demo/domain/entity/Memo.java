package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="memo")//DB에 만들어지는 테이블의 이름을 memo라고 하겠다.
@Data//toString, getter/setter 자동생성
@NoArgsConstructor// 디폴트 생성자 자동생성
@AllArgsConstructor// 모든 인자 생성자 자동생성
@Builder// 빌더 자동 생성
public class Memo {
    @Id //이 빌드를 Primary Key로  사용하겠다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto Increment를 사용하여 자동으로 ID에 숫자가 메겨지도록 함.
    private Long id;
    private String text;
    private String writer;
    private LocalDateTime createAt;
}
