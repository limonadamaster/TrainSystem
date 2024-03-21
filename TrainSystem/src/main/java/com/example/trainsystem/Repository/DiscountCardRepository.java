package com.example.trainsystem.Repository;

import com.example.trainsystem.Entity.DiscoundCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountCardRepository extends JpaRepository<DiscoundCard,Long> {
    DiscoundCard findByCardNumber(String cardNumber);
}
