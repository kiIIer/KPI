package Root;

import ArActions.*;
import CSV.IMatrixReader;
import CSV.MatrixReader;
import Definer.GraphDefiner;
import Definer.IGraphDefiner;
import Tree.Calculator.BranchCalculator;
import Tree.Calculator.IBranchCalculator;
import Tree.Tablers.IPostTable;
import Tree.Tablers.IPreTable;
import Tree.Tablers.PostTable;
import Tree.Tablers.PreTable;
import Tree.ToStringers.IPostfixToString;
import Tree.ToStringers.IPrefixToString;
import Tree.ToStringers.PostfixToString;
import Tree.ToStringers.PrefixToString;
import Validators.GraphValidator;
import Validators.IGraphValidator;
import Yaml.IYamlReader;
import Yaml.YamlReader;
import com.google.inject.AbstractModule;

public class ToolsModule extends AbstractModule
{
    @Override
    public void configure()
    {
        bind(IGraphValidator.class).to(GraphValidator.class);
        bind(IYamlReader.class).to(YamlReader.class);
        bind(IPrefixToString.class).to(PrefixToString.class);
        bind(IPostfixToString.class).to(PostfixToString.class);
        bind(IPreTable.class).to(PreTable.class);
        bind(IPostTable.class).to(PostTable.class);
        bind(IMatrixReader.class).to(MatrixReader.class);
        bind(IGraphDefiner.class).to(GraphDefiner.class);

        bind(IBranchCalculator.class).to(BranchCalculator.class);
        bind(IAddition.class).to(Addition.class);
        bind(ISubtraction.class).to(Subtraction.class);
        bind(IMultiplication.class).to(Multiplication.class);
        bind(IDivision.class).to(Division.class);
        bind(IExponentiation.class).to(Exponentiation.class);

    }
}
