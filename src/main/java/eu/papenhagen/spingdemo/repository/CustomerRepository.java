/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.spingdemo.repository;

import eu.papenhagen.spingdemo.entity.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jens Papenhagen
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    
}
