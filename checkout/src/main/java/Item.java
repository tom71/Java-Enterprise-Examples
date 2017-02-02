/**
 * Produkt hat einen Einzelpreis und eine SKU
 */
public class Item
{
	private String sku;

	private int price;

	public Item( String sku, int price )
	{
		this.sku = sku;
		this.price = price;
	}

	public String getSku()
	{
		return sku;
	}

	public int getPrice()
	{
		return price;
	}
}
