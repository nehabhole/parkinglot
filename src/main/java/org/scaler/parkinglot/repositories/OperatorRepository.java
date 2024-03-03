package org.scaler.parkinglot.repositories;

import org.scaler.parkinglot.models.Gate;
import org.scaler.parkinglot.models.Operator;
import org.scaler.parkinglot.models.ParkingFloor;
import org.scaler.parkinglot.models.ParkingLot;

import java.util.TreeMap;

public class OperatorRepository {
    private TreeMap<Integer, Operator> operators = new TreeMap<>();
    private int optIndex = 0;

    public Operator addOperator(Integer empNO ){
        optIndex++;
        Operator operator = new Operator();
        operator.setEmpNo(empNO);
        operators.put(optIndex,operator);
        return operator;
    }
}
