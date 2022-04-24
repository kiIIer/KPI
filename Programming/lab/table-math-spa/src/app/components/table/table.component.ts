import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {ControlsConfigModel} from "../../models/controlsConfig.model";
import {Dictionary} from "@ngrx/entity";

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit
{
  @Output() loadResultEvent: EventEmitter<any> = new EventEmitter<any>();
  @Output() addParameterEvent: EventEmitter<string> = new EventEmitter<string>();

  @Input() paramGroups: Map<string, FormGroup> | null = new Map<string, FormGroup>();

  polishFormGroup: FormGroup | undefined = new FormGroup({polish: new FormControl('', [Validators.required])});

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

}
