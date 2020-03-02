package com.zeroq6.java.design_pattern.create.factory.simple_factory;

public class SimpleFactory {
    public static Product getProduct(ProductType productType) {
        if (productType == ProductType.PRODUCT_A) {
            return new ProductA();
        } else if (productType == ProductType.PRODUCT_B) {
            return new ProductB();
        }
        return null;
    }

}
