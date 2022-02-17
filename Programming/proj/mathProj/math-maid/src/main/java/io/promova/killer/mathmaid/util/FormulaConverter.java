package io.promova.killer.mathmaid.util;

import io.promova.killer.mathmaid.rep.FormulaEntity;
import io.promova.killer.mathmaid.result.responce.FormulaDTO;

public class FormulaConverter implements IFormulaConverter
{
    @Override
    public FormulaDTO convert(FormulaEntity entity)
    {
        return new FormulaDTO(entity.getId(), entity.getParams().split(" "));
    }
}
