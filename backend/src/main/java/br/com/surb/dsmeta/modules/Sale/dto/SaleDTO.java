package br.com.surb.dsmeta.modules.Sale.dto;

import br.com.surb.dsmeta.modules.Sale.infra.entities.Sale;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class SaleDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;
  private String sellerName;
  private Integer visited;
  private Integer deals;
  private Double amount;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDateTime date;

  public SaleDTO(){}

  public SaleDTO(Long id, String sellerName, Integer visited, Integer deals, Double amount, LocalDateTime date) {
    this.id = id;
    this.sellerName = sellerName;
    this.visited = visited;
    this.deals = deals;
    this.amount = amount;
    this.date = date;
  }

  public SaleDTO(Sale sale){
    id = sale.getId();
    sellerName= sale.getSellerName();
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

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }
}
