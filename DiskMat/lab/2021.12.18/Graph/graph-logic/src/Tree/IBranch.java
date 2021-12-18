package Tree;

public interface IBranch
{
    Object getContent();

    Action getAction();

    Double getNumber();

    IBranch getLeftBranch();

    IBranch getRightBranch();

    void print(StringBuilder buffer, String prefix, String childrenPrefix);
}
