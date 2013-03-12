package com.github.rmannibucau;

import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.apache.deltaspike.jsf.api.config.view.View;

import javax.inject.Named;

@View
@Named
public class CalcController {
    private float number1 = 0;
    private float number2 = 0;
    private float result;

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
        return result;
    }

    public Class<? extends ViewConfig> computeResult() {
        result = number1 + number2;
        return CalcPages.Result.class;
    }
}
