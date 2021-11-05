package Tools;

public class Validator implements IValidator
{
    @Override
    public void validate(int[][] matrix)
    {
        if (matrix.length == 0)
        {
            throw new InvalidRelationException("Matrix is empty");
        }
        boolean isSquare = true;
        boolean hasInvalidNumbers = false;
        for (int[] row :
                matrix)
        {
            if (row.length != matrix.length)
            {
                isSquare = false;
                break;
            }
            for (int element :
                    row)
            {
                if (element != 1 && element != 0)
                {
                    hasInvalidNumbers = true;
                    break;
                }
            }
        }

        if (!isSquare)
        {
            throw new InvalidRelationException("Matrix is not square");
        }
        if (hasInvalidNumbers)
        {
            throw new InvalidRelationException("Matrix contains numbers except 0 and 1");
        }

    }
}
