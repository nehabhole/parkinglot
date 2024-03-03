package org.scaler.parkinglot.strategies.feeCalcuation;

import org.scaler.parkinglot.models.Ticket;

public class BusFeeCalculationStrategy implements FeeCalculationStrategy{
    @Override
    public int calculateFee(Ticket ticket) {
        return 0;
    }
}
