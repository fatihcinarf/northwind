package kodlamaio.northwind.entities.contretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "product"})
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int id;

	// @Column(name="category_id")
	// private int categoryId;

	@Column(name = "product_name")
	private String productName; // Ürün Adı

	@Column(name = "unit_price")
	private double unitPrice; // Ürün Fiyatı

	@Column(name = "units_in_stock")
	private short unitsInStock; // Ürünün Stok Adedi

	@Column(name = "quantity_per_unit")
	private String quantityPerUnit; // Ürünün Açıklaması

	// Product'ın kategorisi nedir?

	@ManyToOne() // get isteginde ürün tekrarını engeleme
	@JoinColumn(name = "category_id")
	private Category category;

}
