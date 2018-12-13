package homework.pkg11;

public class Country implements Measurable
{
   private String name;
   private double area;

   /**
      Construct a country with name and area.
      @param name country's name
      @param area total area of country
   */
   public Country(String name, double area)
   {
      this.name = name;
      this.area = area;
   }

   /**
      Measurable interface method to retrieve measure.
      @return the measured area
   */
   public double getMeasure()
   {
      return area;
   }
}
