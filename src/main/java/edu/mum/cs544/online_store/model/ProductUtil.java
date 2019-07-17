package edu.mum.cs544.online_store.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProductUtil {
    private Long id;
    private int quantity;
}
