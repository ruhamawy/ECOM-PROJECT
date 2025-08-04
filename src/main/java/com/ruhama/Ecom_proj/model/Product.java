package com.ruhama.Ecom_proj.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    private String name;
    private String descrb;
    private String brand;
    private String category;
    private  Double price;

    private String imageName;
    private String imageType;
    @Lob
    private  byte[] imageData;

    private boolean available;
    private  int quantity;
   // @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = ="dd-MM-yyyy")
   // private Date relase_date;

}
