import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestPrice
{

	public int calculatePrice( String goods )
	{
		PricingRules pricingRules = new PricingRules();
		CheckOut co = new CheckOut( pricingRules );
		for ( int i = 0; i < goods.length(); i++ )
		{
			co.scan( String.valueOf( goods.charAt( i ) ) );
		}
		return co.total();
	}

	@Test
	public void totals()
	{
		assertEquals( 0, calculatePrice( "" ) );
		assertEquals( 40, calculatePrice( "A" ) );
		assertEquals( 90, calculatePrice( "AB" ) );
		assertEquals( 135, calculatePrice( "CDBA" ) );
		assertEquals( 80, calculatePrice( "AA" ) ); 
		assertEquals( 100, calculatePrice( "AAA" ) );
		assertEquals( 140, calculatePrice( "AAAA" ) );
		assertEquals( 180, calculatePrice( "AAAAA" ) );
		assertEquals( 200, calculatePrice( "AAAAAA" ) );
		assertEquals( 150, calculatePrice( "AAAB" ) );
		assertEquals( 180, calculatePrice( "AAABB" ) );
		assertEquals( 200, calculatePrice( "AAABBD" ) );
		assertEquals( 200, calculatePrice( "DABABA" ) );
	}

	@Test
	public void incremental()
	{
		PricingRules pricingRules = new PricingRules();
		
		CheckOut co = new CheckOut( pricingRules );
		assertEquals( 0, co.total() );
		co.scan( "A" );
		assertEquals( 40, co.total() );
		co.scan( "B" );
		assertEquals( 90, co.total() );
		co.scan( "A" );
		assertEquals( 130, co.total() );
		co.scan( "A" );
		assertEquals( 150, co.total() );
		co.scan( "B" );
		assertEquals( 180, co.total() );
	}
}