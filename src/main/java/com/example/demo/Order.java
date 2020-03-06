package com.example.demo;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Order {
	@Id
	@GeneratedValue
	private Long id;
	private Date create_at;
	@ManyToOne
	private User user;
	@OneToMany
	private List<Product> products;
	private Float order_sum;
}
