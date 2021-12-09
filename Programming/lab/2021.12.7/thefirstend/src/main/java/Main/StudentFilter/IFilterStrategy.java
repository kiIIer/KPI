package Main.StudentFilter;

import Main.Tools.CollectionType;
import Main.Tools.FilterSettings;
import MyClasses.Abstract.IInstitute;
import MyClasses.Abstract.IStudent;

import java.util.Collection;

/**
 * Strategy of selecting and running proper FilterLauncher.
 */
public interface IFilterStrategy
{
    /**
     * Picks the launcher according to data type provided and launches it with provided settings.
     * @param institute Institute to be used when filtering students later on.
     * @param settings Filter setting to be used when filtering students later on.
     * @param collectionType Type of collection used in provided institute. The Filters have different algorithm for each type.
     * @return Collection with collectionType inside it after filtering.
     */
    Collection<IStudent> get(IInstitute institute, FilterSettings settings, CollectionType collectionType);
}
