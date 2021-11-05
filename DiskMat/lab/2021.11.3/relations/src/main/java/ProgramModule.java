import Commands.*;
import Tools.*;
import Tools.Checks.*;
import com.google.inject.AbstractModule;

import java.sql.Ref;

public class ProgramModule extends AbstractModule
{
    @Override
    public void configure()
    {
        bind(IProgram.class).to(Program.class);
        bind(ICLIBuilder.class).to(CLIBuilder.class);

        bind(IAppCommand.class).to(AppCommand.class);
        bind(ICheckCommand.class).to(CheckCommand.class);
        bind(ICompositionCommand.class).to(CompositionCommand.class);
        bind(IClosureCommand.class).to(ClosureCommand.class);

        bind(IValidator.class).to(Validator.class);
        bind(IMatrixReader.class).to(MatrixReader.class);
        bind(IMatrixWriter.class).to(MatrixWriter.class);
        bind(IMatrixUnioner.class).to(MatrixUnioner.class);
        bind(IRelationComposer.class).to(RelationComposer.class);
        bind(IMatrixBuilder.class).to(MatrixBuilder.class);

        bind(IReflexiveClosurer.class).to(ReflexiveClosurer.class);
        bind(ISymmetricClosurer.class).to(SymmetricClosurer.class);
        bind(ITransitiveClosurer.class).to(TransitiveClosurer.class);

        bind(IReflexivePropertyChecker.class).to(ReflexivePropertyChecker.class);
        bind(IIrreflexivePropertyChecker.class).to(IrreflexivePropertyChecker.class);
        bind(ISymmetricPropertyChecker.class).to(SymmetricPropertyChecker.class);
        bind(IAntiSymmetricPropertyChecker.class).to(AntiSymmetricPropertyChecker.class);
        bind(IAsymmetricPropertyChecker.class).to(AsymmetricPropertyChecker.class);
        bind(ITransitivePropertyChecker.class).to(TransitivePropertyChecker.class);
        bind(IAntiTransitivePropertyChecker.class).to(AntiTransitivePropertyChecker.class);
        bind(IEquivalencePropertyChecker.class).to(EquivalencePropertyChecker.class);
        bind(IPartialOrderPropertyChecker.class).to(PartialOrderPropertyChecker.class);
        bind(IStrictOrderPropertyChecker.class).to(StrictOrderPropertyChecker.class);

    }
}
