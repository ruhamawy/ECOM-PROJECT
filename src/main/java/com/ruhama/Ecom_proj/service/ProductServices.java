package com.ruhama.Ecom_proj.service;

import com.ruhama.Ecom_proj.model.Product;
import com.ruhama.Ecom_proj.repo.Productrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {
    @Autowired
    private Productrepo repo;

    public List<Product> getallproduct(){

        return repo.findAll();
    }
    public  Product getproduct(int id) {
        Optional<Product> op = repo.findById(id);
        //return repo.findById(id);
    /* if(op.isEmpty()){
         return null;
     }
     return op.get();
    }*/
        return repo.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile image) throws IOException {
       product.setImageName(image.getOriginalFilename());
       product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());
        return repo.save(product);
    }
    public Product updateProducts (int id,Product product, MultipartFile image) throws IOException {
       Optional<Product> optionalProduct=repo.findById(id);
       if(optionalProduct.isPresent()){
           Product existingproduct=optionalProduct.get();
           existingproduct.setName(product.getName());
           existingproduct.setBrand(product.getBrand());
           existingproduct.setCategory(product.getCategory());
           existingproduct.setDescrb(product.getDescrb());
           existingproduct.setPrice(product.getPrice());
           existingproduct.setAvailable(product.isAvailable());
           existingproduct.setQuantity(product.getQuantity());
           if (image != null && !image.isEmpty()) {
               existingproduct.setImageName(image.getOriginalFilename());
               existingproduct.setImageType(image.getContentType());
               existingproduct.setImageData(image.getBytes());
           }
           return repo.save(existingproduct);  // saves the updated product
       }

        return null;  // Not found
    }

    public void deleteProducts(int id) {

            repo.deleteById(id);

    }
}
