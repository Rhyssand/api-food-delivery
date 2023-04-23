package com.upao.apifood.request;

import com.upao.apifood.modelo.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderRequest {

    private String customerName;
    private String customerEmail;
    private List<Food> items;

}
