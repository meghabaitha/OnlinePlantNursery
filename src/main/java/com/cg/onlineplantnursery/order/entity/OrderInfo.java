package com.cg.onlineplantnursery.order.entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import com.cg.onlineplantnursery.cart.entity.CartEntity;
import com.cg.onlineplantnursery.customer.entity.Customer;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Store_order")
public class OrderInfo {
	
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQUENCE6")
	@SequenceGenerator(name="SEQUENCE6", sequenceName = "SEQUENCE6",allocationSize = 1,initialValue = 1001)
		private int orderId;
	
	@Column(name = "recipient_name")
	@Size(min=8, max=30)
	private String recipientName;
	
	@Column(name = "recipient_phone_no")
	@Size(min=10, max=15)
	private String recipientPhoneNumber;

	@Column(name = "street_address")
	@Size(min=10, max=128)
	private String streetAddress;
	
	@Column(name = "city")
	@Size(min=3, max=32)
	private String city;

	@Column(name = "zip_code")
	@Size(min=3, max=24)
	private Integer zipCode;

	@Column(name = "country")
	@Size(min=3, max=64)
	private String country;

	@Column(name="shipping_address")
	private String shippingAddress;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="total_price")
	private float totalPrice;
	
	@Column(name="order_status")
	private String orderStatus;
	
	@Column(name="payment_method")
	private String paymentMethod;
	
	@Column(name="order_date")
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
	private LocalDate orderDate;

	@OneToMany( orphanRemoval = true,cascade = CascadeType.MERGE)
	private List<CartEntity> cart = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name="customerId", referencedColumnName = "customerId")
	private Customer customer = new Customer();
	
	public OrderInfo()
	{
		super();
	}


	
	public OrderInfo(int orderId, @Size(min = 8, max = 30) String recipientName,
			@Size(min = 10, max = 15) String recipientPhoneNumber, @Size(min = 10, max = 128) String streetAddress,
			@Size(min = 3, max = 32) String city, @Size(min = 3, max = 24) Integer zipCode,
			@Size(min = 3, max = 64) String country, String shippingAddress, int quantity, float totalPrice,
			String orderStatus, String paymentMethod, LocalDate orderDate, List<CartEntity> cart, Customer customer) {
		super();
		this.orderId = orderId;
		this.recipientName = recipientName;
		this.recipientPhoneNumber = recipientPhoneNumber;
		this.streetAddress = streetAddress;
		this.city = city;
		this.zipCode = zipCode;
		this.country = country;
		this.shippingAddress = shippingAddress;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.orderStatus = orderStatus;
		this.paymentMethod = paymentMethod;
		this.orderDate = orderDate;
		this.cart = cart;
		this.customer = customer;
	}



	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getRecipientPhoneNumber() {
		return recipientPhoneNumber;
	}

	public void setRecipientPhoneNumber(String recipientPhoneNumber) {
		this.recipientPhoneNumber = recipientPhoneNumber;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public List<CartEntity> getCart() {
		return cart;
	}

	public void setCart(List<CartEntity> cart) {
		this.cart = cart;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "OrderInfo [orderId=" + orderId + ", recipientName=" + recipientName + ", recipientPhoneNumber="
				+ recipientPhoneNumber + ", streetAddress=" + streetAddress + ", city=" + city + ", zipCode=" + zipCode
				+ ", country=" + country + ", shippingAddress=" + shippingAddress + ", quantity=" + quantity
				+ ", totalPrice=" + totalPrice + ", orderStatus=" + orderStatus + ", paymentMethod=" + paymentMethod
				+ ", orderDate=" + orderDate + ", cart=" + cart + ", customer=" + customer + "]";
	}

	
		
}