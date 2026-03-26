package com.b.simple.design.business.customer;

import com.b.simple.design.business.exception.DifferentCurrenciesException;
import com.b.simple.design.model.customer.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomerBOImplTest {

    private final CustomerBOImpl bo = new CustomerBOImpl();

    @Test
    void sumEmptyListReturnsZeroEuro() throws DifferentCurrenciesException {
        List<Amount> emptyAmounts = new ArrayList<>();
        Amount result = bo.getCustomerProductsSum(productsFromAmounts(emptyAmounts));
        assertEquals(BigDecimal.ZERO, result.getValue());
        assertEquals(Currency.EURO, result.getCurrency());
    }

    @Test
    void sumSameCurrencySumsValues() throws DifferentCurrenciesException {
        List<Amount> amounts = Arrays.asList(
                new AmountImpl(new BigDecimal("10.00"), Currency.EURO),
                new AmountImpl(new BigDecimal("5.50"), Currency.EURO)
        );
        Amount result = bo.getCustomerProductsSum(productsFromAmounts(amounts));
        assertEquals(new BigDecimal("15.50"), result.getValue());
        assertEquals(Currency.EURO, result.getCurrency());
    }

    @Test
    void differentCurrenciesThrowException() {
        List<Amount> amounts = Arrays.asList(
                new AmountImpl(new BigDecimal("1.00"), Currency.EURO),
                new AmountImpl(new BigDecimal("2.00"), Currency.UNITED_STATES_DOLLAR)
        );

        assertThrows(DifferentCurrenciesException.class,
                () -> bo.getCustomerProductsSum(productsFromAmounts(amounts)));
    }

    private List<Product> productsFromAmounts(List<Amount> amounts) {
        List<Product> products = new ArrayList<>();
        long id = 1L;
        for (Amount a : amounts) {
            products.add(new ProductImpl(id++, "p", null, a));
        }
        return products;
    }
}