package Tree;

import Tools.StringToAction;

public class Branch implements IBranch
{
    public Object content;
    public IBranch leftBranch;
    public IBranch rightBranch;

    public Object getContent()
    {
        return content;
    }

    @Override
    public Action getAction()
    {
        if (!(content instanceof String))
        {
            return null;
        }
        return StringToAction.actions.get(content);
    }

    public void setAction(String action)
    {
        this.content = action;
    }

    @Override
    public Double getNumber()
    {
        if (!(content instanceof Double))
        {
            return null;
        }
        return (Double) content;
    }

    public void setNumber(Double number)
    {
        this.content = number;
    }

    @Override
    public IBranch getLeftBranch()
    {
        return leftBranch;
    }

    public void setLeftBranch(Branch leftBranch)
    {
        this.leftBranch = leftBranch;
    }

    @Override
    public IBranch getRightBranch()
    {
        return rightBranch;
    }

    public void setRightBranch(Branch rightBranch)
    {
        this.rightBranch = rightBranch;
    }

    public String toString()
    {
        StringBuilder buffer = new StringBuilder(50);
        print(buffer, "", "");
        return buffer.toString();
    }

    public void print(StringBuilder buffer, String prefix, String childrenPrefix)
    {
        buffer.append(prefix);
        buffer.append(content);
        buffer.append('\n');
        if (leftBranch != null)
        {
            this.leftBranch.print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
        }
        if (rightBranch != null)
        {
            this.rightBranch.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
        }
    }
}
