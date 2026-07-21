package org.example.geektext.model;

import jakarta.persistence.*;

@Entity
@Table
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardId;

    private String cardNumber;
    private String expierationDate;
    private String ccv;

    @ManyToOne@JoinColumn(name = "user_id")
    private User user;

    public int getCardId() {
        return cardId;
    }
    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpierationDate() {
        return expierationDate;
    }

    public void getExpierationDate(String expierationDate) {
        this.expierationDate = expierationDate;
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}


