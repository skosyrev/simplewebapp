package com.example.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Calculator API
 *
 * @version 0.1
 */
@Controller
@RequestMapping("/calc")
public class CalculatorController {

    @RequestMapping(value = "/multiply", method = RequestMethod.GET)
    @ResponseBody
    public String multiply(@RequestParam(value = "a", required = true) Integer a,
                           @RequestParam(value = "b", required = true) Integer b) {
        return String.valueOf(a * b);
    }

    @RequestMapping(value = "/divide", method = RequestMethod.GET)
    @ResponseBody
    public String divide(@RequestParam(value = "a", required = true) Integer a,
                         @RequestParam(value = "b", required = true) Integer b) {
        if (b.equals(0)) {
            return "second operand is zero";
        }
        return String.valueOf(a / b);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ResponseBody
    public String add(@RequestParam(value = "a", required = true) Integer a,
                      @RequestParam(value = "b", required = true) Integer b) {
        return String.valueOf(a + b);
    }

    /** Return result of substraction */
    @RequestMapping(value = "/substract", method = RequestMethod.GET)
    @ResponseBody
    public String substract(@RequestParam(value = "a", required = true) Integer a,
                            @RequestParam(value = "b", required = true) Integer b) {
        return String.valueOf(a - b);
    }
}
