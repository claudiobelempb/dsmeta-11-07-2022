package br.com.surb.dsmeta.modules.Sale.filter;

import br.com.surb.dsmeta.modules.Sale.infra.entities.Sale;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class SaleFilter implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;
  private String sellerName;
  private Integer visited;
  private Integer deals;
  private Double amount;
  private LocalDate date;

  public SaleFilter() {
  }

  public SaleFilter(Long id, String sellerName, Integer visited, Integer deals, Double amount, LocalDate date) {
    this.id = id;
    this.sellerName = sellerName;
    this.visited = visited;
    this.deals = deals;
    this.amount = amount;
    this.date = date;
  }

  public SaleFilter(Sale sale) {
    id = sale.getId();
    sellerName = sale.getSellerName();
    visited = sale.getVisited();
    deals = sale.getDeals();
    amount = sale.getAmount();
    date = sale.getDate();
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

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {

  }
}