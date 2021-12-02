package Checkers;

import Preparators.IZhegalkinPolynomial;
import Tools.Symbols;
import com.google.inject.Inject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Linient implements ILinient
{
    private final IZhegalkinPolynomial zhegalkinPolynomial;

    @Inject
    public Linient(
            IZhegalkinPolynomial zhegalkinPolynomial
    )
    {
        this.zhegalkinPolynomial = zhegalkinPolynomial;
    }

    @Override
    public boolean check(String tuple)
    {
        Pattern pattern = Pattern.compile(String.valueOf(Symbols.CONJUNCTION));
        Matcher matcher = pattern.matcher(zhegalkinPolynomial.translate(tuple));

        return matcher.results().findAny().isEmpty();
    }
}
