package com.zeroq6.java.design_pattern.action.mediator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteMediator extends Mediator {

    private List<Colleague> colleagues = new ArrayList<>();

    public void register(Colleague colleague) {

        if (!colleagues.contains(colleague)) {

            colleagues.add(colleague);

            colleague.setMedium(this);

        }

    }

    public void relay(Colleague cl) {

        for (Colleague colleague : colleagues) {

            if (!colleague.equals(cl)) {

                colleague.receive();

            }

        }

    }

}

