package org.scaler.parkinglot.strategies.payment;

import org.scaler.parkinglot.models.Bill;
import org.scaler.parkinglot.models.PaymentMode;
import org.scaler.parkinglot.models.PaymentStatus;

public interface PaymentStrategy {

    public PaymentStatus pay(Bill bill, int amount, PaymentMode mode);
}
