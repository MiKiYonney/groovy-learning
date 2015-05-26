package chapter3

/**
 * Created by yonney.yang on 2015/4/17.
 */
class Money {
    private int amount;
    private String currency;

    Money(int amount, String currency) {
        this.amount = amount
        this.currency = currency
    }

    @Override
    boolean equals(Object obj) {
        if(null == obj) return false;
        if(! obj instanceof  Money) return false;
        if(currency != obj.currency) return false;
        if(amount != obj.amount) return false;
        return true;
    }

    @Override
    int hashCode() {
        return amount.hashCode()+currency.hashCode();
    }

    Money plus(Money other){
        if(null == other) return null;
        if(other.currency != currency) {
            throw new IllegalArgumentException("can not plus")
        }
        return new Money(amount + other.amount,currency)
    }

    public static void main(String[] args) {
    }
}
