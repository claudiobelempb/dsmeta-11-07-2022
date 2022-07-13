package br.com.surb.dsmeta.modules.Sale.useCases.Sale.SaleFindAllPage;

import br.com.surb.dsmeta.modules.Sale.dto.SaleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sales")
public class SalesFindAllPageResource {

  @Autowired
  private SalesFindAllPageService service;

  @GetMapping
  public ResponseEntity<Page<SaleDTO>> handle(Pageable pageable)
  {
    /*PARAMETRISE: page, size, direction, sort*/
    Page<SaleDTO> dto = service.execute(pageable);
    return ResponseEntity.ok().body(dto);
  }
}
