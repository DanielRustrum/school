package homework.pkg11;
import java.lang.Comparable;

public class Data
{
   /**
      Computes the average of the measures of the given objects.
      @param objects an array of Measurable objects
      @return the average of the measures
   */
   public static double average(Measurable[] objects)
   {
      double sum = 0;
      for (Measurable obj : objects)
      {
         sum = sum + obj.getMeasure();
      }
      if (objects.length > 0)
      {
         return sum / objects.length;
      }
      else
      {
         return 0;
      }
   }

   /**
      Computes the maximum of the measures of the given objects.
      @param objects an array of Measurable objects
      @return the maximum of the measures, null if array is empty
   */
   public static Measurable max(Measurable[] objects)
   {
       Object tempObj = null;
         
        for (int i = 0; i < objects.length-1; i++) {
            if (objects[i] == tempObj)
                tempObj = objects[i];
            else
                tempObj = objects[i + 1];
        }//End if
 
        return (Measurable) tempObj;
    }
}
