package Checkers;

import Preparators.IDuality;
import com.google.inject.Inject;

public class Dually implements IDually
{
    private final IDuality duality;

    @Inject
    public Dually(
            IDuality duality
    )
    {
        this.duality = duality;
    }

    @Override
    public boolean check(String tuple)
    {
        return tuple.equals(duality.translate(tuple));
    }
}
