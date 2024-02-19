package anhnd.ph30384.asm2.repository;

import anhnd.ph30384.asm2.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product, Long> {
}
