package br.com.surb.dsmeta.modules.Sale.useCases.Sale.SaleFindAllPage;

import br.com.surb.dsmeta.modules.Sale.dto.SaleDTO;
import br.com.surb.dsmeta.modules.Sale.infra.entities.Sale;
import br.com.surb.dsmeta.modules.Sale.infra.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SalesFindAllPageService {

  @Autowired
  private SaleRepository repository;

  @Transactional(readOnly = true)
  public Page<SaleDTO> execute(Pageable pageable){
    Page<Sale> entity = repository.findAll(pageable);
    return entity.map(dto -> new SaleDTO(dto));
  }

}
