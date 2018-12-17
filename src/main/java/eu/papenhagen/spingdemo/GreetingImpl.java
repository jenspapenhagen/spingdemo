/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.spingdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * Impl. of Geeting
 *
 * @author Jens Papenhagen
 */
@Component
public class GreetingImpl {

    @Autowired
    private GreetingService greetingService;

    public String greeting(@NonNull String name) {
        return greetingService.greeting(name);
    }

}
