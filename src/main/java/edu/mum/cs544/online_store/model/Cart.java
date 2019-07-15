package edu.mum.cs544.online_store.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Data
@RequiredArgsConstructor
public class Cart {
    private List<OrderLine> orderLines;
}
