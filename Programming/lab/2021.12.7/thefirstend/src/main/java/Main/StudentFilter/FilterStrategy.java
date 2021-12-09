package Main.StudentFilter;

import Main.Tools.CollectionType;
import Main.Tools.FilterSettings;
import MyClasses.Abstract.IInstitute;
import MyClasses.Abstract.IStudent;
import com.google.inject.Inject;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FilterStrategy implements IFilterStrategy
{
    private final Map<CollectionType, IFilterLauncher> launchers;

    @Inject
    public FilterStrategy(IFilterListLauncher filterListLauncher,
                          IFilterTreeLauncher filterTreeLauncher,
                          IFilterHashLauncher filterHashLauncher)
    {
        Map<CollectionType, IFilterLauncher> launchers = new HashMap<>();
        launchers.put(CollectionType.LIST, filterListLauncher);
        launchers.put(CollectionType.TREESET, filterTreeLauncher);
        launchers.put(CollectionType.HASHSET, filterHashLauncher);

        this.launchers = launchers;
    }

    @Override
    public Collection<IStudent> get(IInstitute institute, FilterSettings settings, CollectionType collectionType)
    {
        IFilterLauncher launcher = launchers.get(collectionType);
        return launcher.launch(institute, settings);
    }


}



