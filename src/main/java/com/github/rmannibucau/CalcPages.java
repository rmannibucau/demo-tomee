package com.github.rmannibucau;

import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.apache.deltaspike.jsf.api.config.view.View;

@View
public interface CalcPages extends ViewConfig {
    @View
    public class Home implements CalcPages {}

    @View
    public class Result implements CalcPages {}
}
