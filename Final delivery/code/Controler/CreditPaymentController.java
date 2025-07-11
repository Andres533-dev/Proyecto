package Proyecto.Code.src.Controler;

import java.util.ArrayList;

public class CreditPaymentController {
    private String cardNumber;
    private String expirationDate;
    private String cvv;
    private String cardholderName;
    public int validationStatus; // 0: invalid, 1: partially valid, 2: mostly valid, 3: fully valid
    public boolean isPaymentValid;

    public CreditPaymentController(ArrayList<String> paymentData) {
        this.validationStatus = 0;
        this.isPaymentValid = false;

        if (paymentData.size() >= 4) {
            this.cardNumber = paymentData.get(0); // Remove spaces from card number
            this.expirationDate = paymentData.get(1);
            this.cvv = paymentData.get(2);
            this.cardholderName = paymentData.get(3);

            validateCardNumber();
            validateExpirationDate();
            validateCVV();
            this.isPaymentValid = (validationStatus == 4); // All 4 fields valid
        }
    }

    private void validateCardNumber() {
        if (cardNumber.matches("^[0-9]{16}$")) { // Exactamente 16 dígitos
            this.validationStatus++;
        } else {
            return;
        }
    }

    private void validateExpirationDate() {
        // Validate MM/YY format
        if (expirationDate == null || !expirationDate.matches("^(0[1-9]|1[0-2])/([0-9]{2})$")) {
            return;
        }

        // Validate not expired
        String[] parts = expirationDate.split("/");
        int month = Integer.parseInt(parts[0]);
        int year = 2000 + Integer.parseInt(parts[1]); // Convert YY to YYYY

        java.time.YearMonth current = java.time.YearMonth.now();
        java.time.YearMonth expDate = java.time.YearMonth.of(year, month);

        if (!expDate.isBefore(current)) {
            validationStatus++;
        }
    }

    private void validateCVV() {
        if (cvv != null && cvv.matches("^[0-9]{3,4}$")) {
            validationStatus++;
        }
    }

}