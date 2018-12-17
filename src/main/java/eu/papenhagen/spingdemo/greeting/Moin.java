/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.spingdemo.greeting;

import eu.papenhagen.spingdemo.GreetingService;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Moin
 *
 * @author Jens Papenhagen
 */
@Component
@Primary
public class Moin implements GreetingService {

    @Override
    public String greeting(String name) {
        String output = "Moin "+ name;
        return output;
    }

}
