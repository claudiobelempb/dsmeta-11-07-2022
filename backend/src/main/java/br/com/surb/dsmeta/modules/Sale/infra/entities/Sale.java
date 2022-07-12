package br.com.surb.dsmeta.modules.Sale.infra.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_sales")
public class Sale implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String sellerName;
  private Integer visited;
  private Integer deals;
  private Double amount;
  private LocalDateTime date;

  public Sale(){}

  public Sale(Long id, String sellerName, Integer visited, Integer deals, Double amount, LocalDateTime date) {
    this.id = id;
    this.sellerName = sellerName;
    this.visited = visited;
    this.deals = deals;
    this.amount = amount;
    this.date = date;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSellerName() {
    return sellerName;
  }

  public void setSellerName(String sellerName) {
    this.sellerName = sellerName;
  }

  public Integer getVisited() {
    return visited;
  }

  public void setVisited(Integer visited) {
    this.visited = visited;
  }

  public Integer getDeals() {
    return deals;
  }

  public void setDeals(Integer deals) {
    this.deals = deals;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

//  @PrePersist
//  private void prePersist() {
////    id = UUID.randomUUID().toString();
////    date = LocalDateTime.now();
//  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Sale sale = (Sale) o;
    return Objects.equals(id, sale.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}