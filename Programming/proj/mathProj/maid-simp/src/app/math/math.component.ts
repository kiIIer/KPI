import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {SimperService} from "../simper.service";
import {Observable} from "rxjs";
import {Formula} from "../Entities/response/Formula";
import {ParamEntity} from "../Entities/requests/ParamEntity";
import {Result} from "../Entities/response/Result";

@Component({
  selector: 'app-math',
  templateUrl: './math.component.html',
  styleUrls: ['./math.component.css']
})
export class MathComponent implements OnInit
{
  formulas: Observable<Formula[]> | undefined;

  requestForm: FormGroup = new FormGroup({});

  requestParameters: string[] | undefined;
  chosenFormula: Formula | undefined;

  result: Observable<Result> | undefined;


  constructor(
    private formBuilder: FormBuilder,
    private formulaService: SimperService
  )
  {
  }

  ngOnInit(): void
  {
    this.formulas = this.formulaService.getFormulas();
  }

  showParameters(formula: Formula)
  {
    let config = {};

    for (const parameter of formula.parameters)
    {
      config = {...config, [parameter]: [null, Validators.required]};
    }

    this.chosenFormula = formula;
    this.requestForm = this.formBuilder.group(config);
    this.requestParameters = formula.parameters;
  }

  submit()
  {
    if (!this.requestForm.valid)
    {
      return;
    }

    const paramEntities: ParamEntity[] = this.requestParameters!.map(p => ({
      name: p,
      value: parseFloat(this.requestForm.value[p])
    }));

    this.result = this.formulaService.postRequest({params: paramEntities}, this.chosenFormula!.id);

  }

}
