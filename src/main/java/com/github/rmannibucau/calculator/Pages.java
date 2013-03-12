package com.github.rmannibucau.calculator;

import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.apache.deltaspike.jsf.api.config.view.View;

/**
 * using codi is ATM more efficient
 * because of @PageBean, @InitView, PrePageAction...
 */
@View(basePath = "/")
public interface Pages extends ViewConfig {
    @View(name = "index")
    public static class Home implements Pages {}

    @View(navigation = View.NavigationMode.REDIRECT)
    public static class Result implements Pages {}
}
