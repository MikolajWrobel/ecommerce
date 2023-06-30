package pl.mwrobel.sales.payment;

public interface PaymentGateway {
    PaymentData register(RegisterPaymentRequest request);
}
