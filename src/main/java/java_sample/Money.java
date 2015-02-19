package java_sample;

import java.math.BigDecimal;
import java.util.Currency;

public final class Money {

    private final Currency currency;
    private final BigDecimal amount;

    public static final Currency JPY = Currency.getInstance("JPY");
    public static final Currency USD = Currency.getInstance("USD");

    public Money(Currency currency, BigDecimal amount) {
        if (currency == null) {
            throw new IllegalArgumentException("currency is null.");
        }
        if (amount == null) {
            throw new IllegalArgumentException("amount is null.");
        }
        this.currency = currency;
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        if (!amount.equals(money.amount)) return false;
        if (!currency.equals(money.currency)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = currency.hashCode();
        result = 31 * result + amount.hashCode();
        return result;
    }

}

