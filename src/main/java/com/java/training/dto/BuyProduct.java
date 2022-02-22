package com.java.training.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.java.training.entity.Product;


@Entity
public class BuyProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer buyProductId;
	private Integer userId;
	private Integer cartId;
	private Integer quantity;
	@ManyToOne
	@JoinColumn(name="productId")
	private Product product;
	
//	private List<Product> productList;
	
	
	public Integer getBuyProductId() {
		return buyProductId;
	}
	public void setBuyProductId(Integer buyProductId) {
		this.buyProductId = buyProductId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	//	public Integer getProductId() {
//		return productId;
//	}
//	public void setProductId(Integer productId) {
//		this.productId = productId;
//	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
//	public List<Product> getProductList() {
//		return productList;
//	}
//	public void setProductList(List<Product> productList) {
//		this.productList = productList;
//	}
	

}
