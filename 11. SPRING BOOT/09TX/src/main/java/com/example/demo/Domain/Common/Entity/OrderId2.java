package com.example.demo.Domain.Common.Entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data

@NoArgsConstructor
@AllArgsConstructor
public class OrderId2 {
    @EmbeddedId
    private OrderId id;
    private int quantity;


}

