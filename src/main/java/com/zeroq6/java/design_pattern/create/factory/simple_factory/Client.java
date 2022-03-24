package com.zeroq6.java.design_pattern.create.factory.simple_factory;

import java.util.Objects;

public class Client {

    public static void main(String[] args) {
        Product product = SimpleFactory.getProduct(ProductType.PRODUCT_A);
        System.out.println(Objects.isNull(product)? null : product.getClass().getName());
    }
}
