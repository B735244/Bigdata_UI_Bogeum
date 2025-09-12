package com.example.demo.Domain.Common.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//복합키 처리 방식!!
@Entity
@Table(name="orders")
@IdClass(OrderId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    //1
    @Id
    private Long orderId;
    @Id
    private Long productId;
    private int quantity;
}
