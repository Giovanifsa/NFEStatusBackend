package giovani.nfestatusproj.nfestatus.utils;

public class NumberUtils {
	private NumberUtils() {
		
	}
	
	public static Long parseLongOrNull(String numericString) {
		try {
			return Long.valueOf(numericString);
		}
		
		catch (NumberFormatException e) {
			return null;
		}
	}
}
