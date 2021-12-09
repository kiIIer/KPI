package Main.StudentFilter;

import Main.Tools.FilterSettings;
import MyClasses.Abstract.IInstitute;
import MyClasses.Abstract.IStudent;

import java.util.Collection;

/**
 * Launches filter.
 */
public interface IFilterLauncher
{
    /**
     * Launches its filter, translating provided settings into parameters filter can understand, creates and provides filter with student iterator.
     *
     * @param institute Institute with students to be filtered.
     * @param settings  Abstract filter settings which will be translated into more specific ones.
     * @return Collection of students after filtration.
     */
    public Collection<IStudent> launch(IInstitute institute, FilterSettings settings);
}
