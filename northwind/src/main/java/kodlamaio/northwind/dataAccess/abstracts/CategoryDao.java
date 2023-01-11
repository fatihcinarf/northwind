
package kodlamaio.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.northwind.entities.contretes.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {
	
}
