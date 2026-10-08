package com.example.ecommerce.service;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.exception.ResourceNotFoundException;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productrepository){
        this.productRepository = productrepository;
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Product not found with id:" + id));
    }
//    public Product getAllProducts(){
//        return productService.getAllProducts();
//    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);

    }
}
