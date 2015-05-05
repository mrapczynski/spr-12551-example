package edu.fhda.spr12551demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO: Description goes here. Provide additional detail about the features of this controller
 *
 * @version 1.0
 */
@Controller
public class AppController {

    /* SLF4J Logger */
    private final static Logger log = LoggerFactory.getLogger(AppController.class);

    /* Spring beans */
    @Autowired DataSource dataSource;

    /**
     * Root application binding.
     */
    @RequestMapping(value = {"/", "/index"})
    public ModelAndView index() {
        // Create page model
        ModelAndView view = new ModelAndView("index");

        // Render the view template
        return view;
    }

    /**
     * Handle any exceptions encountered, and a dump a JSON object with details back to the client.
     * @param error The exception that was thrown
     * @param response The HTTP response object associated with the request
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handleErrorException(Exception error, HttpServletResponse response) {
        // Create a Map with details about the exception
        Map<String, Object> map = new HashMap<>();
        map.put("error", Boolean.TRUE);
        map.put("type", error.getClass().getName());
        map.put("message", error.getMessage());

        // Set HTTP response code
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        // Return
        return map;
    }

}
