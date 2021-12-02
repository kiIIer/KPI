package Main;

import Checkers.*;
import Commands.*;
import Preparators.*;
import Tools.IValidator;
import Tools.IWriter;
import Tools.Validator;
import Tools.Writer;
import com.google.inject.AbstractModule;

public class ProgramModule extends AbstractModule
{
    @Override
    public void configure()
    {
        bind(IDuality.class).to(Duality.class);
        bind(IDually.class).to(Dually.class);
        bind(ILinient.class).to(Linient.class);
        bind(IMonotonic.class).to(Monotonic.class);
        bind(ITOne.class).to(TOne.class);
        bind(ITZero.class).to(TZero.class);
        bind(ICCNF.class).to(CCNF.class);
        bind(ICDNF.class).to(CDNF.class);
        bind(IZhegalkinPolynomial.class).to(ZhegalkinPolynomial.class);
        bind(IWriter.class).to(Writer.class);
        bind(ITruthTable.class).to(TruthTable.class);
        bind(IProgram.class).to(Program.class);
        bind(ICLIBuilder.class).to(CLIBuilder.class);
        bind(IValidator.class).to(Validator.class);
        bind(IAppCommand.class).to(AppCommand.class);
        bind(IDualityCommand.class).to(DualityCommand.class);
        bind(ITruthTableCommand.class).to(TruthTableCommand.class);
        bind(IZhegalkinPolynomialCommand.class).to(ZhegalkinPolynomialCommand.class);
        bind(ICCNFCommand.class).to(CCNFCommand.class);
        bind(ICDNFCommand.class).to(CDNFCommand.class);
        bind(ICheckCommand.class).to(CheckCommand.class);
    }
}
