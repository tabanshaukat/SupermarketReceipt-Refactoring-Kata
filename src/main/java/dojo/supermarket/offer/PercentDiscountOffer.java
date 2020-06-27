package dojo.supermarket.offer;

import dojo.supermarket.model.Discount;
import dojo.supermarket.model.Product;
import dojo.supermarket.model.ShoppingCart;
import dojo.supermarket.model.SupermarketCatalog;

public class PercentDiscountOffer extends Offer {

    private double discountPercentage;

    public PercentDiscountOffer(Product product, double discountPercentageOrAmount) {
        super(product);
        this.discountPercentage = discountPercentageOrAmount;
    }

    @Override
    public Discount getDiscount(SupermarketCatalog catalog, Product product,
            ShoppingCart shoppingCart) {

        if (!shoppingCart.isProductAvailableForOffer(product)) {
            return null;
        }

        return new Discount(product, discountPercentage + "% off", -shoppingCart
                .getQuantity(product) * catalog.getUnitPrice(product)
                * discountPercentage / 100.0);
    }
}
