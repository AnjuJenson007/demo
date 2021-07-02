package com.main.project.java.Controller;

import com.main.project.java.Entity.Product;
import com.main.project.java.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public String viewHomePage(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "product";
    }

    @GetMapping("/showNewProductForm")
    public String showNewProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "AddProduct";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product")Product product) {
        productService.saveProduct(product);
        return "redirect:/product";
    }

    @GetMapping("/showProductFormForUpdate/{id}")
    public String showProductFormForUpdate(@PathVariable(value = "id") int productId, Model model) {
        Product product = productService.getProductById(productId);
        model.addAttribute("product", product);
        return "UpdateProduct";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable(value = "id") int productId) {
        this.productService.deleteProductById(productId);
        return "redirect:/product";
    }
}

