package us.abstracta.sparring.model;

import lombok.Data;

@Data
public class PaymentInfo {

    private int id;
    private int quantity;
    private String name;
    private int cardNumber;
    private int cvv;

    public PaymentInfo(
            int id, int quantity, String name, int cardNumber, int cvv) {
        this.id=id;
        this.quantity=quantity;
        this.name=name;
        this.cardNumber=cardNumber;
        this.cvv=cvv;
    }
    public PaymentInfo(){ }

}
