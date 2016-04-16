package Merlin.Base;

import org.joda.time.LocalDate;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Chris on 4/15/2016.
 */
public class FrequencyTest
{
	@Test
	public void getSetProperties()
			throws
			Exception
	{

		Frequency f = new Frequency();

		f.setTimeUnitType(TimeUnit.WEEK);
		f.setTimeUnits(4);

		assertEquals(f.getTimeUnitType(), TimeUnit.WEEK);
		assertEquals(f.getTimeUnits(), 4);

	}


	@Test
	public void addFrequency()
			throws
			Exception
	{

		LocalDate dt = new LocalDate(2016, 1, 10);
		LocalDate dt2 = new LocalDate(2016, 1, 31);
		Frequency f = new Frequency(4, TimeUnit.WEEK);
		LocalDate result1 = f.addFrequency(dt);

		f.setTimeUnitType(TimeUnit.SEMIMONTH);
		LocalDate result2 = f.addFrequency(dt);

		f.setTimeUnitType(TimeUnit.MONTH);
		LocalDate result3 = f.addFrequency(dt);

		f.setTimeUnits(1);
		LocalDate result4 = f.addFrequency(dt2);



		assertEquals(new LocalDate(2016, 2, 7), result1);
		assertEquals(new LocalDate(2016, 2, 29), result2);
		assertEquals(new LocalDate(2016, 5, 10), result3);
		assertEquals(new LocalDate(2016, 2, 29), result4);



	}

	@Test
	public void subtractFrequency()
			throws
			Exception
	{

	}

}