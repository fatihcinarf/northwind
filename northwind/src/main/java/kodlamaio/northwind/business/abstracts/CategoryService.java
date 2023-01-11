
package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.entities.contretes.Category;

public interface CategoryService {
	List<Category> findAll();
}
