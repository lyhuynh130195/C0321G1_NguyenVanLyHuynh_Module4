package com.codegym.model.dto;

import com.codegym.model.entity.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartDto {
    private Map<ProductDto,Integer> productDtoMap = new HashMap<>();

    public CartDto() {
    }

    public void addProductDto(ProductDto productDto){
        if(productDtoMap.containsKey(productDto)){
            int currentValue = productDtoMap.get(productDto);
            productDtoMap.put(productDto,currentValue+1);
        }else {
            productDtoMap.put(productDto,1);
        }
    }

    public Map<ProductDto, Integer> getProductDtoMap() {
        return productDtoMap;
    }

    public void setProductDtoMap(Map<ProductDto, Integer> productDtoMap) {
        this.productDtoMap = productDtoMap;
    }

    public void removeProductDtoMap(ProductDto productDto){
        productDtoMap.remove(productDto);
    }

    public ProductDto findProductDtoById(Long id){
        for (Map.Entry<ProductDto, Integer> item : productDtoMap.entrySet()){
            if(item.getKey().getId()==id){
                return item.getKey();
            }
        }
        return null;
    }
}
