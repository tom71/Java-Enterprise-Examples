import java.util.*;

/**
 * Preisregel, hier ein Beispiel im Constructor erstellt,
 * kann aber auch aus File oder DB kommen
 * 
 * Berücksichtigt nur eine Preisregel pro Prokukt. (Wenn mehrere Preisregeln gelten sollen, wird es komplexer)
 */
public class PricingRules
{
	private Set<Item> items;
	private Map<Item, Rule> rules;

	public PricingRules()
	{
		rules = new HashMap();

		items = new HashSet<Item>();

		Item itemA = new Item( "A", 40 );
		Item itemB = new Item( "B", 50 );
		Item itemC = new Item( "C", 25 );
		Item itemD = new Item( "D", 20 );

		items.add( itemA );
		items.add( itemB );
		items.add( itemC );
		items.add( itemD );
		
		Rule ruleA = new Rule( 3, 100 );
		Rule ruleB = new Rule( 2, 80);

		rules.put( itemA, ruleA );
		rules.put( itemB, ruleB );
	}

	/**
	 * Gibt ein Produkt anhand der SKU zurück
	 * @param sku
	 * @return
	 */
	public Item getItemBySKU( String sku )
	{
		for ( Item item : items )
		{
			if ( sku.equals( item.getSku() ) )
			{
				return item;
			}
		}
		return null;
	}

	/**
	 * Gibt eine Preisregel für ein Produkt zurück
	 * @param item
	 * @return
	 */
	public Rule getRuleForItem(Item item)
	{
		return rules.get( item );
	}

}
