package io.promova.killer.mathmaid.rep;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface IResultRepository extends JpaRepository<FormulaEntity, Long>
{
}
