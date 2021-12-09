package Main;

/**
 * Start of logic. Program is injected in root of project.
 */
public interface IProgram
{
    /**
     * Pseudo main of the app. You can consider this as a normal main of the app, but with resolved dependencies using injector,
     * giving the opportunity to use all dependencies without hell(creating them manually). Builds and runs CLI passing args to it.
     *
     * @param args Command line arguments which will be then given to command line.
     * @throws Exception Just in case something goes wring. It will be thrown only if app doesn't work properly.
     */
    void execute(String[] args) throws Exception;
}
