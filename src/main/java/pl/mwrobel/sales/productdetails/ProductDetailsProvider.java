package pl.mwrobel.sales.productdetails;

import pl.mwrobel.sales.productdetails.ProductDetails;

import java.util.Optional;

public interface ProductDetailsProvider {
    public Optional<ProductDetails> load(String productId);
}
