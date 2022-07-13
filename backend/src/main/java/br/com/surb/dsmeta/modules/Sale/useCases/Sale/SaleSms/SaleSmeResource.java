package br.com.surb.dsmeta.modules.Sale.useCases.Sale.SaleSms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sales")
public class SaleSmeResource {

  @Autowired
  private SaleSmsService service;

  @GetMapping("/{id}/notification")
  public void handle(@PathVariable Long id){
     service.execute(id);
  }
}
