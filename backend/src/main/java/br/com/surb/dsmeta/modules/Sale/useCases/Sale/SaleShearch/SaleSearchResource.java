package br.com.surb.dsmeta.modules.Sale.useCases.Sale.SaleShearch;

import br.com.surb.dsmeta.modules.Sale.dto.SaleDTO;
import br.com.surb.dsmeta.modules.Sale.filter.SaleFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/sales")
public class SaleSearchResource {

  @Autowired
  private SaleSearchService service;


  @GetMapping(value = "/search")
  public ResponseEntity<Page<SaleDTO>> handle(SaleFilter filter, Pageable pageable)
  {
    /*PARAMETRISE: page, size, direction, sort*/
    Page<SaleDTO> dto = service.execute(filter, pageable);
    return ResponseEntity.ok().body(dto);
  }

//  @GetMapping(value = "/search/{min}/{max}")
//  public ResponseEntity<Page<SaleDTO>> handle(@PathVariable LocalDate min, LocalDate max, Pageable pageable)
//  {
//    /*PARAMETRISE: page, size, direction, sort*/
//    Page<SaleDTO> dto = service.execute(min, max, pageable);
//    System.out.println("Sales"  + dto);
//
//
//    return ResponseEntity.ok().body(dto);
//  }
//
//  @GetMapping(value = "/search")
//  public ResponseEntity<Page<SaleDTO>> handle(Pageable pageable){
//    Page<SaleDTO> dto = service.execute(pageable);
//    return ResponseEntity.ok().body(dto);
//  }

}
