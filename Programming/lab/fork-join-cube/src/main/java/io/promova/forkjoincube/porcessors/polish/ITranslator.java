package io.promova.forkjoincube.porcessors.polish;

import io.promova.forkjoincube.porcessors.calculator.IFormula;

public interface ITranslator
{
    IFormula translate(String polish);
}
