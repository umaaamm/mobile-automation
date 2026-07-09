package com.company.automation.base;

import com.company.automation.utils.ElementActions;
import com.company.automation.utils.GestureActions;
import com.company.automation.utils.KeyboardActions;

public abstract class BasePage {

    protected final ElementActions element;
    protected final GestureActions gesture =
            new GestureActions();
    protected final KeyboardActions keyboard =
            new KeyboardActions();

    protected BasePage() {
        element = new ElementActions();
    }
}