package kodlamaio.northwind.api.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.contretes.Product;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductsController {

	private ProductService productService;

	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	// -------------------------------------------

	@GetMapping("/getall")
	public DataResult<List<Product>> getAll() {
		return this.productService.getAll();
	}

	@PostMapping("/postadd")
	public Result add(@RequestBody Product product) {
		return this.productService.postadd(product);
	}

	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName) {
		return this.productService.getByProductName(productName);
	}

	/*
	@GetMapping("/getByProductNameAndCategory")
	public DataResult<Product> getByProductNameAndCategory_CategoryId(@RequestParam() String productName,
			@RequestParam() int categoryId) {
		return this.productService.getByProductNameAndCategory(productName, categoryId);
	}
	*/

	@GetMapping("/getByProductNameOrCategoryId")
	public DataResult<List<Product>> getByProductNameOrCategoryId(@RequestParam() String productName,
			@RequestParam() int categoryId) {
		return this.productService.getByProductNameOrCategoryId(productName, categoryId);
	}

	@GetMapping("/getByCategoryIdIn")
	public DataResult<List<Product>> getByCategory_CategoryIdIn(@RequestParam() List<Integer> categories) {
		return productService.getByCategory_CategoryIdIn(categories);
	}

	@GetMapping("/getByProductNameContains") // "xxxx" içeren productları getirme
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return this.productService.getByProductNameContains(productName);
	}

	@GetMapping("/getByProductNameStartsWith") // "xxxx" ile başlayan
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return this.productService.getByProductNameStartsWith(productName);
	}

	@GetMapping("/getByPage")
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		return this.productService.getAll(pageNo, pageSize);
	}

	@GetMapping("/getBySorted")
	public DataResult<List<Product>> getAllSorted() {
		return this.productService.getAllSorted();
	}

	@GetMapping("/getByNameAndCategory")
	public DataResult<List<Product>> getByProductNameAndCategory(String productName, int categoryId) {
		return this.productService.getByProductNameAndCategory(productName, categoryId);
	}

	
	/*
	 * @GetMapping("/getProductWithCategoryDtos") public
	 * DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
	 * return this.productService.getProductWithCategoryDetails(); }
	 */
		
	
}
