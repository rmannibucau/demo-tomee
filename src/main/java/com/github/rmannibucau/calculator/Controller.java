package com.github.rmannibucau.calculator;

import org.apache.deltaspike.core.api.config.view.ViewConfig;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Named
@SessionScoped
public class Controller implements Serializable {
    @Inject
    private StatReporter reporter;

    private Computation computation = new Computation();

    public Class<? extends ViewConfig> computeResult() {
        reporter.incComputations();
        return Pages.Result.class;
    }

    public Class<? extends ViewConfig> getHome() {
        return Pages.Home.class;
    }

    public Computation getComputation() {
        return computation;
    }

    public static class Computation implements Serializable {
        private static final Collection<String> OPERANDS = new ArrayList<String>();
        static {
            for (final Operation o : Operation.values()) {
                OPERANDS.add(o.getSymbol());
            }
        }

        private float number1 = 0;
        private float number2 = 0;
        private Operation operation = Operation.values()[0];

        public float getNumber1() {
            return number1;
        }

        public void setNumber1(final float number1) {
            this.number1 = number1;
        }

        public float getNumber2() {
            return number2;
        }

        public void setNumber2(final float number2) {
            this.number2 = number2;
        }

        public float getResult() {
            return operation.compute(number1, number2);
        }

        public Operation getOperation() {
            return operation;
        }

        public void setOperation(final Operation operation) {
            this.operation = operation;
        }

        public Operation[] getOperands() {
            return Operation.values();
        }
    }
}
