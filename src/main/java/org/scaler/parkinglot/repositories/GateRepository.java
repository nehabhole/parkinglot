package org.scaler.parkinglot.repositories;

import com.sun.source.tree.Tree;
import org.scaler.parkinglot.models.Gate;
import org.scaler.parkinglot.models.GateStatus;
import org.scaler.parkinglot.models.GateType;
import org.scaler.parkinglot.models.Operator;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class GateRepository {
    private TreeMap<Integer, Gate> gates = new TreeMap<>();
    private int gateId = 0;

    public Gate addGate(int gateNo, GateType gateType, Operator operator){
        gateId++;
        Gate gate = new Gate();
        gate.setGateStatus(GateStatus.OPEN);
        gate.setGateType(gateType);
        gate.setGateNo(gateNo);
        gate.setOperator(operator);
        gates.put(gateId,gate);
        return gate;
    }

    public Optional<Gate> findGateById(int gateId) {
        if (gates.containsKey(gateId)) {
            return Optional.of(gates.get(gateId));
        }
        return Optional.empty();
    }



}
