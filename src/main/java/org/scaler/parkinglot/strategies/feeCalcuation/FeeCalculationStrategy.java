package org.scaler.parkinglot.strategies.feeCalcuation;

import org.scaler.parkinglot.models.Ticket;

public interface FeeCalculationStrategy {
    public int calculateFee(Ticket ticket);
}
