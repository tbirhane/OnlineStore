package edu.mum.cs544.online_store.model;


import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
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
//    @Lob
//    @Basic(fetch = FetchType.LAZY)
//    @Nullable
//    private byte[] image;

    @Transient
    private MultipartFile productImage;


    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Nullable
    private String imageStr;


//    public byte[] getImage() {
//        return image;
//    }
}
