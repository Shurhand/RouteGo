package utilities.paypal.IPN;

public enum PayPalEnvironment {

	LIVE(""),
    SANDBOX("sandbox.");

    private final String urlModifier;

    private PayPalEnvironment(String urlModifier) {
    	this.urlModifier = urlModifier;
    }

    public String getUrlModifier() {
    	return urlModifier;
    }
}
