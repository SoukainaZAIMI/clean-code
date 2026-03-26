package com.b.simple.design.business.customer;

import com.b.simple.design.business.exception.DifferentCurrenciesException;
import com.b.simple.design.model.customer.Amount;
import com.b.simple.design.model.customer.AmountImpl;
import com.b.simple.design.model.customer.Currency;
import com.b.simple.design.model.customer.Product;

import java.math.BigDecimal;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {

	@Override

    public Amount getCustomerProductsSum(List<Product> products)
            throws DifferentCurrenciesException {
        if (products.isEmpty()) {
            return new AmountImpl(BigDecimal.ZERO, Currency.EURO);
        }

        Currency referenceCurrency = getReferenceCurrency(products);
        validateCurrencies(products, referenceCurrency);
        BigDecimal total = sumProductValues(products);

        return new AmountImpl(total, referenceCurrency);
    }

    private Currency getReferenceCurrency(List<Product> products) {
        return products.get(0).getAmount().getCurrency();
    }

    private void validateCurrencies(List<Product> products, Currency referenceCurrency)
            throws DifferentCurrenciesException {
        for (Product product : products) {
            boolean sameCurrency = product.getAmount().getCurrency().equals(referenceCurrency);
            if (!sameCurrency) {
                throw new DifferentCurrenciesException();
            }
        }
    }

    private BigDecimal sumProductValues(List<Product> products) {
        BigDecimal total = BigDecimal.ZERO;
        for (Product product : products) {
            total = total.add(product.getAmount().getValue());
        }
        return total;
    }
}