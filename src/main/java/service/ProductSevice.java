package service;

import model.Product;

import java.util.List;

public interface ProductSevice extends GenenaSevice{
    List<Product> findAllByNameContains(String name);
    public List<Product> findByPrice(int start, int end);
}
