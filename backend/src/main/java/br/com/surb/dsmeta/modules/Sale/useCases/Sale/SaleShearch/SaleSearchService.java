package br.com.surb.dsmeta.modules.Sale.useCases.Sale.SaleShearch;

import br.com.surb.dsmeta.modules.Sale.dto.SaleDTO;
import br.com.surb.dsmeta.modules.Sale.filter.SaleFilter;
import br.com.surb.dsmeta.modules.Sale.infra.entities.Sale;
import br.com.surb.dsmeta.modules.Sale.infra.repositories.SaleRepository;
import br.com.surb.dsmeta.modules.Sale.specification.SaleSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class SaleSearchService {
  @Autowired
  private SaleRepository repository;

  @Autowired
  private SaleSpecification specification;

  @Transactional(readOnly = true)
  public Page<SaleDTO> execute(SaleFilter filter, Pageable pageable){
    Page<Sale> entity = repository.findAll(specification.sales(filter), pageable);
    return entity.map(dto -> new SaleDTO(dto));
  }
//
//  @Transactional(readOnly = true)
//  public Page<SaleDTO> execute2(LocalDate min, LocalDate max, Pageable pageable){
//    Page<Sale> entity = repository.findSales(min, max, pageable);
//    System.out.println("Sales"  + entity);
//    return entity.map(dto -> new SaleDTO(dto));
//  }
//  @Transactional(readOnly = true)
//  public Page<SaleDTO> execute3(Pageable pageable){
//    Page<Sale> users = repository.findAll(pageable);
//    return users.map(sale -> new SaleDTO(sale));
//  }
}
