package com.ruhama.Ecom_proj.collroller;

import com.ruhama.Ecom_proj.model.Product;
import com.ruhama.Ecom_proj.service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController {
    @Autowired
    private ProductServices service;

    @RequestMapping("/start")
    public String greet() {
        return "Hello World";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getallproducts() {
        return new ResponseEntity<>(service.getallproduct(), HttpStatus.OK);

    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getproducbyId(@PathVariable int id) {
        Product product = service.getproduct(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        //@PostMapping("/add")
        //  public R
    }
    @PostMapping("/addproduct/")
    public ResponseEntity<?> addingProduct(@RequestPart Product product,
                                           @RequestPart MultipartFile image) {
        try {
            Product product1 = service.addProduct(product, image);
            return  new ResponseEntity<>(product1,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    @PutMapping("/update/{id}")
    public  ResponseEntity<?> updatingProduct(@PathVariable int id,@RequestPart Product product
    ,@RequestPart MultipartFile image) throws IOException {
        Product product1 = service.updateProducts(id, product, image);
        if (product1 != null) {
            return new ResponseEntity("Updated", HttpStatus.OK);
        }
        else
            return new ResponseEntity("Bad request", HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id){
        Product product1=service.getproduct(id);
        if(product1!=null)      {
            service.deleteProducts(id);
            return new ResponseEntity("deleted", HttpStatus.OK);
    }
        else
                return new ResponseEntity("Bad request", HttpStatus.NOT_FOUND);
}
    }

