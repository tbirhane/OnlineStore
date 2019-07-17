package edu.mum.cs544.online_store.model;


import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;


@Data
@RequiredArgsConstructor
@Getter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] image;


    public byte[] getImage() {
        return image;
    }
}
