package Tools;

import java.util.ArrayList;
import java.util.List;

public class CartesianProducter implements ICartesianProducter
{
    @Override
    public int[][] calculate(Set set1, Set set2)
    {
        List<int[]> product = new ArrayList<int[]>();

        for (int i = 0; i < set1.elements.length; i++)
        {
            for (int j = 0; j < set2.elements.length; j++)
            {
                product.add(new int[]{set1.elements[i], set2.elements[j]});
            }
        }
        return product.toArray(new int[0][0]);
    }
}
