package Merlin.Base;

import org.joda.time.LocalDate;

/**
 * Created by chris on 4/13/16.
 */
public class Frequency
{

	public Frequency()
	{

	}

	public Frequency(int units, TimeUnit unitType)
	{
		timeUnits = units;
		timeUnitType = unitType;
	}

	private int timeUnits = 1;
	public int getTimeUnits()
	{
		return timeUnits;
	}
	public void setTimeUnits(int timeUnits)
	{
		this.timeUnits = timeUnits;
	}

	private TimeUnit timeUnitType;
	public TimeUnit getTimeUnitType()
	{
		return timeUnitType;
	}
	public void setTimeUnitType(TimeUnit timeUnitType)
	{
		this.timeUnitType = timeUnitType;
	}


	public LocalDate addFrequency(LocalDate toDate)
	{
		return IncrementFrequency(toDate, false);
	}

	public LocalDate aubtractFrequency(LocalDate fromDate)
	{
		return IncrementFrequency(fromDate, true);
	}

	private LocalDate IncrementFrequency(LocalDate toDate,
								   boolean subtract)
			throws IllegalArgumentException
	{

		if (toDate == null)
		{
			throw new IllegalArgumentException("Date specified cannot be null");
		}

		int factor = (subtract ? -1 : 1);

		switch (timeUnitType)
		{
			case DAY:
				return toDate.plusDays(timeUnits * factor);
			case WEEK:
				return toDate.plusWeeks(timeUnits * factor);
			case MONTH:
				return toDate.plusMonths(timeUnits * factor);
			case YEAR:
				return toDate.plusYears(timeUnits * factor);
			case SEMIMONTH:

				LocalDate curDate = toDate;
				LocalDate result = toDate;

				if (subtract)
				{
					for (int i = 0; i < timeUnits; i++)
					{

						if (curDate.getDayOfMonth() > 15)
						{
							result = new LocalDate(curDate.getYear(), curDate.getMonthOfYear(), 15);
						}
						else
						{
							result = curDate.dayOfMonth().withMinimumValue().minusDays(1);
						}

						curDate = result.minusDays(1);

					}

					return result;

				}
				else
				{

					for (int i = 0; i < timeUnits; i++)
					{

						if (curDate.getDayOfMonth() < 15)
						{
							result = new LocalDate(curDate.getYear(), curDate.getMonthOfYear(), 15);
						}
						else
						{
							result = curDate.dayOfMonth().withMaximumValue();
						}

						curDate = result.plusDays(1);

					}

					return result;

				}

		}

		return toDate;

	}




}
