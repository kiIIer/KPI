import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {CalculateRequestModel} from "../../models/calculateRequest.model";
import {group} from "@angular/animations";
import {Parameter} from "@angular/compiler-cli/src/ngtsc/reflection";
import {ParameterModel} from "../../models/parameter.model";
import {ErrorModel} from "../../models/Error.model";
import {DimensionModel} from "../../models/dimension.model";
import {NestedTreeControl} from "@angular/cdk/tree";
import {MatTreeNestedDataSource} from "@angular/material/tree";

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit
{
  @Output() loadResultEvent: EventEmitter<CalculateRequestModel> = new EventEmitter<CalculateRequestModel>();
  @Output() addParameterEvent: EventEmitter<string> = new EventEmitter<string>();
  @Output() deleteParameterEvent: EventEmitter<string> = new EventEmitter<string>();

  @Input() paramGroups: Map<string, FormGroup> | null = new Map<string, FormGroup>();
  @Input() errors: ErrorModel | undefined | null;
  @Input() result: DimensionModel | null | undefined;

  polishFormGroup: FormGroup = new FormGroup({polish: new FormControl('', [Validators.required])});
  addParameterFormGroup: FormGroup = new FormGroup({param: new FormControl('', [Validators.required])});


  constructor(
    private groupBuilder: FormBuilder
  )
  {
  }

  ngOnInit(): void
  {
  }

  addParameter()
  {
    if (!this.addParameterFormGroup.valid)
    {
      return;
    }

    let {param} = this.addParameterFormGroup.value;
    this.addParameterEvent.emit(param);
  }

  deleteParameter(id: string)
  {
    this.deleteParameterEvent.emit(id);
  }

  calculate()
  {
    if (!this.polishFormGroup.valid)
    {
      return;
    }

    this.paramGroups?.forEach((group: FormGroup) =>
    {
      if (!group.valid)
      {
        return;
      }
    })

    let calculateRequest: CalculateRequestModel = {
      parameters: [],
      polish: ""
    };

    calculateRequest.polish = this.polishFormGroup.value.polish;

    this.paramGroups?.forEach((group: FormGroup) =>
    {
      let parameter: ParameterModel;
      parameter = group.value;
      calculateRequest.parameters = [...calculateRequest.parameters, parameter];
    });

    this.loadResultEvent.emit(calculateRequest);
  }
}
