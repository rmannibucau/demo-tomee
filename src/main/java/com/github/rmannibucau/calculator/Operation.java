package com.github.rmannibucau.calculator;

public enum Operation {
    PLUS("+", new Computable() { @Override public float compute(float n1, float n2) { return n1 + n2; } }),
    MINUS("-", new Computable() { @Override public float compute(float n1, float n2) { return n1 - n2; } }),
    MULTIPLY("*", new Computable() { @Override public float compute(float n1, float n2) { return n1 * n2; } }),
    DIVIDE("/", new Computable() { @Override public float compute(float n1, float n2) { return n1 / n2; } });

    private final Computable delegate;
    private final String symbol;

    Operation(final String symbol, final Computable computable) {
        this.delegate = computable;
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public float compute(final float n1, final float n2) {
        return delegate.compute(n1, n2);
    }

    private static interface Computable {
        float compute(float n1, float n2);
    }
}
