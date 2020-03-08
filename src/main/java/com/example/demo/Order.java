package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "order_table")
public class Order {
	@Id
	@GeneratedValue
	private Long id;
	private LocalDateTime create_at;
	@ManyToOne
	@JoinColumn
	private User user;
	@OneToMany(fetch = FetchType.LAZY)
	private List<Product> products;
	private Float order_sum;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Float getOrder_sum() {
		return order_sum;
	}
	public void setOrder_sum(Float order_sum) {
		this.order_sum = order_sum;
	}
	public LocalDateTime getCreate_at() {
		return create_at;
	}
	public void setCreate_at(LocalDateTime create_at) {
		this.create_at = create_at;
	}
	
}
