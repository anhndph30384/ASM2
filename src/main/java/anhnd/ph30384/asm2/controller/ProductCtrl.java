package anhnd.ph30384.asm2.controller;

import anhnd.ph30384.asm2.model.Product;
import anhnd.ph30384.asm2.repository.ProductRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductCtrl {
    @Autowired
    ProductRepo repo;

    @GetMapping("/newproduct")
    public String showAddForm(Product product) {
        return "add-product";
    }

    @PostMapping("/addproduct")
    public String addProduct(@Valid Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-product";
        }
        repo.save(product);
        return "redirect:/product";
    }

    @GetMapping("/product")
    public String showProductList(Model model) {
        model.addAttribute("products", repo.findAll());
        return "product";
    }

    @GetMapping("/editproduct/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Product product = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID:" + id));

        model.addAttribute("product", product);
        return "update-product";
    }

    @PostMapping("/updateproduct/{id}")
    public String updateProduct(@PathVariable("id") long id, @Valid Product product,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            product.setId(id);
            return "update-product";
        }
        repo.save(product);
        return "redirect:/product";
    }

    @GetMapping("/deleteproduct/{id}")
    public String deleteProduct(@PathVariable("id") long id, Model model) {
        Product product = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        repo.delete(product);
        return "redirect:/product";
    }
}
