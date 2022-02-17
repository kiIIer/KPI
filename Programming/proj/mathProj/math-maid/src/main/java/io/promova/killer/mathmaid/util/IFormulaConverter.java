package io.promova.killer.mathmaid.util;

import io.promova.killer.mathmaid.rep.FormulaEntity;
import io.promova.killer.mathmaid.result.responce.FormulaDTO;

public interface IFormulaConverter
{
    FormulaDTO convert(FormulaEntity entity);
}
