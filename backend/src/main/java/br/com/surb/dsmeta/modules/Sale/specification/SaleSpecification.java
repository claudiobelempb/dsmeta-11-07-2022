package br.com.surb.dsmeta.modules.Sale.specification;

import br.com.surb.dsmeta.modules.Sale.filter.SaleFilter;
import br.com.surb.dsmeta.modules.Sale.infra.entities.Sale;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class SaleSpecification {

  public SaleSpecification(){}

  public Specification<Sale> sales(SaleFilter filter) {
    return (root, query, criteriaBuilder) -> {
      List<Predicate> predicateList = new ArrayList<>();

      if (!ObjectUtils.isEmpty(filter.getSellerName())) {
        predicateList.add(
          criteriaBuilder.like(
            criteriaBuilder.upper(root.get("sellerName")), filter.getSellerName().toUpperCase().concat("%")
          )
        );
      }

//      SELECT date
//      FROM tb_sales
//      WHERE date BETWEEN '2022-06-14' AND '2022-11-15'
//      ORDER BY amount DESC

      if (!ObjectUtils.isEmpty(filter.getVisited())) {
        predicateList.add(
          criteriaBuilder.equal(root.get("visited"), filter.getVisited())
        );
      }

      if (!ObjectUtils.isEmpty(filter.getDate())) {
        predicateList.add(
          criteriaBuilder.greaterThanOrEqualTo(root.get("min"), filter.getDate())
        );
      }

//      if (!ObjectUtils.isEmpty(filter.getDate())) {
//        predicateList.add(
//          criteriaBuilder.equal(root.get("max"), filter.getDate())
//        );
//      }
//
      if (!ObjectUtils.isEmpty(filter.getDate())) {
        Predicate min = criteriaBuilder.equal(root.get("min"), filter.getDate());
        Predicate max = criteriaBuilder.equal(root.get("max"), filter.getDate());
        predicateList.add(
          criteriaBuilder.between(root.get("between"), min, max)
        );
      }


      if (!ObjectUtils.isEmpty(filter.getAmount())) {
        predicateList.add(
          criteriaBuilder.equal(root.get("amount"), filter.getAmount())
        );
      }



//      if (!ObjectUtils.isEmpty(filter.getDate())) {
//        predicateList.add(
//          criteriaBuilder.greaterThanOrEqualTo(root.get("data"), filter.getDate())
//        );
//      }

      return criteriaBuilder.and(predicateList.toArray(Predicate[]::new));
    };
  }
}
