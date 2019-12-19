package woowa.precourse.practicecourses.movie.domain;

public enum Payment {

    CREDIT_CARD(1,0.95),
    CASH(2,0.97);

    private int id;
    private Double discountRate;

    Payment(int id, double discountRate) {
        this.id = id;
        this.discountRate = discountRate;
    }

    public double totalPriceWithDiscount(double moneyWithoutDiscount){
        if(id ==CREDIT_CARD.id)
            return moneyWithoutDiscount * CREDIT_CARD.discountRate;
        return moneyWithoutDiscount * CASH.discountRate;
    }

}
