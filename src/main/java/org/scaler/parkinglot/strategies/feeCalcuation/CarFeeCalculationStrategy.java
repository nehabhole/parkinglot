package org.scaler.parkinglot.strategies.feeCalcuation;

import org.scaler.parkinglot.models.Ticket;

public class CarFeeCalculationStrategy implements FeeCalculationStrategy{
    @Override
    public int calculateFee(Ticket ticket) {
        return 0;
    }
}
