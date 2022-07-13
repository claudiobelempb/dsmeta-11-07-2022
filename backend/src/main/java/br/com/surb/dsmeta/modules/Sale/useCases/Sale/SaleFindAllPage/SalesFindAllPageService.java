package br.com.surb.dsmeta.modules.Sale.useCases.Sale.SaleFindAllPage;

import br.com.surb.dsmeta.modules.Sale.dto.SaleDTO;
import br.com.surb.dsmeta.modules.Sale.infra.entities.Sale;
import br.com.surb.dsmeta.modules.Sale.infra.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class SalesFindAllPageService {

  @Autowired
  private SaleRepository repository;

  @GetMapping
  @Transactional(readOnly = true)
  public Page<SaleDTO> execute(String minDate, String maxDate, Pageable pageable){

    LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

    LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
    LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
    Page<Sale> users = repository.findSales(min, max, pageable);
    return users.map(sale -> new SaleDTO(sale));
  }

}
