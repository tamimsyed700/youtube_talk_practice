import java.util.*;
import java.text.*;

class A
{
	public static void main(String[] args)
	{
		Locale[] locales = NumberFormat.getAvailableLocales();
		 double myNumber = -1234.56;
		 NumberFormat form;
		 for (int j=0; j<3; ++j) {
		     System.out.println("FORMAT");
		     for (int i = 0; i < locales.length; ++i) {
		         if (locales[i].getCountry().length() == 0) {
		            continue; // Skip language-only locales
		         }
		         System.out.print(locales[i].getDisplayName());
		         switch (j) {
		         case 0:
		             form = NumberFormat.getInstance(locales[i]); break;
		         case 1:
		             form = NumberFormat.getCurrencyInstance(locales[i]); break;
		         default:
		             form = NumberFormat.getPercentInstance(locales[i]); break;
		         }
		         try {
		             // Assume form is a DecimalFormat
		             System.out.print(": " + ((DecimalFormat) form).toPattern()
		                              + " -> " + form.format(myNumber));
		         } catch (IllegalArgumentException e) {}
		         try {
		             System.out.println(" ->>> " + form.parse(form.format(myNumber)));
		         } catch (ParseException e) {}
		     }
		 }
	}
}
