package Main.StudentFilter;

import Main.Tools.DataType;
import Main.Tools.FilterSettings;
import MyClasses.Abstract.IInstitute;
import MyClasses.Abstract.IStudent;
import com.google.inject.Inject;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FilterStrategy implements IFilterStrategy
{
    private final Map<DataType, IFilterLauncher> launchers;

    @Inject
    public FilterStrategy(IFilterListLauncher filterListLauncher,
                          IFilterTreeLauncher filterTreeLauncher,
                          IFilterHashLauncher filterHashLauncher)
    {
        Map<DataType, IFilterLauncher> launchers = new HashMap<>();
        launchers.put(DataType.LIST, filterListLauncher);
        launchers.put(DataType.TREESET, filterTreeLauncher);
        launchers.put(DataType.HASHSET, filterHashLauncher);

        this.launchers = launchers;
    }

    @Override
    public Collection<IStudent> get(IInstitute institute, FilterSettings settings, DataType dataType)
    {
        IFilterLauncher launcher = launchers.get(dataType);
        return launcher.launch(institute, settings);
    }


}



