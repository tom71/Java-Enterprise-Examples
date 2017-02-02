import java.util.*;

/**
 * Repräsentation des Warenkorbs
 */
public class CheckOut
{
	// Preisregeln
	private PricingRules pricingRules;

	// Items im Warenkorb
	private List<Item> items;

	/**
	 * Warenkorb wird mit Preisregeln initialisiert
	 */
	public CheckOut( PricingRules pricingRules )
	{
		this.pricingRules = pricingRules;
		items = new ArrayList<>();
	}

	// Hinzufügen von Items in den Warenkorb
	public void scan( String sku )
	{
		Item item = pricingRules.getItemBySKU( sku );
		items.add( item );
	}

	// Berechnung des Preises aller Items im Warenkorb 
	public int total()
	{

		Map<String, Integer> priceForItems = new HashMap<>();

		// Schleife über alle Items im Warenkorb
		for ( Item item : items )
		{
			// Wurde der Gesamtpreis für dieses Item schon bestimmt?
			if ( !priceForItems.containsKey( item.getSku() ) )
			{
				// Wieviele Items sind im Warenkorb
				int amountOfItem = getAmountOfItem( item );

				// Wie hoch ist der Preis für dieses Item abhängig von der Anzahl
				int priceForItem = getPriceForItem( item, amountOfItem );

				// Preis für dieses Item setzen
				priceForItems.put( item.getSku(), priceForItem );
			}
		}

		// Errechnen des Gesamtpreises 
		int total = 0;
		for ( Integer price : priceForItems.values() )
		{
			total += price;
		}
		return total;
	}

	/**
	 * Berechnet die Anzahl der gleichen Items im Warenkorb
	 *
	 * @return amount of items
	 */
	private int getAmountOfItem( Item itemToCount )
	{
		int amount = 0;
		for ( Item item : items )
		{
			if ( item.getSku().equals( itemToCount.getSku() ) )
			{
				amount++;
			}
		}
		return amount;
	}

	/**
	 * Berechnet den Preis eines Items, abhängig von der Anzahl
	 *
	 * @return price for given item
	 */
	private int getPriceForItem( Item item, int amount )
	{
		// Gibt es eine Preisregel ?
		Rule rule = pricingRules.getRuleForItem( item );

		// ist die Anzahl der Items größer als die Mindestanzahl für die Regel? 
		if ( rule != null && amount >= rule.getMinAmountForDiscount() )
		{
			// Rest bestimmen, der nicht von der Preisregel betroffen ist
			int mod = amount % rule.getMinAmountForDiscount();
			int price = mod * item.getPrice();

			// Anzahl der Preisnachlässe bestimmen und mit dem Nachlass multiplizieren
			price += ((amount - mod) / rule.getMinAmountForDiscount()) * rule.getPriceForDiscount();
			return price;
		}
		else
		{
			// Einzelpreis mal Menge
			return item.getPrice() * amount;
		}
	}
}
