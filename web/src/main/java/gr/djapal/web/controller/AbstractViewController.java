package gr.djapal.web.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

public class AbstractViewController {

    public static ModelAndView getModelAndView(String viewName, ModelMap model) {
        model.put("view", viewName);
        return new ModelAndView("container", model);
    }

}

