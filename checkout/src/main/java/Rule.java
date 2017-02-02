/**
 * Preisregel hat eine Mindestmenge und einen Preis
 */
public class Rule
{

	private int minAmountForDiscount;

	private int priceForDiscount;

	public Rule( int minAmountForDiscount, int priceForDiscount )
	{
		this.minAmountForDiscount = minAmountForDiscount;
		this.priceForDiscount = priceForDiscount;
	}

	public int getMinAmountForDiscount()
	{
		return minAmountForDiscount;
	}

	public int getPriceForDiscount()
	{
		return priceForDiscount;
	}
}
