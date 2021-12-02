package Tools;

import java.util.HashMap;
import java.util.Map;

public class BinaryMap
{
    public static final Map<Integer, Integer> mapColumn;
    public static final Map<Integer, Integer> mapRow;

    static
    {
        mapColumn = new HashMap<>();

        mapColumn.put(0, 1 << 2);
        mapColumn.put(1, 1 << 1);
        mapColumn.put(2, 1);

        mapRow = new HashMap<>();

    }
}
