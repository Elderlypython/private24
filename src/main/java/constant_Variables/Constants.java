package constant_Variables;

public class Constants {
    public static int IMPLICIT_WAIT_TIME_IN_SEC = 10;
    public static int EXPLICIT_WAIT_TIME_IN_SEC = 10;

    public static class URLs{
        public static String URL_For_mobile = "https://next.privat24.ua/mobile";
        public static String URL_For_Car_Leasing = "https://next.privat24.ua/auto-credit/order";
    }
    public static class DataForMobileReplanishment{
        public static String VALID_PHONE_NUMBER = "686979712";
        public static String VALID_CARD_NUMBER = "4093206288191961";
        public static String VALID_ISSUE_DATE = "0622";
        public static String VALID_CVV = "464";
        public static String VALID_NAME = "TARAS";
        public static String VALID_SURNAME = "SHEVCHENKO";
        public static String RUSSIA = "Росі";
    }
    public static class DataForNegativeReplanishmentTest{
        public static String TOO_LOW_SUM = "0.1";
        public static String TOO_HIGH_SUM = "9999999";

    }
}
