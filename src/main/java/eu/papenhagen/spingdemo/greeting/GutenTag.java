/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.spingdemo.greeting;

import eu.papenhagen.spingdemo.GreetingService;

import org.springframework.stereotype.Component;

/**
 * Formal German greeting
 *
 * @author Jens Papenhagen
 */
@Component
public class GutenTag implements GreetingService {

    @Override
    public String greeting(String name) {
        String output = "Guten Tag " + name;
        return output;
    }

}
