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
}
